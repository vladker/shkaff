package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbbk extends zbuf implements zbvn {
    private static final zbbk zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg;
    private boolean zbh;
    private int zbi;
    private boolean zbj;
    private int zbk;

    static {
        zbbk zbbkVar = new zbbk();
        zbb = zbbkVar;
        zbuf.zbD(zbbk.class, zbbkVar);
    }

    private zbbk() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004ဇ\u0003\u0005င\u0004\u0006ဇ\u0005\u0007င\u0006", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk"});
        }
        if (i6 == 3) {
            return new zbbk();
        }
        zbbi zbbiVar = null;
        if (i6 == 4) {
            return new zbbj(zbbiVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
