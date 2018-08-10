package com.cubic.book;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;
@SpringBootApplication
@Slf4j
/**
 * 
 * @author Toshiba
 *
 */
@ComponentScan("com.cubic.book")
public class Application {
	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(Application.class, args);
		}
}
