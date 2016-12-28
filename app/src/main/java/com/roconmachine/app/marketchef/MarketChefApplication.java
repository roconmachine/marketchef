package com.roconmachine.app.marketchef;

import android.app.Application;
import android.content.Context;

import timber.log.Timber;

import com.roconmachine.app.marketchef.injection.component.ApplicationComponent;
import com.roconmachine.app.marketchef.injection.component.DaggerApplicationComponent;
import com.roconmachine.app.marketchef.injection.module.ApplicationModule;

public class MarketChefApplication extends Application  {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            //Fabric.with(this, new Crashlytics());
        }
    }

    public static MarketChefApplication get(Context context) {
        return (MarketChefApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
