package com.other.finalproject.activity;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;
import com.other.finalproject.R;
import com.other.finalproject.adapter.BBSDetailAdapter;
import com.other.finalproject.bean.BBSPostDetailBean;
import com.other.finalproject.bean.FollowBena;
import com.other.finalproject.utils.Constant;
import com.other.finalproject.utils.DateUtils;
import com.other.finalproject.utils.InputTextMsgDialog;
import com.other.finalproject.utils.SpUtil;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author: hedianbo.
 * @date: 2019-12-31 08:19.
 * @desc: 论坛详情
 */
public class BBSDetailActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.zan_number)
    TextView zan_number;
    @BindView(R.id.comment_nmber)
    TextView comment_nmber;
    @BindView(R.id.btn_comment)
    Button btn_comment;


    private BBSDetailAdapter adapter;
    private TextView tv_title;
    private TextView type;
    private TextView focus;
    private TextView userName;
    private TextView time;
    private TextView tv_content;
    private String userName1;
    private int postid;
    private InputTextMsgDialog inputTextMsgDialog;
    private BBSPostDetailBean bbsPostDetailBean;
    private boolean followed = false;
    private int pLike;


    @Override
    protected int getContentView(@Nullable Bundle savedInstanceState) {
         overridePendingTransition(R.anim.fade_in, 0);

        return R.layout.activity_bbsdetail;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

        userName1 = getIntent().getStringExtra("userName");
        postid = getIntent().getIntExtra("postid", -1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new BBSDetailAdapter();
        recyclerView.setAdapter(adapter);

        View view = LayoutInflater.from(this).inflate(R.layout.item_header_bbsdetail, null, false);
        tv_title = view.findViewById(R.id.tv_title);
        time = view.findViewById(R.id.time);
        userName = view.findViewById(R.id.userName);
        focus = view.findViewById(R.id.focus);
        type = view.findViewById(R.id.type);
        tv_content = view.findViewById(R.id.tv_content);
        adapter.addHeaderView(view);

        focus.setOnClickListener(view12 -> {
            if (followed) {
                cancelFollow(userName1);
            } else {
                follow(userName1);
            }
        });

        inputTextMsgDialog = new InputTextMsgDialog(this, R.style.dialog_center);
        inputTextMsgDialog.setmOnTextSendListener(msg -> {
            addNewComment(msg);
        });

        btn_comment.setOnClickListener(view1 -> inputTextMsgDialog.show());

        recyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId()==R.id.zan_number){
                    addCommentLike(bbsPostDetailBean.getComments().get(position).getCommentid());
                }
            }
        });

        zan_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLike(postid);
            }
        });

        initDatas();
    }


    //取消关注
    private void cancelFollow(String following) {
        OkGo.<String>get(Constant.baseUrl + "follow/cancel?follower=" + SpUtil.getData("userName") +
                "&following=" + following)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        FollowBena followBena = gson.fromJson(response.body(), FollowBena.class);
                        switch (followBena.getResponseCode()) {
                            case Constant.OK:
                                showToast("取消关注成功");
                                focus.setText("关注");
                                followed = false;
                                break;
                        }
                    }
                });
    }

    //去关注
    private void follow(String following) {
        OkGo.<String>get(Constant.baseUrl + "follow/follow?follower=" + SpUtil.getData("userName") +
                "&following=" + following)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        FollowBena followBena = gson.fromJson(response.body(), FollowBena.class);
                        switch (followBena.getResponseCode()) {
                            case Constant.OK:
                                showToast("关注成功");
                                focus.setText("已关注");
                                followed = true;
                                break;
                            case Constant.ERROR:
                                showToast("服务器异常,关注失败");
                                followed = false;
                                break;
                        }
                    }
                });
    }


    //对评论内容点赞
    private void addCommentLike(int commentId) {

        HttpParams httpParams = new HttpParams();
        httpParams.put("username",SpUtil.getData("userName"));
        httpParams.put("commentid",commentId);

        OkGo.<String>get(Constant.baseUrl+"comment/like")
                .params(httpParams)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        com.other.finalproject.bean.Response response1 = gson.fromJson(response.body(), com.other.finalproject.bean.Response.class);
                        switch (response1.getResponseCode()) {
                            case Constant.OK:
                                showToast("点赞成功");
                                initDatas();
                                break;
                            case Constant.ERROR:
                                showToast("服务器异常,点赞失败");
                                break;
                        }
                    }
                });
    }


    //点赞
    private void addLike(int postid) {

        HttpParams httpParams = new HttpParams();
        httpParams.put("username",SpUtil.getData("userName"));
        httpParams.put("postid",postid);

        OkGo.<String>get(Constant.baseUrl+"post/like")
               .params(httpParams)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        com.other.finalproject.bean.Response response1 = gson.fromJson(response.body(), com.other.finalproject.bean.Response.class);
                        switch (response1.getResponseCode()) {
                            case Constant.OK:
                                showToast("点赞成功");
                                pLike+=1;
                                zan_number.setText(pLike + "");
                                break;
                            case Constant.ERROR:
                                showToast("服务器异常,点赞失败");
                                break;
                        }
                    }
                });
    }


    //添加新的评论
    private void addNewComment(String content) {
        OkGo.<String>get(Constant.baseUrl + "comment/new?username=" + SpUtil.getData("userName") + "&postid=" + postid
                + "&content=" + content)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        com.other.finalproject.bean.Response response1 = gson.fromJson(response.body(), new TypeToken<com.other.finalproject.bean.Response>() {
                        }.getType());
                        if (response1.getResponseCode().equals(Constant.OK)) {

                            BBSPostDetailBean.CommentsBean commentsBean = new BBSPostDetailBean.CommentsBean();
                            commentsBean.setContent(content);
                            commentsBean.setPostid(postid);
                            commentsBean.setUsername(SpUtil.getData("userName"));
                            commentsBean.setDate(DateUtils.getTodayCommon());

                            if (bbsPostDetailBean != null && bbsPostDetailBean.getComments() != null) {
                                bbsPostDetailBean.getComments().add(commentsBean);
                                adapter.setNewData(bbsPostDetailBean.getComments());
                            } else {
                                ArrayList<BBSPostDetailBean.CommentsBean> commentsBeans = new ArrayList<>();
                                BBSPostDetailBean.CommentsBean commentsBean1 = new BBSPostDetailBean.CommentsBean();
                                commentsBeans.add(commentsBean1);
                                adapter.setNewData(commentsBeans);
                            }
                            Toast.makeText(BBSDetailActivity.this, "评论成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void initDatas() {
        OkGo.<String>get(Constant.baseUrl + "post/data?username=" + userName1 + "&postid=" + postid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        bbsPostDetailBean = gson.fromJson(response.body(), new TypeToken<BBSPostDetailBean>() {
                        }.getType());
                        if (bbsPostDetailBean.getResponseCode().equals(Constant.OK)) {

                            adapter.setNewData(bbsPostDetailBean.getComments());
                            BBSPostDetailBean.PostBean post = bbsPostDetailBean.getPost();
                            followed = bbsPostDetailBean.isFollow();
                            tv_title.setText(post.getPosttitle());
                            time.setText(DateUtils.formatDate(post.getCreatedate()));
                            userName.setText(post.getUsername());
                            tv_content.setText(post.getContent());
                            focus.setText(followed ? "已关注" : "关注");
                            pLike = post.getPLike();
                            zan_number.setText(pLike + "");
                            comment_nmber.setText(post.getCommentamount() + "");
                            //1	游戏	2019-12-24	4
                            //2	影视	2019-12-24	6
                            //3	其他	2019-12-24	4
                            switch (post.getFieldid()) {
                                case 1:
                                    type.setText("游戏");
                                    break;
                                case 2:
                                    type.setText("影视");
                                    break;
                                case 3:
                                    type.setText("其他");
                                    break;
                            }

                        }
                    }
                });
    }

}
