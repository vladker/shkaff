package cn.sharesdk.facebook;

import A3.AbstractC0157z;
import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.utils.ResHelper;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class c extends cn.sharesdk.framework.authorize.b {
    public c(WebAuthorizeActivity webAuthorizeActivity) {
        super(webAuthorizeActivity);
    }

    @Override // cn.sharesdk.framework.authorize.b
    public void onComplete(String str) {
        int i5;
        Bundle bundleUrlToBundle = ResHelper.urlToBundle(str);
        String string = bundleUrlToBundle.getString("error_message");
        if (string != null && this.listener != null) {
            StringBuilder sbY = AbstractC0157z.y("error_message ==>>", string, "\nerror_code ==>>");
            sbY.append(bundleUrlToBundle.getString("error_code"));
            string = sbY.toString();
            this.listener.onError(new Throwable(str));
        }
        if (string == null) {
            String string2 = bundleUrlToBundle.getString("access_token");
            String string3 = bundleUrlToBundle.containsKey("expires_in") ? bundleUrlToBundle.getString("expires_in") : StructuredDataId.RESERVED;
            if (this.listener != null) {
                Bundle bundle = new Bundle();
                bundle.putString("oauth_token", string2);
                bundle.putString("oauth_token_secret", "");
                try {
                    i5 = ResHelper.parseInt(string3);
                } catch (Throwable th) {
                    SSDKLog.b().a(th);
                    i5 = -1;
                }
                bundle.putInt("oauth_token_expires", i5);
                this.listener.onComplete(bundle);
            }
        }
    }

    @Override // cn.sharesdk.framework.h, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            String str2 = this.redirectUri;
            if (str2 != null && str.startsWith(str2)) {
                webView.stopLoading();
                webView.postDelayed(new Runnable() { // from class: cn.sharesdk.facebook.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((cn.sharesdk.framework.authorize.b) c.this).activity.finish();
                    }
                }, 500L);
                onComplete(str);
                return true;
            }
        } catch (Exception e) {
            SSDKLog.b().d(e.getMessage(), new Object[0]);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
