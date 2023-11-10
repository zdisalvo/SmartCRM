package com.amazon.ata.crm.service.converters;


import com.amazon.ata.crm.service.dynamodb.models.Client;
import com.amazon.ata.crm.service.models.ClientModel;

public class ModelConverter {

    public ClientModel toClientModel(Client client) {

    return ClientModel.builder()
            .withId(client.getId())
            .withFirstName(client.getFirstName())
            .withLastName(client.getLastName())
            .withCompany(client.getCompany())
            .withPhone(client.getPhone())
            .withEmail(client.getEmail())
            .withTextBox(client.getTextBox())
            .withLogNotes(client.getLogNotes())
            .build();
    }
}
