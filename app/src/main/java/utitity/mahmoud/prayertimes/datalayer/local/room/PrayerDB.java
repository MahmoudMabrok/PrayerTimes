package utitity.mahmoud.prayertimes.datalayer.local.room;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {DayPrayerItem.class}, version = 1)
@TypeConverters({TimingConverter.class})
public abstract class PrayerDB extends RoomDatabase {


    static PrayerDB instance;

    public static synchronized PrayerDB getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(application, PrayerDB.class, "prayer")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract DayPrayerDao getDayPrayerDao();

}
