package BikeShop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @GetMapping("/Anzeigen")
    public List<Anzeige> Anzeigen() {
        Anzeige anzeige1 = new Anzeige("Test 1", "Test", 2.50);
        Anzeige anzeige2 = new Anzeige("Test 2 ", "Test", 2.50);
        Anzeige anzeige3 = new Anzeige("Test 3", "Test", 2.50);
        Anzeige anzeige4 = new Anzeige("Test 4", "Test", 2.50);
        return List.of(anzeige1, anzeige2, anzeige3, anzeige4);
    }
}
