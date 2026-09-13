package com.google.firebase.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ParametersBuilder {
    private final Bundle zza = new Bundle();

    public final Bundle getBundle() {
        return this.zza;
    }

    public final void param(@NonNull String key, double d) {
        E.f(key, "key");
        this.zza.putDouble(key, d);
    }

    public final void param(@NonNull String key, long j6) {
        E.f(key, "key");
        this.zza.putLong(key, j6);
    }

    public final void param(@NonNull String key, @NonNull Bundle value) {
        E.f(key, "key");
        E.f(value, "value");
        this.zza.putBundle(key, value);
    }

    public final void param(@NonNull String key, @NonNull String value) {
        E.f(key, "key");
        E.f(value, "value");
        this.zza.putString(key, value);
    }

    public final void param(@NonNull String key, @NonNull Bundle[] value) {
        E.f(key, "key");
        E.f(value, "value");
        this.zza.putParcelableArray(key, value);
    }
}
