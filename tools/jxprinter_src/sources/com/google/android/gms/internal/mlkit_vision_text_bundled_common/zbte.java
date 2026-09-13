package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbte extends zbtg {
    private int zbb;
    private int zbc;
    private int zbd;

    public /* synthetic */ zbte(byte[] bArr, int i5, int i6, boolean z6, zbtd zbtdVar) {
        super(null);
        this.zbd = Integer.MAX_VALUE;
        this.zbb = 0;
    }

    public final int zba(int i5) {
        int i6 = this.zbd;
        this.zbd = 0;
        int i7 = this.zbb + this.zbc;
        this.zbb = i7;
        if (i7 <= 0) {
            this.zbc = 0;
            return i6;
        }
        this.zbc = i7;
        this.zbb = 0;
        return i6;
    }
}
