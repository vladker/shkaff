package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbaat extends zbub implements zbvn {
    private static final zbaat zbd;
    private int zbe;
    private Object zbg;
    private int zbi;
    private int zbj;
    private int zbk;
    private int zbf = 0;
    private byte zbl = 2;
    private String zbh = "";

    static {
        zbaat zbaatVar = new zbaat();
        zbd = zbaatVar;
        zbuf.zbD(zbaat.class, zbaatVar);
    }

    private zbaat() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbl);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbd, "\u0001\u0007\u0001\u0001\u0001\b\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0006=\u0000\u0007=\u0000\b6\u0000", new Object[]{"zbg", "zbf", "zbe", "zbh", "zbi", "zbj", "zbk"});
        }
        if (i6 == 3) {
            return new zbaat();
        }
        zbaad zbaadVar = null;
        if (i6 == 4) {
            return new zbaas(zbaadVar);
        }
        if (i6 == 5) {
            return zbd;
        }
        this.zbl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
