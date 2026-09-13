package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbabs extends zbuf implements zbvn {
    private static final zbabs zbb;
    private int zbd;
    private zbuk zbe = zbuf.zbv();
    private zbuk zbf = zbuf.zbv();
    private int zbg;
    private int zbh;
    private int zbi;
    private int zbj;

    static {
        zbabs zbabsVar = new zbabs();
        zbb = zbabsVar;
        zbuf.zbD(zbabs.class, zbabsVar);
    }

    private zbabs() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0002\u0000\u0001\u0013\u0002\u0013\u0003ဋ\u0000\u0004ဋ\u0001\u0005ဋ\u0002\u0006ဋ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj"});
        }
        if (i6 == 3) {
            return new zbabs();
        }
        zbabq zbabqVar = null;
        if (i6 == 4) {
            return new zbabr(zbabqVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
