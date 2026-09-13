package com.android.billingclient.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import com.google.android.gms.internal.play_billing.zzba;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzdf;
import com.google.android.gms.internal.play_billing.zzdk;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzp;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class h1 extends C0421m {

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final Context f2476K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public volatile int f2477L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public volatile g1 f2478M;

    @Nullable
    private volatile zzba zzc;

    @Nullable
    private volatile ScheduledExecutorService zze;

    @AnyThread
    public h1(@Nullable String str, Context context, @Nullable j1 j1Var, @Nullable ExecutorService executorService, C0417k c0417k) {
        super(null, context, null, null, c0417k);
        this.f2477L = 0;
        this.f2476K = context;
    }

    public static /* synthetic */ void n0(h1 h1Var, int i5, zzp zzpVar) {
        String str;
        try {
            if (h1Var.zzc == null) {
                throw null;
            }
            zzba zzbaVar = h1Var.zzc;
            String packageName = h1Var.f2476K.getPackageName();
            if (i5 == 2) {
                str = "LAUNCH_BILLING_FLOW";
            } else if (i5 == 3) {
                str = "ACKNOWLEDGE_PURCHASE";
            } else if (i5 == 4) {
                str = "CONSUME_ASYNC";
            } else if (i5 != 5) {
                str = i5 != 6 ? "QUERY_PRODUCT_DETAILS_ASYNC" : "START_CONNECTION";
            } else {
                str = "IS_FEATURE_SUPPORTED";
            }
            zzbaVar.zza(packageName, str, new f1(zzpVar));
        } catch (Exception e) {
            h1Var.p0(28, k1.f2505F, zzjs.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION);
            zzc.zzo("BillingClientTesting", "An error occurred while retrieving billing override.", e);
            zzpVar.zzb(0);
        }
    }

    @Override // com.android.billingclient.api.C0421m, com.android.billingclient.api.AbstractC0419l
    public final void acknowledgePurchase(C0401c c0401c, InterfaceC0403d interfaceC0403d) {
        throw null;
    }

    @Override // com.android.billingclient.api.C0421m, com.android.billingclient.api.AbstractC0419l
    public final void consumeAsync(final J j6, final K k6) {
        r0(4, new Consumer() { // from class: com.android.billingclient.api.d1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                String purchaseToken = j6.getPurchaseToken();
                ((p062l0.a) k6).onConsumeResponse((H) obj, purchaseToken);
            }
        }, new L0(this, j6, k6));
    }

    @Override // com.android.billingclient.api.C0421m, com.android.billingclient.api.AbstractC0419l
    public final void endConnection() {
        synchronized (this) {
            q0(27);
            try {
                try {
                    if (this.f2478M != null && this.zzc != null) {
                        zzc.zzm("BillingClientTesting", "Unbinding from Billing Override Service.");
                        this.f2476K.unbindService(this.f2478M);
                        this.f2478M = new g1(this);
                    }
                    this.zzc = null;
                    if (this.zze != null) {
                        this.zze.shutdownNow();
                        this.zze = null;
                    }
                } catch (RuntimeException e) {
                    zzc.zzo("BillingClientTesting", "There was an exception while ending Billing Override Service connection!", e);
                }
                this.f2477L = 3;
            } catch (Throwable th) {
                this.f2477L = 3;
                throw th;
            }
        }
        super.endConnection();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.billingclient.api.C0421m, com.android.billingclient.api.AbstractC0419l
    public final H launchBillingFlow(Activity activity, C0442x c0442x) {
        int iIntValue = 0;
        try {
            iIntValue = ((Integer) o0(2).get(28500L, TimeUnit.MILLISECONDS)).intValue();
        } catch (TimeoutException e) {
            p0(28, k1.f2505F, zzjs.BILLING_OVERRIDE_SERVICE_CALL_TIMEOUT);
            zzc.zzo("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", e);
        } catch (Exception e6) {
            if (e6 instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            p0(28, k1.f2505F, zzjs.BILLING_OVERRIDE_SERVICE_CALL_EXCEPTION);
            zzc.zzo("BillingClientTesting", "An error occurred while retrieving billing override.", e6);
        }
        if (iIntValue > 0) {
            H hA = k1.a(iIntValue, "Billing override value was set by a license tester.");
            p0(2, hA, zzjs.LICENSE_TESTER_BILLING_OVERRIDE);
            d0(hA);
            return hA;
        }
        try {
            return super.launchBillingFlow(activity, c0442x);
        } catch (Exception e7) {
            zzjs zzjsVar = zzjs.BILLING_OVERRIDE_SERVICE_FALLBACK_ERROR;
            H h6 = k1.f2514h;
            p0(2, h6, zzjsVar);
            zzc.zzo("BillingClientTesting", "An internal error occurred.", e7);
            return h6;
        }
    }

    public final synchronized boolean m0() {
        return (this.f2477L != 2 || this.zzc == null || this.f2478M == null) ? false : true;
    }

    public final zzdk o0(int i5) {
        if (m0()) {
            return zzu.zza(new p096r.f(this, i5));
        }
        zzc.zzn("BillingClientTesting", "Billing Override Service is not ready.");
        p0(28, k1.a(-1, "Billing Override Service connection is disconnected."), zzjs.BILLING_OVERRIDE_SERVICE_CONNECTION_NOT_READY);
        return zzdf.zza(0);
    }

    public final void p0(int i5, H h6, zzjs zzjsVar) {
        int i6 = i1.f2481a;
        zzjl zzjlVarZzb = i1.zzb(zzjsVar, i5, h6, null, zzjz.BROADCAST_ACTION_UNSPECIFIED);
        Objects.requireNonNull(zzjlVarZzb, "ApiFailure should not be null");
        ((m1) this.f2545f).zza(zzjlVarZzb);
    }

    public final void q0(int i5) {
        int i6 = i1.f2481a;
        zzjp zzjpVarZzc = i1.zzc(i5, zzjz.BROADCAST_ACTION_UNSPECIFIED);
        Objects.requireNonNull(zzjpVarZzc, "ApiSuccess should not be null");
        ((m1) this.f2545f).zzf(zzjpVarZzc);
    }

    @Override // com.android.billingclient.api.C0421m, com.android.billingclient.api.AbstractC0419l
    public final void queryProductDetailsAsync(C0443x0 c0443x0, final InterfaceC0426o0 interfaceC0426o0) {
        r0(7, new Consumer() { // from class: com.android.billingclient.api.c1
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                C0445y0 c0445y0 = new C0445y0(new ArrayList(), new ArrayList());
                ((p062l0.a) interfaceC0426o0).onProductDetailsResponse((H) obj, c0445y0);
            }
        }, new L0(this, 1, c0443x0, interfaceC0426o0));
    }

    public final void r0(int i5, Consumer consumer, Runnable runnable) {
        ScheduledExecutorService scheduledExecutorService;
        zzdk zzdkVarO0 = o0(i5);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        synchronized (this) {
            try {
                if (this.zze == null) {
                    this.zze = Executors.newSingleThreadScheduledExecutor();
                }
                scheduledExecutorService = this.zze;
            } catch (Throwable th) {
                throw th;
            }
        }
        zzdf.zzc(zzdf.zzb(zzdkVarO0, 28500L, timeUnit, scheduledExecutorService), new e1(this, i5, consumer, runnable), m());
    }

    @Override // com.android.billingclient.api.C0421m, com.android.billingclient.api.AbstractC0419l
    public final void startConnection(InterfaceC0423n interfaceC0423n) {
        synchronized (this) {
            if (m0()) {
                zzc.zzm("BillingClientTesting", "Billing Override Service connection is valid. No need to re-initialize.");
                q0(26);
            } else if (this.f2477L == 1) {
                zzc.zzn("BillingClientTesting", "Client is already in the process of connecting to Billing Override Service.");
            } else if (this.f2477L == 3) {
                zzc.zzn("BillingClientTesting", "Billing Override Service Client was already closed and can't be reused. Please create another instance.");
                p0(26, k1.a(-1, "Billing Override Service connection is disconnected."), zzjs.BILLING_CLIENT_CLOSED);
            } else {
                this.f2477L = 1;
                zzc.zzm("BillingClientTesting", "Starting Billing Override Service setup.");
                this.f2478M = new g1(this);
                Intent intent = new Intent("com.google.android.apps.play.billingtestcompanion.BillingOverrideService.BIND");
                intent.setPackage("com.google.android.apps.play.billingtestcompanion");
                Context context = this.f2476K;
                List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                zzjs zzjsVar = zzjs.REASON_UNSPECIFIED;
                if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                    zzjsVar = zzjs.INTENT_SERVICE_NOT_FOUND;
                } else {
                    ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                    if (serviceInfo != null) {
                        String str = serviceInfo.packageName;
                        String str2 = serviceInfo.name;
                        if (!Objects.equals(str, "com.google.android.apps.play.billingtestcompanion") || str2 == null) {
                            zzjsVar = zzjs.BILLING_SERVICE_BLOCKED;
                            zzc.zzn("BillingClientTesting", "The device doesn't have valid Play Billing Lab.");
                        } else {
                            ComponentName componentName = new ComponentName(str, str2);
                            Intent intent2 = new Intent(intent);
                            intent2.setComponent(componentName);
                            if (context.bindService(intent2, this.f2478M, 1)) {
                                zzc.zzm("BillingClientTesting", "Billing Override Service was bonded successfully.");
                            } else {
                                zzjsVar = zzjs.BILLING_SERVICE_BLOCKED;
                                zzc.zzn("BillingClientTesting", "Connection to Billing Override Service is blocked.");
                            }
                        }
                    }
                }
                this.f2477L = 0;
                zzc.zzm("BillingClientTesting", "Billing Override Service unavailable on device.");
                p0(26, k1.a(2, "Billing Override Service unavailable on device."), zzjsVar);
            }
        }
        U(interfaceC0423n, 0);
    }

    @AnyThread
    public h1(@Nullable String str, C0416j0 c0416j0, Context context, n1 n1Var, @Nullable j1 j1Var, @Nullable ExecutorService executorService, C0417k c0417k) {
        super((String) null, c0416j0, context, (n1) null, (j1) null, (ExecutorService) null, c0417k);
        this.f2477L = 0;
        this.f2476K = context;
    }

    @AnyThread
    public h1(@Nullable String str, C0416j0 c0416j0, Context context, InterfaceC0435t0 interfaceC0435t0, @Nullable j1 j1Var, @Nullable ExecutorService executorService, C0417k c0417k) {
        super((String) null, c0416j0, context, interfaceC0435t0, (j1) null, (ExecutorService) null, c0417k);
        this.f2477L = 0;
        this.f2476K = context;
    }

    @AnyThread
    public h1(@Nullable String str, C0416j0 c0416j0, Context context, InterfaceC0435t0 interfaceC0435t0, @Nullable C0 c6, @Nullable O o6, @Nullable j1 j1Var, @Nullable ExecutorService executorService, C0417k c0417k) {
        super(null, c0416j0, context, interfaceC0435t0, c6, o6, null, null, c0417k);
        this.f2477L = 0;
        this.f2476K = context;
    }
}
