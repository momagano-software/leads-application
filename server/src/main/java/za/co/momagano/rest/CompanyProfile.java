package za.co.momagano.rest;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class CompanyProfile implements Serializable {
    @Id
    private String companyRegistration;
    private String tradingName;


    public CompanyProfile() {
    }

    public CompanyProfile(String companyRegistration, String tradingName) {
        this.companyRegistration = companyRegistration;
        this.tradingName = tradingName;
    }

    public void setTradingName(String tradingName) {

        this.tradingName = tradingName;
    }

    public String getTradingName() {
        return tradingName;
    }

    public String getCompanyRegistration() {
        return companyRegistration;
    }
}
