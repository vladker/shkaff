package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbew extends zbuf implements zbvn {
    private static final zbew zbb;
    private int zbd;
    private boolean zbe;
    private float zbf = 0.2f;
    private zbun zbg = zbuf.zby();

    static {
        zbew zbewVar = new zbew();
        zbb = zbewVar;
        zbuf.zbD(zbew.class, zbewVar);
    }

    private zbew() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0001\u0000\u0001ဇ\u0000\u0002ခ\u0001\u0004\u001b", new Object[]{"zbd", "zbe", "zbf", "zbg", zbez.class});
        }
        if (i6 == 3) {
            return new zbew();
        }
        zbeu zbeuVar = null;
        if (i6 == 4) {
            return new zbev(zbeuVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
