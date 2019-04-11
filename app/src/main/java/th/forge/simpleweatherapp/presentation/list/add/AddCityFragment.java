package th.forge.simpleweatherapp.presentation.list.add;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.navigation.Navigation;
import th.forge.simpleweatherapp.R;
import th.forge.simpleweatherapp.databinding.FragmentAddCityBinding;

public class AddCityFragment extends Fragment {

    private AddCityViewModel viewModel;
    private FragmentAddCityBinding binding;

    private final SaveClickListener saveClickListener = (view, cityName) -> {
        viewModel.addCity(cityName);
        hideKeyboard(view);
        Navigation.findNavController(view).navigate(R.id.citiesListFragment);
    };

    private void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getRootView().getWindowToken(), 0);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_city, container, false);
        binding.setSaveCallback(saveClickListener);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(AddCityViewModel.class);
        // TODO: Use the ViewModel
    }

}
