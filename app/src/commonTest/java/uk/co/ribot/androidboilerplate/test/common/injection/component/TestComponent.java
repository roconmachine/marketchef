package uk.co.ribot.androidboilerplate.test.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import com.roconmachine.app.marketchef.injection.component.ApplicationComponent;
import uk.co.ribot.androidboilerplate.test.common.injection.module.ApplicationTestModule;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}
