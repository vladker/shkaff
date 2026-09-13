package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zben extends zbuf implements zbvn {
    private static final zben zbb;
    private int zbd;
    private zbfu zbe;
    private zbnm zbf;
    private zbbn zbg;
    private zbfl zbh;
    private zbet zbi;
    private zbeq zbj;
    private zbff zbk;
    private byte zbl = 2;

    static {
        zben zbenVar = new zben();
        zbb = zbenVar;
        zbuf.zbD(zben.class, zbenVar);
    }

    private zben() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbl);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ᐉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007ဉ\u0006", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk"});
        }
        if (i6 == 3) {
            return new zben();
        }
        zbel zbelVar = null;
        if (i6 == 4) {
            return new zbem(zbelVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
