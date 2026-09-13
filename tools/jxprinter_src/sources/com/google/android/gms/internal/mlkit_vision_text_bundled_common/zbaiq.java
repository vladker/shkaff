package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbaiq extends zbuf implements zbvn {
    private static final zbaiq zbb;
    private int zbd;
    private zbaio zbe;
    private float zbf = 0.6f;
    private float zbg = 0.5f;
    private float zbh = 0.01f;
    private float zbi = 0.2f;
    private float zbj = 3.0f;
    private float zbk = 0.75f;
    private float zbl = 0.75f;
    private float zbm = 0.25f;
    private float zbn = 0.2f;
    private float zbo = 0.4f;
    private int zbp = 10;
    private float zbq = 0.05f;
    private int zbr = 3;

    static {
        zbaiq zbaiqVar = new zbaiq();
        zbb = zbaiqVar;
        zbuf.zbD(zbaiq.class, zbaiqVar);
    }

    private zbaiq() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0000\u0000\u0001ဉ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005\bခ\u0006\tခ\u0007\nခ\b\u000bခ\t\fခ\n\rင\u000b\u000eခ\f\u000fင\r", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", "zbn", "zbo", "zbp", "zbq", "zbr"});
        }
        if (i6 == 3) {
            return new zbaiq();
        }
        zbaim zbaimVar = null;
        if (i6 == 4) {
            return new zbaip(zbaimVar);
        }
        if (i6 != 5) {
            return null;
        }
        return zbb;
    }
}
