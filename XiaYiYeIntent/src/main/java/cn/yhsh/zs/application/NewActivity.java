package cn.yhsh.zs.application;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * 创  建  者：下一页5 于2016/8/3日 9:42创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai(无法正常访问了…………)
 * 百度 搜 索：下一页5
 */
public class NewActivity extends Activity {

    private EditText sz_name;
    private Button night;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        sz_name = (EditText) findViewById(R.id.sz_name);
        night = (Button) findViewById(R.id.night);
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alpha = sz_name.getText().toString().trim();
                int int_alpha = Integer.parseInt(alpha);
                float fl_alpha = int_alpha / 100f;
                backgroundAlpha(NewActivity.this, fl_alpha);
            }
        });
    }

    /**
     * 窗体半透明,自定义窗口亮度代码
     *
     * @param activity
     * @param bgAlpha
     */
    public static void backgroundAlpha(Activity activity, float bgAlpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        activity.getWindow().setAttributes(lp);
    }

}
