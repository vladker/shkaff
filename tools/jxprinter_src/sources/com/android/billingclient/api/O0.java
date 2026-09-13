package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzca;
import com.google.android.gms.internal.play_billing.zzjs;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class O0 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0433s0 f2445a;
    public final /* synthetic */ String b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ C0421m d;

    public O0(C0421m c0421m, InterfaceC0433s0 interfaceC0433s0, String str, boolean z6) {
        this.f2445a = interfaceC0433s0;
        this.b = str;
        this.c = z6;
        this.d = c0421m;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        long j6 = p002a.c.c;
        C0421m c0421m = this.d;
        boolean zX = c0421m.X(j6);
        InterfaceC0433s0 interfaceC0433s0 = this.f2445a;
        if (!zX) {
            zzjs zzjsVar = zzjs.SERVICE_CONNECTION_NOT_READY;
            H h6 = k1.f2516j;
            c0421m.N(9, h6, zzjsVar);
            ((F4.f) interfaceC0433s0).onQueryPurchasesResponse(h6, zzca.zzk());
            return null;
        }
        String str = this.b;
        if (TextUtils.isEmpty(str)) {
            zzc.zzn("BillingClient", "Please provide a valid product type.");
            zzjs zzjsVar2 = zzjs.EMPTY_PRODUCT_TYPE;
            H h7 = k1.e;
            c0421m.N(9, h7, zzjsVar2);
            ((F4.f) interfaceC0433s0).onQueryPurchasesResponse(h7, zzca.zzk());
            return null;
        }
        u1 u1VarT = C0421m.t(c0421m, str, this.c);
        List listZzb = u1VarT.zzb();
        H h8 = u1VarT.f2581a;
        if (listZzb != null) {
            ((F4.f) interfaceC0433s0).onQueryPurchasesResponse(h8, u1VarT.zzb());
            return null;
        }
        ((F4.f) interfaceC0433s0).onQueryPurchasesResponse(h8, zzca.zzk());
        return null;
    }
}
