
package utitity.mahmoud.prayertimes.datalayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weekday {

    @SerializedName("en")
    @Expose
    private String en;

    /**
     * No args constructor for use in serialization
     */
    public Weekday() {
    }

    /**
     * @param en
     */
    public Weekday(String en) {
        super();
        this.en = en;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

}
