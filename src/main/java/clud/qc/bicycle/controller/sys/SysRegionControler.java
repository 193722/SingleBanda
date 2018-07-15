package clud.qc.bicycle.controller.sys;

import clud.qc.bicycle.controller.BaseController;
import clud.qc.bicycle.controller.result.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysRegionControler extends BaseController {

    @RequestMapping("excel/import")
    @ResponseBody
    public BaseResult importExcel(String filePath) {
        BaseResult result = new BaseResult();
        System.out.println("文件名：" + filePath);
        return result;
    }

}
