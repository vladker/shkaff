package com.google.barhopper.deeplearning;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class BarhopperV3Options extends zzeh<BarhopperV3Options, zzk> implements zzfn {
    private static final BarhopperV3Options zzb;
    private int zzd;
    private zzi zze;
    private zzac zzf;
    private zzq zzg;

    static {
        BarhopperV3Options barhopperV3Options = new BarhopperV3Options();
        zzb = barhopperV3Options;
        zzeh.zzV(BarhopperV3Options.class, barhopperV3Options);
    }

    private BarhopperV3Options() {
    }

    public static zzk zza() {
        return (zzk) zzb.zzG();
    }

    public static /* synthetic */ void zzc(BarhopperV3Options barhopperV3Options, zzi zziVar) {
        zziVar.getClass();
        barhopperV3Options.zze = zziVar;
        barhopperV3Options.zzd |= 1;
    }

    public static /* synthetic */ void zzd(BarhopperV3Options barhopperV3Options, zzac zzacVar) {
        zzacVar.getClass();
        barhopperV3Options.zzf = zzacVar;
        barhopperV3Options.zzd |= 2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    @NonNull
    public final Object zzg(int i5, @NonNull Object obj, @NonNull Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i6 == 3) {
            return new BarhopperV3Options();
        }
        zzj zzjVar = null;
        if (i6 == 4) {
            return new zzk(zzjVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zzb;
    }
}
