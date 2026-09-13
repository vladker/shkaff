package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbpb extends zbuf implements zbvn {
    private static final zbpb zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg;
    private int zbh;
    private float zbi;
    private byte zbj = 2;

    static {
        zbpb zbpbVar = new zbpb();
        zbb = zbpbVar;
        zbuf.zbD(zbpb.class, zbpbVar);
    }

    private zbpb() {
    }

    public static zbpb zbh() {
        return zbb;
    }

    public final float zba() {
        return this.zbi;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbj);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0004\u0001ᔄ\u0000\u0002ᔄ\u0001\u0003ᔄ\u0002\u0004ᔄ\u0003\u0005ခ\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i6 == 3) {
            return new zbpb();
        }
        zboq zboqVar = null;
        if (i6 == 4) {
            return new zbpa(zboqVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final int zbc() {
        return this.zbh;
    }

    public final int zbd() {
        return this.zbe;
    }

    public final int zbe() {
        return this.zbf;
    }

    public final int zbf() {
        return this.zbg;
    }
}
