package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbqm extends zbuf implements zbvn {
    private static final zbqm zbb;
    private int zbd;
    private zbtc zbe;
    private zbtc zbf;
    private zbtc zbg;
    private zbpw zbh;
    private String zbi;
    private byte zbj = 2;

    static {
        zbqm zbqmVar = new zbqm();
        zbb = zbqmVar;
        zbuf.zbD(zbqm.class, zbqmVar);
    }

    private zbqm() {
        zbtc zbtcVar = zbtc.zbb;
        this.zbe = zbtcVar;
        this.zbf = zbtcVar;
        this.zbg = zbtcVar;
        this.zbi = "";
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbj);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0002\u0001ᔊ\u0000\u0002ည\u0001\u0003ည\u0002\u0004ᐉ\u0003\u0005ဈ\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i6 == 3) {
            return new zbqm();
        }
        zbpu zbpuVar = null;
        if (i6 == 4) {
            return new zbql(zbpuVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
