package W2;

import android.app.Activity;
import android.app.job.JobParameters;
import android.graphics.Typeface;
import android.net.Uri;
import android.view.View;
import androidx.browser.trusted.TrustedWebActivityServiceConnectionPool;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;
import androidx.lifecycle.DispatchQueue;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewStartUpResult;
import androidx.window.embedding.ExtensionEmbeddingBackend;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.sidecar.SidecarWindowBackend;
import cn.bertsir.zbar.QRActivity;
import com.appdev.standard.dialog.E;
import com.appdev.standard.page.mine.MemberBuyActivity;
import com.appdev.standard.page.scene.CloudSpaceFragment;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.camera.media.ImageStreamReader;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import io.flutter.plugins.webviewflutter.JavaScriptChannel;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.input.ReadAheadInputStream;
import org.apache.xmlbeans.impl.tool.CodeGenUtil;
import p050j.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f786a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ b(Object obj, Object obj2, int i5) {
        this.f786a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = this.f786a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i5) {
            case 0:
                ((e) obj2).b.success((List) obj);
                break;
            case 1:
                ((TrustedWebActivityServiceConnectionPool) obj2).lambda$connect$0((Uri) obj);
                break;
            case 2:
                ((ViewTransition) obj2).lambda$applyTransition$0((View[]) obj);
                break;
            case 3:
                ((ResourcesCompat.FontCallback) obj2).lambda$callbackSuccessAsync$0((Typeface) obj);
                break;
            case 4:
                DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1((DispatchQueue) obj2, (Runnable) obj);
                break;
            case 5:
                ((WebViewCompat.WebViewStartUpCallback) obj2).onSuccess((WebViewStartUpResult) obj);
                break;
            case 6:
                ExtensionEmbeddingBackend.SplitListenerWrapper.accept$lambda$1((ExtensionEmbeddingBackend.SplitListenerWrapper) obj2, (ArrayList) obj);
                break;
            case 7:
                SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.accept$lambda$0((SidecarWindowBackend.WindowLayoutChangeCallbackWrapper) obj2, (WindowLayoutInfo) obj);
                break;
            case 8:
                FragmentStrictMode.handlePolicyViolation$lambda$0((FragmentStrictMode.Policy) obj2, (Violation) obj);
                break;
            case 9:
                FragmentStrictMode.handlePolicyViolation$lambda$1((String) obj2, (Violation) obj);
                break;
            case 10:
                ((QRActivity) obj2).lambda$recognitionLocation$2((String) obj);
                break;
            case 11:
                ((QRActivity) obj2).lambda$recognitionLocation$3((Exception) obj);
                break;
            case 12:
                ((QRActivity) obj2).lambda$recognitionLocation$4((Uri) obj);
                break;
            case 13:
                ((MemberBuyActivity) obj2).lambda$checkPendingGooglePayment$3((String) obj);
                break;
            case 14:
                ((CloudSpaceFragment) obj2).lambda$startPrintLabel$11((Exception) obj);
                break;
            case 15:
                ((JobInfoSchedulerService) obj2).lambda$onStartJob$0((JobParameters) obj);
                break;
            case 16:
                ((RemovalListener) obj2).onRemoval((RemovalNotification) obj);
                break;
            case 17:
                ((UserMetadata) obj2).lambda$updateRolloutsState$1((List) obj);
                break;
            case 18:
                ((FlutterBoostFragment) obj2).lambda$didFragmentShow$3((Runnable) obj);
                break;
            case 19:
                ImageStreamReader.lambda$onImageAvailable$0((EventChannel.EventSink) obj2, (IllegalStateException) obj);
                break;
            case 20:
                FlutterFirebaseCorePlugin.lambda$delete$8((String) obj2, (TaskCompletionSource) obj);
                break;
            case 21:
                FlutterFirebasePluginRegistry.lambda$getPluginConstantsForFirebaseApp$0((FirebaseApp) obj2, (TaskCompletionSource) obj);
                break;
            case 22:
                ((FlutterFirebaseCrashlyticsPlugin) obj2).lambda$recordError$4((String) obj);
                break;
            case 23:
                ((JavaScriptChannel) obj2).lambda$postMessage$1((String) obj);
                break;
            case 24:
                E.b((((Integer) obj2).intValue() * 100) / ((Integer) obj).intValue());
                break;
            case 25:
                ((p062l0.e) obj2).d((p062l0.c) obj);
                break;
            case 26:
                ((ReadAheadInputStream) obj2).lambda$readAsync$1((byte[]) obj);
                break;
            case 27:
                CodeGenUtil.lambda$copy$2((BufferedReader) obj2, (StringBuilder) obj);
                break;
            case 28:
                String str = (String) obj2;
                Activity activity = (Activity) obj;
                if (activity != w.f5393a) {
                    w.f5393a = activity;
                    p010b2.a aVar = w.b;
                    if (aVar != null && aVar.isShowing()) {
                        try {
                            w.b.dismiss();
                            break;
                        } catch (Exception unused) {
                        }
                    }
                    w.b = null;
                }
                if (w.b == null) {
                    w.b = new p010b2.a(activity);
                }
                try {
                    w.b.f1086a.setText(str);
                    w.b.show();
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                break;
            default:
                MethodChannel.Result result = (MethodChannel.Result) obj2;
                p133x1.f fVar = p133x1.g.Companion;
                if (result != null) {
                    result.success(obj);
                }
                break;
        }
    }
}
