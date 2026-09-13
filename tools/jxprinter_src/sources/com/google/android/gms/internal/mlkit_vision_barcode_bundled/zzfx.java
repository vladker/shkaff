package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfx extends zzcz {
    final zzgb zza;
    zzdb zzb = zzb();
    final /* synthetic */ zzgd zzc;

    public zzfx(zzgd zzgdVar) {
        this.zzc = zzgdVar;
        this.zza = new zzgb(zzgdVar, null);
    }

    private final zzdb zzb() {
        zzgb zzgbVar = this.zza;
        if (zzgbVar.hasNext()) {
            return zzgbVar.next().iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdb
    public final byte zza() {
        zzdb zzdbVar = this.zzb;
        if (zzdbVar == null) {
            throw new NoSuchElementException();
        }
        byte bZza = zzdbVar.zza();
        if (!this.zzb.hasNext()) {
            this.zzb = zzb();
        }
        return bZza;
    }
}
