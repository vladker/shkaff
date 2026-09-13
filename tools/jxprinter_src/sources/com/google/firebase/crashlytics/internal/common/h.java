package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.TaskCompletionSource;
import io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3488a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Object d;

    public /* synthetic */ h(Object obj, long j6, Object obj2, int i5) {
        this.f3488a = i5;
        this.b = obj;
        this.c = j6;
        this.d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3488a) {
            case 0:
                ((CrashlyticsCore) this.b).lambda$log$2(this.c, (String) this.d);
                break;
            case 1:
                ((CrashlyticsCore) this.b).lambda$log$3(this.c, (String) this.d);
                break;
            default:
                FlutterFirebaseAnalyticsPlugin.handleSetSessionTimeoutDuration$lambda$6((FlutterFirebaseAnalyticsPlugin) this.b, this.c, (TaskCompletionSource) this.d);
                break;
        }
    }
}
