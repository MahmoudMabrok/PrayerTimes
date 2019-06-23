
package utitity.mahmoud.prayertimes.datalayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Month_ {

    @SerializedName("number")
    @Expose
    private int number;
    @SerializedName("en")
    @Expose
    private String en;

    /**
     * No args constructor for use in serialization
     */
    public Month_() {
    }

    /**
     * @param en
     * @param number
     */
    public Month_(int number, String en) {
        super();
        this.number = number;
        this.en = en;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

}
