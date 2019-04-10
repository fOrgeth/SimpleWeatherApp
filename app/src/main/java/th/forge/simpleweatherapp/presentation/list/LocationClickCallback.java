package th.forge.simpleweatherapp.presentation.list;

import android.view.View;

import th.forge.simpleweatherapp.data.db.citieslist.Location;

public interface LocationClickCallback {
    void onClick(View view, Location location);
}
