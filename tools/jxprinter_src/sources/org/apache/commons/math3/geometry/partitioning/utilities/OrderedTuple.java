package org.apache.commons.math3.geometry.partitioning.utilities;

import io.flutter.embedding.android.KeyboardMap;
import java.util.Arrays;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class OrderedTuple implements Comparable<OrderedTuple> {
    private static final long EXPONENT_MASK = 9218868437227405312L;
    private static final long IMPLICIT_ONE = 4503599627370496L;
    private static final long MANTISSA_MASK = 4503599627370495L;
    private static final long SIGN_MASK = Long.MIN_VALUE;
    private double[] components;
    private long[] encoding;
    private int lsb;
    private boolean nan;
    private boolean negInf;
    private int offset;
    private boolean posInf;

    public OrderedTuple(double... dArr) {
        this.components = (double[]) dArr.clone();
        this.lsb = Integer.MAX_VALUE;
        this.posInf = false;
        this.negInf = false;
        this.nan = false;
        int iMax = Integer.MIN_VALUE;
        for (int i5 = 0; i5 < dArr.length; i5++) {
            if (Double.isInfinite(dArr[i5])) {
                if (dArr[i5] < 0.0d) {
                    this.negInf = true;
                } else {
                    this.posInf = true;
                }
            } else if (Double.isNaN(dArr[i5])) {
                this.nan = true;
            } else {
                long jDoubleToLongBits = Double.doubleToLongBits(dArr[i5]);
                long jMantissa = mantissa(jDoubleToLongBits);
                if (jMantissa != 0) {
                    int iExponent = exponent(jDoubleToLongBits);
                    iMax = FastMath.max(iMax, computeMSB(jMantissa) + iExponent);
                    this.lsb = FastMath.min(this.lsb, iExponent + computeLSB(jMantissa));
                }
            }
        }
        if (this.posInf && this.negInf) {
            this.posInf = false;
            this.negInf = false;
            this.nan = true;
        }
        if (this.lsb <= iMax) {
            encode(iMax + 16);
        } else {
            this.encoding = new long[]{0};
        }
    }

    private static int computeLSB(long j6) {
        long j7 = -4294967296L;
        int i5 = 32;
        int i6 = 0;
        while (i5 != 0) {
            if ((j6 & j7) == j6) {
                i6 |= i5;
                j6 >>= i5;
            }
            i5 >>= 1;
            j7 >>= i5;
        }
        return i6;
    }

    private static int computeMSB(long j6) {
        long j7 = KeyboardMap.kValueMask;
        int i5 = 32;
        int i6 = 0;
        while (i5 != 0) {
            if ((j6 & j7) != j6) {
                i6 |= i5;
                j6 >>= i5;
            }
            i5 >>= 1;
            j7 >>= i5;
        }
        return i6;
    }

    private void encode(int i5) {
        int i6 = i5 + 31;
        int i7 = i6 - (i6 % 32);
        this.offset = i7;
        long[] jArr = this.encoding;
        if (jArr != null && jArr.length == 1 && jArr[0] == 0) {
            return;
        }
        this.encoding = new long[this.components.length * ((((i7 + 1) - this.lsb) + 62) / 63)];
        long j6 = 0;
        int i8 = 0;
        int i9 = 62;
        while (i8 < this.encoding.length) {
            for (int i10 = 0; i10 < this.components.length; i10++) {
                if (getBit(i10, i7) != 0) {
                    j6 |= 1 << i9;
                }
                int i11 = i9 - 1;
                if (i9 == 0) {
                    this.encoding[i8] = j6;
                    j6 = 0;
                    i9 = 62;
                    i8++;
                } else {
                    i9 = i11;
                }
            }
            i7--;
        }
    }

    private static int exponent(long j6) {
        return ((int) ((j6 & EXPONENT_MASK) >> 52)) - 1075;
    }

    private int getBit(int i5, int i6) {
        int i7;
        long jDoubleToLongBits = Double.doubleToLongBits(this.components[i5]);
        int iExponent = exponent(jDoubleToLongBits);
        if (i6 < iExponent || i6 > (i7 = this.offset)) {
            return 0;
        }
        if (i6 == i7) {
            return sign(jDoubleToLongBits) == 0 ? 1 : 0;
        }
        if (i6 > iExponent + 52) {
            return sign(jDoubleToLongBits) == 0 ? 0 : 1;
        }
        long jSign = sign(jDoubleToLongBits);
        long jMantissa = mantissa(jDoubleToLongBits);
        if (jSign != 0) {
            jMantissa = -jMantissa;
        }
        return (int) ((jMantissa >> (i6 - iExponent)) & 1);
    }

    private static long mantissa(long j6) {
        return (EXPONENT_MASK & j6) == 0 ? (j6 & 4503599627370495L) << 1 : (j6 & 4503599627370495L) | 4503599627370496L;
    }

    private static long sign(long j6) {
        return j6 & SIGN_MASK;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OrderedTuple) && compareTo((OrderedTuple) obj) == 0;
    }

    public double[] getComponents() {
        return (double[]) this.components.clone();
    }

    public int hashCode() {
        return (((((((((Arrays.hashCode(this.components) * 37) + this.offset) * 37) + this.lsb) * 37) + (this.posInf ? 97 : 71)) * 37) + (this.negInf ? 97 : 71)) * 37) + (this.nan ? 97 : 71);
    }

    @Override // java.lang.Comparable
    public int compareTo(OrderedTuple orderedTuple) {
        double[] dArr = this.components;
        int length = dArr.length;
        double[] dArr2 = orderedTuple.components;
        if (length != dArr2.length) {
            return dArr.length - dArr2.length;
        }
        if (this.nan) {
            return 1;
        }
        if (orderedTuple.nan || this.negInf || orderedTuple.posInf) {
            return -1;
        }
        if (this.posInf || orderedTuple.negInf) {
            return 1;
        }
        int i5 = this.offset;
        int i6 = orderedTuple.offset;
        if (i5 < i6) {
            encode(i6);
        } else if (i5 > i6) {
            orderedTuple.encode(i5);
        }
        int iMin = FastMath.min(this.encoding.length, orderedTuple.encoding.length);
        for (int i7 = 0; i7 < iMin; i7++) {
            long j6 = this.encoding[i7];
            long j7 = orderedTuple.encoding[i7];
            if (j6 < j7) {
                return -1;
            }
            if (j6 > j7) {
                return 1;
            }
        }
        long[] jArr = this.encoding;
        int length2 = jArr.length;
        long[] jArr2 = orderedTuple.encoding;
        if (length2 < jArr2.length) {
            return -1;
        }
        return jArr.length > jArr2.length ? 1 : 0;
    }
}
