package com.amazon.ata.crm.service.activity;

import com.amazon.ata.crm.service.dynamodb.ClientDao;
import com.amazon.ata.crm.service.dynamodb.models.Client;
import com.amazon.ata.crm.service.models.requests.CreateClientRequest;
import com.amazon.ata.crm.service.models.results.CreateClientResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CreateClientActivityTest {

    @Mock
    private ClientDao clientDao;

    private CreateClientActivity createClientActivity;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        createClientActivity = new CreateClientActivity(clientDao);
    }

    @Test
    public void handleRequest_newClientIsSaved_andReturned() {

        String expectedFirstName = "first";
        String expectedLastName = "last";
        String expectedCompany = "company";
        String expectedPhone = "8009992222 x722727";
        String expectedEmail = "first@last.com";


        Client client = new Client();
        client.setFirstName(expectedFirstName);
        client.setLastName(expectedLastName);
        client.setCompany(expectedCompany);
        client.setPhone(expectedPhone);
        client.setEmail(expectedEmail);

        when(clientDao.saveClient(client)).thenReturn(client);

        CreateClientRequest request = CreateClientRequest.builder()
                .withFirstName(expectedFirstName)
                .withLastName(expectedLastName)
                .withCompany(expectedCompany)
                .withPhone(expectedPhone)
                .withEmail(expectedEmail)
                .build();
        //WHEN
        CreateClientResult result = createClientActivity.handleRequest(request, null);

        //THEN

        assertEquals(expectedFirstName, result.getClient().getFirstName());
        assertEquals(expectedLastName, result.getClient().getLastName());
        assertEquals(expectedCompany, result.getClient().getCompany());
        System.out.println(result.getClient().getPhone());

    }

}
