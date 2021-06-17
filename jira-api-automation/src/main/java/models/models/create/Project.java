
package models.models.create;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Project {

    public Project(String key) {
        this.key = key;
    }

    @Expose
    private String key;

    public String getKey() {
        return key;
    }
}
