package com.other.finalproject.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.other.finalproject.R;
import com.other.finalproject.utils.Constant;
import com.other.finalproject.utils.bottomselector.BottomSelectorFactury;
import com.other.finalproject.utils.bottomselector.IBottomSheetCallback;

import java.util.ArrayList;
import java.util.List;


public class RegisterActivity extends BaseActivity {


    private Button register;
    private EditText userName;
    private EditText password;
    private ImageView back_iv;
    private TextView sex;
    private EditText email;

    @Override
    protected int getContentView(@Nullable Bundle savedInstanceState) {
         overridePendingTransition(R.anim.fade_in, 0);;

        return R.layout.activity_register;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

        register = findViewById(R.id.register);
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        sex = findViewById(R.id.sex);
        email = findViewById(R.id.email);
        back_iv = findViewById(R.id.back_iv);


        back_iv.setOnClickListener(view -> onBackPressed());

        sex.setOnClickListener(view -> selectSex());

        register.setOnClickListener(view -> {
            String username = userName.getText().toString().trim();
            if (TextUtils.isEmpty(username)) {
                Toast.makeText(mContext, "请输入用户名", Toast.LENGTH_SHORT).show();
                return;
            }

            String email = this.email.getText().toString().trim();
            if (TextUtils.isEmpty(email)) {
                Toast.makeText(mContext, "请输入邮箱", Toast.LENGTH_SHORT).show();
                return;
            }

            String sex = this.sex.getText().toString().trim();
            if (TextUtils.isEmpty(sex)) {
                Toast.makeText(mContext, "请输入性别", Toast.LENGTH_SHORT).show();
                return;
            }

            String password = this.password.getText().toString().trim();
            if (TextUtils.isEmpty(password)) {
                Toast.makeText(mContext, "请输入密码", Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.length() < 6 || password.length() > 16) {
                Toast.makeText(mContext, "密码长度最小为6,最大为16", Toast.LENGTH_SHORT).show();
                return;
            }

            String sexType="m";
            switch (sex){
                case "男":
                    sexType="m";
                    break;
                case "女":
                    sexType="f";
                    break;
            }

            OkGo.<String>get(Constant.baseUrl + "register/check?username=" + username +
                    "&uPassword=" + password + "&uSex=" + sexType + "&uEmail=" + email)
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            Gson gson = new Gson();
                            com.other.finalproject.bean.Response response1 = gson.fromJson(response.body(), com.other.finalproject.bean.Response.class);
                            switch (response1.getResponseCode()) {
                                case Constant.OK:
                                    showToast("注册成功");
                                    finish();
                                    break;
                                case Constant.EMAIL_EXIST:
                                    showToast("邮箱已存在");
                                    break;
                                case Constant.USER_EXIST:
                                    showToast("用户名已存在");
                                    break;
                            }
                        }
                    });


        });
    }


    private void selectSex() {
        List<String> list = new ArrayList<>();
        list.add("男");
        list.add("女");
        Dialog dialog = BottomSelectorFactury.getInstance().getListDialog(this, "请选择性别", list, null, new IBottomSheetCallback() {
            @Override
            public void onSelectItem(Object obj) {
                String com = (String) obj;
                sex.setText(com);
            }

            @Override
            public void onClickCancel() {

            }

            @Override
            public void onClickConfirm() {

            }
        });
        dialog.show();
    }
}
