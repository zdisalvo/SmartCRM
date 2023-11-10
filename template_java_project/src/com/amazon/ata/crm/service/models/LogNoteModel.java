package com.amazon.ata.crm.service.models;

import com.amazon.ata.crm.service.models.requests.CreateLogNoteRequest;

import java.time.LocalDateTime;
import java.util.Objects;

public class LogNoteModel {

    private String clientId;
    private Action action;
    private String note;
    private LocalDateTime noteDateTime;

    public LogNoteModel(String clientId, Action action, String note, LocalDateTime noteDateTime) {
        this.clientId = clientId;
        this.action = action;
        this.note = note;
        this.noteDateTime = noteDateTime;
    }

    public LogNoteModel() {
    }

    public LogNoteModel(Builder builder) {
        this.clientId = builder.clientId;
        this.action = builder.action;
        this.note = builder.note;
        this.noteDateTime = builder.noteDateTime;
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

    public LocalDateTime getNoteDateTime() {
        return noteDateTime;
    }

    public void setNoteDateTime(LocalDateTime noteDateTime) {
        this.noteDateTime = noteDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogNoteModel)) return false;
        LogNoteModel that = (LogNoteModel) o;
        return Objects.equals(getClientId(), that.getClientId()) && getAction() == that.getAction() && Objects.equals(getNote(), that.getNote()) && Objects.equals(getNoteDateTime(), that.getNoteDateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientId(), getAction(), getNote(), getNoteDateTime());
    }

    @Override
    public String toString() {
        return "LogNoteModel{" +
                "clientId='" + clientId + '\'' +
                ", action=" + action +
                ", note='" + note + '\'' +
                ", noteDateTime=" + noteDateTime +
                '}';
    }

    public static Builder builder() { return new Builder();
    }

    public static final class Builder {
        private String clientId;
        private Action action;
        private String note;
        private LocalDateTime noteDateTime;


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

        public Builder withNoteDateTime(LocalDateTime noteDateTimeToUse) {
            this.noteDateTime = LocalDateTime.now();
            return this;
        }

        public LogNoteModel build() {return new LogNoteModel(this);}
    }
}