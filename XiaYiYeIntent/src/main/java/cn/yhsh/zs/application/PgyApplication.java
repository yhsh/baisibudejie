package cn.yhsh.zs.application;

/**
 * 创  建  者：下一页5 于2016/8/2日 17:02创建.
 * 作者联系QQ：13343401268
 * 唯一 域 名：yhsh.wap.ai(无法正常访问了…………)
 * 百度 搜 索：下一页5
 */
import com.pgyersdk.crash.PgyCrashManager;
import android.app.Application;

public class PgyApplication extends Application {

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();

        PgyCrashManager.register(this);
    }
}
