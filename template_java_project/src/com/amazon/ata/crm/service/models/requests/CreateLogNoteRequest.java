package com.amazon.ata.crm.service.models.requests;

import com.amazon.ata.crm.service.models.Action;

import java.time.LocalDateTime;
import java.util.Objects;

public class CreateLogNoteRequest {

    private String clientId;
    private Action action;
    private String note;
    private String date;
    private String time;

    public CreateLogNoteRequest(String clientId, Action action, String note, String date, String time) {
        this.clientId = clientId;
        this.action = action;
        this.note = note;
        this.date = date;
        this.time = time;
    }

    public CreateLogNoteRequest() {
    }

    public CreateLogNoteRequest(Builder builder) {
        this.clientId = builder.clientId;
        this.action = builder.action;
        this.note = builder.note;
        this.date = builder.date;
        this.time = builder.time;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateLogNoteRequest)) return false;
        CreateLogNoteRequest that = (CreateLogNoteRequest) o;
        return Objects.equals(getClientId(), that.getClientId()) && getAction() == that.getAction() && Objects.equals(getNote(), that.getNote()) && Objects.equals(getDate(), that.getDate()) && Objects.equals(getTime(), that.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId(), getAction(), getNote(), getDate(), getTime());
    }

    @Override
    public String toString() {
        return "CreateLogNoteRequest{" +
                "clientId='" + clientId + '\'' +
                ", action=" + action +
                ", note='" + note + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String clientId;
        private Action action;
        private String note;
        private String date;
        private String time;


        private Builder() {

        }

        public Builder withClientId(String clientIdToUse) {
            this.clientId = clientIdToUse;
            return this;
        }
        public Builder withAction(Action actionToUse) {
            this.action = actionToUse;
            return this;
        }

        public Builder withNote(String noteToUse) {
            this.note = noteToUse;
            return this;
        }

        public Builder withDate(String dateToUse) {
            this.date = dateToUse;
            return this;
        }

        public Builder withTime(String timeToUse) {
            this.time = timeToUse;
            return this;
        }

        public CreateLogNoteRequest build() {return new CreateLogNoteRequest(this);}
    }
}
