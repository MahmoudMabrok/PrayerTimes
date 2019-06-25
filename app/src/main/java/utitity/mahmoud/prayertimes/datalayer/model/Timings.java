
package utitity.mahmoud.prayertimes.datalayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Timings {

    @SerializedName("Fajr")
    @Expose
    private String fajr;
    @SerializedName("Sunrise")
    @Expose
    private String sunrise;
    @SerializedName("Dhuhr")
    @Expose
    private String dhuhr;
    @SerializedName("Asr")
    @Expose
    private String asr;
    @SerializedName("Sunset")
    @Expose
    private String sunset;
    @SerializedName("Maghrib")
    @Expose
    private String maghrib;
    @SerializedName("Isha")
    @Expose
    private String isha;
    @SerializedName("Imsak")
    @Expose
    private String imsak;
    @SerializedName("Midnight")
    @Expose
    private String midnight;

    /**
     * No args constructor for use in serialization
     */
    public Timings() {
    }

    /**
     * @param imsak
     * @param dhuhr
     * @param midnight
     * @param isha
     * @param sunset
     * @param asr
     * @param sunrise
     * @param fajr
     * @param maghrib
     */
    public Timings(String fajr, String sunrise, String dhuhr, String asr, String sunset, String maghrib, String isha, String imsak, String midnight) {
        super();
        this.fajr = fajr;
        this.sunrise = sunrise;
        this.dhuhr = dhuhr;
        this.asr = asr;
        this.sunset = sunset;
        this.maghrib = maghrib;
        this.isha = isha;
        this.imsak = imsak;
        this.midnight = midnight;
    }

    public String getFajr() {
        return fajr;
    }

    public void setFajr(String fajr) {
        this.fajr = fajr;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getDhuhr() {
        return dhuhr;
    }

    public void setDhuhr(String dhuhr) {
        this.dhuhr = dhuhr;
    }

    public String getAsr() {
        return asr;
    }

    public void setAsr(String asr) {
        this.asr = asr;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getMaghrib() {
        return maghrib;
    }

    public void setMaghrib(String maghrib) {
        this.maghrib = maghrib;
    }

    public String getIsha() {
        return isha;
    }

    public void setIsha(String isha) {
        this.isha = isha;
    }

    public String getImsak() {
        return imsak;
    }

    public void setImsak(String imsak) {
        this.imsak = imsak;
    }

    public String getMidnight() {
        return midnight;
    }

    public void setMidnight(String midnight) {
        this.midnight = midnight;
    }


    @Override
    public String toString() {
        return "Timings{" +
                "fajr='" + fajr + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", dhuhr='" + dhuhr + '\'' +
                ", asr='" + asr + '\'' +
                ", sunset='" + sunset + '\'' +
                ", maghrib='" + maghrib + '\'' +
                ", isha='" + isha + '\'' +
                ", imsak='" + imsak + '\'' +
                ", midnight='" + midnight + '\'' +
                '}';
    }

    public List<String> getValues() {
        List<String> values = new ArrayList<>();
        values.add(fajr);
        values.add(sunrise);
        values.add(dhuhr);
        values.add(asr);
        values.add(maghrib);
        values.add(isha);

        return values;
    }

}
