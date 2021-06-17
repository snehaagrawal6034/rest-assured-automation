
package models.create;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

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
