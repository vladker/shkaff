package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbgd extends zbuf implements zbvn {
    private static final zbgd zbb;
    private int zbd;
    private Object zbf;
    private int zbg;
    private long zbj;
    private int zbl;
    private int zbe = 0;
    private String zbh = "";
    private zbun zbi = zbuf.zby();
    private String zbk = "";

    static {
        zbgd zbgdVar = new zbgd();
        zbb = zbgdVar;
        zbuf.zbD(zbgd.class, zbgdVar);
    }

    private zbgd() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u000b\u0001\u0001\u0001\u000b\u000b\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဈ\u0003\u0005<\u0000\u0006<\u0000\u0007<\u0000\b<\u0000\t<\u0000\nဂ\u0002\u000b᠌\u0004", new Object[]{"zbf", "zbe", "zbd", "zbg", zbge.zba, "zbh", "zbi", zbgc.class, "zbk", zbci.class, zbaj.class, zbcc.class, zbaq.class, zbcp.class, "zbj", "zbl", zbfz.zba});
        }
        if (i6 == 3) {
            return new zbgd();
        }
        zbfy zbfyVar = null;
        if (i6 == 4) {
            return new zbga(zbfyVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
