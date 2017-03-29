package vp.com.mysecondmvpdemo.api;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;
import vp.com.mysecondmvpdemo.bean.ChinaCity;
import vp.com.mysecondmvpdemo.bean.ChinaPro;
import vp.com.mysecondmvpdemo.bean.Weather;

/**
 * Created by Administrator on 2017/3/28.
 */

public interface ApiManagerService {
    @GET("api/china")
    Observable<List<ChinaPro>> getChinaProData();

    @GET("api/china/{id}")
    Observable<List<ChinaPro>> getChinaProCityData(@Path("id") int id);

    @GET("api/china/{id}/{city}")
    Observable<List<ChinaCity>> getChinaCityData(@Path("id")int id,@Path("city")int city);

    @GET("api/weather")
    Observable<Weather> getCityWeather(@Query("cityid")String cityId, @Query("key")String key);

    @GET("api/bing_pic")
    Observable<String> getPicData();
}
