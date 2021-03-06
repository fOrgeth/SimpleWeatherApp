package th.forge.simpleweatherapp.presentation.current;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import th.forge.simpleweatherapp.data.repository.CitiesListRepository;
import th.forge.simpleweatherapp.data.repository.WeatherRepository;
import th.forge.simpleweatherapp.data.db.weather.entity.City;

public class CurrentWeatherViewModel extends ViewModel {
    private final LiveData<City> weatherObservable;
    public ObservableField<City> city = new ObservableField<>();
    //ToDO: add state

    private CurrentWeatherViewModel(String cityName) {
        /*if (cityName == null) {
            CitiesListRepository cr= CitiesListRepository.getInstance();
            cityName = cr.getCitiesList().getValue().get(0).getName();
        }*/
        weatherObservable = WeatherRepository.getInstance().getWeather(cityName);
    }

    public LiveData<City> getObservableWeather() {
        return weatherObservable;
    }

    public void setCity(City city) {
        this.city.set(city);
    }

    public static class Factory implements ViewModelProvider.Factory {
        private final String cityName;

        public Factory(String cityName) {
            this.cityName = cityName;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new CurrentWeatherViewModel(cityName);
        }
    }
}
