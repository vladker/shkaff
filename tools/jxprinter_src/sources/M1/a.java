package M1;

import android.net.http.SslError;
import android.os.Handler;
import android.os.Message;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.webkit.WebResourceErrorCompat;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;
import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import io.flutter.plugins.webviewflutter.WebViewClientProxyApi;
import java.util.List;
import java.util.Map;
import p133x1.f;
import p133x1.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f468a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, Object obj4, int i5) {
        this.f468a = i5;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f468a;
        Object obj = this.e;
        Object obj2 = this.d;
        Object obj3 = this.c;
        Object obj4 = this.b;
        switch (i5) {
            case 0:
                ((DefaultScheduler) obj4).lambda$schedule$1((TransportContext) obj3, (TransportScheduleCallback) obj2, (EventInternal) obj);
                break;
            case 1:
                ((UserMetadata) obj4).lambda$setNewSession$0((String) obj3, (Map) obj2, (List) obj);
                break;
            case 2:
                FlutterFirebaseAnalyticsPlugin.handleSetUserProperty$lambda$7((FlutterFirebaseAnalyticsPlugin) obj4, (String) obj3, (String) obj2, (TaskCompletionSource) obj);
                break;
            case 3:
                ((FlutterFirebaseCorePlugin) obj4).lambda$initializeApp$3((GeneratedAndroidFirebaseCore.CoreFirebaseOptions) obj3, (String) obj2, (TaskCompletionSource) obj);
                break;
            case 4:
                ((FlutterFirebaseCrashlyticsPlugin) obj4).lambda$recordError$5((Map) obj3, (Handler) obj2, (TaskCompletionSource) obj);
                break;
            case 5:
                ((WebViewClientProxyApi.WebViewClientCompatImpl) obj4).lambda$onFormResubmission$19((WebView) obj3, (Message) obj2, (Message) obj);
                break;
            case 6:
                ((WebViewClientProxyApi.WebViewClientCompatImpl) obj4).lambda$onReceivedSslError$29((WebView) obj3, (SslErrorHandler) obj2, (SslError) obj);
                break;
            case 7:
                ((WebViewClientProxyApi.WebViewClientCompatImpl) obj4).lambda$onReceivedError$7((WebView) obj3, (WebResourceRequest) obj2, (WebResourceErrorCompat) obj);
                break;
            case 8:
                ((WebViewClientProxyApi.WebViewClientCompatImpl) obj4).lambda$onReceivedHttpError$5((WebView) obj3, (WebResourceRequest) obj2, (WebResourceResponse) obj);
                break;
            case 9:
                ((WebViewClientProxyApi.WebViewClientImpl) obj4).lambda$onFormResubmission$19((WebView) obj3, (Message) obj2, (Message) obj);
                break;
            case 10:
                ((WebViewClientProxyApi.WebViewClientImpl) obj4).lambda$onReceivedSslError$29((WebView) obj3, (SslErrorHandler) obj2, (SslError) obj);
                break;
            case 11:
                ((WebViewClientProxyApi.WebViewClientImpl) obj4).lambda$onReceivedError$7((WebView) obj3, (WebResourceRequest) obj2, (WebResourceError) obj);
                break;
            case 12:
                ((WebViewClientProxyApi.WebViewClientImpl) obj4).lambda$onReceivedHttpError$5((WebView) obj3, (WebResourceRequest) obj2, (WebResourceResponse) obj);
                break;
            default:
                MethodChannel.Result result = (MethodChannel.Result) obj4;
                String str = (String) obj3;
                String str2 = (String) obj2;
                f fVar = g.Companion;
                if (result != null) {
                    result.error(str, str2, obj);
                }
                break;
        }
    }
}
