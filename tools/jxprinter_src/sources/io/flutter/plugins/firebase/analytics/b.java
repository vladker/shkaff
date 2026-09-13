package io.flutter.plugins.firebase.analytics;

import O3.l;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4115a;
    public final /* synthetic */ FlutterFirebaseAnalyticsPlugin b;
    public final /* synthetic */ l c;

    public /* synthetic */ b(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, l lVar, int i5) {
        this.f4115a = i5;
        this.b = flutterFirebaseAnalyticsPlugin;
        this.c = lVar;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        switch (this.f4115a) {
            case 0:
                FlutterFirebaseAnalyticsPlugin.getSessionId$lambda$21(this.b, this.c, task);
                break;
            case 1:
                FlutterFirebaseAnalyticsPlugin.setDefaultEventParameters$lambda$19(this.b, this.c, task);
                break;
            case 2:
                FlutterFirebaseAnalyticsPlugin.resetAnalyticsData$lambda$16(this.b, this.c, task);
                break;
            case 3:
                FlutterFirebaseAnalyticsPlugin.logEvent$lambda$12(this.b, this.c, task);
                break;
            case 4:
                FlutterFirebaseAnalyticsPlugin.setUserProperty$lambda$14(this.b, this.c, task);
                break;
            case 5:
                FlutterFirebaseAnalyticsPlugin.setAnalyticsCollectionEnabled$lambda$15(this.b, this.c, task);
                break;
            case 6:
                FlutterFirebaseAnalyticsPlugin.setUserId$lambda$13(this.b, this.c, task);
                break;
            case 7:
                FlutterFirebaseAnalyticsPlugin.setSessionTimeoutDuration$lambda$17(this.b, this.c, task);
                break;
            case 8:
                FlutterFirebaseAnalyticsPlugin.getAppInstanceId$lambda$20(this.b, this.c, task);
                break;
            default:
                FlutterFirebaseAnalyticsPlugin.setConsent$lambda$18(this.b, this.c, task);
                break;
        }
    }
}
