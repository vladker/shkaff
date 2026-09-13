package org.apache.commons.math3.util;

import androidx.collection.a;
import io.flutter.embedding.android.KeyboardMap;
import java.io.PrintStream;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FastMath {

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final double f6940E = 2.718281828459045d;
    static final int EXP_FRAC_TABLE_LEN = 1025;
    static final int EXP_INT_TABLE_LEN = 1500;
    static final int EXP_INT_TABLE_MAX_INDEX = 750;
    private static final double F_11_12 = 0.9166666666666666d;
    private static final double F_13_14 = 0.9285714285714286d;
    private static final double F_15_16 = 0.9375d;
    private static final double F_1_11 = 0.09090909090909091d;
    private static final double F_1_13 = 0.07692307692307693d;
    private static final double F_1_15 = 0.06666666666666667d;
    private static final double F_1_17 = 0.058823529411764705d;
    private static final double F_1_3 = 0.3333333333333333d;
    private static final double F_1_5 = 0.2d;
    private static final double F_1_7 = 0.14285714285714285d;
    private static final double F_1_9 = 0.1111111111111111d;
    private static final double F_5_6 = 0.8333333333333334d;
    private static final double F_9_10 = 0.9d;
    private static final long HEX_40000000 = 1073741824;
    private static final long IMPLICIT_HIGH_BIT = 4503599627370496L;
    private static final double LN_2_A = 0.6931470632553101d;
    private static final double LN_2_B = 1.1730463525082348E-7d;
    static final int LN_MANT_LEN = 1024;
    private static final long MASK_30BITS = -1073741824;
    private static final long MASK_DOUBLE_EXPONENT = 9218868437227405312L;
    private static final long MASK_DOUBLE_MANTISSA = 4503599627370495L;
    private static final int MASK_NON_SIGN_INT = Integer.MAX_VALUE;
    private static final long MASK_NON_SIGN_LONG = Long.MAX_VALUE;
    public static final double PI = 3.141592653589793d;
    private static final boolean RECOMPUTE_TABLES_AT_RUNTIME = false;
    private static final int SINE_TABLE_LEN = 14;
    private static final double TWO_POWER_52 = 4.503599627370496E15d;
    private static final double LOG_MAX_VALUE = StrictMath.log(Double.MAX_VALUE);
    private static final double[][] LN_QUICK_COEF = {new double[]{1.0d, 5.669184079525E-24d}, new double[]{-0.25d, -0.25d}, new double[]{0.3333333134651184d, 1.986821492305628E-8d}, new double[]{-0.25d, -6.663542893624021E-14d}, new double[]{0.19999998807907104d, 1.1921056801463227E-8d}, new double[]{-0.1666666567325592d, -7.800414592973399E-9d}, new double[]{0.1428571343421936d, 5.650007086920087E-9d}, new double[]{-0.12502530217170715d, -7.44321345601866E-11d}, new double[]{0.11113807559013367d, 9.219544613762692E-9d}};
    private static final double[][] LN_HI_PREC_COEF = {new double[]{1.0d, -6.032174644509064E-23d}, new double[]{-0.25d, -0.25d}, new double[]{0.3333333134651184d, 1.9868161777724352E-8d}, new double[]{-0.2499999701976776d, -2.957007209750105E-8d}, new double[]{0.19999954104423523d, 1.5830993332061267E-10d}, new double[]{-0.16624879837036133d, -2.6033824355191673E-8d}};
    private static final double[] SINE_TABLE_A = {0.0d, 0.1246747374534607d, 0.24740394949913025d, 0.366272509098053d, 0.4794255495071411d, 0.5850973129272461d, 0.6816387176513672d, 0.7675435543060303d, 0.8414709568023682d, 0.902267575263977d, 0.9489846229553223d, 0.9808930158615112d, 0.9974949359893799d, 0.9985313415527344d};
    private static final double[] SINE_TABLE_B = {0.0d, -4.068233003401932E-9d, 9.755392680573412E-9d, 1.9987994582857286E-8d, -1.0902938113007961E-8d, -3.9986783938944604E-8d, 4.23719669792332E-8d, -5.207000323380292E-8d, 2.800552834259E-8d, 1.883511811213715E-8d, -3.5997360512765566E-9d, 4.116164446561962E-8d, 5.0614674548127384E-8d, -1.0129027912496858E-9d};
    private static final double[] COSINE_TABLE_A = {1.0d, 0.9921976327896118d, 0.9689123630523682d, 0.9305076599121094d, 0.8775825500488281d, 0.8109631538391113d, 0.7316888570785522d, 0.6409968137741089d, 0.5403022766113281d, 0.4311765432357788d, 0.3153223395347595d, 0.19454771280288696d, 0.07073719799518585d, -0.05417713522911072d};
    private static final double[] COSINE_TABLE_B = {0.0d, 3.4439717236742845E-8d, 5.865827662008209E-8d, -3.7999795083850525E-8d, 1.184154459111628E-8d, -3.43338934259355E-8d, 1.1795268640216787E-8d, 4.438921624363781E-8d, 2.925681159240093E-8d, -2.6437112632041807E-8d, 2.2860509143963117E-8d, -4.813899778443457E-9d, 3.6725170580355583E-9d, 2.0217439756338078E-10d};
    private static final double[] TANGENT_TABLE_A = {0.0d, 0.1256551444530487d, 0.25534194707870483d, 0.3936265707015991d, 0.5463024377822876d, 0.7214844226837158d, 0.9315965175628662d, 1.1974215507507324d, 1.5574076175689697d, 2.092571258544922d, 3.0095696449279785d, 5.041914939880371d, 14.101419448852539d, -18.430862426757812d};
    private static final double[] TANGENT_TABLE_B = {0.0d, -7.877917738262007E-9d, -2.5857668567479893E-8d, 5.2240336371356666E-9d, 5.206150291559893E-8d, 1.8307188599677033E-8d, -5.7618793749770706E-8d, 7.848361555046424E-8d, 1.0708593250394448E-7d, 1.7827257129423813E-8d, 2.893485277253286E-8d, 3.1660099222737955E-7d, 4.983191803254889E-7d, -3.356118100840571E-7d};
    private static final long[] RECIP_2PI = {2935890503282001226L, 9154082963658192752L, 3952090531849364496L, 9193070505571053912L, 7910884519577875640L, 113236205062349959L, 4577762542105553359L, -5034868814120038111L, 4208363204685324176L, 5648769086999809661L, 2819561105158720014L, -4035746434778044925L, -302932621132653753L, -2644281811660520851L, -3183605296591799669L, 6722166367014452318L, -3512299194304650054L, -7278142539171889152L};
    private static final long[] PI_O_4_BITS = {-3958705157555305932L, -4267615245585081135L};
    private static final double F_1_4 = 0.25d;
    private static final double F_1_2 = 0.5d;
    private static final double F_3_4 = 0.75d;
    private static final double F_7_8 = 0.875d;
    private static final double[] EIGHTHS = {0.0d, 0.125d, F_1_4, 0.375d, F_1_2, 0.625d, F_3_4, F_7_8, 1.0d, 1.125d, 1.25d, 1.375d, 1.5d, 1.625d};
    private static final double[] CBRTTWO = {0.6299605249474366d, 0.7937005259840998d, 1.0d, 1.2599210498948732d, 1.5874010519681994d};

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CodyWaite {
        private final int finalK;
        private final double finalRemA;
        private final double finalRemB;

        public CodyWaite(double d) {
            int i5 = (int) (0.6366197723675814d * d);
            while (true) {
                double d6 = -i5;
                double d7 = 1.570796251296997d * d6;
                double d8 = d + d7;
                double d9 = 7.549789948768648E-8d * d6;
                double d10 = d9 + d8;
                double d11 = (-((d8 - d) - d7)) + (-((d10 - d8) - d9));
                double d12 = d6 * 6.123233995736766E-17d;
                double d13 = d12 + d10;
                double d14 = d11 + (-((d13 - d10) - d12));
                if (d13 > 0.0d) {
                    this.finalK = i5;
                    this.finalRemA = d13;
                    this.finalRemB = d14;
                    return;
                }
                i5--;
            }
        }

        public int getK() {
            return this.finalK;
        }

        public double getRemA() {
            return this.finalRemA;
        }

        public double getRemB() {
            return this.finalRemB;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ExpFracTable {
        private static final double[] EXP_FRAC_TABLE_A = FastMathLiteralArrays.loadExpFracA();
        private static final double[] EXP_FRAC_TABLE_B = FastMathLiteralArrays.loadExpFracB();

        private ExpFracTable() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ExpIntTable {
        private static final double[] EXP_INT_TABLE_A = FastMathLiteralArrays.loadExpIntA();
        private static final double[] EXP_INT_TABLE_B = FastMathLiteralArrays.loadExpIntB();

        private ExpIntTable() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class lnMant {
        private static final double[][] LN_MANT = FastMathLiteralArrays.loadLnMant();

        private lnMant() {
        }
    }

    private FastMath() {
    }

    public static double IEEEremainder(double d, double d6) {
        return StrictMath.IEEEremainder(d, d6);
    }

    public static int abs(int i5) {
        int i6 = i5 >>> 31;
        return (i5 ^ ((~i6) + 1)) + i6;
    }

    public static double acos(double d) {
        if (d != d || d > 1.0d || d < -1.0d) {
            return Double.NaN;
        }
        if (d == -1.0d) {
            return 3.141592653589793d;
        }
        if (d == 1.0d) {
            return 0.0d;
        }
        if (d == 0.0d) {
            return 1.5707963267948966d;
        }
        double d6 = d * 1.073741824E9d;
        double d7 = (d + d6) - d6;
        double d8 = d - d7;
        double d9 = -(d7 * d7);
        double d10 = -((d8 * d8) + (d7 * d8 * 2.0d));
        double d11 = d9 + 1.0d;
        double d12 = -((d11 - 1.0d) - d9);
        double d13 = d11 + d10;
        double d14 = d12 + (-((d13 - d11) - d10));
        double dSqrt = sqrt(d13);
        double d15 = 1.073741824E9d * dSqrt;
        double d16 = (dSqrt + d15) - d15;
        double d17 = dSqrt - d16;
        double d18 = dSqrt * 2.0d;
        double d19 = (d14 / d18) + ((((d13 - (d16 * d16)) - ((d16 * 2.0d) * d17)) - (d17 * d17)) / d18) + d17;
        double d20 = d16 + d19;
        double d21 = -((d20 - d16) - d19);
        double d22 = d20 / d;
        if (Double.isInfinite(d22)) {
            return 1.5707963267948966d;
        }
        double dDoubleHighPart = doubleHighPart(d22);
        double d23 = d22 - dDoubleHighPart;
        double d24 = (d21 / d) + (((((d20 - (dDoubleHighPart * d7)) - (dDoubleHighPart * d8)) - (d7 * d23)) - (d8 * d23)) / d) + d23;
        double d25 = dDoubleHighPart + d24;
        return atan(d25, -((d25 - dDoubleHighPart) - d24), d < 0.0d);
    }

    public static double acosh(double d) {
        return log(sqrt((d * d) - 1.0d) + d);
    }

    public static int addExact(int i5, int i6) {
        int i7 = i5 + i6;
        if ((i5 ^ i6) < 0 || (i7 ^ i6) >= 0) {
            return i7;
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static double asin(double d) {
        if (d != d || d > 1.0d || d < -1.0d) {
            return Double.NaN;
        }
        if (d == 1.0d) {
            return 1.5707963267948966d;
        }
        if (d == -1.0d) {
            return -1.5707963267948966d;
        }
        if (d == 0.0d) {
            return d;
        }
        double d6 = d * 1.073741824E9d;
        double d7 = (d + d6) - d6;
        double d8 = d - d7;
        double d9 = d7 * d7;
        double d10 = (d8 * d8) + (d7 * d8 * 2.0d);
        double d11 = -d9;
        double d12 = -d10;
        double d13 = d11 + 1.0d;
        double d14 = -((d13 - 1.0d) - d11);
        double d15 = d13 + d12;
        double d16 = d14 + (-((d15 - d13) - d12));
        double dSqrt = sqrt(d15);
        double d17 = dSqrt * 1.073741824E9d;
        double d18 = (dSqrt + d17) - d17;
        double d19 = dSqrt - d18;
        double d20 = 2.0d * dSqrt;
        double d21 = ((((d15 - (d18 * d18)) - ((d18 * 2.0d) * d19)) - (d19 * d19)) / d20) + d19;
        double d22 = d16 / d20;
        double d23 = d / dSqrt;
        double d24 = 1.073741824E9d * d23;
        double d25 = (d23 + d24) - d24;
        double d26 = d23 - d25;
        double d27 = ((((-d) * d22) / dSqrt) / dSqrt) + (((((d - (d25 * d18)) - (d25 * d21)) - (d18 * d26)) - (d21 * d26)) / dSqrt) + d26;
        double d28 = d25 + d27;
        return atan(d28, -((d28 - d25) - d27), false);
    }

    public static double asinh(double d) {
        boolean z6;
        double d6;
        double d7;
        double d8;
        double dLog;
        double d9 = d;
        if (d9 < 0.0d) {
            d9 = -d9;
            z6 = true;
        } else {
            z6 = false;
        }
        if (d9 > 0.167d) {
            dLog = log(sqrt((d9 * d9) + 1.0d) + d9);
        } else {
            double d10 = d9 * d9;
            if (d9 > 0.097d) {
                d8 = (F_1_13 - (((F_1_15 - ((F_1_17 * d10) * F_15_16)) * d10) * F_13_14)) * d10;
            } else {
                if (d9 > 0.036d) {
                    d8 = F_1_13 * d10;
                } else if (d9 > 0.0036d) {
                    d7 = F_1_9 * d10;
                    d6 = (F_1_5 - (((F_1_7 - (d7 * F_7_8)) * d10) * F_5_6)) * d10;
                } else {
                    d6 = F_1_5 * d10;
                }
                dLog = d9 * (1.0d - (((F_1_3 - (d6 * F_3_4)) * d10) * F_1_2));
            }
            d7 = (F_1_9 - (((F_1_11 - (d8 * F_11_12)) * d10) * F_9_10)) * d10;
            d6 = (F_1_5 - (((F_1_7 - (d7 * F_7_8)) * d10) * F_5_6)) * d10;
            dLog = d9 * (1.0d - (((F_1_3 - (d6 * F_3_4)) * d10) * F_1_2));
        }
        return z6 ? -dLog : dLog;
    }

    public static double atan(double d) {
        return atan(d, 0.0d, false);
    }

    public static double atan2(double d, double d6) {
        if (d6 != d6 || d != d) {
            return Double.NaN;
        }
        if (d == 0.0d) {
            double d7 = d6 * d;
            double d8 = 1.0d / d6;
            double d9 = 1.0d / d;
            if (d8 == 0.0d) {
                return d6 > 0.0d ? d : copySign(3.141592653589793d, d);
            }
            if (d6 < 0.0d || d8 < 0.0d) {
                return (d < 0.0d || d9 < 0.0d) ? -3.141592653589793d : 3.141592653589793d;
            }
            return d7;
        }
        if (d == Double.POSITIVE_INFINITY) {
            if (d6 == Double.POSITIVE_INFINITY) {
                return 0.7853981633974483d;
            }
            return d6 == Double.NEGATIVE_INFINITY ? 2.356194490192345d : 1.5707963267948966d;
        }
        if (d == Double.NEGATIVE_INFINITY) {
            if (d6 == Double.POSITIVE_INFINITY) {
                return -0.7853981633974483d;
            }
            return d6 == Double.NEGATIVE_INFINITY ? -2.356194490192345d : -1.5707963267948966d;
        }
        if (d6 == Double.POSITIVE_INFINITY) {
            if (d <= 0.0d) {
                double d10 = 1.0d / d;
                if (d10 <= 0.0d) {
                    if (d < 0.0d || d10 < 0.0d) {
                        return -0.0d;
                    }
                }
            }
            return 0.0d;
        }
        if (d6 == Double.NEGATIVE_INFINITY) {
            if (d <= 0.0d) {
                double d11 = 1.0d / d;
                if (d11 <= 0.0d) {
                    if (d < 0.0d || d11 < 0.0d) {
                        return -3.141592653589793d;
                    }
                }
            }
            return 3.141592653589793d;
        }
        if (d6 == 0.0d) {
            if (d <= 0.0d) {
                double d12 = 1.0d / d;
                if (d12 <= 0.0d) {
                    if (d < 0.0d || d12 < 0.0d) {
                        return -1.5707963267948966d;
                    }
                }
            }
            return 1.5707963267948966d;
        }
        double d13 = d / d6;
        if (Double.isInfinite(d13)) {
            return atan(d13, 0.0d, d6 < 0.0d);
        }
        double dDoubleHighPart = doubleHighPart(d13);
        double d14 = d13 - dDoubleHighPart;
        double dDoubleHighPart2 = doubleHighPart(d6);
        double d15 = d6 - dDoubleHighPart2;
        double d16 = (((((d - (dDoubleHighPart * dDoubleHighPart2)) - (dDoubleHighPart * d15)) - (dDoubleHighPart2 * d14)) - (d15 * d14)) / d6) + d14;
        double dCopySign = dDoubleHighPart + d16;
        double d17 = -((dCopySign - dDoubleHighPart) - d16);
        if (dCopySign == 0.0d) {
            dCopySign = copySign(0.0d, d);
        }
        return atan(dCopySign, d17, d6 < 0.0d);
    }

    public static double atanh(double d) {
        boolean z6;
        double dLog;
        double d6 = d;
        if (d6 < 0.0d) {
            d6 = -d6;
            z6 = true;
        } else {
            z6 = false;
        }
        if (d6 > 0.15d) {
            dLog = log((d6 + 1.0d) / (1.0d - d6)) * F_1_2;
        } else {
            double d7 = d6 * d6;
            if (d6 > 0.087d) {
                dLog = d6 * ((((((((((((((((F_1_17 * d7) + F_1_15) * d7) + F_1_13) * d7) + F_1_11) * d7) + F_1_9) * d7) + F_1_7) * d7) + F_1_5) * d7) + F_1_3) * d7) + 1.0d);
            } else if (d6 > 0.031d) {
                dLog = d6 * ((((((((((((F_1_13 * d7) + F_1_11) * d7) + F_1_9) * d7) + F_1_7) * d7) + F_1_5) * d7) + F_1_3) * d7) + 1.0d);
            } else {
                dLog = d6 > 0.003d ? d6 * ((((((((F_1_9 * d7) + F_1_7) * d7) + F_1_5) * d7) + F_1_3) * d7) + 1.0d) : d6 * ((((F_1_5 * d7) + F_1_3) * d7) + 1.0d);
            }
        }
        return z6 ? -dLog : dLog;
    }

    public static double cbrt(double d) {
        boolean z6;
        int i5;
        long jDoubleToRawLongBits;
        double d6;
        long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(d);
        int i6 = ((int) ((jDoubleToRawLongBits2 >> 52) & 2047)) - 1023;
        if (i6 != -1023) {
            z6 = false;
            i5 = i6;
            jDoubleToRawLongBits = jDoubleToRawLongBits2;
            d6 = d;
        } else {
            if (d == 0.0d) {
                return d;
            }
            d6 = 1.8014398509481984E16d * d;
            jDoubleToRawLongBits = Double.doubleToRawLongBits(d6);
            i5 = ((int) (2047 & (jDoubleToRawLongBits >> 52))) - 1023;
            z6 = true;
        }
        if (i5 == 1024) {
            return d6;
        }
        double dLongBitsToDouble = Double.longBitsToDouble((Long.MIN_VALUE & jDoubleToRawLongBits) | (((long) (((i5 / 3) + IEEEDouble.EXPONENT_BIAS) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE)) << 52));
        double dLongBitsToDouble2 = Double.longBitsToDouble((jDoubleToRawLongBits & 4503599627370495L) | 4607182418800017408L);
        double d7 = (((((((((-0.010714690733195933d) * dLongBitsToDouble2) + 0.0875862700108075d) * dLongBitsToDouble2) - 0.3058015757857271d) * dLongBitsToDouble2) + 0.7249995199969751d) * dLongBitsToDouble2) + 0.5039018405998233d) * CBRTTWO[(i5 % 3) + 2];
        double d8 = d6 / ((dLongBitsToDouble * dLongBitsToDouble) * dLongBitsToDouble);
        double d9 = ((d8 - ((d7 * d7) * d7)) / ((d7 * 3.0d) * d7)) + d7;
        double d10 = ((d8 - ((d9 * d9) * d9)) / ((d9 * 3.0d) * d9)) + d9;
        double d11 = d10 * 1.073741824E9d;
        double d12 = (d10 + d11) - d11;
        double d13 = d10 - d12;
        double d14 = d12 * d12;
        double d15 = 1.073741824E9d * d14;
        double d16 = (d14 + d15) - d15;
        double d17 = (d14 - d16) + (d13 * d13) + (d12 * d13 * 2.0d);
        double d18 = (d17 * d13) + (d12 * d17) + (d16 * d13);
        double d19 = d16 * d12;
        double d20 = d8 - d19;
        double d21 = (((((-((d20 - d8) + d19)) - d18) + d20) / ((3.0d * d10) * d10)) + d10) * dLongBitsToDouble;
        return z6 ? d21 * 3.814697265625E-6d : d21;
    }

    public static double ceil(double d) {
        if (d != d) {
            return d;
        }
        double dFloor = floor(d);
        if (dFloor == d) {
            return dFloor;
        }
        double d6 = dFloor + 1.0d;
        return d6 == 0.0d ? d * d6 : d6;
    }

    public static double copySign(double d, double d6) {
        return (Double.doubleToRawLongBits(d6) ^ Double.doubleToRawLongBits(d)) >= 0 ? d : -d;
    }

    public static double cos(double d) {
        double dSinQ;
        double remB = 0.0d;
        if (d < 0.0d) {
            d = -d;
        }
        if (d != d || d == Double.POSITIVE_INFINITY) {
            return Double.NaN;
        }
        int k6 = 0;
        if (d > 3294198.0d) {
            double[] dArr = new double[3];
            reducePayneHanek(d, dArr);
            k6 = ((int) dArr[0]) & 3;
            d = dArr[1];
            remB = dArr[2];
        } else if (d > 1.5707963267948966d) {
            CodyWaite codyWaite = new CodyWaite(d);
            k6 = codyWaite.getK() & 3;
            d = codyWaite.getRemA();
            remB = codyWaite.getRemB();
        }
        if (k6 == 0) {
            return cosQ(d, remB);
        }
        if (k6 == 1) {
            dSinQ = sinQ(d, remB);
        } else {
            if (k6 != 2) {
                if (k6 != 3) {
                    return Double.NaN;
                }
                return sinQ(d, remB);
            }
            dSinQ = cosQ(d, remB);
        }
        return -dSinQ;
    }

    private static double cosQ(double d, double d6) {
        double d7 = 1.5707963267948966d - d;
        return sinQ(d7, (6.123233995736766E-17d - d6) + (-((d7 - 1.5707963267948966d) + d)));
    }

    public static double cosh(double d) {
        double dExp;
        double dExp2;
        double d6 = d;
        if (d6 != d6) {
            return d6;
        }
        if (d6 > 20.0d) {
            if (d6 >= LOG_MAX_VALUE) {
                dExp2 = exp(d6 * F_1_2);
                return F_1_2 * dExp2 * dExp2;
            }
            dExp = exp(d6);
            return dExp * F_1_2;
        }
        if (d6 >= -20.0d) {
            double[] dArr = new double[2];
            if (d6 < 0.0d) {
                d6 = -d6;
            }
            exp(d6, 0.0d, dArr);
            double d7 = dArr[0];
            double d8 = dArr[1];
            double d9 = d7 + d8;
            double d10 = -((d9 - d7) - d8);
            double d11 = d9 * 1.073741824E9d;
            double d12 = (d9 + d11) - d11;
            double d13 = d9 - d12;
            double d14 = 1.0d / d9;
            double d15 = 1.073741824E9d * d14;
            double d16 = (d14 + d15) - d15;
            double d17 = d14 - d16;
            double dC = a.C(-d10, d14, d14, (((((1.0d - (d12 * d16)) - (d12 * d17)) - (d13 * d16)) - (d13 * d17)) * d14) + d17);
            double d18 = d9 + d16;
            double d19 = d10 + (-((d18 - d9) - d16));
            double d20 = d18 + dC;
            dExp = d19 + (-((d20 - d18) - dC)) + d20;
        } else {
            if (d6 <= (-LOG_MAX_VALUE)) {
                dExp2 = exp(d6 * (-0.5d));
                return F_1_2 * dExp2 * dExp2;
            }
            dExp = exp(-d6);
        }
        return dExp * F_1_2;
    }

    public static int decrementExact(int i5) {
        if (i5 != Integer.MIN_VALUE) {
            return i5 - 1;
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, Integer.valueOf(i5), 1);
    }

    private static double doubleHighPart(double d) {
        double d6 = Precision.SAFE_MIN;
        return (d <= (-d6) || d >= d6) ? Double.longBitsToDouble(Double.doubleToRawLongBits(d) & MASK_30BITS) : d;
    }

    public static double exp(double d) {
        return exp(d, 0.0d, null);
    }

    public static double expm1(double d) {
        return expm1(d, null);
    }

    public static double floor(double d) {
        if (d != d || d >= TWO_POWER_52 || d <= -4.503599627370496E15d) {
            return d;
        }
        long j6 = (long) d;
        if (d < 0.0d && j6 != d) {
            j6--;
        }
        return j6 == 0 ? d * j6 : j6;
    }

    public static int floorDiv(int i5, int i6) {
        if (i6 != 0) {
            return ((i5 ^ i6) >= 0 || i5 % i6 == 0) ? i5 / i6 : (i5 / i6) - 1;
        }
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    }

    public static int floorMod(int i5, int i6) {
        if (i6 == 0) {
            throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
        }
        int i7 = i5 % i6;
        return ((i5 ^ i6) >= 0 || i7 == 0) ? i7 : i6 + i7;
    }

    public static int getExponent(double d) {
        return ((int) ((Double.doubleToRawLongBits(d) >>> 52) & 2047)) - 1023;
    }

    public static double hypot(double d, double d6) {
        if (Double.isInfinite(d) || Double.isInfinite(d6)) {
            return Double.POSITIVE_INFINITY;
        }
        if (Double.isNaN(d) || Double.isNaN(d6)) {
            return Double.NaN;
        }
        int exponent = getExponent(d);
        int exponent2 = getExponent(d6);
        if (exponent > exponent2 + 27) {
            return abs(d);
        }
        if (exponent2 > exponent + 27) {
            return abs(d6);
        }
        int i5 = (exponent + exponent2) / 2;
        int i6 = -i5;
        double dScalb = scalb(d, i6);
        double dScalb2 = scalb(d6, i6);
        return scalb(sqrt((dScalb2 * dScalb2) + (dScalb * dScalb)), i5);
    }

    public static int incrementExact(int i5) {
        if (i5 != Integer.MAX_VALUE) {
            return i5 + 1;
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, Integer.valueOf(i5), 1);
    }

    public static double log(double d) {
        return log(d, (double[]) null);
    }

    public static double log10(double d) {
        double[] dArr = new double[2];
        double dLog = log(d, dArr);
        if (Double.isInfinite(dLog)) {
            return dLog;
        }
        double d6 = dArr[0];
        double d7 = 1.073741824E9d * d6;
        double d8 = (d6 + d7) - d7;
        double d9 = (d6 - d8) + dArr[1];
        double d10 = (1.9699272335463627E-8d * d8) + (d9 * 1.9699272335463627E-8d);
        return (d8 * 0.4342944622039795d) + (d9 * 0.4342944622039795d) + d10;
    }

    public static double log1p(double d) {
        if (d == -1.0d) {
            return Double.NEGATIVE_INFINITY;
        }
        if (d == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        if (d <= 1.0E-6d && d >= -1.0E-6d) {
            return ((((F_1_3 * d) - F_1_2) * d) + 1.0d) * d;
        }
        double d6 = d + 1.0d;
        double d7 = -((d6 - 1.0d) - d);
        double[] dArr = new double[2];
        double dLog = log(d6, dArr);
        if (Double.isInfinite(dLog)) {
            return dLog;
        }
        double d8 = d7 / d6;
        return a.B(d8, F_1_2, 1.0d, d8) + dArr[1] + dArr[0];
    }

    public static void main(String[] strArr) {
        PrintStream printStream = System.out;
        FastMathCalc.printarray(printStream, "EXP_INT_TABLE_A", 1500, ExpIntTable.EXP_INT_TABLE_A);
        FastMathCalc.printarray(printStream, "EXP_INT_TABLE_B", 1500, ExpIntTable.EXP_INT_TABLE_B);
        FastMathCalc.printarray(printStream, "EXP_FRAC_TABLE_A", 1025, ExpFracTable.EXP_FRAC_TABLE_A);
        FastMathCalc.printarray(printStream, "EXP_FRAC_TABLE_B", 1025, ExpFracTable.EXP_FRAC_TABLE_B);
        FastMathCalc.printarray(printStream, "LN_MANT", 1024, lnMant.LN_MANT);
        FastMathCalc.printarray(printStream, "SINE_TABLE_A", 14, SINE_TABLE_A);
        FastMathCalc.printarray(printStream, "SINE_TABLE_B", 14, SINE_TABLE_B);
        FastMathCalc.printarray(printStream, "COSINE_TABLE_A", 14, COSINE_TABLE_A);
        FastMathCalc.printarray(printStream, "COSINE_TABLE_B", 14, COSINE_TABLE_B);
        FastMathCalc.printarray(printStream, "TANGENT_TABLE_A", 14, TANGENT_TABLE_A);
        FastMathCalc.printarray(printStream, "TANGENT_TABLE_B", 14, TANGENT_TABLE_B);
    }

    public static int max(int i5, int i6) {
        return i5 <= i6 ? i6 : i5;
    }

    public static int min(int i5, int i6) {
        return i5 <= i6 ? i5 : i6;
    }

    public static int multiplyExact(int i5, int i6) {
        if ((i6 <= 0 || (i5 <= Integer.MAX_VALUE / i6 && i5 >= Integer.MIN_VALUE / i6)) && ((i6 >= -1 || (i5 <= Integer.MIN_VALUE / i6 && i5 >= Integer.MAX_VALUE / i6)) && !(i6 == -1 && i5 == Integer.MIN_VALUE))) {
            return i5 * i6;
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_MULTIPLICATION, Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static double nextAfter(double d, double d6) {
        if (Double.isNaN(d) || Double.isNaN(d6)) {
            return Double.NaN;
        }
        if (d == d6) {
            return d6;
        }
        if (Double.isInfinite(d)) {
            return d < 0.0d ? -1.7976931348623157E308d : Double.MAX_VALUE;
        }
        if (d == 0.0d) {
            return d6 < 0.0d ? -4.9E-324d : Double.MIN_VALUE;
        }
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        long j6 = Long.MIN_VALUE & jDoubleToRawLongBits;
        return ((d6 > d ? 1 : (d6 == d ? 0 : -1)) < 0) ^ (j6 == 0) ? Double.longBitsToDouble(j6 | ((jDoubleToRawLongBits & Long.MAX_VALUE) + 1)) : Double.longBitsToDouble(j6 | ((jDoubleToRawLongBits & Long.MAX_VALUE) - 1));
    }

    public static double nextDown(double d) {
        return nextAfter(d, Double.NEGATIVE_INFINITY);
    }

    public static double nextUp(double d) {
        return nextAfter(d, Double.POSITIVE_INFINITY);
    }

    private static double polyCosine(double d) {
        double d6 = d * d;
        return ((((((2.479773539153719E-5d * d6) - 0.0013888888689039883d) * d6) + 0.041666666666621166d) * d6) - 0.49999999999999994d) * d6;
    }

    private static double polySine(double d) {
        double d6 = d * d;
        return ((((((2.7553817452272217E-6d * d6) - 1.9841269659586505E-4d) * d6) + 0.008333333333329196d) * d6) - 0.16666666666666666d) * d6 * d;
    }

    public static double pow(double d, double d6) {
        if (d6 == 0.0d) {
            return 1.0d;
        }
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d6);
        int i5 = (int) ((jDoubleToRawLongBits & MASK_DOUBLE_EXPONENT) >> 52);
        long j6 = jDoubleToRawLongBits & 4503599627370495L;
        long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(d);
        int i6 = (int) ((jDoubleToRawLongBits2 & MASK_DOUBLE_EXPONENT) >> 52);
        long j7 = jDoubleToRawLongBits2 & 4503599627370495L;
        if (i5 > 1085) {
            if ((i5 == 2047 && j6 != 0) || (i6 == 2047 && j7 != 0)) {
                return Double.NaN;
            }
            if (i6 == 1023 && j7 == 0) {
                return i5 == 2047 ? Double.NaN : 1.0d;
            }
            return ((d6 > 0.0d ? 1 : (d6 == 0.0d ? 0 : -1)) > 0) ^ (i6 < 1023) ? Double.POSITIVE_INFINITY : 0.0d;
        }
        if (i5 >= 1023) {
            long j8 = j6 | 4503599627370496L;
            if (i5 >= 1075) {
                long j9 = j8 << (i5 - 1075);
                if (d6 < 0.0d) {
                    j9 = -j9;
                }
                return pow(d, j9);
            }
            int i7 = 1075 - i5;
            if ((((-1) << i7) & j8) == j8) {
                long j10 = j8 >> i7;
                if (d6 < 0.0d) {
                    j10 = -j10;
                }
                return pow(d, j10);
            }
        }
        if (d == 0.0d) {
            return d6 < 0.0d ? Double.POSITIVE_INFINITY : 0.0d;
        }
        if (i6 == 2047) {
            if (j7 == 0) {
                return d6 < 0.0d ? 0.0d : Double.POSITIVE_INFINITY;
            }
            return Double.NaN;
        }
        if (d < 0.0d) {
            return Double.NaN;
        }
        double d7 = d6 * 1.073741824E9d;
        double d8 = (d6 + d7) - d7;
        double d9 = d6 - d8;
        double[] dArr = new double[2];
        double dLog = log(d, dArr);
        if (Double.isInfinite(dLog)) {
            return dLog;
        }
        double d10 = dArr[0];
        double d11 = 1.073741824E9d * d10;
        double d12 = (d10 + d11) - d11;
        double d13 = (d10 - d12) + dArr[1];
        double d14 = d12 * d8;
        double d15 = (d13 * d9) + (d8 * d13) + (d12 * d9);
        double d16 = d14 + d15;
        double d17 = -((d16 - d14) - d15);
        return exp(d16, ((((((((0.008333333333333333d * d17) + 0.041666666666666664d) * d17) + 0.16666666666666666d) * d17) + F_1_2) * d17) + 1.0d) * d17, null);
    }

    public static double random() {
        return Math.random();
    }

    private static void reducePayneHanek(double d, double[] dArr) {
        long j6;
        long j7;
        long j8;
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        int i5 = ((int) ((jDoubleToRawLongBits >> 52) & 2047)) - 1022;
        long j9 = ((jDoubleToRawLongBits & 4503599627370495L) | 4503599627370496L) << 11;
        int i6 = i5 >> 6;
        int i7 = i5 - (i6 << 6);
        if (i7 != 0) {
            long j10 = i6 == 0 ? 0L : RECIP_2PI[i6 - 1] << i7;
            long[] jArr = RECIP_2PI;
            long j11 = jArr[i6];
            int i8 = 64 - i7;
            j6 = j10 | (j11 >>> i8);
            long j12 = jArr[i6 + 1];
            j7 = (j11 << i7) | (j12 >>> i8);
            j8 = (jArr[i6 + 2] >>> i8) | (j12 << i7);
        } else {
            j6 = i6 == 0 ? 0L : RECIP_2PI[i6 - 1];
            long[] jArr2 = RECIP_2PI;
            j7 = jArr2[i6];
            j8 = jArr2[i6 + 1];
        }
        long j13 = j9 >>> 32;
        long j14 = j9 & KeyboardMap.kValueMask;
        long j15 = j7 >>> 32;
        long j16 = j7 & KeyboardMap.kValueMask;
        long j17 = j13 * j15;
        long j18 = j14 * j16;
        long j19 = j15 * j14;
        long j20 = j16 * j13;
        long j21 = j18 + (j20 << 32);
        long j22 = j17 + (j20 >>> 32);
        boolean z6 = (j18 & Long.MIN_VALUE) != 0;
        boolean z7 = (j20 & 2147483648L) != 0;
        long j23 = j21 & Long.MIN_VALUE;
        boolean z8 = j23 != 0;
        if ((z6 && z7) || ((z6 || z7) && !z8)) {
            j22++;
        }
        boolean z9 = j23 != 0;
        boolean z10 = (j19 & 2147483648L) != 0;
        long j24 = j21 + (j19 << 32);
        long j25 = j22 + (j19 >>> 32);
        long j26 = j24 & Long.MIN_VALUE;
        boolean z11 = j26 != 0;
        if ((z9 && z10) || ((z9 || z10) && !z11)) {
            j25++;
        }
        long j27 = j8 >>> 32;
        long j28 = (j13 * j27) + ((((j8 & KeyboardMap.kValueMask) * j13) + (j27 * j14)) >>> 32);
        boolean z12 = j26 != 0;
        boolean z13 = (j28 & Long.MIN_VALUE) != 0;
        long j29 = j24 + j28;
        boolean z14 = (j29 & Long.MIN_VALUE) != 0;
        if ((z12 && z13) || ((z12 || z13) && !z14)) {
            j25++;
        }
        long j30 = j6 >>> 32;
        long j31 = j6 & KeyboardMap.kValueMask;
        long j32 = (j14 * j31) + (((j13 * j31) + (j14 * j30)) << 32) + j25;
        int i9 = (int) (j32 >>> 62);
        long j33 = (j32 << 2) | (j29 >>> 62);
        long j34 = j29 << 2;
        long j35 = j33 >>> 32;
        long j36 = j33 & KeyboardMap.kValueMask;
        long[] jArr3 = PI_O_4_BITS;
        long j37 = jArr3[0];
        long j38 = j37 >>> 32;
        long j39 = j37 & KeyboardMap.kValueMask;
        long j40 = j35 * j38;
        long j41 = j36 * j39;
        long j42 = j38 * j36;
        long j43 = j39 * j35;
        long j44 = j41 + (j43 << 32);
        long j45 = j40 + (j43 >>> 32);
        boolean z15 = (j41 & Long.MIN_VALUE) != 0;
        boolean z16 = (j43 & 2147483648L) != 0;
        long j46 = j44 & Long.MIN_VALUE;
        boolean z17 = j46 != 0;
        if ((z15 && z16) || ((z15 || z16) && !z17)) {
            j45++;
        }
        boolean z18 = j46 != 0;
        boolean z19 = (j42 & 2147483648L) != 0;
        long j47 = j44 + (j42 << 32);
        long j48 = j45 + (j42 >>> 32);
        long j49 = j47 & Long.MIN_VALUE;
        boolean z20 = j49 != 0;
        if ((z18 && z19) || ((z18 || z19) && !z20)) {
            j48++;
        }
        long j50 = jArr3[1];
        long j51 = j50 >>> 32;
        long j52 = (j35 * j51) + (((j35 * (j50 & KeyboardMap.kValueMask)) + (j36 * j51)) >>> 32);
        boolean z21 = j49 != 0;
        boolean z22 = (j52 & Long.MIN_VALUE) != 0;
        long j53 = j47 + j52;
        long j54 = j53 & Long.MIN_VALUE;
        boolean z23 = j54 != 0;
        if ((z21 && z22) || ((z21 || z22) && !z23)) {
            j48++;
        }
        long j55 = j34 >>> 32;
        long j56 = j37 >>> 32;
        long j57 = (j55 * j56) + (((j55 * (j37 & KeyboardMap.kValueMask)) + ((j34 & KeyboardMap.kValueMask) * j56)) >>> 32);
        boolean z24 = j54 != 0;
        boolean z25 = (j57 & Long.MIN_VALUE) != 0;
        long j58 = j53 + j57;
        boolean z26 = (j58 & Long.MIN_VALUE) != 0;
        if ((z24 && z25) || ((z24 || z25) && !z26)) {
            j48++;
        }
        double d6 = (j48 >>> 12) / TWO_POWER_52;
        double d7 = ((((j48 & 4095) << 40) + (j58 >>> 24)) / TWO_POWER_52) / TWO_POWER_52;
        double d8 = d6 + d7;
        dArr[0] = i9;
        dArr[1] = d8 * 2.0d;
        dArr[2] = (-((d8 - d6) - d7)) * 2.0d;
    }

    public static double rint(double d) {
        double dFloor = floor(d);
        double d6 = d - dFloor;
        if (d6 <= F_1_2) {
            return (d6 >= F_1_2 && (((long) dFloor) & 1) != 0) ? dFloor + 1.0d : dFloor;
        }
        if (dFloor == -1.0d) {
            return -0.0d;
        }
        return dFloor + 1.0d;
    }

    public static long round(double d) {
        return (long) floor(d + F_1_2);
    }

    public static double scalb(double d, int i5) {
        if (i5 > -1023 && i5 < 1024) {
            return Double.longBitsToDouble(((long) (i5 + IEEEDouble.EXPONENT_BIAS)) << 52) * d;
        }
        if (Double.isNaN(d) || Double.isInfinite(d) || d == 0.0d) {
            return d;
        }
        if (i5 < -2098) {
            return d > 0.0d ? 0.0d : -0.0d;
        }
        if (i5 > 2097) {
            return d > 0.0d ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        long j6 = Long.MIN_VALUE & jDoubleToRawLongBits;
        int i6 = ((int) (jDoubleToRawLongBits >>> 52)) & IEEEDouble.BIASED_EXPONENT_SPECIAL_VALUE;
        long j7 = jDoubleToRawLongBits & 4503599627370495L;
        int i7 = i6 + i5;
        if (i5 < 0) {
            if (i7 > 0) {
                return Double.longBitsToDouble((((long) i7) << 52) | j6 | j7);
            }
            if (i7 <= -53) {
                return j6 == 0 ? 0.0d : -0.0d;
            }
            long j8 = 4503599627370496L | j7;
            long j9 = j8 >>> (1 - i7);
            if (((1 << (-i7)) & j8) != 0) {
                j9++;
            }
            return Double.longBitsToDouble(j9 | j6);
        }
        if (i6 != 0) {
            if (i7 < 2047) {
                return Double.longBitsToDouble((((long) i7) << 52) | j6 | j7);
            }
            return j6 == 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }
        while ((j7 >>> 52) != 1) {
            j7 <<= 1;
            i7--;
        }
        int i8 = i7 + 1;
        long j10 = 4503599627370495L & j7;
        if (i8 < 2047) {
            return Double.longBitsToDouble((((long) i8) << 52) | j6 | j10);
        }
        return j6 == 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
    }

    public static double signum(double d) {
        if (d < 0.0d) {
            return -1.0d;
        }
        if (d > 0.0d) {
            return 1.0d;
        }
        return d;
    }

    public static double sin(double d) {
        double remA;
        boolean z6;
        double dSinQ;
        double remB = 0.0d;
        int k6 = 0;
        if (d < 0.0d) {
            remA = -d;
            z6 = true;
        } else {
            remA = d;
            z6 = false;
        }
        if (remA == 0.0d) {
            return Double.doubleToRawLongBits(d) < 0 ? -0.0d : 0.0d;
        }
        if (remA != remA || remA == Double.POSITIVE_INFINITY) {
            return Double.NaN;
        }
        if (remA > 3294198.0d) {
            double[] dArr = new double[3];
            reducePayneHanek(remA, dArr);
            k6 = ((int) dArr[0]) & 3;
            remA = dArr[1];
            remB = dArr[2];
        } else if (remA > 1.5707963267948966d) {
            CodyWaite codyWaite = new CodyWaite(remA);
            k6 = codyWaite.getK() & 3;
            remA = codyWaite.getRemA();
            remB = codyWaite.getRemB();
        }
        if (z6) {
            k6 ^= 2;
        }
        if (k6 == 0) {
            return sinQ(remA, remB);
        }
        if (k6 == 1) {
            return cosQ(remA, remB);
        }
        if (k6 == 2) {
            dSinQ = sinQ(remA, remB);
        } else {
            if (k6 != 3) {
                return Double.NaN;
            }
            dSinQ = cosQ(remA, remB);
        }
        return -dSinQ;
    }

    private static double sinQ(double d, double d6) {
        int i5 = (int) ((8.0d * d) + F_1_2);
        double d7 = d - EIGHTHS[i5];
        double d8 = SINE_TABLE_A[i5];
        double d9 = SINE_TABLE_B[i5];
        double d10 = COSINE_TABLE_A[i5];
        double d11 = COSINE_TABLE_B[i5];
        double dPolySine = polySine(d7);
        double dPolyCosine = polyCosine(d7);
        double d12 = 1.073741824E9d * d7;
        double d13 = (d7 + d12) - d12;
        double d14 = dPolySine + (d7 - d13);
        double d15 = d8 + 0.0d;
        double d16 = d10 * d13;
        double d17 = d15 + d16;
        double dA = (d11 * d14) + (d9 * dPolyCosine) + (d11 * d13) + a.A(d10, d14, (-((d15 - 0.0d) - d8)) + 0.0d + (-((d17 - d15) - d16)) + (d8 * dPolyCosine), d9);
        if (d6 != 0.0d) {
            double d18 = (((dPolyCosine + 1.0d) * (d10 + d11)) - ((d13 + d14) * (d8 + d9))) * d6;
            double d19 = d17 + d18;
            dA += -((d19 - d17) - d18);
            d17 = d19;
        }
        return d17 + dA;
    }

    public static double sinh(double d) {
        boolean z6;
        double d6;
        double d7;
        double d8;
        double dExp;
        double dExp2;
        double d9 = d;
        if (d9 == d9) {
            double d10 = F_1_2;
            if (d9 > 20.0d) {
                if (d9 >= LOG_MAX_VALUE) {
                    dExp2 = exp(d9 * F_1_2);
                    return d10 * dExp2 * dExp2;
                }
                dExp = exp(d9);
                return dExp * d10;
            }
            if (d9 < -20.0d) {
                d10 = -0.5d;
                if (d9 <= (-LOG_MAX_VALUE)) {
                    dExp2 = exp(d9 * (-0.5d));
                    return d10 * dExp2 * dExp2;
                }
                dExp = exp(-d9);
                return dExp * d10;
            }
            if (d9 != 0.0d) {
                if (d9 < 0.0d) {
                    d9 = -d9;
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (d9 > F_1_4) {
                    double[] dArr = new double[2];
                    exp(d9, 0.0d, dArr);
                    double d11 = dArr[0];
                    double d12 = dArr[1];
                    double d13 = d11 + d12;
                    double d14 = -((d13 - d11) - d12);
                    double d15 = d13 * 1.073741824E9d;
                    double d16 = (d13 + d15) - d15;
                    double d17 = d13 - d16;
                    double d18 = 1.0d / d13;
                    double d19 = 1.073741824E9d * d18;
                    double d20 = (d18 + d19) - d19;
                    double d21 = d18 - d20;
                    double d22 = (((((1.0d - (d16 * d20)) - (d16 * d21)) - (d17 * d20)) - (d17 * d21)) * d18) + d21;
                    double d23 = -d20;
                    double d24 = -a.C(-d14, d18, d18, d22);
                    double d25 = d13 + d23;
                    d6 = d14 + (-((d25 - d13) - d23));
                    d7 = d25 + d24;
                    d8 = -((d7 - d25) - d24);
                } else {
                    double[] dArr2 = new double[2];
                    expm1(d9, dArr2);
                    double d26 = dArr2[0];
                    double d27 = dArr2[1];
                    double d28 = d26 + d27;
                    double d29 = -((d28 - d26) - d27);
                    double d30 = d28 + 1.0d;
                    double d31 = 1.0d / d30;
                    double d32 = (-((d30 - 1.0d) - d28)) + d29;
                    double d33 = d28 * d31;
                    double d34 = d33 * 1.073741824E9d;
                    double d35 = (d33 + d34) - d34;
                    double d36 = d33 - d35;
                    double d37 = 1.073741824E9d * d30;
                    double d38 = (d30 + d37) - d37;
                    double d39 = d30 - d38;
                    double d40 = ((-d28) * d32 * d31 * d31) + (d29 * d31) + (((((d28 - (d38 * d35)) - (d38 * d36)) - (d39 * d35)) - (d39 * d36)) * d31) + d36;
                    double d41 = d28 + d35;
                    d6 = d29 + (-((d41 - d28) - d35));
                    d7 = d41 + d40;
                    d8 = -((d7 - d41) - d40);
                }
                double d42 = (d6 + d8 + d7) * F_1_2;
                return z6 ? -d42 : d42;
            }
        }
        return d9;
    }

    public static double sqrt(double d) {
        return Math.sqrt(d);
    }

    public static int subtractExact(int i5, int i6) {
        int i7 = i5 - i6;
        if ((i5 ^ i6) >= 0 || (i7 ^ i6) < 0) {
            return i7;
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static double tan(double d) {
        double remA;
        boolean z6;
        int k6;
        double remB = 0.0d;
        if (d < 0.0d) {
            remA = -d;
            z6 = true;
        } else {
            remA = d;
            z6 = false;
        }
        if (remA == 0.0d) {
            return Double.doubleToRawLongBits(d) < 0 ? -0.0d : 0.0d;
        }
        if (remA != remA || remA == Double.POSITIVE_INFINITY) {
            return Double.NaN;
        }
        if (remA > 3294198.0d) {
            double[] dArr = new double[3];
            reducePayneHanek(remA, dArr);
            k6 = 3 & ((int) dArr[0]);
            remA = dArr[1];
            remB = dArr[2];
        } else if (remA > 1.5707963267948966d) {
            CodyWaite codyWaite = new CodyWaite(remA);
            k6 = 3 & codyWaite.getK();
            remA = codyWaite.getRemA();
            remB = codyWaite.getRemB();
        } else {
            k6 = 0;
        }
        if (remA > 1.5d) {
            double d6 = 1.5707963267948966d - remA;
            double d7 = (6.123233995736766E-17d - remB) + (-((d6 - 1.5707963267948966d) + remA));
            remA = d6 + d7;
            remB = -((remA - d6) - d7);
            k6 ^= 1;
            z6 = !z6;
        }
        double dTanQ = (k6 & 1) == 0 ? tanQ(remA, remB, false) : -tanQ(remA, remB, true);
        return z6 ? -dTanQ : dTanQ;
    }

    private static double tanQ(double d, double d6, boolean z6) {
        double d7;
        int i5 = (int) ((8.0d * d) + F_1_2);
        double d8 = d - EIGHTHS[i5];
        double d9 = SINE_TABLE_A[i5];
        double d10 = SINE_TABLE_B[i5];
        double d11 = COSINE_TABLE_A[i5];
        double d12 = COSINE_TABLE_B[i5];
        double dPolySine = polySine(d8);
        double dPolyCosine = polyCosine(d8);
        double d13 = d8 * 1.073741824E9d;
        double d14 = (d8 + d13) - d13;
        double d15 = (d8 - d14) + dPolySine;
        double d16 = d9 + 0.0d;
        double d17 = d11 * d14;
        double d18 = d16 + d17;
        double dA = a.A(d12, d15, (d10 * dPolyCosine) + (d12 * d14) + d10, a.A(d11, d15, d9 * dPolyCosine, (-((d16 - 0.0d) - d9)) + 0.0d + (-((d18 - d16) - d17))));
        double d19 = d18 + dA;
        double d20 = -((d19 - d18) - dA);
        double d21 = d11 * 1.0d;
        double d22 = d21 + 0.0d;
        double d23 = (-d9) * d14;
        double d24 = d22 + d23;
        double dA2 = a.A(d12, dPolyCosine, (d11 * dPolyCosine) + (d12 * 1.0d), ((-((d22 - 0.0d) - d21)) + 0.0d) + (-((d24 - d22) - d23))) - ((d10 * d15) + ((d9 * d15) + (d14 * d10)));
        double d25 = d24 + dA2;
        double d26 = -((d25 - d24) - dA2);
        if (z6) {
            d20 = d26;
            d26 = d20;
            d7 = d19;
        } else {
            d7 = d25;
            d25 = d19;
        }
        double d27 = d25 / d7;
        double d28 = d27 * 1.073741824E9d;
        double d29 = (d27 + d28) - d28;
        double d30 = d27 - d29;
        double d31 = 1.073741824E9d * d7;
        double d32 = (d7 + d31) - d31;
        double d33 = d7 - d32;
        double dA3 = ((((-d25) * d26) / d7) / d7) + (d20 / d7) + com.google.android.gms.auth.api.accounttransfer.a.a(d30, d33, ((d25 - (d29 * d32)) - (d29 * d33)) - (d32 * d30), d7);
        if (d6 != 0.0d) {
            double dC = a.C(d27, d27, d6, d6);
            if (z6) {
                dC = -dC;
            }
            dA3 += dC;
        }
        return d27 + dA3;
    }

    public static double tanh(double d) {
        boolean z6;
        double d6;
        double d7 = d;
        if (d7 == d7) {
            if (d7 > 20.0d) {
                return 1.0d;
            }
            if (d7 < -20.0d) {
                return -1.0d;
            }
            if (d7 != 0.0d) {
                if (d7 < 0.0d) {
                    d7 = -d7;
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (d7 >= F_1_2) {
                    double[] dArr = new double[2];
                    exp(d7 * 2.0d, 0.0d, dArr);
                    double d8 = dArr[0];
                    double d9 = dArr[1];
                    double d10 = d8 + d9;
                    double d11 = -((d10 - d8) - d9);
                    double d12 = (-1.0d) + d10;
                    double d13 = d12 + d11;
                    double d14 = (-((d12 + 1.0d) - d10)) + (-((d13 - d12) - d11));
                    double d15 = d10 + 1.0d;
                    double d16 = -((d15 - 1.0d) - d10);
                    double d17 = d15 + d11;
                    double d18 = d16 + (-((d17 - d15) - d11));
                    double d19 = d17 * 1.073741824E9d;
                    double d20 = (d17 + d19) - d19;
                    double d21 = d17 - d20;
                    double d22 = d13 / d17;
                    double d23 = 1.073741824E9d * d22;
                    double d24 = (d22 + d23) - d23;
                    double d25 = d22 - d24;
                    d6 = ((((-d18) * d13) / d17) / d17) + (d14 / d17) + (((((d13 - (d20 * d24)) - (d20 * d25)) - (d21 * d24)) - (d21 * d25)) / d17) + d25 + d24;
                } else {
                    double[] dArr2 = new double[2];
                    expm1(d7 * 2.0d, dArr2);
                    double d26 = dArr2[0];
                    double d27 = dArr2[1];
                    double d28 = d26 + d27;
                    double d29 = -((d28 - d26) - d27);
                    double d30 = d28 + 2.0d;
                    double d31 = d30 + d29;
                    double d32 = (-((d30 - 2.0d) - d28)) + (-((d31 - d30) - d29));
                    double d33 = d31 * 1.073741824E9d;
                    double d34 = (d31 + d33) - d33;
                    double d35 = d31 - d34;
                    double d36 = d28 / d31;
                    double d37 = 1.073741824E9d * d36;
                    double d38 = (d36 + d37) - d37;
                    double d39 = d36 - d38;
                    d6 = ((((-d32) * d28) / d31) / d31) + (d29 / d31) + (((((d28 - (d34 * d38)) - (d34 * d39)) - (d35 * d38)) - (d35 * d39)) / d31) + d39 + d38;
                }
                return z6 ? -d6 : d6;
            }
        }
        return d7;
    }

    public static double toDegrees(double d) {
        if (Double.isInfinite(d) || d == 0.0d) {
            return d;
        }
        double dDoubleHighPart = doubleHighPart(d);
        double d6 = d - dDoubleHighPart;
        double d7 = 3.145894820876798E-6d * dDoubleHighPart;
        return (dDoubleHighPart * 57.2957763671875d) + d7 + (d6 * 57.2957763671875d) + (d6 * 3.145894820876798E-6d);
    }

    public static int toIntExact(long j6) {
        if (j6 < -2147483648L || j6 > 2147483647L) {
            throw new MathArithmeticException(LocalizedFormats.OVERFLOW, new Object[0]);
        }
        return (int) j6;
    }

    public static double toRadians(double d) {
        if (Double.isInfinite(d) || d == 0.0d) {
            return d;
        }
        double dDoubleHighPart = doubleHighPart(d);
        double d6 = d - dDoubleHighPart;
        double d7 = 1.997844754509471E-9d * dDoubleHighPart;
        double d8 = (dDoubleHighPart * 0.01745329052209854d) + d7 + (d6 * 0.01745329052209854d) + (d6 * 1.997844754509471E-9d);
        return d8 == 0.0d ? d8 * d : d8;
    }

    public static double ulp(double d) {
        if (Double.isInfinite(d)) {
            return Double.POSITIVE_INFINITY;
        }
        return abs(d - Double.longBitsToDouble(Double.doubleToRawLongBits(d) ^ 1));
    }

    public static long abs(long j6) {
        long j7 = j6 >>> 63;
        return (j6 ^ ((~j7) + 1)) + j7;
    }

    public static long addExact(long j6, long j7) {
        long j8 = j6 + j7;
        if ((j6 ^ j7) < 0 || (j8 ^ j7) >= 0) {
            return j8;
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, Long.valueOf(j6), Long.valueOf(j7));
    }

    private static double atan(double d, double d6, boolean z6) {
        double d7;
        boolean z7;
        int i5;
        double dA;
        double d8;
        double d9 = d;
        if (d9 == 0.0d) {
            return z6 ? copySign(3.141592653589793d, d9) : d9;
        }
        if (d9 < 0.0d) {
            d9 = -d9;
            d7 = -d6;
            z7 = true;
        } else {
            d7 = d6;
            z7 = false;
        }
        if (d9 > 1.633123935319537E16d) {
            return z7 ^ z6 ? -1.5707963267948966d : 1.5707963267948966d;
        }
        if (d9 < 1.0d) {
            i5 = (int) (((((-1.7168146928204135d) * d9 * d9) + 8.0d) * d9) + F_1_2);
        } else {
            double d10 = 1.0d / d9;
            i5 = (int) ((-((((-1.7168146928204135d) * d10 * d10) + 8.0d) * d10)) + 13.07d);
        }
        double d11 = TANGENT_TABLE_A[i5];
        double d12 = TANGENT_TABLE_B[i5];
        double d13 = d9 - d11;
        double d14 = (d7 - d12) + (-((d13 - d9) + d11));
        double d15 = d13 + d14;
        double d16 = -((d15 - d13) - d14);
        double d17 = d9 * 1.073741824E9d;
        double d18 = (d9 + d17) - d17;
        double d19 = ((d9 + d7) - d18) + d7;
        if (i5 == 0) {
            double d20 = 1.0d / (((d11 + d12) * (d18 + d19)) + 1.0d);
            d8 = d15 * d20;
            dA = d16 * d20;
        } else {
            double d21 = d18 * d11;
            double d22 = d21 + 1.0d;
            double d23 = (d18 * d12) + (d11 * d19);
            double d24 = d22 + d23;
            double d25 = (d19 * d12) + (-((d22 - 1.0d) - d21)) + (-((d24 - d22) - d23));
            double d26 = d15 / d24;
            double d27 = d26 * 1.073741824E9d;
            double d28 = (d26 + d27) - d27;
            double d29 = d26 - d28;
            double d30 = 1.073741824E9d * d24;
            double d31 = (d24 + d30) - d30;
            double d32 = d24 - d31;
            dA = (d16 / d24) + ((((-d15) * d25) / d24) / d24) + com.google.android.gms.auth.api.accounttransfer.a.a(d29, d32, ((d15 - (d28 * d31)) - (d28 * d32)) - (d31 * d29), d24);
            d8 = d26;
        }
        double d33 = d8 * d8;
        double d34 = ((((((((((0.07490822288864472d * d33) - 0.09088450866185192d) * d33) + 0.11111095942313305d) * d33) - 0.1428571423679182d) * d33) + 0.19999999999923582d) * d33) - 0.33333333333333287d) * d33 * d8;
        double d35 = d8 + d34;
        double d36 = (dA / (d33 + 1.0d)) + (-((d35 - d8) - d34));
        double d37 = EIGHTHS[i5];
        double d38 = d37 + d35;
        double d39 = d38 + d36;
        double d40 = (-((d38 - d37) - d35)) + (-((d39 - d38) - d36));
        double d41 = d39 + d40;
        if (z6) {
            double d42 = -((d41 - d39) - d40);
            double d43 = 3.141592653589793d - d41;
            d41 = (1.2246467991473532E-16d - d42) + (-((d43 - 3.141592653589793d) + d41)) + d43;
        }
        return z7 ^ z6 ? -d41 : d41;
    }

    public static long decrementExact(long j6) {
        if (j6 != Long.MIN_VALUE) {
            return j6 - 1;
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, Long.valueOf(j6), 1);
    }

    private static double exp(double d, double d6, double[] dArr) {
        double dA;
        int i5 = (int) d;
        if (d < 0.0d) {
            if (d < -746.0d) {
                if (dArr != null) {
                    dArr[0] = 0.0d;
                    dArr[1] = 0.0d;
                }
                return 0.0d;
            }
            if (i5 < -709) {
                double dExp = exp(d + 40.19140625d, d6, dArr) / 2.8504009514401178E17d;
                if (dArr != null) {
                    dArr[0] = dArr[0] / 2.8504009514401178E17d;
                    dArr[1] = dArr[1] / 2.8504009514401178E17d;
                }
                return dExp;
            }
            if (i5 == -709) {
                double dExp2 = exp(d + 1.494140625d, d6, dArr) / 4.455505956692757d;
                if (dArr != null) {
                    dArr[0] = dArr[0] / 4.455505956692757d;
                    dArr[1] = dArr[1] / 4.455505956692757d;
                }
                return dExp2;
            }
            i5--;
        } else if (i5 > 709) {
            if (dArr != null) {
                dArr[0] = Double.POSITIVE_INFINITY;
                dArr[1] = 0.0d;
            }
            return Double.POSITIVE_INFINITY;
        }
        double[] dArr2 = ExpIntTable.EXP_INT_TABLE_A;
        int i6 = i5 + EXP_INT_TABLE_MAX_INDEX;
        double d7 = dArr2[i6];
        double d8 = ExpIntTable.EXP_INT_TABLE_B[i6];
        double d9 = i5;
        int i7 = (int) ((d - d9) * 1024.0d);
        double d10 = ExpFracTable.EXP_FRAC_TABLE_A[i7];
        double d11 = ExpFracTable.EXP_FRAC_TABLE_B[i7];
        double d12 = d - ((((double) i7) / 1024.0d) + d9);
        double d13 = (((((((0.04168701738764507d * d12) + 0.1666666505023083d) * d12) + 0.5000000000042687d) * d12) + 1.0d) * d12) - 3.940510424527919E-20d;
        double d14 = d7 * d10;
        double d15 = (d8 * d11) + (d10 * d8) + (d7 * d11);
        double d16 = d15 + d14;
        if (d16 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        if (d6 != 0.0d) {
            double d17 = d16 * d6;
            dA = (d16 * d13) + (d17 * d13) + d17 + d15 + d14;
        } else {
            dA = a.A(d16, d13, d15, d14);
        }
        if (dArr != null) {
            dArr[0] = d14;
            double d18 = d6 * d16;
            dArr[1] = a.A(d16, d13, (d18 * d13) + d18, d15);
        }
        return dA;
    }

    private static double expm1(double d, double[] dArr) {
        boolean z6;
        double d6 = d;
        if (d6 != d6 || d6 == 0.0d) {
            return d6;
        }
        if (d6 <= -1.0d || d6 >= 1.0d) {
            double[] dArr2 = new double[2];
            exp(d6, 0.0d, dArr2);
            if (d6 > 0.0d) {
                return (dArr2[0] - 1.0d) + dArr2[1];
            }
            double d7 = dArr2[0];
            double d8 = (-1.0d) + d7;
            return (-((1.0d + d8) - d7)) + dArr2[1] + d8;
        }
        if (d6 < 0.0d) {
            d6 = -d6;
            z6 = true;
        } else {
            z6 = false;
        }
        int i5 = (int) (d6 * 1024.0d);
        double d9 = ExpFracTable.EXP_FRAC_TABLE_A[i5] - 1.0d;
        double d10 = ExpFracTable.EXP_FRAC_TABLE_B[i5];
        double d11 = d9 + d10;
        double d12 = d11 * 1.073741824E9d;
        double d13 = (d11 + d12) - d12;
        double d14 = (d11 - d13) + (-((d11 - d9) - d10));
        double d15 = d6 - (((double) i5) / 1024.0d);
        double d16 = ((((((0.008336750013465571d * d15) + 0.041666663879186654d) * d15) + 0.16666666666745392d) * d15) + 0.49999999999999994d) * d15 * d15;
        double d17 = d15 + d16;
        double d18 = -((d17 - d15) - d16);
        double d19 = d17 * 1.073741824E9d;
        double d20 = (d17 + d19) - d19;
        double d21 = (d17 - d20) + d18;
        double d22 = d20 * d13;
        double d23 = d20 * d14;
        double d24 = d22 + d23;
        double d25 = -((d24 - d22) - d23);
        double d26 = d21 * d13;
        double d27 = d24 + d26;
        double d28 = d25 + (-((d27 - d24) - d26));
        double d29 = d21 * d14;
        double d30 = d27 + d29;
        double d31 = d28 + (-((d30 - d27) - d29));
        double d32 = d30 + d13;
        double d33 = d32 + d20;
        double d34 = d31 + (-((d32 - d13) - d30)) + (-((d33 - d32) - d20));
        double d35 = d33 + d14;
        double d36 = d35 + d21;
        double d37 = d34 + (-((d35 - d33) - d14)) + (-((d36 - d35) - d21));
        if (z6) {
            double d38 = d36 + 1.0d;
            double d39 = 1.0d / d38;
            double d40 = (-((d38 - 1.0d) - d36)) + d37;
            double d41 = d36 * d39;
            double d42 = d41 * 1.073741824E9d;
            double d43 = (d41 + d42) - d42;
            double d44 = d41 - d43;
            double d45 = d38 * 1.073741824E9d;
            double d46 = (d38 + d45) - d45;
            double d47 = d38 - d46;
            double d48 = ((-d36) * d40 * d39 * d39) + (d37 * d39) + (((((d36 - (d46 * d43)) - (d46 * d44)) - (d47 * d43)) - (d47 * d44)) * d39) + d44;
            d36 = -d43;
            d37 = -d48;
        }
        if (dArr != null) {
            dArr[0] = d36;
            dArr[1] = d37;
        }
        return d36 + d37;
    }

    public static int getExponent(float f6) {
        return ((Float.floatToRawIntBits(f6) >>> 23) & 255) - 127;
    }

    public static long incrementExact(long j6) {
        if (j6 != Long.MAX_VALUE) {
            return j6 + 1;
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_ADDITION, Long.valueOf(j6), 1);
    }

    private static double log(double d, double[] dArr) {
        double d6;
        double d7;
        if (d == 0.0d) {
            return Double.NEGATIVE_INFINITY;
        }
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        if (((Long.MIN_VALUE & jDoubleToRawLongBits) != 0 || d != d) && d != 0.0d) {
            if (dArr != null) {
                dArr[0] = Double.NaN;
            }
            return Double.NaN;
        }
        if (d == Double.POSITIVE_INFINITY) {
            if (dArr != null) {
                dArr[0] = Double.POSITIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }
        int i5 = ((int) (jDoubleToRawLongBits >> 52)) - 1023;
        if ((MASK_DOUBLE_EXPONENT & jDoubleToRawLongBits) == 0) {
            if (d == 0.0d) {
                if (dArr != null) {
                    dArr[0] = Double.NEGATIVE_INFINITY;
                }
                return Double.NEGATIVE_INFINITY;
            }
            jDoubleToRawLongBits <<= 1;
            while ((4503599627370496L & jDoubleToRawLongBits) == 0) {
                i5--;
                jDoubleToRawLongBits <<= 1;
            }
        }
        if ((i5 == -1 || i5 == 0) && d < 1.01d && d > 0.99d && dArr == null) {
            double d8 = d - 1.0d;
            double d9 = d8 * 1.073741824E9d;
            double d10 = (d8 + d9) - d9;
            double d11 = d8 - d10;
            double[][] dArr2 = LN_QUICK_COEF;
            double[] dArr3 = dArr2[dArr2.length - 1];
            double d12 = dArr3[0];
            double d13 = dArr3[1];
            for (int length = dArr2.length - 2; length >= 0; length--) {
                double d14 = d12 * d10;
                double d15 = (d13 * d11) + (d13 * d10) + (d12 * d11);
                double d16 = d14 * 1.073741824E9d;
                double d17 = (d14 + d16) - d16;
                double d18 = (d14 - d17) + d15;
                double[] dArr4 = LN_QUICK_COEF[length];
                double d19 = d17 + dArr4[0];
                double d20 = d19 * 1.073741824E9d;
                d12 = (d19 + d20) - d20;
                d13 = (d19 - d12) + d18 + dArr4[1];
            }
            double d21 = d12 * d10;
            double d22 = (d13 * d11) + (d10 * d13) + (d12 * d11);
            double d23 = 1.073741824E9d * d21;
            double d24 = (d21 + d23) - d23;
            return (d21 - d24) + d22 + d24;
        }
        long j6 = 4499201580859392L & jDoubleToRawLongBits;
        double[] dArr5 = lnMant.LN_MANT[(int) (j6 >> 42)];
        double d25 = jDoubleToRawLongBits & 4398046511103L;
        double d26 = j6 + TWO_POWER_52;
        double d27 = d25 / d26;
        if (dArr != null) {
            double d28 = d27 * 1.073741824E9d;
            double d29 = (d27 + d28) - d28;
            double d30 = d27 - d29;
            double d31 = (((d25 - (d29 * d26)) - (d30 * d26)) / d26) + d30;
            double[][] dArr6 = LN_HI_PREC_COEF;
            double[] dArr7 = dArr6[dArr6.length - 1];
            double d32 = dArr7[0];
            double d33 = dArr7[1];
            for (int length2 = dArr6.length - 2; length2 >= 0; length2--) {
                double d34 = d32 * d29;
                double d35 = (d33 * d31) + (d33 * d29) + (d32 * d31);
                double d36 = d34 * 1.073741824E9d;
                double d37 = (d34 + d36) - d36;
                double d38 = (d34 - d37) + d35;
                double[] dArr8 = LN_HI_PREC_COEF[length2];
                double d39 = d37 + dArr8[0];
                double d40 = d39 * 1.073741824E9d;
                d32 = (d39 + d40) - d40;
                d33 = (d39 - d32) + d38 + dArr8[1];
            }
            double d41 = d32 * d29;
            double d42 = (d33 * d31) + (d29 * d33) + (d32 * d31);
            d6 = d41 + d42;
            d7 = -((d6 - d41) - d42);
        } else {
            d6 = (((((((((((-0.16624882440418567d) * d27) + 0.19999954120254515d) * d27) - 0.2499999997677497d) * d27) + 0.3333333333332802d) * d27) - 0.5d) * d27) + 1.0d) * d27;
            d7 = 0.0d;
        }
        double d43 = i5;
        double d44 = LN_2_A * d43;
        double d45 = dArr5[0];
        double d46 = d44 + d45;
        double d47 = (-((d46 - d44) - d45)) + 0.0d;
        double d48 = d46 + d6;
        double d49 = d47 + (-((d48 - d46) - d6));
        double d50 = d43 * LN_2_B;
        double d51 = d48 + d50;
        double d52 = d49 + (-((d51 - d48) - d50));
        double d53 = dArr5[1];
        double d54 = d51 + d53;
        double d55 = d52 + (-((d54 - d51) - d53));
        double d56 = d54 + d7;
        double d57 = d55 + (-((d56 - d54) - d7));
        if (dArr != null) {
            dArr[0] = d56;
            dArr[1] = d57;
        }
        return d56 + d57;
    }

    public static long max(long j6, long j7) {
        return j6 <= j7 ? j7 : j6;
    }

    public static long min(long j6, long j7) {
        return j6 <= j7 ? j6 : j7;
    }

    public static float nextDown(float f6) {
        return nextAfter(f6, Double.NEGATIVE_INFINITY);
    }

    public static float nextUp(float f6) {
        return nextAfter(f6, Double.POSITIVE_INFINITY);
    }

    public static int round(float f6) {
        return (int) floor(f6 + 0.5f);
    }

    public static float signum(float f6) {
        if (f6 < 0.0f) {
            return -1.0f;
        }
        if (f6 > 0.0f) {
            return 1.0f;
        }
        return f6;
    }

    public static long subtractExact(long j6, long j7) {
        long j8 = j6 - j7;
        if ((j6 ^ j7) >= 0 || (j8 ^ j7) < 0) {
            return j8;
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_SUBTRACTION, Long.valueOf(j6), Long.valueOf(j7));
    }

    public static float abs(float f6) {
        return Float.intBitsToFloat(Float.floatToRawIntBits(f6) & Integer.MAX_VALUE);
    }

    public static float copySign(float f6, float f7) {
        return (Float.floatToRawIntBits(f7) ^ Float.floatToRawIntBits(f6)) >= 0 ? f6 : -f6;
    }

    public static long floorMod(long j6, long j7) {
        if (j7 != 0) {
            long j8 = j6 % j7;
            return ((j6 ^ j7) >= 0 || j8 == 0) ? j8 : j7 + j8;
        }
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    }

    public static float max(float f6, float f7) {
        if (f6 <= f7) {
            if (f6 >= f7) {
                if (f6 != f7) {
                    return Float.NaN;
                }
                if (Float.floatToRawIntBits(f6) == Integer.MIN_VALUE) {
                }
            }
            return f7;
        }
        return f6;
    }

    public static float min(float f6, float f7) {
        if (f6 <= f7) {
            if (f6 >= f7) {
                if (f6 != f7) {
                    return Float.NaN;
                }
                if (Float.floatToRawIntBits(f6) == Integer.MIN_VALUE) {
                }
            }
            return f6;
        }
        return f7;
    }

    public static long multiplyExact(long j6, long j7) {
        if ((j7 <= 0 || (j6 <= Long.MAX_VALUE / j7 && j6 >= Long.MIN_VALUE / j7)) && ((j7 >= -1 || (j6 <= Long.MIN_VALUE / j7 && j6 >= Long.MAX_VALUE / j7)) && !(j7 == -1 && j6 == Long.MIN_VALUE))) {
            return j6 * j7;
        }
        throw new MathArithmeticException(LocalizedFormats.OVERFLOW_IN_MULTIPLICATION, Long.valueOf(j6), Long.valueOf(j7));
    }

    public static float ulp(float f6) {
        if (Float.isInfinite(f6)) {
            return Float.POSITIVE_INFINITY;
        }
        return abs(f6 - Float.intBitsToFloat(Float.floatToIntBits(f6) ^ 1));
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Split {
        private final double full;
        private final double high;
        private final double low;
        public static final Split NAN = new Split(Double.NaN, 0.0d);
        public static final Split POSITIVE_INFINITY = new Split(Double.POSITIVE_INFINITY, 0.0d);
        public static final Split NEGATIVE_INFINITY = new Split(Double.NEGATIVE_INFINITY, 0.0d);

        public Split(double d) {
            this.full = d;
            double dLongBitsToDouble = Double.longBitsToDouble(Double.doubleToRawLongBits(d) & (-134217728));
            this.high = dLongBitsToDouble;
            this.low = d - dLongBitsToDouble;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Split pow(long j6) {
            Split split = new Split(1.0d);
            Split split2 = new Split(this.full, this.high, this.low);
            for (long j7 = j6; j7 != 0; j7 >>>= 1) {
                if ((j7 & 1) != 0) {
                    split = split.multiply(split2);
                }
                split2 = split2.multiply(split2);
            }
            if (!Double.isNaN(split.full)) {
                return split;
            }
            if (Double.isNaN(this.full)) {
                return NAN;
            }
            if (FastMath.abs(this.full) < 1.0d) {
                return new Split(FastMath.copySign(0.0d, this.full), 0.0d);
            }
            return (this.full >= 0.0d || (j6 & 1) != 1) ? POSITIVE_INFINITY : NEGATIVE_INFINITY;
        }

        public Split multiply(Split split) {
            Split split2 = new Split(this.full * split.full);
            double d = this.low;
            double d6 = split.low;
            double d7 = split2.full;
            double d8 = this.high;
            double d9 = split.high;
            return new Split(split2.high, split2.low + ((d * d6) - (((d7 - (d8 * d9)) - (d * d9)) - (d8 * d6))));
        }

        public Split reciprocal() {
            Split split = new Split(1.0d / this.full);
            Split splitMultiply = multiply(split);
            double d = (splitMultiply.high - 1.0d) + splitMultiply.low;
            return Double.isNaN(d) ? split : new Split(split.high, split.low - (d / this.full));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Split(double d, double d6) {
            double d7;
            double d8;
            double d9;
            if (d == 0.0d) {
                if (d6 == 0.0d && Double.doubleToRawLongBits(d) == Long.MIN_VALUE) {
                    d7 = -0.0d;
                } else {
                    d9 = d6;
                    d8 = d9;
                }
                this(d9, d, d8);
            }
            d7 = d + d6;
            d8 = d6;
            d9 = d7;
            this(d9, d, d8);
        }

        public Split(double d, double d6, double d7) {
            this.full = d;
            this.high = d6;
            this.low = d7;
        }
    }

    public static double abs(double d) {
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d) & Long.MAX_VALUE);
    }

    public static double max(double d, double d6) {
        if (d <= d6) {
            if (d >= d6) {
                if (d != d6) {
                    return Double.NaN;
                }
                if (Double.doubleToRawLongBits(d) == Long.MIN_VALUE) {
                }
            }
            return d6;
        }
        return d;
    }

    public static double min(double d, double d6) {
        if (d <= d6) {
            if (d >= d6) {
                if (d != d6) {
                    return Double.NaN;
                }
                if (Double.doubleToRawLongBits(d) == Long.MIN_VALUE) {
                }
            }
            return d;
        }
        return d6;
    }

    public static long floorDiv(long j6, long j7) {
        if (j7 != 0) {
            long j8 = j6 % j7;
            if ((j6 ^ j7) < 0 && j8 != 0) {
                return (j6 / j7) - 1;
            }
            return j6 / j7;
        }
        throw new MathArithmeticException(LocalizedFormats.ZERO_DENOMINATOR, new Object[0]);
    }

    public static float nextAfter(float f6, double d) {
        double d6 = f6;
        if (Double.isNaN(d6) || Double.isNaN(d)) {
            return Float.NaN;
        }
        if (d6 == d) {
            return (float) d;
        }
        if (Float.isInfinite(f6)) {
            return f6 < 0.0f ? -3.4028235E38f : Float.MAX_VALUE;
        }
        if (f6 == 0.0f) {
            return d < 0.0d ? -1.4E-45f : Float.MIN_VALUE;
        }
        int iFloatToIntBits = Float.floatToIntBits(f6);
        int i5 = Integer.MIN_VALUE & iFloatToIntBits;
        if ((d < d6) ^ (i5 == 0)) {
            return Float.intBitsToFloat(((iFloatToIntBits & Integer.MAX_VALUE) + 1) | i5);
        }
        return Float.intBitsToFloat(((iFloatToIntBits & Integer.MAX_VALUE) - 1) | i5);
    }

    public static float scalb(float f6, int i5) {
        if (i5 > -127 && i5 < 128) {
            return Float.intBitsToFloat((i5 + 127) << 23) * f6;
        }
        if (Float.isNaN(f6) || Float.isInfinite(f6) || f6 == 0.0f) {
            return f6;
        }
        if (i5 < -277) {
            return f6 > 0.0f ? 0.0f : -0.0f;
        }
        if (i5 > 276) {
            return f6 > 0.0f ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        }
        int iFloatToIntBits = Float.floatToIntBits(f6);
        int i6 = Integer.MIN_VALUE & iFloatToIntBits;
        int i7 = (iFloatToIntBits >>> 23) & 255;
        int i8 = iFloatToIntBits & 8388607;
        int i9 = i7 + i5;
        if (i5 < 0) {
            if (i9 > 0) {
                return Float.intBitsToFloat(i8 | (i9 << 23) | i6);
            }
            if (i9 <= -24) {
                return i6 == 0 ? 0.0f : -0.0f;
            }
            int i10 = i8 | 8388608;
            int i11 = (1 << (-i9)) & i10;
            int i12 = i10 >>> (1 - i9);
            if (i11 != 0) {
                i12++;
            }
            return Float.intBitsToFloat(i12 | i6);
        }
        if (i7 != 0) {
            if (i9 < 255) {
                return Float.intBitsToFloat(i8 | (i9 << 23) | i6);
            }
            return i6 == 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
        }
        while ((i8 >>> 23) != 1) {
            i8 <<= 1;
            i9--;
        }
        int i13 = i9 + 1;
        int i14 = i8 & 8388607;
        if (i13 < 255) {
            return Float.intBitsToFloat(i14 | (i13 << 23) | i6);
        }
        return i6 == 0 ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY;
    }

    public static double pow(double d, int i5) {
        return pow(d, i5);
    }

    public static double pow(double d, long j6) {
        if (j6 == 0) {
            return 1.0d;
        }
        return j6 > 0 ? new Split(d).pow(j6).full : new Split(d).reciprocal().pow(-j6).full;
    }

    public static double log(double d, double d6) {
        return log(d6) / log(d);
    }
}
