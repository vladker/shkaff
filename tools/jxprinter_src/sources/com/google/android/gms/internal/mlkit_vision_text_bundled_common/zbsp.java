package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbsp extends zbuf implements zbvn {
    private static final zbsp zbb;
    private String zbd = "";
    private zbtc zbe = zbtc.zbb;

    static {
        zbsp zbspVar = new zbsp();
        zbb = zbspVar;
        zbuf.zbD(zbsp.class, zbspVar);
    }

    private zbsp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new zbvw(zbb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"zbd", "zbe"});
        }
        if (i6 == 3) {
            return new zbsp();
        }
        zbsn zbsnVar = null;
        if (i6 == 4) {
            return new zbso(zbsnVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
