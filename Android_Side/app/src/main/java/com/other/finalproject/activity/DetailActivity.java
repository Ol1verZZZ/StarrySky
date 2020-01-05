package com.other.finalproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.other.finalproject.R;
import com.other.finalproject.bean.CollectResourceBean;
import com.other.finalproject.bean.DownLoadBena;
import com.other.finalproject.bean.FavoriteB;
import com.other.finalproject.bean.FollowBena;
import com.other.finalproject.bean.ResourceBean;
import com.other.finalproject.utils.Constant;
import com.other.finalproject.utils.GlideHelper;
import com.other.finalproject.utils.ShowDialogManager;
import com.other.finalproject.utils.SpUtil;

import butterknife.BindView;

/**
 * @author: hedianbo.
 * @date: 2019-12-30 09:07.
 * @desc: 详情页面
 */
public class DetailActivity extends BaseActivity {

    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.focus)
    TextView focus;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.collect_number)
    TextView collectNumber;
    @BindView(R.id.im_center)
    ImageView imCenter;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.collect)
    TextView collect;
    @BindView(R.id.downLoad)
    LinearLayout downLoad;
    @BindView(R.id.tv_down)
    TextView tv_down;


    private ResourceBean.MoviesBean moviesBean;
    private ResourceBean.GamesBean gamesBean;
    private ResourceBean.OthersBean othersBean;
    private boolean followed = false;
    private boolean favorited = false;
    private int likes;
    private boolean owner = false;//是否是自己发布的
    private boolean downloaded = false;//是否下载了
    private CollectResourceBean.ResourcesBean resourcesBean;


    @Override
    protected int getContentView(@Nullable Bundle savedInstanceState) {
         overridePendingTransition(R.anim.fade_in, 0);;

        return R.layout.activity_detail;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

        resourcesBean = (CollectResourceBean.ResourcesBean) getIntent().getSerializableExtra("resourcesBean");
        moviesBean = (ResourceBean.MoviesBean) getIntent().getSerializableExtra("moviesBean");
        gamesBean = (ResourceBean.GamesBean) getIntent().getSerializableExtra("gamesBean");
        othersBean = (ResourceBean.OthersBean) getIntent().getSerializableExtra("othersBean");

        if (moviesBean != null) {
            userName.setText(moviesBean.getUsername());
            title.setText(moviesBean.getTitle());
            content.setText(moviesBean.getContent());
            likes = moviesBean.getLikes();
            collectNumber.setText(likes + "");
            GlideHelper.loadImage(Constant.baseUrl + moviesBean.getPicaddr(), imCenter);
            isFollowed(moviesBean.getUsername());
            isFavorited(moviesBean.getResourceid());
            downloadCheck(moviesBean.getResourceid());
        }

        if (gamesBean != null) {
            userName.setText(gamesBean.getUsername());
            title.setText(gamesBean.getTitle());
            content.setText(gamesBean.getContent());
            likes = gamesBean.getLikes();
            collectNumber.setText(likes + "");
            GlideHelper.loadImage(Constant.baseUrl + gamesBean.getPicaddr(), imCenter);
            isFollowed(gamesBean.getUsername());
            isFavorited(gamesBean.getResourceid());
            downloadCheck(gamesBean.getResourceid());

        }

        if (othersBean != null) {
            userName.setText(othersBean.getUsername());
            title.setText(othersBean.getTitle());
            content.setText(othersBean.getContent());
            likes = othersBean.getLikes();
            collectNumber.setText(likes + "");
            GlideHelper.loadImage(Constant.baseUrl + othersBean.getPicaddr(), imCenter);
            isFollowed(othersBean.getUsername());
            isFavorited(othersBean.getResourceid());
            downloadCheck(othersBean.getResourceid());
        }

        if (resourcesBean != null) {
            userName.setText(resourcesBean.getUsername());
            title.setText(resourcesBean.getTitle());
            content.setText(resourcesBean.getContent());
            likes = resourcesBean.getLikes();
            collectNumber.setText(likes + "");
            GlideHelper.loadImage(Constant.baseUrl + resourcesBean.getPicaddr(), imCenter);
            isFollowed(resourcesBean.getUsername());
            isFavorited(resourcesBean.getResourceid());
            downloadCheck(resourcesBean.getResourceid());
        }

        downLoad.setOnClickListener(view -> {
            if (owner) {
                return;
            }
            if (downloaded) {

                if (moviesBean != null) {
                    Intent intent = new Intent(DetailActivity.this, WebViewActivity.class);
                    intent.putExtra("url",moviesBean.getUrl());
                    startActivity(intent);
                }

                if (othersBean != null) {
                    Intent intent = new Intent(DetailActivity.this, WebViewActivity.class);
                    intent.putExtra("url",othersBean.getUrl());
                    startActivity(intent);
                }

                if (gamesBean != null) {
                    Intent intent = new Intent(DetailActivity.this, WebViewActivity.class);
                    intent.putExtra("url",gamesBean.getUrl());
                    startActivity(intent);
                }

                if (resourcesBean != null) {
                    Intent intent = new Intent(DetailActivity.this, WebViewActivity.class);
                    intent.putExtra("url",resourcesBean.getUrl());
                    startActivity(intent);
                }

                return;
            }

            ShowDialogManager.getInstance().showDialogHint(this, "是否确认下载资源", view1 -> {
                if (moviesBean != null) {
                    downloadResource(moviesBean.getResourceid());
                }

                if (othersBean != null) {
                    downloadResource(othersBean.getResourceid());

                }

                if (gamesBean != null) {
                    downloadResource(gamesBean.getResourceid());
                }

                if (resourcesBean != null) {
                    downloadResource(resourcesBean.getResourceid());
                }
            });
        });


        focus.setOnClickListener(view -> {

            if (followed) {
                if (moviesBean != null) {
                    cancelFollow(moviesBean.getUsername());
                }

                if (othersBean != null) {
                    cancelFollow(othersBean.getUsername());

                }

                if (gamesBean != null) {
                    cancelFollow(gamesBean.getUsername());
                }

                if (resourcesBean != null) {
                    cancelFollow(resourcesBean.getUsername());
                }
            } else {
                if (moviesBean != null) {
                    follow(moviesBean.getUsername());
                }

                if (othersBean != null) {
                    follow(othersBean.getUsername());

                }

                if (gamesBean != null) {
                    follow(gamesBean.getUsername());
                }

                if (resourcesBean != null) {
                    follow(resourcesBean.getUsername());
                }
            }
        });


        collect.setOnClickListener(view -> {

            if (favorited) {
                if (moviesBean != null) {
                    cancelFavorite(moviesBean.getResourceid());
                }

                if (othersBean != null) {
                    cancelFavorite(othersBean.getResourceid());

                }

                if (gamesBean != null) {
                    cancelFavorite(gamesBean.getResourceid());
                }

                if (resourcesBean != null) {
                    cancelFavorite(resourcesBean.getResourceid());
                }
            } else {
                if (moviesBean != null) {
                    addFavorite(moviesBean.getResourceid());
                }

                if (othersBean != null) {
                    addFavorite(othersBean.getResourceid());
                }

                if (gamesBean != null) {
                    addFavorite(gamesBean.getResourceid());
                }

                if (resourcesBean != null) {
                    addFavorite(resourcesBean.getResourceid());
                }
            }
        });

    }


    //是否关注了
    private void isFollowed(String following) {
        OkGo.<String>get(Constant.baseUrl + "follow/is-followed?follower=" + SpUtil.getData("userName") +
                "&following=" + following)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        FollowBena followBena = gson.fromJson(response.body(), FollowBena.class);
                        switch (followBena.getResponseCode()) {
                            case Constant.OK:
                                followed = followBena.isFollowed();
                                if (followed) {
                                    focus.setText("已关注");
                                } else {
                                    focus.setText("关注");
                                }
                                break;
                        }
                    }
                });
    }

    //是否收藏了
    private void isFavorited(int resourceid) {
        OkGo.<String>get(Constant.baseUrl + "favorite/is-favorited?username=" + SpUtil.getData("userName") +
                "&resourceid=" + resourceid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        FavoriteB favoriteB = gson.fromJson(response.body(), new TypeToken<FavoriteB>() {
                        }.getType());
                        switch (favoriteB.getResponseCode()) {
                            case Constant.FAVORITE_EXIST:
                                favorited = true;
                                collect.setText("已收藏");
                                break;
                            case Constant.FAVORITE_NOT_EXIST:
                                favorited = false;
                                collect.setText("收藏");
                                break;
                        }
                    }
                });
    }

    //是否下载过资源
    private void downloadCheck(int resourceid) {
        OkGo.<String>get(Constant.baseUrl + "resource/downloadcheck?username=" + SpUtil.getData("userName") +
                "&resourceid=" + resourceid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        DownLoadBena downLoadBena = gson.fromJson(response.body(), new TypeToken<DownLoadBena>() {
                        }.getType());
                        switch (downLoadBena.getResponseCode()) {
                            case Constant.OK:
                                if (downLoadBena.isOwner()) {
                                    owner = true;
                                    tv_down.setText("修改");
                                    return;
                                }

                                if (downLoadBena.isDownloaded()) {
                                    downloaded = true;
                                    tv_down.setText("查看");
                                }
                                break;
                        }
                    }
                });
    }


    //下载资源
    private void downloadResource(int resourceid) {
        OkGo.<String>get(Constant.baseUrl + "resource/download?username=" + SpUtil.getData("userName") +
                "&resourceid=" + resourceid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        DownLoadBena downLoadBena = gson.fromJson(response.body(), new TypeToken<DownLoadBena>() {
                        }.getType());
                        switch (downLoadBena.getResponseCode()) {
                            case Constant.OK:
                                dismissWaitingDialog();
                                downloaded = true;
                                tv_down.setText("查看");
                                showToast("下载成功");
                                break;
                            case Constant.ERROR:
                                dismissWaitingDialog();
                                downloaded = false;
                                showToast("您的积分不足,下载失败");
                                break;
                        }
                    }
                });
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
                        }
                    }
                });
    }

    //取消收藏
    private void cancelFavorite(int resourceid) {
        OkGo.<String>get(Constant.baseUrl + "favorite/delete-favorite?username=" + SpUtil.getData("userName") +
                "&resourceid=" + resourceid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        FavoriteB favoriteB = gson.fromJson(response.body(), FavoriteB.class);
                        switch (favoriteB.getResponseCode()) {
                            case Constant.OK:
                                favorited = false;
                                collect.setText("收藏");
                                showToast("取消收藏成功");
                                likes -= 1;
                                collectNumber.setText(String.format("%d", likes));
                                break;
                        }
                    }
                });
    }

    //收藏
    private void addFavorite(int resourceid) {
        OkGo.<String>get(Constant.baseUrl + "favorite/add-favorite?username=" + SpUtil.getData("userName") +
                "&resourceid=" + resourceid)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        FavoriteB favoriteB = gson.fromJson(response.body(), FavoriteB.class);
                        switch (favoriteB.getResponseCode()) {
                            case Constant.OK:
                                favorited = true;
                                collect.setText("已收藏");
                                showToast("收藏成功");
                                likes += 1;
                                collectNumber.setText(String.format("%d", likes));
                                break;
                        }
                    }
                });
    }

}
