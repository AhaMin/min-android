package cn.aftsky.myapplication.widget;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.aftsky.myapplication.R;

/**
 * Created by MaoHonglu on 2018/3/23.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    @BindView(R.id.input_account) EditText _accountText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.btn_login) Button _loginButton;
    @BindView(R.id.link_signup) TextView _signupLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.link_signup)
    public void onClick(View v){
        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivityForResult(intent,REQUEST_SIGNUP);
    }
    @OnClick(R.id.btn_login)
    public void login(View v){
        Log.d(TAG,"Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("正在登录...");
        progressDialog.show();

        String account = _accountText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: 实现okHttp登录校验.

        //创建一个JAVA多线程消息的函数，实现3S一次的定时操作，根据okHttp的结果来判断登录成功或者登录失败
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    @Override
    public void onBackPressed() {
        // 防止用户关闭登录界面
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String account = _accountText.getText().toString();
        String password = _passwordText.getText().toString();

        if (account.isEmpty()) {
            _accountText.setError("请输入用户名！");
            valid = false;
        } else {
            _accountText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("密码的长度只能是4-6个字符之间");
            valid = false;
        } else {
            _passwordText.setError(null);
        }
        return valid;//true为表单校验成功，false为表单校验失败
    }
}
