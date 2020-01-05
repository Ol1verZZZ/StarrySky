package com.other.finalproject.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.other.finalproject.R;
import com.other.finalproject.bean.ResourceBean;
import com.other.finalproject.utils.Constant;
import com.other.finalproject.utils.SpUtil;
import com.other.finalproject.utils.bottomselector.BottomSelectorFactury;
import com.other.finalproject.utils.bottomselector.IBottomSheetCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: hedianbo.
 * @date: 2019-12-31 10:33.
 * @desc: 发布页面
 */
public class PublishPostActivity extends BaseActivity {

    @BindView(R.id.rl1)
    RelativeLayout rl1;
    @BindView(R.id.et_title_input)
    EditText etTitleInput;
    @BindView(R.id.et_input_content)
    EditText etInputContent;
    @BindView(R.id.btn_publsih)
    Button btn_publsih;
    @BindView(R.id.tv_type)
    TextView tv_type;


    @Override
    protected int getContentView(@Nullable Bundle savedInstanceState) {
         overridePendingTransition(R.anim.fade_in, 0);;

        return R.layout.activity_publish_post;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

        rl1.setOnClickListener(view -> selectType());

        btn_publsih.setOnClickListener(new View.OnClickListener() {
            private int fieldid;

            @Override
            public void onClick(View view) {
                String type = tv_type.getText().toString().trim();
                if (TextUtils.isEmpty(type)){
                    showToast("请选择发布类型");
                    return;
                }

                String etTitle = etTitleInput.getText().toString().trim();
                if (TextUtils.isEmpty(etTitle)){
                    showToast("请输入标题");
                    return;
                }

                if (etTitle.length()>50){
                    showToast("标题长度限制在50以下");
                    return;
                }

                String etContent = etInputContent.getText().toString().trim();
                if (TextUtils.isEmpty(etContent)){
                    showToast("请输入您要发布的内容");
                    return;
                }

                switch (type){
                    case "游戏":
                        fieldid=1;
                        break;
                    case "影视":
                        fieldid=2;
                        break;
                    case "其他":
                        fieldid=3;
                        break;
                }

                publishPost(etTitle,fieldid,etContent);
            }
        });

    }


    public void publishPost(String posttitle,int fieldid,String content) {

        OkGo.<String>get(Constant.baseUrl + "post/new?username="+ SpUtil.getData("userName")
                +"&posttitle="+posttitle+"&fieldid="+fieldid+"&content="+content)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        com.other.finalproject.bean.Response response1 = gson.fromJson(response.body(), new TypeToken<com.other.finalproject.bean.Response>() {
                        }.getType());
                        if (response1.getResponseCode().equals(Constant.OK)){
                            showToast("发布成功");
                            finish();
                        }else {
                            showToast("服务器异常,发布失败");
                        }
                    }
                });

    }


    private void selectType() {
        List<String> list = new ArrayList<>();
        list.add("影视");
        list.add("游戏");
        list.add("其他");
        Dialog dialog = BottomSelectorFactury.getInstance().getListDialog(this, "请选择资源类型", list, null, new IBottomSheetCallback() {
            @Override
            public void onSelectItem(Object obj) {
                String com = (String) obj;
                tv_type.setText(com);
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
