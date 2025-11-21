package uz.lb.models;

import uz.lb.enums.GeneralStatus;
import uz.lb.enums.UserRoleEnums;

import java.sql.Date;
import java.util.List;

public class User {
    private Long id;
    private String phoneNumber;
    private String firstname;
    private String lastname;
    private String surname;
    private String password;
    private String passwordApp;
    private String bio;
    private List<Long> imageIds;
    private java.sql.Date birthday;
    private UserRoleEnums role = UserRoleEnums.ROLE_USER;
    private GeneralStatus status = GeneralStatus.ACTIVE;
    private Boolean visible = Boolean.TRUE;

    private Date createdAt;
    private Date updatedAt;

    public User(Long id, String phoneNumber, String firstname, String lastname, String surname, String password,
                String passwordApp, String bio, List<Long> imageIds, Date birthday, UserRoleEnums role,
                GeneralStatus status, Boolean visible, Date createdAt, Date updatedAt) {

        this.id = id;
        this.phoneNumber = phoneNumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.surname = surname;
        this.password = password;
        this.passwordApp = passwordApp;
        this.bio = bio;
        this.imageIds = imageIds;
        this.birthday = birthday;
        this.role = role;
        this.status = status;
        this.visible = visible;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordApp() {
        return passwordApp;
    }

    public void setPasswordApp(String passwordApp) {
        this.passwordApp = passwordApp;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Long> getImageIds() {
        return imageIds;
    }

    public void setImageIds(List<Long> imageIds) {
        this.imageIds = imageIds;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public UserRoleEnums getRole() {
        return role;
    }

    public void setRole(UserRoleEnums role) {
        this.role = role;
    }

    public GeneralStatus getStatus() {
        return status;
    }

    public void setStatus(GeneralStatus status) {
        this.status = status;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", passwordApp='" + passwordApp + '\'' +
                ", bio='" + bio + '\'' +
                ", imageIds=" + imageIds +
                ", birthday=" + birthday +
                ", role=" + role +
                ", status=" + status +
                ", visible=" + visible +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

