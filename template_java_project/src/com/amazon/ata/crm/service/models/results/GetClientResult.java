package com.amazon.ata.crm.service.models.results;

import com.amazon.ata.crm.service.models.ClientModel;

public class GetClientResult {

    private ClientModel client;

    public GetClientResult(GetClientResult.Builder builder) {this.client = builder.client; }

    public ClientModel getClient() {return client;}

    public void setClient(ClientModel client) {this.client = client;}

    public static GetClientResult.Builder builder() {return new GetClientResult.Builder();}

    public static final class Builder {
        private ClientModel client;

        public GetClientResult.Builder withClient(ClientModel client) {
            this.client = client;
            return this;
        }

        public GetClientResult build() {return new GetClientResult(this);}
    }
}
