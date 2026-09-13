package p084o4;

import java.util.Arrays;
import kotlin.jvm.internal.E;
import p147z3.K;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g1 extends J0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6463a;
    private long[] buffer;

    public g1(long[] jArr) {
        this.buffer = jArr;
        this.f6463a = jArr.length;
        b(10);
    }

    @Override // p084o4.J0
    public final /* bridge */ /* synthetic */ Object a() {
        return K.b(m1058buildY2RjT0g$kotlinx_serialization_core());
    }

    @Override // p084o4.J0
    public final void b(int i5) {
        long[] jArr = this.buffer;
        if (jArr.length < i5) {
            int length = jArr.length * 2;
            if (i5 < length) {
                i5 = length;
            }
            long[] jArrCopyOf = Arrays.copyOf(jArr, i5);
            E.e(jArrCopyOf, "copyOf(...)");
            this.buffer = K.m1297constructorimpl(jArrCopyOf);
        }
    }

    /* JADX INFO: renamed from: build-Y2RjT0g$kotlinx_serialization_core, reason: not valid java name */
    public long[] m1058buildY2RjT0g$kotlinx_serialization_core() {
        long[] jArrCopyOf = Arrays.copyOf(this.buffer, this.f6463a);
        E.e(jArrCopyOf, "copyOf(...)");
        return K.m1297constructorimpl(jArrCopyOf);
    }

    @Override // p084o4.J0
    public final int d() {
        return this.f6463a;
    }

    public final void e(long j6) {
        b(d() + 1);
        long[] jArr = this.buffer;
        int i5 = this.f6463a;
        this.f6463a = i5 + 1;
        jArr[i5] = j6;
    }
}
