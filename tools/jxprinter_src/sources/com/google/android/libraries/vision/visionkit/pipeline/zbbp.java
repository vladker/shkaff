package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbbp extends zbuf implements zbvn {
    private static final zbbp zbb;
    private int zbd;
    private int zbe;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbdg zbf;
    private zbu zbg;

    static {
        zbbp zbbpVar = new zbbp();
        zbb = zbbpVar;
        zbuf.zbD(zbbp.class, zbbpVar);
    }

    private zbbp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zbd", "zbe", zbbo.zba, "zbf", "zbg"});
        }
        if (i6 == 3) {
            return new zbbp();
        }
        zbbm zbbmVar = null;
        if (i6 == 4) {
            return new zbbn(zbbmVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
