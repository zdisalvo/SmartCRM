package com.amazon.ata.crm.service.lambda;

import com.amazon.ata.crm.service.activity.CreateClientActivity;
import com.amazon.ata.crm.service.activity.CreateLogNoteActivity;
import com.amazon.ata.crm.service.dependency.DaggerServiceComponent;
import com.amazon.ata.crm.service.dependency.ServiceComponent;
import com.amazon.ata.crm.service.models.requests.CreateClientRequest;
import com.amazon.ata.crm.service.models.requests.CreateLogNoteRequest;
import com.amazon.ata.crm.service.models.results.CreateClientResult;
import com.amazon.ata.crm.service.models.results.CreateLogNoteResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateLogNoteActivityProvider implements RequestHandler<CreateLogNoteRequest, CreateLogNoteResult> {

    //private static App app;

    public CreateLogNoteActivityProvider() {

    }

    @Override
    public CreateLogNoteResult handleRequest(final CreateLogNoteRequest createLogNoteRequest, Context context) {
        return getDagger().handleRequest(createLogNoteRequest, context);
    }


    private CreateLogNoteActivity getDagger() {
        ServiceComponent dagger = DaggerServiceComponent.create();
        CreateLogNoteActivity createLogNoteActivity = dagger.provideCreateLogNoteActivity();
        return createLogNoteActivity;
    }


}
