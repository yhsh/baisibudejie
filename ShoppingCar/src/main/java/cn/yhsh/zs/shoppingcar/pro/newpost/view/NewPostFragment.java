package cn.yhsh.zs.shoppingcar.pro.newpost.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Arrays;

import cn.yhsh.zs.shoppingcar.R;
import cn.yhsh.zs.shoppingcar.pro.base.view.BaseFragment;
import cn.yhsh.zs.shoppingcar.pro.essence.view.adapter.EssenceAdapter;
import cn.yhsh.zs.shoppingcar.pro.newpost.view.adapter.NewPostAdapter;
import cn.yhsh.zs.shoppingcar.pro.newpost.view.navigation.NewPostNavigationBuilder;

/**
 * 创  建  者：下一页5 于2016/9/7日 11:00创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public class NewPostFragment extends BaseFragment {
    private TabLayout tab_newpost;
    private ViewPager vp_newpost;
    @Override
    public int getContent() {
        return R.layout.fragment_newpost;
    }

    @Override
    protected void initContent(View viewContent) {
        //初始化toolbar
        initToolBar(viewContent);
        //初始化控件
        tab_newpost = (TabLayout) viewContent.findViewById(R.id.tab_newpost);
        vp_newpost = (ViewPager) viewContent.findViewById(R.id.vp_newpost);
    }
    private void initToolBar(View viewContent) {
        NewPostNavigationBuilder builder = new NewPostNavigationBuilder(getContext());
        builder.setTitleIcon(R.mipmap.main_essence_title).
                setLeftIcon(R.mipmap.main_newpost_audit_btn_normal).
                setLeftIconOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "点击了左上角的图片", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.createAndBind((ViewGroup) viewContent);
    }

    @Override
    public void initData() {
        String [] titles = getResources().getStringArray(R.array.newpost_video_tab);
        NewPostAdapter adapter = new NewPostAdapter(getFragmentManager(), Arrays.asList(titles));
        vp_newpost.setAdapter(adapter);
        tab_newpost.setupWithViewPager(this.vp_newpost);//绑定viewpager
    }
}
