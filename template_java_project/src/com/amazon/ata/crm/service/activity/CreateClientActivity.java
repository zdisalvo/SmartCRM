package com.amazon.ata.crm.service.activity;

import com.amazon.ata.crm.service.converters.ModelConverter;
import com.amazon.ata.crm.service.dynamodb.ClientDao;
import com.amazon.ata.crm.service.dynamodb.models.Client;
import com.amazon.ata.crm.service.dynamodb.models.User;
import com.amazon.ata.crm.service.exceptions.InvalidAttributeException;
import com.amazon.ata.crm.service.models.ClientModel;
import com.amazon.ata.crm.service.models.requests.CreateClientRequest;
import com.amazon.ata.crm.service.models.results.CreateClientResult;
import com.amazon.ata.crm.service.util.CreateValidEmail;
import com.amazon.ata.crm.service.util.CreateValidName;
import com.amazon.ata.crm.service.util.CreateValidPhone;
import com.amazon.ata.crm.service.util.GenerateId;
import com.amazonaws.Request;
//import com.amazonaws.handlers.RequestHandler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;





import com.amazonaws.services.s3.request.S3HandlerContextKeys;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.util.TimingInfo;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.logging.Log;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateClientActivity implements RequestHandler<CreateClientRequest, CreateClientResult> {


    //TODO - need to import apache loggin or find name for logger
    private final Logger log = LogManager.getLogger();

    private final ClientDao clientDao;


    public CreateClientActivity(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public CreateClientResult handleRequest(final CreateClientRequest createClientRequest, Context context){
        log.info("Received CreateClientRequest {}", createClientRequest);
        Client client = new Client();

        client.setCompany(createClientRequest.getCompany());

        if (CreateValidName.isValidName(createClientRequest.getFirstName()) &&
            CreateValidName.isValidName(createClientRequest.getLastName())) {
            client.setFirstName(createClientRequest.getFirstName());
            client.setLastName(createClientRequest.getLastName());
        } else {
            throw new InvalidAttributeException("Name entry was invalid, some characters were not allowed");
        }

        if (CreateValidPhone.isValidPhone(createClientRequest.getPhone())) {
            client.setPhone(createClientRequest.getPhone());
        } else {
            throw new InvalidAttributeException("Invalid phone. Phone number must be exactly 10 digits");
        }

        if (CreateValidEmail.isValidEmail(createClientRequest.getEmail())) {
            client.setEmail(createClientRequest.getEmail());
        } else {
            throw new InvalidAttributeException("Invalid email.");
        }

        String clientId = GenerateId.generateClientId();
        client.setId(clientId);

        client.setTextBox("");

        ClientModel clientModel = new ModelConverter().toClientModel(client);

        clientDao.saveClient(client);

        return CreateClientResult.builder()
                .withClient(clientModel)
                .build();
    }




}
