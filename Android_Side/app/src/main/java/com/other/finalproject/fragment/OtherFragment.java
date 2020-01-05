package com.other.finalproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.other.finalproject.R;
import com.other.finalproject.activity.DetailActivity;
import com.other.finalproject.activity.MainActivity;
import com.other.finalproject.adapter.OtherAdapter;
import com.other.finalproject.adapter.VideoAdapter;
import com.other.finalproject.bean.ResourceBean;

import butterknife.BindView;

/**
 * author: hedianbo.
 * date: 2019-12-29
 * desc: 其他
 */
public class OtherFragment extends BaseFragment{

    public static OtherFragment newInstance() {
        return new OtherFragment();
    }

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private OtherAdapter adapter;
    private ResourceBean resourceBean;

    @Override
    public int getLayoutResId() {
        return R.layout.other_fragment;
    }

    @Override
    public void initView(Bundle state) {


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new OtherAdapter();
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int viewId = view.getId();
                if (viewId == R.id.im_center||viewId==R.id.linear) {
                    if (resourceBean!=null){
                        ResourceBean.OthersBean othersBean = resourceBean.getOthers().get(position);
                        Intent intent = new Intent(getActivity(), DetailActivity.class);
                        intent.putExtra("othersBean",othersBean);
                        startActivity(intent);
                    }
                }else if (viewId==R.id.head_im){
                    showToast("点击头像");
                }
            }
        });
    }

    public void setData(ResourceBean resourceBean){
        this.resourceBean=resourceBean;
        if (adapter!=null){
            adapter.setNewData(resourceBean.getOthers());
        }

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        MainActivity activity = (MainActivity) getActivity();
        if (isVisibleToUser){
            if (activity!=null){
                if (activity.resourceBean!=null) {
                    this.resourceBean=activity.resourceBean;
                    if (adapter!=null){
                        adapter.setNewData(resourceBean.getOthers());
                    }
                }else {
                    activity.initDatas();
                }
            }
        }
        super.setUserVisibleHint(isVisibleToUser);
    }
}
