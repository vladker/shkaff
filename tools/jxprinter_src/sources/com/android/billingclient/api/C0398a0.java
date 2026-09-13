package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.HashSet;

/* JADX INFO: renamed from: com.android.billingclient.api.a0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C0398a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f2462a = new HashSet();

    @NonNull
    public C0398a0 addAllInAppMessageCategoriesToShow() {
        this.f2462a.add(2);
        return this;
    }

    @NonNull
    public C0398a0 addInAppMessageCategoryToShow(int i5) {
        this.f2462a.add(Integer.valueOf(i5));
        return this;
    }

    @NonNull
    public C0400b0 build() {
        return new C0400b0(this.f2462a);
    }
}
