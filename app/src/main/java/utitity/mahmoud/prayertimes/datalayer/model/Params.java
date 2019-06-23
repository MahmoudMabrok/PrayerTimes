
package utitity.mahmoud.prayertimes.datalayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Params {

    @SerializedName("Fajr")
    @Expose
    private int fajr;
    @SerializedName("Isha")
    @Expose
    private int isha;

    /**
     * No args constructor for use in serialization
     */
    public Params() {
    }

    /**
     * @param isha
     * @param fajr
     */
    public Params(int fajr, int isha) {
        super();
        this.fajr = fajr;
        this.isha = isha;
    }

    public int getFajr() {
        return fajr;
    }

    public void setFajr(int fajr) {
        this.fajr = fajr;
    }

    public int getIsha() {
        return isha;
    }

    public void setIsha(int isha) {
        this.isha = isha;
    }

}
