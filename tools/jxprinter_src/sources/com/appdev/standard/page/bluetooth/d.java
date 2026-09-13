package com.appdev.standard.page.bluetooth;

import com.google.android.gms.tasks.TaskCompletionSource;
import io.flutter.plugins.firebase.analytics.FlutterFirebaseAnalyticsPlugin;
import p134x2.K;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2682a = 0;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ d(PrintDeviceInfoActivity printDeviceInfoActivity, K k6, boolean z6) {
        this.c = printDeviceInfoActivity;
        this.d = k6;
        this.b = z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2682a) {
            case 0:
                ((PrintDeviceInfoActivity) this.c).lambda$updateZipSetting$1((K) this.d, this.b);
                break;
            default:
                FlutterFirebaseAnalyticsPlugin.handleSetAnalyticsCollectionEnabled$lambda$5((FlutterFirebaseAnalyticsPlugin) this.c, this.b, (TaskCompletionSource) this.d);
                break;
        }
    }

    public /* synthetic */ d(FlutterFirebaseAnalyticsPlugin flutterFirebaseAnalyticsPlugin, boolean z6, TaskCompletionSource taskCompletionSource) {
        this.c = flutterFirebaseAnalyticsPlugin;
        this.b = z6;
        this.d = taskCompletionSource;
    }
}
