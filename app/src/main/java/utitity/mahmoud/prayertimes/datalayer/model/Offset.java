
package utitity.mahmoud.prayertimes.datalayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offset {

    @SerializedName("Imsak")
    @Expose
    private int imsak;
    @SerializedName("Fajr")
    @Expose
    private int fajr;
    @SerializedName("Sunrise")
    @Expose
    private int sunrise;
    @SerializedName("Dhuhr")
    @Expose
    private int dhuhr;
    @SerializedName("Asr")
    @Expose
    private int asr;
    @SerializedName("Maghrib")
    @Expose
    private int maghrib;
    @SerializedName("Sunset")
    @Expose
    private int sunset;
    @SerializedName("Isha")
    @Expose
    private int isha;
    @SerializedName("Midnight")
    @Expose
    private int midnight;

    /**
     * No args constructor for use in serialization
     */
    public Offset() {
    }

    /**
     * @param dhuhr
     * @param imsak
     * @param midnight
     * @param isha
     * @param sunset
     * @param asr
     * @param sunrise
     * @param fajr
     * @param maghrib
     */
    public Offset(int imsak, int fajr, int sunrise, int dhuhr, int asr, int maghrib, int sunset, int isha, int midnight) {
        super();
        this.imsak = imsak;
        this.fajr = fajr;
        this.sunrise = sunrise;
        this.dhuhr = dhuhr;
        this.asr = asr;
        this.maghrib = maghrib;
        this.sunset = sunset;
        this.isha = isha;
        this.midnight = midnight;
    }

    public int getImsak() {
        return imsak;
    }

    public void setImsak(int imsak) {
        this.imsak = imsak;
    }

    public int getFajr() {
        return fajr;
    }

    public void setFajr(int fajr) {
        this.fajr = fajr;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getDhuhr() {
        return dhuhr;
    }

    public void setDhuhr(int dhuhr) {
        this.dhuhr = dhuhr;
    }

    public int getAsr() {
        return asr;
    }

    public void setAsr(int asr) {
        this.asr = asr;
    }

    public int getMaghrib() {
        return maghrib;
    }

    public void setMaghrib(int maghrib) {
        this.maghrib = maghrib;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public int getIsha() {
        return isha;
    }

    public void setIsha(int isha) {
        this.isha = isha;
    }

    public int getMidnight() {
        return midnight;
    }

    public void setMidnight(int midnight) {
        this.midnight = midnight;
    }

}
