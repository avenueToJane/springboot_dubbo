package com.springboot;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;
/**
* <p>Title: ProviderApplication </p>
* <p>Description: </p>
* <p>Company: xxx</p> 
* @author Mr.yang
* @date 2018年9月19日 下午5:52:06
* 通过@ImportResource实现xml配置的装载
* 通过使用@MapperScan可以指定要扫描的Mapper类的包的路径
* @SpringBootApplication启动类注解
 */
@SpringBootApplication
@ImportResource({ "classpath:config/spring-dubbo.xml" })
/**
 *  通过使用@MapperScan可以指定要扫描的Mapper类的包的路径
   @MapperScan注解和mybatis.mapper-locations 两者缺一不可
 */
@MapperScan("com.springboot.dao") 
public class ProviderApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
