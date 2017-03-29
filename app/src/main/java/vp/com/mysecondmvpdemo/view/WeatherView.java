package vp.com.mysecondmvpdemo.view;

import vp.com.mysecondmvpdemo.bean.Weather;

/**
 * Created by Administrator on 2017/3/29.
 */

public interface WeatherView {
    void loadWeatherData(Weather weather);
    void loadFail();
}
