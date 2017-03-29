package vp.com.mysecondmvpdemo.presenter;

import java.util.List;

import vp.com.mysecondmvpdemo.bean.ChinaPro;
import vp.com.mysecondmvpdemo.modelimpl.ChinaProData;
import vp.com.mysecondmvpdemo.model.IChinaProData;
import vp.com.mysecondmvpdemo.model.IXiaZaiSuccessFail;
import vp.com.mysecondmvpdemo.view.CityView;

/**
 * Created by Administrator on 2017/3/29.
 */

public class CityPresenter {
    private CityView mCityView;
    private IChinaProData mIChinaProData;

    public CityPresenter(CityView cityView) {
        mCityView = cityView;
        mIChinaProData = new ChinaProData();
    }

    public void loadCityData(int id){
        mIChinaProData.getChinaProCityData(id, new IXiaZaiSuccessFail() {
            @Override
            public void successFull(List<ChinaPro> lists) {
                mCityView.loadCityData(lists);
            }

            @Override
            public void fail(Throwable throwable) {
                mCityView.xiaZaiFail();
            }
        });
    }
}
