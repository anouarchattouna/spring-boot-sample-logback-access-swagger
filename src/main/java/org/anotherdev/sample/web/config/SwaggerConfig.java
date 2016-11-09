package org.anotherdev.sample.web.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is a sample configuration for enabling api documentation generation with swagger.</br>
 * 
 * @see <a href="http://springfox.github.io/springfox/docs/current/#dependencies">Springfox-swagger2 with Spring MVC and
 * Spring Boot</a>
 * 
 * @author Anouar
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Value("${application.version:}")
  private String applicationVersion;

  // @formatter:off
    @Bean
    public Docket sampleApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName("employees-api")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api.*"))
                .build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Sample REST API")
                .description("This is a sample REST API")
                .version(applicationVersion)
                .build();
    }

    // @formatter:on
}