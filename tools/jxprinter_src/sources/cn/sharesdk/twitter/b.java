package cn.sharesdk.twitter;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import androidx.browser.trusted.sharing.ShareTarget;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.network.SSDKNetworkHelper;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.k;
import com.google.common.net.HttpHeaders;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import org.apache.commons.math3.optimization.direct.CMAESOptimizer;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class b extends cn.sharesdk.framework.authorize.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2336a;
    private boolean b;

    public b(WebAuthorizeActivity webAuthorizeActivity) {
        super(webAuthorizeActivity);
    }

    public void a(String str) {
        this.f2336a = str;
    }

    @Override // cn.sharesdk.framework.authorize.b
    public void onComplete(String str) {
        if (this.b) {
            return;
        }
        this.b = true;
        c cVarA = c.a(this.activity.getHelper().getPlatform());
        Bundle bundle = new Bundle();
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
        arrayList2.add(new KVPair<>(HttpHeaders.CONTENT_TYPE, ShareTarget.ENCODING_TYPE_URL_ENCODED));
        StringBuilder sb = new StringBuilder("Basic ");
        sb.append(Base64.encodeToString((cVarA.a() + ParameterizedMessage.ERROR_MSG_SEPARATOR + cVarA.c()).getBytes(), 2));
        arrayList2.add(new KVPair<>(HttpHeaders.AUTHORIZATION, sb.toString()));
        arrayList.add(new KVPair<>("client_id", cVarA.a()));
        arrayList.add(new KVPair<>("grant_type", "authorization_code"));
        arrayList.add(new KVPair<>("code_verifier", "challenge"));
        arrayList.add(new KVPair<>("redirect_uri", cVarA.getRedirectUri()));
        arrayList.add(new KVPair<>("code", str));
        try {
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = CMAESOptimizer.DEFAULT_MAXITERATIONS;
            networkTimeOut.connectionTimeout = 10000;
            String str2 = (String) new Hashon().fromJson(SSDKNetworkHelper.getInstance().httpPost("https://api.twitter.com/2/oauth2/token", arrayList, (KVPair<String>) null, arrayList2, networkTimeOut, "/oauth2/token", 11)).get("access_token");
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("access_token", str2);
            }
            if (bundle.size() <= 0) {
                AuthorizeListener authorizeListener = this.listener;
                if (authorizeListener != null) {
                    authorizeListener.onError(new Throwable());
                    return;
                }
                return;
            }
            AuthorizeListener authorizeListener2 = this.listener;
            if (authorizeListener2 != null) {
                authorizeListener2.onComplete(bundle);
            }
        } catch (Throwable th) {
            SSDKLog.b().a("twitter get token error" + th.getMessage());
        }
    }

    @Override // cn.sharesdk.framework.h, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String str2 = this.redirectUri;
        if (str2 != null && str.startsWith(str2)) {
            webView.stopLoading();
            this.activity.finish();
            final String strValueOf = String.valueOf(ResHelper.urlToBundle(str).get("code"));
            k.a((Runnable) new k.a() { // from class: cn.sharesdk.twitter.b.2
                @Override // cn.sharesdk.framework.utils.k.a
                public void a() {
                    b.this.onComplete(strValueOf);
                }
            });
        } else if (str.startsWith(this.f2336a)) {
            webView.loadUrl(this.authorizeUrl);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // cn.sharesdk.framework.h, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2 = this.redirectUri;
        if (str2 == null || !str.startsWith(str2)) {
            if (str.startsWith(this.f2336a)) {
                webView.loadUrl(this.authorizeUrl);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        webView.stopLoading();
        this.activity.finish();
        final String strValueOf = String.valueOf(ResHelper.urlToBundle(str).get("code"));
        k.a((Runnable) new k.a() { // from class: cn.sharesdk.twitter.b.1
            @Override // cn.sharesdk.framework.utils.k.a
            public void a() {
                b.this.onComplete(strValueOf);
            }
        });
        return true;
    }
}
