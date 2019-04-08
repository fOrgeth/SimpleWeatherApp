package th.forge.simpleweatherapp.presentation.current;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import th.forge.simpleweatherapp.R;
import th.forge.simpleweatherapp.databinding.FragmentCurrentWeatherBinding;

public class CurrentWeatherFragment extends Fragment {

    private CurrentWeatherViewModel viewModel;
    private FragmentCurrentWeatherBinding binding;
    private String weather;

    public static CurrentWeatherFragment newInstance() {
        return new CurrentWeatherFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_current_weather,
                container,
                false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this,
                new CurrentWeatherViewModel.Factory("Kazan"))
                .get(CurrentWeatherViewModel.class);
        binding.setCurrentWeatherViewModel(viewModel);
        viewModel.getObservableWeather().observe(this, city -> {
            if (city != null) {
                viewModel.setCity(city);
            }
        });

    }

    private void updateUI() {

    }

}
