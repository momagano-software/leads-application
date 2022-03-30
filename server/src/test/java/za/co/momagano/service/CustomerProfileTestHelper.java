package za.co.momagano.service;

import za.co.momagano.model.CustomerProfile;

public class CustomerProfileTestHelper {
    public static CustomerProfile getFullCustomerProfile() {
        CustomerProfile customerProfile = new CustomerProfile(
                "Peter",
                "Parker",
                "spidey@gmail.com",
                "0111122334"
        );
        return customerProfile;
    }
}
