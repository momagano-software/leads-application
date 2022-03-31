package za.co.momagano.service;

import org.springframework.stereotype.Service;
import za.co.momagano.model.CustomerProfile;
import za.co.momagano.repository.CustomerProfileRepository;

@Service
public class CustomerProfileService {

    private final CustomerProfileRepository customerProfileRepository;

    public CustomerProfileService(CustomerProfileRepository customerProfileRepository) {
        this.customerProfileRepository = customerProfileRepository;
    }

    public void addProfile(CustomerProfile customerProfile) {
        this.customerProfileRepository.save(customerProfile);
    }

    public CustomerProfile getProfile(String email) {
        return this.customerProfileRepository.findById(email).orElse(null);
    }
}
