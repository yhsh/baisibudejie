package cn.yhsh.zs.shoppingcar.pro.base.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import cn.yhsh.zs.shoppingcar.mvp.presenter.impl.MvpBasePresenter;
import cn.yhsh.zs.shoppingcar.mvp.view.impl.MvpFragment;

/**
 * 创  建  者：下一页5 于2016/9/5日 16:25创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public abstract class BaseFragment<P extends MvpBasePresenter> extends MvpFragment<P> {
    private View viewContent;
    private int content;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (viewContent == null) {
            viewContent = inflater.inflate(getContent(), container, false);
            initContent(viewContent);
            initData();//初始化数据
        }
        //判断对应Fragment是否存在此视图
        ViewGroup parent = (ViewGroup) viewContent.getParent();
        if (parent != null) {
            parent.removeView(viewContent);//如果视图存在移除视图，实现缓存功能
        }
        return viewContent;
    }
    public P bindPresenter() {
        return null;
    }

    /**
     * 初始化数据
     */
    public void initData() {

    }
    /**
     * 让其子类实现布局的方法
     * @return
     */
    public abstract int getContent();

    /**
     * 让其子类实现初始化布局的方法
     * @param viewContent
     */
    protected abstract void initContent(View viewContent);
}
