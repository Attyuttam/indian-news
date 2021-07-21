package com.attyuttam.newsappui;

import com.attyuttam.newsappui.application.NewsProcessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(NewsProcessor.class)
public class NewsAppUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsAppUiApplication.class, args);
	}

}
