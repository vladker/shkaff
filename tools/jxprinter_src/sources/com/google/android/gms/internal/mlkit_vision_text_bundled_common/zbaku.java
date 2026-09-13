package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbaku extends zbuf implements zbvn {
    private static final zbaku zbb;
    private int zbd;
    private zbbt zbe;
    private zbun zbf = zbuf.zby();

    static {
        zbaku zbakuVar = new zbaku();
        zbb = zbakuVar;
        zbuf.zbD(zbaku.class, zbakuVar);
    }

    private zbaku() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"zbd", "zbe", "zbf", zbajh.class});
        }
        if (i6 == 3) {
            return new zbaku();
        }
        zbaks zbaksVar = null;
        if (i6 == 4) {
            return new zbakt(zbaksVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
