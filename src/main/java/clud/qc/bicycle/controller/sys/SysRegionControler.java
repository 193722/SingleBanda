package clud.qc.bicycle.controller.sys;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import clud.qc.bicycle.controller.BaseController;
import clud.qc.bicycle.controller.result.BaseResult;

@RestController
public class SysRegionControler extends BaseController {
	
	@RequestMapping("excel/import")
	@ResponseBody
	public BaseResult importExcel(@RequestParam(value = "fileName", required = false) MultipartFile file) {
		BaseResult result = new BaseResult();
		System.out.println("文件名：" + file.getOriginalFilename());
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
