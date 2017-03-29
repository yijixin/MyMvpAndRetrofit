package vp.com.mysecondmvpdemo.model;

import java.util.List;

import vp.com.mysecondmvpdemo.bean.ChinaPro;

/**
 * Created by Administrator on 2017/3/28.
 */

public interface IXiaZaiSuccessFail {
    void successFull(List<ChinaPro> lists);

    void fail(Throwable throwable);
}
