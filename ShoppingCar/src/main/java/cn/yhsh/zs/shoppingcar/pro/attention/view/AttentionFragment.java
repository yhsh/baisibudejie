package cn.yhsh.zs.shoppingcar.pro.attention.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

import cn.yhsh.zs.shoppingcar.R;
import cn.yhsh.zs.shoppingcar.pro.attention.view.navigation.AttentionNavigationBuilder;
import cn.yhsh.zs.shoppingcar.pro.base.view.BaseFragment;
import cn.yhsh.zs.shoppingcar.pro.essence.view.adapter.EssenceAdapter;

/**
 * 创  建  者：下一页5 于2016/9/7日 11:00创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public class AttentionFragment extends BaseFragment {
    private ViewPager vp_attention;

    @Override
    public int getContent() {
        return R.layout.fragment_attention;
    }

    @Override
    public void initContent(View contentView) {
        vp_attention = (ViewPager) contentView.findViewById(R.id.vp_attention);
        String[] titles = getResources().getStringArray(R.array.attention_video_tab);
        EssenceAdapter adapter =
                new EssenceAdapter(getFragmentManager(), Arrays.asList(titles));
        vp_attention.setAdapter(adapter);
        initToolBar(contentView, vp_attention);
    }

    private void initToolBar(View contentView, ViewPager viewPager) {
        AttentionNavigationBuilder builder = new AttentionNavigationBuilder(getContext());
        builder.setUpWithViewPager(viewPager)
                .setLeftIcon(R.drawable.main_essence_btn_selector)
                .setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
        ViewGroup parentView = (ViewGroup) contentView;
        builder.createAndBind(parentView);
    }
}
