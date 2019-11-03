package utitity.mahmoud.prayertimes.datalayer.local.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import utitity.mahmoud.prayertimes.datalayer.model.Timings;

@Entity(tableName = "prayers")
public class DayPrayerItem {

    @PrimaryKey(autoGenerate = true)
    int id;
    private int day;
    private int month;
    private int year;
    private String dayDate;

    private Timings timings;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDayDate() {
        return dayDate;
    }

    public void setDayDate(String dayDate) {
        this.dayDate = dayDate;
    }

    public Timings getTimings() {
        return timings;
    }

    public void setTimings(Timings timings) {
        this.timings = timings;
    }

    @Override
    public String toString() {
        return "DayPrayerItem{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", dayDate='" + dayDate + '\'' +
                ", timings=" + timings +
                '}';
    }
}
