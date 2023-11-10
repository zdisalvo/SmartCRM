package com.amazon.ata.crm.service.lambda;


import com.amazon.ata.crm.service.activity.GetClientActivity;
import com.amazon.ata.crm.service.dependency.DaggerServiceComponent;
import com.amazon.ata.crm.service.dependency.ServiceComponent;
import com.amazon.ata.crm.service.models.requests.GetClientRequest;
import com.amazon.ata.crm.service.models.results.GetClientResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class GetClientActivityProvider implements RequestHandler<GetClientRequest, GetClientResult> {

    //private static App app;

    public GetClientActivityProvider() {

    }

    @Override
    public GetClientResult handleRequest(final GetClientRequest getClientRequest, Context context) {
        return getDagger().handleRequest(getClientRequest, context);
    }


    private GetClientActivity getDagger() {
        ServiceComponent dagger = DaggerServiceComponent.create();
        GetClientActivity getClientActivity = dagger.provideGetClientActivity();
        return getClientActivity;
    }
}


