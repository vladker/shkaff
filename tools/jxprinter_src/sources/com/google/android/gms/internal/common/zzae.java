package com.google.android.gms.internal.common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzae extends zzz {
    private final zzah zza;

    public zzae(zzah zzahVar, int i5) {
        super(zzahVar.size(), i5);
        this.zza = zzahVar;
    }

    @Override // com.google.android.gms.internal.common.zzz
    public final Object zza(int i5) {
        return this.zza.get(i5);
    }
}
