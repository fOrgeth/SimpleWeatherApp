package th.forge.simpleweatherapp.data.retrofit;

import android.support.annotation.NonNull;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("data/2.5/weather?units=metric")
    Call<> getCurrentWeather(@NonNull @Query("q") String cityName);
}
