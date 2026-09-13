package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4124a;
    public final /* synthetic */ FlutterFirebaseCrashlyticsPlugin b;
    public final /* synthetic */ TaskCompletionSource c;

    public /* synthetic */ b(FlutterFirebaseCrashlyticsPlugin flutterFirebaseCrashlyticsPlugin, TaskCompletionSource taskCompletionSource, int i5) {
        this.f4124a = i5;
        this.b = flutterFirebaseCrashlyticsPlugin;
        this.c = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4124a) {
            case 0:
                this.b.lambda$checkForUnsentReports$0(this.c);
                break;
            default:
                this.b.lambda$didCrashOnPreviousExecution$3(this.c);
                break;
        }
    }
}
