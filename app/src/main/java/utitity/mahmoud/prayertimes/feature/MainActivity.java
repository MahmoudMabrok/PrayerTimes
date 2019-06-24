package utitity.mahmoud.prayertimes.feature;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utitity.mahmoud.prayertimes.R;
import utitity.mahmoud.prayertimes.datalayer.Repository;
import utitity.mahmoud.prayertimes.datalayer.local.room.DayPrayerItem;
import utitity.mahmoud.prayertimes.datalayer.model.Data;
import utitity.mahmoud.prayertimes.datalayer.model.Day;
import utitity.mahmoud.prayertimes.datalayer.model.PrayerRespose;
import utitity.mahmoud.prayertimes.util.Util;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.tvCurrentdate)
    TextView tvCurrentdate;
    @BindView(R.id.tvFajr)
    TextView tvFajr;
    @BindView(R.id.tvShrooq)
    TextView tvShrooq;

    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Stetho.initializeWithDefaults(getApplication());

        PrayerRespose prayerRespose = Util.getPrayer(this);
        showMessage("aa");
        if (prayerRespose != null) {
            showMessage(String.valueOf(prayerRespose.getData().getFirstMonth() != null));
        }
        repository = new Repository(getApplication());


        try {
            try {
                fillDb(prayerRespose.getData());
                Log.d(TAG, "onCreate: after fill DB ");
            } catch (Exception e) {
                e.printStackTrace();
            }
            int day = 25;
            int month = 1;
            int year = 2019;
            DayPrayerItem dayPrayerItem = repository.getPrayer(year, month, day);

            Log.d(TAG, "onCreate: after retrieve " + String.valueOf(dayPrayerItem == null));
            fillUI(dayPrayerItem);


        } catch (Exception e) {
            e.printStackTrace();
        }


        repository = new Repository(getApplication());

        Map<String, String> params = new HashMap<>();
        params.put("annual", String.valueOf(true));
        params.put("year", String.valueOf(2019));
        params.put("latitude", String.valueOf(30.5));
        params.put("longitude", String.valueOf(35.5));

        repository.getPrayerResponse(params).enqueue(new Callback<PrayerRespose>() {
            @Override
            public void onResponse(Call<PrayerRespose> call, Response<PrayerRespose> response) {
                //  Log.d(TAG, "onResponse: called" + response.message());
                //   Log.d(TAG, "onResponse: qqq " + response.raw().toString());
                PrayerRespose prayerRespose1 = response.body();
                try {
                    Log.d(TAG, "onResponse: " + prayerRespose1.getData().getFirstMonth().size());

                    Day day = prayerRespose1.getData().getFirstMonth().get(0);
                    Log.d(TAG, "onResponse: ## " + day.getTimings().getAsr());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<PrayerRespose> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }


    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void fillDb(Data date) {

        Log.d(TAG, "fillDb: size  " + date.getFirstMonth().size());
        for (Day dayObj : date.getFirstMonth()) {
            String dayStr = dayObj.getDate().getGregorian().getDate();
            String[] parts = dayStr.split("-");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            //    Log.d(TAG, "fillDb: day " + day);

            DayPrayerItem dayPrayerItem = new DayPrayerItem();
            dayPrayerItem.setDay(day);
            dayPrayerItem.setMonth(month);
            dayPrayerItem.setYear(year);
            dayPrayerItem.setDayDate(dayStr);
            dayPrayerItem.setTimings(dayObj.getTimings());

            try {
                repository.addDayPrayer(dayPrayerItem);
                //      Log.d(TAG, "fillDb: " + dayPrayerItem.toString());
            } catch (Exception e) {
                // e.printStackTrace();
            }


        }


    }

    private void fillUI(DayPrayerItem dayPrayerItem) {
        Log.d(TAG, "fillUI: ");
        tvCurrentdate.setText(dayPrayerItem.getDayDate());
        tvFajr.setText(dayPrayerItem.getTimings().getFajr());
        tvShrooq.setText(dayPrayerItem.getTimings().getSunrise());
    }
}
