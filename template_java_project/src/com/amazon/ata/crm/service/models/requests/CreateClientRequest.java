package com.amazon.ata.crm.service.models.requests;

import com.amazon.ata.crm.service.util.CreateValidName;



import java.util.Locale;
import java.util.Objects;
import java.util.Set;

public class CreateClientRequest {

    private String id;
    private String firstName;
    private String lastName;
    private String company;
    private String phone;
    private String email;
    private String textBox;

    public CreateClientRequest(String id, String firstName, String lastName,
                               String company, String phone, String email, String textBox) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.phone = phone;
        this.email = email;
        this.textBox = textBox;
    }

    public CreateClientRequest() {
    }

    public CreateClientRequest(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.company = builder.company;
        this.phone = builder.phone;
        this.email = builder.email;
        this.textBox = builder.textBox;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != CreateClientRequest.class) return false;
        CreateClientRequest that = (CreateClientRequest) o;
        return  Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getCompany(), that.getCompany()) &&
                Objects.equals(getPhone(), that.getPhone()) &&
                Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, company, phone, email);
    }

    @Override
    public String toString() {
        return "CreateClientRequest{" +
                "id='" + id + '\'' +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private String id;
        private String firstName;
        private String lastName;
        private String company;
        private String phone;
        private String email;
        private String textBox;

        private Builder() {

        }

        public Builder withId (String idToUse) {
            this.id = idToUse;
            return this;
        }

        public Builder withFirstName (String firstNameToUse) {
            this.firstName = firstNameToUse;
            return this;
        }

        public Builder withLastName (String lastNameToUse) {
            this.lastName = lastNameToUse;
            return this;
        }

        public Builder withCompany (String companyToUse) {
            this.company = companyToUse;
            return this;
        }

        public Builder withPhone (String phoneToUse) {
            this.phone = phoneToUse;
            return this;
        }

        public Builder withEmail (String emailToUse) {
            this.email = emailToUse;
            return this;
        }

        public Builder withTextBox (String textBoxToUse) {
            this.textBox = textBoxToUse;
            return this;
        }

        public CreateClientRequest build() {return new CreateClientRequest(this);}
    }
}
