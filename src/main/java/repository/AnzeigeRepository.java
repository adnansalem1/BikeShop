package repository;

import BikeShop.Anzeige;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnzeigeRepository extends CrudRepository<Anzeige, Long> {
}