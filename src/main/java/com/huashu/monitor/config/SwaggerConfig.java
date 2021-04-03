package com.huashu.monitor.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 前后端接口文档Swagger配置类
 * 默认访问路径： http://localhost:8080/huashu/swagger-ui.html
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    // 是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
    @Value(value = "${swagger.enabled}")
    Boolean swaggerEnabled;

    @Bean
    public Docket createBackEndApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
//                .groupName("接口管理")
                // 是否开启
                .enable(swaggerEnabled).select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.huashu.monitor"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build()
                .pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("华数智能监控项目API文档")
                .description("杭州电子科技大学")
                // 作者信息
                .contact(new Contact("author", "https://www.baidu.com", "xxxx@163.com"))
                .version("1.0.0")
                .build();
    }
}
