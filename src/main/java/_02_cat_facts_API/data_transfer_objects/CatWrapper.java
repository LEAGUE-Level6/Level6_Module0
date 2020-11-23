package _02_cat_facts_API.data_transfer_objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CatWrapper {

    @SerializedName("data")
    @Expose
    private List<String> data = null;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    /*
    This class could simply be defined as below, but the above code is what is supplied by jsonschema2pojo.com:

    private List<String> data = null;

    public List<String> getData() {
        return data;
    }
    */

}
