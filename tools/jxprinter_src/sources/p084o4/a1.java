package p084o4;

import java.util.Arrays;
import p147z3.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a1 extends J0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6460a;
    private byte[] buffer;

    public a1(byte[] bArr) {
        this.buffer = bArr;
        this.f6460a = bArr.length;
        b(10);
    }

    @Override // p084o4.J0
    public final /* bridge */ /* synthetic */ Object a() {
        return E.b(m1044buildTcUX1vc$kotlinx_serialization_core());
    }

    @Override // p084o4.J0
    public final void b(int i5) {
        byte[] bArr = this.buffer;
        if (bArr.length < i5) {
            int length = bArr.length * 2;
            if (i5 < length) {
                i5 = length;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i5);
            kotlin.jvm.internal.E.e(bArrCopyOf, "copyOf(...)");
            this.buffer = E.m1179constructorimpl(bArrCopyOf);
        }
    }

    /* JADX INFO: renamed from: build-TcUX1vc$kotlinx_serialization_core, reason: not valid java name */
    public byte[] m1044buildTcUX1vc$kotlinx_serialization_core() {
        byte[] bArrCopyOf = Arrays.copyOf(this.buffer, this.f6460a);
        kotlin.jvm.internal.E.e(bArrCopyOf, "copyOf(...)");
        return E.m1179constructorimpl(bArrCopyOf);
    }

    @Override // p084o4.J0
    public final int d() {
        return this.f6460a;
    }

    public final void e(byte b) {
        b(d() + 1);
        byte[] bArr = this.buffer;
        int i5 = this.f6460a;
        this.f6460a = i5 + 1;
        bArr[i5] = b;
    }
}
