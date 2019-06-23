package utitity.mahmoud.prayertimes.datalayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PrayerRespose {

    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("data")
    @Expose
    private Data data;

    public PrayerRespose(int code, Data data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getDate() {
        return data;
    }

    public void setDate(Data date) {
        this.data = date;
    }
}
