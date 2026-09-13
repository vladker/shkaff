package p134x2;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8861a;
    public final int b;
    public final int c;
    private byte[] data;

    public P(int i5, int i6, int i7, byte[] data) {
        E.f(data, "data");
        this.f8861a = i5;
        this.b = i6;
        this.c = i7;
        this.data = data;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final void setData(byte[] bArr) {
        E.c(bArr);
        this.data = bArr;
    }
}
