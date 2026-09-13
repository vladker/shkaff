package com.google.android.gms.internal.play_billing;

import com.google.android.gms.auth.api.accounttransfer.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzhl {
    private final zzhk zza;

    private zzhl(zzjg zzjgVar, Object obj, zzjg zzjgVar2, Object obj2) {
        this.zza = new zzhk(zzjgVar, "", zzjgVar2, obj2);
    }

    public static int zzb(zzhk zzhkVar, Object obj, Object obj2) {
        return zzgh.zza(zzhkVar.zza, 1, obj) + zzgh.zza(zzhkVar.zzc, 2, obj2);
    }

    public static zzhl zzd(zzjg zzjgVar, Object obj, zzjg zzjgVar2, Object obj2) {
        return new zzhl(zzjgVar, "", zzjgVar2, obj2);
    }

    public static void zze(zzfx zzfxVar, zzhk zzhkVar, Object obj, Object obj2) {
        zzgh.zzi(zzfxVar, zzhkVar.zza, 1, obj);
        zzgh.zzi(zzfxVar, zzhkVar.zzc, 2, obj2);
    }

    public final int zza(int i5, Object obj, Object obj2) {
        zzhk zzhkVar = this.zza;
        int iZzy = zzfx.zzy(i5 << 3);
        int iZzb = zzb(zzhkVar, obj, obj2);
        return a.C(iZzb, iZzb, iZzy);
    }

    public final zzhk zzc() {
        return this.zza;
    }
}
