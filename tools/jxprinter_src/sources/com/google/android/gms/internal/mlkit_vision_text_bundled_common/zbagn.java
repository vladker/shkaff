package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbagn extends zbuf implements zbvn {
    private static final zbagn zbb;
    private int zbd;
    private float zbe;
    private float zbf;
    private float zbg;
    private float zbh;
    private zbagq zbi;
    private float zbj;
    private zbafz zbk;
    private float zbl;
    private zbtc zbm;
    private zbtc zbn;
    private byte zbo = 2;

    static {
        zbagn zbagnVar = new zbagn();
        zbb = zbagnVar;
        zbuf.zbD(zbagn.class, zbagnVar);
    }

    private zbagn() {
        zbtc zbtcVar = zbtc.zbb;
        this.zbm = zbtcVar;
        this.zbn = zbtcVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbo);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0004\u0001ᔁ\u0000\u0002ᔁ\u0001\u0003ᔁ\u0002\u0004ခ\u0003\u0005ခ\u0007\u0006ည\b\u0007ခ\u0005\bဉ\u0006\tᐉ\u0004\nည\t", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbl", "zbm", "zbj", "zbk", "zbi", "zbn"});
        }
        if (i6 == 3) {
            return new zbagn();
        }
        zbagl zbaglVar = null;
        if (i6 == 4) {
            return new zbagm(zbaglVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbo = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
