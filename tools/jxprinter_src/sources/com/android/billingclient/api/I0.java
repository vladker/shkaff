package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class I0 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2436a;
    public final /* synthetic */ C0421m b;
    public final /* synthetic */ Object c;

    public /* synthetic */ I0(C0421m c0421m, Object obj, int i5) {
        this.f2436a = i5;
        this.b = c0421m;
        this.c = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f2436a) {
            case 0:
                this.b.zzaJ(null, (C0401c) this.c);
                break;
            case 1:
                this.b.zzaQ(null, (F) this.c);
                break;
            default:
                this.b.zzaK(null, (X) this.c);
                break;
        }
        return null;
    }
}
