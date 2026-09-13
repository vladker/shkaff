package p084o4;

import java.util.Arrays;
import kotlin.jvm.internal.E;
import p147z3.H;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d1 extends J0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6461a;
    private int[] buffer;

    public d1(int[] iArr) {
        this.buffer = iArr;
        this.f6461a = iArr.length;
        b(10);
    }

    @Override // p084o4.J0
    public final /* bridge */ /* synthetic */ Object a() {
        return H.b(m1051buildhP7Qyg$kotlinx_serialization_core());
    }

    @Override // p084o4.J0
    public final void b(int i5) {
        int[] iArr = this.buffer;
        if (iArr.length < i5) {
            int length = iArr.length * 2;
            if (i5 < length) {
                i5 = length;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i5);
            E.e(iArrCopyOf, "copyOf(...)");
            this.buffer = H.m1238constructorimpl(iArrCopyOf);
        }
    }

    /* JADX INFO: renamed from: build--hP7Qyg$kotlinx_serialization_core, reason: not valid java name */
    public int[] m1051buildhP7Qyg$kotlinx_serialization_core() {
        int[] iArrCopyOf = Arrays.copyOf(this.buffer, this.f6461a);
        E.e(iArrCopyOf, "copyOf(...)");
        return H.m1238constructorimpl(iArrCopyOf);
    }

    @Override // p084o4.J0
    public final int d() {
        return this.f6461a;
    }

    public final void e(int i5) {
        b(d() + 1);
        int[] iArr = this.buffer;
        int i6 = this.f6461a;
        this.f6461a = i6 + 1;
        iArr[i6] = i5;
    }
}
