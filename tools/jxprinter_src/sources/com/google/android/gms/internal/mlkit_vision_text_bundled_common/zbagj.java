package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbagj extends zbuf implements zbvn {
    private static final zbagj zbb;
    private int zbd;
    private int zbe;
    private int zbg;
    private boolean zbh;
    private byte zbi = 2;
    private zbun zbf = zbuf.zby();

    static {
        zbagj zbagjVar = new zbagj();
        zbb = zbagjVar;
        zbuf.zbD(zbagj.class, zbagjVar);
    }

    private zbagj() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbi);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0004\u0000\u0001\u0003\u0006\u0004\u0000\u0001\u0002\u0003ᔄ\u0000\u0004Л\u0005င\u0001\u0006ဇ\u0002", new Object[]{"zbd", "zbe", "zbf", zbagn.class, "zbg", "zbh"});
        }
        if (i6 == 3) {
            return new zbagj();
        }
        zbagg zbaggVar = null;
        if (i6 == 4) {
            return new zbagi(zbaggVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
