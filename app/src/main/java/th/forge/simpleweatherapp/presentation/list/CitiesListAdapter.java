package th.forge.simpleweatherapp.presentation.list;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import th.forge.simpleweatherapp.BR;
import th.forge.simpleweatherapp.R;
import th.forge.simpleweatherapp.data.db.citieslist.Location;
import th.forge.simpleweatherapp.databinding.CitiesListItemBinding;

public class CitiesListAdapter extends RecyclerView.Adapter<CitiesListAdapter.CityViewHolder> {

    private List<Location> items;
    private CitiesListViewModel viewModel;

    //ToDo clickcallback

    public CitiesListAdapter() {
    }

    public void setLocations(List<Location> locations) {
        this.items = locations;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CitiesListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.cities_list_item,
                parent, false);
        return new CityViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }


    public class CityViewHolder extends RecyclerView.ViewHolder {
        final CitiesListItemBinding binding;

        public CityViewHolder(@NonNull CitiesListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Integer position) {
//            Location item = viewModel.getLocationAt(position);
            binding.setLocation(items.get(position));
            /*binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, position);*/
            binding.executePendingBindings();
        }
    }
}
