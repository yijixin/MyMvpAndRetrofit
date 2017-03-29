package vp.com.mysecondmvpdemo.presenter;

import java.util.List;

import vp.com.mysecondmvpdemo.bean.ChinaPro;
import vp.com.mysecondmvpdemo.modelimpl.ChinaProData;
import vp.com.mysecondmvpdemo.model.IChinaProData;
import vp.com.mysecondmvpdemo.model.IXiaZaiSuccessFail;
import vp.com.mysecondmvpdemo.view.SuccessView;

/**
 * Created by Administrator on 2017/3/28.
 */

public class SuccessPresenter {

    private SuccessView mSuccessView;
    private IChinaProData mIChinaProData;

    public SuccessPresenter(SuccessView successView) {
        mSuccessView = successView;
        mIChinaProData = new ChinaProData();
    }

    public void loadChinaProData(){
        mIChinaProData.getChinaProData(new IXiaZaiSuccessFail() {
            @Override
            public void successFull(List<ChinaPro> lists) {
                mSuccessView.loadChinaProData(lists);
            }

            @Override
            public void fail(Throwable throwable) {
                mSuccessView.xiaFail();
            }
        });
    }
}
