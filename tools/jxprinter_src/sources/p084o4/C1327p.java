package p084o4;

import java.util.Arrays;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: o4.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1327p extends J0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6471a;
    private char[] buffer;

    public C1327p(char[] bufferWithData) {
        E.f(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.f6471a = bufferWithData.length;
        b(10);
    }

    @Override // p084o4.J0
    public final void b(int i5) {
        char[] cArr = this.buffer;
        if (cArr.length < i5) {
            int length = cArr.length * 2;
            if (i5 < length) {
                i5 = length;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i5);
            E.e(cArrCopyOf, "copyOf(...)");
            this.buffer = cArrCopyOf;
        }
    }

    @Override // p084o4.J0
    /* JADX INFO: renamed from: build$kotlinx_serialization_core, reason: merged with bridge method [inline-methods] */
    public char[] a() {
        char[] cArrCopyOf = Arrays.copyOf(this.buffer, this.f6471a);
        E.e(cArrCopyOf, "copyOf(...)");
        return cArrCopyOf;
    }

    @Override // p084o4.J0
    public final int d() {
        return this.f6471a;
    }

    public final void e(char c) {
        b(d() + 1);
        char[] cArr = this.buffer;
        int i5 = this.f6471a;
        this.f6471a = i5 + 1;
        cArr[i5] = c;
    }
}
