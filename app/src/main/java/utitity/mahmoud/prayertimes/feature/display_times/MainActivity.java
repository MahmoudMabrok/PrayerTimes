package utitity.mahmoud.prayertimes.feature.display_times;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utitity.mahmoud.prayertimes.R;
import utitity.mahmoud.prayertimes.datalayer.Repository;
import utitity.mahmoud.prayertimes.datalayer.local.room.DayPrayerItem;
import utitity.mahmoud.prayertimes.feature.setting.Setting;
import utitity.mahmoud.prayertimes.util.DateOperation;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.tvCurrentdate)
    TextView tvCurrentdate;
    @BindView(R.id.btnOpenSetting)
    Button btnOpenSetting;
    @BindView(R.id.rvTimes)
    RecyclerView rvTimes;
    TimesAdapter timesAdapter;
    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Stetho.initializeWithDefaults(getApplication());
        repository = new Repository(getApplication());
        initRv();


    }

    @Override
    protected void onResume() {
        super.onResume();
        load();
    }

    private void load() {
        try {
            int day = DateOperation.getCurrentDay();
            int month = DateOperation.getCurrentMonth();
            int year = DateOperation.getCurrentYear();
            DayPrayerItem dayPrayerItem = repository.getPrayer(year, month, day);
            Log.d(TAG, "current data : month " + month);
            loadData(dayPrayerItem);
        } catch (Exception e) {
            e.printStackTrace();
            showMessage("please download data from setting ^_^");
        }
    }

    private void loadData(DayPrayerItem dayPrayerItem) {
        if (dayPrayerItem != null) {
            String[] times = getResources().getStringArray(R.array.times);
            timesAdapter.setValues(Arrays.asList(times), dayPrayerItem.getTimings().getValues());
            tvCurrentdate.setText(dayPrayerItem.getDayDate());
            Log.d(TAG, "loadData: data exist ");
        }
        Log.d(TAG, "loaded Data: " + dayPrayerItem.getDayDate());
    }

    private void initRv() {
        timesAdapter = new TimesAdapter();
        rvTimes.setAdapter(timesAdapter);
    }


    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnOpenSetting)
    public void onViewClicked() {
        Intent openAcivity = new Intent(MainActivity.this, Setting.class);
        startActivity(openAcivity);
    }
}
