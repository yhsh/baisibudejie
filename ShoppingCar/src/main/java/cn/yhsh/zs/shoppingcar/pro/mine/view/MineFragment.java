package cn.yhsh.zs.shoppingcar.pro.mine.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cn.yhsh.zs.shoppingcar.R;
import cn.yhsh.zs.shoppingcar.pro.base.view.BaseFragment;
import cn.yhsh.zs.shoppingcar.pro.essence.view.navigation.EssenceNavigationBuilder;
import cn.yhsh.zs.shoppingcar.pro.mine.view.navigation.MineNavigationBuilder;

/**
 * 创  建  者：下一页5 于2016/9/7日 11:00创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai
 * 百度 搜 索：下一页5
 */
public class MineFragment extends BaseFragment {
    @Override
    public int getContent() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initContent(View viewContent) {
        //初始化toolbar
        initToolBar(viewContent);
    }

    private void initToolBar(View viewContent) {
        MineNavigationBuilder builder = new MineNavigationBuilder(getContext());
        builder.setModelRes(R.mipmap.main_mine_night_model_normal).//调用顺序不能错，必须先setModelRes，在setModelOnClickListener，在setTitle，在setRightIcon，不然必须先setModelRes无法调用
                setModelOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "点击了图片", Toast.LENGTH_SHORT).show();
            }
        }).setTitle(R.string.main_mine_title_text).//设置标题
                setRightIcon(R.mipmap.main_mine_setting_normal).setRightIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "点击了右上角的设置图片", Toast.LENGTH_SHORT).show();
            }
        });
        builder.createAndBind((ViewGroup) viewContent);
    }
}
