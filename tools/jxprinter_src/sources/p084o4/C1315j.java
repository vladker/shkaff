package p084o4;

import java.util.Arrays;
import kotlin.jvm.internal.E;

/* JADX INFO: renamed from: o4.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1315j extends J0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6465a;
    private byte[] buffer;

    public C1315j(byte[] bufferWithData) {
        E.f(bufferWithData, "bufferWithData");
        this.buffer = bufferWithData;
        this.f6465a = bufferWithData.length;
        b(10);
    }

    @Override // p084o4.J0
    public final void b(int i5) {
        byte[] bArr = this.buffer;
        if (bArr.length < i5) {
            int length = bArr.length * 2;
            if (i5 < length) {
                i5 = length;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i5);
            E.e(bArrCopyOf, "copyOf(...)");
            this.buffer = bArrCopyOf;
        }
    }

    @Override // p084o4.J0
    /* JADX INFO: renamed from: build$kotlinx_serialization_core, reason: merged with bridge method [inline-methods] */
    public byte[] a() {
        byte[] bArrCopyOf = Arrays.copyOf(this.buffer, this.f6465a);
        E.e(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    @Override // p084o4.J0
    public final int d() {
        return this.f6465a;
    }

    public final void e(byte b) {
        b(d() + 1);
        byte[] bArr = this.buffer;
        int i5 = this.f6465a;
        this.f6465a = i5 + 1;
        bArr[i5] = b;
    }
}
