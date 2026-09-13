package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzaq;
import com.google.android.gms.internal.play_billing.zzar;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjj;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjn;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjq;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzju;
import com.google.android.gms.internal.play_billing.zzjx;
import com.google.android.gms.internal.play_billing.zzku;
import com.google.android.gms.internal.play_billing.zzkw;
import com.google.android.gms.internal.play_billing.zzle;
import com.google.android.gms.internal.play_billing.zzlg;
import com.google.android.gms.internal.play_billing.zzlk;
import com.google.android.gms.internal.play_billing.zzll;
import com.google.android.gms.internal.play_billing.zzln;
import java.util.concurrent.TimeUnit;
import p079o.AbstractC1282k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class P0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0423n f2447a;
    public final com.google.android.gms.internal.play_billing.zzbn b;
    public final com.google.android.gms.internal.play_billing.zzbn c;
    public final int d;
    public final /* synthetic */ C0421m e;

    public /* synthetic */ P0(C0421m c0421m, InterfaceC0423n interfaceC0423n, int i5) {
        this.e = c0421m;
        com.google.android.gms.internal.play_billing.zzbq zzbqVar = c0421m.f2543J;
        this.b = com.google.android.gms.internal.play_billing.zzbn.zzc(zzbqVar);
        this.c = com.google.android.gms.internal.play_billing.zzbn.zzc(zzbqVar);
        this.f2447a = interfaceC0423n;
        this.d = i5;
    }

    public static void a(P0 p1) {
        Bundle bundle;
        zzar zzarVar;
        C0421m c0421m = p1.e;
        synchronized (c0421m.f2544a) {
            try {
                if (c0421m.b == 3) {
                    return;
                }
                int i5 = 0;
                boolean z6 = true;
                boolean z7 = c0421m.b == 1;
                Exception exc = null;
                if (TextUtils.isEmpty(null)) {
                    bundle = null;
                } else {
                    bundle = new Bundle();
                    bundle.putString("accountName", null);
                    zzc.zzc(bundle, c0421m.c, c0421m.zzd, c0421m.f2542I.longValue());
                }
                zzjs zzjsVar = zzjs.REASON_UNSPECIFIED;
                synchronized (c0421m.f2544a) {
                    zzarVar = c0421m.f2546g;
                }
                if (zzarVar == null) {
                    C0421m c0421m2 = p1.e;
                    c0421m2.T(0);
                    int i6 = p1.d;
                    zzjs zzjsVar2 = zzjs.SERVICE_RESET_TO_NULL;
                    H h6 = k1.f2516j;
                    c0421m2.S(i6, h6, zzjsVar2);
                    p1.d(h6);
                    return;
                }
                String packageName = p1.e.e.getPackageName();
                try {
                    if (zzarVar.zzb(25, packageName, "inapp") == 0) {
                        C0421m c0421m3 = p1.e;
                        Context context = c0421m3.e;
                        synchronized (v1.class) {
                        }
                        synchronized (v1.class) {
                        }
                        synchronized (v1.class) {
                        }
                        synchronized (v1.class) {
                        }
                        long jMin = 100;
                        while (true) {
                            long j6 = i5;
                            if (j6 > 3) {
                                break;
                            }
                            try {
                                Boolean boolValueOf = Boolean.valueOf(z7);
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("callingPackage", c0421m3.e.getPackageName());
                                zzc.zzc(bundle2, c0421m3.c, c0421m3.zzd, c0421m3.f2542I.longValue());
                                if (c0421m3.zzG != null) {
                                    c0421m3.zzG.getClass();
                                    bundle2.putBoolean("enablePendingPurchases", true);
                                }
                                if (c0421m3.zzG != null && c0421m3.zzG.f2482a) {
                                    bundle2.putBoolean("enablePendingPurchaseForSubscriptions", true);
                                }
                                zzarVar.zzq(25, c0421m3.e.getPackageName(), bundle2, new W0(c0421m3, p1, boolValueOf, i5));
                                return;
                            } catch (SecurityException e) {
                                p1.e(e, z7, i5);
                                return;
                            } catch (Exception e6) {
                                exc = e6;
                                if (j6 == 3) {
                                    break;
                                }
                                zzc.zzo("BillingClient", androidx.exifinterface.media.a.k("Transient error during initialize(), retrying in ", jMin, "ms"), exc);
                                try {
                                    Thread.sleep(jMin);
                                    jMin = (long) Math.min(jMin * 2.0d, 60000L);
                                    i5++;
                                } catch (InterruptedException e7) {
                                    Thread.currentThread().interrupt();
                                    p1.e(e7, z7, i5);
                                    return;
                                }
                            }
                        }
                        p1.e(exc, z7, i5);
                        return;
                    }
                    int i7 = 29;
                    int iZzb = 3;
                    while (true) {
                        if (i7 < 3) {
                            i7 = 0;
                            break;
                        }
                        try {
                            zzc.zzm("BillingClient", AbstractC1282k.f(i7, "trying subs apiVersion: "));
                            iZzb = bundle == null ? zzarVar.zzb(i7, packageName, "subs") : zzarVar.zzc(i7, packageName, "subs", bundle);
                            if (iZzb == 0) {
                                zzc.zzm("BillingClient", AbstractC1282k.f(i7, "highestLevelSupportedForSubs: "));
                                break;
                            }
                            i7--;
                        } catch (Exception e8) {
                            p1.f(e8, z7);
                            return;
                        }
                    }
                    C0421m c0421m4 = p1.e;
                    c0421m4.f2549j = i7 >= 5;
                    if (i7 < 3) {
                        z6 = false;
                    }
                    c0421m4.f2548i = z6;
                    if (i7 < 3) {
                        zzjsVar = zzjs.SUBSCRIPTIONS_NOT_SUPPORTED;
                        zzc.zzm("BillingClient", "In-app billing API does not support subscription on this device.");
                    }
                    for (int i8 = 29; i8 >= 3; i8--) {
                        zzc.zzm("BillingClient", AbstractC1282k.f(i8, "trying inapp apiVersion: "));
                        iZzb = bundle == null ? zzarVar.zzb(i8, packageName, "inapp") : zzarVar.zzc(i8, packageName, "inapp", bundle);
                        if (iZzb == 0) {
                            c0421m4.f2550k = i8;
                            zzc.zzm("BillingClient", "mHighestLevelSupportedForInApp: " + i8);
                            break;
                        }
                    }
                    C0421m.J(c0421m4, c0421m4.f2550k);
                    if (c0421m4.f2550k < 3) {
                        zzjsVar = zzjs.ONE_TIME_PRODUCT_NOT_SUPPORTED;
                        zzc.zzn("BillingClient", "In-app billing API version 3 is not supported on this device.");
                    }
                    zzjs zzjsVar3 = zzjsVar;
                    C0421m.K(c0421m4, iZzb);
                    if (iZzb == 0) {
                        p1.c(0, z7);
                        p1.d(k1.f2515i);
                    } else {
                        H h7 = k1.b;
                        p1.zzi(h7, zzjsVar3, null, z7, 0);
                        p1.d(h7);
                    }
                } catch (Exception e9) {
                    p1.f(e9, z7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    private final Long zzh(boolean z6) {
        try {
            if (z6) {
                synchronized (this.e.f2544a) {
                    try {
                        com.google.android.gms.internal.play_billing.zzbn zzbnVar = this.b;
                        if (!zzbnVar.zzg()) {
                            return null;
                        }
                        zzbnVar.zzf();
                        return Long.valueOf(zzbnVar.zza(TimeUnit.MILLISECONDS));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            synchronized (this.e.f2544a) {
                try {
                    com.google.android.gms.internal.play_billing.zzbn zzbnVar2 = this.c;
                    if (!zzbnVar2.zzg()) {
                        return null;
                    }
                    zzbnVar2.zzf();
                    return Long.valueOf(zzbnVar2.zza(TimeUnit.MILLISECONDS));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            zzc.zzo("BillingClient", "Exception getting connection establishment duration.", th3);
        }
        zzc.zzo("BillingClient", "Exception getting connection establishment duration.", th3);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzi(H h6, zzjs zzjsVar, @Nullable String str, boolean z6, int i5) {
        try {
            zzjq zzjqVarZza = zzju.zza();
            zzjqVarZza.zzp(h6.f2433a);
            zzjqVarZza.zzb(h6.getDebugMessage());
            zzjqVarZza.zze(zzjsVar);
            zzjqVarZza.zzc(i5);
            if (str != null) {
                zzjqVarZza.zza(str);
            }
            Long lZzh = zzh(z6);
            C0421m c0421m = this.e;
            if (!z6) {
                zzle zzleVarZza = zzlg.zza();
                zzleVarZza.zza(zzjqVarZza);
                if (lZzh != null) {
                    zzleVarZza.zzb(lZzh.longValue());
                }
                ((m1) c0421m.f2545f).f((zzlg) zzleVarZza.zzi());
                return;
            }
            zzll zzllVarZza = zzln.zza();
            int i6 = this.d;
            zzllVarZza.zza(i6 > 0);
            zzllVarZza.zzb(i6);
            zzllVarZza.zzd(i5);
            if (lZzh != null) {
                zzllVarZza.zzc(lZzh.longValue());
            }
            zzjj zzjjVarZza = zzjl.zza();
            zzjjVarZza.zzb(zzjqVarZza);
            zzjjVarZza.zzp(6);
            zzjjVarZza.zze(zzllVarZza);
            c0421m.Q((zzjl) zzjjVarZza.zzi());
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void c(int i5, boolean z6) {
        try {
            Long lZzh = zzh(z6);
            C0421m c0421m = this.e;
            if (!z6) {
                zzle zzleVarZza = zzlg.zza();
                zzjq zzjqVarZza = zzju.zza();
                zzjqVarZza.zzp(0);
                zzjqVarZza.zzc(i5);
                zzleVarZza.zza(zzjqVarZza);
                if (lZzh != null) {
                    zzleVarZza.zzb(lZzh.longValue());
                }
                ((m1) c0421m.f2545f).f((zzlg) zzleVarZza.zzi());
                return;
            }
            zzjn zzjnVarZza = zzjp.zza();
            zzjnVarZza.zze(6);
            zzll zzllVarZza = zzln.zza();
            int i6 = this.d;
            zzllVarZza.zza(i6 > 0);
            zzllVarZza.zzb(i6);
            zzllVarZza.zzd(i5);
            if (lZzh != null) {
                zzllVarZza.zzc(lZzh.longValue());
            }
            zzjnVarZza.zzd(zzllVarZza);
            c0421m.R((zzjp) zzjnVarZza.zzi());
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void d(H h6) {
        C0421m c0421m = this.e;
        synchronized (c0421m.f2544a) {
            try {
                if (c0421m.b == 3) {
                    return;
                }
                try {
                    this.f2447a.onBillingSetupFinished(h6);
                } catch (Throwable th) {
                    zzc.zzo("BillingClient", "Exception while calling onBillingSetupFinished.", th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void e(Exception exc, boolean z6, int i5) {
        zzjs zzjsVar;
        zzc.zzo("BillingClient", "Exception while invoking initialize AIDL method", exc);
        boolean z7 = exc instanceof DeadObjectException;
        if (z7) {
            zzjsVar = zzjs.INITIALIZE_DEAD_OBJECT_EXCEPTION;
        } else if (exc instanceof RemoteException) {
            zzjsVar = zzjs.INITIALIZE_REMOTE_EXCEPTION;
        } else {
            zzjsVar = exc instanceof SecurityException ? zzjs.INITIALIZE_SECURITY_EXCEPTION : zzjs.INITIALIZE_SERVICE_CALL_EXCEPTION;
        }
        zzjs zzjsVar2 = zzjsVar;
        String strZza = i1.zza(exc);
        this.e.T(0);
        zzi(z7 ? k1.f2516j : k1.f2514h, zzjsVar2, strZza, z6, i5);
        d(z7 ? k1.f2516j : k1.f2514h);
    }

    public final void f(Exception exc, boolean z6) {
        zzjs zzjsVar;
        zzc.zzo("BillingClient", "Exception while checking if billing is supported; try to reconnect", exc);
        boolean z7 = exc instanceof DeadObjectException;
        if (z7) {
            zzjsVar = zzjs.IS_BILLING_SUPPORTED_DEAD_OBJECT_EXCEPTION;
        } else if (exc instanceof RemoteException) {
            zzjsVar = zzjs.IS_BILLING_SUPPORTED_REMOTE_EXCEPTION;
        } else {
            zzjsVar = exc instanceof SecurityException ? zzjs.IS_BILLING_SUPPORTED_SECURITY_EXCEPTION : zzjs.IS_BILLING_SUPPORTED_SERVICE_CALL_EXCEPTION;
        }
        zzjs zzjsVar2 = zzjsVar;
        String strZza = zzjsVar2.equals(zzjs.IS_BILLING_SUPPORTED_SERVICE_CALL_EXCEPTION) ? i1.zza(exc) : null;
        this.e.T(0);
        zzi(z7 ? k1.f2516j : k1.f2514h, zzjsVar2, strZza, z6, 0);
        d(z7 ? k1.f2516j : k1.f2514h);
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        boolean z6;
        boolean z7;
        zzc.zzn("BillingClient", "Billing service died.");
        try {
            C0421m c0421m = this.e;
            synchronized (c0421m.f2544a) {
                z6 = true;
                z7 = c0421m.b == 1;
            }
            if (z7) {
                j1 j1Var = c0421m.f2545f;
                zzjj zzjjVarZza = zzjl.zza();
                zzjjVarZza.zzp(6);
                zzjq zzjqVarZza = zzju.zza();
                zzjqVarZza.zze(zzjs.BINDING_DIED);
                zzjjVarZza.zzb(zzjqVarZza);
                zzll zzllVarZza = zzln.zza();
                int i5 = this.d;
                if (i5 <= 0) {
                    z6 = false;
                }
                zzllVarZza.zza(z6);
                zzllVarZza.zzb(i5);
                zzjjVarZza.zze(zzllVarZza);
                ((m1) j1Var).zza((zzjl) zzjjVarZza.zzi());
            } else {
                j1 j1Var2 = c0421m.f2545f;
                zzjx zzjxVarZzb = zzjx.zzb();
                m1 m1Var = (m1) j1Var2;
                m1Var.getClass();
                try {
                    zzku zzkuVarZza = zzkw.zza();
                    zzkuVarZza.zzp(m1Var.b);
                    zzkuVarZza.zzc(zzjxVarZzb);
                    m1Var.c.a((zzkw) zzkuVarZza.zzi());
                } catch (Throwable th) {
                    zzc.zzo("BillingLogger", "Unable to log.", th);
                }
            }
        } catch (Throwable th2) {
            zzc.zzo("BillingClient", "Unable to log.", th2);
        }
        C0421m c0421m2 = this.e;
        synchronized (c0421m2.f2544a) {
            if (c0421m2.b != 3 && c0421m2.b != 0) {
                c0421m2.T(0);
                c0421m2.V();
                try {
                    this.f2447a.d();
                } catch (Throwable th3) {
                    zzc.zzo("BillingClient", "Exception while calling onBillingServiceDisconnected.", th3);
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzc.zzm("BillingClient", "Billing service connected.");
        C0421m c0421m = this.e;
        synchronized (c0421m.f2544a) {
            try {
                if (c0421m.b == 3) {
                    return;
                }
                c0421m.f2546g = zzaq.zzu(iBinder);
                if (C0421m.zzP(new D0(this, 5), 30000L, new H2.c(this, 9), c0421m.u(), c0421m.m()) == null) {
                    int i5 = this.d;
                    H hW = c0421m.w();
                    c0421m.S(i5, hW, zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC);
                    d(hW);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        boolean z6;
        boolean z7;
        zzc.zzn("BillingClient", "Billing service disconnected.");
        try {
            C0421m c0421m = this.e;
            synchronized (c0421m.f2544a) {
                z6 = true;
                z7 = c0421m.b == 1;
            }
            if (z7) {
                j1 j1Var = c0421m.f2545f;
                zzjj zzjjVarZza = zzjl.zza();
                zzjjVarZza.zzp(6);
                zzjq zzjqVarZza = zzju.zza();
                zzjqVarZza.zze(zzjs.SERVICE_DISCONNECTED);
                zzjjVarZza.zzb(zzjqVarZza);
                zzll zzllVarZza = zzln.zza();
                int i5 = this.d;
                if (i5 <= 0) {
                    z6 = false;
                }
                zzllVarZza.zza(z6);
                zzllVarZza.zzb(i5);
                zzjjVarZza.zze(zzllVarZza);
                ((m1) j1Var).zza((zzjl) zzjjVarZza.zzi());
            } else {
                ((m1) c0421m.f2545f).zzn(zzlk.zzb());
            }
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
        C0421m c0421m2 = this.e;
        synchronized (c0421m2.f2544a) {
            try {
                if (p002a.c.e) {
                    if (c0421m2.b != 3 && c0421m2.b != 0) {
                        com.google.android.gms.internal.play_billing.zzbn zzbnVar = this.c;
                        zzbnVar.zzd();
                        zzbnVar.zze();
                    }
                    return;
                }
                com.google.android.gms.internal.play_billing.zzbn zzbnVar2 = this.c;
                zzbnVar2.zzd();
                zzbnVar2.zze();
                if (c0421m2.b == 3) {
                    return;
                }
                c0421m2.T(0);
                try {
                    this.f2447a.d();
                } catch (Throwable th2) {
                    zzc.zzo("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}
