package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbqy extends zbuf implements zbvn {
    private static final zbqy zbb;
    private int zbd;
    private float zbf;
    private float zbg;
    private float zbh;
    private float zbi;
    private float zbk;
    private float zbl;
    private boolean zbm;
    private int zbe = 1;
    private float zbj = 1.0f;

    static {
        zbqy zbqyVar = new zbqy();
        zbb = zbqyVar;
        zbuf.zbD(zbqy.class, zbqyVar);
    }

    private zbqy() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001င\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007ခ\u0006\bခ\u0007\tဇ\b", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm"});
        }
        if (i6 == 3) {
            return new zbqy();
        }
        zbpu zbpuVar = null;
        if (i6 == 4) {
            return new zbqx(zbpuVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
