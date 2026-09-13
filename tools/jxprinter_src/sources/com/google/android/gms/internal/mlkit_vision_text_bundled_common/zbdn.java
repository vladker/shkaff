package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbdn extends zbuf implements zbvn {
    private static final zbdn zbb;
    private int zbd;
    private int zbe;
    private String zbf = "";

    static {
        zbdn zbdnVar = new zbdn();
        zbb = zbdnVar;
        zbuf.zbD(zbdn.class, zbdnVar);
    }

    private zbdn() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zbd", "zbe", zbdm.zba, "zbf"});
        }
        if (i6 == 3) {
            return new zbdn();
        }
        zbdk zbdkVar = null;
        if (i6 == 4) {
            return new zbdl(zbdkVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
