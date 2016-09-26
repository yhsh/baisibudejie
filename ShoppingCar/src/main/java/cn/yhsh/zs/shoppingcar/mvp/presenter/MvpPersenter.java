package cn.yhsh.zs.shoppingcar.mvp.presenter;

import cn.yhsh.zs.shoppingcar.mvp.view.MvpView;

/**
 * 创  建  者：下一页5 于2016/9/5日 14:20创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public interface MvpPersenter<V extends MvpView> {
    /**
     * 绑定找房子的人
     */
    public void attachview(V v);

    /**
     * 解除绑定找房子的人
     */
    public void detachview();
}
