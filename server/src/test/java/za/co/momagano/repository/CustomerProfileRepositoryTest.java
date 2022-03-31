package za.co.momagano.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.co.momagano.CompanyProfileTestHelper;
import za.co.momagano.CustomerProfileTestHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class CustomerProfileRepositoryTest {

    @Autowired
    private CustomerProfileRepository customerProfileRepository;

    @BeforeEach
    public void clearDb() {
        customerProfileRepository.deleteAll();
    }

    @Test
    public void companyProfileShouldBeSavedToRepository() {
        assertEquals(0, customerProfileRepository.count());
        customerProfileRepository.save(CustomerProfileTestHelper.getFullCustomerProfile());

        assertEquals(1, customerProfileRepository.count());

    }
}
