package th.forge.simpleweatherapp.presentation.current;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class CurrentWeatherViewModelFactory implements ViewModelProvider.Factory {
    private final String cityName;

    public CurrentWeatherViewModelFactory(String cityName) {
        this.cityName = cityName;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CurrentWeatherViewModel(cityName);
    }
}
