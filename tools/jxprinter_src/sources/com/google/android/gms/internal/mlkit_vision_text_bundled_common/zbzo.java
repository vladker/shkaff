package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbzo extends zbuf implements zbvn {
    private static final zbzo zbb;
    private int zbd;
    private int zbe;
    private zbze zbf;
    private zbyj zbg;
    private zbxj zbh;
    private zbyu zbi;
    private zbyd zbj;
    private zbxo zbk;
    private zbzr zbl;
    private zbxr zbm;
    private zbyp zbn;
    private zbys zbo;
    private zbys zbp;
    private zbys zbq;
    private boolean zbr;
    private zbyg zbs;
    private int zbt = -1;
    private boolean zbu;
    private zbzk zbv;
    private zbxl zbw;

    static {
        zbzo zbzoVar = new zbzo();
        zbb = zbzoVar;
        zbuf.zbD(zbzo.class, zbzoVar);
    }

    private zbzo() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\n\u0007ဉ\u000b\bဉ\f\tဇ\r\nဉ\u0005\u000bဉ\u000e\fဉ\u0006\rဉ\u0007\u000eင\u000f\u000fဉ\b\u0010ဇ\u0010\u0011ဉ\u0011\u0012ဉ\t\u0013ဉ\u0012", new Object[]{"zbd", "zbe", zbxs.zba, "zbf", "zbg", "zbh", "zbi", "zbo", "zbp", "zbq", "zbr", "zbj", "zbs", "zbk", "zbl", "zbt", "zbm", "zbu", "zbv", "zbn", "zbw"});
        }
        if (i6 == 3) {
            return new zbzo();
        }
        zbwz zbwzVar = null;
        if (i6 == 4) {
            return new zbzn(zbwzVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
