package com.bridgelabz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@SpringBootApplication
@Slf4j
public class EmployeePayrollAppApplication {

	public static void main(String[] args) {
		/*UC-2 Use Lombok Library for Logging*/

		System.out.println("Welcome To Employee Payroll Service Application");
		ApplicationContext context = SpringApplication.run(EmployeePayrollAppApplication.class,args);
		log.info("Employee Payroll App Started in {} Enivronment",
				context.getEnvironment().getProperty("environment"));
		log.info("Employee Payroll DB User is {}",
				context.getEnvironment().getProperty("spring.datasource.username"));
	}
//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.bridgelabz.employeepayrollapp"))
//				.build();
//	}
}