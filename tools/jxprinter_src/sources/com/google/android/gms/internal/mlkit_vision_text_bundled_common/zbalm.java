package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbalm extends zbuf implements zbvn {
    private static final zbalm zbb;

    static {
        zbalm zbalmVar = new zbalm();
        zbb = zbalmVar;
        zbuf.zbD(zbalm.class, zbalmVar);
    }

    private zbalm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        zbalk zbalkVar = null;
        if (i6 == 2) {
            return zbuf.zbA(zbb, TarConstants.VERSION_ANT, null);
        }
        if (i6 == 3) {
            return new zbalm();
        }
        if (i6 == 4) {
            return new zball(zbalkVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
