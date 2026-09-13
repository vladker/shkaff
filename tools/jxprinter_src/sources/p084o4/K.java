package p084o4;

import java.util.Arrays;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class K extends J0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6455a;
    private float[] buffer;

    public K(float[] bufferWithData) {
        E.f(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.f6455a = bufferWithData.length;
        b(10);
    }

    @Override // p084o4.J0
    public final void b(int i5) {
        float[] fArr = this.buffer;
        if (fArr.length < i5) {
            int length = fArr.length * 2;
            if (i5 < length) {
                i5 = length;
            }
            float[] fArrCopyOf = Arrays.copyOf(fArr, i5);
            E.e(fArrCopyOf, "copyOf(...)");
            this.buffer = fArrCopyOf;
        }
    }

    @Override // p084o4.J0
    /* JADX INFO: renamed from: build$kotlinx_serialization_core, reason: merged with bridge method [inline-methods] */
    public float[] a() {
        float[] fArrCopyOf = Arrays.copyOf(this.buffer, this.f6455a);
        E.e(fArrCopyOf, "copyOf(...)");
        return fArrCopyOf;
    }

    @Override // p084o4.J0
    public final int d() {
        return this.f6455a;
    }

    public final void e(float f6) {
        b(d() + 1);
        float[] fArr = this.buffer;
        int i5 = this.f6455a;
        this.f6455a = i5 + 1;
        fArr[i5] = f6;
    }
}
