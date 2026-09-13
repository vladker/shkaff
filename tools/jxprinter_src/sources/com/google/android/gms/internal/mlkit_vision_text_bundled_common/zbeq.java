package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbeq extends zbuf implements zbvn {
    private static final zbeq zbb;
    private int zbd;
    private int zbf;
    private int zbg;
    private float zbi;
    private zbun zbe = zbuf.zby();
    private String zbh = "";

    static {
        zbeq zbeqVar = new zbeq();
        zbb = zbeqVar;
        zbuf.zbD(zbeq.class, zbeqVar);
    }

    private zbeq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001c\u0002င\u0000\u0003င\u0001\u0004ဈ\u0002\u0005ခ\u0003", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi"});
        }
        if (i6 == 3) {
            return new zbeq();
        }
        zbeo zbeoVar = null;
        if (i6 == 4) {
            return new zbep(zbeoVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
