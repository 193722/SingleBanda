package clud.qc.bicycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import clud.qc.bicycle.common.enums.ErrorCodeEnum;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class BandaApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(BandaApplication.class);
	
	public static void main(String[] args) {
		logger.info("程序启动---");
		// 错误码检查
		ErrorCodeEnum.selfCheck();
		SpringApplication.run(BandaApplication.class, args);
		logger.info("项目管理后台访问路径：http://localhost:8088/singleBanda/index.html");
	}
	
	/**
	 * 文件上传配置
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//单个文件最大  
		factory.setMaxFileSize("10240KB"); //KB,MB  
		/// 设置总上传数据总大小  
		factory.setMaxRequestSize("102400KB");
		return factory.createMultipartConfig();
	}
}
