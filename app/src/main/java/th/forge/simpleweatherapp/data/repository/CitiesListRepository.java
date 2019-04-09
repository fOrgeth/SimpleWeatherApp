package th.forge.simpleweatherapp.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import th.forge.simpleweatherapp.app.App;
import th.forge.simpleweatherapp.data.db.citieslist.CitiesListDB;
import th.forge.simpleweatherapp.data.db.citieslist.Location;

public class CitiesListRepository {
    private CitiesListDB db;
    private static CitiesListRepository citiesListRepository;

    private CitiesListRepository() {
        db = App.getDatabase();
    }

    public synchronized static CitiesListRepository getInstance() {
        if (citiesListRepository == null) {
            citiesListRepository = new CitiesListRepository();
        }
        return citiesListRepository;
    }

    public LiveData<List<Location>> getCitiesList() {
        final MutableLiveData<List<Location>> data = new MutableLiveData<>();
        data.setValue(db.locationDao().getAll());
        return data;
    }

    public void addCity(Location location){

    }
}
