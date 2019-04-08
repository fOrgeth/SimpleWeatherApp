package th.forge.simpleweatherapp.presentation.list;

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

public class CitiesListFragment extends Fragment {

    private CitiesListViewModel viewModel;
    private FragmentCitiesListBinding binding;

    public static CitiesListFragment newInstance() {
        return new CitiesListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cities_list, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(CitiesListViewModel.class);
        binding.citiesRv.setAdapter(viewModel.getAdapter());
        //ToDo
    }

}
