package th.forge.simpleweatherapp.presentation.list.add;

import android.arch.lifecycle.ViewModel;

import th.forge.simpleweatherapp.data.repository.CitiesListRepository;

public class AddCityViewModel extends ViewModel {
    private CitiesListRepository citiesListRepository;

    public AddCityViewModel() {
        this.citiesListRepository = CitiesListRepository.getInstance();
    }

    public void addCity(String cityName) {
        citiesListRepository.addCity(cityName);
    }
}
