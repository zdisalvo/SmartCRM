package com.amazon.ata.crm.service.converters;

import com.amazon.ata.crm.service.dynamodb.models.LogNote;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class LogNoteLinkedListConverter implements DynamoDBTypeConverter<String, List> {
    private static final Gson GSON = new Gson();
    private final Logger log = LogManager.getLogger();

    @Override
    public String convert(List listToBeConverted) {
        return GSON.toJson(listToBeConverted);
    }

    @Override
    public List unconvert(String dynamoDbRepresentation) {
        // need to provide the type parameter for the list to convert correctly
        return GSON.fromJson(dynamoDbRepresentation, new TypeToken<LinkedList<LogNote>>() { } .getType());
    }
}
