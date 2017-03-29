package vp.com.mysecondmvpdemo.model;

import vp.com.mysecondmvpdemo.bean.Weather;

/**
 * Created by Administrator on 2017/3/29.
 */

public interface IWeatherSuccessFail {
    void successFull(Weather weather);

    void fail(Throwable throwable);
}
