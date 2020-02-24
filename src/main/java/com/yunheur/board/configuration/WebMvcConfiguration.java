package com.yunheur.board.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yunheur.board.interceptor.LoggerInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{

	@Bean
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setDefaultEncoding("UTF-8"); // 파일의 인코딩
		commonsMultipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024); // 업로드되는 파일크기 제한 (5 * 1024 * 1024 (5mb))
		return commonsMultipartResolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new LoggerInterceptor());
	}
}
