package clud.qc.bicycle.common.config;

import clud.qc.bicycle.common.Interceptor.BandaInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
@ComponentScan("clud.qc.bicycle")
@EnableRedisHttpSession(redisNamespace = "SingleBanda", maxInactiveIntervalInSeconds = 1800)
public class BandaSpringMvcConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public BandaInterceptor bandaInterceptor() {
		return new BandaInterceptor();
	}
	
	/**
	 * 重写addInterceptors方法，注册拦截器
	 *
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		InterceptorRegistration ir = registry.addInterceptor(bandaInterceptor());
		//定义拦截的路径
		ir.addPathPatterns("/**");
		//排除拦截的路径
		//ir.excludePathPatterns("/index.html");
		super.addInterceptors(registry);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		super.addResourceHandlers(registry);
	}
	
	/**
	 * cookie的相关配置
	 *
	 * @return
	 */
	@Bean
	public CookieHttpSessionStrategy cookieHttpSessionStrategy() {
		CookieHttpSessionStrategy strategy = new CookieHttpSessionStrategy();
		DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
		//cookies名称
		cookieSerializer.setCookieName("SingleBanda");
		//过期时间(秒)
		cookieSerializer.setCookieMaxAge(1800);
		strategy.setCookieSerializer(cookieSerializer);
		return strategy;
	}
	
}
