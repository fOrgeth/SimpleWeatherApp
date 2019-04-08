package th.forge.simpleweatherapp.data.db.citieslist;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface LocationDao {
    @Query("SELECT * FROM cities_list")
    List<Location> getAll();

    @Query("SELECT * FROM cities_list WHERE id = :id")
    Location getById(long id);

    @Insert
    void insert(Location location);

    @Delete
    void delete(Location location);

    @Update
    void update(Location location);
}
