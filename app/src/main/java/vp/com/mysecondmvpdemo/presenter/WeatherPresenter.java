package vp.com.mysecondmvpdemo.presenter;

import vp.com.mysecondmvpdemo.bean.Weather;
import vp.com.mysecondmvpdemo.model.IChinaProData;
import vp.com.mysecondmvpdemo.model.IWeatherSuccessFail;
import vp.com.mysecondmvpdemo.modelimpl.ChinaProData;
import vp.com.mysecondmvpdemo.view.WeatherView;

/**
 * Created by Administrator on 2017/3/29.
 */

public class WeatherPresenter {
    private IChinaProData mIChinaProData;
    private WeatherView mWeatherView;

    public WeatherPresenter(WeatherView weatherView) {
        mWeatherView = weatherView;
        mIChinaProData = new ChinaProData();
    }

    public void loadWeatherData(String cityId,String key){
        mIChinaProData.getCityWeatherData(cityId, key, new IWeatherSuccessFail() {
            @Override
            public void successFull(Weather weather) {
                mWeatherView.loadWeatherData(weather);
            }

            @Override
            public void fail(Throwable throwable) {
                mWeatherView.loadFail();
            }
        });
    }
}
