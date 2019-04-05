package th.forge.simpleweatherapp.data.retrofit;

import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import th.forge.simpleweatherapp.data.repository.entity.City;

public interface ApiService {
    @GET("data/2.5/weather?units=metric")
    Call<City> getCurrentWeather(@NonNull @Query("q") String cityName);
}
