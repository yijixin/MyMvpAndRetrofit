package vp.com.mysecondmvpdemo.model;

import java.util.List;

import vp.com.mysecondmvpdemo.bean.ChinaCity;

/**
 * Created by Administrator on 2017/3/29.
 */

public interface IXiaZaiChinaCitySuccess {
    void successFull(List<ChinaCity> lists);

    void fail(Throwable throwable);
}
