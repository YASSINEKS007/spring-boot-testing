package yk.projects.springboottesting.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "service.cors.properties")
@Getter
@Setter
public class AppCorsConfiguration {
    private String allowedHeaders;
    private String allowedMethods;
    private String allowedOrigins;
}
