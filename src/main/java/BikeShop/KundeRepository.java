package BikeShop;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KundeRepository extends CrudRepository<Kunde, Long> {
}
