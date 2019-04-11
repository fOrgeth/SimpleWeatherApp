package th.forge.simpleweatherapp.data.db.citieslist;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "cities_list")
public class Location {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
