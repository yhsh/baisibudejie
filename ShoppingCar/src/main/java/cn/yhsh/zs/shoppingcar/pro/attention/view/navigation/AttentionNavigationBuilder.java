package cn.yhsh.zs.shoppingcar.pro.attention.view.navigation;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import cn.yhsh.zs.shoppingcar.R;
import cn.yhsh.zs.shoppingcar.pro.base.view.navigation.NavigationBuilderAdapter;

/**
 * 创  建  者：下一页5 于2016/9/7日 17:05创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public class AttentionNavigationBuilder extends NavigationBuilderAdapter {
    private ViewPager viewPager;
    private TabLayout tab_attention;
    public AttentionNavigationBuilder(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.toolbar_attention_layout;//加载的toolbar布局文件
    }
    public AttentionNavigationBuilder setUpWithViewPager(ViewPager viewPager){
        this.viewPager = viewPager;
        return this;
    }

    @Override
    public void createAndBind(ViewGroup parent) {
        super.createAndBind(parent);
        setImageViewStyle(R.id.iv_left,getLeftIconRes(),getLeftIconOnClickListener());
        tab_attention = (TabLayout) findViewById(R.id.tab_attention);
        tab_attention.setupWithViewPager(viewPager);
    }
}
