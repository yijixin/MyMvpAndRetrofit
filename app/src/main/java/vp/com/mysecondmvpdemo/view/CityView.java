package vp.com.mysecondmvpdemo.view;

import java.util.List;

import vp.com.mysecondmvpdemo.bean.ChinaPro;

/**
 * Created by Administrator on 2017/3/29.
 */

public interface CityView {
    void loadCityData(List<ChinaPro> pros);
    void xiaZaiFail();
}
