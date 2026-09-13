package cn.sharesdk.framework.authorize;

import android.content.Intent;
import cn.sharesdk.framework.utils.SSDKLog;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class SSOAuthorizeActivity extends AbstractAuthorizeActivity {
    private static final int DEFAULT_AUTH_ACTIVITY_CODE = 32973;
    protected SSOListener listener;
    private c sso;

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i5, int i6, Intent intent) {
        try {
            this.sso.a(i5, i6, intent);
        } catch (Throwable th) {
            finish();
            SSDKLog.b().a(th);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        try {
            c sSOProcessor = this.helper.getSSOProcessor(this);
            this.sso = sSOProcessor;
            if (sSOProcessor != null) {
                sSOProcessor.a(DEFAULT_AUTH_ACTIVITY_CODE);
                this.sso.a();
                return;
            }
            finish();
            AuthorizeListener authorizeListener = this.helper.getAuthorizeListener();
            if (authorizeListener != null) {
                authorizeListener.onError(new Throwable("Failed to start SSO for " + this.helper.getPlatform().getName()));
            }
        } catch (Throwable th) {
            finish();
            SSDKLog.b().a(th);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onNewIntent(Intent intent) {
        try {
            this.sso.a(intent);
        } catch (Throwable th) {
            finish();
            SSDKLog.b().a(th);
        }
    }

    public void setSSOListener(SSOListener sSOListener) {
        this.listener = sSOListener;
    }
}
