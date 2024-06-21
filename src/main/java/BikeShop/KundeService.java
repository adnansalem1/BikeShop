package BikeShop;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KundeService {

    @Autowired
    KundeRepository kundeRepository;

    @Transactional
    public Kunde save(Kunde kunde) {
        return kundeRepository.save(kunde);
    }

    public Kunde get(Long id) {
        return kundeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Kunde not found"));
    }

    public List<Kunde> findAll() {
        return (List<Kunde>) kundeRepository.findAll();
    }

    @Transactional
    public Kunde update(Long id, Kunde kunde) {
        Kunde existingKunde = get(id);
        existingKunde.setName(kunde.getName());
        existingKunde.setEmail(kunde.getEmail());
        existingKunde.setAdresse(kunde.getAdresse());
        existingKunde.setTelefonnummer(kunde.getTelefonnummer());
        existingKunde.setKontoGuthaben(kunde.getKontoGuthaben());
        return kundeRepository.save(existingKunde);
    }

    @Transactional
    public void delete(Long id) {
        kundeRepository.deleteById(id);
    }
}