package com.mingkai.mmpt.configuration;

/**
 * @Author [mingkai]
 * @create 2019/11/25 20:48
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 资源映射路径
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    @Value("${path.patterns}")
    private String pathPatterns;

    @Value("${resource.location}")
    private String resourceLocation;


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(pathPatterns).addResourceLocations(resourceLocation);
    }
}

