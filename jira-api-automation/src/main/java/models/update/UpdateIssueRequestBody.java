
package models.update;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class UpdateIssueRequestBody {

    public UpdateIssueRequestBody(Fields fields) {
        this.fields = fields;
    }

    @Expose
    private Fields fields;

    public Fields getFields() {
        return fields;
    }

    public static class Builder {

        private Fields fields;

        public UpdateIssueRequestBody.Builder withFields(Fields fields) {
            this.fields = fields;
            return this;
        }

        public UpdateIssueRequestBody build() {
            UpdateIssueRequestBody updateIssueRequestBody = new UpdateIssueRequestBody(fields);
            return updateIssueRequestBody;
        }

    }

}
