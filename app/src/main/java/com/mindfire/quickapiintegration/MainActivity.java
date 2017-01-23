package com.mindfire.quickapiintegration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.magnet.android.mms.MagnetMobileClient;
import com.magnet.android.mms.async.Call;
import com.magnet.android.mms.exception.SchemaException;
import com.mindfire.quickapiintegration.controller.api.WeatherData;
import com.mindfire.quickapiintegration.controller.api.WeatherDataFactory;
import com.mindfire.quickapiintegration.model.beans.WeatherResult;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    private WeatherData mWeatherData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWeatherAPI();
        WeatherResult weather = null;
        try {
            weather = fetchWeather();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onCreate: " + weather.getSys().getMessage() + " " + weather.getMain().getTemp_max());
    }

    private WeatherResult fetchWeather() throws ExecutionException, InterruptedException {
        Call<WeatherResult> weatherCall = mWeatherData.getWeather("201301", "ec2d7002083aec3884e9ad313c30df8d", null);
        return weatherCall.get();
    }

    /**
     * Instantiate a controller
     *
     * @return Weather Result object
     */
    private void initWeatherAPI() {

        MagnetMobileClient magnetClient = MagnetMobileClient.getInstance(this);
        WeatherDataFactory controllerFactory = new WeatherDataFactory(magnetClient);
        try {
            mWeatherData = controllerFactory.obtainInstance();
        } catch (SchemaException e) {
            e.printStackTrace();
        }
    }

}
