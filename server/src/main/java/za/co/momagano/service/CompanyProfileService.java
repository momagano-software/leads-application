package za.co.momagano.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.momagano.model.CompanyProfile;
import za.co.momagano.repository.CompanyProfileRepository;

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
