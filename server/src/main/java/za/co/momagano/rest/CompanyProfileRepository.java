package za.co.momagano.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyProfileRepository extends CrudRepository<CompanyProfile, String> {
}
