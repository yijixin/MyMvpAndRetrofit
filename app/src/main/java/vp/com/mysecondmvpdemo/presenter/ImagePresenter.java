package vp.com.mysecondmvpdemo.presenter;

import vp.com.mysecondmvpdemo.model.IPicBiz;
import vp.com.mysecondmvpdemo.model.IPicSuccess;
import vp.com.mysecondmvpdemo.modelimpl.PicBiz;
import vp.com.mysecondmvpdemo.view.ImagePicView;

/**
 * Created by Administrator on 2017/3/29.
 */

public class ImagePresenter {
    private ImagePicView mImagePicView;
    private IPicBiz mIPicBiz;

    public ImagePresenter(ImagePicView imagePicView) {
        mImagePicView = imagePicView;
        mIPicBiz = new PicBiz();
    }

    public void loadDataPic(){
        mIPicBiz.picData(new IPicSuccess() {
            @Override
            public void picSuccess(String strPic) {
                mImagePicView.loadPicData(strPic);
            }

            @Override
            public void picFail() {
                mImagePicView.loadFail();
            }
        });
    }
}
