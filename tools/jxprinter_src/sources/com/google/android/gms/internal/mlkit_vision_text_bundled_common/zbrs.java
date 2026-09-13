package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbrs extends zbuf implements zbvn {
    private static final zbrs zbb;
    private int zbA;
    private float zbB;
    private float zbD;
    private int zbE;
    private int zbd;
    private zbpw zbf;
    private zbpw zbg;
    private float zbi;
    private boolean zbl;
    private boolean zbn;
    private boolean zbq;
    private boolean zbr;
    private int zbs;
    private int zbt;
    private int zbu;
    private int zbv;
    private int zbw;
    private int zbx;
    private float zbz;
    private byte zbF = 2;
    private zbun zbe = zbuf.zby();
    private String zbh = "";
    private zbun zbj = zbuf.zby();
    private zbun zbk = zbuf.zby();
    private String zbm = "";
    private zbun zbo = zbuf.zby();
    private boolean zbp = true;
    private String zby = "";
    private int zbC = 1;

    static {
        zbrs zbrsVar = new zbrs();
        zbb = zbrsVar;
        zbuf.zbD(zbrs.class, zbrsVar);
    }

    private zbrs() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbF);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u001b\u0000\u0001\u0001\u001b\u001b\u0000\u0004\u0004\u0001Л\u0002ᔉ\u0000\u0003ᐉ\u0001\u0004ဈ\u0002\u0005ခ\u0003\u0006\u001b\u0007ဇ\u0004\bဈ\u0005\tЛ\nဇ\u0006\u000b\u001b\fဇ\u0007\rဇ\b\u000eဇ\t\u000fင\u000b\u0010င\f\u0011င\r\u0012င\u000e\u0013င\u000f\u0014ဈ\u0010\u0015ခ\u0011\u0016᠌\u0012\u0017᠌\u0014\u0018ခ\u0013\u0019ခ\u0015\u001aင\u0016\u001bင\n", new Object[]{"zbd", "zbe", zbre.class, "zbf", "zbg", "zbh", "zbi", "zbk", zbpy.class, "zbl", "zbm", "zbj", zbqa.class, "zbn", "zbo", zbrc.class, "zbp", "zbq", "zbr", "zbt", "zbu", "zbv", "zbw", "zbx", "zby", "zbz", "zbA", zbabe.zba(), "zbC", zbqr.zba, "zbB", "zbD", "zbE", "zbs"});
        }
        if (i6 == 3) {
            return new zbrs();
        }
        zbpu zbpuVar = null;
        if (i6 == 4) {
            return new zbrr(zbpuVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbF = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
