package top.yunsun.bicycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BandaApplication {

    private static final Logger logger = LoggerFactory.getLogger(BandaApplication.class);

    public static void main(String[] args) {
        logger.info("程序启动---");
        SpringApplication.run(BandaApplication.class, args);
        logger.info("项目管理后台访问路径：http://localhost:8000/singleBanda/index.html");
    }
}
