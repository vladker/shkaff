package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzby extends zzbs {
    private final zzca zza;

    public zzby(zzca zzcaVar, int i5) {
        super(zzcaVar.size(), i5);
        this.zza = zzcaVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbs
    public final Object zza(int i5) {
        return this.zza.get(i5);
    }
}
