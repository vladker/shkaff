package p084o4;

import java.util.Arrays;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: o4.i0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1314i0 extends J0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6464a;
    private long[] buffer;

    public C1314i0(long[] bufferWithData) {
        E.f(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.f6464a = bufferWithData.length;
        b(10);
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
            this.buffer = jArrCopyOf;
        }
    }

    @Override // p084o4.J0
    /* JADX INFO: renamed from: build$kotlinx_serialization_core, reason: merged with bridge method [inline-methods] */
    public long[] a() {
        long[] jArrCopyOf = Arrays.copyOf(this.buffer, this.f6464a);
        E.e(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }

    @Override // p084o4.J0
    public final int d() {
        return this.f6464a;
    }

    public final void e(long j6) {
        b(d() + 1);
        long[] jArr = this.buffer;
        int i5 = this.f6464a;
        this.f6464a = i5 + 1;
        jArr[i5] = j6;
    }
}
