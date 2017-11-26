package top.yunsun.bicycle.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import top.yunsun.bicycle.common.Interceptor.BandaInterceptor;

@Configuration
@EnableWebMvc   //开启Spring MVC支持，若无此句，重写WebMvcConfigurerAdapter方法无效
@ComponentScan("top.yunsun.bicycle")
//继承WebMvcConfigurerAdapter类，重写其方法可对Spring MVC进行配置
public class BandaSpringMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置拦截器的Bean
     *
     * @return
     */
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
        //super.addInterceptors(registry);
        registry.addInterceptor(bandaInterceptor());
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setPrefix("classpath:/templates/");
        //viewResolver.setSuffix(".html");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //super.addResourceHandlers(registry);
        //addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    /**
     * 统一处理没啥业务逻辑处理的controller请求，实现代码的简洁
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/index").setViewName("/index");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
