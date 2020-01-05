package com.other.finalproject.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.core.util.LogWriter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.other.finalproject.MainApplication;
import com.other.finalproject.utils.WaitingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author: hedianbo.
 * @date: 2019-12-29 22:49.
 * @desc:
 */
public abstract class BaseFragment extends Fragment {

    private Toast mToast = null;
    private WaitingDialog mWaitingDialog = null;
    protected FragmentActivity activity;
    protected boolean mIsFirstVisible = true;
    private Unbinder mUnbinder;
    protected View rootView;

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            onVisible();
        } else {
            onInVisible();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            onVisible();
        } else {
            onInVisible();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (FragmentActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle state) {
        rootView = inflater.inflate(getLayoutResId(), null, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        initView(state);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        boolean isVis = isHidden() || getUserVisibleHint();
        if (isVis && mIsFirstVisible) {
            lazyLoad();
            mIsFirstVisible = false;
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        if (mUnbinder != Unbinder.EMPTY) mUnbinder.unbind();
        super.onDestroyView();
        this.activity = null;
    }

    @Override
    public void onDestroy() {
        this.rootView = null;
        this.mUnbinder = null;
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.activity = null;
    }

    /**
     * @return
     */
    public abstract int getLayoutResId();

    /**
     * 初始化views
     *
     * @param state
     */
    public abstract void initView(Bundle state);

    /**
     * 当界面可见时的操作
     */
    protected void onVisible() {
        if (mIsFirstVisible && isResumed()) {
            lazyLoad();
            mIsFirstVisible = false;
        }
    }

    /**
     * 当界面不可见时的操作
     */
    protected void onInVisible() {

    }

    /**
     * 数据懒加载
     */
    protected void lazyLoad() {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    /**
     * 显示提示信息
     */
    protected void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    /**
     * [页面跳转]
     *
     * @param clz
     */
    public void startActivity(Class<?> clz) {
        Intent intent = new Intent(getActivity(), clz);
        startActivity(intent, null);
    }

    /**
     * 显示等待对话框
     */
    public void showWaitingDialog(final String content) {
        if (mWaitingDialog != null) {
            mWaitingDialog.dismiss();
            mWaitingDialog = null;
        }
        mWaitingDialog = new WaitingDialog(getActivity());
        mWaitingDialog.setMessage(content);
        mWaitingDialog.setCanceledOnTouchOutside(false);
        mWaitingDialog.setCancelable(false);
        mWaitingDialog.show();
    }

    /**
     * 隐藏进度对话框
     */
    public void dismissWaitingDialog() {
        if (mWaitingDialog != null && mWaitingDialog.isShowing() && !getActivity().isFinishing()) {
            mWaitingDialog.dismiss();
            mWaitingDialog = null;
        }
    }

}

