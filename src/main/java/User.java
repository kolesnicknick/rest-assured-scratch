import com.fasterxml.jackson.annotation.JsonProperty;

public class User {


    public User(String login, Integer id, String avatarurl, String url) {
        this.login = login;
        this.id = id;
        this.avatarurl = avatarurl;
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String login;
    private Integer id;
    @JsonProperty("avatar_url")
    private String avatarurl;
    private String url;

}
