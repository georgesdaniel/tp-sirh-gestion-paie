package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import config.ServicesConfig;
import dev.paie.spring.DataSourceMySQLConfig;

@Configuration
@EnableWebMvc
@Import({JpaConfig.class,ServicesConfig.class,DataSourceMySQLConfig.class})
@ImportResource({"classpath:cotisations-imposables.xml","classpath:jdd-config.xml","classpath:cotisations-non-imposables.xml","classpath:grades.xml","classpath:profils-remuneration.xml","classpath:entreprises.xml"})
@ComponentScan("dev.paie.web.controller")
public class WebAppConfig {

	@Bean
	public ViewResolver viewResolver() {

		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");

	}
}
