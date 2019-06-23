package utitity.mahmoud.prayertimes.feature;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import utitity.mahmoud.prayertimes.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        PrayerRespose prayerRespose = Util.getPrayer(this);
        assert prayerRespose != null;

        Day day = prayerRespose.getDate().getFirstMonth().get(0);
        fillUI(day);
    }

    private void fillUI(Day day) {

        tvCurrentdate.setText(day.getDate().getReadable());

        tvFajr.setText(day.getTimings().getFajr());
        tvShrooq.setText(day.getTimings().getSunrise());
    }
}
