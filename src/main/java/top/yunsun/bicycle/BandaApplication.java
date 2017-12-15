package top.yunsun.bicycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class BandaApplication extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(BandaApplication.class);


    public static void main(String[] args) {
        logger.info("程序启动---");
        SpringApplication.run(BandaApplication.class, args);
    }
}
