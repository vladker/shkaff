package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzev extends zzer {
    final /* synthetic */ zzew zza;
    private final zzxh zzb;

    public zzev(zzew zzewVar, zzxh zzxhVar) {
        this.zza = zzewVar;
        this.zzb = zzxhVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzer
    public final /* bridge */ /* synthetic */ Object zza() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzer
    public final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzer
    public final void zzc(Throwable th) {
        this.zza.zzn(th);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzer
    public final /* synthetic */ void zzd(Object obj) {
        this.zza.zzo((zzet) obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzer
    public final boolean zzf() {
        return this.zza.isDone();
    }
}
