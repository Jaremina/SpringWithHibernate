package pl.akademiakodu.giflib.config;

import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import javax.servlet.MultipartConfigElement;


@Configuration
@PropertySource("app.properties")
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    public Hashids hashids() {
        return new Hashids(env.getProperty("giflib.hash.salt"),8);
    }

    // zeby mies wlasne wiadomosci przy errorach
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){ // zminia limit rozmianu plikow
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("20MB");
        factory.setMaxRequestSize("20MB");
        return factory.createMultipartConfig();
    }

}
