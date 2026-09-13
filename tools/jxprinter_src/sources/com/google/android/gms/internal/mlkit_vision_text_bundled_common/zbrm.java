package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbrm extends zbuf implements zbvn {
    private static final zbrm zbb;
    private int zbd;
    private zbpw zbe;
    private int zbh;
    private int zbi;
    private byte zbj = 2;
    private String zbf = "";
    private zbul zbg = zbuf.zbw();

    static {
        zbrm zbrmVar = new zbrm();
        zbb = zbrmVar;
        zbuf.zbD(zbrm.class, zbrmVar);
    }

    private zbrm() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbj);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ᐉ\u0000\u0002ဈ\u0001\u0003\u0016\u0004င\u0002\u0005᠌\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", zbabe.zba()});
        }
        if (i6 == 3) {
            return new zbrm();
        }
        zbpu zbpuVar = null;
        if (i6 == 4) {
            return new zbrl(zbpuVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
