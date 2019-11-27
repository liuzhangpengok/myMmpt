package com.mingkai.mmpt.start;

import com.mingkai.mmpt.filter.CrosFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@ImportResource({"classpath:spring.xml"})
@ComponentScan(basePackages = {"com.mingkai"})
@EnableScheduling
public class MmptServiceMain {
    private static Logger logger = LoggerFactory.getLogger(MmptServiceMain.class);

    public static void main(String[] args) {

        logger.info(" TfcLsServiceMain 服务开始启动......");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> logger.warn("系统退出......")));

        SpringApplication.run(MmptServiceMain.class, args);
    }

    /**
     * 配置跨域访问的过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean registerFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.addUrlPatterns("/*");
        bean.setFilter(new CrosFilter());
        return bean;
    }

}

