package cn.yhsh.zs.shoppingcar.pro.newpost.view;

import android.view.View;
import android.widget.TextView;

import cn.yhsh.zs.shoppingcar.R;
import cn.yhsh.zs.shoppingcar.pro.base.view.BaseFragment;

/**
 * 创  建  者：下一页5 于2016/9/9日 12:34创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public class NewPostVideoFragment extends BaseFragment {
    private int mType = 0;
    private String mTitle;

    public void setType(int mType) {
        this.mType = mType;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public int getContent() {
        return R.layout.fragment_essence_video;
    }

    @Override
    protected void initContent(View viewContent) {
        TextView textView = (TextView)viewContent.findViewById(R.id.tv_content);
        textView.setText(this.mTitle);
    }

    /**
     * 初始化数据
     */
    public void initData() {

    }
}
