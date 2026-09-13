package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbbi extends zbuf implements zbvn {
    private static final zbbi zbb;
    private int zbd;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbee zbe;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbek zbf;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbeh zbg;

    static {
        zbbi zbbiVar = new zbbi();
        zbb = zbbiVar;
        zbuf.zbD(zbbi.class, zbbiVar);
    }

    private zbbi() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0004\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0004ဉ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i6 == 3) {
            return new zbbi();
        }
        zbbg zbbgVar = null;
        if (i6 == 4) {
            return new zbbh(zbbgVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
