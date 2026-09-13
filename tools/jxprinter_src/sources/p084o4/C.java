package p084o4;

import java.util.Arrays;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C extends J0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6451a;
    private double[] buffer;

    public C(double[] bufferWithData) {
        E.f(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.f6451a = bufferWithData.length;
        b(10);
    }

    @Override // p084o4.J0
    public final void b(int i5) {
        double[] dArr = this.buffer;
        if (dArr.length < i5) {
            int length = dArr.length * 2;
            if (i5 < length) {
                i5 = length;
            }
            double[] dArrCopyOf = Arrays.copyOf(dArr, i5);
            E.e(dArrCopyOf, "copyOf(...)");
            this.buffer = dArrCopyOf;
        }
    }

    @Override // p084o4.J0
    /* JADX INFO: renamed from: build$kotlinx_serialization_core, reason: merged with bridge method [inline-methods] */
    public double[] a() {
        double[] dArrCopyOf = Arrays.copyOf(this.buffer, this.f6451a);
        E.e(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }

    @Override // p084o4.J0
    public final int d() {
        return this.f6451a;
    }

    public final void e(double d) {
        b(d() + 1);
        double[] dArr = this.buffer;
        int i5 = this.f6451a;
        this.f6451a = i5 + 1;
        dArr[i5] = d;
    }
}
