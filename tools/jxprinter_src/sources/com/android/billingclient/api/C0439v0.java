package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: com.android.billingclient.api.v0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0439v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2583a;
    public String b;

    @Nullable
    private String dynamicProductToken;

    @NonNull
    public C0441w0 build() {
        String str = this.b;
        if ("first_party".equals(str)) {
            throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
        }
        if (this.f2583a == null) {
            throw new IllegalArgumentException("Product id must be provided.");
        }
        if (str != null) {
            return new C0441w0(this);
        }
        throw new IllegalArgumentException("Product type must be provided.");
    }

    @NonNull
    public C0439v0 setDynamicProductToken(@NonNull String str) {
        this.dynamicProductToken = str;
        return this;
    }

    @NonNull
    public C0439v0 setProductId(@NonNull String str) {
        this.f2583a = str;
        return this;
    }

    @NonNull
    public C0439v0 setProductType(@NonNull String str) {
        this.b = str;
        return this;
    }
}
