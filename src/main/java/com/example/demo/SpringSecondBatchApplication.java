package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.demo.servlet.MyServlet;

@SpringBootApplication
public class SpringSecondBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecondBatchApplication.class, args);
	}
	@Bean
	  ServletRegistrationBean myServletRegistration () {
	      ServletRegistrationBean srb = new ServletRegistrationBean();
	      srb.setServlet(new MyServlet());
	      srb.setUrlMappings(Arrays.asList("/path2/*"));
	      return srb;
	  }
}
