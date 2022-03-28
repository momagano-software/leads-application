package za.co.momagano.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class WorkingHours {

    @EmbeddedId
    private WorkingHoursId workingHoursId;

    @ManyToMany(mappedBy = "workingHours")
    @JsonIgnore
    List<CompanyProfile> companyProfiles;

    public WorkingHours() {
    }

    public WorkingHoursId getWorkingHoursId() {
        return workingHoursId;
    }

    public void setWorkingHoursId(WorkingHoursId workingHoursId) {
        this.workingHoursId = workingHoursId;
    }

    public List<CompanyProfile> getCompanyProfiles() {
        return companyProfiles;
    }

    public void setCompanyProfiles(List<CompanyProfile> companyProfiles) {
        this.companyProfiles = companyProfiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingHours that = (WorkingHours) o;
        return Objects.equals(workingHoursId, that.workingHoursId) &&
                Objects.equals(companyProfiles, that.companyProfiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workingHoursId, companyProfiles);
    }

    @Override
    public String toString() {
        return "WorkingHours{" +
                "workingHoursId=" + workingHoursId +
                ", companyProfiles=" + companyProfiles +
                '}';
    }
}
