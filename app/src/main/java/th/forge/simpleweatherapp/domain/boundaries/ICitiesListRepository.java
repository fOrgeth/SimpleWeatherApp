package th.forge.simpleweatherapp.domain.boundaries;

import android.arch.lifecycle.LiveData;

import java.util.List;

import th.forge.simpleweatherapp.data.db.citieslist.Location;

public interface ICitiesListRepository {
    LiveData<List<Location>> getCitiesList();

    void addCity(Location location);
}
