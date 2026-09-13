package com.google.firebase.crashlytics.internal.concurrency;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3489a;
    public final /* synthetic */ Callable b;

    public /* synthetic */ a(Callable callable, int i5) {
        this.f3489a = i5;
        this.b = callable;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        switch (this.f3489a) {
            case 0:
                return CrashlyticsWorker.lambda$submit$0(this.b, task);
            case 1:
                return CrashlyticsWorker.lambda$submitTask$2(this.b, task);
            case 2:
                return CrashlyticsWorker.lambda$submitTask$3(this.b, task);
            default:
                return CrashlyticsWorker.lambda$submitTaskOnSuccess$4(this.b, task);
        }
    }
}
