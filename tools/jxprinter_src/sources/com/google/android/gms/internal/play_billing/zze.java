package com.google.android.gms.internal.play_billing;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zze {
    static final zze zza;
    static final zze zzb;

    @Nullable
    final Throwable zzc;

    static {
        if (zzo.zza) {
            zzb = null;
            zza = null;
        } else {
            zzb = new zze(false, null);
            zza = new zze(true, null);
        }
    }

    public zze(boolean z6, @Nullable Throwable th) {
        this.zzc = th;
    }
}
