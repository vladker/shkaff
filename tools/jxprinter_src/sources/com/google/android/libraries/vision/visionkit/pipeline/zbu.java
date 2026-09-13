package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbaiv;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbu extends zbuf implements zbvn {
    private static final zbu zbb;
    private int zbd;
    private zbaiv zbe;
    private int zbg;
    private String zbf = "";
    private int zbh = 93;

    static {
        zbu zbuVar = new zbu();
        zbb = zbuVar;
        zbuf.zbD(zbu.class, zbuVar);
    }

    private zbu() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i6 == 3) {
            return new zbu();
        }
        zbs zbsVar = null;
        if (i6 == 4) {
            return new zbt(zbsVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
