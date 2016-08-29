package cn.yhsh.zs.application;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * Created by Yhsh On 2016/4/19 and At 11:33
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());//初始化布局文件
        initView();//初始化控件
        initListener();//初始化监听
        initData();//初始化数据
        resgisterCommonBtn();//注册监听方法
    }

    /**
     * 返回ID的方法
     *
     * @return
     */
    protected abstract int getLayoutId();

    private void resgisterCommonBtn() {
//        View view = findViewById(R.id.back);
//        if (view != null) {
//            view.setOnClickListener(this);
        }
//    }

    /**
     * 返回数据的方法
     */
    protected abstract void initData();

    /**
     * 返回布局文件的方法
     */
    protected abstract void initView();

    /**
     * 当不走系统的点击事件的时候，走此点击事件
     *
     * @param v
     */
    protected abstract void processClick(View v);

    /**
     * 返回监听的方法
     */
    protected abstract void initListener();

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.back:
//                finish();//关闭本页面
//                break;
            default:
                //其他的走此方法
                processClick(v);
                break;
        }
    }

}
