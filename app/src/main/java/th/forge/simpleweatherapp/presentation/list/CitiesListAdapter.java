package th.forge.simpleweatherapp.presentation.list;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import th.forge.simpleweatherapp.BR;
import th.forge.simpleweatherapp.data.db.citieslist.Location;

public class CitiesListAdapter extends RecyclerView.Adapter<CitiesListAdapter.CityViewHolder> {

    private List<Location> items;
    private CitiesListViewModel viewModel;

    public CitiesListAdapter(List<Location> items, CitiesListViewModel viewModel) {
        this.items = items;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new CityViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        holder.bind(viewModel, position);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public class CityViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        public CityViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(CitiesListViewModel viewModel, Integer position) {
            Location item = viewModel.getLocationAt(position);
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, position);
            binding.executePendingBindings();
        }
    }
}
