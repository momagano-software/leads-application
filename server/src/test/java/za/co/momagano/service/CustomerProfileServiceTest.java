package za.co.momagano.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import za.co.momagano.CustomerProfileTestHelper;
import za.co.momagano.model.CustomerProfile;
import za.co.momagano.repository.CustomerProfileRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class CustomerProfileServiceTest {
    @Autowired
    CustomerProfileService customerProfileService;
    @MockBean
    private CustomerProfileRepository customerProfileRepository;

    @Test
    void shouldCreateProfile(){
        customerProfileService.addProfile(CustomerProfileTestHelper.getFullCustomerProfile());

        verify(customerProfileRepository, times(1)).save(CustomerProfileTestHelper.getFullCustomerProfile());
    }

    @Test
    void shouldGetCustomerProfile(){
        final CustomerProfile customerProfile = CustomerProfileTestHelper.getFullCustomerProfile();
        final String email = customerProfile.getEmail();
        when(customerProfileRepository.findById(email)).thenReturn(Optional.of(customerProfile));

        customerProfileService.getProfile(email);
        verify(customerProfileRepository, times(1)).findById(email);
    }

    @Test
    void shouldReturnNullWhenProfileNotFound(){
        final CustomerProfile customerProfile = CustomerProfileTestHelper.getFullCustomerProfile();
        final String email = customerProfile.getEmail().concat("%3");
        when(customerProfileRepository.findById(email)).thenReturn(Optional.empty());

        CustomerProfile searchedCustomerProfile = customerProfileService.getProfile(email);
        Assertions.assertNull(searchedCustomerProfile);
        verify(customerProfileRepository, times(1)).findById(email);
    }
}