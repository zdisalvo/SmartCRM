package com.amazon.ata.crm.service.dynamodb.models;

public class Client {

    private String firstName;
    private String lastName;
    private String company;
    private String phone;
    private String email;
    private String textBox;
    private Integer clientId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getTextBox() {
        return textBox;
    }

    public void setTextBox(String textBox) {
        this.textBox = textBox;
    }
}
