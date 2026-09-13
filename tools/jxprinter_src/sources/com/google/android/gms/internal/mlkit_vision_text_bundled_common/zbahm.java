package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbahm extends zbuf implements zbvn {
    private static final zbahm zbb;
    private int zbd;
    private Object zbf;
    private zbahf zbg;
    private int zbe = 0;
    private zbvg zbm = zbvg.zba();
    private String zbh = "";
    private String zbi = "";
    private String zbj = "";
    private zbun zbk = zbuf.zby();
    private zbun zbl = zbuf.zby();
    private zbun zbn = zbuf.zby();

    static {
        zbahm zbahmVar = new zbahm();
        zbb = zbahmVar;
        zbuf.zbD(zbahm.class, zbahmVar);
    }

    private zbahm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0000\t\u0001\u0001\u0001\u000b\t\u0001\u0003\u0000\u0001ဉ\u0000\u0002Ȉ\u0003\u001b\u0004\u001b\u0005<\u0000\b2\t\u001b\nȈ\u000bȈ", new Object[]{"zbf", "zbe", "zbd", "zbg", "zbh", "zbk", zbahj.class, "zbl", zbahl.class, zbahd.class, "zbm", zbahg.zba, "zbn", zbsp.class, "zbi", "zbj"});
        }
        if (i6 == 3) {
            return new zbahm();
        }
        zbagx zbagxVar = null;
        if (i6 == 4) {
            return new zbahh(zbagxVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
