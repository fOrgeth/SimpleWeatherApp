package th.forge.simpleweatherapp.presentation;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import th.forge.simpleweatherapp.R;
import th.forge.simpleweatherapp.data.db.citieslist.Location;
import th.forge.simpleweatherapp.presentation.current.CurrentWeatherFragment;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private BottomNavigationView bottomNav;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "123");
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        toolbar = findViewById(R.id.toolbar);
        bottomNav = findViewById(R.id.bottom_nav);
        setSupportActionBar(toolbar);
        NavigationUI.setupWithNavController(bottomNav, navController);
        NavigationUI.setupActionBarWithNavController(this, navController);


    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, (DrawerLayout) null);
    }

    //ToDo: release navigation
    public void show(Location location) {
        CurrentWeatherFragment currentWeatherFragment = CurrentWeatherFragment.newInstance(location.getName());
        getSupportFragmentManager().beginTransaction()
                .addToBackStack("location")
                .replace(R.id.nav_host_fragment, currentWeatherFragment, null)
                .commit();
    }

}
