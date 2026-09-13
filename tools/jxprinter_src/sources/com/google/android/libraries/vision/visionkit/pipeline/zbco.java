package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbco extends zbuf implements zbvn {
    private static final zbco zbb;
    private zbun zbd = zbuf.zby();

    static {
        zbco zbcoVar = new zbco();
        zbb = zbcoVar;
        zbuf.zbD(zbco.class, zbcoVar);
    }

    private zbco() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zbd", zbcn.class});
        }
        if (i6 == 3) {
            return new zbco();
        }
        zbcg zbcgVar = null;
        if (i6 == 4) {
            return new zbch(zbcgVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
