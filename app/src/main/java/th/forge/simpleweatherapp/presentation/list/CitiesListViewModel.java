package th.forge.simpleweatherapp.presentation.list;

import android.arch.lifecycle.ViewModel;

import th.forge.simpleweatherapp.data.db.citieslist.Location;

public class CitiesListViewModel extends ViewModel {

    private CitiesListAdapter adapter;

    CitiesListAdapter getAdapter(){
        return adapter;
    }

    public Location getLocationAt(Integer position){
        return new Location();
    }
}
