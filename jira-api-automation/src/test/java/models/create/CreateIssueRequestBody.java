
package models.create;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CreateIssueRequestBody {

    public CreateIssueRequestBody(Fields fields) {
        this.fields = fields;
    }

    @Expose
    private Fields fields;

    public Fields getFields() {
        return fields;
    }
}
