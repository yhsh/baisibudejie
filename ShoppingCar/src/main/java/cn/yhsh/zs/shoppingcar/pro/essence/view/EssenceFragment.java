package cn.yhsh.zs.shoppingcar.pro.essence.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.Arrays;

import cn.yhsh.zs.shoppingcar.R;
import cn.yhsh.zs.shoppingcar.pro.base.view.BaseFragment;
import cn.yhsh.zs.shoppingcar.pro.essence.view.adapter.EssenceAdapter;
import cn.yhsh.zs.shoppingcar.pro.essence.view.navigation.EssenceNavigationBuilder;

/**
 * 创  建  者：下一页5 于2016/9/7日 11:00创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public class EssenceFragment extends BaseFragment {

    private TabLayout tab_essence;
    private ViewPager vp_essence;

    @Override
    public int getContent() {
        return R.layout.fragment_essence;
    }

    @Override
    protected void initContent(View viewContent) {
        //初始化toolbar
        initToolBar(viewContent);
        //初始化控件
        tab_essence = (TabLayout) viewContent.findViewById(R.id.tab_essence);
        vp_essence = (ViewPager) viewContent.findViewById(R.id.vp_essence);
    }

    private void initToolBar(View viewContent) {
        EssenceNavigationBuilder builder = new EssenceNavigationBuilder(getContext());
        builder.setLeftIcon(R.mipmap.main_essence_btn_normal).
                setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "点击了左上角的图片", Toast.LENGTH_SHORT).show();
                    }
                }).setTitleIcon(R.mipmap.main_essence_title).
                setRightIcon(R.mipmap.main_essence_btn_more_normal).
                setRightIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "点击了右上角的图片", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.createAndBind((ViewGroup) viewContent);
    }
    /**
     * 初始化数据
     */
    public void initData() {
        String [] titles = getResources().getStringArray(R.array.essence_video_tab);
        EssenceAdapter adapter = new EssenceAdapter(getFragmentManager(), Arrays.asList(titles));
        vp_essence.setAdapter(adapter);
        tab_essence.setupWithViewPager(this.vp_essence);//绑定viewpager
    }
}
