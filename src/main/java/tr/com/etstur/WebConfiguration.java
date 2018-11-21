<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-context</artifactId>
  <version>4.2.2.RELEASE</version>
  </dependency>package tr.com.etstur;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.WebJarsResourceResolver;
import tr.com.etstur.common.OperatorConverter;

import java.util.concurrent.TimeUnit;


@Configuration
@ComponentScan(basePackages = "tr.com.etstur")
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {


    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfiguration.class);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/**")
                .addResourceLocations("/");

        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");

        registry.addResourceHandler("index.html")
                .addResourceLocations("/index.html");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/")
                .setCacheControl(
                        CacheControl.maxAge(30L, TimeUnit.DAYS)
                                .cachePublic())
                .resourceChain(true)
                .addResolver(new WebJarsResourceResolver());

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/index.html");
    }

    @Autowired
    public void setViews(FormattingConversionService formattingConversionService) {
        formattingConversionService.addConverter(new OperatorConverter());
    }


}
