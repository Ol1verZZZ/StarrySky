package com.other.finalproject.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.other.finalproject.R;
import com.other.finalproject.utils.Constant;
import com.other.finalproject.utils.SpUtil;

public class LoginActivity extends BaseActivity {

    private TextView userName;
    private TextView password;
    private Button register;
    private Button login;

    @Override
    protected int getContentView(@Nullable Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fade_in, 0);
        return R.layout.activity_login;
    }


    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

        if (SpUtil.getBoolean("login")) {
            startActivity(MainActivity.class);
            finish();
        }

        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);

        register.setOnClickListener(view -> {
            startActivity(RegisterActivity.class);
        });

        login.setOnClickListener(view -> {
            String username = userName.getText().toString().trim();
            if (TextUtils.isEmpty(username)) {
                Toast.makeText(mContext, "请输入用户名", Toast.LENGTH_SHORT).show();
                return;
            }

            String password = this.password.getText().toString().trim();
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(mContext, "请输入密码", Toast.LENGTH_SHORT).show();
                return;
            }

            OkGo.<String>get(Constant.baseUrl + "login/check?username=" + username +
                    "&password=" + password)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            Gson gson = new Gson();
                            com.other.finalproject.bean.Response response1 = gson.fromJson(response.body(), com.other.finalproject.bean.Response.class);
                            switch (response1.getResponseCode()) {
                                case Constant.OK:
                                    SpUtil.setBoolean("login", true);
                                    SpUtil.setData("userName", username);
                                    showToast("登陆成功");
                                    startActivity(MainActivity.class);
                                    finish();
                                    break;
                                case Constant.ERROR:
                                    showToast("请检查用户名和密码是否正确");
                                    break;
                            }
                        }
                    });

        });

    }
}
