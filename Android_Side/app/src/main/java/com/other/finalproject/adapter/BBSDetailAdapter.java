package com.other.finalproject.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.other.finalproject.R;
import com.other.finalproject.bean.BBSPostDetailBean;

/**
 * author: hedianbo.
 * date: 2019-12-22
 * desc:
 */
public class BBSDetailAdapter extends BaseQuickAdapter<BBSPostDetailBean.CommentsBean, BaseViewHolder> {

    public BBSDetailAdapter() {
        super(R.layout.item_bbsdetail_comment);
    }

    @Override
    protected void convert(BaseViewHolder helper, BBSPostDetailBean.CommentsBean item) {

        TextView userName = helper.getView(R.id.userName);
        TextView time = helper.getView(R.id.time);
        TextView zan_number = helper.getView(R.id.zan_number);
        TextView tv_comment = helper.getView(R.id.tv_comment);

        userName.setText(item.getUsername());
        time.setText(item.getDate());
        zan_number.setText(item.getPLike()+"");
        tv_comment.setText(item.getContent());

        helper.addOnClickListener(R.id.zan_number);
    }
}
