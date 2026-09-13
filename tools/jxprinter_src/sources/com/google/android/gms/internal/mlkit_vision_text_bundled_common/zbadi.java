package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbadi extends zbuf implements zbvn {
    private static final zbadi zbb;
    private int zbd;
    private int zbe;
    private int zbf;

    static {
        zbadi zbadiVar = new zbadi();
        zbb = zbadiVar;
        zbuf.zbD(zbadi.class, zbadiVar);
    }

    private zbadi() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i6 == 3) {
            return new zbadi();
        }
        zbadg zbadgVar = null;
        if (i6 == 4) {
            return new zbadh(zbadgVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
