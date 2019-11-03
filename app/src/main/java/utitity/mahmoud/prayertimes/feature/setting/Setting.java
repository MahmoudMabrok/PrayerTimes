package utitity.mahmoud.prayertimes.feature.setting;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import utitity.mahmoud.prayertimes.R;
import utitity.mahmoud.prayertimes.datalayer.Repository;
import utitity.mahmoud.prayertimes.datalayer.local.room.DayPrayerItem;
import utitity.mahmoud.prayertimes.datalayer.model.Data;
import utitity.mahmoud.prayertimes.datalayer.model.Day;
import utitity.mahmoud.prayertimes.datalayer.model.PrayerRespose;
import utitity.mahmoud.prayertimes.util.DateOperation;

public class Setting extends AppCompatActivity {

    private static final String TAG = "Setting";

    @BindView(R.id.btnGetData)
    Button btnGetData;

    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        repository = new Repository(getApplication());


    }

    @OnClick(R.id.btnGetData)
    public void onViewClicked() {
        controlButton(false);
        int prayerCount = repository.getPrayerCount();
        if (prayerCount == 0) {
            showMessage("Start Loading");
            // get Location data
            String langitude = "30.5";
            String longitude = "35.5";

            // get year
            int year = DateOperation.getCurrentYear();
            Log.d(TAG, "onViewClicked: year" + year);

            // call api
            // prepare params
            Map<String, String> params = new HashMap<>();
            params.put("annual", String.valueOf(true));
            params.put("year", String.valueOf(year));
            params.put("latitude", langitude);
            params.put("longitude", longitude);
            // make call
            repository.getPrayerResponse(params).enqueue(new Callback<PrayerRespose>() {
                @Override
                public void onResponse(Call<PrayerRespose> call, Response<PrayerRespose> response) {
                    if (response.isSuccessful()) {
                        Log.d(TAG, "onResponse: success");
                        controlButton(true);
                        try {

                            PrayerRespose respose = response.body();
                            storeInDb(respose);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }

                @Override
                public void onFailure(Call<PrayerRespose> call, Throwable t) {
                    Log.d(TAG, "onFailure: " + t.getMessage());
                    controlButton(true);
                }
            });
        } else {
            showMessage("Data Exist, no need to download it again ");
            controlButton(true);
        }

    }

    private void controlButton(boolean b) {
        btnGetData.setEnabled(b);
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void storeInDb(PrayerRespose respose) {
        // make async task call
        new StoreAsync().execute(respose.getData());
    }


    private class StoreAsync extends AsyncTask<Data, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: ");

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(TAG, "onPostExecute: ");
            showMessage("Finish Loading ");
        }

        @Override
        protected Void doInBackground(Data... data) {
            if (data[0] != null) {
                Log.d(TAG, "doInBackground: *");
                // data -> represent data of all the year, then store each month
                storeMonth(data[0].getFirstMonth());
                storeMonth(data[0].getSecondMonth());
                storeMonth(data[0].get_3());
                storeMonth(data[0].get_4());
                storeMonth(data[0].get_5());
                storeMonth(data[0].get_6());
                storeMonth(data[0].get_11());
                Log.d(TAG, "doInBackground: **");
            }
            return null;
        }

        private void storeMonth(List<Day> monthData) {
            Log.d(TAG, "storeMonth: n == " + monthData.size());
            for (Day dayObj : monthData) {
                // prepare dayPrayer data
                String dayStr = dayObj.getDate().getGregorian().getDate();
                String[] parts = dayStr.split("-");
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                DayPrayerItem dayPrayerItem = new DayPrayerItem();
                dayPrayerItem.setDay(day);
                dayPrayerItem.setMonth(month);
                dayPrayerItem.setYear(year);
                dayPrayerItem.setDayDate(dayStr);
                dayPrayerItem.setTimings(dayObj.getTimings());
                try {
                    repository.addDayPrayer(dayPrayerItem);
                } catch (Exception e) {
                    // if it already added before.
                    e.printStackTrace();
                }
            }
        }
    }
}
