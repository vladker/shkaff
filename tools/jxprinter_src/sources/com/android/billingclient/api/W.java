package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2456a;

    @Nullable
    private Locale zza;

    @NonNull
    private String zzc;

    @NonNull
    public X build() {
        if (this.f2456a != 5) {
            throw new IllegalArgumentException("Only billing choice is allowed for this API.");
        }
        if (this.zzc != null) {
            return new X(this);
        }
        throw new IllegalArgumentException("Play Billing choice image layout is required.");
    }

    @NonNull
    public W setBillingProgram(int i5) {
        this.f2456a = i5;
        return this;
    }

    @NonNull
    public W setPlayBillingChoiceImageLayout(@NonNull String str) {
        this.zzc = str;
        return this;
    }

    @NonNull
    public W setUserLocale(@Nullable Locale locale) {
        this.zza = locale;
        return this;
    }
}
