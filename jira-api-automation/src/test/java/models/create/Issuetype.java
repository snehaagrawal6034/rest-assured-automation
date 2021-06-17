
package models.create;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Issuetype {

    public Issuetype(String name) {
        this.name = name;
    }

    @Expose
    private String name;

    public String getName() {
        return name;
    }
}
