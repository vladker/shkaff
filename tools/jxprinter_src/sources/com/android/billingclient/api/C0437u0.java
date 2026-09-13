package com.android.billingclient.api;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.play_billing.zzca;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: renamed from: com.android.billingclient.api.u0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0437u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zzca f2580a;

    @NonNull
    public C0443x0 build() {
        if (this.f2580a != null) {
            return new C0443x0(this);
        }
        throw new IllegalArgumentException("Product list must be set to a non empty list.");
    }

    @NonNull
    public C0437u0 setProductList(@NonNull List<C0441w0> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be empty.");
        }
        HashSet hashSet = new HashSet();
        for (C0441w0 c0441w0 : list) {
            if (!"play_pass_subs".equals(c0441w0.zzb())) {
                hashSet.add(c0441w0.zzb());
            }
        }
        if (hashSet.size() > 1) {
            throw new IllegalArgumentException("All products should be of the same product type.");
        }
        this.f2580a = zzca.zzj(list);
        return this;
    }
}
