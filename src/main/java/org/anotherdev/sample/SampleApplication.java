package org.anotherdev.sample;

import org.apache.catalina.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

import ch.qos.logback.access.tomcat.LogbackValve;

@SpringBootApplication
public class SampleApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(SampleApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(SampleApplication.class, args);
  }

  @Bean
  @ConditionalOnProperty(name = "embedded.tomcat.logback.access.config.path")
  public EmbeddedServletContainerCustomizer containerCustomizer(
    @Value("${embedded.tomcat.logback.access.config.path}") final String fileName) {
    if (StringUtils.isEmpty(fileName)) {
      LOGGER.error(" Could not read embedded.tomcat.logback.access.config.path property");
    }
    return new EmbeddedServletContainerCustomizer() {
      @Override
      public void customize(ConfigurableEmbeddedServletContainer container) {
        if (container instanceof TomcatEmbeddedServletContainerFactory) {
          ((TomcatEmbeddedServletContainerFactory) container)
            .addContextCustomizers(new TomcatContextCustomizer() {
              @Override
              public void customize(Context context) {
                LogbackValve logbackValve = new LogbackValve();
                logbackValve.setFilename(fileName);
                context.getPipeline().addValve(logbackValve);
              }
            });
        }
      }
    };
  }

}
