package vp.com.mysecondmvpdemo.modelimpl;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import vp.com.mysecondmvpdemo.api.ApiService;
import vp.com.mysecondmvpdemo.bean.ChinaCity;
import vp.com.mysecondmvpdemo.bean.ChinaPro;
import vp.com.mysecondmvpdemo.bean.Weather;
import vp.com.mysecondmvpdemo.model.IChinaProData;
import vp.com.mysecondmvpdemo.model.IWeatherSuccessFail;
import vp.com.mysecondmvpdemo.model.IXiaZaiChinaCitySuccess;
import vp.com.mysecondmvpdemo.model.IXiaZaiSuccessFail;

/**
 * Created by Administrator on 2017/3/28.
 */

public class ChinaProData implements IChinaProData {
    //下载省级数据
    @Override
    public void getChinaProData(final IXiaZaiSuccessFail iXiaZaiSuccessFail) {
        ApiService.getChinaProData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<ChinaPro>>() {
                    @Override
                    public void call(List<ChinaPro> pros) {
                        iXiaZaiSuccessFail.successFull(pros);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        iXiaZaiSuccessFail.fail(throwable);
                    }
                });
    }

    //下载城市数据
    @Override
    public void getChinaProCityData(int id, final IXiaZaiSuccessFail iXiaZaiSuccessFail) {
        ApiService.getChinaProCityData(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<ChinaPro>>() {
                    @Override
                    public void call(List<ChinaPro> pros) {
                        iXiaZaiSuccessFail.successFull(pros);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        iXiaZaiSuccessFail.fail(throwable);
                    }
                });
    }

    //下载城市天气id
    @Override
    public void getChinaCityData(int id, int city, final IXiaZaiChinaCitySuccess iXiaZaiChinaCitySuccess) {
        ApiService.getChinaCityData(id,city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<ChinaCity>>() {
                    @Override
                    public void call(List<ChinaCity> cities) {
                        iXiaZaiChinaCitySuccess.successFull(cities);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        iXiaZaiChinaCitySuccess.fail(throwable);
                    }
                });
    }

    //下载天气情况的数据
    @Override
    public void getCityWeatherData(String cityId, String key, final IWeatherSuccessFail iWeatherSuccessFail) {
        ApiService.getCityWeatherData(cityId, key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Weather>() {
                    @Override
                    public void call(Weather weather) {
                        iWeatherSuccessFail.successFull(weather);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        iWeatherSuccessFail.fail(throwable);
                    }
                });
    }
}
