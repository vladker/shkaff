package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbaif extends zbuf implements zbvn {
    private static final zbaif zbb;
    private int zbd = 0;
    private Object zbe;
    private float zbf;

    static {
        zbaif zbaifVar = new zbaif();
        zbb = zbaifVar;
        zbuf.zbD(zbaif.class, zbaifVar);
    }

    private zbaif() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u00017\u0000\u0002\u0001\u0003<\u0000", new Object[]{"zbe", "zbd", "zbf", zbaid.class});
        }
        if (i6 == 3) {
            return new zbaif();
        }
        zbaib zbaibVar = null;
        if (i6 == 4) {
            return new zbaie(zbaibVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
