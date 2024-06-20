package BikeShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "https://bikeshopfrontend.onrender.com"})
@RequestMapping("/anzeigen")
public class AnzeigeController {

    @Autowired
    private AnzeigeService anzeigeService;

    public AnzeigeController() {
        System.out.println("AnzeigeController initialized");
    }

    @GetMapping
    public List<Anzeige> anzeigen() {
        return anzeigeService.findAll();
    }

    @PostMapping
    public Anzeige createAnzeige(@RequestBody Anzeige anzeige) {
        return anzeigeService.save(anzeige);
    }

    @GetMapping("/{id}")
    public Anzeige getAnzeige(@PathVariable Long id) {
        return anzeigeService.get(id);
    }

    @PutMapping("/{id}")
    public Anzeige updateAnzeige(@PathVariable Long id, @RequestBody Anzeige anzeige) {
        return anzeigeService.update(id, anzeige);
    }

    @DeleteMapping("/{id}")
    public void deleteAnzeige(@PathVariable Long id) {
        anzeigeService.delete(id);
    }
}