package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class D0 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2425a;
    public final /* synthetic */ Object b;

    public /* synthetic */ D0(Object obj, int i5) {
        this.f2425a = i5;
        this.b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f2425a) {
            case 0:
                ((C0421m) this.b).zzaT(null);
                break;
            case 1:
                ((C0421m) this.b).zzaL(null);
                break;
            case 2:
                ((C0421m) this.b).zzaR(null);
                break;
            case 3:
                ((C0421m) this.b).zzaP(null);
                break;
            case 4:
                C0421m.l((C0421m) this.b);
                break;
            default:
                P0.a((P0) this.b);
                break;
        }
        return null;
    }
}
