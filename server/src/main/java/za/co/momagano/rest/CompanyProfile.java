package za.co.momagano.rest;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class CompanyProfile implements Serializable {
    @Id
    private String companyRegistration;
    private String tradingName;
    private  String name;
    private  String email;
    private  String contact;
    private  String experience;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "company_working_hours",
            joinColumns = @JoinColumn(name = "company_companyRegistration", referencedColumnName = "companyRegistration"))
    private  List<WorkingHours> workingHours;
    private  String location;
    private  String portfolio;
//    private  List<Social> socials;
    private  String about;




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

    public void setCompanyRegistration(String companyRegistration) {
        this.companyRegistration = companyRegistration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public List<WorkingHours> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(List<WorkingHours> workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return "CompanyProfile{" +
                "companyRegistration='" + companyRegistration + '\'' +
                ", tradingName='" + tradingName + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", experience='" + experience + '\'' +
                ", workingHours=" + workingHours +
                ", location='" + location + '\'' +
                ", portfolio='" + portfolio + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
