package clud.qc.bicycle;

import clud.qc.bicycle.common.util.ExcelUtil;
import clud.qc.bicycle.dto.sys.SysRegionDTO;
import clud.qc.bicycle.entity.sys.SysRegionDO;
import clud.qc.bicycle.service.sys.SysRegionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.soap.Addressing;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

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
        String fileStr = "E:/file/2016年最新行政区划数据库-旗舰版.xls";
        FileInputStream fileInputStream = new FileInputStream(new File(fileStr));
        SysRegionDTO sysRegion = new SysRegionDTO();
        List<Object> list = new ExcelUtil().importDataFromExcel(sysRegion, fileInputStream, "2016年最新行政区划数据库.xls");
        List<SysRegionDO> sysRegionDOList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            SysRegionDTO dto = (SysRegionDTO) list.get(i);
            SysRegionDO sysRegionDO = new SysRegionDO();
            convert(sysRegionDO, dto);
            sysRegionDOList.add(sysRegionDO);
        }
        sysRegionService.batchSave(sysRegionDOList);
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
