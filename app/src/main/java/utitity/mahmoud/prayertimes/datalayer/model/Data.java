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


    @SerializedName("3")
    @Expose
    private List<Day> _3 = null;

    @SerializedName("4")
    @Expose
    private List<Day> _4 = null;


    @SerializedName("5")
    @Expose
    private List<Day> _5 = null;

    @SerializedName("6")
    @Expose
    private List<Day> _6 = null;




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

    public List<Day> get_3() {
        return _3;
    }

    public void set_3(List<Day> _3) {
        this._3 = _3;
    }

    public List<Day> get_4() {
        return _4;
    }

    public void set_4(List<Day> _4) {
        this._4 = _4;
    }

    public List<Day> get_5() {
        return _5;
    }

    public void set_5(List<Day> _5) {
        this._5 = _5;
    }

    public List<Day> get_6() {
        return _6;
    }

    public void set_6(List<Day> _6) {
        this._6 = _6;
    }
}
