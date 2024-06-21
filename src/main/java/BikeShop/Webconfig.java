package BikeShop;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class Webconfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Erlaubt CORS-Anfragen für alle URLs vom angegebenen Origin
        registry.addMapping("/**") // Dies ermöglicht CORS für alle Pfade in Ihrer Anwendung
                .allowedOrigins("http://localhost:3000") // Erlaubt Zugriffe von Ihrem Frontend-Server
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Erlaubt spezifische HTTP-Methoden
                .allowedHeaders("*") // Erlaubt alle Headers
                .allowCredentials(true); // Erlaubt Credentials wie Cookies, Authorization-Header etc.
    }
}