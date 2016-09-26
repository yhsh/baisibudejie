package cn.yhsh.zs.shoppingcar.pro.essence.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import cn.yhsh.zs.shoppingcar.pro.essence.view.EssenceVideoFragment;

/**
 * 创  建  者：下一页5 于2016/9/9日 13:10创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public class EssenceAdapter extends FragmentStatePagerAdapter {
    public static final String TAB_TAG = "@dream@";
    private List<String> mTitles;
    public EssenceAdapter(FragmentManager fm ,List<String> titles) {
        super(fm);
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        EssenceVideoFragment fragment = new EssenceVideoFragment();
        String[] title = mTitles.get(position).split(TAB_TAG);
        fragment.setType(Integer.parseInt(title[1]));
        fragment.setTitle(title[0]);
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position).split(TAB_TAG)[0];
    }
}
