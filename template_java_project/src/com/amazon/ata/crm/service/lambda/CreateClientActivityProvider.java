package com.amazon.ata.crm.service.lambda;

import com.amazon.ata.crm.service.activity.CreateClientActivity;
//import com.amazon.ata.crm.service.dependency.DaggerServiceComponent;
import com.amazon.ata.crm.service.dependency.DaggerServiceComponent;
import com.amazon.ata.crm.service.dependency.ServiceComponent;
import com.amazon.ata.crm.service.models.requests.CreateClientRequest;
import com.amazon.ata.crm.service.models.results.CreateClientResult;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateClientActivityProvider implements RequestHandler<CreateClientRequest, CreateClientResult> {

    //private static App app;

    public CreateClientActivityProvider() {

    }

    @Override
    public CreateClientResult handleRequest(final CreateClientRequest createClientRequest, Context context) {
        return getDagger().handleRequest(createClientRequest, context);
    }


    private CreateClientActivity getDagger() {
        ServiceComponent dagger = DaggerServiceComponent.create();
        CreateClientActivity createClientActivity = dagger.provideCreateClientActivity();
        return createClientActivity;
    }


}
