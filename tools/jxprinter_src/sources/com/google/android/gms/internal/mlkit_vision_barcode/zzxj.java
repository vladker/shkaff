package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzxj implements zzeh {
    final /* synthetic */ zzrc zza;
    final /* synthetic */ float zzb;
    final /* synthetic */ zzxn zzc;
    final /* synthetic */ float zzd;
    final /* synthetic */ zzxk zze;

    public zzxj(zzxk zzxkVar, zzrc zzrcVar, float f6, zzxn zzxnVar, float f7) {
        this.zza = zzrcVar;
        this.zzb = f6;
        this.zzc = zzxnVar;
        this.zzd = f7;
        this.zze = zzxkVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeh
    public final void zza(Throwable th) {
        zzxk.zzf.w("AutoZoom", "Unable to set zoom to " + this.zzd, th);
        this.zze.zzg.set(false);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeh
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Float f6 = (Float) obj;
        if (f6.floatValue() >= 1.0f) {
            zzxk.zzg(this.zze, f6.floatValue());
            this.zze.zzq(this.zza, this.zzb, f6.floatValue(), this.zzc);
        }
        this.zze.zzg.set(false);
    }
}
