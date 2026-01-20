package model;

import java.time.LocalDateTime;

public class Organization {
    private Integer orgID;
    private String orgName;
    private String address;
    private String phone;
    private String email;
    private LocalDateTime createdDate;

    public Organization() {
    }

    public Organization(String orgName, String address, String phone, String email) {
        this.orgName = orgName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.createdDate = LocalDateTime.now();
    }

    // Getters and Setters
    public Integer getOrgID() {
        return orgID;
    }

    public void setOrgID(Integer orgID) {
        this.orgID = orgID;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}