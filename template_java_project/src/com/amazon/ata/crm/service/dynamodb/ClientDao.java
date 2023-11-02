package com.amazon.ata.crm.service.dynamodb;
//import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazon.ata.crm.service.exceptions.ClientNotFoundException;
import com.amazon.ata.crm.service.util.DynamoDbClientProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;



import com.amazon.ata.crm.service.dynamodb.models.Client;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;



public class ClientDao {

    private final DynamoDBMapper dynamoDBMapper;



    /**
     * Instantiates a ClientDao object
     *
     * @param dynamoDBMapper the {@link DynamoDBMapper} used to interact with the clients table
     *      */
    @Inject
    public ClientDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }


    public Client getClientById(String id) {
        Client client = this.dynamoDBMapper.load(Client.class, id);

        if (client == null) {
            throw new ClientNotFoundException("Could not find a client with id " + id);
        }

        return client;
    }

    public List<Client> getClientByAttributes(Map<String, AttributeValue> query) {


        Client client = new Client();
        client.setId("C819835");
//
//        // * NEW *
//        Condition condition = new Condition();
//        condition.withComparisonOperator(ComparisonOperator.EQ)
//                .withAttributeValueList(new AttributeValue().withS("5")); //Set your search value here

        DynamoDBQueryExpression<Client> queryExpression =
                new DynamoDBQueryExpression<Client>()
                        //.withHashKeyValues(client)
                        .withFilterExpression("firstName = :zack")
                        .withExpressionAttributeValues(query)// * NEW *
                        .withLimit(20);

        List<Client> queryResult = this.dynamoDBMapper.query(Client.class, queryExpression);

        return queryResult;



//
//        String expString = "";
//
//        for (HashMap.Entry<String, AttributeValue> entry : query.entrySet()) {
//            expString += entry.getValue() + " ";
//        }
//
//        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
//                .withFilterExpression(expString).withExpressionAttributeValues(query);
//
//        List<Client> scanResult = this.dynamoDBMapper.parallelScan(Client.class, scanExpression, 20);
//
//
//
//        List<Client> clientList = new ArrayList<>();


        //TODO IGNORE
//        Client client = this.dynamoDBMapper.load(Client.class, firstName);
//
//        if (client == null) {
//            throw new ClientNotFoundException("Could not find a client with first name " + firstName);
//        }
//
//        clientList.add(client);
//
//        while (client != null) {
//            client = this.dynamoDBMapper.load(Client.class, firstName);
//        }
    //TODO

//        return scanResult;
    }

    public Client saveClient(Client client) {
        DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
        //Playlist playlist = mapper.load(Playlist.class, id);

        mapper.save(client);

        return client;
    }
}
