package com.roconmachine.app.marketchef.injection.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import com.roconmachine.app.marketchef.data.DataManager;
import com.roconmachine.app.marketchef.data.SyncService;
import com.roconmachine.app.marketchef.data.local.DatabaseHelper;
import com.roconmachine.app.marketchef.data.local.PreferencesHelper;
import com.roconmachine.app.marketchef.data.remote.RibotsService;
import com.roconmachine.app.marketchef.injection.ApplicationContext;
import com.roconmachine.app.marketchef.injection.module.ApplicationModule;
import com.roconmachine.app.marketchef.util.RxEventBus;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SyncService syncService);

    @ApplicationContext
    Context context();
    Application application();
    RibotsService ribotsService();
    PreferencesHelper preferencesHelper();
    DatabaseHelper databaseHelper();
    DataManager dataManager();
    RxEventBus eventBus();

}
