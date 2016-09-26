package cn.yhsh.zs.shoppingcar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.yhsh.zs.shoppingcar.pro.attention.view.AttentionFragment;
import cn.yhsh.zs.shoppingcar.pro.essence.view.EssenceFragment;
import cn.yhsh.zs.shoppingcar.pro.mine.view.MineFragment;
import cn.yhsh.zs.shoppingcar.pro.newpost.view.NewPostFragment;
import cn.yhsh.zs.shoppingcar.pro.publish.view.PublishFragment;

public class HomeActivity extends AppCompatActivity implements TabHost.OnTabChangeListener {

    private List<TabItem> tabItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);//去除标题栏，还可以使用主题
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initData();
        initTabHost();
    }

    private void initData() {
        tabItemList = new ArrayList<>();
        tabItemList.add(new TabItem(R.mipmap.main_bottom_essence_normal, R.mipmap.main_bottom_essence_press, R.string.main_essence_text, EssenceFragment.class));//添加精华页面
        tabItemList.add(new TabItem(R.mipmap.main_bottom_newpost_normal, R.mipmap.main_bottom_newpost_press, R.string.main_newpost_text, NewPostFragment.class));//添加新帖页面
        tabItemList.add(new TabItem(R.mipmap.main_bottom_public_normal, R.mipmap.main_bottom_public_press, 0, PublishFragment.class));//添加发布页面
        tabItemList.add(new TabItem(R.mipmap.main_bottom_attention_normal, R.mipmap.main_bottom_attention_press, R.string.main_attention_text, AttentionFragment.class));//添加关注页面
        tabItemList.add(new TabItem(R.mipmap.main_bottom_mine_normal, R.mipmap.main_bottom_mine_press, R.string.main_mine_text, MineFragment.class));//添加个人页面
    }

    /**
     * 初始化选项卡
     */
    private void initTabHost() {
        //获取FragmentTabHost
        FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        // 绑定tabhost
        fragmentTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        fragmentTabHost.getTabWidget().setDividerDrawable(null);//去掉tabhost的分割线
        //循环遍历添加fragment
        for (int i = 0; i < tabItemList.size(); i++) {
            //获取每个tabitem
            TabItem tabItem = tabItemList.get(i);
            //将fragment添加到fragmenttabhost上面
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(tabItem.getTittleString()).setIndicator(tabItem.getView());
            //添加fragment
            fragmentTabHost.addTab(tabSpec, tabItem.getFragmentClass(), tabItem.getBundle());
            //给tab设置背景色
            fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.main_bottom_bg));
            fragmentTabHost.setOnTabChangedListener(this);
            //默认选中第一个
            if (i == 0) {
                tabItem.setChecked(true);
            }
        }
    }

    @Override
    public void onTabChanged(String tabId) {
        Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
        for (int i = 0; i < tabItemList.size(); i++) {
            //重置tab样式
            TabItem tabItem = tabItemList.get(i);
            if (tabId.equals(tabItem.getTittleString())) {
                //选中状态
                tabItem.setChecked(true);
            } else {
                tabItem.setChecked(false);
            }
        }
    }

    class TabItem {
        private View view;
        private int imageNormal;//正常图片
        private int imagePress;//按下的图片
        private int tittle;//tab标题
        private String tittleString;//图片下面的额标题
        private Class<? extends Fragment> fragmentClass;
        private ImageView iv_tab;
        private TextView tv_tab;
        private Bundle bundle;

        public String getTittleString() {
            if (tittle == 0) {
                return "";
            }
            if (TextUtils.isEmpty(tittleString)) {
                tittleString = getString(tittle);
            }
            return tittleString;
        }

        public void setTittleString(String tittleString) {
            this.tittleString = tittleString;
        }

        public Bundle getBundle() {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("tittle", getTittleString());
            return bundle;
        }

        public TabItem(int imageNormal, int imagePress, int tittle, Class<? extends Fragment> fragmentClass) {
            this.imageNormal = imageNormal;
            this.imagePress = imagePress;
            this.tittle = tittle;
            this.fragmentClass = fragmentClass;
        }

        public Class<? extends Fragment> getFragmentClass() {
            return fragmentClass;
        }

        public void setFragmentClass(Class<? extends Fragment> fragmentClass) {
            this.fragmentClass = fragmentClass;
        }

        public int getImageNormal() {
            return imageNormal;
        }

        public void setImageNormal(int imageNormal) {
            this.imageNormal = imageNormal;
        }

        public int getImagePress() {
            return imagePress;
        }

        public void setImagePress(int imagePress) {
            this.imagePress = imagePress;
        }

        public int getTittle() {
            return tittle;
        }

        public void setTittle(int tittle) {
            this.tittle = tittle;
        }

        //写一个选中按钮切换tab的方法
        public void setChecked(boolean isChecked) {
            if (iv_tab != null && tv_tab != null && tittle != 0) {
                if (isChecked) {
                    iv_tab.setImageResource(imagePress);
                    tv_tab.setTextColor(getResources().getColor(R.color.main_bottom_text_select));
                } else {
                    iv_tab.setImageResource(imageNormal);
                    tv_tab.setTextColor(getResources().getColor(R.color.main_bottom_text_normal));
                }
            }
        }

        public View getView() {
            if (this.view == null) {
                this.view = View.inflate(getApplicationContext(), R.layout.view_tab_indicator, null);
                //表示tab下面的那个图片
                iv_tab = (ImageView) this.view.findViewById(R.id.iv_tab);
                //表示tab下面的那个文字
                tv_tab = (TextView) this.view.findViewById(R.id.tv_tab);
                //判断资源是否存在，不存在就隐藏
                if (this.tittle == 0) {
                    tv_tab.setVisibility(View.GONE);//隐藏
                } else {
                    tv_tab.setVisibility(View.VISIBLE);//显示
                    tv_tab.setText(getTittleString());//设置tab的文字显示
                }
                iv_tab.setImageResource(imageNormal);//设置正常图片资源
            }
            return this.view;
        }
    }
}
