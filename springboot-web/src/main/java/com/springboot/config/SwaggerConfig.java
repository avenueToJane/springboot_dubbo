package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 通过@Configuration注解，表明它是一个配置类
 * @EnableSwagger2开启swagger2。
 * apiINfo()配置一些基本的信息。
 * apis()指定扫描的包会生成文档。
 * <p>
 * Title: SwaggerConfig
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: xxx
 * </p>
 * 
 * @author Mr.yang
 * @date 2018年9月25日 下午4:02:37
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.springboot.controller"))// 扫描的包
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("springboot利用swagger构建api文档").description("简单优雅的restfun风格")
				.termsOfServiceUrl("https://www.baidu.com").version("1.0.0").build();
	}

}
