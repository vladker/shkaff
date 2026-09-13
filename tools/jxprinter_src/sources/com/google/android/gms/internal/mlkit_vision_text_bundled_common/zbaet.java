package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbaet extends zbuf implements zbvn {
    private static final zbaet zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg;
    private int zbh;
    private float zbi;
    private float zbj;
    private zbuk zbk = zbuf.zbv();
    private zbul zbl = zbuf.zbw();
    private zbul zbm = zbuf.zbw();

    static {
        zbaet zbaetVar = new zbaet();
        zbb = zbaetVar;
        zbuf.zbD(zbaet.class, zbaetVar);
    }

    private zbaet() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0003\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005ခ\u0004\u0006ခ\u0005\u0007$\b'\t'", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm"});
        }
        if (i6 == 3) {
            return new zbaet();
        }
        zbaer zbaerVar = null;
        if (i6 == 4) {
            return new zbaes(zbaerVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
