package pl.coderslab.model;

import org.mindrot.jbcrypt.BCrypt;

public class User {
    private int id;
    private String userName;
    private String email;
    private String password;
    private int groupId;

    public User() {
    }

    public User(int id, String userName, String email, String password, int groupId) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.hashPassword(password);
        this.groupId = groupId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void hashPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.hashPassword(password);
    }

}
