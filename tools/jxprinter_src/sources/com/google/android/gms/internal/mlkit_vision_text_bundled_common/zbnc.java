package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbnc extends zbuf implements zbvn {
    private static final zbnc zbb;
    private int zbd;
    private zbmd zbg;
    private byte zbh = 2;
    private String zbe = "InOrderOutputStreamHandler";
    private zbun zbf = zbuf.zby();

    static {
        zbnc zbncVar = new zbnc();
        zbb = zbncVar;
        zbuf.zbD(zbnc.class, zbncVar);
    }

    private zbnc() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbh);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0001\u0001ဈ\u0000\u0002\u001a\u0003ᐉ\u0001", new Object[]{"zbd", "zbe", "zbf", "zbg"});
        }
        if (i6 == 3) {
            return new zbnc();
        }
        zbmy zbmyVar = null;
        if (i6 == 4) {
            return new zbnb(zbmyVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
