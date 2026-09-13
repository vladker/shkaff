package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzem;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzc extends zzeh implements zzfn {
    private static final zzc zzb;
    private int zzd;
    private zzem zze = zzeh.zzM();
    private zzem zzf = zzeh.zzM();
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    static {
        zzc zzcVar = new zzc();
        zzb = zzcVar;
        zzeh.zzV(zzc.class, zzcVar);
    }

    private zzc() {
    }

    public static zzb zza() {
        return (zzb) zzb.zzG();
    }

    public static /* synthetic */ void zzc(zzc zzcVar, int i5) {
        zzcVar.zzd |= 2;
        zzcVar.zzh = i5;
    }

    public static /* synthetic */ void zzd(zzc zzcVar, float f6) {
        zzem zzemVar = zzcVar.zze;
        if (!zzemVar.zzc()) {
            zzcVar.zze = zzeh.zzN(zzemVar);
        }
        zzcVar.zze.zzh(f6);
    }

    public static /* synthetic */ void zze(zzc zzcVar, float f6) {
        zzem zzemVar = zzcVar.zzf;
        if (!zzemVar.zzc()) {
            zzcVar.zzf = zzeh.zzN(zzemVar);
        }
        zzcVar.zzf.zzh(f6);
    }

    public static /* synthetic */ void zzf(zzc zzcVar, int i5) {
        zzcVar.zzd |= 1;
        zzcVar.zzg = i5;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001\u0013\u0002\u0013\u0003ဋ\u0000\u0004ဋ\u0001\u0005ဋ\u0002\u0006ဋ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i6 == 3) {
            return new zzc();
        }
        zza zzaVar = null;
        if (i6 == 4) {
            return new zzb(zzaVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zzb;
    }
}
