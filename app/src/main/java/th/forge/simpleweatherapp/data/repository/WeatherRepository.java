package th.forge.simpleweatherapp.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th.forge.simpleweatherapp.app.App;
import th.forge.simpleweatherapp.data.repository.entity.City;
import th.forge.simpleweatherapp.data.retrofit.ApiService;

public class WeatherRepository {
    private ApiService apiService;
    private static WeatherRepository weatherRepository;

    private WeatherRepository() {
        apiService = App.getApiService();
    }

    public synchronized static WeatherRepository getInstance() {
        if (weatherRepository == null) {
            weatherRepository = new WeatherRepository();
        }
        return weatherRepository;
    }

    public LiveData<City> getWeather(String cityName) {
        final MutableLiveData<City> currentWeather = new MutableLiveData<>();
        apiService.getCurrentWeather(cityName).enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                currentWeather.setValue(response.body());
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {

            }
        });
        return currentWeather;
    }
}
