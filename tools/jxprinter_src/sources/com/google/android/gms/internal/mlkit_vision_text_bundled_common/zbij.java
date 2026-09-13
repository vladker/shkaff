package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbij extends zbuf implements zbvn {
    private static final zbij zbb;
    private int zbd;
    private zbih zbf;
    private zbhl zbg;
    private zbalp zbh;
    private zbxb zbk;
    private String zbe = "";
    private String zbi = "en";
    private int zbj = 1;
    private int zbl = -1;
    private String zbm = "";

    static {
        zbij zbijVar = new zbij();
        zbb = zbijVar;
        zbuf.zbD(zbij.class, zbijVar);
    }

    private zbij() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003᠌\u0005\u0004ဉ\u0006\u0005ဉ\u0002\u0006ဈ\u0004\u0007င\u0007\bဉ\u0003\tဈ\b", new Object[]{"zbd", "zbe", "zbf", "zbj", zbii.zba, "zbk", "zbg", "zbi", "zbl", "zbh", "zbm"});
        }
        if (i6 == 3) {
            return new zbij();
        }
        zbie zbieVar = null;
        if (i6 == 4) {
            return new zbif(zbieVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
