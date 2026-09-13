package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbala extends zbuf implements zbvn {
    private static final zbala zbb;
    private long zbe;
    private long zbf;
    private zbtc zbd = zbtc.zbb;
    private zbun zbg = zbuf.zby();

    static {
        zbala zbalaVar = new zbala();
        zbb = zbalaVar;
        zbuf.zbD(zbala.class, zbalaVar);
    }

    private zbala() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001\n\u0002\u0002\u0003\u0002\u0004\u001b", new Object[]{"zbd", "zbe", "zbf", "zbg", zbajt.class});
        }
        if (i6 == 3) {
            return new zbala();
        }
        zbaky zbakyVar = null;
        if (i6 == 4) {
            return new zbakz(zbakyVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
