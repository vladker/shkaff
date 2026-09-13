package Q3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends b {
    private static final double IEEErem(double d, double d6) {
        return Math.IEEEremainder(d, d6);
    }

    private static final double abs(double d) {
        return Math.abs(d);
    }

    private static final double acos(double d) {
        return Math.acos(d);
    }

    public static final double acosh(double d) {
        if (d < 1.0d) {
            return Double.NaN;
        }
        if (d > a.upper_taylor_2_bound) {
            return Math.log(d) + a.LN2;
        }
        double d6 = 1;
        double d7 = d - d6;
        if (d7 >= a.taylor_n_bound) {
            return Math.log(Math.sqrt((d * d) - d6) + d);
        }
        double dSqrt = Math.sqrt(d7);
        if (dSqrt >= a.taylor_2_bound) {
            dSqrt -= ((dSqrt * dSqrt) * dSqrt) / ((double) 12);
        }
        return Math.sqrt(2.0d) * dSqrt;
    }

    private static final double asin(double d) {
        return Math.asin(d);
    }

    public static final double asinh(double d) {
        double d6 = a.taylor_n_bound;
        if (d < d6) {
            if (d <= (-d6)) {
                return -asinh(-d);
            }
            return Math.abs(d) >= a.taylor_2_bound ? d - (((d * d) * d) / ((double) 6)) : d;
        }
        if (d <= a.upper_taylor_n_bound) {
            return Math.log(Math.sqrt((d * d) + ((double) 1)) + d);
        }
        if (d > a.upper_taylor_2_bound) {
            return Math.log(d) + a.LN2;
        }
        double d7 = d * ((double) 2);
        return Math.log((((double) 1) / d7) + d7);
    }

    private static final double atan(double d) {
        return Math.atan(d);
    }

    private static final double atan2(double d, double d6) {
        return Math.atan2(d, d6);
    }

    public static final double atanh(double d) {
        if (Math.abs(d) < a.taylor_n_bound) {
            return Math.abs(d) > a.taylor_2_bound ? (((d * d) * d) / ((double) 3)) + d : d;
        }
        double d6 = 1;
        return Math.log((d6 + d) / (d6 - d)) / ((double) 2);
    }

    private static final double cbrt(double d) {
        return Math.cbrt(d);
    }

    private static final double ceil(double d) {
        return Math.ceil(d);
    }

    private static final double cos(double d) {
        return Math.cos(d);
    }

    private static final double cosh(double d) {
        return Math.cosh(d);
    }

    private static final double exp(double d) {
        return Math.exp(d);
    }

    private static final double expm1(double d) {
        return Math.expm1(d);
    }

    private static final double floor(double d) {
        return Math.floor(d);
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(double d) {
    }

    public static /* synthetic */ void getSign$annotations(double d) {
    }

    public static /* synthetic */ void getUlp$annotations(double d) {
    }

    private static final double hypot(double d, double d6) {
        return Math.hypot(d, d6);
    }

    private static final double ln(double d) {
        return Math.log(d);
    }

    private static final double ln1p(double d) {
        return Math.log1p(d);
    }

    public static final double log(double d, double d6) {
        if (d6 <= 0.0d || d6 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d) / Math.log(d6);
    }

    private static final double log10(double d) {
        return Math.log10(d);
    }

    public static final double log2(double d) {
        return Math.log(d) / a.LN2;
    }

    private static final double max(double d, double d6) {
        return Math.max(d, d6);
    }

    private static final double min(double d, double d6) {
        return Math.min(d, d6);
    }

    private static final double nextDown(double d) {
        return Math.nextAfter(d, Double.NEGATIVE_INFINITY);
    }

    private static final double nextTowards(double d, double d6) {
        return Math.nextAfter(d, d6);
    }

    private static final double nextUp(double d) {
        return Math.nextUp(d);
    }

    private static final double pow(double d, double d6) {
        return Math.pow(d, d6);
    }

    private static final double round(double d) {
        return Math.rint(d);
    }

    public static int roundToInt(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d);
    }

    public static long roundToLong(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d);
    }

    private static final double sign(double d) {
        return Math.signum(d);
    }

    private static final double sin(double d) {
        return Math.sin(d);
    }

    private static final double sinh(double d) {
        return Math.sinh(d);
    }

    private static final double sqrt(double d) {
        return Math.sqrt(d);
    }

    private static final double tan(double d) {
        return Math.tan(d);
    }

    private static final double tanh(double d) {
        return Math.tanh(d);
    }

    public static final double truncate(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return d;
        }
        return d > 0.0d ? Math.floor(d) : Math.ceil(d);
    }

    private static final double withSign(double d, double d6) {
        return Math.copySign(d, d6);
    }

    private static final float IEEErem(float f6, float f7) {
        return (float) Math.IEEEremainder(f6, f7);
    }

    private static final float abs(float f6) {
        return Math.abs(f6);
    }

    private static final float acos(float f6) {
        return (float) Math.acos(f6);
    }

    private static final float asin(float f6) {
        return (float) Math.asin(f6);
    }

    private static final float atan(float f6) {
        return (float) Math.atan(f6);
    }

    private static final float atan2(float f6, float f7) {
        return (float) Math.atan2(f6, f7);
    }

    private static final float cbrt(float f6) {
        return (float) Math.cbrt(f6);
    }

    private static final float ceil(float f6) {
        return (float) Math.ceil(f6);
    }

    private static final float cos(float f6) {
        return (float) Math.cos(f6);
    }

    private static final float cosh(float f6) {
        return (float) Math.cosh(f6);
    }

    private static final float exp(float f6) {
        return (float) Math.exp(f6);
    }

    private static final float expm1(float f6) {
        return (float) Math.expm1(f6);
    }

    private static final float floor(float f6) {
        return (float) Math.floor(f6);
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(float f6) {
    }

    public static /* synthetic */ void getSign$annotations(float f6) {
    }

    public static /* synthetic */ void getUlp$annotations(float f6) {
    }

    private static final float hypot(float f6, float f7) {
        return (float) Math.hypot(f6, f7);
    }

    private static final float ln(float f6) {
        return (float) Math.log(f6);
    }

    private static final float ln1p(float f6) {
        return (float) Math.log1p(f6);
    }

    public static final float log(float f6, float f7) {
        if (f7 <= 0.0f || f7 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log(f6) / Math.log(f7));
    }

    private static final float log10(float f6) {
        return (float) Math.log10(f6);
    }

    public static final float log2(float f6) {
        return (float) (Math.log(f6) / a.LN2);
    }

    private static final float max(float f6, float f7) {
        return Math.max(f6, f7);
    }

    private static final float min(float f6, float f7) {
        return Math.min(f6, f7);
    }

    private static final float nextDown(float f6) {
        return Math.nextAfter(f6, Double.NEGATIVE_INFINITY);
    }

    private static final float nextTowards(float f6, float f7) {
        return Math.nextAfter(f6, f7);
    }

    private static final float nextUp(float f6) {
        return Math.nextUp(f6);
    }

    private static final double pow(double d, int i5) {
        return Math.pow(d, i5);
    }

    private static final float round(float f6) {
        return (float) Math.rint(f6);
    }

    public static final long roundToLong(float f6) {
        return roundToLong(f6);
    }

    private static final float sign(float f6) {
        return Math.signum(f6);
    }

    private static final float sin(float f6) {
        return (float) Math.sin(f6);
    }

    private static final float sinh(float f6) {
        return (float) Math.sinh(f6);
    }

    private static final float sqrt(float f6) {
        return (float) Math.sqrt(f6);
    }

    private static final float tan(float f6) {
        return (float) Math.tan(f6);
    }

    private static final float tanh(float f6) {
        return (float) Math.tanh(f6);
    }

    private static final double withSign(double d, int i5) {
        return Math.copySign(d, i5);
    }

    private static final int abs(int i5) {
        return Math.abs(i5);
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(int i5) {
    }

    public static /* synthetic */ void getSign$annotations(int i5) {
    }

    private static final int max(int i5, int i6) {
        return Math.max(i5, i6);
    }

    private static final int min(int i5, int i6) {
        return Math.min(i5, i6);
    }

    private static final float pow(float f6, float f7) {
        return (float) Math.pow(f6, f7);
    }

    private static final float withSign(float f6, float f7) {
        return Math.copySign(f6, f7);
    }

    private static final long abs(long j6) {
        return Math.abs(j6);
    }

    private static final float atanh(float f6) {
        return (float) atanh(f6);
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(long j6) {
    }

    public static /* synthetic */ void getSign$annotations(long j6) {
    }

    private static final long max(long j6, long j7) {
        return Math.max(j6, j7);
    }

    private static final long min(long j6, long j7) {
        return Math.min(j6, j7);
    }

    private static final float pow(float f6, int i5) {
        return (float) Math.pow(f6, i5);
    }

    public static final int roundToInt(float f6) {
        if (Float.isNaN(f6)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f6);
    }

    public static final float truncate(float f6) {
        double dCeil;
        if (Float.isNaN(f6) || Float.isInfinite(f6)) {
            return f6;
        }
        if (f6 > 0.0f) {
            dCeil = Math.floor(f6);
        } else {
            dCeil = Math.ceil(f6);
        }
        return (float) dCeil;
    }

    private static final float withSign(float f6, int i5) {
        return Math.copySign(f6, i5);
    }

    private static final float acosh(float f6) {
        return (float) acosh(f6);
    }

    private static final float asinh(float f6) {
        return (float) asinh(f6);
    }
}
