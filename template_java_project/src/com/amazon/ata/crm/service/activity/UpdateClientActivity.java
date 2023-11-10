package com.amazon.ata.crm.service.activity;

import com.amazon.ata.crm.service.converters.ModelConverter;
import com.amazon.ata.crm.service.dynamodb.ClientDao;
import com.amazon.ata.crm.service.dynamodb.models.Client;
import com.amazon.ata.crm.service.dynamodb.models.LogNote;
import com.amazon.ata.crm.service.models.ClientModel;
import com.amazon.ata.crm.service.models.requests.UpdateClientRequest;
import com.amazon.ata.crm.service.models.results.CreateClientResult;
import com.amazon.ata.crm.service.models.results.UpdateClientResult;
import com.amazon.ata.crm.service.util.CreateValidEmail;
import com.amazon.ata.crm.service.util.CreateValidName;
import com.amazon.ata.crm.service.util.CreateValidPhone;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.time.LocalDateTime;

public class UpdateClientActivity implements RequestHandler<UpdateClientRequest, UpdateClientResult> {

    private final Logger log = LogManager.getLogger();
    private final ClientDao clientDao;

    @Inject
    public UpdateClientActivity(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public UpdateClientResult handleRequest(final UpdateClientRequest updateClientRequest, Context context) {
        log.info("Received UpdateClientRequest {}", updateClientRequest);

        String clientId = updateClientRequest.getId();

        Client client = clientDao.getClientById(clientId);

        if (updateClientRequest.getFirstName() != null &&
                CreateValidName.isValidName(updateClientRequest.getFirstName())) {
            client.setFirstName(updateClientRequest.getFirstName().toUpperCase());
        }
        if (updateClientRequest.getLastName() != null &&
                CreateValidName.isValidName(updateClientRequest.getLastName())) {
            client.setLastName(updateClientRequest.getLastName().toUpperCase());
        }
        if (updateClientRequest.getCompany() != null) {
            client.setCompany(updateClientRequest.getCompany().toUpperCase());
        }
        if (updateClientRequest.getPhone() != null &&
                CreateValidPhone.isValidPhone(updateClientRequest.getPhone())) {
            client.setPhone(CreateValidPhone.formatPhoneNumber(updateClientRequest.getPhone()));
        }
        if (updateClientRequest.getEmail() != null &&
                CreateValidEmail.isValidEmail(updateClientRequest.getEmail())) {
            client.setEmail(updateClientRequest.getEmail().toUpperCase());
        }
        if (updateClientRequest.getTextBox() != null) {
            client.setTextBox(updateClientRequest.getTextBox());
        }
        if (updateClientRequest.getLogNotes() != null) {
            LogNote logNote = new LogNote();

            logNote.setClientId(updateClientRequest.getId());
            logNote.setNote(logNote.getNote());
            logNote.setAction(logNote.getAction());
            logNote.setNoteDateTime(LocalDateTime.now());

            client.getLogNotes().add(logNote);
        }

        ClientModel clientModel = new ModelConverter().toClientModel(client);

        clientDao.saveClient(client);

        return UpdateClientResult.builder()
                .withClient(clientModel)
                .build();
    }
}
