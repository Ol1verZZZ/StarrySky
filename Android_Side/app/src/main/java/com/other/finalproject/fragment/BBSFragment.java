package com.other.finalproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.other.finalproject.R;
import com.other.finalproject.activity.PublishPostActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * author: hedianbo.
 * date: 2019-12-29
 * desc: 论坛
 */
public class BBSFragment extends BaseFragment {

    @BindView(R.id.tabLayout)
    SlidingTabLayout tabLayout;
    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.publish)
    TextView publish;

    private ArrayList<Fragment> mFragments;
    private BBSAllFragment bbsAllFragment;
    private BBSMovieFragment bbsMovieFragment;
    private BBSGamesFragment bbsGamesFragment;
    private BBSOtherFragment bbsOtherFragment;

    public static BBSFragment newInstance() {
        return new BBSFragment();
    }


    @Override
    public int getLayoutResId() {
        return R.layout.bbs_fragment;
    }

    @Override
    public void initView(Bundle state) {

        mFragments = new ArrayList<>();
        bbsAllFragment = BBSAllFragment.newInstance();
        bbsMovieFragment = BBSMovieFragment.newInstance();
        bbsGamesFragment = BBSGamesFragment.newInstance();
        bbsOtherFragment = BBSOtherFragment.newInstance();
        mFragments.add(bbsAllFragment);
        mFragments.add(bbsMovieFragment);
        mFragments.add(bbsGamesFragment);
        mFragments.add(bbsOtherFragment);
        vpMain.setOffscreenPageLimit(1);
        tabLayout.setViewPager(vpMain, new String[]{"综合", "影视", "游戏","其他"}, getActivity(), mFragments);

        publish.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), PublishPostActivity.class);
            startActivity(intent);
        });
    }
}
