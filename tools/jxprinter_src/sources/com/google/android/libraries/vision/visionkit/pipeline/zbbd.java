package com.google.android.libraries.vision.visionkit.pipeline;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbbd {
    private byte[] zba;
    private long zbb;
    private com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbcr zbc;
    private int zbd;
    private int zbe;

    public final zbbd zba(byte[] bArr) {
        this.zba = bArr;
        return this;
    }

    public final zbbd zbb(com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbcr zbcrVar) {
        this.zbc = zbcrVar;
        return this;
    }

    public final zbbd zbc(long j6) {
        this.zbb = j6;
        return this;
    }

    public final zbbe zbd() {
        return new zbbe(this.zba, this.zbb, this.zbc, this.zbd, this.zbe);
    }

    public final zbbd zbe(int i5) {
        this.zbd = 2;
        return this;
    }

    public final zbbd zbf(int i5) {
        this.zbe = i5;
        return this;
    }
}
