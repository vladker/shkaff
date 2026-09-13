package A3;

import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class C0 {
    /* JADX INFO: renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m74partitionnroSd4(long[] jArr, int i5, int i6) {
        long jM1247constructorimpl = p147z3.J.m1247constructorimpl(jArr[(i5 + i6) / 2]);
        while (i5 <= i6) {
            while (Long.compareUnsigned(p147z3.J.m1247constructorimpl(jArr[i5]), jM1247constructorimpl) < 0) {
                i5++;
            }
            while (Long.compareUnsigned(p147z3.J.m1247constructorimpl(jArr[i6]), jM1247constructorimpl) > 0) {
                i6--;
            }
            if (i5 <= i6) {
                long jM1247constructorimpl2 = p147z3.J.m1247constructorimpl(jArr[i5]);
                jArr[i5] = p147z3.J.m1247constructorimpl(jArr[i6]);
                jArr[i6] = jM1247constructorimpl2;
                i5++;
                i6--;
            }
        }
        return i5;
    }

    /* JADX INFO: renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m75partition4UcCI2c(byte[] bArr, int i5, int i6) {
        int i7;
        byte bM1131constructorimpl = p147z3.D.m1131constructorimpl(bArr[(i5 + i6) / 2]);
        while (i5 <= i6) {
            while (true) {
                int iM1131constructorimpl = p147z3.D.m1131constructorimpl(bArr[i5]) & UnsignedBytes.MAX_VALUE;
                i7 = bM1131constructorimpl & UnsignedBytes.MAX_VALUE;
                if (kotlin.jvm.internal.E.h(iM1131constructorimpl, i7) >= 0) {
                    break;
                }
                i5++;
            }
            while (kotlin.jvm.internal.E.h(p147z3.D.m1131constructorimpl(bArr[i6]) & UnsignedBytes.MAX_VALUE, i7) > 0) {
                i6--;
            }
            if (i5 <= i6) {
                byte bM1131constructorimpl2 = p147z3.D.m1131constructorimpl(bArr[i5]);
                bArr[i5] = p147z3.D.m1131constructorimpl(bArr[i6]);
                bArr[i6] = bM1131constructorimpl2;
                i5++;
                i6--;
            }
        }
        return i5;
    }

    /* JADX INFO: renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m76partitionAa5vz7o(short[] sArr, int i5, int i6) {
        int i7;
        short sM1306constructorimpl = p147z3.N.m1306constructorimpl(sArr[(i5 + i6) / 2]);
        while (i5 <= i6) {
            while (true) {
                i7 = sM1306constructorimpl & 65535;
                if (kotlin.jvm.internal.E.h(p147z3.N.m1306constructorimpl(sArr[i5]) & 65535, i7) >= 0) {
                    break;
                }
                i5++;
            }
            while (kotlin.jvm.internal.E.h(p147z3.N.m1306constructorimpl(sArr[i6]) & 65535, i7) > 0) {
                i6--;
            }
            if (i5 <= i6) {
                short sM1306constructorimpl2 = p147z3.N.m1306constructorimpl(sArr[i5]);
                sArr[i5] = p147z3.N.m1306constructorimpl(sArr[i6]);
                sArr[i6] = sM1306constructorimpl2;
                i5++;
                i6--;
            }
        }
        return i5;
    }

    /* JADX INFO: renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m77partitionoBK06Vg(int[] iArr, int i5, int i6) {
        int iM1188constructorimpl = p147z3.G.m1188constructorimpl(iArr[(i5 + i6) / 2]);
        while (i5 <= i6) {
            while (Integer.compareUnsigned(p147z3.G.m1188constructorimpl(iArr[i5]), iM1188constructorimpl) < 0) {
                i5++;
            }
            while (Integer.compareUnsigned(p147z3.G.m1188constructorimpl(iArr[i6]), iM1188constructorimpl) > 0) {
                i6--;
            }
            if (i5 <= i6) {
                int iM1188constructorimpl2 = p147z3.G.m1188constructorimpl(iArr[i5]);
                iArr[i5] = p147z3.G.m1188constructorimpl(iArr[i6]);
                iArr[i6] = iM1188constructorimpl2;
                i5++;
                i6--;
            }
        }
        return i5;
    }

    /* JADX INFO: renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m78quickSortnroSd4(long[] jArr, int i5, int i6) {
        int iM74partitionnroSd4 = m74partitionnroSd4(jArr, i5, i6);
        int i7 = iM74partitionnroSd4 - 1;
        if (i5 < i7) {
            m78quickSortnroSd4(jArr, i5, i7);
        }
        if (iM74partitionnroSd4 < i6) {
            m78quickSortnroSd4(jArr, iM74partitionnroSd4, i6);
        }
    }

    /* JADX INFO: renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m79quickSort4UcCI2c(byte[] bArr, int i5, int i6) {
        int iM75partition4UcCI2c = m75partition4UcCI2c(bArr, i5, i6);
        int i7 = iM75partition4UcCI2c - 1;
        if (i5 < i7) {
            m79quickSort4UcCI2c(bArr, i5, i7);
        }
        if (iM75partition4UcCI2c < i6) {
            m79quickSort4UcCI2c(bArr, iM75partition4UcCI2c, i6);
        }
    }

    /* JADX INFO: renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m80quickSortAa5vz7o(short[] sArr, int i5, int i6) {
        int iM76partitionAa5vz7o = m76partitionAa5vz7o(sArr, i5, i6);
        int i7 = iM76partitionAa5vz7o - 1;
        if (i5 < i7) {
            m80quickSortAa5vz7o(sArr, i5, i7);
        }
        if (iM76partitionAa5vz7o < i6) {
            m80quickSortAa5vz7o(sArr, iM76partitionAa5vz7o, i6);
        }
    }

    /* JADX INFO: renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m81quickSortoBK06Vg(int[] iArr, int i5, int i6) {
        int iM77partitionoBK06Vg = m77partitionoBK06Vg(iArr, i5, i6);
        int i7 = iM77partitionoBK06Vg - 1;
        if (i5 < i7) {
            m81quickSortoBK06Vg(iArr, i5, i7);
        }
        if (iM77partitionoBK06Vg < i6) {
            m81quickSortoBK06Vg(iArr, iM77partitionoBK06Vg, i6);
        }
    }

    /* JADX INFO: renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m82sortArraynroSd4(long[] array, int i5, int i6) {
        kotlin.jvm.internal.E.f(array, "array");
        m78quickSortnroSd4(array, i5, i6 - 1);
    }

    /* JADX INFO: renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m83sortArray4UcCI2c(byte[] array, int i5, int i6) {
        kotlin.jvm.internal.E.f(array, "array");
        m79quickSort4UcCI2c(array, i5, i6 - 1);
    }

    /* JADX INFO: renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m84sortArrayAa5vz7o(short[] array, int i5, int i6) {
        kotlin.jvm.internal.E.f(array, "array");
        m80quickSortAa5vz7o(array, i5, i6 - 1);
    }

    /* JADX INFO: renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m85sortArrayoBK06Vg(int[] array, int i5, int i6) {
        kotlin.jvm.internal.E.f(array, "array");
        m81quickSortoBK06Vg(array, i5, i6 - 1);
    }
}
