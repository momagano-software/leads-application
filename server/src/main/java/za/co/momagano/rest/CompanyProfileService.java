package za.co.momagano.rest;

import org.springframework.stereotype.Service;

@Service
public class CompanyProfileService {
    private CompanyProfileRepository companyProfileRepository;

    public CompanyProfileService(CompanyProfileRepository companyProfileRepository) {
        this.companyProfileRepository = companyProfileRepository;
    }

    public CompanyProfile addProfile(CompanyProfile companyProfile) {
        return companyProfileRepository.save(companyProfile);
    }
}
