package utitity.mahmoud.prayertimes.feature;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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

        PrayerRespose prayerRespose = Util.getPrayer(this);
        assert prayerRespose != null;

        Day day = prayerRespose.getDate().getFirstMonth().get(0);
        fillUI(day);


        repository = new Repository(getApplication());

        Map<String, String> params = new HashMap<>();
        params.put("annual", String.valueOf(true));
        params.put("year", String.valueOf(2019));

        repository.getPrayerResponse(params).enqueue(new Callback<PrayerRespose>() {
            @Override
            public void onResponse(Call<PrayerRespose> call, Response<PrayerRespose> response) {
                if (call.isExecuted()) {
                    Log.d(TAG, "onResponse: after excuted");
                    PrayerRespose respose = response.body();
                    assert respose != null;
                    Log.d(TAG, "onResponse: not null ");
                    Day day1 = respose.getDate().get_6().get(23);
                    fillUI(day1);


                }
            }

            @Override
            public void onFailure(Call<PrayerRespose> call, Throwable t) {

            }
        });
    }

    private void fillUI(Day day) {

        tvCurrentdate.setText(day.getDate().getReadable());

        tvFajr.setText(day.getTimings().getFajr());
        tvShrooq.setText(day.getTimings().getSunrise());
    }
}
