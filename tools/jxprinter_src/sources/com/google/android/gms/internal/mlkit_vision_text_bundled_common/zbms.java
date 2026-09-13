package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class zbms extends zbuf implements zbvn {
    private static final zbms zbb;
    private int zbd;
    private zbmu zbj;
    private byte zbk = 2;
    private String zbe = "";
    private zbun zbf = zbuf.zby();
    private zbun zbg = zbuf.zby();
    private zbun zbh = zbuf.zby();
    private zbun zbi = zbuf.zby();

    static {
        zbms zbmsVar = new zbms();
        zbb = zbmsVar;
        zbuf.zbD(zbms.class, zbmsVar);
    }

    private zbms() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbk);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0006\u0000\u0001\u0001ϫ\u0006\u0000\u0004\u0001\u0001ဈ\u0000\u0002\u001a\u0003\u001a\u0004ᐉ\u0001Ϫ\u001aϫ\u001a", new Object[]{"zbd", "zbe", "zbf", "zbh", "zbj", "zbg", "zbi"});
        }
        if (i6 == 3) {
            return new zbms();
        }
        zbmq zbmqVar = null;
        if (i6 == 4) {
            return new zbmr(zbmqVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
