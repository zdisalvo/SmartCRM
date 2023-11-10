package com.amazon.ata.crm.service.converters;

import com.amazon.ata.crm.service.dynamodb.models.Client;
import com.amazon.ata.crm.service.dynamodb.models.LogNote;
import com.amazon.ata.crm.service.models.ClientModel;
import com.amazon.ata.crm.service.models.LogNoteModel;

public class LogNoteModelConverter {

        public LogNoteModel toLogNoteModel(LogNote logNote) {

            return LogNoteModel.builder()
                    .withClientId(logNote.getClientId())
                    .withAction(logNote.getAction())
                    .withNote(logNote.getNote())
                    .withNoteDateTime(logNote.getNoteDateTime())
                    .build();
        }

}
