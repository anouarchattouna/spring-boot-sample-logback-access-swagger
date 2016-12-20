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
 * 
 * @author Anouar
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Value("${application.version}")
  private String applicationVersion;

  private static final String API_DESCRIPTION = "Lorem ipsum dolor sit amet, et mi eu, ipsum taciti. Placerat commodo. Suscipit nibh urna, mauris erat sed, accumsan tincidunt sit. Lorem orci enim. Mi quis, nibh quam, eleifend elit.</p>"
    + "Sed morbi, vel commodo. Accumsan ligula, odio sollicitudin vel, non dolorem. Nullam sapien commodo, ipsum amet congue. Posuere vitae lacus, turpis eros. A felis.</p>"
    + "A volutpat, viverra nullam a. Per dignissim, velit suspendisse. Vulputate justo, lacinia neque. <strong>Magna class, est ac.</strong> Lobortis dapibus iaculis. Felis erat.</p>"
    + "Some useful link <a href=\"https://github.com/springfox/springfox\">Springfox</a>."
    + "<h3 id=\"security\">Security</h3>"
    + "oauth (OAuth 2.0)</p>"
    + "<ul><li>Example :<pre><code>Authorization: Bearer &lt;domain-token-value&gt;</code></pre></li></ul>";

  // @formatter:off
    @Bean
    public Docket sampleApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName("sample-api")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api.*"))
                .build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Sample REST API")
                .description(API_DESCRIPTION)
                .version(applicationVersion)
                .build();
    }

    // @formatter:on
}
