package cn.sharesdk.wechat.utils;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class WechatHandlerActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        SSDKLog.b().a("Wechat CallBack Start", new Object[0]);
        setTheme(R.style.Theme.Translucent);
        try {
            int i5 = Build.VERSION.SDK_INT;
            getWindow().addFlags(Integer.MIN_VALUE);
            if (i5 < 35) {
                getWindow().setStatusBarColor(0);
            }
            super.onCreate(bundle);
            l.a().a(this);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        SSDKLog.b().a("Wechat CallBack Start", new Object[0]);
        super.onNewIntent(intent);
        setIntent(intent);
        try {
            l.a().a(this);
        } catch (Throwable th) {
            SSDKLog.b().a(th);
        }
        finish();
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i5) {
        if (Build.VERSION.SDK_INT == 26) {
            return;
        }
        super.setRequestedOrientation(i5);
    }

    public void onGetMessageFromWXReq(WXMediaMessage wXMediaMessage) {
    }

    public void onShowMessageFromWXReq(WXMediaMessage wXMediaMessage) {
    }
}
