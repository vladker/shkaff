package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzca;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.android.billingclient.api.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0429q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2570a;
    public String b;
    public ArrayList c;
    public boolean d;
    public C0438v e;

    @Nullable
    private N zzf;

    @NonNull
    public C0442x build() {
        ArrayList arrayList = this.c;
        if (arrayList == null || arrayList.isEmpty()) {
            throw new IllegalArgumentException("Details of the products must be provided.");
        }
        ArrayList arrayList2 = this.c;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList2.get(i5);
                i5++;
                if (((C0436u) obj) == null) {
                    throw new IllegalArgumentException("ProductDetailsParams cannot be null.");
                }
            }
        }
        C0442x c0442x = new C0442x();
        c0442x.f2587a = !((C0436u) this.c.get(0)).zza().zza().isEmpty();
        c0442x.b = this.f2570a;
        c0442x.c = this.b;
        c0442x.d = this.e.build();
        c0442x.f2588f = new ArrayList();
        c0442x.f2589g = this.d;
        ArrayList arrayList3 = this.c;
        c0442x.e = arrayList3 != null ? zzca.zzj(arrayList3) : zzca.zzk();
        c0442x.zzh = this.zzf;
        return c0442x;
    }

    @NonNull
    public C0429q enableDeveloperBillingOption(@NonNull N n6) {
        this.zzf = n6;
        return this;
    }

    @NonNull
    public C0429q setIsOfferPersonalized(boolean z6) {
        this.d = z6;
        return this;
    }

    @NonNull
    public C0429q setObfuscatedAccountId(@NonNull String str) {
        this.f2570a = str;
        return this;
    }

    @NonNull
    public C0429q setObfuscatedProfileId(@NonNull String str) {
        this.b = str;
        return this;
    }

    @NonNull
    public C0429q setProductDetailsParamsList(@NonNull List<C0436u> list) {
        this.c = new ArrayList(list);
        return this;
    }

    @NonNull
    public C0429q setSubscriptionUpdateParams(@NonNull C0440w c0440w) {
        C0438v c0438vNewBuilder = C0440w.newBuilder();
        c0438vNewBuilder.setOldPurchaseToken(c0440w.f2584a);
        c0438vNewBuilder.setSubscriptionReplacementMode(c0440w.c);
        c0438vNewBuilder.setOriginalExternalTransactionId(c0440w.b);
        this.e = c0438vNewBuilder;
        return this;
    }
}
