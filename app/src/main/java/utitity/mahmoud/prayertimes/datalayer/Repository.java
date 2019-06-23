package utitity.mahmoud.prayertimes.datalayer;

import android.app.Application;

import utitity.mahmoud.prayertimes.datalayer.local.room.DayPrayerDao;
import utitity.mahmoud.prayertimes.datalayer.local.room.DayPrayerItem;
import utitity.mahmoud.prayertimes.datalayer.local.room.PrayerDB;

public class Repository {

    DayPrayerDao dayPrayerDao;

    public Repository(Application application) {
        dayPrayerDao = PrayerDB.getInstance(application).getDayPrayerDao();
    }

    public void addDayPrayer(DayPrayerItem dayPrayerItem) {
        dayPrayerDao.addDayPrayer(dayPrayerItem);
    }

    public DayPrayerItem getPrayer(int year, int month, int day) {
        return dayPrayerDao.getPrayerByDay(year, month, day);
    }

}
