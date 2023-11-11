package com.amazon.ata.crm.service.dynamodb.models;

import com.amazon.ata.crm.service.models.Action;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import org.joda.time.DateTime;

import java.time.LocalDateTime;

@DynamoDBTable(tableName = "log_notes")
public class LogNote {

    private String clientId;
    private Action action;
    private String note;
    private String date;
    private String time;

    public LogNote() {
    }

    @DynamoDBHashKey(attributeName = "clientId")
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    @DynamoDBAttribute(attributeName = "action")
    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @DynamoDBAttribute(attributeName = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    @DynamoDBAttribute(attributeName = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @DynamoDBAttribute(attributeName = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
