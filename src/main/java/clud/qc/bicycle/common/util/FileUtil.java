package clud.qc.bicycle.common.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUtil {
	
	public static String upload(MultipartFile file, String filePath) throws Exception {
		if (file.isEmpty()) {
			throw new Exception("文件为空");
		}
		// 获取文件名
		String fileName = file.getOriginalFilename();
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		//上传文件重命名
		fileName = UUID.randomUUID() + suffixName;
		//上传文件路径
		File dest = new File(filePath + fileName);
		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			return filePath + fileName;
		} catch (IllegalStateException e) {
			throw new Exception(e);
		} catch (IOException e) {
			throw new Exception(e);
		}
	}


	
}
