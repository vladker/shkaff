package com.android.billingclient.api;

import android.app.Activity;
import android.os.ResultReceiver;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class H0 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2434a;
    public final /* synthetic */ C0421m b;
    public final /* synthetic */ Activity c;
    public final /* synthetic */ ResultReceiver d;

    public /* synthetic */ H0(C0421m c0421m, Activity activity, ResultReceiver resultReceiver, int i5) {
        this.f2434a = i5;
        this.b = c0421m;
        this.c = activity;
        this.d = resultReceiver;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f2434a) {
            case 0:
                this.b.zzaU(null, this.c, this.d);
                break;
            default:
                this.b.zzaW(null, this.c, this.d);
                break;
        }
        return null;
    }
}
