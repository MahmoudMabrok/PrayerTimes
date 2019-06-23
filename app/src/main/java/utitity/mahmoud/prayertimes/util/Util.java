package utitity.mahmoud.prayertimes.util;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import utitity.mahmoud.prayertimes.datalayer.model.PrayerRespose;

public class Util {

    public static PrayerRespose getPrayer(Context context) {
        try {
            InputStream fileIn = context.getAssets().open("response.json");
            BufferedInputStream bufferedIn = new BufferedInputStream(fileIn);
            Reader reader = new InputStreamReader(bufferedIn, Charset.forName("UTF-8"));
            return new Gson().fromJson(reader, PrayerRespose.class);
        } catch (Exception e) {
            return null;
        }
    }
}
