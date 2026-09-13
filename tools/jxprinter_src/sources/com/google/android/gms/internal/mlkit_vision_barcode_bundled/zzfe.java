package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfe implements zzgf {
    private static final zzfk zza = new zzfc();
    private final zzfk zzb;

    public zzfe() {
        zzea zzeaVarZza = zzea.zza();
        int i5 = zzfu.zza;
        zzfd zzfdVar = new zzfd(zzeaVarZza, zza);
        byte[] bArr = zzep.zzb;
        this.zzb = zzfdVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgf
    public final zzge zza(Class cls) {
        int i5 = zzgg.zza;
        if (!zzeh.class.isAssignableFrom(cls)) {
            int i6 = zzfu.zza;
        }
        zzfj zzfjVarZzb = this.zzb.zzb(cls);
        if (zzfjVarZzb.zzb()) {
            int i7 = zzfu.zza;
            return zzfq.zzc(zzgg.zzm(), zzdv.zza(), zzfjVarZzb.zza());
        }
        int i8 = zzfu.zza;
        return zzfp.zzl(cls, zzfjVarZzb, zzft.zza(), zzfa.zza(), zzgg.zzm(), zzfjVarZzb.zzc() + (-1) != 1 ? zzdv.zza() : null, zzfi.zza());
    }
}
