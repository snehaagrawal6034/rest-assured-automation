
package models.create;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

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
