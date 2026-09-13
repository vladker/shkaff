package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbse extends zbuf implements zbvn {
    private static final zbse zbb;
    private int zbd;
    private float zbe;
    private float zbf;
    private float zbg;
    private boolean zbl;
    private float zbm;
    private float zbn;
    private byte zbo = 2;
    private String zbh = "";
    private int zbi = -1;
    private float zbj = -1.0f;
    private float zbk = -1.0f;

    static {
        zbse zbseVar = new zbse();
        zbb = zbseVar;
        zbuf.zbD(zbse.class, zbseVar);
    }

    private zbse() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbo);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\n\u0000\u0001\u0001\u000b\n\u0000\u0000\u0001\u0001ᔁ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ဈ\u0003\u0005င\u0004\u0007ခ\u0005\bခ\u0006\tဇ\u0007\nခ\b\u000bခ\t", new Object[]{"zbd", "zbe", "zbf", "zbg", "zbh", "zbi", "zbj", "zbk", "zbl", "zbm", "zbn"});
        }
        if (i6 == 3) {
            return new zbse();
        }
        zbsc zbscVar = null;
        if (i6 == 4) {
            return new zbsd(zbscVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbo = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
