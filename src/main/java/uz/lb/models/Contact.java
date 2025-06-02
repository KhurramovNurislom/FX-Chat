package uz.lb.models;

public class Contact {
    public Contact() {

    }
    public Contact(String name, String avatar, String message) {
        this.name = name;
        this.avatar = avatar;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String name = "suer name";
    String avatar = "avatar";
    String message = "message";
}
