package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbcp extends zbuf implements zbvn {
    private static final zbcp zbb;
    private int zbd;
    private String zbe = "";
    private String zbf = "";
    private int zbg = 1;

    static {
        zbcp zbcpVar = new zbcp();
        zbb = zbcpVar;
        zbuf.zbD(zbcp.class, zbcpVar);
    }

    private zbcp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003᠌\u0002", new Object[]{"zbd", "zbe", "zbf", "zbg", zbco.zba});
        }
        if (i6 == 3) {
            return new zbcp();
        }
        zbcm zbcmVar = null;
        if (i6 == 4) {
            return new zbcn(zbcmVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
