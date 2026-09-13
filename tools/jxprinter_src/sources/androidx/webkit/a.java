package androidx.webkit;

import android.content.Context;
import android.webkit.ClientCertRequest;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import io.flutter.plugins.webviewflutter.WebViewClientProxyApi;
import io.reactivex.internal.operators.observable.C0953x2;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.H;
import okhttp3.K;
import okhttp3.L;
import okhttp3.T;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import p056k0.m;
import p056k0.n;
import p102s.B;
import retrofit2.C1622u;
import retrofit2.InterfaceC1616n;
import retrofit2.r0;
import xyz.doikki.videoplayer.player.k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1067a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(Object obj, int i5, Object obj2, Object obj3) {
        this.f1067a = i5;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5;
        switch (this.f1067a) {
            case 0:
                WebViewCompat.lambda$startUpWebView$3((WebViewStartUpConfig) this.b, (WebViewCompat.WebViewStartUpCallback) this.c, (Context) this.d);
                return;
            case 1:
                ((CrashlyticsCore) this.b).lambda$logException$1((Throwable) this.c, (Map) this.d);
                return;
            case 2:
                FlutterFirebaseAnalyticsPlugin.handleSetUserId$lambda$4((FlutterFirebaseAnalyticsPlugin) this.b, (String) this.c, (TaskCompletionSource) this.d);
                return;
            case 3:
                ((FlutterFirebaseCorePlugin) this.b).lambda$firebaseAppToMap$0((FirebaseApp) this.c, (TaskCompletionSource) this.d);
                return;
            case 4:
                ((FlutterFirebaseCrashlyticsPlugin) this.b).lambda$setCrashlyticsCollectionEnabled$8((Map) this.c, (TaskCompletionSource) this.d);
                return;
            case 5:
                ((FlutterFirebaseCrashlyticsPlugin) this.b).lambda$getPluginConstantsForFirebaseApp$12((TaskCompletionSource) this.c, (FirebaseApp) this.d);
                return;
            case 6:
                ((WebViewClientProxyApi.WebViewClientCompatImpl) this.b).lambda$onReceivedClientCertRequest$25((WebView) this.c, (ClientCertRequest) this.d);
                return;
            case 7:
                ((WebViewClientProxyApi.WebViewClientCompatImpl) this.b).lambda$shouldOverrideUrlLoading$11((WebView) this.c, (WebResourceRequest) this.d);
                return;
            case 8:
                ((WebViewClientProxyApi.WebViewClientImpl) this.b).lambda$shouldOverrideUrlLoading$11((WebView) this.c, (WebResourceRequest) this.d);
                return;
            case 9:
                ((WebViewClientProxyApi.WebViewClientImpl) this.b).lambda$onReceivedClientCertRequest$25((WebView) this.c, (ClientCertRequest) this.d);
                return;
            case 10:
                String str = (String) this.b;
                File file = (File) this.c;
                File file2 = (File) this.d;
                try {
                    H h6 = new H();
                    L l6 = new L();
                    l6.c(str);
                    T tExecute = K.a(h6, l6.a()).execute();
                    try {
                        if (!tExecute.a() || tExecute.body() == null) {
                            C0953x2.b("Server error: " + tExecute.c);
                        } else {
                            long jC = tExecute.body().c();
                            InputStream inputStream = tExecute.body().d().inputStream();
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            byte[] bArr = new byte[4096];
                            int i6 = 0;
                            long j6 = 0;
                            while (true) {
                                int i7 = inputStream.read(bArr);
                                InputStream inputStream2 = inputStream;
                                if (i7 != -1) {
                                    fileOutputStream.write(bArr, 0, i7);
                                    j6 += (long) i7;
                                    if (jC > 0 && (i5 = (int) ((100 * j6) / jC)) != i6) {
                                        n.c = Math.max(0, Math.min(100, Math.max(0, Math.min(100, i5))));
                                        n.e.set(m.b);
                                        n.d();
                                        i6 = i5;
                                    }
                                    inputStream = inputStream2;
                                } else {
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                    inputStream2.close();
                                    if (jC > 0 && j6 < jC) {
                                        file.delete();
                                        C0953x2.b("Download incomplete: " + j6 + PackagingURIHelper.FORWARD_SLASH_STRING + jC);
                                    } else if (file.renameTo(file2) && n.b(file2)) {
                                        p051j0.a.c("ModelFileDownloadUtil", "Model file download success");
                                        n.c = 100;
                                        n.d = "";
                                        n.e.set(m.c);
                                        n.d();
                                    } else {
                                        file.delete();
                                        if (file2.exists() && !n.b(file2)) {
                                            file2.delete();
                                        }
                                        C0953x2.b("Failed to rename tmp file");
                                    }
                                }
                            }
                        }
                        tExecute.close();
                        return;
                    } catch (Throwable th) {
                        if (tExecute == null) {
                            throw th;
                        }
                        try {
                            tExecute.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                } catch (IOException e) {
                    p051j0.a.d("ModelFileDownloadUtil", "downloadModelInternal failed: " + e.getMessage());
                    if (file.exists()) {
                        file.delete();
                    }
                    C0953x2.b(e.getMessage());
                    return;
                } catch (IllegalArgumentException e6) {
                    p051j0.a.d("ModelFileDownloadUtil", "downloadModelInternal invalid URL: " + e6.getMessage());
                    if (file.exists()) {
                        file.delete();
                    }
                    C0953x2.b(e6.getMessage());
                    return;
                }
            case 11:
                k kVar = (k) this.b;
                InterfaceC1616n interfaceC1616n = (InterfaceC1616n) this.c;
                r0 r0Var = (r0) this.d;
                C1622u c1622u = (C1622u) kVar.c;
                if (c1622u.b.d()) {
                    interfaceC1616n.onFailure(c1622u, new IOException("Canceled"));
                    return;
                } else {
                    interfaceC1616n.onResponse(c1622u, r0Var);
                    return;
                }
            case 12:
                ((InterfaceC1616n) this.c).onFailure((C1622u) ((k) this.b).c, (Throwable) this.d);
                return;
            default:
                B.c((String) this.b, (String) this.c, (String) this.d);
                return;
        }
    }

    public /* synthetic */ a(String str, C0953x2 c0953x2, File file, File file2) {
        this.f1067a = 10;
        this.b = str;
        this.c = file;
        this.d = file2;
    }
}
