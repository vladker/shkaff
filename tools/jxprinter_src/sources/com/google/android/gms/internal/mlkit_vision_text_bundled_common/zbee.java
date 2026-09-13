package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbee extends zbuf implements zbvn {
    private static final zbee zbb;
    private int zbd;
    private int zbe = 3;
    private float zbf = 100000.0f;
    private float zbg;

    static {
        zbee zbeeVar = new zbee();
        zbb = zbeeVar;
        zbuf.zbD(zbee.class, zbeeVar);
    }

    private zbee() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ခ\u0001\u0003ခ\u0002", new Object[]{"zbd", "zbe", zbec.zba, "zbf", "zbg"});
        }
        if (i6 == 3) {
            return new zbee();
        }
        zbeb zbebVar = null;
        if (i6 == 4) {
            return new zbed(zbebVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
