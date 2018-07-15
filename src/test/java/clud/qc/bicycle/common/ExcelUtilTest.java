package clud.qc.bicycle.common;

import clud.qc.bicycle.common.util.ExcelUtil;
import clud.qc.bicycle.dto.sys.SysRegionDTO;
import clud.qc.bicycle.entity.sys.SysRegionDO;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * ExcelUtil Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>07/14/2018</pre>
 */
public class ExcelUtilTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: importDataFromExcel(Object vo, InputStream is, String excelFileName)
     */
    @Test
    public void testImportDataFromExcel() throws Exception {
        String fileStr = "E:/workspace/yzt_workspace/2016年最新行政区划数据库.xls";
        FileInputStream fileInputStream = new FileInputStream(new File(fileStr));
        SysRegionDTO sysRegion = new SysRegionDTO();
        List<Object> list = new ExcelUtil().importDataFromExcel(sysRegion, fileInputStream, "2016年最新行政区划数据库.xls");
        System.out.println(list.toString());
    }

    /**
     * Method: exportDataToExcel(List<T> list, String[] headers, String title, OutputStream os)
     */
    @Test
    public void testExportDataToExcel() throws Exception {
        //TODO: Test goes here...
    }

}
