package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zboz extends zbuf implements zbvn {
    private static final zboz zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private int zbg = 2;
    private float zbh;
    private boolean zbi;

    static {
        zboz zbozVar = new zboz();
        zbb = zbozVar;
        zbuf.zbD(zboz.class, zbozVar);
    }

    private zboz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004ခ\u0003\u0005ဇ\u0004", new Object[]{"zbd", "zbe", zbox.zba, "zbf", zbpd.zba, "zbg", zbpc.zba, "zbh", "zbi"});
        }
        if (i6 == 3) {
            return new zboz();
        }
        zboq zboqVar = null;
        if (i6 == 4) {
            return new zboy(zboqVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
