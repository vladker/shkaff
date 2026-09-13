package io.flutter.plugins.firebase.analytics;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4116a;
    public final /* synthetic */ FlutterFirebaseAnalyticsPlugin b;
    public final /* synthetic */ Map c;
    public final /* synthetic */ TaskCompletionSource d;

    public /* synthetic */ c(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, Map map, TaskCompletionSource taskCompletionSource) {
        this.f4116a = 1;
        this.b = flutterFirebaseAnalyticsPlugin;
        this.c = map;
        this.d = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4116a) {
            case 0:
                FlutterFirebaseAnalyticsPlugin.handleLogEvent$lambda$3(this.c, this.b, this.d);
                break;
            case 1:
                FlutterFirebaseAnalyticsPlugin.handleSetDefaultEventParameters$lambda$10(this.b, this.c, this.d);
                break;
            default:
                FlutterFirebaseAnalyticsPlugin.handleSetConsent$lambda$9(this.c, this.b, this.d);
                break;
        }
    }

    public /* synthetic */ c(Map map, FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, TaskCompletionSource taskCompletionSource, int i5) {
        this.f4116a = i5;
        this.c = map;
        this.b = flutterFirebaseAnalyticsPlugin;
        this.d = taskCompletionSource;
    }
}
