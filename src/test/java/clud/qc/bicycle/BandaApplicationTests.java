package clud.qc.bicycle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import clud.qc.bicycle.common.util.ExcelUtil;
import clud.qc.bicycle.dto.sys.SysRegionDTO;
import clud.qc.bicycle.entity.sys.SysRegionDO;
import clud.qc.bicycle.service.sys.SysRegionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BandaApplicationTests {
	
	@Autowired
	private SysRegionService sysRegionService;
	
	private static final Logger logger = LoggerFactory.getLogger(BandaApplicationTests.class);
	
	@Test
	public void contextLoads() {
		
	}
	
	/**
	 * Method: importDataFromExcel(Object vo, InputStream is, String excelFileName)
	 */
	@Test
	public void testImportDataFromExcel() throws Exception {
		String fileStr = "E:\\workspace\\yzt_workspace\\2016年最新行政区划数据库.xls";
		FileInputStream fileInputStream = new FileInputStream(new File(fileStr));
		SysRegionDTO sysRegion = new SysRegionDTO();
		List<Object> list = ExcelUtil.importDataFromExcel(sysRegion, fileInputStream, "2016年最新行政区划数据库.xls");
		List<SysRegionDO> sysRegionDOList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			SysRegionDTO dto = (SysRegionDTO) list.get(i);
			SysRegionDO sysRegionDO = new SysRegionDO();
			convert(sysRegionDO, dto);
			sysRegionDOList.add(sysRegionDO);
		}
		sysRegionService.batchSave(sysRegionDOList);
	}
	
	@Test
	public void testexportDataToExcel() {
		try {
			//定义导出的文件路径
			String filePath = "E:/workspace/yzt_workspace/export/region.xls";
			//得到文件对象
			File file = new File(filePath);
			//判断目录是否存在
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			//判断文件是否存在
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream outputStream = new FileOutputStream(file);
			//定义xls单册
			String sheetName = "region";
			//定义标题
			String[] heards = {	"区域编码", "父地域编码", "地域名称", "地域组合名称", "简称", "地域组合简称", "地域等级", "城市编码", "邮编", "拼音", "拼音",
								"简拼", "首字母", "经度", "纬度", "备注" };
			List<SysRegionDO> list = sysRegionService.queryAll();
			ExcelUtil.exportDataToExcel(list, heards, sheetName, outputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void convert(SysRegionDO regionDO, SysRegionDTO dto) {
		regionDO.setRegionId(dto.getID());
		regionDO.setParentId(dto.getParentId());
		regionDO.setName(dto.getName());
		regionDO.setMergerName(dto.getMergerName());
		regionDO.setShortName(dto.getShortName());
		regionDO.setMergerShortName(dto.getMergerShortName());
		regionDO.setLevelType(dto.getLevelType());
		regionDO.setCityCode(dto.getCityCode());
		regionDO.setZipCode(dto.getZipCode());
		regionDO.setPinyin(dto.getPinyin());
		regionDO.setJianpin(dto.getJianpin());
		regionDO.setFirstChar(dto.getFirstChar());
		regionDO.setLng(dto.getLng());
		regionDO.setLat(dto.getLat());
	}
}
