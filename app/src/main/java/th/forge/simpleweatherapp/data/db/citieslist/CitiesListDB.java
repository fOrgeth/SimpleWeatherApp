package th.forge.simpleweatherapp.data.db.citieslist;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Location.class}, version = 1, exportSchema = false)
public abstract class CitiesListDB extends RoomDatabase {
    public abstract LocationDao locationDao();
}
