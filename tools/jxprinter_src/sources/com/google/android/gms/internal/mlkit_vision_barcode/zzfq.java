package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfq {
    private zzft zza;
    private Integer zzb;
    private zzqd zzc;

    public final zzfq zza(Integer num) {
        this.zzb = Integer.valueOf(num.intValue() & Integer.MAX_VALUE);
        return this;
    }

    public final zzfq zzb(zzqd zzqdVar) {
        this.zzc = zzqdVar;
        return this;
    }

    public final zzfq zzc(zzft zzftVar) {
        this.zza = zzftVar;
        return this;
    }

    public final zzfv zze() {
        return new zzfv(this, null);
    }
}
