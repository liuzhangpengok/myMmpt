package com.mingkai.mmpt.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


/**
 * 服务启动成功后初始化某些数据
 * 提供上下文对象
 *
 * @author hujun 2019.6.4
 */
@Component
public class ApplicationInit implements ApplicationRunner, ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {

    private static Logger logger = LoggerFactory.getLogger(ApplicationInit.class);

    private static ApplicationContext context;
    private static boolean inited = false;
    private static boolean refreshed = false;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        inited = true;
    }

    /**
     * 在这个方法执行完之后，才会暴露dubbo接口
     * 此方法在setApplicationContext之后执行
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        synchronized (ApplicationInit.class) {
            if (!refreshed) {

                logger.warn(">>>>>>------ init before dubbo going ------>>>>>>");
//                DubboFilter2Consumer.setSystemInfo("tfc", "core");

                logger.warn(">>>>>>------ init before dubbo success ------<<<<<<");
                refreshed = true;
            }
        }

    }

    public static <T> T getBean(Class<T> cls) {
        if (inited) {
            return context.getBean(cls);
        } else {
            throw new UnsupportedOperationException(" spring context not inited...");
        }
    }

    public static <T> T getBean(String name, Class<T> cls) {
        if (inited) {
            return context.getBean(name, cls);
        } else {
            throw new UnsupportedOperationException(" spring context not inited...");
        }
    }

    /**
     * 在这个方法执行之前， 已经暴露dubbo接口
     * 此方法执行顺序在onApplicationEvent之后
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            logger.warn(">>>>>>------ ApplicationInit going to start ------>>>>>>");
            //服务启动成功后需要做某些事


//			initKafkaConsumer();
            logger.warn(">>>>>>------ ApplicationInit success started ------<<<<<<");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
