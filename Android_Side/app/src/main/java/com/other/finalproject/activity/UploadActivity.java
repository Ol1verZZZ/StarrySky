package com.other.finalproject.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.other.finalproject.R;
import com.other.finalproject.utils.Constant;
import com.other.finalproject.utils.SpUtil;
import com.other.finalproject.utils.bottomselector.BottomSelectorFactury;
import com.other.finalproject.utils.bottomselector.IBottomSheetCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.finalteam.rxgalleryfinal.RxGalleryFinal;
import cn.finalteam.rxgalleryfinal.RxGalleryFinalApi;
import cn.finalteam.rxgalleryfinal.bean.MediaBean;
import cn.finalteam.rxgalleryfinal.imageloader.ImageLoaderType;
import cn.finalteam.rxgalleryfinal.rxbus.RxBusDisposable;
import cn.finalteam.rxgalleryfinal.rxbus.RxBusResultDisposable;
import cn.finalteam.rxgalleryfinal.rxbus.event.ImageMultipleResultEvent;
import cn.finalteam.rxgalleryfinal.rxbus.event.ImageRadioResultEvent;

public class UploadActivity extends BaseActivity {


    @BindView(R.id.et_resource_name)
    EditText etResourceName;
    @BindView(R.id.et_resource_type)
    TextView etResourceType;
    @BindView(R.id.et_resource_point)
    EditText etResourcePoint;
    @BindView(R.id.et_resource_url)
    EditText etResourceUrl;
    @BindView(R.id.et_resource_des)
    EditText etResourceDes;
    @BindView(R.id.iv_resouce_pic)
    ImageView iv_resouce_pic;

    private String imagePath;


    @Override
    protected int getContentView(@Nullable Bundle savedInstanceState) {
         overridePendingTransition(R.anim.fade_in, 0);;

        return R.layout.activity_upload;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {


    }

    @OnClick({R.id.btn_cancel, R.id.btn_upload, R.id.iv_resouce_pic, R.id.et_resource_type})
    public void OnClik(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                finish();
                break;
            case R.id.btn_upload:
                uploadContent();
                break;
            case R.id.iv_resouce_pic:
                RxGalleryFinalApi
                        .openRadioSelectImage(UploadActivity.this, new RxBusResultDisposable<ImageRadioResultEvent>() {
                            @Override
                            protected void onEvent(ImageRadioResultEvent o) {
                                //显示图片地址
                                 imagePath= o.getResult().getOriginalPath();
                                Glide.with(UploadActivity.this).load(imagePath).into(iv_resouce_pic);
                            }
                        },true);
                break;
            case R.id.et_resource_type:
                selectType();
                break;
        }
    }


    private void uploadContent() {
        String resourceName = etResourceName.getText().toString().trim();
        if (TextUtils.isEmpty(resourceName)) {
            showToast("请输入资源名字");
            return;
        }

        String resourceType = etResourceType.getText().toString().trim();
        if (TextUtils.isEmpty(resourceType)) {
            showToast("请选择资源类型");
            return;
        }

        String resourcePoint = etResourcePoint.getText().toString().trim();
        if (TextUtils.isEmpty(resourcePoint)) {
            showToast("请添加下载资源所需要的积分");
            return;
        }

        String resourceUrl = etResourceUrl.getText().toString().trim();
        if (TextUtils.isEmpty(resourceUrl)) {
            showToast("请添加资源的URL");
            return;
        }

        String resourceDes= etResourceDes.getText().toString().trim();
        if (TextUtils.isEmpty(resourceDes)) {
            showToast("请添加资源描述");
            return;
        }

        if (imagePath==null){
            showToast("请选择资源图片");
            return;
        }

        int fieldid=1;
        switch (resourceType){
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

        HttpParams params = new HttpParams();
        File file = new File(imagePath);
        params.put("picture", file);
        params.put("username", SpUtil.getData("userName"));
        params.put("restype", fieldid);
        params.put("url", resourceUrl);
        params.put("title", resourceName);
        params.put("content", resourceDes);
        params.put("point", resourcePoint);

        OkGo.<String>post(Constant.baseUrl + "resource/add")
                .params(params)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (response.body().contains("<!")){
                            showToast("服务器异常,上传失败");
                            return;
                        }
                        Gson gson = new Gson();
                        com.other.finalproject.bean.Response response1 = gson.fromJson(response.body(), new TypeToken<com.other.finalproject.bean.Response>() {
                        }.getType());
                        if (response1.getResponseCode().equals(Constant.OK)) {
                            showToast("上传成功");
                            finish();
                        } else {
                            showToast("服务器异常,上传失败");
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
                etResourceType.setText(com);
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
