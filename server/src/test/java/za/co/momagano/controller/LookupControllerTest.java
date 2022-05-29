package za.co.momagano.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.momagano.model.Category;
import za.co.momagano.model.KeyValue;
import za.co.momagano.model.LookupObject;
import za.co.momagano.model.SubCategory;
import za.co.momagano.service.LookupService;

import java.util.ArrayList;
import java.util.List;

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

        final LookupObject lookupObject = getLookupObject();

        when(lookupService.getLookupObject()).thenReturn(lookupObject);

        mockMvc.perform(get("/lookup")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.categoryList").isArray())
                .andExpect(jsonPath("$.categoryList[:1].name").value("Beauty"))
                .andExpect(status().isOk());
        verify(lookupService,times(1)).getLookupObject();
    }

    private LookupObject getLookupObject() {
        LookupObject lookupObject = new LookupObject();
        List<Category> categoryList = new ArrayList<>();
        List<SubCategory> subCategoryList = new ArrayList<>();
        List<KeyValue> serviceList = new ArrayList<>();
        serviceList.add(new KeyValue("Installation", "Installation"));
        SubCategory subCategory = new SubCategory("Hairdressing", "Hairdressing", serviceList);
        subCategoryList.add(subCategory);
        Category category = new Category("Beauty", "Beauty", subCategoryList);
        categoryList.add(category);
        lookupObject.setCategoryList(categoryList);
        return lookupObject;
    }
}
