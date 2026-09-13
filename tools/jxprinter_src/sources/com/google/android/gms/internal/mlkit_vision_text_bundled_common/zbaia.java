package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbaia extends zbuf implements zbvn {
    private static final zbaia zbb;
    private zbun zbd = zbuf.zby();
    private zbun zbe = zbuf.zby();
    private zbun zbf = zbuf.zby();
    private zbun zbg = zbuf.zby();

    static {
        zbaia zbaiaVar = new zbaia();
        zbb = zbaiaVar;
        zbuf.zbD(zbaia.class, zbaiaVar);
    }

    private zbaia() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004\u001b", new Object[]{"zbd", zbahm.class, "zbe", zbahb.class, "zbf", zbaif.class, "zbg", zbahy.class});
        }
        if (i6 == 3) {
            return new zbaia();
        }
        zbagx zbagxVar = null;
        if (i6 == 4) {
            return new zbahz(zbagxVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
