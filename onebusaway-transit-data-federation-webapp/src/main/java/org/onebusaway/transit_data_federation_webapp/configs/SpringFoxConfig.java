package org.onebusaway.transit_data_federation_webapp.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.onebusaway.transit_data_federation_webapp.controllers.gtfs_realtime"))
                .apis(RequestHandlerSelectors.basePackage("org.onebusaway.federations.webapp"))
                .apis(RequestHandlerSelectors.basePackage("org.onebusaway.gtfs_realtime.archiver.controller"))
                .apis(RequestHandlerSelectors.basePackage("org.onebusaway.transit_data_federation_webapp.controllers"))
                .apis(RequestHandlerSelectors.basePackage("org.onebusaway.aws.monitoring.api"))
                .apis(RequestHandlerSelectors.basePackage("org.onebusaway.transit_data_federation_webapp.siri"))
                .paths(PathSelectors.any())
                .build();
    }
}
