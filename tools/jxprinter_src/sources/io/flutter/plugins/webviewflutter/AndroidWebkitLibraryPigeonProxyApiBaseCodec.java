package io.flutter.plugins.webviewflutter;

import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class AndroidWebkitLibraryPigeonProxyApiBaseCodec extends AndroidWebkitLibraryPigeonCodec {
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar registrar;

    public AndroidWebkitLibraryPigeonProxyApiBaseCodec(AndroidWebkitLibraryPigeonProxyApiRegistrar registrar) {
        kotlin.jvm.internal.E.f(registrar, "registrar");
        this.registrar = registrar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$0(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$1(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$10(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$11(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$12(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$13(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$14(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$15(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$16(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$17(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$18(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$19(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$2(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$20(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$21(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$22(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$23(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$24(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$25(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$26(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$27(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$28(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$29(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$3(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$30(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$31(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$4(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$5(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$6(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$7(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$8(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Q writeValue$lambda$9(p147z3.u uVar) {
        return Q.INSTANCE;
    }

    public final AndroidWebkitLibraryPigeonProxyApiRegistrar getRegistrar() {
        return this.registrar;
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonCodec, io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte b, ByteBuffer buffer) {
        kotlin.jvm.internal.E.f(buffer, "buffer");
        if (b != -128) {
            return super.readValueOfType(b, buffer);
        }
        Object value = readValue(buffer);
        kotlin.jvm.internal.E.d(value, "null cannot be cast to non-null type kotlin.Long");
        long jLongValue = ((Long) value).longValue();
        Object androidWebkitLibraryPigeonInstanceManager = this.registrar.getInstanceManager().getInstance(jLongValue);
        if (androidWebkitLibraryPigeonInstanceManager == null) {
            Log.e("PigeonProxyApiBaseCodec", "Failed to find instance with identifier: " + jLongValue);
        }
        return androidWebkitLibraryPigeonInstanceManager;
    }

    @Override // io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonCodec, io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object obj) {
        kotlin.jvm.internal.E.f(stream, "stream");
        if ((obj instanceof Boolean) || (obj instanceof byte[]) || (obj instanceof Double) || (obj instanceof double[]) || (obj instanceof float[]) || (obj instanceof Integer) || (obj instanceof int[]) || (obj instanceof List) || (obj instanceof Long) || (obj instanceof long[]) || (obj instanceof Map) || (obj instanceof String) || (obj instanceof FileChooserMode) || (obj instanceof ConsoleMessageLevel) || (obj instanceof OverScrollMode) || (obj instanceof SslErrorType) || (obj instanceof MixedContentMode) || obj == null) {
            super.writeValue(stream, obj);
            return;
        }
        if (obj instanceof WebResourceRequest) {
            final int i5 = 0;
            this.registrar.getPigeonApiWebResourceRequest().pigeon_newInstance((WebResourceRequest) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i5) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof WebResourceResponse) {
            final int i6 = 2;
            this.registrar.getPigeonApiWebResourceResponse().pigeon_newInstance((WebResourceResponse) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i6) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof WebResourceError) {
            final int i7 = 14;
            this.registrar.getPigeonApiWebResourceError().pigeon_newInstance((WebResourceError) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i7) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof WebResourceErrorCompat) {
            final int i8 = 17;
            this.registrar.getPigeonApiWebResourceErrorCompat().pigeon_newInstance((WebResourceErrorCompat) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i8) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof WebViewPoint) {
            final int i9 = 18;
            this.registrar.getPigeonApiWebViewPoint().pigeon_newInstance((WebViewPoint) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i9) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof ConsoleMessage) {
            final int i10 = 19;
            this.registrar.getPigeonApiConsoleMessage().pigeon_newInstance((ConsoleMessage) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i10) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof CookieManager) {
            final int i11 = 20;
            this.registrar.getPigeonApiCookieManager().pigeon_newInstance((CookieManager) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i11) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof WebView) {
            final int i12 = 21;
            this.registrar.getPigeonApiWebView().pigeon_newInstance((WebView) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i12) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof WebSettings) {
            final int i13 = 23;
            this.registrar.getPigeonApiWebSettings().pigeon_newInstance((WebSettings) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i13) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof JavaScriptChannel) {
            final int i14 = 24;
            this.registrar.getPigeonApiJavaScriptChannel().pigeon_newInstance((JavaScriptChannel) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i14) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof WebViewClient) {
            final int i15 = 11;
            this.registrar.getPigeonApiWebViewClient().pigeon_newInstance((WebViewClient) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i15) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof DownloadListener) {
            final int i16 = 22;
            this.registrar.getPigeonApiDownloadListener().pigeon_newInstance((DownloadListener) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i16) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof WebChromeClientProxyApi.WebChromeClientImpl) {
            final int i17 = 25;
            this.registrar.getPigeonApiWebChromeClient().pigeon_newInstance((WebChromeClientProxyApi.WebChromeClientImpl) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i17) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof FlutterAssetManager) {
            final int i18 = 26;
            this.registrar.getPigeonApiFlutterAssetManager().pigeon_newInstance((FlutterAssetManager) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i18) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof WebStorage) {
            final int i19 = 27;
            this.registrar.getPigeonApiWebStorage().pigeon_newInstance((WebStorage) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i19) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof WebChromeClient.FileChooserParams) {
            final int i20 = 28;
            this.registrar.getPigeonApiFileChooserParams().pigeon_newInstance((WebChromeClient.FileChooserParams) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i20) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof PermissionRequest) {
            final int i21 = 29;
            this.registrar.getPigeonApiPermissionRequest().pigeon_newInstance((PermissionRequest) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i21) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof WebChromeClient.CustomViewCallback) {
            this.registrar.getPigeonApiCustomViewCallback().pigeon_newInstance((WebChromeClient.CustomViewCallback) obj, new C0670f(0));
        } else if (obj instanceof View) {
            this.registrar.getPigeonApiView().pigeon_newInstance((View) obj, new C0670f(1));
        } else if (obj instanceof GeolocationPermissions.Callback) {
            final int i22 = 1;
            this.registrar.getPigeonApiGeolocationPermissionsCallback().pigeon_newInstance((GeolocationPermissions.Callback) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i22) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof HttpAuthHandler) {
            final int i23 = 3;
            this.registrar.getPigeonApiHttpAuthHandler().pigeon_newInstance((HttpAuthHandler) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i23) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof Message) {
            final int i24 = 4;
            this.registrar.getPigeonApiAndroidMessage().pigeon_newInstance((Message) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i24) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof ClientCertRequest) {
            final int i25 = 5;
            this.registrar.getPigeonApiClientCertRequest().pigeon_newInstance((ClientCertRequest) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i25) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof PrivateKey) {
            final int i26 = 6;
            this.registrar.getPigeonApiPrivateKey().pigeon_newInstance((PrivateKey) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i26) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof X509Certificate) {
            final int i27 = 7;
            this.registrar.getPigeonApiX509Certificate().pigeon_newInstance((X509Certificate) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i27) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof SslErrorHandler) {
            final int i28 = 8;
            this.registrar.getPigeonApiSslErrorHandler().pigeon_newInstance((SslErrorHandler) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i28) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof SslError) {
            final int i29 = 9;
            this.registrar.getPigeonApiSslError().pigeon_newInstance((SslError) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i29) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof SslCertificate.DName) {
            final int i30 = 10;
            this.registrar.getPigeonApiSslCertificateDName().pigeon_newInstance((SslCertificate.DName) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i30) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof SslCertificate) {
            final int i31 = 12;
            this.registrar.getPigeonApiSslCertificate().pigeon_newInstance((SslCertificate) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i31) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof Certificate) {
            final int i32 = 13;
            this.registrar.getPigeonApiCertificate().pigeon_newInstance((Certificate) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i32) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof WebSettingsCompat) {
            final int i33 = 15;
            this.registrar.getPigeonApiWebSettingsCompat().pigeon_newInstance((WebSettingsCompat) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i33) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        } else if (obj instanceof WebViewFeature) {
            final int i34 = 16;
            this.registrar.getPigeonApiWebViewFeature().pigeon_newInstance((WebViewFeature) obj, new O3.l() { // from class: io.flutter.plugins.webviewflutter.e
                @Override // O3.l
                public final Object invoke(Object obj2) {
                    p147z3.u uVar = (p147z3.u) obj2;
                    switch (i34) {
                        case 0:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$0(uVar);
                        case 1:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$19(uVar);
                        case 2:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$1(uVar);
                        case 3:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$20(uVar);
                        case 4:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$21(uVar);
                        case 5:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$22(uVar);
                        case 6:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$23(uVar);
                        case 7:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$24(uVar);
                        case 8:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$25(uVar);
                        case 9:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$26(uVar);
                        case 10:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$27(uVar);
                        case 11:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$10(uVar);
                        case 12:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$28(uVar);
                        case 13:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$29(uVar);
                        case 14:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$2(uVar);
                        case 15:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$30(uVar);
                        case 16:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$31(uVar);
                        case 17:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$3(uVar);
                        case 18:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$4(uVar);
                        case 19:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$5(uVar);
                        case 20:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$6(uVar);
                        case 21:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$7(uVar);
                        case 22:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$11(uVar);
                        case 23:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$8(uVar);
                        case 24:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$9(uVar);
                        case 25:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$12(uVar);
                        case 26:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$13(uVar);
                        case 27:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$14(uVar);
                        case 28:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$15(uVar);
                        default:
                            return AndroidWebkitLibraryPigeonProxyApiBaseCodec.writeValue$lambda$16(uVar);
                    }
                }
            });
        }
        if (this.registrar.getInstanceManager().containsInstance(obj)) {
            stream.write(128);
            writeValue(stream, this.registrar.getInstanceManager().getIdentifierForStrongReference(obj));
            return;
        }
        throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass().getName() + "'");
    }
}
