
package utitity.mahmoud.prayertimes.datalayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Designation_ {

    @SerializedName("abbreviated")
    @Expose
    private String abbreviated;

    @SerializedName("expanded")
    @Expose
    private String expanded;

    /**
     * No args constructor for use in serialization
     */
    public Designation_() {
    }

    /**
     * @param abbreviated
     * @param expanded
     */
    public Designation_(String abbreviated, String expanded) {
        super();
        this.abbreviated = abbreviated;
        this.expanded = expanded;
    }

    public String getAbbreviated() {
        return abbreviated;
    }

    public void setAbbreviated(String abbreviated) {
        this.abbreviated = abbreviated;
    }

    public String getExpanded() {
        return expanded;
    }

    public void setExpanded(String expanded) {
        this.expanded = expanded;
    }

}
