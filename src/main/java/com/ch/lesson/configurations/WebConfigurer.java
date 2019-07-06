/**
 * @Description TODO
 * @Author zytshijack
 * @Date 2019-04-18 10:53
 * @Version 1.0
 */
package com.ch.lesson.configurations;

import com.ch.lesson.utils.interceptors.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description 自定义配置
 * @Author zytshijack
 * @Date 2019-04-18 10:53
 * @Version 1.0
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    //全局CORS配置（解决跨域问题），默认情况下，所有origins and GET, HEAD and POST methods是允许的。
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/templates");
//        registry.addResourceHandler("/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/static");
    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * addPathPatterns("/**") 表示拦截所有的请求，
         * excludePathPatterns() 排除一些静态依赖
         */
        //注解打开启动拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/passport/*","/user/create","/user/*");
    }
}