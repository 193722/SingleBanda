package clud.qc.bicycle.common.config;

import clud.qc.bicycle.common.Interceptor.BandaInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class BandaSpringMvcConfig extends WebMvcConfigurationSupport {

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


}
