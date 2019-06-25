package utitity.mahmoud.prayertimes.feature.display_times;

import android.content.Intent;
import android.os.Bundle;
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

        initRv();
        try {
            int day = DateOperation.getCurrentDay();
            int month = DateOperation.getCurrentMonth();
            int year = DateOperation.getCurrentYear();
            DayPrayerItem dayPrayerItem = repository.getPrayer(year, month, day);
            loadData(dayPrayerItem);
            //  fillUI(dayPrayerItem);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadData(DayPrayerItem dayPrayerItem) {
        String[] times = getResources().getStringArray(R.array.times);
        timesAdapter.setValues(Arrays.asList(times), dayPrayerItem.getTimings().getValues());
        tvCurrentdate.setText(dayPrayerItem.getDayDate());
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
