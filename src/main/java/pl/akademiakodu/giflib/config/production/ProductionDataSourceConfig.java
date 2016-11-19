package pl.akademiakodu.giflib.config.production;

/**
 * Created by Jaremina on 2016-11-19.
 */
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import pl.akademiakodu.giflib.config.dev.DevDataSourceConfig;

import javax.sql.DataSource;


@Configuration
@PropertySource("production.properties")
@Profile("production")
public class ProductionDataSourceConfig {

    @Autowired
    private Environment env;
    private Logger logger = LoggerFactory.getLogger(ProductionDataSourceConfig.class);

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
