
package models.create;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

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
