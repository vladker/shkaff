package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzxa {

    @Nullable
    private static zzwz zza;

    public static synchronized zzwp zza(zzwh zzwhVar) {
        try {
            if (zza == null) {
                zza = new zzwz(null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (zzwp) zza.get(zzwhVar);
    }

    public static synchronized zzwp zzb(String str) {
        return zza(zzwh.zzd(str).zzd());
    }
}
