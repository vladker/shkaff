package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zblp extends zbub implements zbvn {
    private static final zblp zbd;
    private int zbe;
    private boolean zbf;
    private byte zbg = 2;

    static {
        zblp zblpVar = new zblp();
        zbd = zblpVar;
        zbuf.zbD(zblp.class, zblpVar);
    }

    private zblp() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbg);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbd, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"zbe", "zbf"});
        }
        if (i6 == 3) {
            return new zblp();
        }
        zbln zblnVar = null;
        if (i6 == 4) {
            return new zblo(zblnVar);
        }
        if (i6 == 5) {
            return zbd;
        }
        this.zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
