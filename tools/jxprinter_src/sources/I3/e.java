package I3;

import p147z3.G;
import p147z3.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    /* JADX INFO: renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m814getProgressionLastElement7ftBX0g(long j6, long j7, long j8) {
        if (j8 > 0) {
            if (Long.compareUnsigned(j6, j7) < 0) {
                long jM1247constructorimpl = J.m1247constructorimpl(j8);
                long jRemainderUnsigned = Long.remainderUnsigned(j7, jM1247constructorimpl);
                long jRemainderUnsigned2 = Long.remainderUnsigned(j6, jM1247constructorimpl);
                int iCompareUnsigned = Long.compareUnsigned(jRemainderUnsigned, jRemainderUnsigned2);
                long jM1247constructorimpl2 = J.m1247constructorimpl(jRemainderUnsigned - jRemainderUnsigned2);
                if (iCompareUnsigned < 0) {
                    jM1247constructorimpl2 = J.m1247constructorimpl(jM1247constructorimpl2 + jM1247constructorimpl);
                }
                return J.m1247constructorimpl(j7 - jM1247constructorimpl2);
            }
        } else {
            if (j8 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (Long.compareUnsigned(j6, j7) > 0) {
                long jM1247constructorimpl3 = J.m1247constructorimpl(-j8);
                long jRemainderUnsigned3 = Long.remainderUnsigned(j6, jM1247constructorimpl3);
                long jRemainderUnsigned4 = Long.remainderUnsigned(j7, jM1247constructorimpl3);
                int iCompareUnsigned2 = Long.compareUnsigned(jRemainderUnsigned3, jRemainderUnsigned4);
                long jM1247constructorimpl4 = J.m1247constructorimpl(jRemainderUnsigned3 - jRemainderUnsigned4);
                if (iCompareUnsigned2 < 0) {
                    jM1247constructorimpl4 = J.m1247constructorimpl(jM1247constructorimpl4 + jM1247constructorimpl3);
                }
                return J.m1247constructorimpl(j7 + jM1247constructorimpl4);
            }
        }
        return j7;
    }

    /* JADX INFO: renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m815getProgressionLastElementNkh28Cs(int i5, int i6, int i7) {
        if (i7 > 0) {
            if (Integer.compareUnsigned(i5, i6) < 0) {
                int iM1188constructorimpl = G.m1188constructorimpl(i7);
                int iRemainderUnsigned = Integer.remainderUnsigned(i6, iM1188constructorimpl);
                int iRemainderUnsigned2 = Integer.remainderUnsigned(i5, iM1188constructorimpl);
                int iCompareUnsigned = Integer.compareUnsigned(iRemainderUnsigned, iRemainderUnsigned2);
                int iM1188constructorimpl2 = G.m1188constructorimpl(iRemainderUnsigned - iRemainderUnsigned2);
                if (iCompareUnsigned < 0) {
                    iM1188constructorimpl2 = G.m1188constructorimpl(iM1188constructorimpl2 + iM1188constructorimpl);
                }
                return G.m1188constructorimpl(i6 - iM1188constructorimpl2);
            }
        } else {
            if (i7 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (Integer.compareUnsigned(i5, i6) > 0) {
                int iM1188constructorimpl3 = G.m1188constructorimpl(-i7);
                int iRemainderUnsigned3 = Integer.remainderUnsigned(i5, iM1188constructorimpl3);
                int iRemainderUnsigned4 = Integer.remainderUnsigned(i6, iM1188constructorimpl3);
                int iCompareUnsigned2 = Integer.compareUnsigned(iRemainderUnsigned3, iRemainderUnsigned4);
                int iM1188constructorimpl4 = G.m1188constructorimpl(iRemainderUnsigned3 - iRemainderUnsigned4);
                if (iCompareUnsigned2 < 0) {
                    iM1188constructorimpl4 = G.m1188constructorimpl(iM1188constructorimpl4 + iM1188constructorimpl3);
                }
                return G.m1188constructorimpl(iM1188constructorimpl4 + i6);
            }
        }
        return i6;
    }
}
