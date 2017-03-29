package vp.com.mysecondmvpdemo.model;

/**
 * Created by Administrator on 2017/3/28.
 */

public interface IChinaProData {
    void getChinaProData(IXiaZaiSuccessFail iXiaZaiSuccessFail);

    void getChinaProCityData(int id,IXiaZaiSuccessFail iXiaZaiSuccessFail);

    void getChinaCityData(int id,int city,IXiaZaiChinaCitySuccess iXiaZaiChinaCitySuccess);

    void getCityWeatherData(String cityId,String key,IWeatherSuccessFail iWeatherSuccessFail);
}
