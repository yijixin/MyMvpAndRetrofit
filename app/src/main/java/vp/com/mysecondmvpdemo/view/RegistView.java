package vp.com.mysecondmvpdemo.view;

import vp.com.mysecondmvpdemo.bean.User;

/**
 * Created by Administrator on 2017/3/28.
 */

public interface RegistView {
    String getUserName();
    String getPassWord();

    void registSuccessToActivity(User user);
    void registError();

    void isNotEmpty();
}
