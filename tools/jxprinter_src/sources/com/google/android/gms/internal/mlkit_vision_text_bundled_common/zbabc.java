package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbabc extends zbuf implements zbvn {
    private static final zbabc zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg;
    private int zbh;
    private int zbi;
    private zbun zbj = zbuf.zby();
    private zbun zbk = zbuf.zby();

    static {
        zbabc zbabcVar = new zbabc();
        zbb = zbabcVar;
        zbuf.zbD(zbabc.class, zbabcVar);
    }

    private zbabc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006\u001b\u0007\u001b", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", zbabb.class, "zbk", zbabb.class});
        }
        if (i6 == 3) {
            return new zbabc();
        }
        zbaad zbaadVar = null;
        if (i6 == 4) {
            return new zbaaz(zbaadVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
