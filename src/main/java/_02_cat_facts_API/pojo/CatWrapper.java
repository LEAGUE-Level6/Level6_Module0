package _02_cat_facts_API.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CatWrapper {

    @SerializedName("fact")
    @Expose
    private String fact;
    @SerializedName("length")
    @Expose
    private Integer length;

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

}
