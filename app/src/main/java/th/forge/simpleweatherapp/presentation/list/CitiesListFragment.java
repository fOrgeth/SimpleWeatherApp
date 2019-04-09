package th.forge.simpleweatherapp.presentation.list;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
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
import th.forge.simpleweatherapp.databinding.FragmentCitiesListBinding;
import th.forge.simpleweatherapp.presentation.MainActivity;

public class CitiesListFragment extends Fragment {

    private CitiesListViewModel viewModel;
    private FragmentCitiesListBinding binding;
    private CitiesListAdapter citiesAdapter;

    public static CitiesListFragment newInstance() {
        return new CitiesListFragment();
    }

    private final LocationClickCallback locationClickCallback = location -> {
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            ((MainActivity)getActivity()).show(location);
        }
    };

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cities_list, container, false);
        citiesAdapter = new CitiesListAdapter(locationClickCallback);
        binding.citiesRv.setAdapter(citiesAdapter);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(CitiesListViewModel.class);
        /*if (savedInstanceState == null) {
            viewModel.init();
        }*/
        //ToDo
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
