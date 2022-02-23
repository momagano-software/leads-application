package za.co.momagano.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
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
        CompanyProfile profile = new CompanyProfile("1990/05/904329","A company");


        when(companyProfileService.addProfile(any(CompanyProfile.class))).thenReturn(profile);
        mockMvc.perform(post("/profile")
                .contentType(MediaType.APPLICATION_JSON)
                .content(getObjectMapper().writeValueAsString(profile)))
                .andExpect(status().isCreated());
        verify(companyProfileService,times(1)).addProfile(any(CompanyProfile.class));

    }

    private ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
