package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbja extends zbuf implements zbvn {
    private static final zbja zbb;
    private int zbd;
    private zbhl zbg;
    private zbhl zbh;
    private boolean zbi;
    private boolean zbj;
    private boolean zbk;
    private zbxb zbm;
    private String zbe = "";
    private String zbf = "";
    private int zbl = 1;

    static {
        zbja zbjaVar = new zbja();
        zbb = zbjaVar;
        zbuf.zbD(zbja.class, zbjaVar);
    }

    private zbja() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\t\u0000\u0001\u0001\n\t\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0005\u0003ဇ\u0006\u0004ဉ\u0002\u0006ဇ\u0004\u0007င\u0007\bဉ\b\tဉ\u0003\nဈ\u0001", new Object[]{"zbd", "zbe", "zbj", "zbk", "zbg", "zbi", "zbl", "zbm", "zbh", "zbf"});
        }
        if (i6 == 3) {
            return new zbja();
        }
        zbiy zbiyVar = null;
        if (i6 == 4) {
            return new zbiz(zbiyVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
