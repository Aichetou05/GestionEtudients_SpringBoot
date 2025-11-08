package supnum_api.supnum.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Local development server");

        Server productionServer = new Server();
        productionServer.setUrl("https://api.supnum.mr");
        productionServer.setDescription("Production server");

        return new OpenAPI()
                .servers(List.of(localServer, productionServer))
                .info(new Info()
                        .title("Supnum Student Management API")
                        .version("1.0.0")
                        .description("A RESTful web service for managing student information. " +
                                "This API provides complete CRUD operations for student records. " +
                                "You can use this API to create, read, update, and delete student information.")
                        .contact(new Contact()
                                .name("Supnum API Support")
                                .email("support@supnum.mr")
                                .url("https://supnum.mr"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                        .termsOfService("https://supnum.mr/terms"));
    }
}

