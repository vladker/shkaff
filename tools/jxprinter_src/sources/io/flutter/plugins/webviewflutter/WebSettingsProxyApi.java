package io.flutter.plugins.webviewflutter;

import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class WebSettingsProxyApi extends PigeonApiWebSettings {

    /* JADX INFO: renamed from: io.flutter.plugins.webviewflutter.WebSettingsProxyApi$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$plugins$webviewflutter$MixedContentMode;

        static {
            int[] iArr = new int[MixedContentMode.values().length];
            $SwitchMap$io$flutter$plugins$webviewflutter$MixedContentMode = iArr;
            try {
                iArr[MixedContentMode.ALWAYS_ALLOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$MixedContentMode[MixedContentMode.COMPATIBILITY_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$plugins$webviewflutter$MixedContentMode[MixedContentMode.NEVER_ALLOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public WebSettingsProxyApi(@NonNull ProxyApiRegistrar proxyApiRegistrar) {
        super(proxyApiRegistrar);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    @NonNull
    public String getUserAgentString(@NonNull WebSettings webSettings) {
        return webSettings.getUserAgentString();
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setAllowContentAccess(@NonNull WebSettings webSettings, boolean z6) {
        webSettings.setAllowContentAccess(z6);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setAllowFileAccess(@NonNull WebSettings webSettings, boolean z6) {
        webSettings.setAllowFileAccess(z6);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setBuiltInZoomControls(@NonNull WebSettings webSettings, boolean z6) {
        webSettings.setBuiltInZoomControls(z6);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setDisplayZoomControls(@NonNull WebSettings webSettings, boolean z6) {
        webSettings.setDisplayZoomControls(z6);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setDomStorageEnabled(@NonNull WebSettings webSettings, boolean z6) {
        webSettings.setDomStorageEnabled(z6);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setGeolocationEnabled(@NonNull WebSettings webSettings, boolean z6) {
        webSettings.setGeolocationEnabled(z6);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setJavaScriptCanOpenWindowsAutomatically(@NonNull WebSettings webSettings, boolean z6) {
        webSettings.setJavaScriptCanOpenWindowsAutomatically(z6);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setJavaScriptEnabled(@NonNull WebSettings webSettings, boolean z6) {
        webSettings.setJavaScriptEnabled(z6);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setLoadWithOverviewMode(@NonNull WebSettings webSettings, boolean z6) {
        webSettings.setLoadWithOverviewMode(z6);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setMediaPlaybackRequiresUserGesture(@NonNull WebSettings webSettings, boolean z6) {
        webSettings.setMediaPlaybackRequiresUserGesture(z6);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setMixedContentMode(@NonNull WebSettings webSettings, @NonNull MixedContentMode mixedContentMode) {
        int i5 = AnonymousClass1.$SwitchMap$io$flutter$plugins$webviewflutter$MixedContentMode[mixedContentMode.ordinal()];
        if (i5 == 1) {
            webSettings.setMixedContentMode(0);
        } else if (i5 == 2) {
            webSettings.setMixedContentMode(2);
        } else {
            if (i5 != 3) {
                return;
            }
            webSettings.setMixedContentMode(1);
        }
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setSupportMultipleWindows(@NonNull WebSettings webSettings, boolean z6) {
        webSettings.setSupportMultipleWindows(z6);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setSupportZoom(@NonNull WebSettings webSettings, boolean z6) {
        webSettings.setSupportZoom(z6);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setTextZoom(@NonNull WebSettings webSettings, long j6) {
        webSettings.setTextZoom((int) j6);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setUseWideViewPort(@NonNull WebSettings webSettings, boolean z6) {
        webSettings.setUseWideViewPort(z6);
    }

    @Override // io.flutter.plugins.webviewflutter.PigeonApiWebSettings
    public void setUserAgentString(@NonNull WebSettings webSettings, @Nullable String str) {
        webSettings.setUserAgentString(str);
    }
}
