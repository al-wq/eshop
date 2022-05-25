package com.demo.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Swagger配置类
 * @description 配置Swagger信息
 * @data 2022-05-12
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    //配置Swagger信息
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("", "", "");
        //页面信息
        return new ApiInfo (
                "Swagger Demo",
                "Api Documentation",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }
//    @Bean
//    public Docket docket(Environment environment){
//        //设置要显示的环境
//        Profiles profiles = Profiles.of ( "dev" );
//        //通过environment.acceptsProfiles判断是否处于自己设定的环境中
//        boolean b = environment.acceptsProfiles ( profiles );
//        return new Docket ( DocumentationType.SWAGGER_2 )
//                .apiInfo ( apiInfo () )
//                .enable ( b )
//                .select ()
//                //RequestHandlerSelectors配置扫描接口的方式
//                //basePackage()：指定要扫描包
//                //any()；扫描全部
//                //none():全部不扫描
//                //withMethodAnnotation(final Class<? extends Annotation> annotation)：扫描方法上的注解
//                //withClassAnnotation(final Class<? extends Annotation> annotation)：扫描类上的注解
//                .apis ( RequestHandlerSelectors.basePackage ( "com.demo.controller" ) )
//                //paths (  )：什么路径
//                .paths ( PathSelectors.ant ( "" ) )
//                .build ();
//    }
}
