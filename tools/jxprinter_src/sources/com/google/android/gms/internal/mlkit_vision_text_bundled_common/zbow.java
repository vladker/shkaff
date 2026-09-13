package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbow extends zbuf implements zbvn {
    private static final zbow zbb;
    private int zbd;
    private zbou zbe;
    private double zbf;
    private boolean zbg;
    private zbpb zbh;
    private byte zbi = 2;

    static {
        zbow zbowVar = new zbow();
        zbb = zbowVar;
        zbuf.zbD(zbow.class, zbowVar);
    }

    private zbow() {
    }

    public static zbow zbc() {
        return zbb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbi);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0001\u0001ဉ\u0000\u0002က\u0001\u0003ဇ\u0002\u0004ᐉ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i6 == 3) {
            return new zbow();
        }
        zboq zboqVar = null;
        if (i6 == 4) {
            return new zbov(zboqVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final zbpb zbd() {
        zbpb zbpbVar = this.zbh;
        return zbpbVar == null ? zbpb.zbh() : zbpbVar;
    }
}
