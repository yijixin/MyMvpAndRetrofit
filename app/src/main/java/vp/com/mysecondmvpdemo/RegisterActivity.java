package vp.com.mysecondmvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import vp.com.mysecondmvpdemo.bean.User;
import vp.com.mysecondmvpdemo.presenter.RegistPresenter;
import vp.com.mysecondmvpdemo.view.RegistView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,RegistView {

    private EditText mEtRgUsername;
    private EditText mEtRgPassword;
    private Button mBtnRg;

    private static int num = 0;

    private RegistPresenter mRegistPresenter = new RegistPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        mEtRgUsername = (EditText) findViewById(R.id.et_rg_username);
        mEtRgPassword = (EditText) findViewById(R.id.et_rg_password);
        mBtnRg = (Button) findViewById(R.id.btn_rg);

        mBtnRg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_rg:
                mRegistPresenter.isEmpty();
                mRegistPresenter.regist(this);
                break;
        }
    }

    private void submit() {
        // validate
        String username = mEtRgUsername.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "username不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = mEtRgPassword.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "password不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    @Override
    public String getUserName() {
        return mEtRgUsername.getText().toString();
    }

    @Override
    public String getPassWord() {
        return mEtRgPassword.getText().toString();
    }

    @Override
    public void registSuccessToActivity(User user) {
        Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void registError() {
        if (num==0){
            Toast.makeText(this, "注册错了吧！其实注册名应该填为yjx,密码为123", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "别不信邪！注册名真的是yjx,密码为123", Toast.LENGTH_SHORT).show();
        }
        num++;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.BUTTON_BACK){
            finish();
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void isNotEmpty() {
        submit();
    }
}
