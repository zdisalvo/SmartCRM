package com.amazon.ata.crm.service.activity;

import com.amazon.ata.crm.service.converters.ModelConverter;
import com.amazon.ata.crm.service.dynamodb.ClientDao;
import com.amazon.ata.crm.service.dynamodb.models.Client;
import com.amazon.ata.crm.service.models.ClientModel;
import com.amazon.ata.crm.service.models.requests.GetClientRequest;
import com.amazon.ata.crm.service.models.results.GetClientResult;
import com.amazon.ata.crm.service.util.CreateValidPhone;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetClientActivity implements RequestHandler<GetClientRequest, GetClientResult> {

    private final Logger log = LogManager.getLogger();
    private final ClientDao clientDao;

    @Inject
    public GetClientActivity(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public GetClientResult handleRequest(final GetClientRequest getClientRequest, Context context) {
        log.info("Received GetClientRequest {}", getClientRequest);
        String requestedId = getClientRequest.getId();
        Client client = null;
        List<Client> clientList = new ArrayList<>();

        if (requestedId != null) {
            client = clientDao.getClientById(requestedId);
            clientList.add(client);
        } else {
            Map<String, AttributeValue> query = new HashMap<>();

            String requestedFirstName = getClientRequest.getFirstName();
            if (requestedFirstName != null) {
                query.put(requestedFirstName, new AttributeValue().withS("firstName"));
            }

            String requestedLastName = getClientRequest.getLastName();
            if (requestedLastName != null) {
                query.put(requestedLastName, new AttributeValue().withS("lastName"));
            }

            String requestedCompany = getClientRequest.getCompany();
            if (requestedCompany != null) {
                query.put(requestedCompany, new AttributeValue().withS("company"));
            }

            String requestedPhone = getClientRequest.getPhone();
            if (requestedPhone != null) {
                CreateValidPhone.formatPhoneNumber(requestedPhone);
                query.put(requestedPhone, new AttributeValue().withS("phone"));
            }

            clientList = clientDao.getClientByAttributes(query);
        }

        List<ClientModel> clientModelList = new ArrayList<>();
        ClientModel clientModel;

        for (Client client1 : clientList) {
            clientModel = new ModelConverter().toClientModel(client1);
            clientModelList.add(clientModel);
        }


        return GetClientResult.builder()
                .withClient(clientModelList)
                .build();


    }

}
