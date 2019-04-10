package th.forge.simpleweatherapp.data.db.citieslist;

import android.content.Context;

import th.forge.simpleweatherapp.R;
import th.forge.simpleweatherapp.app.App;

public class Sample {
    public static void fillDb(Context context) {
        CitiesListDB db = App.getDatabase();
        LocationDao dao = db.locationDao();
        String[] cities = context.getResources().getStringArray(R.array.cities_list);
        for (String city : cities) {
            Location location = new Location();
            location.setName(city);
            dao.insert(location);
        }
    }
}
