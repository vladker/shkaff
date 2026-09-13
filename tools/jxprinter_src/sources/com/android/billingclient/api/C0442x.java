package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzca;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.android.billingclient.api.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0442x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2587a;
    public String b;
    public String c;
    public C0440w d;
    public zzca e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f2588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2589g;

    @Nullable
    private N zzh;

    @NonNull
    public static C0429q newBuilder() {
        C0429q c0429q = new C0429q();
        C0438v c0438vNewBuilder = C0440w.newBuilder();
        c0438vNewBuilder.c = true;
        c0429q.e = c0438vNewBuilder;
        return c0429q;
    }

    @Nullable
    public N getDeveloperBillingOptionParams() {
        return this.zzh;
    }

    @Nullable
    public final String zze() {
        return this.b;
    }

    @Nullable
    public final String zzf() {
        return this.c;
    }

    @Nullable
    @Deprecated
    public String zzg() {
        return null;
    }

    @Nullable
    @Deprecated
    public final String zzh() {
        return this.d.f2584a;
    }

    @Nullable
    public final String zzi() {
        return this.d.b;
    }

    @NonNull
    public final ArrayList zzj() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f2588f);
        return arrayList;
    }

    @NonNull
    public final List zzk() {
        return this.e;
    }
}
