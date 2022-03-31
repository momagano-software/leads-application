package za.co.momagano.controller;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.momagano.model.CompanyProfile;
import za.co.momagano.service.CompanyProfileService;
import za.co.momagano.CompanyProfileTestHelper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CompanyProfileController.class)
@AutoConfigureMockMvc
public class CompanyProfileControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private CompanyProfileService companyProfileService;

    @Test
    public void shouldRegisterANewUserProfile() throws Exception {
        mockMvc.perform(post("/profile")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(getObjectMapper().writeValueAsString(CompanyProfileTestHelper.getFullCompanyProfile())))
                .andExpect(status().isCreated());
        verify(companyProfileService,times(1)).addProfile(any(CompanyProfile.class));

    }
    @Test
    public  void  shouldReturnCompanyProfile() throws Exception {
        CompanyProfile profile = new CompanyProfile("1990/05/904329","A company");

        when(companyProfileService.getProfile(profile.getCompanyRegistration())).thenReturn(profile);
        mockMvc.perform(get("/profile/")
                .queryParam("companyRegistration","1990/05/904329")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    private ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
