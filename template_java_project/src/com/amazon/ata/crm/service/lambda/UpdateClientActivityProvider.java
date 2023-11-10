package com.amazon.ata.crm.service.lambda;


import com.amazon.ata.crm.service.activity.GetClientActivity;
import com.amazon.ata.crm.service.activity.UpdateClientActivity;
import com.amazon.ata.crm.service.dependency.DaggerServiceComponent;
import com.amazon.ata.crm.service.dependency.ServiceComponent;
import com.amazon.ata.crm.service.models.requests.GetClientRequest;
import com.amazon.ata.crm.service.models.requests.UpdateClientRequest;
import com.amazon.ata.crm.service.models.results.GetClientResult;
import com.amazon.ata.crm.service.models.results.UpdateClientResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class UpdateClientActivityProvider implements RequestHandler<UpdateClientRequest, UpdateClientResult> {

    //private static App app;

    public UpdateClientActivityProvider() {

    }

    @Override
    public UpdateClientResult handleRequest(final UpdateClientRequest updateClientRequest, Context context) {
        return getDagger().handleRequest(updateClientRequest, context);
    }


    private UpdateClientActivity getDagger() {
        ServiceComponent dagger = DaggerServiceComponent.create();
        UpdateClientActivity updateClientActivity = dagger.provideUpdateClientActivity();
        return updateClientActivity;
    }
}
