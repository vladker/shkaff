package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbbt extends zbuf implements zbvn {
    private static final zbbt zbb;
    private int zbd;
    private int zbe = -1;
    private float zbf = 0.3f;
    private int zbg = 5;
    private float zbh = 0.5f;
    private int zbi = 1;
    private boolean zbj = true;
    private float zbk = 0.85f;
    private boolean zbl = true;
    private float zbm;

    static {
        zbbt zbbtVar = new zbbt();
        zbb = zbbtVar;
        zbuf.zbD(zbbt.class, zbbtVar);
    }

    private zbbt() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0004\t\u0000\u0001\u0001\u0011\t\u0000\u0000\u0000\u0001င\u0000\u0005ခ\u0001\u0006င\u0002\u0007ခ\u0003\f᠌\u0004\u000eဇ\u0005\u000fခ\u0006\u0010ဇ\u0007\u0011ခ\b", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", zbbs.zba, "zbj", "zbk", "zbl", "zbm"});
        }
        if (i6 == 3) {
            return new zbbt();
        }
        zbbq zbbqVar = null;
        if (i6 == 4) {
            return new zbbr(zbbqVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
