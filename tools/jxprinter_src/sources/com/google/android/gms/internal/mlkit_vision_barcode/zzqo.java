package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzqo {
    private Long zza;
    private zzrb zzb;
    private Boolean zzc;
    private Boolean zzd;
    private Boolean zze;

    public final zzqo zza(Boolean bool) {
        this.zzd = bool;
        return this;
    }

    public final zzqo zzb(Boolean bool) {
        this.zze = bool;
        return this;
    }

    public final zzqo zzc(Long l6) {
        this.zza = Long.valueOf(l6.longValue() & LocationRequestCompat.PASSIVE_INTERVAL);
        return this;
    }

    public final zzqo zzd(zzrb zzrbVar) {
        this.zzb = zzrbVar;
        return this;
    }

    public final zzqo zze(Boolean bool) {
        this.zzc = bool;
        return this;
    }

    public final zzqq zzf() {
        return new zzqq(this, null);
    }
}
