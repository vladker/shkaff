package com.google.android.gms.internal.mlkit_vision_text_common;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzun {

    @Nullable
    private static zzum zza;

    public static synchronized zzuc zza(zztu zztuVar) {
        try {
            if (zza == null) {
                zza = new zzum(null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (zzuc) zza.get(zztuVar);
    }

    public static synchronized zzuc zzb(String str) {
        return zza(zztu.zzd(str).zzd());
    }
}
