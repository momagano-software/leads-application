package za.co.momagano.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import za.co.momagano.LookupTestHelper;
import za.co.momagano.model.Category;
import za.co.momagano.model.LookupObject;
import za.co.momagano.repository.LookupRepository;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = LookupService.class)
public class LookupServiceTest {
    @Autowired
    LookupService lookupService;
    @MockBean
    private LookupRepository lookupRepository;

    @Test
    void shouldAddCategoryLookup() {
        Category category = LookupTestHelper
                .getCategories(new ArrayList<>())
                .get(0);

        category.setName("NewName");

        LookupObject lookupObject = LookupTestHelper.getLookupObject();
        when(lookupRepository.findAll()).thenReturn(Arrays.asList(lookupObject));


        lookupService.updateCategory(category);

        verify(lookupRepository).findAll();
        verify(lookupRepository).save(any(LookupObject.class));
    }

    @Test
    void shouldReturnAllCategoryLookups() {
        LookupObject lookupObject = LookupTestHelper.getLookupObject();

        when(lookupRepository.findAll()).thenReturn(Arrays.asList(lookupObject));
        LookupObject retrievedObject = lookupService.getLookupObject();

        verify(lookupRepository).findAll();
        assertNotNull(retrievedObject);
    }

    @Test
    void shouldDeleteCategoryLookup() {

        LookupObject lookupObject = LookupTestHelper.getLookupObject();
        when(lookupRepository.findAll()).thenReturn(Arrays.asList(lookupObject));


        lookupService.deleteCategory("Beauty");

        verify(lookupRepository).findAll();
        verify(lookupRepository).save(any(LookupObject.class));
    }
}
