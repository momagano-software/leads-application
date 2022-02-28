package za.co.momagano.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CompanyProfileRepositoryTest {

    @Autowired
    private CompanyProfileRepository companyProfileRepository;

    @BeforeEach
    public void clearDb() {
        companyProfileRepository.deleteAll();
    }

    @Test
    public void companyProfileShouldBeSavedToRepository() {
        assertEquals(0, companyProfileRepository.count());
        CompanyProfile companyProfile = new CompanyProfile("1990/05/904329","A company");
        companyProfileRepository.save(companyProfile);

        assertEquals(1, companyProfileRepository.count());

    }
}
