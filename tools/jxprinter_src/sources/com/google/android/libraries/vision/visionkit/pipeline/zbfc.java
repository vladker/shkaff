package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbfc extends zbuf implements zbvn {
    private static final zbfc zbb;
    private int zbd;
    private int zbe = 1;
    private boolean zbf;

    static {
        zbfc zbfcVar = new zbfc();
        zbb = zbfcVar;
        zbuf.zbD(zbfc.class, zbfcVar);
    }

    private zbfc() {
    }

    public static zbfb zba() {
        return (zbfb) zbb.zbq();
    }

    public static /* synthetic */ void zbd(zbfc zbfcVar, int i5) {
        zbfcVar.zbe = 1;
        zbfcVar.zbd = 1 | zbfcVar.zbd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001", new Object[]{"zbd", "zbe", zbk.zba, "zbf"});
        }
        if (i6 == 3) {
            return new zbfc();
        }
        zbfa zbfaVar = null;
        if (i6 == 4) {
            return new zbfb(zbfaVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
