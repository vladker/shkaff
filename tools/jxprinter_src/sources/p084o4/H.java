package p084o4;

import A3.C;
import O3.p;
import kotlin.jvm.internal.E;
import p072m4.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H {
    private static final G Companion = new G();
    private static final long[] EMPTY_HIGH_MARKS = new long[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6454a;
    private final r descriptor;
    private final long[] highMarksArray;
    private final p readIfAbsent;

    public H(r descriptor, p readIfAbsent) {
        E.f(descriptor, "descriptor");
        E.f(readIfAbsent, "readIfAbsent");
        this.descriptor = descriptor;
        this.readIfAbsent = readIfAbsent;
        int iB = descriptor.b();
        if (iB <= 64) {
            this.f6454a = iB != 64 ? (-1) << iB : 0L;
            this.highMarksArray = EMPTY_HIGH_MARKS;
            return;
        }
        this.f6454a = 0L;
        long[] jArr = new long[(iB - 1) >>> 6];
        if ((iB & 63) != 0) {
            jArr[C.getLastIndex(jArr)] = (-1) << iB;
        }
        this.highMarksArray = jArr;
    }

    public final void a(int i5) {
        if (i5 < 64) {
            this.f6454a = (1 << i5) | this.f6454a;
        } else {
            int i6 = (i5 >>> 6) - 1;
            long[] jArr = this.highMarksArray;
            jArr[i6] = (1 << (i5 & 63)) | jArr[i6];
        }
    }

    public final int b() {
        int iNumberOfTrailingZeros;
        int iB = this.descriptor.b();
        do {
            long j6 = this.f6454a;
            if (j6 == -1) {
                if (iB <= 64) {
                    return -1;
                }
                int length = this.highMarksArray.length;
                int i5 = 0;
                while (i5 < length) {
                    int i6 = i5 + 1;
                    int i7 = i6 * 64;
                    long j7 = this.highMarksArray[i5];
                    while (j7 != -1) {
                        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(~j7);
                        j7 |= 1 << iNumberOfTrailingZeros2;
                        int i8 = iNumberOfTrailingZeros2 + i7;
                        if (((Boolean) this.readIfAbsent.invoke(this.descriptor, Integer.valueOf(i8))).booleanValue()) {
                            this.highMarksArray[i5] = j7;
                            return i8;
                        }
                    }
                    this.highMarksArray[i5] = j7;
                    i5 = i6;
                }
                return -1;
            }
            iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j6);
            this.f6454a |= 1 << iNumberOfTrailingZeros;
        } while (!((Boolean) this.readIfAbsent.invoke(this.descriptor, Integer.valueOf(iNumberOfTrailingZeros))).booleanValue());
        return iNumberOfTrailingZeros;
    }
}
