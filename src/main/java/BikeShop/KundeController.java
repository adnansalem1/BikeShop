package BikeShop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "https://bikeshopfrontend.onrender.com"})
@RequestMapping("/kunden")
public class KundeController {

    @Autowired
    private KundeService kundeService;

    @GetMapping
    public List<Kunde> kunden() {
        return kundeService.findAll();
    }

    @PostMapping
    public Kunde createKunde(@RequestBody Kunde kunde) {
        return kundeService.save(kunde);
    }

    @GetMapping("/{id}")
    public Kunde getKunde(@PathVariable Long id) {
        return kundeService.get(id);
    }

    @PutMapping("/{id}")
    public Kunde updateKunde(@PathVariable Long id, @RequestBody Kunde kunde) {
        return kundeService.update(id, kunde);
    }

    @DeleteMapping("/{id}")
    public void deleteKunde(@PathVariable Long id) {
        kundeService.delete(id);
    }
}