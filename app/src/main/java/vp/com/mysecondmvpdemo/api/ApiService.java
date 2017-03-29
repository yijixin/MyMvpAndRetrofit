package vp.com.mysecondmvpdemo.api;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import vp.com.mysecondmvpdemo.bean.ChinaCity;
import vp.com.mysecondmvpdemo.bean.ChinaPro;
import vp.com.mysecondmvpdemo.bean.Weather;

/**
 * Created by Administrator on 2017/3/28.
 */

public class ApiService {
    private static final String CHINA_PATH = "http://guolin.tech/";

    private static final Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl(CHINA_PATH)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    private static final ApiManagerService API_MANAGER_SERVICE = mRetrofit.create(ApiManagerService.class);

    //获取省级数据
    public static Observable<List<ChinaPro>> getChinaProData(){
        return API_MANAGER_SERVICE.getChinaProData();
    }

    //获取城市数据
    public static Observable<List<ChinaPro>> getChinaProCityData(int id){
        return API_MANAGER_SERVICE.getChinaProCityData(id);
    }

    //获取城市天气编码id
    public static Observable<List<ChinaCity>> getChinaCityData(int id,int city){
        return API_MANAGER_SERVICE.getChinaCityData(id,city);
    }

    //获取城市天气状况
    public static Observable<Weather> getCityWeatherData(String cityId,String key){
        return API_MANAGER_SERVICE.getCityWeather(cityId,key);
    }

    //获取图片
    public static Observable<String> getPicData(){
        return API_MANAGER_SERVICE.getPicData();
    }
}
