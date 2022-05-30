package za.co.momagano.repository;

import org.springframework.data.repository.CrudRepository;
import za.co.momagano.model.LookupObject;


public interface LookupRepository extends CrudRepository<LookupObject, Long> {
}
