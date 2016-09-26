package cn.yhsh.zs.shoppingcar.mvp.view.impl;

/**
 * 创  建  者：下一页5 于2016/9/5日 14:41创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public abstract class MvpBaseLceView<M> implements MvpLceView<M>{

    @Override
    public void showLoading(boolean PullToRefresh) {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showErr(Exception e, boolean PullToRefresh) {

    }

    @Override
    public void showData(M data) {

    }
}
