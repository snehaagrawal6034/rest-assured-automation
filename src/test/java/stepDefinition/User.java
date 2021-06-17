package stepDefinition;

import java.util.HashMap;
import java.util.Map;

public class User {

    public String owner;
    public String name;
    public String description;
    public Boolean includeAllBranches;
    public Boolean _private;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    /**
     *
     * @param owner
     * @param _private
     * @param name
     * @param includeAllBranches
     * @param description
     */
    public User(String owner, String name, String description, Boolean includeAllBranches, Boolean _private) {
        super();
        this.owner = owner;
        this.name = name;
        this.description = description;
        this.includeAllBranches = includeAllBranches;
        this._private = _private;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}