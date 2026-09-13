package com.google.android.odml.image;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zze implements zzg {
    private final Bitmap zza;
    private final ImageProperties zzb;

    public zze(Bitmap bitmap) {
        this.zza = bitmap;
        zzb zzbVar = new zzb();
        int i5 = zzd.zza[bitmap.getConfig().ordinal()];
        zzbVar.zza(i5 != 1 ? i5 != 2 ? 0 : 1 : 8);
        zzbVar.zzb(1);
        this.zzb = zzbVar.zzc();
    }

    public final Bitmap zza() {
        return this.zza;
    }

    @Override // com.google.android.odml.image.zzg
    public final ImageProperties zzb() {
        return this.zzb;
    }

    @Override // com.google.android.odml.image.zzg
    public final void zzc() {
        this.zza.recycle();
    }
}
