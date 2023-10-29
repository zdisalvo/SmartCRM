//package com.amazon.ata.crm.service.lambda;
//
//import com.amazon.ata.crm.service.activity.CreateClientActivity;
//import com.amazon.ata.crm.service.models.requests.CreateClientRequest;
//import com.amazon.ata.crm.service.models.results.CreateClientResult;
//import com.amazonaws.handlers.RequestHandler;
//
//public class CreateClientActivityProvider implements RequestHandler<CreateClientRequest, CreateClientResult> {
//
//    //private static App app;
//
//    public CreatePlaylistActivityProvider() {
//
//    }
//
//    @Override
//    public CreateClientResult handleRequest(final CreateClientRequest createPlaylistRequest, Context context) {
//        return getDagger().handleRequest(createPlaylistRequest, context);
//    }
//
////    private App getApp() {
////        if (app == null) {
////            app = new App();
////        }
////
////        return app;
////    }
//
//    private CreateClientActivity getDagger() {
//        ServiceComponent dagger = DaggerServiceComponent.create();
//        CreateClientActivity createClientActivity = dagger.provideCreateClientActivity();
//        return createClientActivity;
//    }
//
//
//}
