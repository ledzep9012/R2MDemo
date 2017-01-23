/**
 * File generated by Magnet rest2mobile 1.1 - Jan 23, 2017 1:59:27 PM
 * @see {@link http://developer.magnet.com}
 */

package com.mindfire.quickapiintegration.controller.api;

import com.magnet.android.mms.async.Call;
import com.magnet.android.mms.async.StateChangedListener;

import com.mindfire.quickapiintegration.model.beans.*;

public interface WeatherData {

  /**
   * Generated from URL GET http://api.openweathermap.org/data/2.5/weather?zip=110006&appid=ec2d7002083aec3884e9ad313c30df8d
   * GET data/2.5/weather
   * @param zip  style:QUERY
   * @param appid  style:QUERY
   * @param listener
   * @return WeatherResult
   */
  Call<WeatherResult> getWeather(
     String zip,
     String appid,
     StateChangedListener listener
  );


}