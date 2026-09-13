package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbdy extends zbuf implements zbvn {
    private static final zbdy zbb;
    private int zbd;
    private zbdj zbe;
    private zbdr zbf;
    private zbdn zbg;
    private zbdv zbh;

    static {
        zbdy zbdyVar = new zbdy();
        zbb = zbdyVar;
        zbuf.zbD(zbdy.class, zbdyVar);
    }

    private zbdy() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i6 == 3) {
            return new zbdy();
        }
        zbdw zbdwVar = null;
        if (i6 == 4) {
            return new zbdx(zbdwVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
