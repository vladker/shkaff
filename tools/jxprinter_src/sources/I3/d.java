package I3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static final int getProgressionLastElement(int i5, int i6, int i7) {
        if (i7 > 0) {
            if (i5 < i6) {
                int i8 = i6 % i7;
                if (i8 < 0) {
                    i8 += i7;
                }
                int i9 = i5 % i7;
                if (i9 < 0) {
                    i9 += i7;
                }
                int i10 = (i8 - i9) % i7;
                if (i10 < 0) {
                    i10 += i7;
                }
                return i6 - i10;
            }
        } else {
            if (i7 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i5 > i6) {
                int i11 = -i7;
                int i12 = i5 % i11;
                if (i12 < 0) {
                    i12 += i11;
                }
                int i13 = i6 % i11;
                if (i13 < 0) {
                    i13 += i11;
                }
                int i14 = (i12 - i13) % i11;
                if (i14 < 0) {
                    i14 += i11;
                }
                return i14 + i6;
            }
        }
        return i6;
    }

    public static final long getProgressionLastElement(long j6, long j7, long j8) {
        if (j8 > 0) {
            if (j6 < j7) {
                long j9 = j7 % j8;
                if (j9 < 0) {
                    j9 += j8;
                }
                long j10 = j6 % j8;
                if (j10 < 0) {
                    j10 += j8;
                }
                long j11 = (j9 - j10) % j8;
                if (j11 < 0) {
                    j11 += j8;
                }
                return j7 - j11;
            }
        } else {
            if (j8 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (j6 > j7) {
                long j12 = -j8;
                long j13 = j6 % j12;
                if (j13 < 0) {
                    j13 += j12;
                }
                long j14 = j7 % j12;
                if (j14 < 0) {
                    j14 += j12;
                }
                long j15 = (j13 - j14) % j12;
                if (j15 < 0) {
                    j15 += j12;
                }
                return j7 + j15;
            }
        }
        return j7;
    }
}
