package com.google.android.libraries.vision.visionkit.pipeline;

import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbix;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbun;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbvn;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbaa extends zbuf implements zbvn {
    private static final zbaa zbb;
    private int zbd;
    private int zbf;
    private zbun zbe = zbuf.zby();
    private zbun zbg = zbuf.zby();

    static {
        zbaa zbaaVar = new zbaa();
        zbb = zbaaVar;
        zbuf.zbD(zbaa.class, zbaaVar);
    }

    private zbaa() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002င\u0000\u0003\u001a", new Object[]{"zbd", "zbe", zbix.class, "zbf", "zbg"});
        }
        if (i6 == 3) {
            return new zbaa();
        }
        zby zbyVar = null;
        if (i6 == 4) {
            return new zbz(zbyVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
