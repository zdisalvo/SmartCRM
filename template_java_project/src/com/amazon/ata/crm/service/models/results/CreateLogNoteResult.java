package com.amazon.ata.crm.service.models.results;

import com.amazon.ata.crm.service.dynamodb.models.LogNote;
import com.amazon.ata.crm.service.models.ClientModel;
import com.amazon.ata.crm.service.models.LogNoteModel;

public class CreateLogNoteResult {

    private LogNoteModel logNote;

    public CreateLogNoteResult(Builder builder) {this.logNote= builder.logNote; }

    public LogNoteModel getLogNote() {return logNote;}

    public void setLogNote(LogNoteModel logNote) {this.logNote = logNote;}

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private LogNoteModel logNote;

        public Builder withLogNote(LogNoteModel logNote) {
            this.logNote = logNote;
            return this;
        }

        public CreateLogNoteResult build() {return new CreateLogNoteResult(this);}
    }



}
