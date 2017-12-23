package top.yunsun.bicycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableRedisHttpSession(redisNamespace = "SingleBanda",
        maxInactiveIntervalInSeconds = 3600)
public class BandaApplication extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(BandaApplication.class);

    /**
     * cookie的相关配置
     *
     * @return
     */
    @Bean
    public CookieHttpSessionStrategy cookieHttpSessionStrategy() {
        CookieHttpSessionStrategy strategy = new CookieHttpSessionStrategy();
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        cookieSerializer.setCookieName("SingleBanda");//cookies名称
        cookieSerializer.setCookieMaxAge(1800);//过期时间(秒)
        strategy.setCookieSerializer(cookieSerializer);
        return strategy;
    }

    public static void main(String[] args) {
        logger.info("程序启动---");
        SpringApplication.run(BandaApplication.class, args);
    }
}
