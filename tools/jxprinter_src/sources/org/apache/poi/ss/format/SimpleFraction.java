package org.apache.poi.ss.format;

import A3.AbstractC0157z;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SimpleFraction {
    private final int denominator;
    private final int numerator;

    public SimpleFraction(int i5, int i6) {
        this.numerator = i5;
        this.denominator = i6;
    }

    public static SimpleFraction buildFractionExactDenominator(double d, int i5) {
        return new SimpleFraction((int) Math.round(d * ((double) i5)), i5);
    }

    public static SimpleFraction buildFractionMaxDenominator(double d, int i5) {
        return buildFractionMaxDenominator(d, 0.0d, i5, 100);
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    private static SimpleFraction buildFractionMaxDenominator(double d, double d6, int i5, int i6) {
        boolean z6;
        long jFloor = (long) Math.floor(d);
        if (jFloor > 2147483647L) {
            StringBuilder sb = new StringBuilder("Overflow trying to convert ");
            sb.append(d);
            sb.append(" to fraction (");
            throw new IllegalArgumentException(AbstractC0157z.r(sb, jFloor, "/1)"));
        }
        int i7 = 1;
        if (Math.abs(jFloor - d) < d6) {
            return new SimpleFraction((int) jFloor, 1);
        }
        int i8 = 0;
        double d7 = d;
        long j6 = 1;
        long j7 = 0;
        long j8 = jFloor;
        boolean z7 = false;
        long j9 = 1;
        while (true) {
            i8 += i7;
            long j10 = j8;
            double d8 = 1.0d / (d7 - jFloor);
            long jFloor2 = (long) Math.floor(d8);
            long j11 = jFloor;
            long j12 = (jFloor2 * j10) + j9;
            long j13 = (jFloor2 * j6) + j7;
            if (d6 != 0.0d || i5 <= 0) {
                z6 = z7;
            } else {
                z6 = z7;
                long j14 = i5;
                if (Math.abs(j13) > j14 && Math.abs(j6) < j14) {
                    return new SimpleFraction((int) j10, (int) j6);
                }
            }
            long j15 = j10;
            if (j12 > 2147483647L || j13 > 2147483647L) {
                throw new RuntimeException("Overflow trying to convert " + d + " to fraction (" + j12 + PackagingURIHelper.FORWARD_SLASH_STRING + j13 + ")");
            }
            long j16 = j6;
            double d9 = j12 / j13;
            if (i8 >= i6 || Math.abs(d9 - d) <= d6 || j13 >= i5) {
                j6 = j16;
                z6 = true;
            } else {
                j6 = j13;
                j9 = j15;
                j7 = j16;
                d7 = d8;
                j11 = jFloor2;
                j15 = j12;
            }
            if (z6) {
                if (i8 < i6) {
                    return j13 < ((long) i5) ? new SimpleFraction((int) j12, (int) j13) : new SimpleFraction((int) j15, (int) j6);
                }
                throw new RuntimeException("Unable to convert " + d + " to fraction after " + i6 + " iterations");
            }
            j8 = j15;
            jFloor = j11;
            z7 = z6;
            i7 = 1;
        }
    }
}
