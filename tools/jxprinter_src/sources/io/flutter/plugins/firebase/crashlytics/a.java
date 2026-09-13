package io.flutter.plugins.firebase.crashlytics;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4123a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ TaskCompletionSource c;

    public /* synthetic */ a(Map map, TaskCompletionSource taskCompletionSource, int i5) {
        this.f4123a = i5;
        this.b = map;
        this.c = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4123a) {
            case 0:
                FlutterFirebaseCrashlyticsPlugin.lambda$log$6(this.b, this.c);
                break;
            case 1:
                FlutterFirebaseCrashlyticsPlugin.lambda$setUserIdentifier$9(this.b, this.c);
                break;
            default:
                FlutterFirebaseCrashlyticsPlugin.lambda$setCustomKey$10(this.b, this.c);
                break;
        }
    }
}
