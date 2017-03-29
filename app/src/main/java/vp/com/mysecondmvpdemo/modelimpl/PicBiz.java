package vp.com.mysecondmvpdemo.modelimpl;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import vp.com.mysecondmvpdemo.api.ApiService;
import vp.com.mysecondmvpdemo.model.IPicBiz;
import vp.com.mysecondmvpdemo.model.IPicSuccess;

/**
 * Created by Administrator on 2017/3/29.
 */

public class PicBiz implements IPicBiz{
    @Override
    public void picData(final IPicSuccess iPicSuccess) {
        ApiService.getPicData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        iPicSuccess.picSuccess(s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                        iPicSuccess.picFail();
                    }
                });
    }
}
