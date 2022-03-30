package za.co.momagano.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.momagano.controller.CustomerProfileController;
import za.co.momagano.model.CompanyProfile;
import za.co.momagano.model.CustomerProfile;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CustomerProfileController.class)
@AutoConfigureMockMvc
public class CustomerProfileControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private CustomerProfileService customerProfileService;

    @Test
    public void shouldRegisterANewUserProfile() throws Exception {
        mockMvc.perform(post("/customer/profile")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(getObjectMapper().writeValueAsString(CustomerProfileTestHelper.getFullCustomerProfile())))
                .andExpect(status().isCreated());
        verify(customerProfileService,times(1)).addProfile(any(CustomerProfile.class));
    }


    @Test
    public  void  shouldReturnCompanyProfile() throws Exception {
        CustomerProfile profile = CustomerProfileTestHelper.getFullCustomerProfile();

        when(customerProfileService.getProfile(profile.getEmail())).thenReturn(profile);
        mockMvc.perform(get("/customer/profile")
                .queryParam("customerEmail","spidey@gmail.com")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.email").value(profile.getEmail()))
                .andExpect(jsonPath("$.name").value(profile.getName()))
                .andExpect(status().isOk());

        verify(customerProfileService,times(1)).getProfile(profile.getEmail());
    }
    private ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
