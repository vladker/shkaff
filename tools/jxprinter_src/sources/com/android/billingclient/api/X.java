package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2458a;

    @NonNull
    private final String playBillingChoiceImageLayout;

    @Nullable
    private final Locale userLocale;

    public X(W w6) {
        this.userLocale = w6.zza;
        this.f2458a = w6.f2456a;
        this.playBillingChoiceImageLayout = w6.zzc;
    }

    @NonNull
    public static W newBuilder() {
        W w6 = new W();
        w6.f2456a = 0;
        return w6;
    }

    @NonNull
    public String getPlayBillingChoiceImageLayout() {
        return this.playBillingChoiceImageLayout;
    }

    @Nullable
    public Locale getUserLocale() {
        return this.userLocale;
    }
}
