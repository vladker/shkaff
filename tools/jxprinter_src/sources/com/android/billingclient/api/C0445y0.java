package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: renamed from: com.android.billingclient.api.y0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0445y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2592a;
    public final List b;

    public C0445y0(List list, List list2) {
        this.f2592a = list;
        this.b = list2;
    }

    @NonNull
    public static C0445y0 create(@NonNull List<C0418k0> list, @NonNull List<B0> list2) {
        return new C0445y0(list, list2);
    }

    @NonNull
    public List<C0418k0> getProductDetailsList() {
        return this.f2592a;
    }

    @NonNull
    public List<B0> getUnfetchedProductList() {
        return this.b;
    }
}
