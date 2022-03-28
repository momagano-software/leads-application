package za.co.momagano.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import za.co.momagano.model.CompanyProfile;
import za.co.momagano.repository.CompanyProfileRepository;

import static java.util.Optional.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = CompanyProfileService.class)
public class CompanyProfileServiceTest {
    @Autowired
    CompanyProfileService companyProfileService;
    @MockBean
    private CompanyProfileRepository companyProfileRepository;

    @Test
    void shouldCreateProfile(){
        companyProfileService.addProfile(new CompanyProfile("1990/05/904329","A company"));

        verify(companyProfileRepository, times(1)).save(any(CompanyProfile.class));
    }
    @Test
    void shouldGetCompanyProfile(){
        String profileId = "1990/05/904329";
        when(companyProfileRepository.findById(profileId)).thenReturn(of(new CompanyProfile("1990/05/904329", "A company")));

        companyProfileService.getProfile(profileId);
        verify(companyProfileRepository, times(1)).findById(profileId);
    }
}
