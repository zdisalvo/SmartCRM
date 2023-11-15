package com.amazon.ata.crm.service.dynamodb;

import com.amazon.ata.crm.service.dynamodb.models.Client;
import com.amazon.ata.crm.service.dynamodb.models.LogNote;
import com.amazon.ata.crm.service.exceptions.ClientNotFoundException;
import com.amazon.ata.crm.service.util.DynamoDbClientProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import javax.inject.Inject;
import java.util.LinkedList;

public class LogNoteDao {

    private final DynamoDBMapper dynamoDBMapper;



    /**
     * Instantiates a LogNoteDao object
     *
     * @param dynamoDBMapper the {@link DynamoDBMapper} used to interact with the log_notes table
     *      */
    @Inject
    public LogNoteDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }


    //TODO - should I use client or Log Note class to lookup client?
    public Client getClientById(String id) {
        Client client = this.dynamoDBMapper.load(Client.class, id);

        if (client == null) {
            throw new ClientNotFoundException("Could not find a client with id " + id);
        }

        return client;
    }

    public LogNote saveLogNote(LogNote logNote) {
        DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
        //Playlist playlist = mapper.load(Playlist.class, id);

        //TODO
//        Client client = getClientById(logNote.getClientId());

//        LinkedList<LogNote> logNotesLinkedList = new LinkedList<>();
//
//        if (client.getLogNotes() == null) {
//
//            logNotesLinkedList.addFirst(logNote);
//            client.setLogNotes(logNotesLinkedList);
//
//        } else {
//
//            client.getLogNotes().addFirst(logNote);
//        }
//
//        mapper.save(client);

        mapper.save(logNote);

        return logNote;
    }
}
