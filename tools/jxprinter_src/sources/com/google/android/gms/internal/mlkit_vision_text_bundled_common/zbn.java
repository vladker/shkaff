package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbn extends zbuf implements zbvn {
    private static final zbn zbb;
    private int zbd;
    private float zbf;
    private String zbe = "";
    private zbun zbg = zbuf.zby();
    private zbun zbh = zbuf.zby();

    static {
        zbn zbnVar = new zbn();
        zbb = zbnVar;
        zbuf.zbD(zbn.class, zbnVar);
    }

    private zbn() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0004\u0005\u0000\u0000\u0001\u007f\u0005\u0000\u0002\u0000\u0001\f\u0002Ȉ\u0003\u0001\u0004Ț\u007fȚ", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh"});
        }
        if (i6 == 3) {
            return new zbn();
        }
        zbl zblVar = null;
        if (i6 == 4) {
            return new zbm(zblVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
