package androidx.constraintlayout.core.motion.utils;

import androidx.collection.a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ANTICIPATE = "cubic(0.36, 0, 0.66, -0.56)";
    private static final String ANTICIPATE_NAME = "anticipate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String OVERSHOOT = "cubic(0.34, 1.56, 0.64, 1)";
    private static final String OVERSHOOT_NAME = "overshoot";
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    String mStr = "identity";
    static Easing sDefault = new Easing();
    private static final String STANDARD_NAME = "standard";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = {STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};

    public static Easing getInterpolator(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        switch (str) {
            case "accelerate":
                return new CubicEasing(ACCELERATE);
            case "decelerate":
                return new CubicEasing(DECELERATE);
            case "anticipate":
                return new CubicEasing(ANTICIPATE);
            case "linear":
                return new CubicEasing(LINEAR);
            case "overshoot":
                return new CubicEasing(OVERSHOOT);
            case "standard":
                return new CubicEasing(STANDARD);
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(NAMED_EASING));
                return sDefault;
        }
    }

    public double getDiff(double d) {
        return 1.0d;
    }

    public String toString() {
        return this.mStr;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CubicEasing extends Easing {
        private static double sDError = 1.0E-4d;
        private static double sError = 0.01d;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        public CubicEasing(String str) {
            this.mStr = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.mX1 = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i5 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i5);
            this.mY1 = Double.parseDouble(str.substring(i5, iIndexOf3).trim());
            int i6 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i6);
            this.mX2 = Double.parseDouble(str.substring(i6, iIndexOf4).trim());
            int i7 = iIndexOf4 + 1;
            this.mY2 = Double.parseDouble(str.substring(i7, str.indexOf(41, i7)).trim());
        }

        private double getDiffX(double d) {
            double d6 = 1.0d - d;
            double d7 = this.mX1;
            double d8 = d6 * 3.0d * d6 * d7;
            double d9 = d6 * 6.0d * d;
            double d10 = this.mX2;
            return a.a(1.0d, d10, 3.0d * d * d, a.a(d10, d7, d9, d8));
        }

        private double getDiffY(double d) {
            double d6 = 1.0d - d;
            double d7 = this.mY1;
            double d8 = d6 * 3.0d * d6 * d7;
            double d9 = d6 * 6.0d * d;
            double d10 = this.mY2;
            return a.a(1.0d, d10, 3.0d * d * d, a.a(d10, d7, d9, d8));
        }

        private double getX(double d) {
            double d6 = 1.0d - d;
            double d7 = 3.0d * d6;
            double d8 = d * d * d;
            return a.A(this.mX2, d7 * d * d, this.mX1 * d6 * d7 * d, d8);
        }

        private double getY(double d) {
            double d6 = 1.0d - d;
            double d7 = 3.0d * d6;
            double d8 = d * d * d;
            return a.A(this.mY2, d7 * d * d, this.mY1 * d6 * d7 * d, d8);
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double get(double d) {
            if (d <= 0.0d) {
                return 0.0d;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double d6 = 0.5d;
            double d7 = 0.5d;
            while (d6 > sError) {
                d6 *= 0.5d;
                d7 = getX(d7) < d ? d7 + d6 : d7 - d6;
            }
            double d8 = d7 - d6;
            double x6 = getX(d8);
            double d9 = d7 + d6;
            double x7 = getX(d9);
            double y6 = getY(d8);
            return (((d - x6) * (getY(d9) - y6)) / (x7 - x6)) + y6;
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double getDiff(double d) {
            double d6 = 0.5d;
            double d7 = 0.5d;
            while (d6 > sDError) {
                d6 *= 0.5d;
                d7 = getX(d7) < d ? d7 + d6 : d7 - d6;
            }
            double d8 = d7 - d6;
            double d9 = d7 + d6;
            return (getY(d9) - getY(d8)) / (getX(d9) - getX(d8));
        }

        public void setup(double d, double d6, double d7, double d8) {
            this.mX1 = d;
            this.mY1 = d6;
            this.mX2 = d7;
            this.mY2 = d8;
        }

        public CubicEasing(double d, double d6, double d7, double d8) {
            setup(d, d6, d7, d8);
        }
    }

    public double get(double d) {
        return d;
    }
}
