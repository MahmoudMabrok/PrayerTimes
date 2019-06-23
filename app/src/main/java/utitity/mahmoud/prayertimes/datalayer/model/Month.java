
package utitity.mahmoud.prayertimes.datalayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Month {

    @SerializedName("day")
    @Expose
    private List<Day> day = null;

    /**
     * No args constructor for use in serialization
     */
    public Month() {
    }

    /**
     * @param day
     */
    public Month(List<Day> day) {
        super();
        this.day = day;
    }

    public List<Day> getDay() {
        return day;
    }

    public void setDay(List<Day> day) {
        this.day = day;
    }

}
