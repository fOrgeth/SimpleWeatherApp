package th.forge.simpleweatherapp.app.di;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import th.forge.simpleweatherapp.app.App;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        AppModule.class,
        RepositoryModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App application);

        AppComponent build();
    }

}
