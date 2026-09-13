package com.android.billingclient.api;

import androidx.core.util.Consumer;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzdd;
import com.google.android.gms.internal.play_billing.zzjs;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 implements zzdd, InterceptorCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2470a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e1(Object obj, int i5, Object obj2, Object obj3) {
        this.f2470a = i5;
        this.b = obj2;
        this.c = obj3;
        this.d = obj;
    }

    @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
    public void onContinue(Postcard postcard) {
        ((p030f.c) this.d).a(postcard, this.f2470a, (NavigationCallback) this.b);
    }

    @Override // com.alibaba.android.arouter.facade.callback.InterceptorCallback
    public void onInterrupt(Throwable th) {
        NavigationCallback navigationCallback = (NavigationCallback) this.b;
        if (navigationCallback != null) {
            navigationCallback.onInterrupt((Postcard) this.c);
        }
        p030f.c.f3955a.info("ARouter::", "Navigation failed, termination by interceptor : " + th.getMessage());
    }

    @Override // com.google.android.gms.internal.play_billing.zzdd
    public void zza(Throwable th) {
        h1 h1Var = (h1) this.d;
        if (th instanceof TimeoutException) {
            h1Var.p0(28, k1.f2505F, zzjs.BILLING_OVERRIDE_SERVICE_CALL_TIMEOUT);
            zzc.zzo("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", th);
        } else {
            h1Var.p0(28, k1.f2505F, zzjs.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION);
            zzc.zzo("BillingClientTesting", "An error occurred while retrieving billing override.", th);
        }
        ((Runnable) this.c).run();
    }

    @Override // com.google.android.gms.internal.play_billing.zzdd
    public void zzb(Object obj) {
        Integer num = (Integer) obj;
        int iIntValue = num.intValue();
        h1 h1Var = (h1) this.d;
        if (iIntValue <= 0) {
            ((Runnable) this.c).run();
            return;
        }
        int iIntValue2 = num.intValue();
        h1Var.getClass();
        H hA = k1.a(iIntValue2, "Billing override value was set by a license tester.");
        h1Var.p0(this.f2470a, hA, zzjs.LICENSE_TESTER_BILLING_OVERRIDE);
        ((Consumer) this.b).accept(hA);
    }
}
