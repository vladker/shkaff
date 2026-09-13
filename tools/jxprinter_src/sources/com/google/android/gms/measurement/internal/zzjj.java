package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public enum zzjj {
    STORAGE(zzjk.AD_STORAGE, zzjk.ANALYTICS_STORAGE),
    DMA(zzjk.AD_USER_DATA);

    private final zzjk[] zzc;

    zzjj(zzjk... zzjkVarArr) {
        this.zzc = zzjkVarArr;
    }

    public final zzjk[] zza() {
        return this.zzc;
    }

    public final /* synthetic */ zzjk[] zzb() {
        return this.zzc;
    }
}
