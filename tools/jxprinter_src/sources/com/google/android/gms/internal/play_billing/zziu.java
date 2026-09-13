package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zziu extends zziw {
    public zziu(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.play_billing.zziw
    public final double zza(Object obj, long j6) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j6));
    }

    @Override // com.google.android.gms.internal.play_billing.zziw
    public final float zzb(Object obj, long j6) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j6));
    }

    @Override // com.google.android.gms.internal.play_billing.zziw
    public final void zzc(Object obj, long j6, boolean z6) {
        if (zzix.zza) {
            zzix.zzi(obj, j6, z6);
        } else {
            zzix.zzj(obj, j6, z6);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zziw
    public final void zzd(Object obj, long j6, double d) {
        this.zza.putLong(obj, j6, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.play_billing.zziw
    public final void zze(Object obj, long j6, float f6) {
        this.zza.putInt(obj, j6, Float.floatToIntBits(f6));
    }

    @Override // com.google.android.gms.internal.play_billing.zziw
    public final boolean zzf(Object obj, long j6) {
        return zzix.zza ? zzix.zzq(obj, j6) : zzix.zzr(obj, j6);
    }
}
