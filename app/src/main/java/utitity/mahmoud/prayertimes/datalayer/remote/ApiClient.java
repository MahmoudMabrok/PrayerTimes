package utitity.mahmoud.prayertimes.datalayer.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String prayerUrl = "http://api.aladhan.com/v1/";

    static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static Retrofit retrofitPrayer = null;

    public static synchronized Retrofit getRetrofitPrayer() {
        if (retrofitPrayer == null) {
            retrofitPrayer = new Retrofit.Builder()
                    .baseUrl(prayerUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofitPrayer;
    }

}
