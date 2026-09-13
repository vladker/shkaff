package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbajt extends zbuf implements zbvn {
    private static final zbajt zbb;
    private int zbd;
    private int zbe;
    private int zbf;
    private String zbg = "";

    static {
        zbajt zbajtVar = new zbajt();
        zbb = zbajtVar;
        zbuf.zbD(zbajt.class, zbajtVar);
    }

    private zbajt() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\u000b\u0004Ȉ", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i6 == 3) {
            return new zbajt();
        }
        zbajr zbajrVar = null;
        if (i6 == 4) {
            return new zbajs(zbajrVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
