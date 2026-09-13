package com.google.barhopper.deeplearning;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzz extends zzeh implements zzfn {
    private static final zzz zzb;

    static {
        zzz zzzVar = new zzz();
        zzb = zzzVar;
        zzeh.zzV(zzz.class, zzzVar);
    }

    private zzz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    public final Object zzg(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        zzx zzxVar = null;
        if (i6 == 2) {
            return zzeh.zzS(zzb, "\u0001\u0000", null);
        }
        if (i6 == 3) {
            return new zzz();
        }
        if (i6 == 4) {
            return new zzy(zzxVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zzb;
    }
}
