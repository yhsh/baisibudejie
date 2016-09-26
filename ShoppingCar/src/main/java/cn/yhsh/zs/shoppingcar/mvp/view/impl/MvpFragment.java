package cn.yhsh.zs.shoppingcar.mvp.view.impl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import cn.yhsh.zs.shoppingcar.mvp.presenter.impl.MvpBasePresenter;
import cn.yhsh.zs.shoppingcar.mvp.view.MvpView;

/**
 * 创  建  者：下一页5 于2016/9/5日 15:55创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public abstract class MvpFragment<P extends MvpBasePresenter> extends Fragment implements MvpView{
    protected P presenter;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = bindPresenter();
        if (presenter != null){
            presenter.attachview(this);//绑定
        }
    }
    public abstract P bindPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.detachview();//注销解除绑定
        }
    }
}
