package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbcw extends zbuf implements zbvn {
    private static final zbcw zbb;
    private int zbd;
    private int zbe;
    private int zbf = 2;
    private String zbg = "";

    static {
        zbcw zbcwVar = new zbcw();
        zbb = zbcwVar;
        zbuf.zbD(zbcw.class, zbcwVar);
    }

    private zbcw() {
    }

    public static zbct zba() {
        return (zbct) zbb.zbq();
    }

    public static /* synthetic */ void zbd(zbcw zbcwVar, int i5) {
        zbcwVar.zbe = i5 - 1;
        zbcwVar.zbd |= 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003ဈ\u0002", new Object[]{"zbd", "zbe", zbcu.zba, "zbf", "zbg"});
        }
        if (i6 == 3) {
            return new zbcw();
        }
        zbcs zbcsVar = null;
        if (i6 == 4) {
            return new zbct(zbcsVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
