package com.amazon.ata.crm.service.dependency;

import com.amazon.ata.crm.service.activity.CreateClientActivity;
import com.amazon.ata.crm.service.activity.CreateLogNoteActivity;
import com.amazon.ata.crm.service.activity.GetClientActivity;
import com.amazon.ata.crm.service.activity.UpdateClientActivity;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {DaoModule.class})
@Singleton
public interface ServiceComponent {
    //root objects
    CreateClientActivity provideCreateClientActivity();

    GetClientActivity provideGetClientActivity();

    UpdateClientActivity provideUpdateClientActivity();

    CreateLogNoteActivity provideCreateLogNoteActivity();
}

