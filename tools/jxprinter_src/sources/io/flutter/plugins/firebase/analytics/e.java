package io.flutter.plugins.firebase.analytics;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4118a;
    public final /* synthetic */ FlutterFirebaseAnalyticsPlugin b;
    public final /* synthetic */ TaskCompletionSource c;

    public /* synthetic */ e(TaskCompletionSource taskCompletionSource, FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin) {
        this.f4118a = 1;
        this.b = flutterFirebaseAnalyticsPlugin;
        this.c = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4118a) {
            case 0:
                FlutterFirebaseAnalyticsPlugin.handleGetAppInstanceId$lambda$11(this.c, this.b);
                break;
            case 1:
                FlutterFirebaseAnalyticsPlugin.handleResetAnalyticsData$lambda$8(this.b, this.c);
                break;
            default:
                FlutterFirebaseAnalyticsPlugin.handleGetSessionId$lambda$2(this.c, this.b);
                break;
        }
    }

    public /* synthetic */ e(TaskCompletionSource taskCompletionSource, FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, int i5) {
        this.f4118a = i5;
        this.c = taskCompletionSource;
        this.b = flutterFirebaseAnalyticsPlugin;
    }
}
