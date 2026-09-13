package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbnt extends zbuf implements zbvn {
    private static final zbnt zbb;
    private int zbd;
    private zbun zbe = zbuf.zby();
    private int zbf;
    private int zbg;

    static {
        zbnt zbntVar = new zbnt();
        zbb = zbntVar;
        zbuf.zbD(zbnt.class, zbntVar);
    }

    private zbnt() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002᠌\u0000\u0003᠌\u0001", new Object[]{"zbd", "zbe", zbnr.class, "zbf", zbns.zba, "zbg", zbnn.zba});
        }
        if (i6 == 3) {
            return new zbnt();
        }
        zbno zbnoVar = null;
        if (i6 == 4) {
            return new zbnp(zbnoVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
