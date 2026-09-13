package com.google.android.gms.internal.mlkit_vision_text_common;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zznu {
    private Long zza;
    private Long zzb;
    private Long zzc;
    private Long zzd;
    private Long zze;
    private Long zzf;

    public final zznu zza(Long l6) {
        this.zzc = Long.valueOf(l6.longValue() & LocationRequestCompat.PASSIVE_INTERVAL);
        return this;
    }

    public final zznu zzb(Long l6) {
        this.zzd = Long.valueOf(l6.longValue() & LocationRequestCompat.PASSIVE_INTERVAL);
        return this;
    }

    public final zznu zzc(Long l6) {
        this.zza = Long.valueOf(l6.longValue() & LocationRequestCompat.PASSIVE_INTERVAL);
        return this;
    }

    public final zznu zzd(Long l6) {
        this.zze = Long.valueOf(l6.longValue() & LocationRequestCompat.PASSIVE_INTERVAL);
        return this;
    }

    public final zznu zze(Long l6) {
        this.zzb = Long.valueOf(l6.longValue() & LocationRequestCompat.PASSIVE_INTERVAL);
        return this;
    }

    public final zznu zzf(Long l6) {
        this.zzf = Long.valueOf(l6.longValue() & LocationRequestCompat.PASSIVE_INTERVAL);
        return this;
    }

    public final zznw zzg() {
        return new zznw(this, null);
    }
}
