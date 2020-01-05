package com.other.finalproject.adapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.other.finalproject.R;
import com.other.finalproject.bean.ResourceBean;
import com.other.finalproject.utils.Constant;
import com.other.finalproject.utils.GlideHelper;

/**
 * author: hedianbo.
 * date: 2019-12-22
 * desc:
 */
public class VideoAdapter extends BaseQuickAdapter<ResourceBean.MoviesBean, BaseViewHolder> {

    public VideoAdapter() {
        super(R.layout.resource_item);
    }

    @Override
    protected void convert(BaseViewHolder helper, ResourceBean.MoviesBean item) {

        ImageView head_im = helper.getView(R.id.head_im);
        ImageView im_center = helper.getView(R.id.im_center);
        TextView title = helper.getView(R.id.title);
        TextView content = helper.getView(R.id.content);
        TextView collect_number = helper.getView(R.id.collect_number);

        GlideHelper.loadImage(Constant.baseUrl + item.getPicaddr(), im_center);
        title.setText(item.getTitle());
        content.setText(item.getContent());
        collect_number.setText(item.getLikes() + "");

        helper.addOnClickListener(R.id.linear);
        helper.addOnClickListener(R.id.head_im);
        helper.addOnClickListener(R.id.im_center);

    }
}
