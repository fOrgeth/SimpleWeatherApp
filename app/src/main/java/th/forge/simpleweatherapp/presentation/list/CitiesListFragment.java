package th.forge.simpleweatherapp.presentation.list;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;
import th.forge.simpleweatherapp.R;
import th.forge.simpleweatherapp.databinding.FragmentCitiesListBinding;

import static th.forge.simpleweatherapp.presentation.current.CurrentWeatherFragment.KEY_LOC_NAME;

public class CitiesListFragment extends Fragment {

    private CitiesListViewModel viewModel;
    private FragmentCitiesListBinding binding;
    private CitiesListAdapter citiesAdapter;

    private final LocationClickListener locationClickListener = (view, location) -> {
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            Bundle args = new Bundle();
            args.putString(KEY_LOC_NAME, location.getName());
            Navigation.findNavController(view).navigate(R.id.action_citiesListFragment_to_currentWeatherFragment, args);
        }
    };

    private final LocationDeleteListener deleteListener = (long id) -> {
        viewModel.deleteLocation(id);
        return false;
    };

    private final FabClickListener fabClickListener = view -> {
        Navigation.findNavController(view).navigate(R.id.action_citiesListFragment_to_addCityFragment);
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cities_list, container, false);
        citiesAdapter = new CitiesListAdapter(locationClickListener, deleteListener);
        binding.citiesRv.setAdapter(citiesAdapter);
        binding.setFabCallback(fabClickListener);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(CitiesListViewModel.class);
        binding.setViewModel(viewModel);
        observeViewModel(viewModel);
    }

    private void observeViewModel(CitiesListViewModel viewModel) {
        viewModel.getLocationListObservable().observe(this, cities -> {
            if (cities != null) {
                citiesAdapter.setLocations(cities);
            }
        });
    }

}
