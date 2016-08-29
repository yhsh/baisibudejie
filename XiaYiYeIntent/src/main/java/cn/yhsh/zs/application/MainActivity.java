package cn.yhsh.zs.application;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pgyersdk.crash.PgyCrashManager;
import com.pgyersdk.feedback.PgyFeedbackShakeManager;
import com.pgyersdk.update.PgyUpdateManager;

public class MainActivity extends AppCompatActivity {

    private EditText tv_intent;
    private Button bt_enter;
    private Button bt_new;
    private WebView wv_pager;
    private SharedPreferences iPconfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PgyCrashManager.register(this);//初始化蒲公英
        PgyUpdateManager.register(this);//检查版本更新

        tv_intent = (EditText) findViewById(R.id.tv_intent);
        tv_intent.setText("http://www.baidu.com");
        bt_enter = (Button) findViewById(R.id.bt_enter);
        bt_new = (Button) findViewById(R.id.bt_new);
        bt_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewActivity.class);
                startActivity(intent);
            }
        });
        wv_pager = (WebView) findViewById(R.id.wv_pager);
        iPconfig = getSharedPreferences("IPconfig", MODE_PRIVATE);
        //点击按钮，加载网页
        bt_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv_pager.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        if (url.startsWith("http:") || url.startsWith("https:")) {
                            return false;
                        }
                        /**
                         * Otherwise allow the OS to handle things like tel, mailto, etc.
                         * 这个方法是在webview里面打开webview网页
                         */
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                        return true;
                    }
                });
                iPconfig.edit().putString("ip", tv_intent.getText().toString().trim()).commit();
                String ip = iPconfig.getString("ip", "http://www.baidu.com");
                wv_pager.loadUrl(ip);
                WebSettings settings = wv_pager.getSettings();
                settings.setJavaScriptEnabled(true);//支持JavaScript网页
                wv_pager.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//加载缓存
                wv_pager.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器。
                        view.loadUrl(url);
                        return true;
                    }
                });
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (wv_pager.canGoBack()) {
                wv_pager.goBack();//返回上一页面
                return true;
            } else {
                System.exit(0);//退出程序
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PgyCrashManager.unregister();//解除注册
    }
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        // 自定义摇一摇的灵敏度，默认为950，数值越小灵敏度越高。
        PgyFeedbackShakeManager.setShakingThreshold(1000);

        // 以对话框的形式弹出
        PgyFeedbackShakeManager.register(MainActivity.this);

        // 以Activity的形式打开，这种情况下必须在AndroidManifest.xml配置FeedbackActivity
        // 打开沉浸式,默认为false
        // FeedbackActivity.setBarImmersive(true);
        PgyFeedbackShakeManager.register(MainActivity.this, false);

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        PgyFeedbackShakeManager.unregister();
    }
}
