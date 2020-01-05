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
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.other.finalproject.R;
import com.other.finalproject.adapter.BBSOtherAdapter;
import com.other.finalproject.adapter.MyPostAdapter;
import com.other.finalproject.bean.BBSPost;
import com.other.finalproject.bean.ResourceBean;
import com.other.finalproject.utils.Constant;
import com.other.finalproject.utils.ShowDialogManager;
import com.other.finalproject.utils.SpUtil;

import java.util.List;

import butterknife.BindView;

public class MinePostActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private MyPostAdapter adapter;
    private List<BBSPost.PostsBean> posts;

    @Override
    protected int getContentView(@Nullable Bundle savedInstanceState) {

        return R.layout.activity_mine_post;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new MyPostAdapter();
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int viewId = view.getId();
                if (viewId == R.id.linear) {
                    Intent intent = new Intent(MinePostActivity.this, BBSDetailActivity.class);
                    intent.putExtra("userName", posts.get(position).getUsername());
                    intent.putExtra("postid", posts.get(position).getPostid());
                    startActivity(intent);
                }else if (viewId==R.id.tv_del){
                    ShowDialogManager.getInstance().showDialogHint(MinePostActivity.this, "确定删除？", new ShowDialogManager.AddOnClikLister() {
                        @Override
                        public void setOnclickLister(View view) {
                            deletePost(posts.get(position).getPostid());
                        }
                    });
                }
            }
        });
        initDatas();
    }


    //删除发帖
    public void deletePost(int postid) {
        OkGo.<String>get(Constant.baseUrl + "post/delete")
                .params("username",SpUtil.getData("userName"))
                .params("postid",postid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        com.other.finalproject.bean.Response response1 = gson.fromJson(response.body(), new TypeToken<com.other.finalproject.bean.Response>() {
                        }.getType());
                        if (response1.getResponseCode().equals(Constant.OK)) {
                            showToast("删除成功");
                            initDatas();
                        }
                    }
                });

    }

    public void initDatas() {
        OkGo.<String>get(Constant.baseUrl + "post/mypost?username=" + SpUtil.getData("userName"))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        BBSPost bbsPostBean = gson.fromJson(response.body(), new TypeToken<BBSPost>() {
                        }.getType());
                        if (bbsPostBean.getResponseCode().equals(Constant.OK)) {
                            posts = bbsPostBean.getPosts();
                            adapter.setNewData(posts);
                        }
                    }
                });

    }

    @Override
    protected void onResume() {
        super.onResume();
        initDatas();
    }
}
