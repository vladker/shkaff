package com.google.android.gms.internal.mlkit_vision_text_common;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzoh {
    private Long zza;
    private zzou zzb;
    private Boolean zzc;
    private Boolean zzd;
    private Boolean zze;

    public final zzoh zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzoh zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzoh zzc(Long l6) {
        this.zza = Long.valueOf(l6.longValue() & LocationRequestCompat.PASSIVE_INTERVAL);
        return this;
    }

    public final zzoh zzd(zzou zzouVar) {
        this.zzb = zzouVar;
        return this;
    }

    public final zzoh zze(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzoj zzf() {
        return new zzoj(this, null);
    }
}
