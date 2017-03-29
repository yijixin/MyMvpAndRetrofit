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
import vp.com.mysecondmvpdemo.presenter.LoginPresenter;
import vp.com.mysecondmvpdemo.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private Button mBtnRegister;

    private LoginPresenter mLoginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassWord() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void loginSuccessToActivity(User user) {
        Intent intent = new Intent(MainActivity.this,SuccessFulActivity.class);
        intent.putExtra("name",user.getUserName());
        startActivity(intent);
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "不知道用户名和密码吧，赶紧注册去吧！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void isNotEmpty() {
        submit();
    }

    private void initView() {
        mEtUsername = (EditText) findViewById(R.id.et_username);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnRegister = (Button) findViewById(R.id.btn_register);

        mBtnLogin.setOnClickListener(this);
        mBtnRegister.setOnClickListener(this);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                mLoginPresenter.isEmpty();
                mLoginPresenter.login();
                break;
            case R.id.btn_register:
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void submit() {
        // validate
        String username = mEtUsername.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "username不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String password = mEtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "password不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
