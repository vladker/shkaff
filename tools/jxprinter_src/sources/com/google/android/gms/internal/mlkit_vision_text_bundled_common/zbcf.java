package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbcf extends zbuf implements zbvn {
    private static final zbcf zbb;
    private int zbd;
    private float zbf;
    private int zbi;
    private float zbj;
    private zbun zbe = zbuf.zby();
    private boolean zbg = true;
    private float zbh = 0.8f;

    static {
        zbcf zbcfVar = new zbcf();
        zbb = zbcfVar;
        zbuf.zbD(zbcf.class, zbcfVar);
    }

    private zbcf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001a\u0002ခ\u0000\u0003ဇ\u0001\u0004ခ\u0002\u0005င\u0003\u0006ခ\u0004", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i6 == 3) {
            return new zbcf();
        }
        zbcd zbcdVar = null;
        if (i6 == 4) {
            return new zbce(zbcdVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
