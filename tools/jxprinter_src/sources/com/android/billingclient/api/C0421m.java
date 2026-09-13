package com.android.billingclient.api;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.BundleCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzar;
import com.google.android.gms.internal.play_billing.zzbf;
import com.google.android.gms.internal.play_billing.zzbo;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzca;
import com.google.android.gms.internal.play_billing.zzcf;
import com.google.android.gms.internal.play_billing.zzcg;
import com.google.android.gms.internal.play_billing.zzdf;
import com.google.android.gms.internal.play_billing.zzdk;
import com.google.android.gms.internal.play_billing.zzes;
import com.google.android.gms.internal.play_billing.zzij;
import com.google.android.gms.internal.play_billing.zzim;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjf;
import com.google.android.gms.internal.play_billing.zzjj;
import com.google.android.gms.internal.play_billing.zzjl;
import com.google.android.gms.internal.play_billing.zzjn;
import com.google.android.gms.internal.play_billing.zzjp;
import com.google.android.gms.internal.play_billing.zzjq;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzju;
import com.google.android.gms.internal.play_billing.zzjz;
import com.google.android.gms.internal.play_billing.zzke;
import com.google.android.gms.internal.play_billing.zzkg;
import com.google.android.gms.internal.play_billing.zzkk;
import com.google.android.gms.internal.play_billing.zzkn;
import com.google.android.gms.internal.play_billing.zzll;
import com.google.android.gms.internal.play_billing.zzln;
import com.google.android.gms.internal.play_billing.zzu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONException;
import org.json.JSONObject;
import p079o.AbstractC1282k;

/* JADX INFO: renamed from: com.android.billingclient.api.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class C0421m extends AbstractC0419l {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f2534A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public boolean f2535B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f2536C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f2537D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public boolean f2538E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public boolean f2539F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public zzcf f2540G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public ExecutorService f2541H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final Long f2542I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final com.google.android.gms.internal.play_billing.zzbq f2543J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2544a;
    public volatile int b;
    public final String c;
    public final Handler d;
    public Context e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j1 f2545f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile zzar f2546g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile P0 f2547h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2548i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2549j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f2550k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2551l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2552m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2553n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2554o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2555p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2556q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2557r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2558s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2559t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f2560u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2561v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2562w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f2563x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2564y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2565z;

    @Nullable
    private C0416j0 zzG;

    @Nullable
    private volatile InterfaceC0423n zzK;

    @Nullable
    private final String zzd;

    @Nullable
    private volatile y1 zzf;

    @AnyThread
    public C0421m(@Nullable String str, Context context, @Nullable j1 j1Var, @Nullable ExecutorService executorService, C0417k c0417k) {
        this.f2544a = new Object();
        this.b = 0;
        this.d = new Handler(Looper.getMainLooper());
        this.f2550k = 0;
        this.f2540G = zzcf.zzk();
        long jNextLong = new Random().nextLong();
        this.f2542I = Long.valueOf(jNextLong);
        this.f2543J = zzbf.zza();
        this.c = "9.1.0";
        String strZzaO = zzaO();
        this.zzd = strZzaO;
        this.e = context.getApplicationContext();
        zzke zzkeVarZza = zzkg.zza();
        zzkeVarZza.zzx("9.1.0");
        if (strZzaO != null) {
            zzkeVarZza.zzy(strZzaO);
        }
        zzkeVarZza.zzq(this.e.getPackageName());
        zzkeVarZza.zzd(jNextLong);
        zzkeVarZza.zzw(c0417k.f2489j);
        zzkeVarZza.zza(Build.VERSION.SDK_INT);
        zzkeVarZza.zzp(926300087L);
        L(zzkeVarZza, context);
        try {
            zzkeVarZza.zzb(this.e.getPackageManager().getPackageInfo(this.e.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.f2545f = new m1(this.e, (zzkg) zzkeVarZza.zzi());
        this.e.getPackageName();
        this.f2538E = c0417k.f2489j;
    }

    public static /* synthetic */ void A(C0421m c0421m, H h6) {
        if (c0421m.zzf.zze() != null) {
            ((p062l0.d) c0421m.zzf.zze()).onPurchasesUpdated(h6, null);
        } else {
            zzc.zzn("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    public static /* bridge */ /* synthetic */ void J(C0421m c0421m, int i5) {
        c0421m.f2550k = i5;
        c0421m.f2537D = i5 >= 29;
        c0421m.f2536C = i5 >= 28;
        c0421m.f2535B = i5 >= 27;
        c0421m.f2534A = i5 >= 26;
        c0421m.f2565z = i5 >= 24;
        c0421m.f2564y = i5 >= 23;
        c0421m.f2563x = i5 >= 22;
        c0421m.f2562w = i5 >= 21;
        c0421m.f2561v = i5 >= 20;
        c0421m.f2560u = i5 >= 19;
        c0421m.f2559t = i5 >= 18;
        c0421m.f2558s = i5 >= 17;
        c0421m.f2557r = i5 >= 16;
        c0421m.f2556q = i5 >= 15;
        c0421m.f2555p = i5 >= 14;
        c0421m.f2554o = i5 >= 12;
        c0421m.f2553n = i5 >= 9;
        c0421m.f2552m = i5 >= 8;
        c0421m.f2551l = i5 >= 6;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void K(C0421m c0421m, int i5) {
        if (i5 != 0) {
            c0421m.T(0);
            return;
        }
        synchronized (c0421m.f2544a) {
            try {
                if (c0421m.b == 3) {
                    return;
                }
                c0421m.T(2);
                y1 y1Var = c0421m.zzf != null ? c0421m.zzf : null;
                if (y1Var != null) {
                    boolean z6 = c0421m.f2562w;
                    IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
                    IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
                    intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
                    y1Var.f2594f = z6;
                    x1 x1Var = y1Var.e;
                    Context context = y1Var.f2593a;
                    x1Var.a(context, intentFilter2);
                    if (!y1Var.f2594f) {
                        y1Var.d.a(context, intentFilter);
                        return;
                    }
                    x1 x1Var2 = y1Var.d;
                    synchronized (x1Var2) {
                        try {
                            if (x1Var2.f2591a) {
                                return;
                            }
                            if (Build.VERSION.SDK_INT >= 33) {
                                context.registerReceiver(x1Var2, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != x1Var2.b ? 4 : 2);
                            } else {
                                context.registerReceiver(x1Var2, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                            }
                            x1Var2.f2591a = true;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static final void L(zzke zzkeVar, Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                zzkeVar.zzv((int) (memoryInfo.totalMem / 1048576));
                zzkeVar.zzr(Build.BRAND);
                zzkeVar.zzu(Build.MODEL);
                zzkeVar.zzt(Build.MANUFACTURER);
                zzkeVar.zzs(Build.FINGERPRINT);
            }
        } catch (RuntimeException e) {
            zzc.zzo("BillingClient", "Runtime error while populating device info.", e);
        }
    }

    public static void f(C0421m c0421m, C0410g0 c0410g0, Activity activity) {
        zzar zzarVar;
        try {
            if (!c0421m.X(p002a.c.c)) {
                c0421m.zzbk(null, k1.f2516j, zzjs.SERVICE_CONNECTION_NOT_READY, null);
                return;
            }
            if (!c0421m.f2535B) {
                zzc.zzn("BillingClient", "Current client doesn't support launch external link.");
                c0421m.zzbk(null, k1.f2507H, zzjs.LAUNCH_EXTERNAL_LINK_NOT_SUPPORTED, null);
                return;
            }
            synchronized (c0421m.f2544a) {
                zzarVar = c0421m.f2546g;
            }
            if (zzarVar == null) {
                c0421m.zzbk(null, k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, null);
                return;
            }
            String packageName = c0421m.e.getPackageName();
            String str = c0421m.zzd;
            long jLongValue = c0421m.f2542I.longValue();
            int i5 = zzc.zza;
            Bundle bundle = new Bundle();
            zzc.zzc(bundle, "9.1.0", str, jLongValue);
            zzij zzijVarZza = zzim.zza();
            zzjd zzjdVarZza = zzjf.zza();
            zzjdVarZza.zza(c0410g0.getLinkUri().toString());
            zzijVarZza.zza("externalOfferUri", (zzjf) zzjdVarZza.zzi());
            zzjd zzjdVarZza2 = zzjf.zza();
            zzjdVarZza2.zza(String.valueOf(c0410g0.getLaunchMode()));
            zzijVarZza.zza("externalOfferLaunchMode", (zzjf) zzjdVarZza2.zzi());
            zzjd zzjdVarZza3 = zzjf.zza();
            zzjdVarZza3.zza(String.valueOf(c0410g0.getLinkType()));
            zzijVarZza.zza("externalOfferLinkType", (zzjf) zzjdVarZza3.zzi());
            zzjd zzjdVarZza4 = zzjf.zza();
            zzjdVarZza4.zza(String.valueOf(c0410g0.getBillingProgram()));
            zzijVarZza.zza("externalOfferBillingProgram", (zzjf) zzjdVarZza4.zzi());
            if (!TextUtils.isEmpty(c0410g0.getExternalTransactionToken())) {
                zzjd zzjdVarZza5 = zzjf.zza();
                zzjdVarZza5.zza(c0410g0.getExternalTransactionToken());
                zzijVarZza.zza("externalTransactionToken", (zzjf) zzjdVarZza5.zzi());
            }
            bundle.putByteArray("REQUEST_PARAMS", ((zzim) zzijVarZza.zzi()).zzQ());
            zzarVar.zzp(27, packageName, bundle, new V0(c0421m, new WeakReference(activity)));
        } catch (RuntimeException e) {
            c0421m.zzbk(null, k1.f2514h, zzjs.SERVICE_CALL_EXCEPTION, e);
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00c7 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.android.billingclient.api.m] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.android.billingclient.api.m] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.android.billingclient.api.m] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g0(com.android.billingclient.api.C0421m r8, com.android.billingclient.api.K r9, com.android.billingclient.api.J r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.C0421m.g0(com.android.billingclient.api.m, com.android.billingclient.api.K, com.android.billingclient.api.J):void");
    }

    private void initialize(Context context, InterfaceC0435t0 interfaceC0435t0, C0416j0 c0416j0, @Nullable C0 c6, @Nullable O o6, String str, @Nullable j1 j1Var, C0417k c0417k) {
        this.e = context.getApplicationContext();
        zzke zzkeVarZza = zzkg.zza();
        zzkeVarZza.zzx(str);
        String str2 = this.zzd;
        if (str2 != null) {
            zzkeVarZza.zzy(str2);
        }
        zzkeVarZza.zzq(this.e.getPackageName());
        zzkeVarZza.zzd(this.f2542I.longValue());
        zzkeVarZza.zzw(c0417k.f2489j);
        zzkeVarZza.zza(Build.VERSION.SDK_INT);
        zzkeVarZza.zzp(926300087L);
        L(zzkeVarZza, context);
        try {
            zzkeVarZza.zzb(this.e.getPackageManager().getPackageInfo(this.e.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        if (j1Var != null) {
            this.f2545f = j1Var;
        } else {
            this.f2545f = new m1(this.e, (zzkg) zzkeVarZza.zzi());
        }
        if (interfaceC0435t0 == null) {
            zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzf = new y1(this.e, interfaceC0435t0, this.f2545f);
        this.zzG = c0416j0;
        this.f2539F = c6 != null;
        this.f2538E = c0417k.f2489j;
    }

    public static void l(C0421m c0421m) {
        zzar zzarVar;
        try {
            if (!c0421m.X(p002a.c.c)) {
                c0421m.zzba(null, k1.f2516j, zzjs.SERVICE_CONNECTION_NOT_READY, null);
                return;
            }
            if (!c0421m.f2562w) {
                zzc.zzn("BillingClient", "Current client doesn't support alternative billing only.");
                c0421m.zzba(null, k1.f2503D, zzjs.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, null);
                return;
            }
            synchronized (c0421m.f2544a) {
                zzarVar = c0421m.f2546g;
            }
            if (zzarVar == null) {
                c0421m.zzba(null, k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, null);
            } else {
                zzarVar.zzr(21, c0421m.e.getPackageName(), zzc.zzh(c0421m.c, c0421m.zzd, c0421m.f2542I.longValue()), new X0(c0421m.f2545f, c0421m.f2550k));
            }
        } catch (Exception e) {
            c0421m.zzba(null, e instanceof DeadObjectException ? k1.f2516j : k1.f2514h, zzjs.IS_ALTERNATIVE_BILLING_ONLY_AVAILABLE_SERVICE_CALL_EXCEPTION, e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0147 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x01aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0153  */
    /* JADX WARN: Code duplicated, block: B:73:0x016d  */
    /* JADX WARN: Code duplicated, block: B:77:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:82:0x01c2  */
    public static u1 t(C0421m c0421m, String str, boolean z6) {
        zzar zzarVar;
        int i5;
        int i6;
        Bundle bundleZzi;
        H hC;
        zzjs zzjsVar;
        ArrayList<String> stringArrayList;
        ArrayList<String> stringArrayList2;
        ArrayList<String> stringArrayList3;
        int i7;
        boolean z7;
        C0431r0 c0431r0;
        c0421m.getClass();
        zzc.zzm("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        boolean z8 = c0421m.f2553n;
        boolean z9 = c0421m.f2560u;
        c0421m.zzG.getClass();
        boolean z10 = c0421m.zzG.f2482a;
        long jLongValue = c0421m.f2542I.longValue();
        Bundle bundle = new Bundle();
        zzc.zzc(bundle, "9.1.0", c0421m.zzd, jLongValue);
        if (z8) {
            bundle.putBoolean("enablePendingPurchases", true);
        }
        if (z9 && z10) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        if (z6) {
            bundle.putBoolean("includeSuspendedSubscriptions", true);
        }
        String string = null;
        do {
            try {
                synchronized (c0421m.f2544a) {
                    zzarVar = c0421m.f2546g;
                }
                if (zzarVar == null) {
                    return c0421m.zzbB(9, k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, "Service has been reset to null", null);
                }
                if (z6 && !c0421m.f2534A) {
                    return c0421m.zzbB(9, k1.f2530x, zzjs.INCLUDE_SUSPENDED_SUBSCRIPTIONS_NOT_SUPPORTED, "Include suspended subscriptions is not supported", null);
                }
                if (c0421m.f2553n) {
                    if (c0421m.f2534A) {
                        i6 = 26;
                    } else if (c0421m.f2565z) {
                        i6 = 24;
                    } else {
                        if (c0421m.f2560u) {
                            i6 = 19;
                        } else {
                            i5 = 9;
                        }
                        bundleZzi = zzarVar.zzi(i5, c0421m.e.getPackageName(), str, string, bundle);
                    }
                    i5 = i6;
                    bundleZzi = zzarVar.zzi(i5, c0421m.e.getPackageName(), str, string, bundle);
                } else {
                    bundleZzi = zzarVar.zzh(3, c0421m.e.getPackageName(), str, string);
                }
                H h6 = k1.f2514h;
                if (bundleZzi == null) {
                    zzc.zzn("BillingClient", "getPurchase() got null owned items list");
                    zzjsVar = zzjs.NULL_OWNED_ITEMS_LIST;
                } else {
                    int iZzb = zzc.zzb(bundleZzi, "BillingClient");
                    hC = androidx.exifinterface.media.a.c(iZzb, zzc.zzj(bundleZzi, "BillingClient"));
                    if (iZzb != 0) {
                        zzc.zzn("BillingClient", "getPurchase() failed. Response code: " + iZzb);
                        zzjsVar = zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
                    } else if (bundleZzi.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundleZzi.containsKey("INAPP_PURCHASE_DATA_LIST") && bundleZzi.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                        ArrayList<String> stringArrayList4 = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                        ArrayList<String> stringArrayList5 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        ArrayList<String> stringArrayList6 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                        if (stringArrayList4 == null) {
                            zzc.zzn("BillingClient", "Bundle returned from getPurchase() contains null SKUs list.");
                            zzjsVar = zzjs.NULL_SKUS_LIST;
                        } else if (stringArrayList5 == null) {
                            zzc.zzn("BillingClient", "Bundle returned from getPurchase() contains null purchases list.");
                            zzjsVar = zzjs.NULL_PURCHASES_LIST;
                        } else if (stringArrayList6 == null) {
                            zzc.zzn("BillingClient", "Bundle returned from getPurchase() contains null signatures list.");
                            zzjsVar = zzjs.NULL_SIGNATURES_LIST;
                        } else {
                            hC = k1.f2515i;
                            zzjsVar = zzjs.REASON_UNSPECIFIED;
                        }
                    } else {
                        zzc.zzn("BillingClient", "Bundle returned from getPurchase() doesn't contain required fields.");
                        zzjsVar = zzjs.MISSING_REQUIRED_PURCHASE_KEY;
                    }
                    if (hC != k1.f2515i) {
                        return c0421m.zzbB(9, hC, zzjsVar, "Purchase bundle invalid", null);
                    }
                    stringArrayList = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    stringArrayList2 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    stringArrayList3 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    z7 = false;
                    for (i7 = 0; i7 < stringArrayList2.size(); i7++) {
                        String str2 = stringArrayList2.get(i7);
                        String str3 = stringArrayList3.get(i7);
                        zzc.zzm("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i7))));
                        try {
                            c0431r0 = new C0431r0(str2, str3);
                            c0421m.f2540G.isEmpty();
                            if (TextUtils.isEmpty(c0431r0.getPurchaseToken())) {
                                zzc.zzn("BillingClient", "BUG: empty/null token!");
                                z7 = true;
                            }
                            arrayList.add(c0431r0);
                        } catch (JSONException e) {
                            return c0421m.zzbB(9, k1.f2514h, zzjs.ERROR_DECODING_PURCHASE_DATA, "Got an exception trying to decode the purchase!", e);
                        }
                    }
                    if (z7) {
                        c0421m.N(9, h6, zzjs.EMPTY_PURCHASE_TOKEN);
                    }
                    string = bundleZzi.getString("INAPP_CONTINUATION_TOKEN");
                    zzc.zzm("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                }
                hC = h6;
                if (hC != k1.f2515i) {
                    return c0421m.zzbB(9, hC, zzjsVar, "Purchase bundle invalid", null);
                }
                stringArrayList = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                stringArrayList2 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                stringArrayList3 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                z7 = false;
                while (i7 < stringArrayList2.size()) {
                    String str4 = stringArrayList2.get(i7);
                    String str5 = stringArrayList3.get(i7);
                    zzc.zzm("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i7))));
                    c0431r0 = new C0431r0(str4, str5);
                    c0421m.f2540G.isEmpty();
                    if (TextUtils.isEmpty(c0431r0.getPurchaseToken())) {
                        zzc.zzn("BillingClient", "BUG: empty/null token!");
                        z7 = true;
                    }
                    arrayList.add(c0431r0);
                }
                if (z7) {
                    c0421m.N(9, h6, zzjs.EMPTY_PURCHASE_TOKEN);
                }
                string = bundleZzi.getString("INAPP_CONTINUATION_TOKEN");
                zzc.zzm("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
            } catch (DeadObjectException e6) {
                return c0421m.zzbB(9, k1.f2516j, zzjs.GET_PURCHASE_SERVICE_CALL_EXCEPTION, "Got exception trying to get purchases try to reconnect", e6);
            } catch (Exception e7) {
                return c0421m.zzbB(9, k1.f2514h, zzjs.GET_PURCHASE_SERVICE_CALL_EXCEPTION, "Got exception trying to get purchases try to reconnect", e7);
            }
        } while (!TextUtils.isEmpty(string));
        return new u1(k1.f2515i, arrayList);
    }

    @Nullable
    public static Future zzP(Callable callable, long j6, @Nullable Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            Future futureSubmit = executorService.submit(callable);
            handler.postDelayed(new K0(futureSubmit, runnable, 0), (long) (j6 * 0.95d));
            return futureSubmit;
        } catch (Exception e) {
            zzc.zzo("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle zzaC(int i5, String str, String str2, C0442x c0442x, Bundle bundle) {
        zzar zzarVar;
        try {
            synchronized (this.f2544a) {
                zzarVar = this.f2546g;
            }
            return zzarVar == null ? zzc.zzd(k1.f2516j, zzjs.SERVICE_RESET_TO_NULL) : zzarVar.zzg(i5, this.e.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e) {
            return zzc.zze(k1.f2516j, zzjs.LAUNCH_BILLING_FLOW_EXCEPTION, i1.zza(e));
        } catch (Exception e6) {
            return zzc.zze(k1.f2514h, zzjs.LAUNCH_BILLING_FLOW_EXCEPTION, i1.zza(e6));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle zzaD(String str, String str2) {
        zzar zzarVar;
        try {
            synchronized (this.f2544a) {
                zzarVar = this.f2546g;
            }
            return zzarVar == null ? zzc.zzd(k1.f2516j, zzjs.SERVICE_RESET_TO_NULL) : zzarVar.zzf(3, this.e.getPackageName(), str, str2, null);
        } catch (DeadObjectException e) {
            return zzc.zze(k1.f2516j, zzjs.LAUNCH_BILLING_FLOW_EXCEPTION, i1.zza(e));
        } catch (Exception e6) {
            return zzc.zze(k1.f2514h, zzjs.LAUNCH_BILLING_FLOW_EXCEPTION, i1.zza(e6));
        }
    }

    private final b1 zzaF(H h6, zzjs zzjsVar, String str, @Nullable Exception exc) {
        zzc.zzo("BillingClient", str, exc);
        zzbG(zzjsVar, 7, h6, i1.zza(exc));
        return new b1(h6.f2433a, h6.getDebugMessage(), new ArrayList(), new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzaJ(InterfaceC0403d interfaceC0403d, C0401c c0401c) {
        zzar zzarVar;
        try {
            if (!X(p002a.c.c)) {
                N(3, k1.f2516j, zzjs.SERVICE_CONNECTION_NOT_READY);
                interfaceC0403d.a();
                return null;
            }
            if (TextUtils.isEmpty(c0401c.getPurchaseToken())) {
                zzc.zzn("BillingClient", "Please provide a valid purchase token.");
                N(3, k1.f2513g, zzjs.EMPTY_PURCHASE_TOKEN);
                interfaceC0403d.a();
                return null;
            }
            if (!this.f2553n) {
                N(3, k1.f2511a, zzjs.API_VERSION_NOT_V9);
                interfaceC0403d.a();
                return null;
            }
            synchronized (this.f2544a) {
                zzarVar = this.f2546g;
            }
            if (zzarVar == null) {
                zzaZ(interfaceC0403d, k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, null);
                return null;
            }
            String packageName = this.e.getPackageName();
            String purchaseToken = c0401c.getPurchaseToken();
            String str = this.zzd;
            long jLongValue = this.f2542I.longValue();
            int i5 = zzc.zza;
            Bundle bundle = new Bundle();
            zzc.zzc(bundle, "9.1.0", str, jLongValue);
            Bundle bundleZzd = zzarVar.zzd(9, packageName, purchaseToken, bundle);
            k1.a(zzc.zzb(bundleZzd, "BillingClient"), zzc.zzj(bundleZzd, "BillingClient"));
            interfaceC0403d.a();
            return null;
        } catch (DeadObjectException e) {
            zzaZ(interfaceC0403d, k1.f2516j, zzjs.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e6) {
            zzaZ(interfaceC0403d, k1.f2514h, zzjs.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzaK(InterfaceC0415j interfaceC0415j, X x6) {
        zzar zzarVar;
        try {
            if (!X(p002a.c.c)) {
                zzbb(interfaceC0415j, k1.f2516j, zzjs.SERVICE_CONNECTION_NOT_READY, null);
                return null;
            }
            if (this.f2550k < 24) {
                zzbb(interfaceC0415j, k1.f2510K, zzjs.FEATURE_NOT_SUPPORTED, null);
                return null;
            }
            synchronized (this.f2544a) {
                zzarVar = this.f2546g;
            }
            if (zzarVar == null) {
                zzbb(interfaceC0415j, k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, null);
                return null;
            }
            String str = this.c;
            zzes zzesVarN = p079o.J.n(this.e, "getBillingChoiceInfo");
            zzij zzijVarZza = zzim.zza();
            zzjd zzjdVarZza = zzjf.zza();
            zzjdVarZza.zza(str);
            zzijVarZza.zza("PLAY_BILLING_LIBRARY_VERSION", (zzjf) zzjdVarZza.zzi());
            zzjd zzjdVarZza2 = zzjf.zza();
            zzjdVarZza2.zza(this.e.getPackageName());
            zzijVarZza.zza("CALLING_PACKAGE", (zzjf) zzjdVarZza2.zzi());
            zzjd zzjdVarZza3 = zzjf.zza();
            zzjdVarZza3.zza(String.valueOf(x6.f2458a));
            zzijVarZza.zza("BILLING_PROGRAM", (zzjf) zzjdVarZza3.zzi());
            if (x6.getUserLocale() != null) {
                zzjd zzjdVarZza4 = zzjf.zza();
                zzjdVarZza4.zza(x6.getUserLocale().toLanguageTag());
                zzijVarZza.zza("LANGUAGE", (zzjf) zzjdVarZza4.zzi());
            }
            if (x6.getPlayBillingChoiceImageLayout() != null) {
                zzjd zzjdVarZza5 = zzjf.zza();
                zzjdVarZza5.zza(x6.getPlayBillingChoiceImageLayout());
                zzijVarZza.zza("PLAY_BILLING_CHOICE_IMAGE_LAYOUT", (zzjf) zzjdVarZza5.zzi());
            }
            zzarVar.zzm(p079o.J.m(zzesVarN, (zzim) zzijVarZza.zzi()), new o1(this.f2545f, this.f2550k));
            return null;
        } catch (DeadObjectException e) {
            zzbb(interfaceC0415j, k1.f2516j, zzjs.SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e6) {
            zzbb(interfaceC0415j, k1.f2514h, zzjs.SERVICE_CALL_EXCEPTION, e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzaL(InterfaceC0427p interfaceC0427p) {
        zzar zzarVar;
        try {
            if (!X(p002a.c.c)) {
                zzc.zzn("BillingClient", "Service disconnected.");
                N(13, k1.f2516j, zzjs.SERVICE_CONNECTION_NOT_READY);
                interfaceC0427p.a();
                return null;
            }
            if (!this.f2559t) {
                zzc.zzn("BillingClient", "Current client doesn't support get billing config.");
                N(13, k1.f2532z, zzjs.GET_BILLING_CONFIG_NOT_SUPPORTED);
                interfaceC0427p.a();
                return null;
            }
            synchronized (this.f2544a) {
                zzarVar = this.f2546g;
            }
            if (zzarVar == null) {
                zzbj(interfaceC0427p, k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, null);
                return null;
            }
            if (!p002a.c.f904a || !this.f2565z) {
                String packageName = this.e.getPackageName();
                String str = this.zzd;
                long jLongValue = this.f2542I.longValue();
                int i5 = zzc.zza;
                Bundle bundle = new Bundle();
                zzc.zzc(bundle, "9.1.0", str, jLongValue);
                if (!TextUtils.isEmpty(null)) {
                    bundle.putString("accountName", null);
                }
                zzarVar.zzo(18, packageName, bundle, new T0(this.f2545f, this.f2550k));
                return null;
            }
            String str2 = this.c;
            zzes zzesVarN = p079o.J.n(this.e, "getBillingConfig");
            zzij zzijVarZza = zzim.zza();
            zzjd zzjdVarZza = zzjf.zza();
            zzjdVarZza.zza(str2);
            zzijVarZza.zza("PLAY_BILLING_LIBRARY_VERSION", (zzjf) zzjdVarZza.zzi());
            zzjd zzjdVarZza2 = zzjf.zza();
            zzjdVarZza2.zza(this.e.getPackageName());
            zzijVarZza.zza("CALLING_PACKAGE", (zzjf) zzjdVarZza2.zzi());
            Bundle bundleM = p079o.J.m(zzesVarN, (zzim) zzijVarZza.zzi());
            if (!TextUtils.isEmpty(null)) {
                bundleM.putString("accountName", null);
            }
            new p1();
            throw null;
        } catch (DeadObjectException e) {
            zzbj(interfaceC0427p, k1.f2516j, zzjs.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e6) {
            zzbj(interfaceC0427p, k1.f2514h, zzjs.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Object zzaM(Bundle bundle, Activity activity, ResultReceiver resultReceiver) {
        zzar zzarVar;
        try {
            synchronized (this.f2544a) {
                zzarVar = this.f2546g;
            }
            if (zzarVar == null) {
                zzbn(-1, zzjs.SERVICE_RESET_TO_NULL, null);
                return null;
            }
            zzarVar.zzt(12, this.e.getPackageName(), bundle, new Z0(new WeakReference(activity), resultReceiver));
            return null;
        } catch (DeadObjectException e) {
            zzbn(-1, zzjs.SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e6) {
            zzbn(6, zzjs.SERVICE_CALL_EXCEPTION, e6);
            return null;
        }
    }

    @Nullable
    @SuppressLint({"PrivateApi"})
    private static String zzaO() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void zzaP(InterfaceC0411h interfaceC0411h) {
        zzar zzarVar;
        try {
            if (!X(p002a.c.c)) {
                zzbe(interfaceC0411h, k1.f2516j, zzjs.SERVICE_CONNECTION_NOT_READY, null);
                return null;
            }
            if (!this.f2562w) {
                zzc.zzn("BillingClient", "Current client doesn't support alternative billing only.");
                zzbe(interfaceC0411h, k1.f2503D, zzjs.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, null);
                return null;
            }
            synchronized (this.f2544a) {
                zzarVar = this.f2546g;
            }
            if (zzarVar == null) {
                zzbe(interfaceC0411h, k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, null);
                return null;
            }
            zzarVar.zzk(21, this.e.getPackageName(), zzc.zzh(this.c, this.zzd, this.f2542I.longValue()), new Q0(this.f2545f, this.f2550k));
            return null;
        } catch (DeadObjectException e) {
            zzbe(interfaceC0411h, k1.f2516j, zzjs.CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e6) {
            zzbe(interfaceC0411h, k1.f2514h, zzjs.CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL_EXCEPTION, e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void zzaQ(D d, F f6) {
        zzar zzarVar;
        try {
            if (!X(p002a.c.c)) {
                zzbf(d, k1.f2516j, zzjs.SERVICE_CONNECTION_NOT_READY, null);
                return null;
            }
            if (!this.f2535B) {
                zzc.zzn("BillingClient", "Current client doesn't support the provided billing program.");
                zzbf(d, k1.f2506G, zzjs.BILLING_PROGRAM_NOT_SUPPORTED, null);
                return null;
            }
            synchronized (this.f2544a) {
                zzarVar = this.f2546g;
            }
            if (zzarVar == null) {
                zzbf(d, k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, null);
                return null;
            }
            String str = this.c;
            zzes zzesVarN = p079o.J.n(this.e, "createIndirectBillingReportingDetails");
            zzij zzijVarZza = zzim.zza();
            zzjd zzjdVarZza = zzjf.zza();
            zzjdVarZza.zza(str);
            zzijVarZza.zza("PLAY_BILLING_LIBRARY_VERSION", (zzjf) zzjdVarZza.zzi());
            zzjd zzjdVarZza2 = zzjf.zza();
            zzjdVarZza2.zza(this.e.getPackageName());
            zzijVarZza.zza("CALLING_PACKAGE", (zzjf) zzjdVarZza2.zzi());
            zzjd zzjdVarZza3 = zzjf.zza();
            zzjdVarZza3.zza(String.valueOf(f6.f2428a));
            zzijVarZza.zza("BILLING_PROGRAM", (zzjf) zzjdVarZza3.zzi());
            zzjd zzjdVarZza4 = zzjf.zza();
            zzjdVarZza4.zza("RESPONSE_FORMAT_PROTO");
            zzijVarZza.zza("RESPONSE_FORMAT", (zzjf) zzjdVarZza4.zzi());
            int i5 = f6.f2428a;
            if (i5 == 3) {
                zzjd zzjdVarZza5 = zzjf.zza();
                zzjdVarZza5.zza(String.valueOf(this.e.getPackageManager().getPackageInfo(this.e.getPackageName(), 0).firstInstallTime));
                zzijVarZza.zza("APP_INSTALL_TIME_MILLIS", (zzjf) zzjdVarZza5.zzi());
            } else if (i5 == 5) {
                zzjd zzjdVarZza6 = zzjf.zza();
                zzjdVarZza6.zza(String.valueOf(f6.getDeveloperBillingType()));
                zzijVarZza.zza("DEVELOPER_BILLING_TYPE", (zzjf) zzjdVarZza6.zzi());
            }
            p079o.J.m(zzesVarN, (zzim) zzijVarZza.zzi());
            u();
            m();
            new L();
            throw null;
        } catch (DeadObjectException e) {
            zzbf(d, k1.f2516j, zzjs.SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (RuntimeException e6) {
            zzbf(d, k1.f2514h, zzjs.SERVICE_CALL_EXCEPTION, e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void zzaR(V v6) {
        zzar zzarVar;
        try {
            if (!X(p002a.c.c)) {
                zzbg(v6, k1.f2516j, zzjs.SERVICE_CONNECTION_NOT_READY, null);
                return null;
            }
            if (!this.f2563x) {
                zzc.zzn("BillingClient", "Current client doesn't support external offer.");
                zzbg(v6, k1.f2527u, zzjs.EXTERNAL_OFFER_NOT_SUPPORTED, null);
                return null;
            }
            synchronized (this.f2544a) {
                zzarVar = this.f2546g;
            }
            if (zzarVar == null) {
                zzbg(v6, k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, null);
                return null;
            }
            String packageName = this.e.getPackageName();
            long j6 = this.e.getPackageManager().getPackageInfo(this.e.getPackageName(), 0).firstInstallTime;
            String str = this.zzd;
            long jLongValue = this.f2542I.longValue();
            int i5 = zzc.zza;
            Bundle bundle = new Bundle();
            zzc.zzc(bundle, "9.1.0", str, jLongValue);
            bundle.putLong("appInstallTimeMillis", j6);
            zzarVar.zzl(22, packageName, bundle, new R0(this.f2545f, this.f2550k));
            return null;
        } catch (DeadObjectException e) {
            zzbg(v6, k1.f2516j, zzjs.CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e6) {
            zzbg(v6, k1.f2514h, zzjs.CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL_EXCEPTION, e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void zzaS(InterfaceC0444y interfaceC0444y, int i5) {
        zzar zzarVar;
        try {
            if (!X(p002a.c.c)) {
                zzbc(interfaceC0444y, i5, k1.f2516j, zzjs.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.f2535B) {
                synchronized (this.f2544a) {
                    zzarVar = this.f2546g;
                }
                if (zzarVar != null) {
                    String str = this.c;
                    zzes zzesVarN = p079o.J.n(this.e, "isIndirectBillingProgramAvailable");
                    zzij zzijVarZza = zzim.zza();
                    zzjd zzjdVarZza = zzjf.zza();
                    zzjdVarZza.zza(str);
                    zzijVarZza.zza("PLAY_BILLING_LIBRARY_VERSION", (zzjf) zzjdVarZza.zzi());
                    zzjd zzjdVarZza2 = zzjf.zza();
                    zzjdVarZza2.zza(this.e.getPackageName());
                    zzijVarZza.zza("CALLING_PACKAGE", (zzjf) zzjdVarZza2.zzi());
                    zzjd zzjdVarZza3 = zzjf.zza();
                    zzjdVarZza3.zza(String.valueOf(i5));
                    zzijVarZza.zza("BILLING_PROGRAM", (zzjf) zzjdVarZza3.zzi());
                    p079o.J.m(zzesVarN, (zzim) zzijVarZza.zzi());
                    u();
                    m();
                    new BinderC0406e0();
                    throw null;
                }
                zzbc(interfaceC0444y, i5, k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, null);
            } else {
                zzc.zzn("BillingClient", "Current client doesn't support the provided billing program.");
                zzbc(interfaceC0444y, i5, k1.f2506G, zzjs.BILLING_PROGRAM_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzbc(interfaceC0444y, i5, k1.f2516j, zzjs.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e6) {
            zzbc(interfaceC0444y, i5, k1.f2514h, zzjs.SERVICE_CALL_EXCEPTION, e6);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void zzaT(S s6) {
        zzar zzarVar;
        try {
            if (!X(p002a.c.c)) {
                zzbh(s6, k1.f2516j, zzjs.SERVICE_CONNECTION_NOT_READY, null);
                return null;
            }
            if (!this.f2565z) {
                zzc.zzn("BillingClient", "Current client doesn't support external offer.");
                zzbh(s6, k1.f2527u, zzjs.EXTERNAL_OFFER_NOT_SUPPORTED, null);
                return null;
            }
            synchronized (this.f2544a) {
                zzarVar = this.f2546g;
            }
            if (zzarVar == null) {
                zzbh(s6, k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, null);
                return null;
            }
            zzarVar.zzs(24, this.e.getPackageName(), zzc.zzh(this.c, this.zzd, this.f2542I.longValue()), new Y0(this.f2545f, this.f2550k));
            return null;
        } catch (DeadObjectException e) {
            zzbh(s6, k1.f2516j, zzjs.IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e6) {
            zzbh(s6, k1.f2514h, zzjs.IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL_EXCEPTION, e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Void zzaU(InterfaceC0407f interfaceC0407f, Activity activity, ResultReceiver resultReceiver) {
        zzar zzarVar;
        try {
            synchronized (this.f2544a) {
                zzarVar = this.f2546g;
            }
            if (zzarVar == null) {
                zzbl(interfaceC0407f, k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, null);
                return null;
            }
            zzarVar.zzn(21, this.e.getPackageName(), zzc.zzh(this.c, this.zzd, this.f2542I.longValue()), new S0(new WeakReference(activity), resultReceiver));
            return null;
        } catch (DeadObjectException e) {
            zzbl(interfaceC0407f, k1.f2516j, zzjs.SHOW_ALTERNATIVE_BILLING_ONLY_DIALOG_SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e6) {
            zzbl(interfaceC0407f, k1.f2514h, zzjs.SHOW_ALTERNATIVE_BILLING_ONLY_DIALOG_SERVICE_CALL_EXCEPTION, e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Void zzaV(InterfaceC0446z interfaceC0446z, B b, Activity activity) {
        zzar zzarVar;
        try {
            if (!X(p002a.c.c)) {
                zzbm(interfaceC0446z, k1.f2516j, zzjs.SERVICE_CONNECTION_NOT_READY, null);
                return null;
            }
            if (!this.f2537D) {
                zzc.zzn("BillingClient", "Current client doesn't support showBillingProgramInformationDialog.");
                zzbm(interfaceC0446z, k1.f2509J, zzjs.FEATURE_NOT_SUPPORTED, null);
                return null;
            }
            synchronized (this.f2544a) {
                zzarVar = this.f2546g;
            }
            if (zzarVar == null) {
                zzbm(interfaceC0446z, k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, null);
                return null;
            }
            String packageName = this.e.getPackageName();
            String str = this.zzd;
            long jLongValue = this.f2542I.longValue();
            int i5 = zzc.zza;
            Bundle bundle = new Bundle();
            zzc.zzc(bundle, "9.1.0", str, jLongValue);
            zzij zzijVarZza = zzim.zza();
            zzjd zzjdVarZza = zzjf.zza();
            zzjdVarZza.zza(String.valueOf(b.f2422a));
            zzijVarZza.zza("developerBillingProgram", (zzjf) zzjdVarZza.zzi());
            if (b.getExternalTransactionToken() != null) {
                zzjd zzjdVarZza2 = zzjf.zza();
                zzjdVarZza2.zza(b.getExternalTransactionToken());
                zzijVarZza.zza("externalTransactionToken", (zzjf) zzjdVarZza2.zzi());
            }
            bundle.putByteArray("REQUEST_PARAMS", ((zzim) zzijVarZza.zzi()).zzQ());
            zzarVar.zzn(28, packageName, bundle, new a1(new WeakReference(activity), new zzbn(this, this.d)));
            return null;
        } catch (DeadObjectException e) {
            zzbm(interfaceC0446z, k1.f2516j, zzjs.SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (RuntimeException e6) {
            zzbm(interfaceC0446z, k1.f2514h, zzjs.SERVICE_CALL_EXCEPTION, e6);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Void zzaW(T t6, Activity activity, ResultReceiver resultReceiver) {
        zzar zzarVar;
        try {
            synchronized (this.f2544a) {
                zzarVar = this.f2546g;
            }
            if (zzarVar == null) {
                zzbi(t6, k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, null);
                return null;
            }
            zzarVar.zzp(22, this.e.getPackageName(), zzc.zzh(this.c, this.zzd, this.f2542I.longValue()), new U0(new WeakReference(activity), resultReceiver));
            return null;
        } catch (DeadObjectException e) {
            zzbi(t6, k1.f2516j, zzjs.SHOW_EXTERNAL_PAYMENT_DIALOG_SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e6) {
            zzbi(t6, k1.f2514h, zzjs.SHOW_EXTERNAL_PAYMENT_DIALOG_SERVICE_CALL_EXCEPTION, e6);
            return null;
        }
    }

    @Nullable
    private final Future zzaX(Callable callable, long j6, @Nullable Runnable runnable, Handler handler) throws Exception {
        try {
            Future futureSubmit = m().submit(callable);
            handler.postDelayed(new K0(futureSubmit, runnable, 1), 28500L);
            return futureSubmit;
        } catch (Exception e) {
            zzc.zzo("BillingClient", "Async task throws exception!", e);
            throw e;
        }
    }

    private final void zzaZ(InterfaceC0403d interfaceC0403d, H h6, zzjs zzjsVar, @Nullable Exception exc) {
        zzc.zzo("BillingClient", "Error in acknowledge purchase!", exc);
        zzbG(zzjsVar, 3, h6, i1.zza(exc));
        interfaceC0403d.a();
    }

    private final u1 zzbB(int i5, H h6, zzjs zzjsVar, String str, @Nullable Exception exc) {
        zzbG(zzjsVar, 9, h6, i1.zza(exc));
        zzc.zzo("BillingClient", str, exc);
        return new u1(h6, null);
    }

    private final void zzbG(zzjs zzjsVar, int i5, H h6, @Nullable String str) {
        try {
            int i6 = i1.f2481a;
            Q(i1.zzb(zzjsVar, i5, h6, str, zzjz.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbI(zzjs zzjsVar, int i5, H h6, @Nullable String str, long j6, boolean z6) {
        try {
            int i6 = i1.f2481a;
            zzjl zzjlVarZzb = i1.zzb(zzjsVar, 2, h6, str, zzjz.BROADCAST_ACTION_UNSPECIFIED);
            try {
                ((m1) this.f2545f).c(zzjlVarZzb, this.f2550k, j6, z6);
            } catch (Throwable th) {
                zzc.zzo("BillingClient", "Unable to log.", th);
            }
        } catch (Throwable th2) {
            zzc.zzo("BillingClient", "Unable to log.", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzba(InterfaceC0405e interfaceC0405e, H h6, zzjs zzjsVar, @Nullable Exception exc) {
        zzbG(zzjsVar, 14, h6, i1.zza(exc));
        interfaceC0405e.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbb(InterfaceC0415j interfaceC0415j, H h6, zzjs zzjsVar, @Nullable Exception exc) {
        zzc.zzo("BillingClient", "getBillingChoiceInfo got an exception.", exc);
        zzbG(zzjsVar, 40, h6, i1.zza(exc));
        interfaceC0415j.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbc(InterfaceC0444y interfaceC0444y, int i5, H h6, zzjs zzjsVar, @Nullable Exception exc) {
        zzbG(zzjsVar, 33, h6, i1.zza(exc));
        interfaceC0444y.a();
    }

    private final void zzbd(K k6, String str, H h6, zzjs zzjsVar, String str2, @Nullable Exception exc) {
        zzc.zzo("BillingClient", str2, exc);
        zzbG(zzjsVar, 4, h6, i1.zza(exc));
        ((p062l0.a) k6).onConsumeResponse(h6, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbe(InterfaceC0411h interfaceC0411h, H h6, zzjs zzjsVar, @Nullable Exception exc) {
        zzbG(zzjsVar, 15, h6, i1.zza(exc));
        interfaceC0411h.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbf(D d, H h6, zzjs zzjsVar, @Nullable Exception exc) {
        zzbG(zzjsVar, 35, h6, i1.zza(exc));
        d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbg(V v6, H h6, zzjs zzjsVar, @Nullable Exception exc) {
        zzbG(zzjsVar, 24, h6, i1.zza(exc));
        v6.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbh(S s6, H h6, zzjs zzjsVar, @Nullable Exception exc) {
        zzbG(zzjsVar, 23, h6, i1.zza(exc));
        s6.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbi(T t6, H h6, zzjs zzjsVar, @Nullable Exception exc) {
        zzbG(zzjsVar, 25, h6, i1.zza(exc));
        t6.a();
    }

    private final void zzbj(InterfaceC0427p interfaceC0427p, H h6, zzjs zzjsVar, @Nullable Exception exc) {
        zzc.zzo("BillingClient", "getBillingConfig got an exception.", exc);
        zzbG(zzjsVar, 13, h6, i1.zza(exc));
        interfaceC0427p.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbk(InterfaceC0412h0 interfaceC0412h0, H h6, zzjs zzjsVar, @Nullable Exception exc) {
        zzbG(zzjsVar, 37, h6, i1.zza(exc));
        interfaceC0412h0.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbl(InterfaceC0407f interfaceC0407f, H h6, zzjs zzjsVar, @Nullable Exception exc) {
        zzbG(zzjsVar, 16, h6, i1.zza(exc));
        interfaceC0407f.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbm(InterfaceC0446z interfaceC0446z, H h6, zzjs zzjsVar, @Nullable Exception exc) {
        zzbG(zzjsVar, 39, h6, i1.zza(exc));
        interfaceC0446z.a();
    }

    private final void zzbn(int i5, zzjs zzjsVar, @Nullable Exception exc) {
        zzjl zzjlVar;
        zzc.zzo("BillingClient", "showInAppMessages error.", exc);
        j1 j1Var = this.f2545f;
        String strZza = i1.zza(exc);
        try {
            zzjq zzjqVarZza = zzju.zza();
            zzjqVarZza.zzp(i5);
            if (zzjsVar != null) {
                zzjqVarZza.zze(zzjsVar);
            }
            if (strZza != null) {
                zzjqVarZza.zza(strZza);
            }
            zzjj zzjjVarZza = zzjl.zza();
            zzjjVarZza.zzb(zzjqVarZza);
            zzjjVarZza.zzp(30);
            zzjlVar = (zzjl) zzjjVarZza.zzi();
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to create logging payload", th);
            zzjlVar = null;
        }
        ((m1) j1Var).zza(zzjlVar);
    }

    public final void M(int i5, H h6, zzjs zzjsVar) {
        zzjp zzjpVar = null;
        zzjl zzjlVar = null;
        if (h6.f2433a == 0) {
            int i6 = i1.f2481a;
            try {
                zzjn zzjnVarZza = zzjp.zza();
                zzjnVarZza.zze(5);
                zzkk zzkkVarZza = zzkn.zza();
                zzkkVarZza.zza(i5);
                zzjnVarZza.zzb((zzkn) zzkkVarZza.zzi());
                zzjpVar = (zzjp) zzjnVarZza.zzi();
            } catch (Exception e) {
                zzc.zzo("BillingLogger", "Unable to create logging payload", e);
            }
            R(zzjpVar);
            return;
        }
        int i7 = i1.f2481a;
        try {
            zzjj zzjjVarZza = zzjl.zza();
            zzjq zzjqVarZza = zzju.zza();
            zzjqVarZza.zzp(h6.f2433a);
            zzjqVarZza.zzb(h6.getDebugMessage());
            zzjqVarZza.zze(zzjsVar);
            zzjjVarZza.zzb(zzjqVarZza);
            zzjjVarZza.zzp(5);
            zzkk zzkkVarZza2 = zzkn.zza();
            zzkkVarZza2.zza(i5);
            zzjjVarZza.zzc((zzkn) zzkkVarZza2.zzi());
            zzjlVar = (zzjl) zzjjVarZza.zzi();
        } catch (Exception e6) {
            zzc.zzo("BillingLogger", "Unable to create logging payload", e6);
        }
        Q(zzjlVar);
    }

    public final void N(int i5, H h6, zzjs zzjsVar) {
        try {
            int i6 = i1.f2481a;
            Q(i1.zzb(zzjsVar, i5, h6, null, zzjz.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void O(zzjs zzjsVar, H h6, long j6) {
        try {
            int i5 = i1.f2481a;
            zzjl zzjlVarZzb = i1.zzb(zzjsVar, 2, h6, null, zzjz.BROADCAST_ACTION_UNSPECIFIED);
            try {
                ((m1) this.f2545f).a(zzjlVarZzb, this.f2550k, j6);
            } catch (Throwable th) {
                zzc.zzo("BillingClient", "Unable to log.", th);
            }
        } catch (Throwable th2) {
            zzc.zzo("BillingClient", "Unable to log.", th2);
        }
    }

    public final void P(zzjs zzjsVar, H h6, long j6, boolean z6) {
        try {
            int i5 = i1.f2481a;
            zzjl zzjlVarZzb = i1.zzb(zzjsVar, 2, h6, null, zzjz.BROADCAST_ACTION_UNSPECIFIED);
            try {
                ((m1) this.f2545f).c(zzjlVarZzb, this.f2550k, j6, z6);
            } catch (Throwable th) {
                zzc.zzo("BillingClient", "Unable to log.", th);
            }
        } catch (Throwable th2) {
            zzc.zzo("BillingClient", "Unable to log.", th2);
        }
    }

    public final void Q(zzjl zzjlVar) {
        try {
            ((m1) this.f2545f).zzb(zzjlVar, this.f2550k);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void R(zzjp zzjpVar) {
        try {
            ((m1) this.f2545f).zzg(zzjpVar, this.f2550k);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void S(int i5, H h6, zzjs zzjsVar) {
        try {
            int i6 = i1.f2481a;
            zzjj zzjjVar = (zzjj) i1.zzb(zzjsVar, 6, h6, null, zzjz.BROADCAST_ACTION_UNSPECIFIED).zzq();
            zzll zzllVarZza = zzln.zza();
            zzllVarZza.zza(i5 > 0);
            zzllVarZza.zzb(i5);
            zzjjVar.zze(zzllVarZza);
            Q((zzjl) zzjjVar.zzi());
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void T(int i5) {
        String str;
        String str2;
        synchronized (this.f2544a) {
            try {
                if (this.b == 3) {
                    return;
                }
                int i6 = this.b;
                if (i6 == 0) {
                    str = "DISCONNECTED";
                } else if (i6 != 1) {
                    str = i6 != 2 ? "CLOSED" : "CONNECTED";
                } else {
                    str = "CONNECTING";
                }
                if (i5 == 0) {
                    str2 = "DISCONNECTED";
                } else if (i5 != 1) {
                    str2 = i5 != 2 ? "CLOSED" : "CONNECTED";
                } else {
                    str2 = "CONNECTING";
                }
                zzc.zzm("BillingClient", "Setting clientState from " + str + " to " + str2);
                this.b = i5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void U(InterfaceC0423n interfaceC0423n, int i5) {
        zzjs zzjsVar;
        H hV;
        H h6;
        synchronized (this.f2544a) {
            try {
                if (Y()) {
                    hV = v(i5);
                } else {
                    if (this.b == 1) {
                        zzc.zzn("BillingClient", "Client is already in the process of connecting to billing service.");
                        zzjs zzjsVar2 = zzjs.BILLING_CLIENT_CONNECTING;
                        h6 = k1.d;
                        S(i5, h6, zzjsVar2);
                    } else if (this.b == 3) {
                        zzc.zzn("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                        zzjs zzjsVar3 = zzjs.BILLING_CLIENT_CLOSED;
                        h6 = k1.f2516j;
                        S(i5, h6, zzjsVar3);
                    } else {
                        T(1);
                        if (i5 == 0) {
                            this.zzK = interfaceC0423n;
                            i5 = 0;
                        }
                        V();
                        zzc.zzm("BillingClient", "Starting in-app billing setup.");
                        this.f2547h = new P0(this, interfaceC0423n, i5);
                        P0 p1 = this.f2547h;
                        synchronized (p1.e.f2544a) {
                            com.google.android.gms.internal.play_billing.zzbn zzbnVar = p1.b;
                            zzbnVar.zzd();
                            zzbnVar.zze();
                        }
                        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                        intent.setPackage("com.android.vending");
                        List<ResolveInfo> listQueryIntentServices = this.e.getPackageManager().queryIntentServices(intent, 0);
                        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                            zzjsVar = zzjs.INTENT_SERVICE_NOT_FOUND;
                        } else {
                            ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
                            if (serviceInfo != null) {
                                String str = serviceInfo.packageName;
                                String str2 = serviceInfo.name;
                                if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                                    zzjsVar = zzjs.INVALID_PHONESKY_PACKAGE;
                                    zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                                } else {
                                    ComponentName componentName = new ComponentName(str, str2);
                                    Intent intent2 = new Intent(intent);
                                    intent2.setComponent(componentName);
                                    intent2.putExtra("playBillingLibraryVersion", this.c);
                                    synchronized (this.f2544a) {
                                        try {
                                            if (this.b == 2) {
                                                hV = v(i5);
                                            } else if (this.b != 1) {
                                                zzc.zzn("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                                zzjs zzjsVar4 = zzjs.BILLING_CLIENT_TRANSITIONED_OUT_OF_CONNECTING;
                                                h6 = k1.f2516j;
                                                S(i5, h6, zzjsVar4);
                                            } else {
                                                P0 p6 = this.f2547h;
                                                if ((i5 <= 0 || Build.VERSION.SDK_INT < 29) ? this.e.bindService(intent2, p6, 1) : this.e.bindService(intent2, 1, m(), p6)) {
                                                    zzc.zzm("BillingClient", "Service was bonded successfully.");
                                                    hV = null;
                                                } else {
                                                    zzjsVar = zzjs.BILLING_SERVICE_BLOCKED;
                                                    zzc.zzn("BillingClient", "Connection to Billing service is blocked.");
                                                }
                                            }
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                }
                            } else {
                                zzjsVar = zzjs.INVALID_PHONESKY_PACKAGE;
                                zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                            }
                        }
                        T(0);
                        zzc.zzm("BillingClient", "Billing service unavailable on device.");
                        H h7 = k1.b;
                        S(i5, h7, zzjsVar);
                        hV = h7;
                    }
                    hV = h6;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (hV != null) {
            interfaceC0423n.onBillingSetupFinished(hV);
        }
    }

    public final void V() {
        synchronized (this.f2544a) {
            if (this.f2547h != null) {
                try {
                    this.e.unbindService(this.f2547h);
                    this.f2546g = null;
                    this.f2547h = null;
                } catch (Throwable th) {
                    try {
                        zzc.zzo("BillingClient", "There was an exception while unbinding service!", th);
                        this.f2546g = null;
                        this.f2547h = null;
                    } catch (Throwable th2) {
                        this.f2546g = null;
                        this.f2547h = null;
                        throw th2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean W(long j6) {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                j6 = 0;
            }
            int i5 = ((H) x(1).get(j6, TimeUnit.MILLISECONDS)).f2433a;
            if (i5 == 0) {
                zzc.zzm("BillingClient", "Reconnection succeeded with result: " + i5);
            } else {
                zzc.zzn("BillingClient", "Reconnection failed with result: " + i5);
            }
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            zzc.zzo("BillingClient", "Error during reconnection attempt: ", e);
        }
        return Y();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean X(long j6) {
        com.google.android.gms.internal.play_billing.zzbn zzbnVarZzb = com.google.android.gms.internal.play_billing.zzbn.zzb(this.f2543J);
        int i5 = p002a.c.d;
        long jZza = j6;
        for (int i6 = 1; i6 <= i5; i6++) {
            try {
                long jMax = Math.max(0L, jZza);
                if (jMax <= 0) {
                    zzc.zzn("BillingClient", "No time remaining for reconnection attempt.");
                    return Y();
                }
                int i7 = ((H) x(i6).get(jMax, TimeUnit.MILLISECONDS)).f2433a;
                if (i7 == 0) {
                    zzc.zzm("BillingClient", "Reconnection succeeded with result: " + i7);
                    return Y();
                }
                zzc.zzn("BillingClient", "Reconnection failed with result: " + i7);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                jZza = j6 - zzbnVarZzb.zza(timeUnit);
                long jPow = ((long) Math.pow(2.0d, i6 - 1)) * 1000;
                if (jZza < jPow) {
                    zzc.zzn("BillingClient", "Reconnection failed due to timeout limit reached.");
                    return Y();
                }
                if (i6 < i5 && jPow > 0) {
                    try {
                        Thread.sleep(jPow);
                        jZza = j6 - zzbnVarZzb.zza(timeUnit);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        zzc.zzo("BillingClient", "Error sleeping during reconnection attempt: ", e);
                    }
                }
            } catch (Exception e6) {
                if (e6 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                zzc.zzo("BillingClient", "Error during reconnection attempt: ", e6);
            }
        }
        zzc.zzn("BillingClient", "Max retries reached.");
        return Y();
    }

    public final boolean Y() {
        boolean z6;
        synchronized (this.f2544a) {
            try {
                z6 = false;
                if (this.b == 2 && this.f2546g != null && this.f2547h != null) {
                    z6 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z6;
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public void acknowledgePurchase(C0401c c0401c, InterfaceC0403d interfaceC0403d) {
        if (zzP(new I0(this, c0401c, 0), 30000L, new E0(this, 2), u(), m()) != null) {
            return;
        }
        N(3, w(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC);
        throw null;
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public void consumeAsync(J j6, K k6) {
        if (zzP(new G0(this, k6, j6, 3), 30000L, new L0(this, 0, k6, j6), u(), m()) == null) {
            H hW = w();
            N(4, hW, zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC);
            ((p062l0.a) k6).onConsumeResponse(hW, j6.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public void createAlternativeBillingOnlyReportingDetailsAsync(InterfaceC0411h interfaceC0411h) {
        if (zzP(new D0(this, 3), 30000L, new E0(this, 7), u(), m()) == null) {
            zzbe(interfaceC0411h, w(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public void createBillingProgramReportingDetailsAsync(F f6, D d) {
        try {
            try {
                zzaX(new I0(this, f6, 1), 30000L, new E0(this, 4), u());
            } catch (Exception e) {
                e = e;
                zzbf(d, w(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, e);
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public void createExternalOfferReportingDetailsAsync(V v6) {
        if (zzP(new D0(this, 2), 30000L, new E0(this, 9), u(), m()) == null) {
            zzbg(v6, w(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    public final void d0(H h6) {
        if (Thread.interrupted()) {
            return;
        }
        this.d.post(new Q0.b(this, h6, 7));
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004e A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #1 {, blocks: (B:20:0x004a, B:22:0x004e), top: B:44:0x004a, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.android.billingclient.api.AbstractC0419l
    public void endConnection() {
        ExecutorService executorService;
        try {
            int i5 = i1.f2481a;
            R(i1.zzc(12, zzjz.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
        synchronized (this.f2544a) {
            try {
                if (this.zzf != null) {
                    y1 y1Var = this.zzf;
                    x1 x1Var = y1Var.d;
                    Context context = y1Var.f2593a;
                    x1Var.b(context);
                    y1Var.e.b(context);
                    try {
                        zzc.zzm("BillingClient", "Unbinding from service.");
                        V();
                    } catch (Throwable th2) {
                        zzc.zzo("BillingClient", "There was an exception while unbinding from the service while ending connection!", th2);
                    }
                    try {
                        synchronized (this) {
                            executorService = this.f2541H;
                            if (executorService != null) {
                                executorService.shutdownNow();
                                this.f2541H = null;
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            zzc.zzo("BillingClient", "There was an exception while shutting down the executor service while ending connection!", th3);
                        } catch (Throwable th4) {
                            T(3);
                            this.zzK = null;
                            throw th4;
                        }
                    }
                    T(3);
                    this.zzK = null;
                } else {
                    zzc.zzm("BillingClient", "Unbinding from service.");
                    V();
                    synchronized (this) {
                        executorService = this.f2541H;
                        if (executorService != null) {
                            executorService.shutdownNow();
                            this.f2541H = null;
                        }
                        T(3);
                        this.zzK = null;
                    }
                }
            } catch (Throwable th5) {
                zzc.zzo("BillingClient", "There was an exception while shutting down broadcast manager while ending connection!", th5);
            }
            throw th;
        }
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public void getBillingChoiceInfoAsync(X x6, InterfaceC0415j interfaceC0415j) {
        if (interfaceC0415j == null) {
            throw new IllegalArgumentException("Please provide a valid listener.");
        }
        if (x6 == null) {
            throw new IllegalArgumentException("Please provide valid GetBillingChoiceInfoParams.");
        }
        if (zzP(new I0(this, x6, 2), 30000L, new E0(this, 11), u(), m()) == null) {
            zzbb(interfaceC0415j, w(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public void getBillingConfigAsync(Z z6, InterfaceC0427p interfaceC0427p) {
        if (zzP(new D0(this, 1), 30000L, new E0(this, 5), u(), m()) == null) {
            N(13, w(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC);
            interfaceC0427p.a();
        }
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public final int getConnectionState() {
        int i5;
        synchronized (this.f2544a) {
            i5 = this.b;
        }
        return i5;
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public void isAlternativeBillingOnlyAvailableAsync(InterfaceC0405e interfaceC0405e) {
        if (zzP(new D0(this, 4), 30000L, new E0(this, 8), u(), m()) == null) {
            zzba(interfaceC0405e, w(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public void isBillingProgramAvailableAsync(final int i5, InterfaceC0444y interfaceC0444y) {
        if (zzP(new Callable() { // from class: com.android.billingclient.api.J0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.f2438a.zzaS(null, i5);
                return null;
            }
        }, 30000L, new H2.e(this, i5, 1), u(), m()) == null) {
            zzbc(interfaceC0444y, i5, w(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public void isExternalOfferAvailableAsync(S s6) {
        int i5 = 0;
        if (zzP(new D0(this, i5), 30000L, new E0(this, i5), u(), m()) == null) {
            zzbh(s6, w(), zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.android.billingclient.api.AbstractC0419l
    public final H isFeatureSupported(String str) {
        if (!W(p002a.c.b)) {
            H h6 = k1.f2516j;
            zzjs zzjsVar = zzjs.SERVICE_CONNECTION_NOT_READY;
            if (h6.f2433a != 0) {
                N(5, h6, zzjsVar);
                return h6;
            }
            try {
                int i5 = i1.f2481a;
                R(i1.zzc(5, zzjz.BROADCAST_ACTION_UNSPECIFIED));
                return h6;
            } catch (Throwable th) {
                zzc.zzo("BillingClient", "Unable to log.", th);
                return h6;
            }
        }
        H h7 = k1.f2511a;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals("subscriptionsUpdate")) {
                    H h8 = this.f2549j ? k1.f2515i : k1.f2519m;
                    M(3, h8, zzjs.SUBSCRIPTIONS_UPDATE_NOT_SUPPORTED);
                    return h8;
                }
                break;
            case 96321:
                if (str.equals("aaa")) {
                    H h9 = this.f2556q ? k1.f2515i : k1.f2521o;
                    M(6, h9, zzjs.CROSS_APP_NOT_SUPPORTED);
                    return h9;
                }
                break;
            case 97314:
                if (str.equals("bbb")) {
                    H h10 = this.f2554o ? k1.f2515i : k1.f2526t;
                    M(5, h10, zzjs.IN_APP_MESSAGE_NOT_SUPPORTED);
                    return h10;
                }
                break;
            case 98307:
                if (str.equals("ccc")) {
                    H h11 = this.f2557r ? k1.f2515i : k1.f2522p;
                    M(8, h11, zzjs.MULTI_ITEM_NOT_SUPPORTED);
                    return h11;
                }
                break;
            case 99300:
                if (str.equals("ddd")) {
                    H h12 = this.f2555p ? k1.f2515i : k1.f2523q;
                    M(7, h12, zzjs.OFFER_ID_TOKEN_NOT_SUPPORTED);
                    return h12;
                }
                break;
            case 100293:
                if (str.equals("eee")) {
                    H h13 = this.f2557r ? k1.f2515i : k1.f2522p;
                    M(9, h13, zzjs.PBL_FOR_PAYMENTS_GATEWAY_BUYFLOW_NOT_SUPPORTED);
                    return h13;
                }
                break;
            case 101286:
                if (str.equals("fff")) {
                    H h14 = this.f2558s ? k1.f2515i : k1.f2525s;
                    M(10, h14, zzjs.PRODUCT_DETAILS_NOT_SUPPORTED);
                    return h14;
                }
                break;
            case 102279:
                if (str.equals("ggg")) {
                    H h15 = this.f2559t ? k1.f2515i : k1.f2532z;
                    M(11, h15, zzjs.GET_BILLING_CONFIG_NOT_SUPPORTED);
                    return h15;
                }
                break;
            case 103272:
                if (str.equals("hhh")) {
                    H h16 = this.f2559t ? k1.f2515i : k1.f2500A;
                    M(12, h16, zzjs.QUERY_PRODUCT_DETAILS_WITH_SERIALIZED_DOCID_NOT_SUPPORTED);
                    return h16;
                }
                break;
            case 104265:
                if (str.equals("iii")) {
                    H h17 = this.f2561v ? k1.f2515i : k1.f2502C;
                    M(13, h17, zzjs.QUERY_PRODUCT_DETAILS_WITH_DEVELOPER_SPECIFIED_ACCOUNT_NOT_SUPPORTED);
                    return h17;
                }
                break;
            case 105258:
                if (str.equals("jjj")) {
                    H h18 = this.f2562w ? k1.f2515i : k1.f2503D;
                    M(14, h18, zzjs.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED);
                    return h18;
                }
                break;
            case 106251:
                if (str.equals("kkk")) {
                    H h19 = this.f2565z ? k1.f2515i : k1.f2527u;
                    M(18, h19, zzjs.EXTERNAL_OFFER_NOT_SUPPORTED);
                    return h19;
                }
                break;
            case 107244:
                if (str.equals("lll")) {
                    H h20 = this.f2564y ? k1.f2515i : k1.f2528v;
                    M(19, h20, zzjs.MULTI_ITEM_WITH_SEASON_PASS_NOT_SUPPORTED);
                    return h20;
                }
                break;
            case 108237:
                if (str.equals("mmm")) {
                    H h21 = this.f2565z ? k1.f2515i : k1.f2529w;
                    M(20, h21, zzjs.AUTO_PAY_NOT_SUPPORTED);
                    return h21;
                }
                break;
            case 109230:
                if (str.equals("nnn")) {
                    H h22 = this.f2534A ? k1.f2515i : k1.f2530x;
                    M(21, h22, zzjs.INCLUDE_SUSPENDED_SUBSCRIPTIONS_NOT_SUPPORTED);
                    return h22;
                }
                break;
            case 110223:
                if (str.equals("ooo")) {
                    H h23 = this.f2536C ? k1.f2515i : k1.f2524r;
                    M(22, h23, zzjs.GIFT_CODE_PURCHASE_NOT_SUPPORTED);
                    return h23;
                }
                break;
            case 207616302:
                if (str.equals("priceChangeConfirmation")) {
                    H h24 = this.f2552m ? k1.f2515i : k1.f2520n;
                    M(4, h24, zzjs.PRICE_CHANGE_CONFIRMATION_NOT_SUPPORTED);
                    return h24;
                }
                break;
            case 1987365622:
                if (str.equals("subscriptions")) {
                    H h25 = this.f2548i ? k1.f2515i : k1.f2518l;
                    M(2, h25, zzjs.SUBSCRIPTIONS_NOT_SUPPORTED);
                    return h25;
                }
                break;
        }
        zzc.zzn("BillingClient", "Unsupported feature: ".concat(str));
        H h26 = k1.f2531y;
        M(1, h26, zzjs.UNKNOWN_FEATURE);
        return h26;
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public final boolean isReady() {
        if (this.f2538E) {
            return true;
        }
        return Y();
    }

    /* JADX WARN: Code duplicated, block: B:182:0x0450 A[EDGE_INSN: B:182:0x0450->B:134:0x030f BREAK  A[LOOP:5: B:154:0x03c2->B:408:0x03c2]] */
    /* JADX WARN: Code duplicated, block: B:185:0x0458  */
    /* JADX WARN: Code duplicated, block: B:187:0x0467  */
    /* JADX WARN: Code duplicated, block: B:189:0x046f  */
    /* JADX WARN: Code duplicated, block: B:191:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:193:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:195:0x04cb  */
    /* JADX WARN: Code duplicated, block: B:198:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:200:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:202:0x0500  */
    /* JADX WARN: Code duplicated, block: B:204:0x050d  */
    /* JADX WARN: Code duplicated, block: B:206:0x0512  */
    /* JADX WARN: Code duplicated, block: B:209:0x0543  */
    /* JADX WARN: Code duplicated, block: B:211:0x0557  */
    /* JADX WARN: Code duplicated, block: B:214:0x056d  */
    /* JADX WARN: Code duplicated, block: B:216:0x0572  */
    /* JADX WARN: Code duplicated, block: B:220:0x05a7  */
    /* JADX WARN: Code duplicated, block: B:223:0x05b2  */
    /* JADX WARN: Code duplicated, block: B:226:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:229:0x05c8  */
    /* JADX WARN: Code duplicated, block: B:238:0x05fa  */
    /* JADX WARN: Code duplicated, block: B:239:0x060a  */
    /* JADX WARN: Code duplicated, block: B:242:0x0612  */
    /* JADX WARN: Code duplicated, block: B:243:0x061a  */
    /* JADX WARN: Code duplicated, block: B:246:0x0622  */
    /* JADX WARN: Code duplicated, block: B:247:0x062a  */
    /* JADX WARN: Code duplicated, block: B:249:0x0636  */
    /* JADX WARN: Code duplicated, block: B:255:0x065f  */
    /* JADX WARN: Code duplicated, block: B:256:0x0662  */
    /* JADX WARN: Code duplicated, block: B:261:0x066f  */
    /* JADX WARN: Code duplicated, block: B:263:0x0673 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:265:0x0678  */
    /* JADX WARN: Code duplicated, block: B:267:0x067c  */
    /* JADX WARN: Code duplicated, block: B:268:0x067f  */
    /* JADX WARN: Code duplicated, block: B:270:0x069d  */
    /* JADX WARN: Code duplicated, block: B:296:0x06e8 A[Catch: Exception -> 0x06c8, CancellationException -> 0x06cd, TimeoutException -> 0x06d0, TRY_LEAVE, TryCatch #12 {Exception -> 0x06c8, blocks: (B:276:0x06c4, B:296:0x06e8, B:298:0x06ed, B:300:0x0702, B:314:0x0766, B:316:0x076a, B:324:0x077f, B:313:0x0753), top: B:364:0x06b6 }] */
    /* JADX WARN: Code duplicated, block: B:300:0x0702 A[Catch: Exception -> 0x06c8, CancellationException -> 0x07ac, TimeoutException -> 0x07b0, TRY_LEAVE, TryCatch #12 {Exception -> 0x06c8, blocks: (B:276:0x06c4, B:296:0x06e8, B:298:0x06ed, B:300:0x0702, B:314:0x0766, B:316:0x076a, B:324:0x077f, B:313:0x0753), top: B:364:0x06b6 }] */
    /* JADX WARN: Code duplicated, block: B:310:0x0729 A[Catch: all -> 0x0718, TryCatch #11 {all -> 0x0718, blocks: (B:302:0x0715, B:305:0x071a, B:307:0x0722, B:308:0x0725, B:310:0x0729, B:311:0x0734), top: B:362:0x0713 }] */
    /* JADX WARN: Code duplicated, block: B:311:0x0734 A[Catch: all -> 0x0718, TRY_LEAVE, TryCatch #11 {all -> 0x0718, blocks: (B:302:0x0715, B:305:0x071a, B:307:0x0722, B:308:0x0725, B:310:0x0729, B:311:0x0734), top: B:362:0x0713 }] */
    /* JADX WARN: Code duplicated, block: B:316:0x076a A[Catch: Exception -> 0x06c8, CancellationException -> 0x06cd, TimeoutException -> 0x06d0, TRY_ENTER, TRY_LEAVE, TryCatch #12 {Exception -> 0x06c8, blocks: (B:276:0x06c4, B:296:0x06e8, B:298:0x06ed, B:300:0x0702, B:314:0x0766, B:316:0x076a, B:324:0x077f, B:313:0x0753), top: B:364:0x06b6 }] */
    /* JADX WARN: Code duplicated, block: B:320:0x0771  */
    /* JADX WARN: Code duplicated, block: B:343:0x07b2 A[Catch: CancellationException -> 0x06d8, TimeoutException -> 0x06dd, Exception -> 0x079f, TRY_LEAVE, TryCatch #5 {Exception -> 0x079f, blocks: (B:329:0x079b, B:343:0x07b2), top: B:358:0x0700 }] */
    /* JADX WARN: Code duplicated, block: B:367:0x0775 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:369:0x06b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:388:0x0594 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00da  */
    /* JADX WARN: Code duplicated, block: B:56:0x00de  */
    /* JADX WARN: Instruction removed from duplicated block: B:311:0x0734, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v1, types: [long] */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v3 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARN: Type inference failed for: r19v6 */
    /* JADX WARN: Type inference failed for: r19v7 */
    /* JADX WARN: Type inference failed for: r29v0, types: [com.android.billingclient.api.m] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v41 */
    /* JADX WARN: Type inference failed for: r4v42 */
    /* JADX WARN: Type inference failed for: r4v43 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r6v49 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r6v51 */
    /* JADX WARN: Type inference failed for: r6v53 */
    /* JADX WARN: Type inference failed for: r6v54, types: [long] */
    /* JADX WARN: Type inference failed for: r6v55 */
    /* JADX WARN: Type inference failed for: r6v56 */
    /* JADX WARN: Type inference failed for: r6v57 */
    /* JADX WARN: Type inference failed for: r6v61 */
    /* JADX WARN: Type inference failed for: r6v62 */
    /* JADX WARN: Type inference failed for: r6v70 */
    /* JADX WARN: Type inference failed for: r6v71 */
    /* JADX WARN: Type inference failed for: r6v72 */
    /* JADX WARN: Type inference failed for: r6v73 */
    /* JADX WARN: Type inference failed for: r6v74 */
    /* JADX WARN: Type inference failed for: r6v75 */
    /* JADX WARN: Type inference failed for: r6v76 */
    /* JADX WARN: Type inference failed for: r6v77 */
    /* JADX WARN: Type inference failed for: r6v78 */
    /* JADX WARN: Type inference failed for: r8v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v15, types: [boolean] */
    @Override // com.android.billingclient.api.AbstractC0419l
    public H launchBillingFlow(Activity activity, final C0442x c0442x) {
        boolean z6;
        int i5;
        boolean z7;
        List list;
        H hA;
        C0418k0.b next;
        C0434t subscriptionProductReplacementParams;
        H h6;
        int i6;
        H hA2;
        H hA3;
        boolean z8;
        String str;
        Future futureZzP;
        ?? r6;
        ?? r7;
        ?? r8;
        ?? r9;
        ?? r19;
        ?? r10;
        boolean z9;
        long j6;
        boolean z10;
        Bundle bundle;
        int iZzb;
        String strZzj;
        zzjs zzjsVarZzb;
        String string;
        Object obj;
        List list2;
        String str2;
        Bundle bundleZzf;
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ArrayList<String> arrayList5;
        ArrayList<Integer> arrayList6;
        int i7;
        String str3;
        C0418k0 c0418k0Zza;
        String strZzc;
        boolean z11;
        String str4;
        Intent intent;
        int i8;
        ArrayList<String> arrayList7;
        Iterator it;
        ArrayList<String> arrayList8;
        ArrayList<String> arrayList9;
        long jNextLong = new Random().nextLong();
        if (this.zzf == null || this.zzf.zze() == null) {
            zzjs zzjsVar = zzjs.MISSING_LISTENER;
            H h7 = k1.f2504E;
            O(zzjsVar, h7, jNextLong);
            return h7;
        }
        if (c0442x.getDeveloperBillingOptionParams() != null) {
            this.zzf.zzc();
            zzjs zzjsVar2 = zzjs.MISSING_DEVELOPER_PROVIDED_BILLING_LISTENER;
            H h8 = k1.f2508I;
            O(zzjsVar2, h8, jNextLong);
            return h8;
        }
        if (!W(p002a.c.b)) {
            zzjs zzjsVar3 = zzjs.SERVICE_CONNECTION_NOT_READY;
            H h9 = k1.f2516j;
            O(zzjsVar3, h9, jNextLong);
            d0(h9);
            return h9;
        }
        synchronized (this.f2544a) {
            try {
                z6 = false;
                if (this.f2547h != null) {
                    z6 = this.f2547h.d > 0;
                    i5 = 0;
                } else {
                    i5 = 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ArrayList arrayListZzj = c0442x.zzj();
        List listZzk = c0442x.zzk();
        if (zzcg.zza(arrayListZzj, null) != null) {
            throw new ClassCastException();
        }
        C0436u c0436u = (C0436u) zzcg.zza(listZzk, null);
        final String productId = c0436u.zza().getProductId();
        String productType = c0436u.zza().getProductType();
        if (productType.equals("subs") && !this.f2548i) {
            zzc.zzn("BillingClient", "Current client doesn't support subscriptions.");
            zzjs zzjsVar4 = zzjs.SUBSCRIPTIONS_NOT_SUPPORTED;
            H h10 = k1.f2518l;
            P(zzjsVar4, h10, jNextLong, z6);
            d0(h10);
            return h10;
        }
        long j7 = jNextLong;
        if (c0442x.b == null && c0442x.c == null) {
            C0440w c0440w = c0442x.d;
            if (c0440w.b == null && c0440w.c == 0 && !c0442x.f2587a && !c0442x.f2589g) {
                zzca zzcaVar = c0442x.e;
                if (zzcaVar != null) {
                    int size = zzcaVar.size();
                    int i9 = i5;
                    while (true) {
                        if (i9 < size) {
                            C0434t subscriptionProductReplacementParams2 = ((C0436u) zzcaVar.get(i9)).getSubscriptionProductReplacementParams();
                            i9++;
                            if (subscriptionProductReplacementParams2 != null) {
                                if (!this.f2551l) {
                                    zzc.zzn("BillingClient", "Current client doesn't support extra params for buy intent.");
                                    zzjs zzjsVar5 = zzjs.EXTRA_PARAMS_NOT_SUPPORTED;
                                    H h11 = k1.f2512f;
                                    P(zzjsVar5, h11, j7, z6);
                                    d0(h11);
                                    return h11;
                                }
                            }
                        }
                    }
                }
            } else if (!this.f2551l) {
                zzc.zzn("BillingClient", "Current client doesn't support extra params for buy intent.");
                zzjs zzjsVar6 = zzjs.EXTRA_PARAMS_NOT_SUPPORTED;
                H h12 = k1.f2512f;
                P(zzjsVar6, h12, j7, z6);
                d0(h12);
                return h12;
            }
        } else if (!this.f2551l) {
            zzc.zzn("BillingClient", "Current client doesn't support extra params for buy intent.");
            zzjs zzjsVar7 = zzjs.EXTRA_PARAMS_NOT_SUPPORTED;
            H h13 = k1.f2512f;
            P(zzjsVar7, h13, j7, z6);
            d0(h13);
            return h13;
        }
        if (arrayListZzj.size() > 1 && !this.f2557r) {
            zzc.zzn("BillingClient", "Current client doesn't support multi-item purchases.");
            zzjs zzjsVar8 = zzjs.MULTI_ITEM_NOT_SUPPORTED;
            H h14 = k1.f2522p;
            P(zzjsVar8, h14, j7, z6);
            d0(h14);
            return h14;
        }
        if (!listZzk.isEmpty() && !this.f2558s) {
            zzc.zzn("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            zzjs zzjsVar9 = zzjs.PRODUCT_DETAILS_NOT_SUPPORTED;
            H h15 = k1.f2525s;
            P(zzjsVar9, h15, j7, z6);
            d0(h15);
            return h15;
        }
        Iterator it2 = listZzk.iterator();
        while (it2.hasNext()) {
            String strZzb = ((C0436u) it2.next()).zzb();
            if (strZzb != null && strZzb.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR) && !this.f2536C) {
                zzc.zzn("BillingClient", "Current Play Store version doesn't support gift code purchase.");
                zzjs zzjsVar10 = zzjs.GIFT_CODE_PURCHASE_NOT_SUPPORTED;
                H h16 = k1.f2524r;
                P(zzjsVar10, h16, j7, z6);
                d0(h16);
                return h16;
            }
        }
        if (!c0442x.e.isEmpty()) {
            C0436u c0436u2 = (C0436u) c0442x.e.get(0);
            int i10 = 1;
            while (true) {
                if (i10 >= c0442x.e.size()) {
                    String strZza = c0436u2.zza().zza();
                    HashMap map = new HashMap();
                    HashSet hashSet = new HashSet();
                    zzca zzcaVar2 = c0442x.e;
                    int size2 = zzcaVar2.size();
                    int i11 = 0;
                    boolean z12 = false;
                    while (true) {
                        if (i11 >= size2) {
                            z7 = z6;
                            list = listZzk;
                            Iterator it3 = hashSet.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    if (z12 && c0442x.d.c != 0) {
                                        hA = k1.a(5, "SubscriptionUpdateParams.setSubscriptionReplaceMode and  ProductDetailsParams.setSubscriptionProductReplacementParams cannot be called at the same time.");
                                        break;
                                    }
                                    List<C0418k0.b> oneTimePurchaseOfferDetailsList = c0436u2.zza().getOneTimePurchaseOfferDetailsList();
                                    String strZzb2 = c0436u2.zzb();
                                    if (strZzb2 != null && oneTimePurchaseOfferDetailsList != null) {
                                        Iterator<C0418k0.b> it4 = oneTimePurchaseOfferDetailsList.iterator();
                                        do {
                                            if (!it4.hasNext()) {
                                                next = null;
                                                break;
                                            }
                                            next = it4.next();
                                        } while (!strZzb2.equals(next.getOfferToken()));
                                        if (next != null && next.zza() != null) {
                                            hA = k1.a(5, "Both autoPayDetails and autoPayBalanceThreshold is required for constructing ProductDetailsParams for autopay.");
                                            break;
                                        }
                                        hA = k1.f2515i;
                                        break;
                                    }
                                    hA = k1.f2515i;
                                    break;
                                }
                                String str5 = (String) it3.next();
                                if (map.containsKey(str5) && ((subscriptionProductReplacementParams = ((C0436u) map.get(str5)).getSubscriptionProductReplacementParams()) == null || !subscriptionProductReplacementParams.getOldProductId().equals(str5))) {
                                    hA = k1.a(5, "OldProductId must not be one of the products to be purchased. Invalid old product id: " + str5 + Consts.DOT);
                                    break;
                                }
                            }
                        } else {
                            int i12 = size2;
                            C0436u c0436u3 = (C0436u) zzcaVar2.get(i11);
                            C0434t subscriptionProductReplacementParams3 = c0436u3.getSubscriptionProductReplacementParams();
                            if (subscriptionProductReplacementParams3 != null) {
                                z7 = z6;
                                list = listZzk;
                                if (c0436u3.zza().getProductType().equals("subs")) {
                                    i6 = i11;
                                    if (subscriptionProductReplacementParams3.getReplacementMode() <= 0) {
                                        hA2 = k1.a(5, "replacementMode is required for constructing SubscriptionProductReplacementParams. Not correctly set for product id: " + c0436u3.zza().getProductId());
                                    } else if (zzbo.zzd(subscriptionProductReplacementParams3.f2577a)) {
                                        hA2 = k1.a(5, "oldProductId is required for constructing SubscriptionProductReplacementParams. Not correctly set for product id: " + c0436u3.zza().getProductId());
                                    } else {
                                        hA2 = k1.f2515i;
                                    }
                                } else {
                                    i6 = i11;
                                    hA2 = k1.a(5, "Non-subscription product cannot have SubscriptionProductReplacementParams. Invalid product id: " + c0436u3.zza().getProductId());
                                }
                                if (hA2 != k1.f2515i) {
                                }
                                h6 = hA2;
                                break;
                            }
                            z7 = z6;
                            list = listZzk;
                            i6 = i11;
                            if (subscriptionProductReplacementParams3 != null && subscriptionProductReplacementParams3.getReplacementMode() == 6) {
                                if (c0436u3.zzb() != null) {
                                    hA2 = k1.a(5, "When using KEEP_EXISTING mode, offerToken in ProductDetailsParams should not be set. Offer token is set for product id: " + c0436u3.zza().getProductId());
                                } else if (subscriptionProductReplacementParams3.getOldProductId().equals(c0436u3.zza().getProductId())) {
                                    hA2 = k1.f2515i;
                                } else {
                                    hA2 = k1.a(5, "When using KEEP_EXISTING mode, oldProductId in SubscriptionProductReplacementParams should be the same as the product id in ProductDetails. Value is invalid for product id: " + c0436u3.zza().getProductId());
                                }
                                if (hA2 != k1.f2515i) {
                                    h6 = hA2;
                                    break;
                                }
                            }
                            if (c0436u3.zza().getSubscriptionOfferDetails() != null && c0436u3.zzb() == null && (subscriptionProductReplacementParams3 == null || subscriptionProductReplacementParams3.getReplacementMode() != 6)) {
                                hA = k1.a(5, "offerToken is required for constructing ProductDetailsParams for subscriptions. Missing value for product id: " + c0436u3.zza().getProductId());
                            } else if (map.containsKey(c0436u3.zza().getProductId())) {
                                hA = k1.a(5, "ProductId can not be duplicated. Invalid product id: " + c0436u3.zza().getProductId() + Consts.DOT);
                            } else {
                                map.put(c0436u3.zza().getProductId(), c0436u3);
                                if (subscriptionProductReplacementParams3 == null) {
                                    if (!c0436u2.zza().getProductType().equals("play_pass_subs") || c0436u3.zza().getProductType().equals("play_pass_subs") || strZza.equals(c0436u3.zza().zza())) {
                                        i11 = i6 + 1;
                                        listZzk = list;
                                        size2 = i12;
                                        z6 = z7;
                                    } else {
                                        hA = k1.a(5, "All products must have the same package name.");
                                    }
                                } else if (hashSet.contains(subscriptionProductReplacementParams3.getOldProductId())) {
                                    hA = k1.a(5, "OldProductId can not be duplicated. Invalid old product id: " + subscriptionProductReplacementParams3.getOldProductId() + Consts.DOT);
                                } else {
                                    hashSet.add(subscriptionProductReplacementParams3.getOldProductId());
                                    z12 = true;
                                    if (c0436u2.zza().getProductType().equals("play_pass_subs")) {
                                    }
                                    i11 = i6 + 1;
                                    listZzk = list;
                                    size2 = i12;
                                    z6 = z7;
                                }
                            }
                        }
                        h6 = hA;
                        break;
                    }
                }
                C0436u c0436u4 = (C0436u) c0442x.e.get(i10);
                if (c0436u4.zza().getProductType().equals(c0436u2.zza().getProductType()) || c0436u4.zza().getProductType().equals("play_pass_subs")) {
                    i10++;
                } else {
                    hA3 = k1.a(5, "All products should have same ProductType.");
                }
            }
            if (h6 != k1.f2515i) {
                P(zzjs.INVALID_BILLING_FLOW_PARAMS, h6, j7, z7);
                d0(h6);
                return h6;
            }
            z8 = z7;
            if (this.f2551l) {
                boolean z13 = this.f2553n;
                boolean z14 = this.f2560u;
                this.zzG.getClass();
                list2 = list;
                str2 = null;
                bundleZzf = zzc.zzf(c0442x, z13, z14, true, this.zzG.f2482a, this.f2539F, this.c, this.zzd, this.f2542I.longValue(), this.e.getPackageName(), j7);
                if (arrayListZzj.isEmpty()) {
                    arrayList = new ArrayList<>(list2.size() - 1);
                    arrayList2 = new ArrayList<>(list2.size() - 1);
                    arrayList3 = new ArrayList<>();
                    arrayList4 = new ArrayList<>();
                    arrayList5 = new ArrayList<>();
                    arrayList6 = new ArrayList<>();
                    i7 = 0;
                    while (i7 < list2.size()) {
                        C0436u c0436u5 = (C0436u) list2.get(i7);
                        c0418k0Zza = c0436u5.zza();
                        String str6 = str2;
                        if (!c0418k0Zza.f2493h.isEmpty()) {
                            arrayList3.add(c0418k0Zza.f2493h);
                        }
                        String strZzb3 = c0436u5.zzb();
                        arrayList4.add(strZzb3);
                        strZzc = c0418k0Zza.zzc(strZzb3);
                        if (!TextUtils.isEmpty(strZzc)) {
                            arrayList5.add(strZzc);
                        }
                        if (i7 > 0) {
                            arrayList.add(((C0436u) list2.get(i7)).zza().getProductId());
                            arrayList2.add(((C0436u) list2.get(i7)).zza().getProductType());
                        }
                        i7++;
                        str2 = str6;
                    }
                    str3 = str2;
                    bundleZzf.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                    if (!arrayList6.isEmpty()) {
                        bundleZzf.putIntegerArrayList("autoPayBalanceThresholdList", arrayList6);
                    }
                    if (!arrayList3.isEmpty()) {
                        bundleZzf.putStringArrayList("skuDetailsTokens", arrayList3);
                    }
                    if (!arrayList5.isEmpty()) {
                        bundleZzf.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                    }
                    if (!arrayList.isEmpty()) {
                        bundleZzf.putStringArrayList("additionalSkus", arrayList);
                        bundleZzf.putStringArrayList("additionalSkuTypes", arrayList2);
                    }
                } else {
                    arrayList7 = new ArrayList<>();
                    new ArrayList();
                    new ArrayList();
                    new ArrayList();
                    new ArrayList();
                    it = arrayListZzj.iterator();
                    if (!it.hasNext()) {
                        throw AbstractC1125a.g(it);
                    }
                    if (!arrayList7.isEmpty()) {
                        bundleZzf.putStringArrayList("skuDetailsTokens", arrayList7);
                    }
                    if (arrayListZzj.size() > 1) {
                        arrayList8 = new ArrayList<>(arrayListZzj.size() - 1);
                        arrayList9 = new ArrayList<>(arrayListZzj.size() - 1);
                        if (arrayListZzj.size() <= 1) {
                            arrayListZzj.get(1).getClass();
                            throw new ClassCastException();
                        }
                        bundleZzf.putStringArrayList("additionalSkus", arrayList8);
                        bundleZzf.putStringArrayList("additionalSkuTypes", arrayList9);
                    }
                    str3 = null;
                }
                if (!bundleZzf.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !this.f2555p) {
                    zzjs zzjsVar11 = zzjs.OFFER_ID_TOKEN_NOT_SUPPORTED;
                    H h17 = k1.f2523q;
                    P(zzjsVar11, h17, j7, z8);
                    d0(h17);
                    return h17;
                }
                if (TextUtils.isEmpty(c0436u.zza().zza())) {
                    z11 = false;
                } else {
                    bundleZzf.putString("skuPackageName", c0436u.zza().zza());
                    z11 = true;
                }
                if (TextUtils.isEmpty(str3)) {
                    str4 = str3;
                } else {
                    str4 = str3;
                    bundleZzf.putString("accountName", str4);
                }
                intent = activity.getIntent();
                if (intent == null) {
                    zzc.zzn("BillingClient", "Activity's intent is null.");
                } else if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                    String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                    bundleZzf.putString("proxyPackage", stringExtra);
                    try {
                        bundleZzf.putString("proxyPackageVersion", this.e.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                    } catch (PackageManager.NameNotFoundException unused) {
                        bundleZzf.putString("proxyPackageVersion", "package not found");
                    }
                }
                if (this.f2536C) {
                    i8 = 28;
                } else if (!this.f2558s && !list2.isEmpty()) {
                    i8 = 17;
                } else if (!this.f2556q && z11) {
                    i8 = 15;
                } else if (this.f2553n) {
                    i8 = 9;
                } else {
                    i8 = 6;
                }
                str = str4;
                final String str7 = productType;
                final Bundle bundle2 = bundleZzf;
                final int i13 = i8;
                futureZzP = zzP(new Callable() { // from class: com.android.billingclient.api.F0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f2429a.zzaC(i13, productId, str7, c0442x, bundle2);
                    }
                }, CoroutineLiveDataKt.DEFAULT_TIMEOUT, null, this.d, m());
                r7 = str7;
                r6 = bundle2;
            } else {
                str = null;
                futureZzP = zzP(new G0(this, productId, productType, 0), CoroutineLiveDataKt.DEFAULT_TIMEOUT, null, this.d, m());
                r7 = arrayListZzj;
                r6 = z8;
            }
            try {
                try {
                    try {
                        if (futureZzP == null) {
                            try {
                                zzjs zzjsVar12 = zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC;
                                H h18 = k1.c;
                                z9 = z8;
                                j6 = j7;
                                try {
                                    P(zzjsVar12, h18, j6, z9);
                                    d0(h18);
                                    return h18;
                                } catch (Exception e) {
                                    e = e;
                                    r8 = j6;
                                    r9 = z9;
                                }
                            } catch (CancellationException e6) {
                                e = e6;
                                r10 = z8;
                                r19 = j7;
                                zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                                zzjs zzjsVar13 = zzjs.LAUNCH_BILLING_FLOW_TIMEOUT;
                                H h19 = k1.f2517k;
                                zzbI(zzjsVar13, 2, h19, i1.zza(e), r19, r10);
                                d0(h19);
                                return h19;
                            } catch (TimeoutException e7) {
                                e = e7;
                                r10 = z8;
                                r19 = j7;
                                zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                                zzjs zzjsVar14 = zzjs.LAUNCH_BILLING_FLOW_TIMEOUT;
                                H h110 = k1.f2517k;
                                zzbI(zzjsVar14, 2, h110, i1.zza(e), r19, r10);
                                d0(h110);
                                return h110;
                            } catch (Exception e8) {
                                e = e8;
                                r6 = z8;
                                r8 = j7;
                                r9 = r6;
                            }
                        } else {
                            z10 = z8;
                            try {
                                bundle = (Bundle) futureZzP.get(CoroutineLiveDataKt.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
                                iZzb = zzc.zzb(bundle, "BillingClient");
                                strZzj = zzc.zzj(bundle, "BillingClient");
                                try {
                                    if (iZzb != 0) {
                                        Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                                        intent2.putExtra("BUY_INTENT", (PendingIntent) bundle.getParcelable("BUY_INTENT"));
                                        intent2.putExtra("billingClientTransactionId", j7);
                                        intent2.putExtra("wasServiceAutoReconnected", z10);
                                        activity.startActivity(intent2);
                                        return k1.f2515i;
                                    }
                                    zzc.zzn("BillingClient", AbstractC1282k.f(iZzb, "Unable to buy item, Error response code: "));
                                    H hA4 = k1.a(iZzb, strZzj);
                                    try {
                                        if (bundle != null || (obj = bundle.get("LOG_REASON")) == null) {
                                            zzjsVarZzb = zzjs.REASON_UNSPECIFIED;
                                        } else if (obj instanceof Integer) {
                                            zzjsVarZzb = zzjs.zzb(((Integer) obj).intValue());
                                        } else {
                                            zzc.zzn("BillingClient", "Unexpected type for bundle log reason: " + obj.getClass().getName());
                                            zzjsVarZzb = zzjs.REASON_UNSPECIFIED;
                                        }
                                    } catch (Throwable th2) {
                                        zzc.zzn("BillingClient", "Failed to get log reason from bundle: ".concat(String.valueOf(th2.getMessage())));
                                        zzjsVarZzb = zzjs.REASON_UNSPECIFIED;
                                    }
                                    if (zzjsVarZzb == zzjs.REASON_UNSPECIFIED) {
                                        zzjsVarZzb = zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
                                    }
                                    zzjs zzjsVar15 = zzjsVarZzb;
                                    if (bundle == null) {
                                        string = str;
                                    } else {
                                        try {
                                            string = bundle.getString("ADDITIONAL_LOG_DETAILS");
                                        } catch (Throwable th3) {
                                            zzc.zzn("BillingClient", "Failed to get additional log details from bundle: ".concat(String.valueOf(th3.getMessage())));
                                            string = str;
                                        }
                                    }
                                    try {
                                        zzbI(zzjsVar15, 2, hA4, string, j7, z10);
                                        d0(hA4);
                                        return hA4;
                                    } catch (CancellationException e9) {
                                        e = e9;
                                        r7 = j7;
                                        r6 = z10 ? 1 : 0;
                                        r19 = r7;
                                        r10 = r6;
                                        zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                                        zzjs zzjsVar16 = zzjs.LAUNCH_BILLING_FLOW_TIMEOUT;
                                        H h111 = k1.f2517k;
                                        zzbI(zzjsVar16, 2, h111, i1.zza(e), r19, r10);
                                        d0(h111);
                                        return h111;
                                    } catch (TimeoutException e10) {
                                        e = e10;
                                        r7 = j7;
                                        r6 = z10 ? 1 : 0;
                                        r19 = r7;
                                        r10 = r6;
                                        zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                                        zzjs zzjsVar17 = zzjs.LAUNCH_BILLING_FLOW_TIMEOUT;
                                        H h112 = k1.f2517k;
                                        zzbI(zzjsVar17, 2, h112, i1.zza(e), r19, r10);
                                        d0(h112);
                                        return h112;
                                    } catch (Exception e11) {
                                        e = e11;
                                        r8 = j7;
                                        r9 = z10 ? 1 : 0;
                                    }
                                } catch (Exception e12) {
                                    e = e12;
                                    r8 = r7;
                                    r9 = z10;
                                }
                            } catch (CancellationException e13) {
                                e = e13;
                                r10 = z10;
                                r19 = j7;
                                zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                                zzjs zzjsVar18 = zzjs.LAUNCH_BILLING_FLOW_TIMEOUT;
                                H h113 = k1.f2517k;
                                zzbI(zzjsVar18, 2, h113, i1.zza(e), r19, r10);
                                d0(h113);
                                return h113;
                            } catch (TimeoutException e14) {
                                e = e14;
                                r10 = z10;
                                r19 = j7;
                                zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                                zzjs zzjsVar19 = zzjs.LAUNCH_BILLING_FLOW_TIMEOUT;
                                H h114 = k1.f2517k;
                                zzbI(zzjsVar19, 2, h114, i1.zza(e), r19, r10);
                                d0(h114);
                                return h114;
                            }
                        }
                    } catch (Exception e15) {
                        e = e15;
                    }
                } catch (CancellationException e16) {
                    e = e16;
                } catch (TimeoutException e17) {
                    e = e17;
                }
            } catch (CancellationException e18) {
                e = e18;
                r10 = r6;
                r19 = j7;
            } catch (TimeoutException e19) {
                e = e19;
                r10 = r6;
                r19 = j7;
            }
            zzc.zzo("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
            zzjs zzjsVar20 = zzjs.LAUNCH_BILLING_FLOW_EXCEPTION;
            ?? r110 = r8;
            H h20 = k1.f2516j;
            zzbI(zzjsVar20, 2, h20, i1.zza(e), r110, r9);
            d0(h20);
            return h20;
        }
        hA3 = k1.f2515i;
        h6 = hA3;
        z7 = z6;
        list = listZzk;
        if (h6 != k1.f2515i) {
            P(zzjs.INVALID_BILLING_FLOW_PARAMS, h6, j7, z7);
            d0(h6);
            return h6;
        }
        z8 = z7;
        if (this.f2551l) {
            boolean z15 = this.f2553n;
            boolean z16 = this.f2560u;
            this.zzG.getClass();
            list2 = list;
            str2 = null;
            bundleZzf = zzc.zzf(c0442x, z15, z16, true, this.zzG.f2482a, this.f2539F, this.c, this.zzd, this.f2542I.longValue(), this.e.getPackageName(), j7);
            if (arrayListZzj.isEmpty()) {
                arrayList7 = new ArrayList<>();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                new ArrayList();
                it = arrayListZzj.iterator();
                if (!it.hasNext()) {
                    throw AbstractC1125a.g(it);
                }
                if (!arrayList7.isEmpty()) {
                    bundleZzf.putStringArrayList("skuDetailsTokens", arrayList7);
                }
                if (arrayListZzj.size() > 1) {
                    arrayList8 = new ArrayList<>(arrayListZzj.size() - 1);
                    arrayList9 = new ArrayList<>(arrayListZzj.size() - 1);
                    if (arrayListZzj.size() <= 1) {
                        arrayListZzj.get(1).getClass();
                        throw new ClassCastException();
                    }
                    bundleZzf.putStringArrayList("additionalSkus", arrayList8);
                    bundleZzf.putStringArrayList("additionalSkuTypes", arrayList9);
                }
                str3 = null;
            } else {
                arrayList = new ArrayList<>(list2.size() - 1);
                arrayList2 = new ArrayList<>(list2.size() - 1);
                arrayList3 = new ArrayList<>();
                arrayList4 = new ArrayList<>();
                arrayList5 = new ArrayList<>();
                arrayList6 = new ArrayList<>();
                i7 = 0;
                while (i7 < list2.size()) {
                    C0436u c0436u6 = (C0436u) list2.get(i7);
                    c0418k0Zza = c0436u6.zza();
                    String str8 = str2;
                    if (!c0418k0Zza.f2493h.isEmpty()) {
                        arrayList3.add(c0418k0Zza.f2493h);
                    }
                    String strZzb4 = c0436u6.zzb();
                    arrayList4.add(strZzb4);
                    strZzc = c0418k0Zza.zzc(strZzb4);
                    if (!TextUtils.isEmpty(strZzc)) {
                        arrayList5.add(strZzc);
                    }
                    if (i7 > 0) {
                        arrayList.add(((C0436u) list2.get(i7)).zza().getProductId());
                        arrayList2.add(((C0436u) list2.get(i7)).zza().getProductType());
                    }
                    i7++;
                    str2 = str8;
                }
                str3 = str2;
                bundleZzf.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                if (!arrayList6.isEmpty()) {
                    bundleZzf.putIntegerArrayList("autoPayBalanceThresholdList", arrayList6);
                }
                if (!arrayList3.isEmpty()) {
                    bundleZzf.putStringArrayList("skuDetailsTokens", arrayList3);
                }
                if (!arrayList5.isEmpty()) {
                    bundleZzf.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (!arrayList.isEmpty()) {
                    bundleZzf.putStringArrayList("additionalSkus", arrayList);
                    bundleZzf.putStringArrayList("additionalSkuTypes", arrayList2);
                }
            }
            if (!bundleZzf.containsKey("SKU_OFFER_ID_TOKEN_LIST")) {
            }
            if (TextUtils.isEmpty(c0436u.zza().zza())) {
                bundleZzf.putString("skuPackageName", c0436u.zza().zza());
                z11 = true;
            } else {
                z11 = false;
            }
            if (TextUtils.isEmpty(str3)) {
                str4 = str3;
                bundleZzf.putString("accountName", str4);
            } else {
                str4 = str3;
            }
            intent = activity.getIntent();
            if (intent == null) {
                zzc.zzn("BillingClient", "Activity's intent is null.");
            } else if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                String stringExtra2 = intent.getStringExtra("PROXY_PACKAGE");
                bundleZzf.putString("proxyPackage", stringExtra2);
                bundleZzf.putString("proxyPackageVersion", this.e.getPackageManager().getPackageInfo(stringExtra2, 0).versionName);
            }
            if (this.f2536C) {
                i8 = 28;
            } else if (!this.f2558s) {
                if (!this.f2556q) {
                    if (this.f2553n) {
                        i8 = 9;
                    } else {
                        i8 = 6;
                    }
                } else if (this.f2553n) {
                    i8 = 9;
                } else {
                    i8 = 6;
                }
            } else if (!this.f2556q) {
                if (this.f2553n) {
                    i8 = 9;
                } else {
                    i8 = 6;
                }
            } else if (this.f2553n) {
                i8 = 9;
            } else {
                i8 = 6;
            }
            str = str4;
            final String str9 = productType;
            final Bundle bundle3 = bundleZzf;
            final int i14 = i8;
            futureZzP = zzP(new Callable() { // from class: com.android.billingclient.api.F0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f2429a.zzaC(i14, productId, str9, c0442x, bundle3);
                }
            }, CoroutineLiveDataKt.DEFAULT_TIMEOUT, null, this.d, m());
            r7 = str9;
            r6 = bundle3;
        } else {
            str = null;
            futureZzP = zzP(new G0(this, productId, productType, 0), CoroutineLiveDataKt.DEFAULT_TIMEOUT, null, this.d, m());
            r7 = arrayListZzj;
            r6 = z8;
        }
        if (futureZzP == null) {
            zzjs zzjsVar110 = zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC;
            H h115 = k1.c;
            z9 = z8;
            j6 = j7;
            P(zzjsVar110, h115, j6, z9);
            d0(h115);
            return h115;
        }
        z10 = z8;
        bundle = (Bundle) futureZzP.get(CoroutineLiveDataKt.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        iZzb = zzc.zzb(bundle, "BillingClient");
        strZzj = zzc.zzj(bundle, "BillingClient");
        if (iZzb != 0) {
            Intent intent3 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
            intent3.putExtra("BUY_INTENT", (PendingIntent) bundle.getParcelable("BUY_INTENT"));
            intent3.putExtra("billingClientTransactionId", j7);
            intent3.putExtra("wasServiceAutoReconnected", z10);
            activity.startActivity(intent3);
            return k1.f2515i;
        }
        zzc.zzn("BillingClient", AbstractC1282k.f(iZzb, "Unable to buy item, Error response code: "));
        H hA5 = k1.a(iZzb, strZzj);
        if (bundle != null) {
            zzjsVarZzb = zzjs.REASON_UNSPECIFIED;
        } else if (obj instanceof Integer) {
            zzjsVarZzb = zzjs.zzb(((Integer) obj).intValue());
        } else {
            zzc.zzn("BillingClient", "Unexpected type for bundle log reason: " + obj.getClass().getName());
            zzjsVarZzb = zzjs.REASON_UNSPECIFIED;
        }
        if (zzjsVarZzb == zzjs.REASON_UNSPECIFIED) {
            zzjsVarZzb = zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
        }
        zzjs zzjsVar111 = zzjsVarZzb;
        if (bundle == null) {
            string = str;
        } else {
            string = bundle.getString("ADDITIONAL_LOG_DETAILS");
        }
        zzbI(zzjsVar111, 2, hA5, string, j7, z10);
        d0(hA5);
        return hA5;
        zzc.zzo("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
        zzjs zzjsVar21 = zzjs.LAUNCH_BILLING_FLOW_EXCEPTION;
        ?? r111 = r8;
        H h21 = k1.f2516j;
        zzbI(zzjsVar21, 2, h21, i1.zza(e), r111, r9);
        d0(h21);
        return h21;
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public void launchExternalLink(Activity activity, C0410g0 c0410g0, InterfaceC0412h0 interfaceC0412h0) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        try {
            try {
                zzaX(new G0(this, c0410g0, activity, 2), 30000L, new E0(this, 6), u());
            } catch (Exception e) {
                e = e;
                zzbk(interfaceC0412h0, w(), zzjs.SERVICE_CALL_EXCEPTION, e);
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    public final synchronized ExecutorService m() {
        try {
            if (this.f2541H == null) {
                this.f2541H = Executors.newFixedThreadPool(zzc.zza, new N0(this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f2541H;
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public void queryProductDetailsAsync(C0443x0 c0443x0, InterfaceC0426o0 interfaceC0426o0) {
        if (zzP(new G0(this, interfaceC0426o0, c0443x0, 4), 30000L, new Q0.b(this, interfaceC0426o0, 8), u(), m()) == null) {
            H hW = w();
            N(7, hW, zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC);
            ((p062l0.a) interfaceC0426o0).onProductDetailsResponse(hW, new C0445y0(zzca.zzk(), zzca.zzk()));
        }
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public final void queryPurchasesAsync(A0 a6, InterfaceC0433s0 interfaceC0433s0) {
        if (zzP(new O0(this, interfaceC0433s0, a6.zza(), a6.b), 30000L, new Q0.b(this, interfaceC0433s0, 6), u(), m()) == null) {
            H hW = w();
            N(9, hW, zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC);
            ((F4.f) interfaceC0433s0).onQueryPurchasesResponse(hW, zzca.zzk());
        }
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public H showAlternativeBillingOnlyInformationDialog(Activity activity, InterfaceC0407f interfaceC0407f) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!W(p002a.c.b)) {
            zzjs zzjsVar = zzjs.SERVICE_CONNECTION_NOT_READY;
            H h6 = k1.f2516j;
            N(16, h6, zzjsVar);
            return h6;
        }
        if (!this.f2562w) {
            zzc.zzn("BillingClient", "Current Play Store version doesn't support alternative billing only.");
            zzjs zzjsVar2 = zzjs.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED;
            H h7 = k1.f2503D;
            N(16, h7, zzjsVar2);
            return h7;
        }
        Handler handler = this.d;
        if (zzP(new H0(this, activity, new zzbr(this, handler), 0), 30000L, new E0(this, 1), handler, m()) != null) {
            return k1.f2515i;
        }
        H hW = w();
        N(16, hW, zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC);
        return hW;
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public void showBillingProgramInformationDialog(Activity activity, B b, InterfaceC0446z interfaceC0446z) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        try {
            try {
                zzaX(new G0(this, b, activity, 1), 30000L, new E0(this, 3), u());
            } catch (Exception e) {
                e = e;
                zzbm(interfaceC0446z, w(), zzjs.SERVICE_CALL_EXCEPTION, e);
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public H showExternalOfferInformationDialog(Activity activity, T t6) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!W(p002a.c.b)) {
            zzjs zzjsVar = zzjs.SERVICE_CONNECTION_NOT_READY;
            H h6 = k1.f2516j;
            N(25, h6, zzjsVar);
            return h6;
        }
        if (!this.f2563x) {
            zzc.zzn("BillingClient", "Current Play Store version doesn't support external offer.");
            zzjs zzjsVar2 = zzjs.EXTERNAL_OFFER_NOT_SUPPORTED;
            H h7 = k1.f2527u;
            N(25, h7, zzjsVar2);
            return h7;
        }
        Handler handler = this.d;
        if (zzP(new H0(this, activity, new zzbs(this, handler), 1), 30000L, new E0(this, 10), handler, m()) != null) {
            return k1.f2515i;
        }
        H hW = w();
        N(25, hW, zzjs.MISSING_RESULT_FROM_EXECUTE_ASYNC);
        return hW;
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public final H showInAppMessages(final Activity activity, C0400b0 c0400b0, InterfaceC0402c0 interfaceC0402c0) {
        if (!W(p002a.c.b)) {
            zzc.zzn("BillingClient", "Service disconnected.");
            return k1.f2516j;
        }
        if (!this.f2554o) {
            zzc.zzn("BillingClient", "Current client doesn't support showing in-app messages.");
            return k1.f2526t;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        IBinder windowToken = viewFindViewById.getWindowToken();
        if (windowToken == null) {
            zzc.zzn("BillingClient", "Could not retrieve the window token from the activity instance.");
        }
        Rect rect = new Rect();
        viewFindViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.c);
        String str = this.zzd;
        if (str != null) {
            bundle.putString("playBillingLibraryWrapperVersion", str);
        }
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", c0400b0.f2465a);
        if (!TextUtils.isEmpty(null)) {
            bundle.putString("accountName", null);
        }
        Handler handler = this.d;
        final zzbq zzbqVar = new zzbq(handler);
        zzP(new Callable() { // from class: com.android.billingclient.api.M0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.f2442a.zzaM(bundle, activity, zzbqVar);
                return null;
            }
        }, CoroutineLiveDataKt.DEFAULT_TIMEOUT, null, handler, m());
        return k1.f2515i;
    }

    @Override // com.android.billingclient.api.AbstractC0419l
    public void startConnection(InterfaceC0423n interfaceC0423n) {
        U(interfaceC0423n, 0);
    }

    public final Handler u() {
        return Looper.myLooper() == null ? this.d : new Handler(Looper.myLooper());
    }

    public final H v(int i5) {
        zzc.zzm("BillingClient", "Service connection is valid. No need to re-initialize.");
        zzjn zzjnVarZza = zzjp.zza();
        zzjnVarZza.zze(6);
        zzll zzllVarZza = zzln.zza();
        zzllVarZza.zze(true);
        zzllVarZza.zza(i5 > 0);
        zzllVarZza.zzb(i5);
        zzjnVarZza.zzd(zzllVarZza);
        R((zzjp) zzjnVarZza.zzi());
        return k1.f2515i;
    }

    public final H w() {
        int[] iArr = {0, 3};
        synchronized (this.f2544a) {
            for (int i5 = 0; i5 < 2; i5++) {
                if (this.b == iArr[i5]) {
                    return k1.f2516j;
                }
            }
            return k1.f2514h;
        }
    }

    public final zzdk x(int i5) {
        if (!this.f2538E || Y()) {
            zzc.zzm("BillingClient", "Already connected or not opted into auto reconnection.");
            return zzdf.zza(k1.f2515i);
        }
        p067m.k kVar = new p067m.k();
        kVar.b = this;
        kVar.f6115a = i5;
        return zzu.zza(kVar);
    }

    public final void y() {
        if (TextUtils.isEmpty(null)) {
            this.e.getPackageName();
        }
    }

    @VisibleForTesting
    public final b1 zzi(C0443x0 c0443x0) {
        zzar zzarVar;
        int i5;
        int i6;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strZzb = c0443x0.zzb();
        zzca zzcaVar = c0443x0.f2590a;
        int size = zzcaVar.size();
        int i7 = 0;
        while (i7 < size) {
            int i8 = i7 + 20;
            ArrayList arrayList3 = new ArrayList(zzcaVar.subList(i7, i8 > size ? size : i8));
            ArrayList<String> arrayList4 = new ArrayList<>();
            int size2 = arrayList3.size();
            for (int i9 = 0; i9 < size2; i9++) {
                arrayList4.add(((C0441w0) arrayList3.get(i9)).zza());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList4);
            String str = this.c;
            bundle.putString("playBillingLibraryVersion", str);
            try {
                synchronized (this.f2544a) {
                    zzarVar = this.f2546g;
                }
                if (zzarVar == null) {
                    return zzaF(k1.f2516j, zzjs.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                }
                boolean z6 = this.f2560u && this.zzG.f2482a;
                y();
                y();
                y();
                y();
                zza zzaVarZza = zza.zza(z6, true, true, true, false, true);
                Bundle bundleZzj = zzarVar.zzj(true != this.f2561v ? 17 : 20, this.e.getPackageName(), strZzb, bundle, zzc.zzg(str, this.zzd, arrayList3, null, null, zzaVarZza, this.f2542I.longValue()));
                if (bundleZzj == null) {
                    return zzaF(k1.f2501B, zzjs.NULL_BUNDLE_FROM_GET_SKU_DETAILS_SERVICE_CALL, "queryProductDetailsAsync got empty product details response.", null);
                }
                if (!bundleZzj.containsKey("DETAILS_LIST")) {
                    int iZzb = zzc.zzb(bundleZzj, "BillingClient");
                    String strZzj = zzc.zzj(bundleZzj, "BillingClient");
                    return iZzb != 0 ? zzaF(k1.a(iZzb, strZzj), zzjs.BILLING_RESULT_RECEIVED_FROM_PHONESKY, AbstractC1282k.f(iZzb, "getSkuDetails() failed for queryProductDetailsAsync. Response code: "), null) : zzaF(k1.a(6, strZzj), zzjs.MISSING_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.", null);
                }
                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return zzaF(k1.f2501B, zzjs.NULL_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "queryProductDetailsAsync got null response list", null);
                }
                ArrayList arrayList5 = new ArrayList();
                int size3 = stringArrayList.size();
                for (int i10 = 0; i10 < size3; i10++) {
                    try {
                        C0418k0 c0418k0 = new C0418k0(stringArrayList.get(i10));
                        zzc.zzm("BillingClient", "Got product details: ".concat(c0418k0.toString()));
                        arrayList5.add(c0418k0);
                    } catch (JSONException e) {
                        return zzaF(k1.a(6, "Error trying to decode SkuDetails."), zzjs.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e);
                    }
                }
                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("UNFETCHED_PRODUCT_LIST");
                new ArrayList();
                try {
                    ArrayList arrayList6 = new ArrayList();
                    if (stringArrayList2 != null) {
                        int size4 = stringArrayList2.size();
                        int i11 = 0;
                        while (i11 < size4) {
                            String str2 = stringArrayList2.get(i11);
                            i11++;
                            B0 b1 = new B0(str2);
                            zzc.zzm("BillingClient", "Got unfetchedProduct: ".concat(b1.toString()));
                            arrayList6.add(b1);
                        }
                    } else {
                        int size5 = arrayList3.size();
                        int i12 = 0;
                        while (i12 < size5) {
                            Object obj = arrayList3.get(i12);
                            int i13 = i12 + 1;
                            C0441w0 c0441w0 = (C0441w0) obj;
                            int size6 = arrayList5.size();
                            int i14 = 0;
                            while (true) {
                                if (i14 >= size6) {
                                    i5 = size5;
                                    i6 = i13;
                                    arrayList6.add(new B0(new JSONObject().put("productId", c0441w0.zza()).put("type", c0441w0.zzb()).put("statusCode", 0).toString()));
                                    break;
                                }
                                Object obj2 = arrayList5.get(i14);
                                i14++;
                                C0418k0 c0418k1 = (C0418k0) obj2;
                                i5 = size5;
                                i6 = i13;
                                if (c0441w0.zza().equals(c0418k1.getProductId()) && c0441w0.zzb().equals(c0418k1.getProductType())) {
                                    break;
                                }
                                size5 = i5;
                                i13 = i6;
                            }
                            size5 = i5;
                            i12 = i6;
                        }
                    }
                    arrayList.addAll(arrayList5);
                    arrayList2.addAll(arrayList6);
                    i7 = i8;
                } catch (JSONException e6) {
                    return zzaF(k1.a(6, "Error trying to decode SkuDetails."), zzjs.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode UnfetchedProduct. \n Exception: ", e6);
                }
            } catch (DeadObjectException e7) {
                return zzaF(k1.f2516j, zzjs.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e7);
            } catch (Exception e8) {
                return zzaF(k1.f2514h, zzjs.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e8);
            }
        }
        return new b1(0, "", arrayList, arrayList2);
    }

    private void initialize(Context context, InterfaceC0435t0 interfaceC0435t0, C0416j0 c0416j0, String str, @Nullable j1 j1Var, C0417k c0417k) {
        this.e = context.getApplicationContext();
        zzke zzkeVarZza = zzkg.zza();
        zzkeVarZza.zzx(str);
        String str2 = this.zzd;
        if (str2 != null) {
            zzkeVarZza.zzy(str2);
        }
        zzkeVarZza.zzq(this.e.getPackageName());
        zzkeVarZza.zzd(this.f2542I.longValue());
        zzkeVarZza.zzw(c0417k.f2489j);
        zzkeVarZza.zza(Build.VERSION.SDK_INT);
        zzkeVarZza.zzp(926300087L);
        L(zzkeVarZza, context);
        try {
            zzkeVarZza.zzb(this.e.getPackageManager().getPackageInfo(this.e.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        if (j1Var != null) {
            this.f2545f = j1Var;
        } else {
            this.f2545f = new m1(this.e, (zzkg) zzkeVarZza.zzi());
        }
        if (interfaceC0435t0 == null) {
            zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzf = new y1(this.e, interfaceC0435t0, this.f2545f);
        this.zzG = c0416j0;
        this.e.getPackageName();
        this.f2538E = c0417k.f2489j;
    }

    @AnyThread
    public C0421m(@Nullable String str, C0416j0 c0416j0, Context context, InterfaceC0435t0 interfaceC0435t0, @Nullable C0 c6, @Nullable O o6, @Nullable j1 j1Var, @Nullable ExecutorService executorService, C0417k c0417k) {
        this.f2544a = new Object();
        this.b = 0;
        this.d = new Handler(Looper.getMainLooper());
        this.f2550k = 0;
        this.f2540G = zzcf.zzk();
        this.f2542I = Long.valueOf(new Random().nextLong());
        this.f2543J = zzbf.zza();
        this.c = "9.1.0";
        this.zzd = zzaO();
        initialize(context, interfaceC0435t0, c0416j0, c6, o6, "9.1.0", null, c0417k);
    }

    @AnyThread
    public C0421m(@Nullable String str, C0416j0 c0416j0, Context context, InterfaceC0435t0 interfaceC0435t0, @Nullable j1 j1Var, @Nullable ExecutorService executorService, C0417k c0417k) {
        this.f2544a = new Object();
        this.b = 0;
        this.d = new Handler(Looper.getMainLooper());
        this.f2550k = 0;
        this.f2540G = zzcf.zzk();
        this.f2542I = Long.valueOf(new Random().nextLong());
        this.f2543J = zzbf.zza();
        this.c = "9.1.0";
        this.zzd = zzaO();
        initialize(context, interfaceC0435t0, c0416j0, "9.1.0", null, c0417k);
    }

    @AnyThread
    public C0421m(@Nullable String str, C0416j0 c0416j0, Context context, n1 n1Var, @Nullable j1 j1Var, @Nullable ExecutorService executorService, C0417k c0417k) {
        this.f2544a = new Object();
        this.b = 0;
        this.d = new Handler(Looper.getMainLooper());
        this.f2550k = 0;
        this.f2540G = zzcf.zzk();
        long jNextLong = new Random().nextLong();
        this.f2542I = Long.valueOf(jNextLong);
        this.f2543J = zzbf.zza();
        this.c = "9.1.0";
        String strZzaO = zzaO();
        this.zzd = strZzaO;
        this.e = context.getApplicationContext();
        zzke zzkeVarZza = zzkg.zza();
        zzkeVarZza.zzx("9.1.0");
        if (strZzaO != null) {
            zzkeVarZza.zzy(strZzaO);
        }
        zzkeVarZza.zzq(this.e.getPackageName());
        zzkeVarZza.zzd(jNextLong);
        zzkeVarZza.zzw(c0417k.f2489j);
        zzkeVarZza.zza(Build.VERSION.SDK_INT);
        zzkeVarZza.zzp(926300087L);
        L(zzkeVarZza, context);
        try {
            zzkeVarZza.zzb(this.e.getPackageManager().getPackageInfo(this.e.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.f2545f = new m1(this.e, (zzkg) zzkeVarZza.zzi());
        zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzf = new y1(this.e, null, this.f2545f);
        this.zzG = c0416j0;
        this.e.getPackageName();
        this.f2538E = c0417k.f2489j;
    }
}
