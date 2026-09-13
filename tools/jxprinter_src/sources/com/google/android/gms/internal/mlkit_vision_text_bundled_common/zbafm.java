package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbafm extends zbuf implements zbvn {
    private static final zbafm zbb;
    private int zbd;
    private String zbe = "";
    private zbtc zbf;
    private zbafo zbg;
    private String zbh;
    private zbtc zbi;
    private zbafo zbj;
    private String zbk;
    private zbtc zbl;
    private zbafo zbm;
    private String zbn;
    private String zbo;
    private zbafo zbp;

    static {
        zbafm zbafmVar = new zbafm();
        zbb = zbafmVar;
        zbuf.zbD(zbafm.class, zbafmVar);
    }

    private zbafm() {
        zbtc zbtcVar = zbtc.zbb;
        this.zbf = zbtcVar;
        this.zbh = "";
        this.zbi = zbtcVar;
        this.zbk = "";
        this.zbl = zbtcVar;
        this.zbn = "";
        this.zbo = "";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001\u0003ည\u0004\u0004ဈ\u0003\u0005ဈ\u0006\u0006ည\u0007\u0007ဈ\t\bဈ\n\tဉ\u0002\nဉ\u0005\u000bဉ\b\fဉ\u000b", new Object[]{"zbd", "zbe", "zbf", "zbi", "zbh", "zbk", "zbl", "zbn", "zbo", "zbg", "zbj", "zbm", "zbp"});
        }
        if (i6 == 3) {
            return new zbafm();
        }
        zbafj zbafjVar = null;
        if (i6 == 4) {
            return new zbafl(zbafjVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
