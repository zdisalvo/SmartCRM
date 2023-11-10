package com.amazon.ata.crm.service.dynamodb.models;

import com.amazon.ata.crm.service.models.Action;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.joda.time.DateTime;

import java.time.LocalDateTime;

public class LogNote {

    private String clientId;
    private Action action;
    private String note;
    private LocalDateTime noteDateTime;

    @DynamoDBHashKey(attributeName = "client_id")
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

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

    @DynamoDBAttribute(attributeName = "note_date_time")
    public LocalDateTime getNoteDateTime() {
        return noteDateTime;
    }

    public void setNoteDateTime(LocalDateTime noteDateTime) {
        this.noteDateTime = noteDateTime;
    }
}
