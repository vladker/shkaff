package okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6594a;
    public final int[] b = new int[10];

    public final int a() {
        if ((this.f6594a & 128) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    public final void b(int i5, int i6) {
        if (i5 >= 0) {
            int[] iArr = this.b;
            if (i5 >= iArr.length) {
                return;
            }
            this.f6594a = (1 << i5) | this.f6594a;
            iArr[i5] = i6;
        }
    }
}
