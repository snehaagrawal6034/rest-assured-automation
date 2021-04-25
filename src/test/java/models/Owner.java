package models;

import java.util.HashMap;
import java.util.Map;

public class Owner {

    public String login;
    public Integer id;
    public String nodeId;
    public String avatarUrl;
    public String gravatarId;
    public String url;
    public String htmlUrl;
    public String followersUrl;
    public String followingUrl;
    public String gistsUrl;
    public String starredUrl;
    public String subscriptionsUrl;
    public String organizationsUrl;
    public String reposUrl;
    public String eventsUrl;
    public String receivedEventsUrl;
    public String type;
    public Boolean siteAdmin;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Owner() {
    }

    /**
     *
     * @param receivedEventsUrl
     * @param siteAdmin
     * @param followingUrl
     * @param gistsUrl
     * @param avatarUrl
     * @param organizationsUrl
     * @param reposUrl
     * @param htmlUrl
     * @param subscriptionsUrl
     * @param login
     * @param type
     * @param url
     * @param starredUrl
     * @param gravatarId
     * @param followersUrl
     * @param id
     * @param eventsUrl
     * @param nodeId
     */
    public Owner(String login, Integer id, String nodeId, String avatarUrl, String gravatarId, String url, String htmlUrl, String followersUrl, String followingUrl, String gistsUrl, String starredUrl, String subscriptionsUrl, String organizationsUrl, String reposUrl, String eventsUrl, String receivedEventsUrl, String type, Boolean siteAdmin) {
        super();
        this.login = login;
        this.id = id;
        this.nodeId = nodeId;
        this.avatarUrl = avatarUrl;
        this.gravatarId = gravatarId;
        this.url = url;
        this.htmlUrl = htmlUrl;
        this.followersUrl = followersUrl;
        this.followingUrl = followingUrl;
        this.gistsUrl = gistsUrl;
        this.starredUrl = starredUrl;
        this.subscriptionsUrl = subscriptionsUrl;
        this.organizationsUrl = organizationsUrl;
        this.reposUrl = reposUrl;
        this.eventsUrl = eventsUrl;
        this.receivedEventsUrl = receivedEventsUrl;
        this.type = type;
        this.siteAdmin = siteAdmin;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
