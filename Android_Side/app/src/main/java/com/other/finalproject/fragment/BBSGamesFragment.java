package com.other.finalproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.other.finalproject.R;
import com.other.finalproject.activity.BBSDetailActivity;
import com.other.finalproject.adapter.BBSOtherAdapter;
import com.other.finalproject.bean.BBSPost;
import com.other.finalproject.utils.Constant;
import com.other.finalproject.utils.SpUtil;

import java.util.List;

import butterknife.BindView;

/**
 * author: hedianbo.
 * date: 2019-12-29
 * desc: 游戏
 */
public class BBSGamesFragment extends BaseFragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private BBSOtherAdapter adapter;
    private List<BBSPost.PostsBean> posts;

    public static BBSGamesFragment newInstance() {
        return new BBSGamesFragment();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            initDatas();
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.bbs_games_fragment;
    }

    @Override
    public void initView(Bundle state) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new BBSOtherAdapter();
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int viewId = view.getId();
                if (viewId == R.id.cardView) {
                    Intent intent = new Intent(getActivity(), BBSDetailActivity.class);
                    intent.putExtra("userName", posts.get(position).getUsername());
                    intent.putExtra("postid", posts.get(position).getPostid());
                    startActivity(intent);
                }
            }
        });
        initDatas();
    }

    public void initDatas() {
        OkGo.<String>get(Constant.baseUrl + "forum/homepage?username=" +
                SpUtil.getData("userName") + "&posttype=game&ranktype=time")
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
}
