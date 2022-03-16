package za.co.momagano.rest;

public class WorkingHours {

    private String dayOfTheWeek;
    private String startTimeHour;
    private String startTimeMinute;
    private String endTimeHour;
    private String endTimeMinute;

    public WorkingHours() {
    }
    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }


    public String getStartTimeHour() {
        return startTimeHour;
    }

    public void setStartTimeHour(String startTimeHour) {
        this.startTimeHour = startTimeHour;
    }

    public String getStartTimeMinute() {
        return startTimeMinute;
    }

    public void setStartTimeMinute(String startTimeMinute) {
        this.startTimeMinute = startTimeMinute;
    }

    public String getEndTimeHour() {
        return endTimeHour;
    }

    public void setEndTimeHour(String endTimeHour) {
        this.endTimeHour = endTimeHour;
    }

    public String getEndTimeMinute() {
        return endTimeMinute;
    }

    public void setEndTimeMinute(String endTimeMinute) {
        this.endTimeMinute = endTimeMinute;
    }

    @Override
    public String toString() {
        return "WorkingHours{" +
                "day='" + dayOfTheWeek + '\'' +
                ", startTimeHour='" + startTimeHour + '\'' +
                ", startTimeMinutes='" + startTimeMinute + '\'' +
                ", endTimeHour='" + endTimeHour + '\'' +
                ", endTimeMinutes='" + endTimeMinute + '\'' +
                '}';
    }
}
