package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbagt extends zbuf implements zbvn {
    private static final zbagt zbb;
    private int zbd;
    private float zbe;
    private zbtc zbf = zbtc.zbb;

    static {
        zbagt zbagtVar = new zbagt();
        zbb = zbagtVar;
        zbuf.zbD(zbagt.class, zbagtVar);
    }

    private zbagt() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002ည\u0001", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i6 == 3) {
            return new zbagt();
        }
        zbagr zbagrVar = null;
        if (i6 == 4) {
            return new zbags(zbagrVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
