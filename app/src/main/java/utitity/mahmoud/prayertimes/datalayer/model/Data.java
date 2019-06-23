package utitity.mahmoud.prayertimes.datalayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("1")
    @Expose
    private List<Day> firstMonth = null;

    @SerializedName("2")
    @Expose
    private List<Day> secondMonth = null;

    public Data() {
    }

    public Data(List<Day> firstMonth, List<Day> secondMonth) {
        this.firstMonth = firstMonth;
        this.secondMonth = secondMonth;
    }

    public List<Day> getFirstMonth() {
        return firstMonth;
    }

    public void setFirstMonth(List<Day> firstMonth) {
        this.firstMonth = firstMonth;
    }

    public List<Day> getSecondMonth() {
        return secondMonth;
    }

    public void setSecondMonth(List<Day> secondMonth) {
        this.secondMonth = secondMonth;
    }

}
