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
import android.widget.Toast;

import androidx.navigation.Navigation;
import th.forge.simpleweatherapp.R;
import th.forge.simpleweatherapp.databinding.FragmentCurrentWeatherBinding;

public class CurrentWeatherFragment extends Fragment {

    public static final String KEY_LOC_NAME = "city_name";
    private CurrentWeatherViewModel viewModel;
    private FragmentCurrentWeatherBinding binding;
    private String cityName;

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
        if (getArguments() != null) {
            cityName = getArguments().getString(KEY_LOC_NAME);
        }
        //ToDo: add correct null handling
        if (cityName == null) {
            Toast.makeText(binding.getRoot().getContext(), "Select City", Toast.LENGTH_LONG).show();
            Navigation.findNavController(binding.getRoot()).navigate(R.id.citiesListFragment);
        }
        viewModel = ViewModelProviders.of(this,
                new CurrentWeatherViewModel.Factory(cityName))
                .get(CurrentWeatherViewModel.class);
        binding.setCurrentWeatherViewModel(viewModel);
        viewModel.getObservableWeather().observe(this, city -> {
            if (city != null) {
                viewModel.setCity(city);
            }
        });
    }
}
