package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbahr extends zbuf implements zbvn {
    private static final zbahr zbb;
    private int zbd = 0;
    private Object zbe;
    private float zbf;

    static {
        zbahr zbahrVar = new zbahr();
        zbb = zbahrVar;
        zbuf.zbD(zbahr.class, zbahrVar);
    }

    private zbahr() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u00017\u0000\u00024\u0000\u0003Ȼ\u0000\u0004\u0001", new Object[]{"zbe", "zbd", "zbf"});
        }
        if (i6 == 3) {
            return new zbahr();
        }
        zbagx zbagxVar = null;
        if (i6 == 4) {
            return new zbahq(zbagxVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
