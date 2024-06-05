package BikeShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"BikeShop", "controller", "service"})
public class BikeShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikeShopApplication.class, args);
	}

	@RestController
	public static class HelloController {
		@GetMapping("/hello")
		public String hello() {
			return "{\"message\": \"Hello, world!\"}";
		}
	}
}