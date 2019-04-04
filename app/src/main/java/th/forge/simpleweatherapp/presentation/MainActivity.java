package th.forge.simpleweatherapp.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th.forge.simpleweatherapp.R;
import th.forge.simpleweatherapp.app.App;
import th.forge.simpleweatherapp.data.repository.Entity.City;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "123");

        App.getApiService().getCurrentWeather("Moscow").enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                    }
                }
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {

            }
        });

    }
}
