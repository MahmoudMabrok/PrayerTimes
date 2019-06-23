
package utitity.mahmoud.prayertimes.datalayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weekday_ {

    @SerializedName("en")
    @Expose
    private String en;
    @SerializedName("ar")
    @Expose
    private String ar;

    /**
     * No args constructor for use in serialization
     */
    public Weekday_() {
    }

    /**
     * @param ar
     * @param en
     */
    public Weekday_(String en, String ar) {
        super();
        this.en = en;
        this.ar = ar;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

}
