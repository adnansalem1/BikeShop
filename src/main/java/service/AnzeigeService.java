package service;

import BikeShop.Anzeige;
import repository.AnzeigeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnzeigeService {

    private AnzeigeRepository anzeigeRepository;

    public Anzeige save(Anzeige anzeige) {
        return anzeigeRepository.save(anzeige);
    }

    public Anzeige get(Long id) {
        return anzeigeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Anzeige not found"));
    }

    public List<Anzeige> findAll() {
        return (List<Anzeige>) anzeigeRepository.findAll();
    }

    public Anzeige update(Long id, Anzeige anzeige) {
        Anzeige existingAnzeige = get(id);
        existingAnzeige.setName(anzeige.getName());
        existingAnzeige.setBeschreibung(anzeige.getBeschreibung());
        existingAnzeige.setPreis(anzeige.getPreis());
        return anzeigeRepository.save(existingAnzeige);
    }

    public void delete(Long id) {
        anzeigeRepository.deleteById(id);
    }
}
