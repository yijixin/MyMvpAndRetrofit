package vp.com.mysecondmvpdemo.view;

import java.util.List;

import vp.com.mysecondmvpdemo.bean.ChinaCity;

/**
 * Created by Administrator on 2017/3/29.
 */

public interface ChinaCityView {
    void loadCityData(List<ChinaCity> pros);
    void xiaZaiFail();
}
