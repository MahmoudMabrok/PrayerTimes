package utitity.mahmoud.prayertimes.datalayer;

import android.app.Application;

import java.util.Map;

import retrofit2.Call;
import utitity.mahmoud.prayertimes.datalayer.local.room.DayPrayerDao;
import utitity.mahmoud.prayertimes.datalayer.local.room.DayPrayerItem;
import utitity.mahmoud.prayertimes.datalayer.local.room.PrayerDB;
import utitity.mahmoud.prayertimes.datalayer.model.PrayerRespose;
import utitity.mahmoud.prayertimes.datalayer.remote.ApiClient;
import utitity.mahmoud.prayertimes.datalayer.remote.PrayerService;

public class Repository {

    DayPrayerDao dayPrayerDao;
    static Repository repository = null;
    PrayerService prayerService;

    public Repository(Application application) {
        dayPrayerDao = PrayerDB.getInstance(application).getDayPrayerDao();
        prayerService = ApiClient.getRetrofitPrayer().create(PrayerService.class);
    }

    public static synchronized Repository getRepository(Application application) {
        if (repository == null) {
            repository = new Repository(application);
            //    dayPrayerDao = PrayerDB.getInstance(application).getDayPrayerDao();
        }

        return repository;
    }


    public void addDayPrayer(DayPrayerItem dayPrayerItem) {
        dayPrayerDao.addDayPrayer(dayPrayerItem);
    }

    public DayPrayerItem getPrayer(int year, int month, int day) {
        return dayPrayerDao.getPrayerByDay(year, month, day);
    }

    public Call<PrayerRespose> getPrayerResponse(Map<String, String> params) {
        return prayerService.getPrayerRespons(params);
    }


    public int getPrayerCount() {
        return dayPrayerDao.getCount();
    }
}
