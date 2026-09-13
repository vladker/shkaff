package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbqw extends zbuf implements zbvn {
    private static final zbqw zbb;
    private int zbd;
    private boolean zbe;
    private boolean zbf;
    private boolean zbg;
    private boolean zbh = true;
    private boolean zbi;
    private boolean zbj;
    private boolean zbk;
    private float zbl;
    private boolean zbm;
    private boolean zbn;
    private boolean zbo;
    private boolean zbp;
    private int zbq;
    private boolean zbr;
    private zbqo zbs;
    private zbra zbt;

    static {
        zbqw zbqwVar = new zbqw();
        zbb = zbqwVar;
        zbuf.zbD(zbqw.class, zbqwVar);
    }

    private zbqw() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0010\u0000\u0001\u0001\u0010\u0010\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0004\u0004ဇ\u0005\u0005ဇ\u0006\u0006ဇ\u0002\u0007ဇ\u0003\bခ\u0007\tဇ\b\nဇ\t\u000bဇ\n\fဇ\u000b\rင\f\u000eဇ\r\u000fဉ\u000e\u0010ဉ\u000f", new Object[]{"zbd", "zbe", "zbf", "zbi", "zbj", "zbk", "zbg", "zbh", "zbl", "zbm", "zbn", "zbo", "zbp", "zbq", "zbr", "zbs", "zbt"});
        }
        if (i6 == 3) {
            return new zbqw();
        }
        zbpu zbpuVar = null;
        if (i6 == 4) {
            return new zbqv(zbpuVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
