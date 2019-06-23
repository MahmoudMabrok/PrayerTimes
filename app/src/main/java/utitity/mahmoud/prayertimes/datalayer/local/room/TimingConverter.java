package utitity.mahmoud.prayertimes.datalayer.local.room;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import androidx.room.TypeConverter;
import utitity.mahmoud.prayertimes.datalayer.model.Timings;

public class TimingConverter {

    @TypeConverter
    public String fromTimingToString(Timings timings) {
        if (timings == null) {
            return null;
        }
        // create json
        Gson gson = new Gson();
        Type type = new TypeToken<Timings>() {
        }.getType();
        return gson.toJson(timings, type);
    }

    @TypeConverter
    public Timings toTimings(String timings) {
        if (timings == null) {
            return null;
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Timings>() {
        }.getType();
        return gson.fromJson(timings, type);

    }


}
