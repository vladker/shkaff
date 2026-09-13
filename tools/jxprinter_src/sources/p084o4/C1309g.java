package p084o4;

import java.util.Arrays;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: o4.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1309g extends J0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6462a;
    private boolean[] buffer;

    public C1309g(boolean[] bufferWithData) {
        E.f(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.f6462a = bufferWithData.length;
        b(10);
    }

    @Override // p084o4.J0
    public final void b(int i5) {
        boolean[] zArr = this.buffer;
        if (zArr.length < i5) {
            int length = zArr.length * 2;
            if (i5 < length) {
                i5 = length;
            }
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, i5);
            E.e(zArrCopyOf, "copyOf(...)");
            this.buffer = zArrCopyOf;
        }
    }

    @Override // p084o4.J0
    /* JADX INFO: renamed from: build$kotlinx_serialization_core, reason: merged with bridge method [inline-methods] */
    public boolean[] a() {
        boolean[] zArrCopyOf = Arrays.copyOf(this.buffer, this.f6462a);
        E.e(zArrCopyOf, "copyOf(...)");
        return zArrCopyOf;
    }

    @Override // p084o4.J0
    public final int d() {
        return this.f6462a;
    }

    public final void e(boolean z6) {
        b(d() + 1);
        boolean[] zArr = this.buffer;
        int i5 = this.f6462a;
        this.f6462a = i5 + 1;
        zArr[i5] = z6;
    }
}
