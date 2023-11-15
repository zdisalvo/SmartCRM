package com.amazon.ata.crm.service.activity;

import com.amazon.ata.crm.service.converters.LogNoteModelConverter;
import com.amazon.ata.crm.service.converters.ModelConverter;
import com.amazon.ata.crm.service.dynamodb.ClientDao;
import com.amazon.ata.crm.service.dynamodb.LogNoteDao;
import com.amazon.ata.crm.service.dynamodb.models.Client;
import com.amazon.ata.crm.service.dynamodb.models.LogNote;
import com.amazon.ata.crm.service.models.ClientModel;
import com.amazon.ata.crm.service.models.LogNoteModel;
import com.amazon.ata.crm.service.models.requests.CreateClientRequest;
import com.amazon.ata.crm.service.models.requests.CreateLogNoteRequest;
import com.amazon.ata.crm.service.models.results.CreateClientResult;
import com.amazon.ata.crm.service.models.results.CreateLogNoteResult;
import com.amazon.ata.crm.service.models.results.UpdateClientResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class CreateLogNoteActivity implements RequestHandler<CreateLogNoteRequest, CreateLogNoteResult> {



    private final Logger log = LogManager.getLogger();

    private final ClientDao clientDao;
    private final LogNoteDao logNoteDao;


    @Inject
    public CreateLogNoteActivity(ClientDao clientDao, LogNoteDao logNoteDao) {
        this.clientDao = clientDao;
        this.logNoteDao = logNoteDao;
    }

    @Override
    public CreateLogNoteResult handleRequest(final CreateLogNoteRequest createLogNoteRequest, Context context) {
        log.info("Received CreateLogNoteRequest {}", createLogNoteRequest);

        Client client = clientDao.getClientById(createLogNoteRequest.getClientId());

        LogNote logNote = new LogNote();
        logNote.setClientId(createLogNoteRequest.getClientId());
        logNote.setNote(createLogNoteRequest.getNote());
        logNote.setAction(createLogNoteRequest.getAction());

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
        ZonedDateTime pacificDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = pacificDateTime.format(dateFormat);
        //Set Log Note Date
        logNote.setDate(date);

        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = pacificDateTime.format(timeFormat);
        logNote.setTime(time);

        LinkedList<LogNote> logNotesLinkedList = new LinkedList<>();

        if (client.getLogNotes() == null) {

            logNotesLinkedList.addFirst(logNote);
            client.setLogNotes(logNotesLinkedList);

        } else {

            client.getLogNotes().addFirst(logNote);
        }

        clientDao.saveClient(client);

        ClientModel clientModel = new ModelConverter().toClientModel(client);

        LogNoteModel logNoteModel = new LogNoteModelConverter().toLogNoteModel(logNote);



        logNoteDao.saveLogNote(logNote);


        return CreateLogNoteResult.builder()
                .withLogNote(logNoteModel)
                .build();
    }

}
