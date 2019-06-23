package utitity.mahmoud.prayertimes.datalayer.local.room;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DayPrayerDao {

    @Insert
    public void addDayPrayer(DayPrayerItem item);

    @Update
    public void updateDayPrayer(DayPrayerItem item);

    @Query("select  * from prayers where day = :day and month = :month and year = :year")
    public DayPrayerItem getPrayerByDay(int year, int month, int day);

}
