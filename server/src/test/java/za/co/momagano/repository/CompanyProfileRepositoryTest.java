package za.co.momagano.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.co.momagano.CompanyProfileTestHelper;
import za.co.momagano.repository.CompanyProfileRepository;

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
        companyProfileRepository.save(CompanyProfileTestHelper.getFullCompanyProfile());

        assertEquals(1, companyProfileRepository.count());

    }
}
