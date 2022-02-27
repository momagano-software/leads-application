package za.co.momagano.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyProfileService {

    private CompanyProfileRepository companyProfileRepository;
    @Autowired
    public CompanyProfileService(CompanyProfileRepository companyProfileRepository) {
        this.companyProfileRepository = companyProfileRepository;
    }

    public CompanyProfile addProfile(CompanyProfile companyProfile) {
        return companyProfileRepository.save(companyProfile);
    }

    public CompanyProfile getProfile(String companyRegistration) {
        return companyProfileRepository.findById(companyRegistration).get();
    }
}
