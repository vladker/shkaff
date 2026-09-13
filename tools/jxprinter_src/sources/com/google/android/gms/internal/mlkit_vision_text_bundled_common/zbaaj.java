package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbaaj extends zbuf implements zbvn {
    private static final zbaaj zbb;
    private Object zbe;
    private int zbd = 0;
    private byte zbf = 2;

    static {
        zbaaj zbaajVar = new zbaaj();
        zbb = zbaajVar;
        zbuf.zbD(zbaaj.class, zbaajVar);
    }

    private zbaaj() {
    }

    public static zbaaj zbh() {
        return zbb;
    }

    public final boolean zbH() {
        return this.zbd == 1;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuf
    public final Object zbb(int i5, Object obj, Object obj2) {
        int i6 = i5 - 1;
        if (i6 == 0) {
            return Byte.valueOf(this.zbf);
        }
        if (i6 == 2) {
            return zbuf.zbA(zbb, "\u0001\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0003\u0001м\u0000\u0002м\u0000\u0003м\u0000", new Object[]{"zbe", "zbd", zbaai.class, zbpb.class, zbow.class});
        }
        if (i6 == 3) {
            return new zbaaj();
        }
        zbaad zbaadVar = null;
        if (i6 == 4) {
            return new zbaae(zbaadVar);
        }
        if (i6 == 5) {
            return zbb;
        }
        this.zbf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }

    public final zbow zbc() {
        return this.zbd == 3 ? (zbow) this.zbe : zbow.zbc();
    }

    public final zbpb zbe() {
        return this.zbd == 2 ? (zbpb) this.zbe : zbpb.zbh();
    }

    public final zbaai zbf() {
        return this.zbd == 1 ? (zbaai) this.zbe : zbaai.zbf();
    }

    public final boolean zbi() {
        return this.zbd == 3;
    }
}
