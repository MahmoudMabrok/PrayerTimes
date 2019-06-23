
package utitity.mahmoud.prayertimes.datalayer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Method {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("params")
    @Expose
    private Params params;

    /**
     * No args constructor for use in serialization
     */
    public Method() {
    }

    /**
     * @param id
     * @param name
     * @param params
     */
    public Method(int id, String name, Params params) {
        super();
        this.id = id;
        this.name = name;
        this.params = params;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

}
