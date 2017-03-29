package vp.com.mysecondmvpdemo.presenter;

import android.content.Context;

import vp.com.mysecondmvpdemo.bean.User;
import vp.com.mysecondmvpdemo.model.IRegistSuccessFail;
import vp.com.mysecondmvpdemo.model.IUserBiz;
import vp.com.mysecondmvpdemo.modelimpl.UserBiz;
import vp.com.mysecondmvpdemo.view.RegistView;

/**
 * Created by Administrator on 2017/3/28.
 */

public class RegistPresenter {
    private RegistView mRegistView;
    private IUserBiz mUserBiz;

    public RegistPresenter(RegistView registView) {
        mRegistView = registView;
        mUserBiz = new UserBiz();
    }

    public void regist(Context context){
        mUserBiz.regist(mRegistView.getUserName(), mRegistView.getPassWord(), new IRegistSuccessFail() {
            @Override
            public void registSuccess(User user) {
                mRegistView.registSuccessToActivity(user);
            }

            @Override
            public void registFail() {
                mRegistView.registError();
            }
        },context);
    }

    public void isEmpty(){
        mRegistView.isNotEmpty();
    }
}
