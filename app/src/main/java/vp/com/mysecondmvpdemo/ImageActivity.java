package vp.com.mysecondmvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import vp.com.mysecondmvpdemo.presenter.ImagePresenter;
import vp.com.mysecondmvpdemo.view.ImagePicView;

public class ImageActivity extends AppCompatActivity implements ImagePicView{

    private ImageView mIvPic;
    private ImagePresenter mImagePresenter = new ImagePresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        initView();
        mImagePresenter.loadDataPic();
    }

    private void initView() {
        mIvPic = (ImageView) findViewById(R.id.iv_pic);
    }

    @Override
    public void loadPicData(String sPic) {
        Glide.with(ImageActivity.this).load(sPic).into(mIvPic);
    }

    @Override
    public void loadFail() {
        Toast.makeText(this, "图片下载失败！！！", Toast.LENGTH_SHORT).show();
    }
}
