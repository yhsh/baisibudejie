package cn.yhsh.zs.shoppingcar.mvp.view.impl;

import cn.yhsh.zs.shoppingcar.mvp.view.MvpView;

/**
 * 创  建  者：下一页5 于2016/9/5日 14:31创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public interface MvpLceView<M> extends MvpView {
    /**
     * 是否下拉刷新
     */
    public void showLoading(boolean PullToRefresh);
    /**
     * 是否显示内容
     */
    public void showContent();
    /**
     * 抛出异常的时候是否下拉刷新
     */
    public void showErr(Exception e, boolean PullToRefresh);
    /**
     * 是否显示数据
     */
    public void showData(M data);
}
