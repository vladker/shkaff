package cn.sharesdk.loopshare;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import cn.sharesdk.framework.utils.SSDKLog;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class LoopShareActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        SSDKLog.b().a("[LoopShare] LoopShareActivity onCreate");
        if (Build.VERSION.SDK_INT <= 28) {
            SSDKLog.b().a("[LoopShare] LoopShareActivity onCreate SDK_INT <= 28 finish() ");
            finish();
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        SSDKLog.b().a("[LoopShare] LoopShareActivity onNewIntent");
        super.onNewIntent(intent);
        MobLink.updateNewIntent(intent, this);
    }

    @Override // android.app.Activity
    public void onResume() {
        SSDKLog.b().a("[LoopShare] LoopShareActivity onResume");
        if (Build.VERSION.SDK_INT >= 29) {
            SSDKLog.b().a("[LoopShare] LoopShareActivity onResume SDK_INT >= 29 finish() ");
            finish();
        }
        super.onResume();
    }
}
