package com.other.finalproject.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.other.finalproject.R;
import com.other.finalproject.adapter.CollectResourceAdapter;
import com.other.finalproject.bean.CollectResourceBean;
import com.other.finalproject.utils.Constant;
import com.other.finalproject.utils.SpUtil;

import java.util.List;

import butterknife.BindView;

public class MineDownloadActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private CollectResourceAdapter adapter;
    private CollectResourceBean resourceBean;

    @Override
    protected int getContentView(@Nullable Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fade_in, 0);
        return R.layout.activity_mine_download;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new CollectResourceAdapter();
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int viewId = view.getId();
                if (viewId == R.id.im_center||viewId==R.id.linear) {
                    if (resourceBean!=null){
                        CollectResourceBean.ResourcesBean resourcesBean = resourceBean.getResources().get(position);
                        Intent intent = new Intent(MineDownloadActivity.this, DetailActivity.class);
                        intent.putExtra("resourcesBean",resourcesBean);
                        startActivity(intent);
                    }
                }else if (viewId==R.id.head_im){
                    showToast("点击头像");
                }
            }
        });

        initDatas();
    }

    public void initDatas() {

        OkGo.<String>get(Constant.baseUrl + "user/download?username="+ SpUtil.getData("userName"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        resourceBean = gson.fromJson(response.body(), new TypeToken<CollectResourceBean>() {
                        }.getType());
                        List<CollectResourceBean.ResourcesBean> resources = resourceBean.getResources();
                        adapter.setNewData(resources);
                    }
                });

    }

    @Override
    protected void onResume() {
        super.onResume();
        initDatas();
    }
}
