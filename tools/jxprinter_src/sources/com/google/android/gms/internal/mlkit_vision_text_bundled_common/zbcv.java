package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbcv extends zbuf implements zbvn {
    private static final zbcv zbb;
    private int zbd;
    private zbtc zbe = zbtc.zbb;
    private float zbf;
    private zbgw zbg;
    private long zbh;

    static {
        zbcv zbcvVar = new zbcv();
        zbb = zbcvVar;
        zbuf.zbD(zbcv.class, zbcvVar);
    }

    private zbcv() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ခ\u0001\u0003ဉ\u0002\u0004ဂ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i6 == 3) {
            return new zbcv();
        }
        zbcs zbcsVar = null;
        if (i6 == 4) {
            return new zbcu(zbcsVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
