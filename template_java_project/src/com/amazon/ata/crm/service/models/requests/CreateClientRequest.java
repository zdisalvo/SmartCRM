package com.amazon.ata.crm.service.models.requests;

import com.amazon.ata.crm.service.util.CreateValidName;



import java.util.Locale;
import java.util.Objects;
import java.util.Set;

public class CreateClientRequest {

    private String firstName;
    private String lastName;
    private String company;
    private String phone;
    private String email;

    public CreateClientRequest(String firstName, String lastName, String company, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.phone = phone;
        this.email = email;
    }

    public CreateClientRequest() {
    }

    public CreateClientRequest(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.company = builder.company;
        this.phone = builder.phone;
        this.email = builder.email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != CreateClientRequest.class) return false;
        CreateClientRequest that = (CreateClientRequest) o;
        return Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getCompany(), that.getCompany()) &&
                Objects.equals(getPhone(), that.getPhone()) &&
                Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getCompany(), getPhone(), getEmail());
    }

    @Override
    public String toString() {
        return "CreateClientRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private String firstName;
        private String lastName;
        private String company;
        private String phone;
        private String email;

        private Builder() {

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
            this.company = phoneToUse;
            return this;
        }

        public Builder withEmail (String emailToUse) {
            this.email = emailToUse;
            return this;
        }

        public CreateClientRequest build() {return new CreateClientRequest(this);}
    }
}
