package com.wd.demo.adapter;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wd.demo.bean.InformationBean;

import java.util.List;

/**
 * @author 张耀中
 * @name Demo
 * @class name：com.wd.demo.adapter
 * @time 2019/4/9 20:19
 */
public class HomeAdapter extends BaseSectionQuickAdapter<InformationBean, BaseViewHolder> {

    public HomeAdapter(int layoutResId, int sectionHeadResId, List<InformationBean> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, InformationBean item) {

    }

    @Override
    protected void convert(BaseViewHolder helper, InformationBean item) {

    }
}
