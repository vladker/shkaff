package p084o4;

import java.util.Arrays;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S0 extends J0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6456a;
    private short[] buffer;

    public S0(short[] bufferWithData) {
        E.f(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.f6456a = bufferWithData.length;
        b(10);
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
            this.buffer = sArrCopyOf;
        }
    }

    @Override // p084o4.J0
    /* JADX INFO: renamed from: build$kotlinx_serialization_core, reason: merged with bridge method [inline-methods] */
    public short[] a() {
        short[] sArrCopyOf = Arrays.copyOf(this.buffer, this.f6456a);
        E.e(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }

    @Override // p084o4.J0
    public final int d() {
        return this.f6456a;
    }

    public final void e(short s6) {
        b(d() + 1);
        short[] sArr = this.buffer;
        int i5 = this.f6456a;
        this.f6456a = i5 + 1;
        sArr[i5] = s6;
    }
}
