package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbro extends zbuf implements zbvn {
    private static final zbro zbb;
    private int zbd;
    private int zbf;
    private int zbg;
    private zbrq zbj;
    private zbqw zbl;
    private zbqt zbm;
    private byte zbo = 2;
    private zbtc zbe = zbtc.zbb;
    private String zbh = "";
    private zbun zbi = zbuf.zby();
    private zbun zbk = zbuf.zby();
    private zbun zbn = zbuf.zby();

    static {
        zbro zbroVar = new zbro();
        zbb = zbroVar;
        zbuf.zbD(zbro.class, zbroVar);
    }

    private zbro() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbo);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0003\u0004\u0001ᔊ\u0000\u0002ဈ\u0003\u0003Л\u0004ဉ\u0004\u0005Л\u0006ဉ\u0005\u0007ဉ\u0006\bЛ\tင\u0001\nင\u0002", new Object[]{"zbd", "zbe", "zbh", "zbi", zbqq.class, "zbj", "zbk", zbrm.class, "zbl", "zbm", "zbn", zbrk.class, "zbf", "zbg"});
        }
        if (i6 == 3) {
            return new zbro();
        }
        zbpu zbpuVar = null;
        if (i6 == 4) {
            return new zbrn(zbpuVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbo = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
