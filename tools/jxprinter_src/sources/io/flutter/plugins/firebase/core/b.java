package io.flutter.plugins.firebase.core;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4120a;
    public final /* synthetic */ FlutterFirebaseCorePlugin b;
    public final /* synthetic */ TaskCompletionSource c;

    public /* synthetic */ b(FlutterFirebaseCorePlugin flutterFirebaseCorePlugin, TaskCompletionSource taskCompletionSource, int i5) {
        this.f4120a = i5;
        this.b = flutterFirebaseCorePlugin;
        this.c = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4120a) {
            case 0:
                this.b.lambda$optionsFromResource$5(this.c);
                break;
            default:
                this.b.lambda$initializeCore$4(this.c);
                break;
        }
    }
}
