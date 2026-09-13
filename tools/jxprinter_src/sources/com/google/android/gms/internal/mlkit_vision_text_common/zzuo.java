package com.google.android.gms.internal.mlkit_vision_text_common;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzuo {

    @Nullable
    private static zzuo zza;

    private zzuo() {
    }

    public static synchronized zzuo zza() {
        try {
            if (zza == null) {
                zza = new zzuo();
            }
        } catch (Throwable th) {
            throw th;
        }
        return zza;
    }
}
