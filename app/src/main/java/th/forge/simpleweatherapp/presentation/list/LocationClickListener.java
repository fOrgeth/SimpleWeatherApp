package th.forge.simpleweatherapp.presentation.list;

import android.view.View;

import th.forge.simpleweatherapp.data.db.citieslist.Location;

public interface LocationClickListener {
    void onClick(View view, Location location);
}
