package vp.com.mysecondmvpdemo.presenter;

import java.util.List;

import vp.com.mysecondmvpdemo.bean.ChinaCity;
import vp.com.mysecondmvpdemo.modelimpl.ChinaProData;
import vp.com.mysecondmvpdemo.model.IChinaProData;
import vp.com.mysecondmvpdemo.model.IXiaZaiChinaCitySuccess;
import vp.com.mysecondmvpdemo.view.ChinaCityView;

/**
 * Created by Administrator on 2017/3/29.
 */

public class ChinaCityPresenter {

    private ChinaCityView mChinaCityView;
    private IChinaProData mIChinaProData;

    public ChinaCityPresenter(ChinaCityView chinaCityView) {
        mChinaCityView = chinaCityView;
        mIChinaProData = new ChinaProData();
    }

    public void loadCityData(int id,int city){
        mIChinaProData.getChinaCityData(id, city, new IXiaZaiChinaCitySuccess() {
            @Override
            public void successFull(List<ChinaCity> lists) {
                mChinaCityView.loadCityData(lists);
            }

            @Override
            public void fail(Throwable throwable) {
                mChinaCityView.xiaZaiFail();
            }
        });
    }
}
