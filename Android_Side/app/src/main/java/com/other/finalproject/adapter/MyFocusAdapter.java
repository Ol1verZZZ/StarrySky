package com.other.finalproject.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.other.finalproject.R;
import com.other.finalproject.bean.BBSPost;
import com.other.finalproject.bean.MyFocus;
import com.other.finalproject.utils.DateUtils;

/**
 * author: hedianbo.
 * date: 2019-12-22
 * desc:
 */
public class MyFocusAdapter extends BaseQuickAdapter<MyFocus.FollowingsBean, BaseViewHolder> {

    public MyFocusAdapter() {
        super(R.layout.my_focus_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyFocus.FollowingsBean item) {

        TextView userName = helper.getView(R.id.userName);
        TextView birthday = helper.getView(R.id.birthday);
        TextView email = helper.getView(R.id.email);

        userName.setText(item.getUsername());
        birthday.setText(DateUtils.formatDate(item.getBirthday()));
        email.setText(item.getEmail());

    }
}
