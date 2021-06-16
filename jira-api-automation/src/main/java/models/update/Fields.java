
package models.update;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Fields {

    public Fields(String description, String summary) {
        this.description = description;
        this.summary = summary;
    }

    @Expose
    private String description;
    @Expose
    private String summary;

    public String getDescription() {
        return description;
    }

    public String getSummary() {
        return summary;
    }

    public static class Builder {

        private String description;
        private String summary;

        public Fields.Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Fields.Builder withSummary(String summary) {
            this.summary = summary;
            return this;
        }

        public Fields build() {
            Fields fields = new Fields(description, summary);
            return fields;
        }

    }

}
