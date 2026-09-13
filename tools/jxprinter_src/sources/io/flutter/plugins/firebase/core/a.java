package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4119a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Boolean c;
    public final /* synthetic */ TaskCompletionSource d;

    public /* synthetic */ a(String str, Boolean bool, TaskCompletionSource taskCompletionSource, int i5) {
        this.f4119a = i5;
        this.b = str;
        this.c = bool;
        this.d = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4119a) {
            case 0:
                FlutterFirebaseCorePlugin.lambda$setAutomaticResourceManagementEnabled$7(this.b, this.c, this.d);
                break;
            default:
                FlutterFirebaseCorePlugin.lambda$setAutomaticDataCollectionEnabled$6(this.b, this.c, this.d);
                break;
        }
    }
}
