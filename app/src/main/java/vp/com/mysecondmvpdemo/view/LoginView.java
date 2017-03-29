package vp.com.mysecondmvpdemo.view;

import vp.com.mysecondmvpdemo.bean.User;

/**
 * Created by Administrator on 2017/3/28.
 */

public interface LoginView {
    String getUserName();
    String getPassWord();

    void loginSuccessToActivity(User user);
    void loginError();

    void isNotEmpty();
}
