package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbrk extends zbuf implements zbvn {
    private static final zbrk zbb;
    private int zbd;
    private zbpw zbe;
    private byte zbg = 2;
    private zbul zbf = zbuf.zbw();

    static {
        zbrk zbrkVar = new zbrk();
        zbb = zbrkVar;
        zbuf.zbD(zbrk.class, zbrkVar);
    }

    private zbrk() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbg);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001ᐉ\u0000\u0002\u0016", new Object[]{"zbd", "zbe", "zbf"});
        }
        if (i6 == 3) {
            return new zbrk();
        }
        zbpu zbpuVar = null;
        if (i6 == 4) {
            return new zbrj(zbpuVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
