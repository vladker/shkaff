package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbahy extends zbuf implements zbvn {
    private static final zbahy zbb;
    private int zbd;
    private long zbh;
    private zbahr zbl;
    private zbahf zbm;
    private int zbo;
    private zbun zbe = zbuf.zby();
    private zbun zbf = zbuf.zby();
    private zbun zbg = zbuf.zby();
    private String zbi = "";
    private zbun zbj = zbuf.zby();
    private String zbk = "";
    private zbum zbn = zbuf.zbx();

    static {
        zbahy zbahyVar = new zbahy();
        zbb = zbahyVar;
        zbuf.zbD(zbahy.class, zbahyVar);
    }

    private zbahy() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0000\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0005\u0000\u0001\u001b\u0002\u001b\u0003\u0002\u0004Ȉ\u0005Ț\u0006Ȉ\u0007ဉ\u0001\b%\t\u0004\n\u001b\u000bဉ\u0000", new Object[]{"zbd", "zbe", zbaht.class, "zbf", zbahv.class, "zbh", "zbi", "zbj", "zbk", "zbm", "zbn", "zbo", "zbg", zbahp.class, "zbl"});
        }
        if (i6 == 3) {
            return new zbahy();
        }
        zbagx zbagxVar = null;
        if (i6 == 4) {
            return new zbahn(zbagxVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
