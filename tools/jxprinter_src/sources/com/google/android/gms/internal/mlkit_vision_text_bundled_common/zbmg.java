package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbmg extends zbuf implements zbvn {
    private static final zbmg zbb;
    private Object zbe;
    private int zbd = 0;
    private zbun zbf = zbuf.zby();

    static {
        zbmg zbmgVar = new zbmg();
        zbb = zbmgVar;
        zbuf.zbD(zbmg.class, zbmgVar);
    }

    private zbmg() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001;\u0000\u00023\u0000\u0003<\u0000\u0004\u001b", new Object[]{"zbe", "zbd", zbmk.class, "zbf", zbmg.class});
        }
        if (i6 == 3) {
            return new zbmg();
        }
        zbme zbmeVar = null;
        if (i6 == 4) {
            return new zbmf(zbmeVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
