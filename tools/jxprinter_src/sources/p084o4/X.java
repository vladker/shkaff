package p084o4;

import java.util.Arrays;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class X extends J0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6459a;
    private int[] buffer;

    public X(int[] bufferWithData) {
        E.f(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.f6459a = bufferWithData.length;
        b(10);
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
            this.buffer = iArrCopyOf;
        }
    }

    @Override // p084o4.J0
    /* JADX INFO: renamed from: build$kotlinx_serialization_core, reason: merged with bridge method [inline-methods] */
    public int[] a() {
        int[] iArrCopyOf = Arrays.copyOf(this.buffer, this.f6459a);
        E.e(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    @Override // p084o4.J0
    public final int d() {
        return this.f6459a;
    }

    public final void e(int i5) {
        b(d() + 1);
        int[] iArr = this.buffer;
        int i6 = this.f6459a;
        this.f6459a = i6 + 1;
        iArr[i6] = i5;
    }
}
