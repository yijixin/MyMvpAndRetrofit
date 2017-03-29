package vp.com.mysecondmvpdemo.presenter;

import vp.com.mysecondmvpdemo.bean.User;
import vp.com.mysecondmvpdemo.model.ILoginSuccessFail;
import vp.com.mysecondmvpdemo.model.IUserBiz;
import vp.com.mysecondmvpdemo.modelimpl.UserBiz;
import vp.com.mysecondmvpdemo.view.LoginView;

/**
 * Created by Administrator on 2017/3/28.
 */

public class LoginPresenter {
    private LoginView mLoginView;
    private IUserBiz mUserBiz;

    public LoginPresenter(LoginView loginView) {
        mLoginView = loginView;
        mUserBiz = new UserBiz();
    }

    public void login(){
        mUserBiz.login(mLoginView.getUserName(), mLoginView.getPassWord(), new ILoginSuccessFail() {
            @Override
            public void loginSuccess(User user) {
                mLoginView.loginSuccessToActivity(user);
            }

            @Override
            public void loginFail() {
                mLoginView.loginError();
            }
        });
    }

    public void isEmpty(){
        mLoginView.isNotEmpty();
    }
}
