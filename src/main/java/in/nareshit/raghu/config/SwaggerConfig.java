package in.nareshit.raghu.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("WAREHOUSE APPLICATION")
                .description("MetaCorp Logistcs Pvt Co.")
                .version("3.2GA")
                .contact(new Contact().name("Mr. RAGHU").email("javabyraghu@gmail.com").url("http://nareshit.in"))
                .license(new License().name("NIT LICENCE").url("http://nareshit.in")));
    }
}
