package com.amazon.ata.crm.service.models.results;

import com.amazon.ata.crm.service.models.ClientModel;

public class GetClientDetailResult {

    private ClientModel client;

    public GetClientDetailResult(GetClientDetailResult.Builder builder) {this.client = builder.client; }

    public ClientModel getClient() {return client;}

    public void setClient(ClientModel client) {this.client = client;}

    public static GetClientDetailResult.Builder builder() {return new GetClientDetailResult.Builder();}

    public static final class Builder {
        private ClientModel client;

        public GetClientDetailResult.Builder withClient(ClientModel client) {
            this.client = client;
            return this;
        }

        public GetClientDetailResult build() {return new GetClientDetailResult(this);}
    }


}
