package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dev.paie.config.JpaConfig;
import dev.paie.spring.DataSourceMySQLConfig;

@Configuration
@ComponentScan ({"dev.paie.service","dev.paie.util"})
@Import({JpaConfig.class, DataSourceMySQLConfig.class})
@EnableJpaRepositories("dev.paie.repository")	
public class ServicesConfig {
	}

