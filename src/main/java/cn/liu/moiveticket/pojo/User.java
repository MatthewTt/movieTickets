package cn.liu.moiveticket.pojo;


public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private int access_type;

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccess_type() {
        return access_type;
    }

    public void setAccess_type(int access_type) {
        this.access_type = access_type;
    }
}
