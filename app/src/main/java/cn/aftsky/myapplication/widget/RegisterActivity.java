package cn.aftsky.myapplication.widget;

import android.app.ProgressDialog;
import android.os.Bundle;
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

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";

    @BindView(R.id.input_reg_account) EditText _inputRegAccount;
    @BindView(R.id.input_reg_password) EditText _inputRegPassword;
    @BindView(R.id.confirm_input_reg_password) EditText _confirmInputRegPassword;
    @BindView(R.id.btn_signup) Button _btnSignUp;
    @BindView(R.id.link_login) TextView _loginLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.link_login)
    public void linkLogin(){
        finish();//关闭当前页面返回上一个页面（登录页面）
    }

    @OnClick(R.id.btn_signup)
    public void signup(View v) {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _btnSignUp.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("正在创建账户...");
        progressDialog.show();

        String account = _inputRegAccount.getText().toString();
        String password = _inputRegPassword.getText().toString();
        String confirmPassword = _confirmInputRegPassword.getText().toString();

        // TODO: 利用OkHttp发送请求注册账户

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _btnSignUp.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
        _btnSignUp.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String account = _inputRegAccount.getText().toString();
        String password = _inputRegPassword.getText().toString();
        String confirmPassword = _confirmInputRegPassword.getText().toString();

        if (account.isEmpty() || account.length() < 3) {
            _inputRegAccount.setError("账户至少是三个字符");
            valid = false;
        } else {
            _inputRegAccount.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _inputRegPassword.setError("密码的长度必须在四位到十位之间");
            valid = false;
        } else {
            _inputRegPassword.setError(null);
        }

        if(!password.equals(confirmPassword)){
            _inputRegPassword.setError("两次输入的密码不一致");
            valid=false;
        }else{
            _inputRegPassword.setError(null);
        }
        return valid;
    }
}