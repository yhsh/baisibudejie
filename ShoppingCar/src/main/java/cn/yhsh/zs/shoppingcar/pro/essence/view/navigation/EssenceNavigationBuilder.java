package cn.yhsh.zs.shoppingcar.pro.essence.view.navigation;

import android.content.Context;

import cn.yhsh.zs.shoppingcar.R;
import cn.yhsh.zs.shoppingcar.pro.base.view.navigation.NavigationBuilderAdapter;

/**
 * 创  建  者：下一页5 于2016/9/7日 17:05创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public class EssenceNavigationBuilder extends NavigationBuilderAdapter {
    public EssenceNavigationBuilder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_essence_layout;//加载的toolbar布局文件
    }
}
