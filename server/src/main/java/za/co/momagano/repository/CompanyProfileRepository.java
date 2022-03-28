package za.co.momagano.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.momagano.model.CompanyProfile;

@Repository
public interface CompanyProfileRepository extends CrudRepository<CompanyProfile, String> {
}
