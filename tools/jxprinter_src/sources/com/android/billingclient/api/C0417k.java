package com.android.billingclient.api;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzc;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: com.android.billingclient.api.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0417k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile C0416j0 f2484a;
    public final Context b;
    public volatile InterfaceC0435t0 c;
    public volatile boolean d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f2485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f2486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f2487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f2488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f2489j;

    @Nullable
    private volatile O zzj;

    @Nullable
    private volatile ExecutorService zzk;

    public /* synthetic */ C0417k(Context context) {
        this.b = context;
    }

    public final boolean a() {
        try {
            Context context = this.b;
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("com.google.android.play.billingclient.enableBillingOverridesTesting", false);
        } catch (Exception e) {
            zzc.zzo("BillingClient", "Unable to retrieve metadata value for enableBillingOverridesTesting.", e);
            return false;
        }
    }

    @NonNull
    public AbstractC0419l build() {
        Context context = this.b;
        if (context == null) {
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
        if (this.c == null) {
            if (this.f2488i) {
                throw new IllegalArgumentException("Please provide a valid listener for Google Play Billing purchases updates when enabling user choice billing or billing choice.");
            }
            if (this.d || this.e || this.f2485f || this.f2486g || this.f2487h) {
                return a() ? new h1(null, context, null, null, this) : new C0421m(null, context, null, null, this);
            }
            throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
        }
        if (this.f2484a == null) {
            throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
        }
        this.f2484a.getClass();
        if (this.c == null) {
            C0416j0 c0416j0 = this.f2484a;
            return a() ? new h1((String) null, c0416j0, context, (n1) null, (j1) null, (ExecutorService) null, this) : new C0421m((String) null, c0416j0, context, (n1) null, (j1) null, (ExecutorService) null, this);
        }
        C0416j0 c0416j1 = this.f2484a;
        InterfaceC0435t0 interfaceC0435t0 = this.c;
        return a() ? new h1((String) null, c0416j1, context, interfaceC0435t0, (j1) null, (ExecutorService) null, this) : new C0421m((String) null, c0416j1, context, interfaceC0435t0, (j1) null, (ExecutorService) null, this);
    }

    @NonNull
    public C0417k enableAlternativeBillingOnly() {
        this.d = true;
        return this;
    }

    @NonNull
    public C0417k enableAutoServiceReconnection() {
        this.f2489j = true;
        return this;
    }

    @NonNull
    public C0417k enableBillingProgram(int i5) {
        P pNewBuilder = Q.newBuilder();
        pNewBuilder.setBillingProgram(i5);
        enableBillingProgram(pNewBuilder.build());
        return this;
    }

    @NonNull
    @Deprecated
    public C0417k enableExternalOffer() {
        this.e = true;
        return this;
    }

    @NonNull
    public C0417k enablePendingPurchases(@NonNull C0416j0 c0416j0) {
        this.f2484a = c0416j0;
        return this;
    }

    @NonNull
    public C0417k setListener(@NonNull InterfaceC0435t0 interfaceC0435t0) {
        this.c = interfaceC0435t0;
        return this;
    }

    @NonNull
    public C0417k enableBillingProgram(@NonNull Q q6) {
        q6.getDeveloperProvidedBillingListener();
        int i5 = q6.f2448a;
        if (i5 == 1) {
            this.f2485f = true;
            return this;
        }
        if (i5 == 2) {
            this.f2486g = true;
            return this;
        }
        if (i5 == 3) {
            this.e = true;
            return this;
        }
        if (i5 == 4) {
            this.f2487h = true;
            return this;
        }
        if (i5 == 5) {
            this.f2488i = true;
            return this;
        }
        throw new IllegalArgumentException("An invalid BillingProgram has been provided.");
    }

    @NonNull
    public C0417k enableUserChoiceBilling(@NonNull C0 c6) {
        return this;
    }
}
