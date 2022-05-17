package za.co.momagano.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.momagano.CustomerProfileTestHelper;
import za.co.momagano.model.CompanyProfile;
import za.co.momagano.model.Service;
import za.co.momagano.service.ServiceRegistrationService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ServiceRegistration.class)
@AutoConfigureMockMvc
public class ServiceRegistrationControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ServiceRegistrationService serviceRegistrationService;

    @Test
    void shouldAddAServiceToAProfile() throws Exception {

        mockMvc.perform(post("/profile/{profileId}/service","1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new ObjectMapper().writeValueAsString(new Service("Service Name"))))
                .andExpect(status().isCreated());

        verify(serviceRegistrationService,times(1)).addService(any(Service.class));
    }
}
