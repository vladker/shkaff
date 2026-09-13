package io.flutter.plugins.firebase.analytics;

import com.google.android.gms.tasks.TaskCompletionSource;
import io.flutter.plugins.firebase.core.FlutterFirebasePluginRegistry;
import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4117a;
    public final /* synthetic */ TaskCompletionSource b;

    public /* synthetic */ d(int i5, TaskCompletionSource taskCompletionSource) {
        this.f4117a = i5;
        this.b = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4117a) {
            case 0:
                FlutterFirebaseAnalyticsPlugin.getPluginConstantsForFirebaseApp$lambda$0(this.b);
                break;
            case 1:
                FlutterFirebaseAnalyticsPlugin.didReinitializeFirebaseCore$lambda$1(this.b);
                break;
            case 2:
                FlutterFirebasePluginRegistry.lambda$didReinitializeFirebaseCore$1(this.b);
                break;
            case 3:
                FlutterFirebaseCrashlyticsPlugin.lambda$deleteUnsentReports$2(this.b);
                break;
            case 4:
                FlutterFirebaseCrashlyticsPlugin.lambda$sendUnsentReports$7(this.b);
                break;
            default:
                FlutterFirebaseCrashlyticsPlugin.lambda$didReinitializeFirebaseCore$13(this.b);
                break;
        }
    }
}
