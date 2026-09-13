package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbxo extends zbuf implements zbvn {
    private static final zbxo zbb;
    private int zbd;
    private String zbe = "";
    private int zbf = 1;
    private boolean zbg;
    private int zbh;

    static {
        zbxo zbxoVar = new zbxo();
        zbb = zbxoVar;
        zbuf.zbD(zbxo.class, zbxoVar);
    }

    private zbxo() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zbd", "zbe", "zbf", zbxn.zba, "zbg", "zbh"});
        }
        if (i6 == 3) {
            return new zbxo();
        }
        zbwz zbwzVar = null;
        if (i6 == 4) {
            return new zbxm(zbwzVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
