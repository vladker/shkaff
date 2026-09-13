package com.android.billingclient.api;

import android.app.Activity;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzca;
import com.google.android.gms.internal.play_billing.zzjs;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class G0 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2432a;
    public final /* synthetic */ C0421m b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ G0(C0421m c0421m, Object obj, Object obj2, int i5) {
        this.f2432a = i5;
        this.b = c0421m;
        this.c = obj;
        this.d = obj2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Throwable {
        switch (this.f2432a) {
            case 0:
                return this.b.zzaD((String) this.c, (String) this.d);
            case 1:
                this.b.zzaV(null, (B) this.c, (Activity) this.d);
                return null;
            case 2:
                C0421m.f(this.b, (C0410g0) this.c, (Activity) this.d);
                return null;
            case 3:
                C0421m.g0(this.b, (K) this.c, (J) this.d);
                return null;
            default:
                InterfaceC0426o0 interfaceC0426o0 = (InterfaceC0426o0) this.c;
                C0443x0 c0443x0 = (C0443x0) this.d;
                long j6 = p002a.c.c;
                C0421m c0421m = this.b;
                if (!c0421m.X(j6)) {
                    zzjs zzjsVar = zzjs.SERVICE_CONNECTION_NOT_READY;
                    H h6 = k1.f2516j;
                    c0421m.N(7, h6, zzjsVar);
                    ((p062l0.a) interfaceC0426o0).onProductDetailsResponse(h6, new C0445y0(zzca.zzk(), zzca.zzk()));
                    return null;
                }
                if (c0421m.f2558s) {
                    b1 b1VarZzi = c0421m.zzi(c0443x0);
                    ((p062l0.a) interfaceC0426o0).onProductDetailsResponse(k1.a(b1VarZzi.c, b1VarZzi.d), new C0445y0(b1VarZzi.f2466a, b1VarZzi.b));
                    return null;
                }
                zzc.zzn("BillingClient", "Querying product details is not supported.");
                zzjs zzjsVar2 = zzjs.PRODUCT_DETAILS_NOT_SUPPORTED;
                H h7 = k1.f2525s;
                c0421m.N(7, h7, zzjsVar2);
                ((p062l0.a) interfaceC0426o0).onProductDetailsResponse(h7, new C0445y0(zzca.zzk(), zzca.zzk()));
                return null;
        }
    }
}
