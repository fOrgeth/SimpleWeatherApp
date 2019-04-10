package th.forge.simpleweatherapp.presentation.list;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import th.forge.simpleweatherapp.data.db.citieslist.Location;
import th.forge.simpleweatherapp.data.repository.CitiesListRepository;

public class CitiesListViewModel extends ViewModel {

    private final LiveData<List<Location>> locationListObservable;

    public CitiesListViewModel() {
        this.locationListObservable = CitiesListRepository.getInstance().getCitiesList();
    }

    public LiveData<List<Location>> getLocationListObservable() {
        return locationListObservable;
    }

    public Location getLocationAt(Integer position) {
        return new Location();
    }
}
