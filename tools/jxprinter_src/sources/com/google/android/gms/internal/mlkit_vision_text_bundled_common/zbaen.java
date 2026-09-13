package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbaen extends zbuf implements zbvn {
    private static final zbaen zbb;
    private int zbd;
    private zbaeh zbe;
    private zbun zbf = zbuf.zby();
    private float zbg;

    static {
        zbaen zbaenVar = new zbaen();
        zbb = zbaenVar;
        zbuf.zbD(zbaen.class, zbaenVar);
    }

    private zbaen() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ခ\u0001", new Object[]{"zbd", "zbe", "zbf", zbaem.class, "zbg"});
        }
        if (i6 == 3) {
            return new zbaen();
        }
        zbaef zbaefVar = null;
        if (i6 == 4) {
            return new zbaei(zbaefVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
