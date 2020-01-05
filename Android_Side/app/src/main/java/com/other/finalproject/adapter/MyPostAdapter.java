package com.other.finalproject.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.other.finalproject.R;
import com.other.finalproject.bean.BBSPost;
import com.other.finalproject.utils.DateUtils;

/**
 * author: hedianbo.
 * date: 2019-12-22
 * desc:
 */
public class MyPostAdapter extends BaseQuickAdapter<BBSPost.PostsBean, BaseViewHolder> {

    public MyPostAdapter() {
        super(R.layout.my_post_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, BBSPost.PostsBean item) {

        TextView title = helper.getView(R.id.title);
        TextView type = helper.getView(R.id.type);
        TextView time = helper.getView(R.id.time);
        TextView zan_number = helper.getView(R.id.zan_number);
        TextView comment_nmber = helper.getView(R.id.comment_nmber);

        title.setText(item.getPosttitle());
        time.setText(DateUtils.formatDate(item.getCreatedate()));
        zan_number.setText(item.getPLike() + "");
        comment_nmber.setText(item.getCommentamount() + "");
        //1	游戏	2019-12-24	4
        //2	影视	2019-12-24	6
        //3	其他	2019-12-24	4
        switch (item.getFieldid()) {
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

        helper.addOnClickListener(R.id.linear);
        helper.addOnClickListener(R.id.tv_del);
    }
}
