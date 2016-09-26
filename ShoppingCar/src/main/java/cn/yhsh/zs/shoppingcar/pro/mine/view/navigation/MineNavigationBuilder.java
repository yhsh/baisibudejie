package cn.yhsh.zs.shoppingcar.pro.mine.view.navigation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import cn.yhsh.zs.shoppingcar.R;
import cn.yhsh.zs.shoppingcar.pro.base.view.navigation.NavigationBuilderAdapter;

/**
 * 创  建  者：下一页5 于2016/9/7日 17:05创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public class MineNavigationBuilder extends NavigationBuilderAdapter {
    private int modelRes;//设置右边挨着的那还在那张图片的方法
    private View.OnClickListener modelOnClickListener;
    public MineNavigationBuilder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_mine_layout;//加载的toolbar布局文件
    }
    public MineNavigationBuilder setModelRes(int modelRes){
        this.modelRes = modelRes;
        return this;
    }

    public MineNavigationBuilder setModelOnClickListener(View.OnClickListener onClickListener){
        this.modelOnClickListener = onClickListener;
        return this;
    }

    @Override
    public void createAndBind(ViewGroup parent) {
        super.createAndBind(parent);
        setImageViewStyle(R.id.iv_model,modelRes,this.modelOnClickListener);
        setImageViewStyle(R.id.iv_setting,getRightIconRes(),getRightIconOnClickListener());
    }
}
