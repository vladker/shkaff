package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbyd extends zbuf implements zbvn {
    private static final zbyd zbb;
    private int zbd;
    private int zbe;
    private zbxv zbh;
    private int zbj;
    private int zbk;
    private int zbn;
    private zbun zbf = zbuf.zby();
    private int zbg = -1;
    private String zbi = "";
    private zbul zbl = zbuf.zbw();
    private String zbm = "";

    static {
        zbyd zbydVar = new zbyd();
        zbb = zbydVar;
        zbuf.zbD(zbyd.class, zbydVar);
    }

    private zbyd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0002\u0000\u0001᠌\u0000\u0002\u001b\u0003င\u0001\u0004ဉ\u0002\u0005ဈ\u0003\u0006᠌\u0004\u0007᠌\u0005\b'\tဈ\u0006\n᠌\u0007", new Object[]{"zbd", "zbe", zbxy.zba, "zbf", zbxx.class, "zbg", "zbh", "zbi", "zbj", zbya.zba, "zbk", zbyb.zba, "zbl", "zbm", "zbn", zbyc.zba});
        }
        if (i6 == 3) {
            return new zbyd();
        }
        zbwz zbwzVar = null;
        if (i6 == 4) {
            return new zbxz(zbwzVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
