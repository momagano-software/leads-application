package za.co.momagano;

import za.co.momagano.model.CompanyProfile;

import java.util.ArrayList;

public class CompanyProfileTestHelper {

    public static CompanyProfile getFullCompanyProfile() {
        CompanyProfile companyProfile = new CompanyProfile("1990/05/904329","A company");
        companyProfile.setAbout("About");
        companyProfile.setContact("0111122234");
        companyProfile.setEmail("email@address.com");
        companyProfile.setName("Name");
        companyProfile.setPortfolio("Portfolio");
        companyProfile.setLocation("Location");
        companyProfile.setExperience("Experience");
        companyProfile.setWorkingHours(new ArrayList<>());

        return companyProfile;
    }
}
