package ru.at0m1cc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
/**
 * Класс конфигурации который заменяет xml конфигурацию Spring
 * Аннотация @Configuration указывает на то что данный класс является конфигурацией
 * Аннотация @EnableWebMvc говорит о том, что необходимо использовать SpringMVC
 * Аннотация @ComponentScan("ru.at0m1cc.core") указывает на пакет где будут искаться и создаваться бины
 * Так же мы реализовываем интерфейс WebMvcConfigurer у которого переопределяем метод configureViewResolvers для использования шаблонизатора thymeleaf
 * */
@Configuration
@EnableWebMvc
@ComponentScan("ru.at0m1cc.core")
public class Config implements WebMvcConfigurer {
    /**
     * applicationContext
     * */
    private final ApplicationContext applicationContext;

    @Autowired
    public Config(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    /**
     *В данном методе мы создаём templateResolver, объект класса SpringResourceTemplateResolver и передаём в него объект класса ApplicationContext
     * После чего через методы setter мы указываем расположение наших шаблонов и их расширение
     * @return Возвращаем templateResolver
     * */
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }
    /**Реализовываем интерфейс WebMvcConfigurer у которого переопределяем метод configureViewResolvers для использования шаблонизатора thymeleaf*/
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        registry.viewResolver(viewResolver);
    }
    /**Метод для указания заголовков и местоположений ресурсов*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/");
    }

}
