package p084o4;

import java.util.Arrays;
import kotlin.jvm.internal.E;
import p147z3.O;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class j1 extends J0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6466a;
    private short[] buffer;

    public j1(short[] sArr) {
        this.buffer = sArr;
        this.f6466a = sArr.length;
        b(10);
    }

    @Override // p084o4.J0
    public final /* bridge */ /* synthetic */ Object a() {
        return O.b(m1065buildamswpOA$kotlinx_serialization_core());
    }

    @Override // p084o4.J0
    public final void b(int i5) {
        short[] sArr = this.buffer;
        if (sArr.length < i5) {
            int length = sArr.length * 2;
            if (i5 < length) {
                i5 = length;
            }
            short[] sArrCopyOf = Arrays.copyOf(sArr, i5);
            E.e(sArrCopyOf, "copyOf(...)");
            this.buffer = O.m1354constructorimpl(sArrCopyOf);
        }
    }

    /* JADX INFO: renamed from: build-amswpOA$kotlinx_serialization_core, reason: not valid java name */
    public short[] m1065buildamswpOA$kotlinx_serialization_core() {
        short[] sArrCopyOf = Arrays.copyOf(this.buffer, this.f6466a);
        E.e(sArrCopyOf, "copyOf(...)");
        return O.m1354constructorimpl(sArrCopyOf);
    }

    @Override // p084o4.J0
    public final int d() {
        return this.f6466a;
    }

    public final void e(short s6) {
        b(d() + 1);
        short[] sArr = this.buffer;
        int i5 = this.f6466a;
        this.f6466a = i5 + 1;
        sArr[i5] = s6;
    }
}
