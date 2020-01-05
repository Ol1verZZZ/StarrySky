package com.other.finalproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.j256.ormlite.stmt.query.In;
import com.other.finalproject.R;
import com.other.finalproject.activity.BaseActivity;
import com.other.finalproject.activity.LoginActivity;
import com.other.finalproject.activity.MineDownloadActivity;
import com.other.finalproject.activity.MineFoucsActivity;
import com.other.finalproject.activity.MinePostActivity;
import com.other.finalproject.activity.MyCollectActivity;
import com.other.finalproject.activity.UploadActivity;
import com.other.finalproject.utils.ShowDialogManager;
import com.other.finalproject.utils.SpUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * author: hedianbo.
 * date: 2019-12-29
 * desc: 我的个人中心
 */
public class MineFragment extends BaseFragment {

    @BindView(R.id.tv_username)
    TextView tvUsername;

    public static MineFragment newInstance() {
        return new MineFragment();
    }


    @Override
    public int getLayoutResId() {
        return R.layout.mine_fragment;
    }

    @Override
    public void initView(Bundle state) {
        tvUsername.setText(SpUtil.getData("userName"));
    }


    @OnClick({R.id.tv_upload,R.id.tv_collect,R.id.tv_post,R.id.tv_focus,R.id.tv_download,R.id.logout})
    public void OnClik(View view){
        switch (view.getId()){
            case R.id.tv_upload:
                startActivity(UploadActivity.class);
                break;
            case R.id.tv_collect:
                startActivity(MyCollectActivity.class);
                break;
            case R.id.tv_post:
                startActivity(MinePostActivity.class);
                break;
            case R.id.tv_focus:
                startActivity(MineFoucsActivity.class);
                break;
            case R.id.tv_download:
                startActivity(MineDownloadActivity.class);
                break;
            case R.id.logout:
                ShowDialogManager.getInstance().showDialogHint(getContext(), "确定退出登录", new ShowDialogManager.AddOnClikLister() {
                    @Override
                    public void setOnclickLister(View view) {
                        SpUtil.setData("userName","");
                        SpUtil.setBoolean("login",false);
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        BaseActivity.logOut();
                    }
                });
                break;
        }

    }
}
