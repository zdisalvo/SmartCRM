package com.amazon.ata.crm.service.models.results;

import com.amazon.ata.crm.service.dynamodb.models.Client;
import com.amazon.ata.crm.service.models.ClientModel;

import java.util.ArrayList;
import java.util.List;

public class GetClientResult {

    private List<ClientModel> clientList;

    public GetClientResult(GetClientResult.Builder builder) {this.clientList = builder.clientList; }

    public List<ClientModel> getClient() {return clientList;}

    public void setClient(List<ClientModel> clientList) {this.clientList = clientList;}

    public static GetClientResult.Builder builder() {return new GetClientResult.Builder();}

    public static final class Builder {
        private List<ClientModel> clientList;

        public GetClientResult.Builder withClient(List<ClientModel> clientList) {
            this.clientList = clientList;
            return this;
        }

        public GetClientResult build() {return new GetClientResult(this);}
    }
}
