package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbzr extends zbuf implements zbvn {
    private static final zbzr zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private String zbg = "";

    static {
        zbzr zbzrVar = new zbzr();
        zbb = zbzrVar;
        zbuf.zbD(zbzr.class, zbzrVar);
    }

    private zbzr() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002᠌\u0001\u0003ဈ\u0002", new Object[]{"zbd", "zbe", "zbf", zbzp.zba, "zbg"});
        }
        if (i6 == 3) {
            return new zbzr();
        }
        zbwz zbwzVar = null;
        if (i6 == 4) {
            return new zbzq(zbwzVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
