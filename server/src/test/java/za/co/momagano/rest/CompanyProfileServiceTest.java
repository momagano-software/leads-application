package za.co.momagano.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
}
