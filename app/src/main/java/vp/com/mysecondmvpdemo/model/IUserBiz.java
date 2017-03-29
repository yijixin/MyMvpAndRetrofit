package vp.com.mysecondmvpdemo.model;

import android.content.Context;

/**
 * Created by Administrator on 2017/3/28.
 */

public interface IUserBiz {
    void login(String userName,String passWord,ILoginSuccessFail iLoginSuccessFail);

    void regist(String userName, String passWord, IRegistSuccessFail iRegistSuccessFail, Context context);
}
