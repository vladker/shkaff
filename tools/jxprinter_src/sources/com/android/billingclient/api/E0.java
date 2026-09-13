package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzjs;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class E0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2427a;
    public final /* synthetic */ C0421m b;

    public /* synthetic */ E0(C0421m c0421m, int i5) {
        this.f2427a = i5;
        this.b = c0421m;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2427a) {
            case 0:
                this.b.zzbh(null, k1.f2517k, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
                return;
            case 1:
                this.b.zzbl(null, k1.f2517k, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
                return;
            case 2:
                zzjs zzjsVar = zzjs.EXECUTE_ASYNC_TIMEOUT;
                this.b.N(3, k1.f2517k, zzjsVar);
                throw null;
            case 3:
                this.b.zzbm(null, k1.f2517k, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
                return;
            case 4:
                this.b.zzbf(null, k1.f2517k, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
                return;
            case 5:
                zzjs zzjsVar2 = zzjs.EXECUTE_ASYNC_TIMEOUT;
                this.b.N(13, k1.f2517k, zzjsVar2);
                throw null;
            case 6:
                this.b.zzbk(null, k1.f2517k, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
                return;
            case 7:
                this.b.zzbe(null, k1.f2517k, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
                return;
            case 8:
                this.b.zzba(null, k1.f2517k, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
                return;
            case 9:
                this.b.zzbg(null, k1.f2517k, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
                return;
            case 10:
                this.b.zzbi(null, k1.f2517k, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
                return;
            default:
                this.b.zzbb(null, k1.f2517k, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
                return;
        }
    }
}
