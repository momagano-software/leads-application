package za.co.momagano.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class WorkingHoursId implements Serializable {
    private String dayOfTheWeek;
    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
    private Date startTime;
    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
    private Date endTime;
    public WorkingHoursId() {
    }

    public WorkingHoursId(String dayOfTheWeek, Date startTime, Date endTime) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "WorkingHoursId{" +
                "dayOfTheWeek='" + dayOfTheWeek + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingHoursId that = (WorkingHoursId) o;
        return Objects.equals(getDayOfTheWeek(), that.getDayOfTheWeek()) &&
                Objects.equals(getStartTime(), that.getStartTime()) &&
                Objects.equals(getEndTime(), that.getEndTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDayOfTheWeek(), getStartTime(), getEndTime());
    }
}
