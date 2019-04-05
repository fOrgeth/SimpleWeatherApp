package th.forge.simpleweatherapp.presentation.current;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import th.forge.simpleweatherapp.R;
import th.forge.simpleweatherapp.app.App;
import th.forge.simpleweatherapp.data.repository.entity.City;

public class CurrentWeatherFragment extends Fragment {

    private CurrentWeatherViewModel mViewModel;
    private TextView tv;
    private String weather;

    public static CurrentWeatherFragment newInstance() {
        return new CurrentWeatherFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.current_weather_fragment, container, false);
        tv = view.findViewById(R.id.textView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel.class);
        // TODO: Use the ViewModel
        App.getApiService().getCurrentWeather("Moscow").enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        weather = response.body().toString();
                        updateUI();
                        Log.d("FragmentCurrent", "123");
                    }
                }
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Log.d("FragmentCurrent", "456");
            }
        });
    }

    private void updateUI() {

        tv.setText(weather);
        tv.postInvalidateDelayed(200);
    }

}
