package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbadf extends zbuf implements zbvn {
    private static final zbadf zbb;
    private byte zbe = 2;
    private zbun zbd = zbuf.zby();

    static {
        zbadf zbadfVar = new zbadf();
        zbb = zbadfVar;
        zbuf.zbD(zbadf.class, zbadfVar);
    }

    private zbadf() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbe);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zbd", zbadb.class});
        }
        if (i6 == 3) {
            return new zbadf();
        }
        zbadd zbaddVar = null;
        if (i6 == 4) {
            return new zbade(zbaddVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbe = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
