package utitity.mahmoud.prayertimes.feature;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import utitity.mahmoud.prayertimes.R;
import utitity.mahmoud.prayertimes.datalayer.model.Day;
import utitity.mahmoud.prayertimes.datalayer.model.PrayerRespose;
import utitity.mahmoud.prayertimes.util.Util;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PrayerRespose prayerRespose = Util.getPrayer(this);
        assert prayerRespose != null;
        for (Day day : prayerRespose.getDate().getFirstMonth()) {
            Log.d(TAG, "onCreate: " + day.getDate().getReadable());
        }
    }
}
