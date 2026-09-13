package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbabl extends zbub implements zbvn {
    private static final zbabl zbd;
    private int zbe;
    private int zbf;
    private int zbg;
    private zbaat zbh;
    private int zbj;
    private int zbk;
    private zbaax zbm;
    private long zbp;
    private byte zbq = 2;
    private String zbi = "";
    private zbun zbl = zbuf.zby();
    private String zbn = "";
    private zbun zbo = zbuf.zby();

    static {
        zbabl zbablVar = new zbabl();
        zbd = zbablVar;
        zbuf.zbD(zbabl.class, zbablVar);
    }

    private zbabl() {
    }

    public static zbabl zbe() {
        return zbd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbq);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbd, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0002\u0003\u0001င\u0000\u0002င\u0001\u0003ᐉ\u0002\u0004ဈ\u0003\u0005င\u0004\u0006င\u0005\u0007Л\bᐉ\u0006\tဈ\u0007\n\u001a\u000bဂ\b", new Object[]{"zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", zbabj.class, "zbm", "zbn", "zbo", "zbp"});
        }
        if (i6 == 3) {
            return new zbabl();
        }
        zbaad zbaadVar = null;
        if (i6 == 4) {
            return new zbabk(zbaadVar);
        }
        if (i6 == 5) {
            return zbd;
        }
        this.zbq = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final List zbf() {
        return this.zbl;
    }
}
