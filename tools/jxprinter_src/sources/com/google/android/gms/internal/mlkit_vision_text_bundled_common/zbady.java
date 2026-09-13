package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbady extends zbuf implements zbvn {
    private static final zbady zbb;
    private int zbd;
    private Object zbf;
    private int zbe = 0;
    private String zbg = "";

    static {
        zbady zbadyVar = new zbady();
        zbb = zbadyVar;
        zbuf.zbD(zbady.class, zbadyVar);
    }

    private zbady() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000", new Object[]{"zbf", "zbe", "zbd", "zbg", zbadp.class, zbadr.class, zbaee.class, zbadv.class});
        }
        if (i6 == 3) {
            return new zbady();
        }
        zbadn zbadnVar = null;
        if (i6 == 4) {
            return new zbadx(zbadnVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
