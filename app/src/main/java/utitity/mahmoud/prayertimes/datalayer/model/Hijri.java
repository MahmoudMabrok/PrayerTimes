
package utitity.mahmoud.prayertimes.datalayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hijri {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("weekday")
    @Expose
    private Weekday_ weekday;
    @SerializedName("month")
    @Expose
    private Month__ month;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("designation")
    @Expose
    private Designation_ designation;
    @SerializedName("holidays")
    @Expose
    private List<Object> holidays = null;

    /**
     * No args constructor for use in serialization
     */
    public Hijri() {
    }

    /**
     * @param weekday
     * @param designation
     * @param month
     * @param holidays
     * @param year
     * @param day
     * @param format
     * @param date
     */
    public Hijri(String date, String format, String day, Weekday_ weekday, Month__ month, String year, Designation_ designation, List<Object> holidays) {
        super();
        this.date = date;
        this.format = format;
        this.day = day;
        this.weekday = weekday;
        this.month = month;
        this.year = year;
        this.designation = designation;
        this.holidays = holidays;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Weekday_ getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday_ weekday) {
        this.weekday = weekday;
    }

    public Month__ getMonth() {
        return month;
    }

    public void setMonth(Month__ month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Designation_ getDesignation() {
        return designation;
    }

    public void setDesignation(Designation_ designation) {
        this.designation = designation;
    }

    public List<Object> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Object> holidays) {
        this.holidays = holidays;
    }

}
