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
import com.other.finalproject.adapter.MyFocusAdapter;
import com.other.finalproject.adapter.MyPostAdapter;
import com.other.finalproject.bean.BBSPost;
import com.other.finalproject.bean.MyFocus;
import com.other.finalproject.utils.Constant;
import com.other.finalproject.utils.ShowDialogManager;
import com.other.finalproject.utils.SpUtil;

import java.util.List;

import butterknife.BindView;

public class MineFoucsActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MyFocusAdapter adapter;

    @Override
    protected int getContentView(@Nullable Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fade_in, 0);
        return R.layout.activity_mine_foucs;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new MyFocusAdapter();
        recyclerView.setAdapter(adapter);

        initDatas();
    }

    private void initDatas() {

        OkGo.<String>get(Constant.baseUrl + "user/following")
                .params("username", SpUtil.getData("userName"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        MyFocus myFocus = gson.fromJson(response.body(), new TypeToken<MyFocus>() {
                        }.getType());
                        if (myFocus.getResponseCode().equals(Constant.OK)) {
                            adapter.setNewData(myFocus.getFollowings());
                        }
                    }
                });
    }
}
