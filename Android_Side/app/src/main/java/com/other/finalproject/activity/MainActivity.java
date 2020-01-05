package com.other.finalproject.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.other.finalproject.R;
import com.other.finalproject.bean.ResourceBean;
import com.other.finalproject.fragment.BBSFragment;
import com.other.finalproject.fragment.GameFragment;
import com.other.finalproject.fragment.MineFragment;
import com.other.finalproject.fragment.OtherFragment;
import com.other.finalproject.fragment.VideoFragment;
import com.other.finalproject.utils.Constant;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    public ResourceBean resourceBean;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    @BindView(R.id.viewpager_main)
    ViewPager viewPager;
    ArrayList<Fragment> mFragments = new ArrayList<>();
    private VideoFragment videoFragment;
    private GameFragment gameFragment;
    private OtherFragment otherFragment;
    private BBSFragment bbsFragment;
    private MineFragment mineFragment;

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bottomNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    protected int getContentView(@Nullable Bundle savedInstanceState) {
        overridePendingTransition(R.anim.fade_in, 0);
        return R.layout.activity_main;
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        initBottomBar();
        initFragment();

        initDatas();
    }

    private void initBottomBar() {
        bottomNavigationBar.setTabSelectedListener(this);
        bottomNavigationBar.clearAll();
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.icon_movice, "影音")
                        .setInactiveIconResource(R.mipmap.icon_movice)
                        .setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.mipmap.icon_games, "游戏")
                        .setInactiveIconResource(R.mipmap.icon_games)
                        .setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.mipmap.icon_other, "其他")
                        .setInactiveIconResource(R.mipmap.icon_other)
                        .setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.mipmap.icon_bbs, "论坛")
                        .setInactiveIconResource(R.mipmap.icon_bbs)
                        .setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.mipmap.icon_mine, "我的")
                        .setInactiveIconResource(R.mipmap.icon_mine)
                        .setActiveColorResource(R.color.colorPrimary))
                .initialise();

    }

    private void initFragment() {
        videoFragment = VideoFragment.newInstance();
        gameFragment = GameFragment.newInstance();
        otherFragment = OtherFragment.newInstance();
        bbsFragment = BBSFragment.newInstance();
        mineFragment = MineFragment.newInstance();

        mFragments.add(videoFragment);
        mFragments.add(gameFragment);
        mFragments.add(otherFragment);
        mFragments.add(bbsFragment);
        mFragments.add(mineFragment);

        viewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(3);
    }

    public void initDatas() {

        OkGo.<String>get(Constant.baseUrl + "resource/homepage")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Gson gson = new Gson();
                        resourceBean = gson.fromJson(response.body(), new TypeToken<ResourceBean>() {
                        }.getType());

                        videoFragment.setData(resourceBean);
                        gameFragment.setData(resourceBean);
                        otherFragment.setData(resourceBean);
                    }
                });

    }

    @Override
    public void onTabSelected(int position) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    public class MainViewPagerAdapter extends FragmentPagerAdapter {

        MainViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
