package com.amazon.ata.crm.service.models.requests;

import java.util.Objects;

public class GetClientRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String company;
    private String phone;

    public GetClientRequest() {

    }

    public GetClientRequest(Builder builder) {

        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.company = builder.company;
        this.phone = builder.phone;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetClientRequest)) return false;
        GetClientRequest that = (GetClientRequest) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getFirstName(), that.getFirstName()) && Objects.equals(getLastName(), that.getLastName()) && Objects.equals(getCompany(), that.getCompany()) && Objects.equals(getPhone(), that.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getCompany(), getPhone());
    }

    @Override
    public String toString() {
        return "GetClientRequest{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static Builder builder() { return new Builder(); }

    public static final class Builder {
        private String id;
        private String firstName;
        private String lastName;
        private String company;
        private String phone;


        private Builder() {

        }

        public Builder withId(String idToUse) {
            this.id = idToUse;
            return this;
        }

        public Builder withFirstName(String firstNameToUse) {
            this.firstName = firstNameToUse;
            return this;
        }

        public Builder withLastName(String lastNameToUse) {
            this.lastName = lastNameToUse;
            return this;
        }

        public Builder withCompany(String companyToUse) {
            this.company = companyToUse;
            return this;
        }

        public GetClientRequest build() { return new GetClientRequest(this); }
    }
}