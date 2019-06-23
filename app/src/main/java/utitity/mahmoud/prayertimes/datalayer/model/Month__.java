
package utitity.mahmoud.prayertimes.datalayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Month__ {

    @SerializedName("number")
    @Expose
    private int number;
    @SerializedName("en")
    @Expose
    private String en;
    @SerializedName("ar")
    @Expose
    private String ar;

    /**
     * No args constructor for use in serialization
     */
    public Month__() {
    }

    /**
     * @param ar
     * @param en
     * @param number
     */
    public Month__(int number, String en, String ar) {
        super();
        this.number = number;
        this.en = en;
        this.ar = ar;
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

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

}
