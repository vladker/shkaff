package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbrz extends zbuf implements zbvn {
    private static final zbrz zbb;
    private int zbd;
    private zbun zbe = zbuf.zby();
    private zbun zbf = zbuf.zby();
    private int zbg;

    static {
        zbrz zbrzVar = new zbrz();
        zbb = zbrzVar;
        zbuf.zbD(zbrz.class, zbrzVar);
    }

    private zbrz() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u001b\u0003င\u0000", new Object[]{"zbd", "zbe", zbsb.class, "zbf", zbrv.class, "zbg"});
        }
        if (i6 == 3) {
            return new zbrz();
        }
        zbrt zbrtVar = null;
        if (i6 == 4) {
            return new zbry(zbrtVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
