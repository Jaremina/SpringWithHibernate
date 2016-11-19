package pl.akademiakodu.giflib.config.dev;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Created by Jaremina on 2016-11-19.
 */
@Configuration
@PropertySource("dev.properties")
@Profile("dev")
public class DevDataSourceConfig {

    @Autowired
    private Environment env;
    private Logger logger = LoggerFactory.getLogger(DevDataSourceConfig.class);

    @Bean
    public DataSource dataSource(){
        logger.info(env.getProperty("giflib.db.log"));
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(env.getProperty("giflib.db.driver"));
        basicDataSource.setUsername(env.getProperty("giflib.db.username"));
        basicDataSource.setPassword(env.getProperty("giflib.db.password"));
        basicDataSource.setUrl(env.getProperty("giflib.db.url"));
        return basicDataSource;
    }

}
