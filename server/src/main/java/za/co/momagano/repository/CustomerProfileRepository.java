package za.co.momagano.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.momagano.model.CustomerProfile;

@Repository
public interface CustomerProfileRepository extends CrudRepository<CustomerProfile, String> {
}
