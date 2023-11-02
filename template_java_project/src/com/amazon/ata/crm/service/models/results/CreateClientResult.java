package com.amazon.ata.crm.service.models.results;

import com.amazon.ata.crm.service.models.ClientModel;

public class CreateClientResult {

    private ClientModel client;

    public CreateClientResult(Builder builder) {this.client = builder.client; }

    public ClientModel getClient() {return client;}

    public void setClient(ClientModel client) {this.client = client;}

    public static Builder builder() {return new Builder();}

    public static final class Builder {
        private ClientModel client;

        public Builder withClient(ClientModel client) {
            this.client = client;
            return this;
        }

        public CreateClientResult build() {return new CreateClientResult(this);}
    }


}
