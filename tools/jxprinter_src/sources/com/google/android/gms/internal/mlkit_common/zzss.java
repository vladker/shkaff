package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzss {

    @Nullable
    private static zzsr zza;

    public static synchronized zzsh zza(zzsb zzsbVar) {
        try {
            if (zza == null) {
                zza = new zzsr(null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (zzsh) zza.get(zzsbVar);
    }

    public static synchronized zzsh zzb(String str) {
        return zza(zzsb.zzd("common").zzd());
    }
}
