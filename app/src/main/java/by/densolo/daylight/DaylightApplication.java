package by.densolo.daylight;

import android.app.Application;
import android.content.Context;

import org.acra.ACRA;
import org.acra.BuildConfig;
import org.acra.annotation.AcraCore;
import org.acra.annotation.AcraHttpSender;
import org.acra.sender.HttpSender;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

/**
 * Created by honzab on 6.2.2015.
 *
 * @author Modified by Denis Solonevich on 30.03.2020.
 */
@AcraCore(buildConfigClass = BuildConfig.class)
@AcraHttpSender(uri = "https://collector.tracepot.com/3f9b5d43", httpMethod = HttpSender.Method.POST)
public class DaylightApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        // The following line triggers the initialization of ACRA
        ACRA.init(this);
    }


}
