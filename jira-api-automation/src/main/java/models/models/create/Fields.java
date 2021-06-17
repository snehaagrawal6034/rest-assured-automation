
package models.models.create;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Fields {

    public Fields(String description, Issuetype issuetype, Project project, String summary) {
        this.description = description;
        this.issuetype = issuetype;
        this.project = project;
        this.summary = summary;
    }

    @Expose
    private String description;
    @Expose
    private Issuetype issuetype;
    @Expose
    private Project project;
    @Expose
    private String summary;

    public String getDescription() {
        return description;
    }

    public Issuetype getIssuetype() {
        return issuetype;
    }

    public Project getProject() {
        return project;
    }

    public String getSummary() {
        return summary;
    }

}
