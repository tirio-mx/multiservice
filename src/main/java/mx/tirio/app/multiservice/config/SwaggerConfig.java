package mx.tirio.app.multiservice.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ConditionalOnWebApplication
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("mx.tirio.app.multiservice.controller")).build()
                .apiInfo(metadata());
    }

    @SuppressWarnings("rawtypes")
    private static ApiInfo metadata() {
        Collection<StringVendorExtension> vendors = new ArrayList<>();
        Collection<VendorExtension> vendorsInterface = new ArrayList<>();
        StringVendorExtension sVendorExtension = new StringVendorExtension("TIRIO_MX", "Tirio MX");
        vendors.add(sVendorExtension);
        vendorsInterface.addAll(vendors);
        return new ApiInfo("MultiService", "Multi variant services", "1.0", "The URL",
                new Contact("tirio.mx", "http://tirio.mx", "gh.tirio.mx@gmail.com"),
                "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0", vendorsInterface);

    }
}
