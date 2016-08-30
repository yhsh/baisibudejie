package cn.yhsh.zs.textviewnetdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String str = "<a href=\"http://www.baidu.com\">http://www.baidu.com</a>";
    private TextView tv;
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        wv = (WebView) findViewById(R.id.wv);
        initTextView();
    }

    private void initTextView() {
        tv.setText(Html.fromHtml(str));
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence text = tv.getText();
        if (text instanceof Spannable) {
            int end = text.length();
            Spannable sp = (Spannable) tv.getText();
            URLSpan[] urls = sp.getSpans(0, end, URLSpan.class);//扫描出所有的可点击的url
            SpannableStringBuilder style = new SpannableStringBuilder(text);
            style.clearSpans();
            for (URLSpan url : urls) {
                URLClick urlClick = new URLClick(url.getURL());
                style.setSpan(urlClick, sp.getSpanStart(url), sp.getSpanEnd(url), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
            }
            tv.setText(style);
        }
    }

    // 已经给textview添加了监听，下面编写监听类
    public class URLClick extends ClickableSpan {
        String url = null;

        public URLClick(String url) {
            this.url = url;
        }

        @Override
        public void onClick(View widget) {
            //这里添加点击操作
            Toast.makeText(getApplication(),"正在打开网站！",Toast.LENGTH_SHORT).show();
            tv.setVisibility(View.GONE);
            wv.setVisibility(View.VISIBLE);
            wv.setWebViewClient(new WebViewClient() {
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
            wv.loadUrl(tv.getText().toString());
        }
    }
}
