package models.create;

import com.google.gson.annotations.SerializedName;

public class CreateIssueResponse {
    private final String key;

    public CreateIssueResponse(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
