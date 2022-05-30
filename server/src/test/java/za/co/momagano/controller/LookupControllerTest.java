package za.co.momagano.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.momagano.LookupTestHelper;
import za.co.momagano.model.LookupObject;
import za.co.momagano.service.LookupService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = LookupController.class)
@AutoConfigureMockMvc
public class LookupControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private LookupService lookupService;

    @Test
    public void shouldReturnLookups() throws Exception {

        final LookupObject lookupObject = LookupTestHelper.getLookupObject();

        when(lookupService.getLookupObject()).thenReturn(lookupObject);

        mockMvc.perform(get("/lookup")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.categoryList").isArray())
                .andExpect(jsonPath("$.categoryList[:1].name").value("Beauty"))
                .andExpect(status().isOk());
        verify(lookupService,times(1)).getLookupObject();
    }

    //todo: crud endpoints

}
