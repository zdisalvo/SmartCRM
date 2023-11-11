package com.amazon.ata.crm.service.dynamodb.models;

import com.amazon.ata.crm.service.converters.LogNoteLinkedListConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@DynamoDBTable(tableName = "clients")
public class Client {

    private String id;
    private String firstName;
    private String lastName;
    private String company;
    private String phone;
    private String email;
    private String textBox;
    private LinkedList<LogNote> logNotes;


    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @DynamoDBAttribute(attributeName = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @DynamoDBAttribute(attributeName = "company")
    public String getCompany() {
        return company;
    }


    public void setCompany(String company) {
        this.company = company;
    }

    @DynamoDBAttribute(attributeName = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @DynamoDBAttribute(attributeName = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DynamoDBAttribute(attributeName = "text_box")
    public String getTextBox() {
        return textBox;
    }

    public void setTextBox(String textBox) {
        this.textBox = textBox;
    }

    @DynamoDBTypeConverted(converter = LogNoteLinkedListConverter.class)
//    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.L)
    @DynamoDBAttribute(attributeName = "log_notes")
    public LinkedList<LogNote> getLogNotes() {
        return logNotes;
    }

    public void setLogNotes(LinkedList<LogNote> logNotes) {
        this.logNotes = logNotes;
    }
}
