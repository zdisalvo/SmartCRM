package com.amazon.ata.crm.service.models.results;

import com.amazon.ata.crm.service.models.ClientModel;

public class UpdateClientResult {

    private ClientModel client;

    public UpdateClientResult(UpdateClientResult.Builder builder) {this.client = builder.client; }

    public ClientModel getClient() {return client;}

    public void setClient(ClientModel client) {this.client = client;}

    public static UpdateClientResult.Builder builder() {return new UpdateClientResult.Builder();}

    public static final class Builder {
        private ClientModel client;

        public UpdateClientResult.Builder withClient(ClientModel client) {
            this.client = client;
            return this;
        }

        public UpdateClientResult build() {return new UpdateClientResult(this);}
    }


}

