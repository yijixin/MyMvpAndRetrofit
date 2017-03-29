package vp.com.mysecondmvpdemo.model;

import vp.com.mysecondmvpdemo.bean.User;

/**
 * Created by Administrator on 2017/3/28.
 */

public interface IRegistSuccessFail {
    void registSuccess(User user);
    void registFail();
}
