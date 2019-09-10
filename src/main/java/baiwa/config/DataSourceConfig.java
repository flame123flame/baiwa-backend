package baiwa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {
	
	 @Autowired
	 private Environment env;
     
	@Primary
	@Bean
	public DataSource customDataSource() {

		//System.out.println("spring.datasource.driverClassName:"+env.getProperty("spring.datasource.driverClassName"));
		//System.out.println("xxxxxxxxxxxxx:"+env.getProperty("xxxxxxxxxxxxx"));
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
	    dataSource.setUrl(env.getProperty("spring.datasource.url"));
	    dataSource.setUsername(env.getProperty("spring.datasource.username"));
	    dataSource.setPassword(env.getProperty("spring.datasource.password"));

	    return dataSource;

	}
}
