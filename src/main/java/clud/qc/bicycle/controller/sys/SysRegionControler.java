package clud.qc.bicycle.controller.sys;

import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import clud.qc.bicycle.controller.BaseController;
import clud.qc.bicycle.controller.result.BaseResult;

import java.io.File;

@RestController
public class SysRegionControler extends BaseController {
	
	@RequestMapping("excel/import")
	@ResponseBody
	public BaseResult importExcel(@RequestParam(value = "fileName", required = false) MultipartFile file) {
		BaseResult result = new BaseResult();
		System.out.println("文件名：" + file.getOriginalFilename());
		try {
			//获取跟目录
			File path = new File(ResourceUtils.getURL("classpath:").getPath());
			if (!path.exists()) {
				path = new File("");
			}
			//调用文件上传的方法
			System.out.println("path:" + path.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
