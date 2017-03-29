package vp.com.mysecondmvpdemo.modelimpl;

import android.content.Context;

import vp.com.mysecondmvpdemo.bean.User;
import vp.com.mysecondmvpdemo.model.ILoginSuccessFail;
import vp.com.mysecondmvpdemo.model.IRegistSuccessFail;
import vp.com.mysecondmvpdemo.model.IUserBiz;

/**
 * Created by Administrator on 2017/3/28.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(String userName, String passWord, ILoginSuccessFail iLoginSuccessFail) {
        if ("yjx".equals(userName)&&"123".equals(passWord)){
            User user = new User();
            user.setUserName(userName);
            user.setPassWord(passWord);
            iLoginSuccessFail.loginSuccess(user);
        }else{
            iLoginSuccessFail.loginFail();
        }
    }

    @Override
    public void regist(String userName, String passWord, IRegistSuccessFail iRegistSuccessFail, Context context) {
        if ("yjx".equals(userName)&&"123".equals(passWord)){
            User user = new User();
            user.setUserName(userName);
            user.setPassWord(passWord);
            iRegistSuccessFail.registSuccess(user);
        }else{
            iRegistSuccessFail.registFail();
        }
    }
}
