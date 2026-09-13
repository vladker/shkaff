package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzad extends zzv {
    private final zzaf zza;

    public zzad(zzaf zzafVar, int i5) {
        super(zzafVar.size(), i5);
        this.zza = zzafVar;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzv
    public final Object zza(int i5) {
        return this.zza.get(i5);
    }
}
