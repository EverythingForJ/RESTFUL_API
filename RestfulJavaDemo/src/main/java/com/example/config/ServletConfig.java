package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages= {"com.example"})
public class ServletConfig implements WebMvcConfigurer {
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// /WEB-INF/views/static/index.html.jsp
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		//bean.setPrefix("/WEB-INF/views/");
		bean.setPrefix("/static/");
		//bean.setSuffix(".jsp");
		bean.setSuffix(".html");
		registry.viewResolver(bean);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
}
