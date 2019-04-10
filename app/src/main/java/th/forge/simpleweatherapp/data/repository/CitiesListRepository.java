package th.forge.simpleweatherapp.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import th.forge.simpleweatherapp.app.App;
import th.forge.simpleweatherapp.data.db.citieslist.CitiesListDB;
import th.forge.simpleweatherapp.data.db.citieslist.Location;
import th.forge.simpleweatherapp.data.db.citieslist.LocationDao;

public class CitiesListRepository {
    private LocationDao locationDao;
    private LiveData<List<Location>> citiesList;
    private static CitiesListRepository citiesListRepository;

    private CitiesListRepository() {
        CitiesListDB db = App.getDatabase();
        locationDao = db.locationDao();
        citiesList = locationDao.getAll();
    }

    //ToDo: DI
    public synchronized static CitiesListRepository getInstance() {
        if (citiesListRepository == null) {
            citiesListRepository = new CitiesListRepository();
        }
        return citiesListRepository;
    }

    public LiveData<List<Location>> getCitiesList() {
        /*MutableLiveData<List<Location>> data = new MutableLiveData<>();
        data.setValue(locationDao.getAll());
        return data;*/
        return citiesList;
    }

    public void addCity(String cityName) {
        Location location = new Location();
        location.setName(cityName);
        locationDao.insert(location);
    }
}
