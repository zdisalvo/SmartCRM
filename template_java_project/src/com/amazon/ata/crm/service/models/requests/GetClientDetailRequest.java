package com.amazon.ata.crm.service.models.requests;

import com.amazon.ata.crm.service.dynamodb.models.LogNote;

import java.util.List;
import java.util.Objects;

public class GetClientDetailRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String company;
    private String phone;
    private String textBox;
    private List<LogNote> logNotes;

    public GetClientDetailRequest() {

    }

    public GetClientDetailRequest(Builder builder) {

        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.company = builder.company;
        this.phone = builder.phone;
        this.textBox = builder.textBox;
        this.logNotes = builder.logNotes;
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

    public String getTextBox() {
        return textBox;
    }

    public void setTextBox(String textBox) {
        this.textBox = textBox;
    }

    public List<LogNote> getLogNotes() {
        return logNotes;
    }

    public void setLogNotes(List<LogNote> logNotes) {
        this.logNotes = logNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetClientDetailRequest)) return false;
        GetClientDetailRequest that = (GetClientDetailRequest) o;
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
        private String textBox;
        private List<LogNote> logNotes;


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

        public Builder withPhone(String phoneToUse) {
            this.phone = phoneToUse;
            return this;
        }

        public Builder withTextBox(String textBoxToUse) {
            this.textBox = textBoxToUse;
            return this;
        }

        public Builder withLogNotes(List<LogNote> logNotesToUse) {
            this.logNotes = logNotesToUse;
            return this;
        }

        public GetClientDetailRequest build() { return new GetClientDetailRequest(this); }
    }
}