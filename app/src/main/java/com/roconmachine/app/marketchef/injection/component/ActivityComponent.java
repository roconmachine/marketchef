package com.roconmachine.app.marketchef.injection.component;

import dagger.Subcomponent;
import com.roconmachine.app.marketchef.injection.PerActivity;
import com.roconmachine.app.marketchef.injection.module.ActivityModule;
import com.roconmachine.app.marketchef.ui.main.MainActivity;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
