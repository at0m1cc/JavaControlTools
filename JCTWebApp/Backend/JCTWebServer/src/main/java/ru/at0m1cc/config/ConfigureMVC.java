package ru.at0m1cc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Класс который наследуется от AbstractAnnotationConfigDispatcherServletInitializer для замены web.xml
 * */
public class ConfigureMVC extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
    /**
     * Класс который принемает в себе конфигурацию applicationContext
     * */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{Config.class};
    }
    /**
     * Маппинг по root URL
     * */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
