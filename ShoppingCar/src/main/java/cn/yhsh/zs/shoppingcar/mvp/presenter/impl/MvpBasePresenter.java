package cn.yhsh.zs.shoppingcar.mvp.presenter.impl;

import cn.yhsh.zs.shoppingcar.mvp.presenter.MvpPersenter;
import cn.yhsh.zs.shoppingcar.mvp.view.MvpView;

/**
 * 创  建  者：下一页5 于2016/9/5日 14:48创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public abstract class MvpBasePresenter<V extends MvpView> implements MvpPersenter<V> {
    private V view;

    @Override
    public void attachview(V view) {
        this.view = view;
    }

    @Override
    public void detachview() {
        if (view != null){
            view = null;
            //将view设置为空，表示解除绑定
        }
    }
}
