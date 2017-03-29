package vp.com.mysecondmvpdemo.view;

import java.util.List;

import vp.com.mysecondmvpdemo.bean.ChinaPro;

/**
 * Created by Administrator on 2017/3/28.
 */

public interface SuccessView {
    void loadChinaProData(List<ChinaPro> pros);
    void xiaFail();
}
