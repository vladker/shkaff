package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbnr extends zbuf implements zbvn {
    private static final zbnr zbb;
    private int zbd;
    private float zbe;
    private float zbf;

    static {
        zbnr zbnrVar = new zbnr();
        zbb = zbnrVar;
        zbuf.zbD(zbnr.class, zbnrVar);
    }

    private zbnr() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i6 == 3) {
            return new zbnr();
        }
        zbno zbnoVar = null;
        if (i6 == 4) {
            return new zbnq(zbnoVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
