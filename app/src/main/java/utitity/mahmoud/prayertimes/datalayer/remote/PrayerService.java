package utitity.mahmoud.prayertimes.datalayer.remote;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import utitity.mahmoud.prayertimes.datalayer.model.PrayerRespose;

public interface PrayerService {

    /**
     * @param params
     * @return
     * @FieldMap parameters can only be used with form encoding. which is used only with GET
     * Querymap is used with GET
     */

    @GET("calendar")
    Call<PrayerRespose> getPrayerRespons(@QueryMap Map<String, String> params);

}
