package th.forge.simpleweatherapp.app.di;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import th.forge.simpleweatherapp.data.db.citieslist.CitiesListDB;
import th.forge.simpleweatherapp.data.db.citieslist.LocationDao;

@Module
public class AppModule {

    private Application app;

    AppModule(@NonNull Application app) {
        this.app = app;
    }


    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    CitiesListDB provideCitiesListDatabase(Application app) {
        return Room.databaseBuilder(app, CitiesListDB.class, "cities.db")
                //ToDo: use Threads
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    LocationDao provideCitiesListDao(CitiesListDB database) {
        return database.locationDao();
    }
}
