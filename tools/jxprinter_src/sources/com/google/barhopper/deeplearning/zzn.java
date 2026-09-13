package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzn extends zzeh implements zzfn {
    private static final zzn zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzn zznVar = new zzn();
        zzb = zznVar;
        zzeh.zzV(zzn.class, zznVar);
    }

    private zzn() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"zze", "zzd", zzt.class, zzz.class, zzw.class});
        }
        if (i6 == 3) {
            return new zzn();
        }
        zzl zzlVar = null;
        if (i6 == 4) {
            return new zzm(zzlVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zzb;
    }
}
