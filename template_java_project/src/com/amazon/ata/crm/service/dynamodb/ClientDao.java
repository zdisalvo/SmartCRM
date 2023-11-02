package com.amazon.ata.crm.service.dynamodb;
//import com.amazon.ata.aws.dynamodb.DynamoDbClientProvider;
import com.amazon.ata.crm.service.util.DynamoDbClientProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;



import com.amazon.ata.crm.service.dynamodb.models.Client;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;



public class ClientDao {

private final DynamoDBMapper dynamoDBMapper;


    /**
     * Instantiates a ClientDao object
     *
     * @param dynamoDBMapper the {@link DynamoDBMapper} used to interact with the clients table
     *      */
    public ClientDao(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Client saveClient(Client client) {
        DynamoDBMapper mapper = new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
        //Playlist playlist = mapper.load(Playlist.class, id);

        mapper.save(client);

        return client;
    }
}
