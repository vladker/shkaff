package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbeo extends zbuf implements zbvn {
    private static final zbeo zbb;
    private int zbd = 0;
    private Object zbe;

    static {
        zbeo zbeoVar = new zbeo();
        zbb = zbeoVar;
        zbuf.zbD(zbeo.class, zbeoVar);
    }

    private zbeo() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000", new Object[]{"zbe", "zbd", zbbc.class, zbbw.class});
        }
        if (i6 == 3) {
            return new zbeo();
        }
        zbem zbemVar = null;
        if (i6 == 4) {
            return new zben(zbemVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
