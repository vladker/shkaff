package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbdw extends zbuf implements zbvn {
    private static final zbdw zbb;
    private int zbd;
    private zbco zbe;
    private zbat zbf;
    private zbag zbg;
    private zbez zbh;
    private boolean zbi;
    private zbaw zbj;
    private zbcr zbk;
    private zbcf zbl;

    static {
        zbdw zbdwVar = new zbdw();
        zbb = zbdwVar;
        zbuf.zbD(zbdw.class, zbdwVar);
    }

    private zbdw() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\b\u0000\u0001\u0001\t\b\u0000\u0000\u0000\u0001ဉ\u0001\u0003ဉ\u0005\u0004ဉ\u0000\u0005ဉ\u0002\u0006ဉ\u0003\u0007ဇ\u0004\bဉ\u0006\tဉ\u0007", new Object[]{"zbd", "zbf", "zbj", "zbe", "zbg", "zbh", "zbi", "zbk", "zbl"});
        }
        if (i6 == 3) {
            return new zbdw();
        }
        zbdu zbduVar = null;
        if (i6 == 4) {
            return new zbdv(zbduVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
