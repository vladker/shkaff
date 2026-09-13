package org.apache.commons.math3.optimization.direct;

import androidx.collection.a;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.MultivariateOptimizer;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class BOBYQAOptimizer extends BaseAbstractMultivariateSimpleBoundsOptimizer<MultivariateFunction> implements MultivariateOptimizer {
    public static final double DEFAULT_INITIAL_RADIUS = 10.0d;
    public static final double DEFAULT_STOPPING_RADIUS = 1.0E-8d;
    private static final double HALF = 0.5d;
    public static final int MINIMUM_PROBLEM_DIMENSION = 2;
    private static final double MINUS_ONE = -1.0d;
    private static final double ONE = 1.0d;
    private static final double ONE_OVER_A_THOUSAND = 0.001d;
    private static final double ONE_OVER_EIGHT = 0.125d;
    private static final double ONE_OVER_FOUR = 0.25d;
    private static final double ONE_OVER_TEN = 0.1d;
    private static final double SIXTEEN = 16.0d;
    private static final double TEN = 10.0d;
    private static final double TWO = 2.0d;
    private static final double TWO_HUNDRED_FIFTY = 250.0d;
    private static final double ZERO = 0.0d;
    private ArrayRealVector alternativeNewPoint;
    private Array2DRowRealMatrix bMatrix;
    private double[] boundDifference;
    private ArrayRealVector currentBest;
    private ArrayRealVector fAtInterpolationPoints;
    private ArrayRealVector gradientAtTrustRegionCenter;
    private double initialTrustRegionRadius;
    private Array2DRowRealMatrix interpolationPoints;
    private boolean isMinimize;
    private ArrayRealVector lagrangeValuesAtNewPoint;
    private ArrayRealVector lowerDifference;
    private ArrayRealVector modelSecondDerivativesParameters;
    private ArrayRealVector modelSecondDerivativesValues;
    private ArrayRealVector newPoint;
    private final int numberOfInterpolationPoints;
    private ArrayRealVector originShift;
    private final double stoppingTrustRegionRadius;
    private ArrayRealVector trialStepPoint;
    private int trustRegionCenterInterpolationPointIndex;
    private ArrayRealVector trustRegionCenterOffset;
    private ArrayRealVector upperDifference;
    private Array2DRowRealMatrix zMatrix;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PathIsExploredException extends RuntimeException {
        private static final String PATH_IS_EXPLORED = "If this exception is thrown, just remove it from the code";
        private static final long serialVersionUID = 745350979634801853L;

        public PathIsExploredException() {
            super("If this exception is thrown, just remove it from the code " + BOBYQAOptimizer.caller(3));
        }
    }

    public BOBYQAOptimizer(int i5) {
        this(i5, 10.0d, 1.0E-8d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v73 */
    /* JADX WARN: Type inference failed for: r7v74 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private double[] altmov(int i5, double d) {
        double dSqrt;
        double d6;
        double d7;
        boolean z6;
        int i6;
        ArrayRealVector arrayRealVector;
        double d8;
        int i7;
        double d9;
        double dMax;
        int i8;
        printMethod();
        int dimension = this.currentBest.getDimension();
        int i9 = this.numberOfInterpolationPoints;
        ArrayRealVector arrayRealVector2 = new ArrayRealVector(dimension);
        ArrayRealVector arrayRealVector3 = new ArrayRealVector(i9);
        ArrayRealVector arrayRealVector4 = new ArrayRealVector(dimension);
        ArrayRealVector arrayRealVector5 = new ArrayRealVector(dimension);
        for (int i10 = 0; i10 < i9; i10++) {
            arrayRealVector3.setEntry(i10, 0.0d);
        }
        boolean z7 = true;
        int i11 = (i9 - dimension) - 1;
        int i12 = 0;
        while (i12 < i11) {
            double entry = this.zMatrix.getEntry(i5, i12);
            int i13 = 0;
            while (i13 < i9) {
                int i14 = i12;
                int i15 = i13;
                arrayRealVector3.setEntry(i15, AbstractC1125a.c(this.zMatrix, i15, i14, entry, arrayRealVector3.getEntry(i13)));
                i13 = i15 + 1;
                i12 = i14;
            }
            i12++;
        }
        double entry2 = arrayRealVector3.getEntry(i5);
        double d10 = entry2 * HALF;
        for (int i16 = 0; i16 < dimension; i16++) {
            arrayRealVector2.setEntry(i16, this.bMatrix.getEntry(i5, i16));
        }
        int i17 = 0;
        while (i17 < i9) {
            double dE = 0.0d;
            int i18 = 0;
            while (i18 < dimension) {
                int i19 = i18;
                dE = AbstractC1125a.e(this.trustRegionCenterOffset, i19, this.interpolationPoints.getEntry(i17, i18), dE);
                i18 = i19 + 1;
            }
            double entry3 = arrayRealVector3.getEntry(i17) * dE;
            int i20 = 0;
            while (i20 < dimension) {
                int i21 = i17;
                int i22 = i20;
                arrayRealVector2.setEntry(i22, AbstractC1125a.c(this.interpolationPoints, i21, i22, entry3, arrayRealVector2.getEntry(i20)));
                i20 = i22 + 1;
                i17 = i21;
            }
            i17++;
        }
        double d11 = Double.NaN;
        double d12 = 0.0d;
        double d13 = 0.0d;
        double d14 = 0.0d;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i23 < i9) {
            boolean z8 = z7;
            if (i23 == this.trustRegionCenterInterpolationPointIndex) {
                i6 = i23;
                arrayRealVector = arrayRealVector3;
            } else {
                int i26 = i24;
                int i27 = i25;
                int i28 = 0;
                double dE2 = 0.0d;
                double d15 = 0.0d;
                while (i28 < dimension) {
                    ArrayRealVector arrayRealVector6 = arrayRealVector2;
                    double entry4 = this.interpolationPoints.getEntry(i23, i28) - this.trustRegionCenterOffset.getEntry(i28);
                    int i29 = i28;
                    arrayRealVector2 = arrayRealVector6;
                    dE2 = AbstractC1125a.e(arrayRealVector2, i29, entry4, dE2);
                    d15 = (entry4 * entry4) + d15;
                    i28 = i29 + 1;
                    i26 = i26;
                    i23 = i23;
                    i27 = i27;
                }
                int i30 = i26;
                int i31 = i27;
                i6 = i23;
                double dSqrt2 = d / FastMath.sqrt(d15);
                double d16 = dE2;
                arrayRealVector = arrayRealVector3;
                double dMin = FastMath.min(1.0d, dSqrt2);
                int i32 = 0;
                double entry5 = -dSqrt2;
                double d17 = dSqrt2;
                int i33 = 0;
                for (int i34 = 0; i34 < dimension; i34++) {
                    int i35 = i33;
                    double entry6 = this.interpolationPoints.getEntry(i6, i34) - this.trustRegionCenterOffset.getEntry(i34);
                    if (entry6 > 0.0d) {
                        if (entry5 * entry6 < this.lowerDifference.getEntry(i34) - this.trustRegionCenterOffset.getEntry(i34)) {
                            entry5 = (this.lowerDifference.getEntry(i34) - this.trustRegionCenterOffset.getEntry(i34)) / entry6;
                            i8 = (-i34) - 1;
                        } else {
                            i8 = i35;
                        }
                        i35 = i8;
                        if (d17 * entry6 > this.upperDifference.getEntry(i34) - this.trustRegionCenterOffset.getEntry(i34)) {
                            d9 = entry5;
                            dMax = FastMath.max(dMin, (this.upperDifference.getEntry(i34) - this.trustRegionCenterOffset.getEntry(i34)) / entry6);
                            i32 = i34 + 1;
                            d17 = dMax;
                            i33 = i35;
                            entry5 = d9;
                        }
                        i33 = i35;
                    } else if (entry6 >= 0.0d) {
                        i33 = i35;
                    } else {
                        if (entry5 * entry6 > this.upperDifference.getEntry(i34) - this.trustRegionCenterOffset.getEntry(i34)) {
                            entry5 = (this.upperDifference.getEntry(i34) - this.trustRegionCenterOffset.getEntry(i34)) / entry6;
                            i7 = i34 + 1;
                        } else {
                            i7 = i35;
                        }
                        i35 = i7;
                        if (d17 * entry6 < this.lowerDifference.getEntry(i34) - this.trustRegionCenterOffset.getEntry(i34)) {
                            d9 = entry5;
                            dMax = FastMath.max(dMin, (this.lowerDifference.getEntry(i34) - this.trustRegionCenterOffset.getEntry(i34)) / entry6);
                            i32 = (-i34) - 1;
                            d17 = dMax;
                            i33 = i35;
                            entry5 = d9;
                        }
                        i33 = i35;
                    }
                }
                int i36 = i33;
                if (i6 == i5) {
                    double d18 = d16 - 1.0d;
                    double d19 = entry5 * d18;
                    d8 = (d16 - d19) * entry5;
                    double d20 = d17 * d18;
                    double d21 = (d16 - d20) * d17;
                    if (FastMath.abs(d21) > FastMath.abs(d8)) {
                        d8 = d21;
                    } else {
                        d17 = entry5;
                        i32 = i36;
                    }
                    double d22 = d16 * HALF;
                    if ((d22 - d20) * (d22 - d19) < 0.0d) {
                        double d23 = (d22 * d22) / d18;
                        if (FastMath.abs(d23) > FastMath.abs(d8)) {
                            d17 = d22 / d18;
                            d8 = d23;
                            i32 = 0;
                        }
                    }
                } else {
                    double d24 = (1.0d - entry5) * entry5;
                    double d25 = (1.0d - d17) * d17;
                    if (FastMath.abs(d25) > FastMath.abs(d24)) {
                        d24 = d25;
                        entry5 = d17;
                    } else {
                        i32 = i36;
                    }
                    if (d17 <= HALF || FastMath.abs(d24) >= ONE_OVER_FOUR) {
                        d17 = entry5;
                    } else {
                        i32 = 0;
                        d24 = 0.25d;
                        d17 = 0.5d;
                    }
                    d8 = d24 * d16;
                }
                i25 = i32;
                double d26 = (1.0d - d17) * d17 * d15;
                double d27 = d8 * d8;
                double d28 = ((d10 * d26 * d26) + d27) * d27;
                if (d28 > d13) {
                    d13 = d28;
                    i24 = i6;
                    d11 = d17;
                    d12 = d11;
                } else {
                    i25 = i31;
                    i24 = i30;
                    d11 = d17;
                }
            }
            i23 = i6 + 1;
            z7 = z8;
            arrayRealVector3 = arrayRealVector;
        }
        int i37 = i25;
        ArrayRealVector arrayRealVector7 = arrayRealVector3;
        ?? r16 = z7;
        int i38 = i24;
        int i39 = 0;
        while (i39 < dimension) {
            this.newPoint.setEntry(i39, FastMath.max(this.lowerDifference.getEntry(i39), FastMath.min(this.upperDifference.getEntry(i39), ((this.interpolationPoints.getEntry(i38, i39) - this.trustRegionCenterOffset.getEntry(i39)) * d12) + this.trustRegionCenterOffset.getEntry(i39))));
            i39++;
            d11 = d11;
            arrayRealVector5 = arrayRealVector5;
        }
        double d29 = d11;
        ArrayRealVector arrayRealVector8 = arrayRealVector5;
        if (i37 < 0) {
            int i40 = (-i37) - 1;
            this.newPoint.setEntry(i40, this.lowerDifference.getEntry(i40));
        }
        if (i37 > 0) {
            int i41 = i37 - 1;
            this.newPoint.setEntry(i41, this.upperDifference.getEntry(i41));
        }
        double d30 = d + d;
        boolean z9 = false;
        double d31 = 0.0d;
        while (true) {
            int i42 = 0;
            double d32 = d14;
            while (i42 < dimension) {
                double entry7 = arrayRealVector2.getEntry(i42);
                double d33 = d31;
                double d34 = d14;
                arrayRealVector4.setEntry(i42, d34);
                if (FastMath.min(this.trustRegionCenterOffset.getEntry(i42) - this.lowerDifference.getEntry(i42), entry7) > d34 || FastMath.max(this.trustRegionCenterOffset.getEntry(i42) - this.upperDifference.getEntry(i42), entry7) < d34) {
                    arrayRealVector4.setEntry(i42, d30);
                    d32 = (entry7 * entry7) + d32;
                }
                i42++;
                d31 = d33;
                d14 = 0.0d;
            }
            double d35 = d31;
            if (d32 == d14) {
                double[] dArr = new double[2];
                dArr[0] = entry2;
                dArr[r16] = d14;
                return dArr;
            }
            double d36 = (d * d) - d14;
            if (d36 > d14) {
                dSqrt = FastMath.sqrt(d36 / d32);
                for (int i43 = 0; i43 < dimension; i43++) {
                    if (arrayRealVector4.getEntry(i43) == d30) {
                        double entry8 = this.trustRegionCenterOffset.getEntry(i43) - (arrayRealVector2.getEntry(i43) * dSqrt);
                        if (entry8 <= this.lowerDifference.getEntry(i43)) {
                            arrayRealVector4.setEntry(i43, this.lowerDifference.getEntry(i43) - this.trustRegionCenterOffset.getEntry(i43));
                            arrayRealVector4.getEntry(i43);
                        } else if (entry8 >= this.upperDifference.getEntry(i43)) {
                            arrayRealVector4.setEntry(i43, this.upperDifference.getEntry(i43) - this.trustRegionCenterOffset.getEntry(i43));
                            arrayRealVector4.getEntry(i43);
                        } else {
                            arrayRealVector2.getEntry(i43);
                        }
                    }
                }
            } else {
                dSqrt = d29;
            }
            ?? r7 = r16;
            int i44 = 0;
            double dE3 = 0.0d;
            while (i44 < dimension) {
                double entry9 = arrayRealVector2.getEntry(i44);
                if (arrayRealVector4.getEntry(i44) == d30) {
                    arrayRealVector4.setEntry(i44, (-dSqrt) * entry9);
                    this.alternativeNewPoint.setEntry(i44, FastMath.max(this.lowerDifference.getEntry(i44), FastMath.min(this.upperDifference.getEntry(i44), arrayRealVector4.getEntry(i44) + this.trustRegionCenterOffset.getEntry(i44))));
                    z6 = true;
                } else {
                    if (arrayRealVector4.getEntry(i44) == 0.0d) {
                        this.alternativeNewPoint.setEntry(i44, this.trustRegionCenterOffset.getEntry(i44));
                    } else if (entry9 > 0.0d) {
                        this.alternativeNewPoint.setEntry(i44, this.lowerDifference.getEntry(i44));
                    } else {
                        this.alternativeNewPoint.setEntry(i44, this.upperDifference.getEntry(i44));
                    }
                    z6 = true;
                }
                dE3 = AbstractC1125a.e(arrayRealVector4, i44, entry9, dE3);
                i44++;
                arrayRealVector8 = arrayRealVector8;
                d30 = d30;
                dSqrt = dSqrt;
                r7 = z6;
            }
            double d37 = d30;
            double d38 = dSqrt;
            double d39 = dE3;
            ArrayRealVector arrayRealVector9 = arrayRealVector8;
            d14 = 0.0d;
            int i45 = 0;
            double entry10 = 0.0d;
            ?? r8 = r7;
            while (i45 < i9) {
                int i46 = 0;
                double dE4 = 0.0d;
                while (i46 < dimension) {
                    dE4 = AbstractC1125a.e(arrayRealVector4, i46, this.interpolationPoints.getEntry(i45, i46), dE4);
                    i46++;
                    entry10 = entry10;
                    d39 = d39;
                }
                entry10 = (arrayRealVector7.getEntry(i45) * dE4 * dE4) + entry10;
                i45++;
                d39 = d39;
                r8 = 1;
            }
            ?? r10 = r8;
            double d40 = d39;
            double d41 = entry10;
            ArrayRealVector arrayRealVector10 = arrayRealVector7;
            double d42 = z9 == r10 ? -d41 : d41;
            ArrayRealVector arrayRealVector11 = arrayRealVector4;
            double d43 = d40;
            double d44 = -d43;
            if (d42 <= d44 || d42 >= (FastMath.sqrt(TWO) + 1.0d) * d44) {
                arrayRealVector4 = arrayRealVector11;
                arrayRealVector7 = arrayRealVector10;
                double d45 = (d42 * HALF) + d43;
                d6 = d45 * d45;
            } else {
                double d46 = d44 / d42;
                int i47 = 0;
                while (i47 < dimension) {
                    ArrayRealVector arrayRealVector12 = arrayRealVector11;
                    this.alternativeNewPoint.setEntry(i47, FastMath.max(this.lowerDifference.getEntry(i47), FastMath.min(this.upperDifference.getEntry(i47), AbstractC1125a.e(arrayRealVector12, i47, d46, this.trustRegionCenterOffset.getEntry(i47)))));
                    i47++;
                    arrayRealVector11 = arrayRealVector12;
                    d43 = d43;
                    d46 = d46;
                    arrayRealVector10 = arrayRealVector10;
                }
                arrayRealVector4 = arrayRealVector11;
                arrayRealVector7 = arrayRealVector10;
                double d47 = d43 * HALF * d46;
                d6 = d47 * d47;
            }
            if (z9) {
                if (d35 > d6) {
                    for (int i48 = 0; i48 < dimension; i48++) {
                        this.alternativeNewPoint.setEntry(i48, arrayRealVector9.getEntry(i48));
                    }
                    d7 = d35;
                } else {
                    d7 = d6;
                }
                return new double[]{entry2, d7};
            }
            for (int i49 = 0; i49 < dimension; i49++) {
                arrayRealVector2.setEntry(i49, -arrayRealVector2.getEntry(i49));
                arrayRealVector9.setEntry(i49, this.alternativeNewPoint.getEntry(i49));
            }
            arrayRealVector8 = arrayRealVector9;
            d31 = d6;
            d30 = d37;
            d29 = d38;
            z9 = true;
            r16 = 1;
        }
    }

    private double bobyqa(double[] dArr, double[] dArr2) {
        printMethod();
        int dimension = this.currentBest.getDimension();
        for (int i5 = 0; i5 < dimension; i5++) {
            double d = this.boundDifference[i5];
            this.lowerDifference.setEntry(i5, dArr[i5] - this.currentBest.getEntry(i5));
            this.upperDifference.setEntry(i5, dArr2[i5] - this.currentBest.getEntry(i5));
            if (this.lowerDifference.getEntry(i5) >= (-this.initialTrustRegionRadius)) {
                if (this.lowerDifference.getEntry(i5) >= 0.0d) {
                    this.currentBest.setEntry(i5, dArr[i5]);
                    this.lowerDifference.setEntry(i5, 0.0d);
                    this.upperDifference.setEntry(i5, d);
                } else {
                    this.currentBest.setEntry(i5, dArr[i5] + this.initialTrustRegionRadius);
                    this.lowerDifference.setEntry(i5, -this.initialTrustRegionRadius);
                    this.upperDifference.setEntry(i5, FastMath.max(dArr2[i5] - this.currentBest.getEntry(i5), this.initialTrustRegionRadius));
                }
            } else if (this.upperDifference.getEntry(i5) <= this.initialTrustRegionRadius) {
                if (this.upperDifference.getEntry(i5) <= 0.0d) {
                    this.currentBest.setEntry(i5, dArr2[i5]);
                    this.lowerDifference.setEntry(i5, -d);
                    this.upperDifference.setEntry(i5, 0.0d);
                } else {
                    this.currentBest.setEntry(i5, dArr2[i5] - this.initialTrustRegionRadius);
                    this.lowerDifference.setEntry(i5, FastMath.min(dArr[i5] - this.currentBest.getEntry(i5), -this.initialTrustRegionRadius));
                    this.upperDifference.setEntry(i5, this.initialTrustRegionRadius);
                }
            }
        }
        return bobyqb(dArr, dArr2);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0408  */
    /* JADX WARN: Code duplicated, block: B:108:0x042c  */
    /* JADX WARN: Code duplicated, block: B:110:0x0444  */
    /* JADX WARN: Code duplicated, block: B:112:0x0456  */
    /* JADX WARN: Code duplicated, block: B:117:0x0470 A[LOOP:5: B:116:0x046e->B:117:0x0470, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:120:0x0492  */
    /* JADX WARN: Code duplicated, block: B:123:0x049a  */
    /* JADX WARN: Code duplicated, block: B:125:0x049e  */
    /* JADX WARN: Code duplicated, block: B:127:0x04a8  */
    /* JADX WARN: Code duplicated, block: B:129:0x04af  */
    /* JADX WARN: Code duplicated, block: B:131:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:132:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:135:0x04cb  */
    /* JADX WARN: Code duplicated, block: B:138:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:140:0x04e2  */
    /* JADX WARN: Code duplicated, block: B:142:0x04ea A[LOOP:7: B:141:0x04e8->B:142:0x04ea, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:145:0x0510 A[LOOP:8: B:144:0x050e->B:145:0x0510, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:148:0x0536  */
    /* JADX WARN: Code duplicated, block: B:152:0x055d  */
    /* JADX WARN: Code duplicated, block: B:155:0x056e  */
    /* JADX WARN: Code duplicated, block: B:156:0x057b  */
    /* JADX WARN: Code duplicated, block: B:159:0x059e  */
    /* JADX WARN: Code duplicated, block: B:162:0x05c9  */
    /* JADX WARN: Code duplicated, block: B:164:0x05d5 A[LOOP:10: B:163:0x05d3->B:164:0x05d5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:168:0x0605  */
    /* JADX WARN: Code duplicated, block: B:170:0x0611 A[LOOP:12: B:169:0x060f->B:170:0x0611, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:174:0x063b A[LOOP:13: B:173:0x0639->B:174:0x063b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:177:0x065a  */
    /* JADX WARN: Code duplicated, block: B:179:0x0660 A[LOOP:15: B:178:0x065e->B:179:0x0660, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:182:0x067b A[LOOP:16: B:181:0x0679->B:182:0x067b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:185:0x0694 A[LOOP:17: B:184:0x0692->B:185:0x0694, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:189:0x06b7 A[LOOP:18: B:188:0x06b5->B:189:0x06b7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:192:0x06dc  */
    /* JADX WARN: Code duplicated, block: B:194:0x06e5  */
    /* JADX WARN: Code duplicated, block: B:196:0x06fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:197:0x06fe  */
    /* JADX WARN: Code duplicated, block: B:202:0x0742  */
    /* JADX WARN: Code duplicated, block: B:204:0x0748 A[LOOP:22: B:203:0x0746->B:204:0x0748, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:207:0x0767 A[LOOP:23: B:206:0x0765->B:207:0x0767, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:211:0x078d  */
    /* JADX WARN: Code duplicated, block: B:213:0x0792  */
    /* JADX WARN: Code duplicated, block: B:215:0x0796 A[LOOP:24: B:214:0x0794->B:215:0x0796, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:218:0x07b6  */
    /* JADX WARN: Code duplicated, block: B:220:0x07bc A[LOOP:26: B:219:0x07ba->B:220:0x07bc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:223:0x07d7 A[LOOP:27: B:222:0x07d5->B:223:0x07d7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:227:0x07fa  */
    /* JADX WARN: Code duplicated, block: B:229:0x0800 A[LOOP:29: B:228:0x07fe->B:229:0x0800, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:233:0x082e  */
    /* JADX WARN: Code duplicated, block: B:235:0x0836 A[LOOP:31: B:234:0x0834->B:235:0x0836, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:238:0x0871  */
    /* JADX WARN: Code duplicated, block: B:239:0x088e  */
    /* JADX WARN: Code duplicated, block: B:241:0x08a0  */
    /* JADX WARN: Code duplicated, block: B:243:0x08b8  */
    /* JADX WARN: Code duplicated, block: B:247:0x08de  */
    /* JADX WARN: Code duplicated, block: B:248:0x08e1  */
    /* JADX WARN: Code duplicated, block: B:251:0x08e6  */
    /* JADX WARN: Code duplicated, block: B:253:0x08ee A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:254:0x08f0  */
    /* JADX WARN: Code duplicated, block: B:256:0x08ff  */
    /* JADX WARN: Code duplicated, block: B:258:0x090a  */
    /* JADX WARN: Code duplicated, block: B:261:0x0919  */
    /* JADX WARN: Code duplicated, block: B:271:0x096e  */
    /* JADX WARN: Code duplicated, block: B:273:0x0974 A[LOOP:34: B:272:0x0972->B:273:0x0974, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:276:0x0993  */
    /* JADX WARN: Code duplicated, block: B:277:0x0997  */
    /* JADX WARN: Code duplicated, block: B:283:0x09ab  */
    /* JADX WARN: Code duplicated, block: B:285:0x09b9  */
    /* JADX WARN: Code duplicated, block: B:288:0x09d8  */
    /* JADX WARN: Code duplicated, block: B:299:0x0a1f  */
    /* JADX WARN: Code duplicated, block: B:305:0x0a37  */
    /* JADX WARN: Code duplicated, block: B:307:0x0a40  */
    /* JADX WARN: Code duplicated, block: B:308:0x0a4b  */
    /* JADX WARN: Code duplicated, block: B:312:0x0a65  */
    /* JADX WARN: Code duplicated, block: B:387:0x0d52  */
    /* JADX WARN: Code duplicated, block: B:390:0x0d5e  */
    /* JADX WARN: Code duplicated, block: B:392:0x0d6e A[LOOP:50: B:391:0x0d6c->B:392:0x0d6e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:395:0x0d8e  */
    /* JADX WARN: Code duplicated, block: B:397:0x0db6 A[LOOP:52: B:396:0x0db4->B:397:0x0db6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:402:0x0e1d  */
    /* JADX WARN: Code duplicated, block: B:404:0x0e25 A[LOOP:54: B:403:0x0e23->B:404:0x0e25, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:407:0x0e4d  */
    /* JADX WARN: Code duplicated, block: B:409:0x0e5d A[LOOP:56: B:408:0x0e5b->B:409:0x0e5d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:412:0x0e7f A[LOOP:57: B:411:0x0e7d->B:412:0x0e7f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:416:0x0eaa  */
    /* JADX WARN: Code duplicated, block: B:418:0x0eb4 A[LOOP:59: B:417:0x0eb2->B:418:0x0eb4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:423:0x0ed4  */
    /* JADX WARN: Code duplicated, block: B:425:0x0ee4 A[LOOP:61: B:424:0x0ee2->B:425:0x0ee4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:429:0x0f1c A[LOOP:62: B:427:0x0f19->B:429:0x0f1c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:433:0x0f5b A[LOOP:63: B:432:0x0f59->B:433:0x0f5b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:435:0x0faa  */
    /* JADX WARN: Code duplicated, block: B:437:0x0fb5  */
    /* JADX WARN: Code duplicated, block: B:439:0x0fd5  */
    /* JADX WARN: Code duplicated, block: B:444:0x040d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:445:0x058e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:448:0x09a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:449:0x09dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:450:0x09f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:451:0x0a62 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:453:0x0a0e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:454:0x0a2c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:455:0x0a74 A[EDGE_INSN: B:455:0x0a74->B:313:0x0a74 BREAK  A[LOOP:1: B:6:0x0080->B:464:0x0080], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:460:0x0a04 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:461:0x09ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:463:0x041d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:472:0x03ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:476:0x0458 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:480:0x053c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:496:0x0717 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:512:0x0911 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x039c  */
    /* JADX WARN: Code duplicated, block: B:95:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:98:0x03e8  */
    private double bobyqb(double[] dArr, double[] dArr2) {
        char c;
        ArrayRealVector arrayRealVector;
        int i5;
        double d;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        double d6;
        double d7;
        double d8;
        int i14;
        double d9;
        int i15;
        double entry;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        double entry2;
        double entry3;
        int i25;
        int i26;
        int i27;
        double entry4;
        int i28;
        double entry5;
        int i29;
        int i30;
        int i31;
        int i32;
        double dE;
        double d10;
        double d11;
        int i33;
        int i34;
        int i35;
        int i36;
        double d12;
        int i37;
        int i38;
        ArrayRealVector arrayRealVector2;
        double d13;
        double d14;
        double d15;
        int i39;
        int i40;
        double d16;
        double dMin;
        double dSqrt;
        int i41;
        int i42;
        int i43;
        int i44;
        int i45;
        double dSqrt2;
        int i46;
        double d17;
        int i47;
        int i48;
        double d18;
        int i49;
        double dComputeObjectiveValue;
        double d19;
        double entry6;
        double entry7;
        int i50;
        int i51;
        int i52;
        double d20;
        double d21;
        double dAbs;
        double d22;
        double d23;
        int i53;
        int i54;
        double d24;
        double d25;
        double d26;
        int i55;
        double entry8;
        int i56;
        int i57;
        int i58;
        int i59;
        int i60;
        ArrayRealVector arrayRealVector3;
        int i61;
        int i62;
        double d27;
        ArrayRealVector arrayRealVector4;
        int i63;
        int i64;
        int i65;
        int i66;
        int i67;
        int i68;
        double d28;
        double d29;
        int i69;
        int i70;
        int iMax;
        int i71;
        int i72;
        double entry9;
        double d30;
        double d31;
        double d32;
        int i73;
        double dE2;
        int i74;
        double dE3;
        int i75;
        int i76;
        int i77;
        double d33;
        int i78;
        int i79;
        double dE4;
        double entry10;
        int i80;
        int i81;
        int i82;
        double dC;
        int i83;
        double dE5;
        double d34;
        int i84;
        double entry11;
        int i85;
        double entry12;
        int i86;
        double d35;
        double dMax;
        double d36;
        double dMax2;
        double d37;
        int i87;
        int i88;
        double d38;
        int i89;
        int i90;
        double d39;
        int i91;
        double d40;
        int i92;
        double d41;
        int i93;
        int i94;
        double entry13;
        BOBYQAOptimizer bOBYQAOptimizer = this;
        printMethod();
        int dimension = bOBYQAOptimizer.currentBest.getDimension();
        int i95 = bOBYQAOptimizer.numberOfInterpolationPoints;
        int i96 = dimension + 1;
        int i97 = i95 - i96;
        int i98 = (i96 * dimension) / 2;
        ArrayRealVector arrayRealVector5 = new ArrayRealVector(dimension);
        ArrayRealVector arrayRealVector6 = new ArrayRealVector(i95);
        ArrayRealVector arrayRealVector7 = new ArrayRealVector(i95);
        bOBYQAOptimizer.trustRegionCenterInterpolationPointIndex = 0;
        prelim(dArr, dArr2);
        double d42 = 0.0d;
        for (int i99 = 0; i99 < dimension; i99++) {
            bOBYQAOptimizer.trustRegionCenterOffset.setEntry(i99, bOBYQAOptimizer.interpolationPoints.getEntry(bOBYQAOptimizer.trustRegionCenterInterpolationPointIndex, i99));
            d42 = AbstractC1125a.d(bOBYQAOptimizer.trustRegionCenterOffset, i99, d42);
        }
        double d43 = 0.0d;
        double d44 = Double.NaN;
        double entry14 = bOBYQAOptimizer.fAtInterpolationPoints.getEntry(0);
        int evaluations = bOBYQAOptimizer.getEvaluations();
        double d45 = d42;
        double d46 = bOBYQAOptimizer.initialTrustRegionRadius;
        double d47 = d46;
        double d48 = Double.NaN;
        double d49 = Double.NaN;
        double dMax3 = 0.0d;
        double dMax4 = 0.0d;
        double d50 = 0.0d;
        double d51 = 0.0d;
        double d52 = 0.0d;
        double d53 = 0.0d;
        double d54 = 0.0d;
        double d55 = 0.0d;
        double d56 = 0.0d;
        double d57 = 0.0d;
        int i100 = 0;
        int i101 = 0;
        int i102 = 0;
        int i103 = 20;
        while (true) {
            d46 = d46;
            if (i103 == 20) {
                c = 20;
                arrayRealVector = arrayRealVector5;
                i5 = 60;
                d47 = d47;
                d = dMax4;
                i6 = 210;
                i7 = 90;
                i8 = 680;
                i9 = 650;
                i10 = 230;
                BOBYQAOptimizer bOBYQAOptimizer2 = bOBYQAOptimizer;
                i11 = i101;
                printState(20);
                if (bOBYQAOptimizer2.trustRegionCenterInterpolationPointIndex != 0) {
                    int i104 = 0;
                    for (int i105 = 0; i105 < dimension; i105++) {
                        int i106 = 0;
                        while (i106 <= i105) {
                            if (i106 < i105) {
                                ArrayRealVector arrayRealVector8 = bOBYQAOptimizer2.gradientAtTrustRegionCenter;
                                int i107 = i106;
                                i13 = i100;
                                i12 = i107;
                                arrayRealVector8.setEntry(i105, AbstractC1125a.e(bOBYQAOptimizer2.trustRegionCenterOffset, i107, bOBYQAOptimizer2.modelSecondDerivativesValues.getEntry(i104), arrayRealVector8.getEntry(i105)));
                            } else {
                                i12 = i106;
                                i13 = i100;
                            }
                            ArrayRealVector arrayRealVector9 = bOBYQAOptimizer2.gradientAtTrustRegionCenter;
                            arrayRealVector9.setEntry(i12, AbstractC1125a.e(bOBYQAOptimizer2.trustRegionCenterOffset, i105, bOBYQAOptimizer2.modelSecondDerivativesValues.getEntry(i104), arrayRealVector9.getEntry(i12)));
                            i104++;
                            i106 = i12 + 1;
                            i100 = i13;
                        }
                    }
                    i100 = i100;
                    if (bOBYQAOptimizer2.getEvaluations() > i95) {
                        int i108 = 0;
                        while (i108 < i95) {
                            double dE6 = d43;
                            int i109 = 0;
                            while (i109 < dimension) {
                                int i110 = i109;
                                dE6 = AbstractC1125a.e(bOBYQAOptimizer2.trustRegionCenterOffset, i110, bOBYQAOptimizer2.interpolationPoints.getEntry(i108, i109), dE6);
                                i109 = i110 + 1;
                            }
                            double entry15 = bOBYQAOptimizer2.modelSecondDerivativesParameters.getEntry(i108) * dE6;
                            int i111 = 0;
                            while (i111 < dimension) {
                                ArrayRealVector arrayRealVector10 = bOBYQAOptimizer2.gradientAtTrustRegionCenter;
                                int i112 = i108;
                                int i113 = i111;
                                arrayRealVector10.setEntry(i113, AbstractC1125a.c(bOBYQAOptimizer2.interpolationPoints, i112, i113, entry15, arrayRealVector10.getEntry(i111)));
                                i111 = i113 + 1;
                                i108 = i112;
                            }
                            i108++;
                        }
                    }
                } else {
                    i100 = i100;
                }
            } else if (i103 == 60) {
                arrayRealVector = arrayRealVector5;
                i5 = 60;
                d47 = d47;
                d = dMax4;
                i6 = 210;
                i7 = 90;
                i8 = 680;
                i9 = 650;
                i10 = 230;
                i11 = i101;
                i100 = i100;
                c = 20;
            } else if (i103 != 90) {
                int i114 = 720;
                double d58 = 1.0d;
                int i115 = 360;
                if (i103 != 210) {
                    if (i103 != 230) {
                        if (i103 != 360) {
                            if (i103 != 650) {
                                if (i103 != 680) {
                                    if (i103 != 720) {
                                        throw new MathIllegalStateException(LocalizedFormats.SIMPLE_MESSAGE, "bobyqb");
                                    }
                                    bOBYQAOptimizer = bOBYQAOptimizer;
                                    i38 = 720;
                                    break;
                                }
                                i39 = 680;
                                i100 = i100;
                                arrayRealVector5 = arrayRealVector5;
                                d = dMax4;
                                dMin = d46;
                                bOBYQAOptimizer = bOBYQAOptimizer;
                                i36 = 360;
                                i38 = 720;
                                d47 = d47;
                                i40 = i101;
                                d16 = d54;
                                printState(i39);
                                d47 = d47;
                                dSqrt = bOBYQAOptimizer.stoppingTrustRegionRadius;
                                if (d47 > dSqrt) {
                                    if (i40 == -1) {
                                        break;
                                    }
                                    d46 = dMin;
                                    d54 = d16;
                                    bOBYQAOptimizer = bOBYQAOptimizer;
                                    i101 = i40;
                                    i100 = i100;
                                    i103 = i36;
                                    arrayRealVector5 = arrayRealVector5;
                                    dMax4 = d;
                                    d47 = d47;
                                } else {
                                    double d59 = d47 * HALF;
                                    d57 = d47 / dSqrt;
                                    if (d57 > SIXTEEN) {
                                        if (d57 <= TWO_HUNDRED_FIFTY) {
                                            dSqrt = bOBYQAOptimizer.stoppingTrustRegionRadius * FastMath.sqrt(d57);
                                        } else {
                                            dSqrt = d47 * ONE_OVER_TEN;
                                        }
                                    }
                                    double dMax5 = FastMath.max(d59, dSqrt);
                                    evaluations = bOBYQAOptimizer.getEvaluations();
                                    d47 = dSqrt;
                                    d46 = dMax5;
                                    d54 = d16;
                                    bOBYQAOptimizer = bOBYQAOptimizer;
                                    i100 = i100;
                                    i101 = 0;
                                    arrayRealVector5 = arrayRealVector5;
                                    i103 = 60;
                                    dMax4 = d;
                                }
                            } else {
                                i42 = 650;
                                i41 = i101;
                                arrayRealVector5 = arrayRealVector5;
                                d = dMax4;
                                d54 = d54;
                                dMin = d46;
                                i43 = 90;
                                bOBYQAOptimizer = bOBYQAOptimizer;
                                i36 = 360;
                                i38 = 720;
                                d47 = d47;
                                printState(i42);
                                i45 = -1;
                                while (i44 < i95) {
                                    i46 = 0;
                                    d17 = 0.0d;
                                    while (i46 < dimension) {
                                        double entry16 = bOBYQAOptimizer.interpolationPoints.getEntry(i44, i46) - bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i46);
                                        d17 = (entry16 * entry16) + d17;
                                        i46++;
                                        i45 = i45;
                                    }
                                    i47 = i45;
                                    if (d17 > dMax3) {
                                        i45 = i44;
                                        dMax3 = d17;
                                    } else {
                                        i45 = i47;
                                    }
                                }
                                i100 = i45;
                                if (i100 >= 0) {
                                    dSqrt2 = FastMath.sqrt(dMax3);
                                    if (i41 == -1) {
                                        dMin = FastMath.min(dMin * ONE_OVER_TEN, dSqrt2 * HALF);
                                        if (dMin <= d47 * 1.5d) {
                                            dMin = d47;
                                        }
                                    }
                                    dMax4 = FastMath.max(FastMath.min(dSqrt2 * ONE_OVER_TEN, dMin), d47);
                                    d44 = dMax4 * dMax4;
                                    d46 = dMin;
                                    i101 = 0;
                                    i103 = i43;
                                } else {
                                    i40 = i41;
                                    if (i40 == -1) {
                                        d46 = dMin;
                                        i101 = i40;
                                        dMax4 = d;
                                        i103 = 680;
                                    } else {
                                        d43 = 0.0d;
                                        if (d57 > 0.0d) {
                                            d47 = d47;
                                            d46 = dMin;
                                            bOBYQAOptimizer = bOBYQAOptimizer;
                                            i101 = i40;
                                            i100 = i100;
                                            arrayRealVector5 = arrayRealVector5;
                                            i103 = 60;
                                            dMax4 = d;
                                            d54 = d54;
                                        } else {
                                            d16 = d54;
                                            if (FastMath.max(dMin, d16) <= d47) {
                                                i39 = 680;
                                                printState(i39);
                                                d47 = d47;
                                                dSqrt = bOBYQAOptimizer.stoppingTrustRegionRadius;
                                                if (d47 > dSqrt) {
                                                    if (i40 == -1) {
                                                        break;
                                                        break;
                                                    }
                                                    d46 = dMin;
                                                    d54 = d16;
                                                    bOBYQAOptimizer = bOBYQAOptimizer;
                                                    i101 = i40;
                                                    i100 = i100;
                                                    i103 = i36;
                                                    arrayRealVector5 = arrayRealVector5;
                                                    dMax4 = d;
                                                    d47 = d47;
                                                } else {
                                                    double d510 = d47 * HALF;
                                                    d57 = d47 / dSqrt;
                                                    if (d57 > SIXTEEN) {
                                                        if (d57 <= TWO_HUNDRED_FIFTY) {
                                                            dSqrt = bOBYQAOptimizer.stoppingTrustRegionRadius * FastMath.sqrt(d57);
                                                        } else {
                                                            dSqrt = d47 * ONE_OVER_TEN;
                                                        }
                                                    }
                                                    double dMax6 = FastMath.max(d510, dSqrt);
                                                    evaluations = bOBYQAOptimizer.getEvaluations();
                                                    d47 = dSqrt;
                                                    d46 = dMax6;
                                                    d54 = d16;
                                                    bOBYQAOptimizer = bOBYQAOptimizer;
                                                    i100 = i100;
                                                    i101 = 0;
                                                }
                                            } else {
                                                d47 = d47;
                                                d46 = dMin;
                                                d54 = d16;
                                                bOBYQAOptimizer = bOBYQAOptimizer;
                                                i101 = i40;
                                                i100 = i100;
                                            }
                                            arrayRealVector5 = arrayRealVector5;
                                            i103 = 60;
                                            dMax4 = d;
                                        }
                                    }
                                }
                                d43 = 0.0d;
                            }
                        } else {
                            arrayRealVector2 = arrayRealVector5;
                            d = dMax4;
                            i36 = 360;
                            i38 = 720;
                            d13 = d56;
                            printState(i36);
                            i48 = 0;
                            while (i48 < dimension) {
                                double d60 = d13;
                                int i116 = i100;
                                bOBYQAOptimizer.currentBest.setEntry(i48, FastMath.min(FastMath.max(dArr[i48], bOBYQAOptimizer.newPoint.getEntry(i48) + bOBYQAOptimizer.originShift.getEntry(i48)), dArr2[i48]));
                                if (bOBYQAOptimizer.newPoint.getEntry(i48) == bOBYQAOptimizer.lowerDifference.getEntry(i48)) {
                                    bOBYQAOptimizer.currentBest.setEntry(i48, dArr[i48]);
                                }
                                if (bOBYQAOptimizer.newPoint.getEntry(i48) == bOBYQAOptimizer.upperDifference.getEntry(i48)) {
                                    bOBYQAOptimizer.currentBest.setEntry(i48, dArr2[i48]);
                                }
                                i48++;
                                i100 = i116;
                                d13 = d60;
                            }
                            d18 = d13;
                            i49 = i100;
                            dComputeObjectiveValue = bOBYQAOptimizer.computeObjectiveValue(bOBYQAOptimizer.currentBest.toArray());
                            if (!bOBYQAOptimizer.isMinimize) {
                                dComputeObjectiveValue = -dComputeObjectiveValue;
                            }
                            d19 = dComputeObjectiveValue;
                            if (i101 == -1) {
                                entry14 = d19;
                                i100 = i49;
                                i103 = i38;
                                d56 = d18;
                                dMax4 = d;
                                d50 = entry14;
                                arrayRealVector5 = arrayRealVector2;
                            } else {
                                entry6 = bOBYQAOptimizer.fAtInterpolationPoints.getEntry(bOBYQAOptimizer.trustRegionCenterInterpolationPointIndex);
                                entry7 = d43;
                                i50 = 0;
                                i51 = 0;
                                while (i50 < dimension) {
                                    i93 = i51;
                                    entry7 = AbstractC1125a.e(bOBYQAOptimizer.gradientAtTrustRegionCenter, i50, bOBYQAOptimizer.trialStepPoint.getEntry(i50), entry7);
                                    for (i94 = 0; i94 <= i50; i94++) {
                                        entry13 = bOBYQAOptimizer.trialStepPoint.getEntry(i50) * bOBYQAOptimizer.trialStepPoint.getEntry(i94);
                                        if (i94 == i50) {
                                            entry13 *= HALF;
                                        }
                                        entry7 = AbstractC1125a.e(bOBYQAOptimizer.modelSecondDerivativesValues, i93, entry13, entry7);
                                        i93++;
                                    }
                                    i50++;
                                    i51 = i93;
                                }
                                for (i52 = 0; i52 < i95; i52++) {
                                    double entry17 = arrayRealVector6.getEntry(i52);
                                    entry7 = (bOBYQAOptimizer.modelSecondDerivativesParameters.getEntry(i52) * HALF * entry17 * entry17) + entry7;
                                }
                                d20 = d19 - entry6;
                                d21 = d20 - entry7;
                                dAbs = FastMath.abs(d21);
                                d22 = d54;
                                if (d22 > d47) {
                                    evaluations = bOBYQAOptimizer.getEvaluations();
                                }
                                if (i101 > 0) {
                                    d23 = d48;
                                    d54 = d22;
                                    i53 = i101;
                                    i54 = i49;
                                    d43 = d43;
                                    d47 = d47;
                                    d18 = d18;
                                    d24 = d55;
                                    d25 = d46;
                                } else {
                                    if (entry7 < d43) {
                                        throw new MathIllegalStateException(LocalizedFormats.TRUST_REGION_STEP_FAILED, Double.valueOf(entry7));
                                    }
                                    d57 = d20 / entry7;
                                    d35 = d46 * HALF;
                                    if (d57 <= ONE_OVER_TEN) {
                                        dMax = FastMath.min(d35, d22);
                                    } else {
                                        if (d57 <= 0.7d) {
                                            dMax = FastMath.max(d35, d22);
                                        } else {
                                            d54 = d22;
                                            dMax = FastMath.max(d35, d54 * TWO);
                                        }
                                        if (dMax <= d47 * 1.5d) {
                                            dMax = d47;
                                        }
                                        if (d19 < entry6) {
                                            d36 = dMax * dMax;
                                            d25 = dMax;
                                            dMax2 = d43;
                                            d37 = dMax2;
                                            i87 = 0;
                                            i88 = 0;
                                            d38 = d55;
                                            while (i87 < i95) {
                                                i90 = i88;
                                                d39 = d43;
                                                i91 = 0;
                                                while (i91 < i97) {
                                                    double entry18 = bOBYQAOptimizer.zMatrix.getEntry(i87, i91);
                                                    d39 = (entry18 * entry18) + d39;
                                                    i91++;
                                                    i101 = i101;
                                                }
                                                int i117 = i101;
                                                double entry19 = bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i87);
                                                d40 = (entry19 * entry19) + (d39 * d18);
                                                dMax3 = d43;
                                                for (i92 = 0; i92 < dimension; i92++) {
                                                    double entry20 = bOBYQAOptimizer.interpolationPoints.getEntry(i87, i92) - bOBYQAOptimizer.newPoint.getEntry(i92);
                                                    dMax3 = (entry20 * entry20) + dMax3;
                                                }
                                                double d61 = dMax3 / d36;
                                                double d62 = d48;
                                                double dMax7 = FastMath.max(1.0d, d61 * d61);
                                                d41 = dMax7 * d40;
                                                if (d41 > d37) {
                                                    i90 = i87;
                                                    d37 = d41;
                                                    d38 = d40;
                                                }
                                                double entry21 = bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i87);
                                                dMax2 = FastMath.max(dMax2, entry21 * entry21 * dMax7);
                                                i87++;
                                                i88 = i90;
                                                i101 = i117;
                                                d48 = d62;
                                            }
                                            i89 = i88;
                                            int i118 = i101;
                                            d23 = d48;
                                            if (d37 <= dMax2 * HALF) {
                                                i54 = i49;
                                                d24 = d55;
                                            } else {
                                                i54 = i89;
                                                d24 = d38;
                                            }
                                            i53 = i118;
                                        } else {
                                            d25 = dMax;
                                            d23 = d48;
                                            i53 = i101;
                                            i54 = i49;
                                            d43 = d43;
                                            d47 = d47;
                                            d18 = d18;
                                            d24 = d55;
                                            d54 = d54;
                                        }
                                    }
                                    d54 = d22;
                                    if (dMax <= d47 * 1.5d) {
                                        dMax = d47;
                                    }
                                    if (d19 < entry6) {
                                        d36 = dMax * dMax;
                                        d25 = dMax;
                                        dMax2 = d43;
                                        d37 = dMax2;
                                        i87 = 0;
                                        i88 = 0;
                                        d38 = d55;
                                        while (i87 < i95) {
                                            i90 = i88;
                                            d39 = d43;
                                            i91 = 0;
                                            while (i91 < i97) {
                                                double entry110 = bOBYQAOptimizer.zMatrix.getEntry(i87, i91);
                                                d39 = (entry110 * entry110) + d39;
                                                i91++;
                                                i101 = i101;
                                            }
                                            int i119 = i101;
                                            double entry111 = bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i87);
                                            d40 = (entry111 * entry111) + (d39 * d18);
                                            dMax3 = d43;
                                            while (i92 < dimension) {
                                                double entry22 = bOBYQAOptimizer.interpolationPoints.getEntry(i87, i92) - bOBYQAOptimizer.newPoint.getEntry(i92);
                                                dMax3 = (entry22 * entry22) + dMax3;
                                            }
                                            double d63 = dMax3 / d36;
                                            double d64 = d48;
                                            double dMax8 = FastMath.max(1.0d, d63 * d63);
                                            d41 = dMax8 * d40;
                                            if (d41 > d37) {
                                                i90 = i87;
                                                d37 = d41;
                                                d38 = d40;
                                            }
                                            double entry23 = bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i87);
                                            dMax2 = FastMath.max(dMax2, entry23 * entry23 * dMax8);
                                            i87++;
                                            i88 = i90;
                                            i101 = i119;
                                            d48 = d64;
                                        }
                                        i89 = i88;
                                        int i1110 = i101;
                                        d23 = d48;
                                        if (d37 <= dMax2 * HALF) {
                                            i54 = i49;
                                            d24 = d55;
                                        } else {
                                            i54 = i89;
                                            d24 = d38;
                                        }
                                        i53 = i1110;
                                    } else {
                                        d25 = dMax;
                                        d23 = d48;
                                        i53 = i101;
                                        i54 = i49;
                                        d43 = d43;
                                        d47 = d47;
                                        d18 = d18;
                                        d24 = d55;
                                        d54 = d54;
                                    }
                                }
                                i43 = 90;
                                bOBYQAOptimizer.update(d18, d24, i54);
                                d26 = d18;
                                d55 = d24;
                                i55 = i54;
                                entry8 = bOBYQAOptimizer.modelSecondDerivativesParameters.getEntry(i55);
                                bOBYQAOptimizer.modelSecondDerivativesParameters.setEntry(i55, d43);
                                i57 = 0;
                                for (i56 = 0; i56 < dimension; i56++) {
                                    entry12 = bOBYQAOptimizer.interpolationPoints.getEntry(i55, i56) * entry8;
                                    i86 = 0;
                                    while (i86 <= i56) {
                                        ArrayRealVector arrayRealVector11 = bOBYQAOptimizer.modelSecondDerivativesValues;
                                        int i120 = i55;
                                        int i121 = i86;
                                        arrayRealVector11.setEntry(i57, AbstractC1125a.c(bOBYQAOptimizer.interpolationPoints, i120, i121, entry12, arrayRealVector11.getEntry(i57)));
                                        i57++;
                                        i86 = i121 + 1;
                                        i55 = i120;
                                        entry8 = entry8;
                                    }
                                }
                                i58 = i55;
                                i59 = 0;
                                while (i59 < i97) {
                                    entry11 = bOBYQAOptimizer.zMatrix.getEntry(i58, i59) * d21;
                                    i85 = 0;
                                    while (i85 < i95) {
                                        ArrayRealVector arrayRealVector12 = bOBYQAOptimizer.modelSecondDerivativesParameters;
                                        int i122 = i59;
                                        int i123 = i85;
                                        arrayRealVector12.setEntry(i123, AbstractC1125a.c(bOBYQAOptimizer.zMatrix, i123, i122, entry11, arrayRealVector12.getEntry(i85)));
                                        i85 = i123 + 1;
                                        i59 = i122;
                                    }
                                    i59++;
                                }
                                bOBYQAOptimizer.fAtInterpolationPoints.setEntry(i58, d19);
                                for (i60 = 0; i60 < dimension; i60++) {
                                    bOBYQAOptimizer.interpolationPoints.setEntry(i58, i60, bOBYQAOptimizer.newPoint.getEntry(i60));
                                    arrayRealVector2.setEntry(i60, bOBYQAOptimizer.bMatrix.getEntry(i58, i60));
                                }
                                arrayRealVector3 = arrayRealVector2;
                                i61 = 0;
                                while (i61 < i95) {
                                    i82 = 0;
                                    dC = 0.0d;
                                    while (i82 < i97) {
                                        int i124 = i82;
                                        dC = AbstractC1125a.c(bOBYQAOptimizer.zMatrix, i61, i124, bOBYQAOptimizer.zMatrix.getEntry(i58, i82), dC);
                                        i82 = i124 + 1;
                                    }
                                    i83 = 0;
                                    dE5 = 0.0d;
                                    while (i83 < dimension) {
                                        int i125 = i83;
                                        dE5 = AbstractC1125a.e(bOBYQAOptimizer.trustRegionCenterOffset, i125, bOBYQAOptimizer.interpolationPoints.getEntry(i61, i83), dE5);
                                        i83 = i125 + 1;
                                    }
                                    d34 = dC * dE5;
                                    i84 = 0;
                                    while (i84 < dimension) {
                                        int i126 = i61;
                                        int i127 = i84;
                                        arrayRealVector3.setEntry(i127, AbstractC1125a.c(bOBYQAOptimizer.interpolationPoints, i126, i127, d34, arrayRealVector3.getEntry(i84)));
                                        i84 = i127 + 1;
                                        i61 = i126;
                                    }
                                    i61++;
                                }
                                i62 = 0;
                                while (i62 < dimension) {
                                    ArrayRealVector arrayRealVector13 = bOBYQAOptimizer.gradientAtTrustRegionCenter;
                                    ArrayRealVector arrayRealVector14 = arrayRealVector3;
                                    arrayRealVector13.setEntry(i62, AbstractC1125a.e(arrayRealVector14, i62, d21, arrayRealVector13.getEntry(i62)));
                                    i62++;
                                    arrayRealVector3 = arrayRealVector14;
                                    bOBYQAOptimizer = bOBYQAOptimizer;
                                    d19 = d19;
                                }
                                d27 = d19;
                                bOBYQAOptimizer = bOBYQAOptimizer;
                                arrayRealVector4 = arrayRealVector3;
                                if (d27 < entry6) {
                                    bOBYQAOptimizer.trustRegionCenterInterpolationPointIndex = i58;
                                    i76 = 0;
                                    i77 = 0;
                                    d33 = 0.0d;
                                    while (i76 < dimension) {
                                        int i128 = i58;
                                        bOBYQAOptimizer.trustRegionCenterOffset.setEntry(i76, bOBYQAOptimizer.newPoint.getEntry(i76));
                                        d33 = AbstractC1125a.d(bOBYQAOptimizer.trustRegionCenterOffset, i76, d33);
                                        for (i81 = 0; i81 <= i76; i81++) {
                                            if (i81 < i76) {
                                                ArrayRealVector arrayRealVector15 = bOBYQAOptimizer.gradientAtTrustRegionCenter;
                                                arrayRealVector15.setEntry(i76, AbstractC1125a.e(bOBYQAOptimizer.trialStepPoint, i81, bOBYQAOptimizer.modelSecondDerivativesValues.getEntry(i77), arrayRealVector15.getEntry(i76)));
                                            }
                                            ArrayRealVector arrayRealVector16 = bOBYQAOptimizer.gradientAtTrustRegionCenter;
                                            arrayRealVector16.setEntry(i81, AbstractC1125a.e(bOBYQAOptimizer.trialStepPoint, i76, bOBYQAOptimizer.modelSecondDerivativesValues.getEntry(i77), arrayRealVector16.getEntry(i81)));
                                            i77++;
                                        }
                                        i76++;
                                        i58 = i128;
                                    }
                                    i63 = i58;
                                    i78 = 0;
                                    while (i78 < i95) {
                                        i79 = 0;
                                        dE4 = 0.0d;
                                        while (i79 < dimension) {
                                            int i129 = i79;
                                            dE4 = AbstractC1125a.e(bOBYQAOptimizer.trialStepPoint, i129, bOBYQAOptimizer.interpolationPoints.getEntry(i78, i79), dE4);
                                            i79 = i129 + 1;
                                        }
                                        entry10 = bOBYQAOptimizer.modelSecondDerivativesParameters.getEntry(i78) * dE4;
                                        i80 = 0;
                                        while (i80 < dimension) {
                                            ArrayRealVector arrayRealVector17 = bOBYQAOptimizer.gradientAtTrustRegionCenter;
                                            int i130 = i78;
                                            int i131 = i80;
                                            arrayRealVector17.setEntry(i131, AbstractC1125a.c(bOBYQAOptimizer.interpolationPoints, i130, i131, entry10, arrayRealVector17.getEntry(i80)));
                                            i80 = i131 + 1;
                                            i78 = i130;
                                        }
                                        i78++;
                                    }
                                    d45 = d33;
                                } else {
                                    i63 = i58;
                                }
                                i64 = i53;
                                if (i64 > 0) {
                                    for (i65 = 0; i65 < i95; i65++) {
                                        bOBYQAOptimizer.lagrangeValuesAtNewPoint.setEntry(i65, bOBYQAOptimizer.fAtInterpolationPoints.getEntry(i65) - bOBYQAOptimizer.fAtInterpolationPoints.getEntry(bOBYQAOptimizer.trustRegionCenterInterpolationPointIndex));
                                        arrayRealVector7.setEntry(i65, 0.0d);
                                    }
                                    i66 = 0;
                                    while (i66 < i97) {
                                        i74 = 0;
                                        dE3 = 0.0d;
                                        while (i74 < i95) {
                                            int i132 = i74;
                                            dE3 = AbstractC1125a.e(bOBYQAOptimizer.lagrangeValuesAtNewPoint, i132, bOBYQAOptimizer.zMatrix.getEntry(i74, i66), dE3);
                                            i74 = i132 + 1;
                                        }
                                        i75 = 0;
                                        while (i75 < i95) {
                                            int i133 = i66;
                                            int i134 = i75;
                                            arrayRealVector7.setEntry(i134, AbstractC1125a.c(bOBYQAOptimizer.zMatrix, i134, i133, dE3, arrayRealVector7.getEntry(i75)));
                                            i75 = i134 + 1;
                                            i66 = i133;
                                        }
                                        i66++;
                                    }
                                    for (i67 = 0; i67 < i95; i67++) {
                                        i73 = 0;
                                        dE2 = 0.0d;
                                        while (i73 < dimension) {
                                            int i135 = i73;
                                            dE2 = AbstractC1125a.e(bOBYQAOptimizer.trustRegionCenterOffset, i135, bOBYQAOptimizer.interpolationPoints.getEntry(i67, i73), dE2);
                                            i73 = i135 + 1;
                                        }
                                        arrayRealVector6.setEntry(i67, arrayRealVector7.getEntry(i67));
                                        arrayRealVector7.setEntry(i67, arrayRealVector7.getEntry(i67) * dE2);
                                    }
                                    i68 = 0;
                                    d28 = 0.0d;
                                    d29 = 0.0d;
                                    while (i68 < dimension) {
                                        ArrayRealVector arrayRealVector18 = arrayRealVector4;
                                        i72 = 0;
                                        entry9 = 0.0d;
                                        while (i72 < i95) {
                                            entry9 = (arrayRealVector7.getEntry(i72) * bOBYQAOptimizer.interpolationPoints.getEntry(i72, i68)) + (bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i72) * bOBYQAOptimizer.bMatrix.getEntry(i72, i68)) + entry9;
                                            i72++;
                                            d29 = d29;
                                        }
                                        d30 = d29;
                                        if (bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i68) == bOBYQAOptimizer.lowerDifference.getEntry(i68)) {
                                            double dMin2 = FastMath.min(0.0d, bOBYQAOptimizer.gradientAtTrustRegionCenter.getEntry(i68));
                                            double d65 = (dMin2 * dMin2) + d28;
                                            double dMin3 = FastMath.min(0.0d, entry9);
                                            d29 = (dMin3 * dMin3) + d30;
                                            d28 = d65;
                                        } else {
                                            if (bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i68) == bOBYQAOptimizer.upperDifference.getEntry(i68)) {
                                                double dMax9 = FastMath.max(0.0d, bOBYQAOptimizer.gradientAtTrustRegionCenter.getEntry(i68));
                                                d31 = (dMax9 * dMax9) + d28;
                                                double dMax10 = FastMath.max(0.0d, entry9);
                                                d32 = dMax10 * dMax10;
                                            } else {
                                                d31 = AbstractC1125a.d(bOBYQAOptimizer.gradientAtTrustRegionCenter, i68, d28);
                                                d32 = entry9 * entry9;
                                            }
                                            d29 = d32 + d30;
                                            d28 = d31;
                                        }
                                        bOBYQAOptimizer.lagrangeValuesAtNewPoint.setEntry(i95 + i68, entry9);
                                        i68++;
                                        arrayRealVector4 = arrayRealVector18;
                                        i64 = i64;
                                    }
                                    arrayRealVector5 = arrayRealVector4;
                                    i41 = i64;
                                    i69 = i102 + 1;
                                    if (d28 < d29 * 10.0d) {
                                        i70 = 0;
                                    } else {
                                        i70 = i69;
                                    }
                                    if (i70 >= 3) {
                                        iMax = FastMath.max(i95, i98);
                                        i71 = 0;
                                        while (i71 < iMax) {
                                            if (i71 < dimension) {
                                                bOBYQAOptimizer.gradientAtTrustRegionCenter.setEntry(i71, bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i95 + i71));
                                            }
                                            if (i71 < i95) {
                                                bOBYQAOptimizer.modelSecondDerivativesParameters.setEntry(i71, arrayRealVector6.getEntry(i71));
                                            }
                                            if (i71 < i98) {
                                                bOBYQAOptimizer.modelSecondDerivativesValues.setEntry(i71, 0.0d);
                                            }
                                            i71++;
                                            i70 = 0;
                                        }
                                    }
                                    i102 = i70;
                                } else {
                                    arrayRealVector5 = arrayRealVector4;
                                    i41 = i64;
                                }
                                if (i41 != 0 && d27 > (entry7 * ONE_OVER_TEN) + entry6) {
                                    double d66 = TWO * d25;
                                    d47 = d47;
                                    double d67 = d47 * 10.0d;
                                    dMax3 = FastMath.max(d66 * d66, d67 * d67);
                                    d56 = d26;
                                    d53 = d52;
                                    dMin = d25;
                                    d48 = d23;
                                    i42 = 650;
                                    d50 = d27;
                                    d52 = d51;
                                    d51 = dAbs;
                                    printState(i42);
                                    i45 = -1;
                                    for (i44 = 0; i44 < i95; i44++) {
                                        i46 = 0;
                                        d17 = 0.0d;
                                        while (i46 < dimension) {
                                            double entry112 = bOBYQAOptimizer.interpolationPoints.getEntry(i44, i46) - bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i46);
                                            d17 = (entry112 * entry112) + d17;
                                            i46++;
                                            i45 = i45;
                                        }
                                        i47 = i45;
                                        if (d17 > dMax3) {
                                            i45 = i44;
                                            dMax3 = d17;
                                        } else {
                                            i45 = i47;
                                        }
                                    }
                                    i100 = i45;
                                    if (i100 >= 0) {
                                        dSqrt2 = FastMath.sqrt(dMax3);
                                        if (i41 == -1) {
                                            dMin = FastMath.min(dMin * ONE_OVER_TEN, dSqrt2 * HALF);
                                            if (dMin <= d47 * 1.5d) {
                                                dMin = d47;
                                            }
                                        }
                                        dMax4 = FastMath.max(FastMath.min(dSqrt2 * ONE_OVER_TEN, dMin), d47);
                                        d44 = dMax4 * dMax4;
                                        d46 = dMin;
                                        i101 = 0;
                                        i103 = i43;
                                    } else {
                                        i40 = i41;
                                        if (i40 == -1) {
                                            d46 = dMin;
                                            i101 = i40;
                                            dMax4 = d;
                                            i103 = 680;
                                        } else {
                                            d43 = 0.0d;
                                            if (d57 > 0.0d) {
                                                d47 = d47;
                                                d46 = dMin;
                                                bOBYQAOptimizer = bOBYQAOptimizer;
                                                i101 = i40;
                                                i100 = i100;
                                                arrayRealVector5 = arrayRealVector5;
                                                i103 = 60;
                                                dMax4 = d;
                                                d54 = d54;
                                            } else {
                                                d16 = d54;
                                                if (FastMath.max(dMin, d16) <= d47) {
                                                    i39 = 680;
                                                    printState(i39);
                                                    d47 = d47;
                                                    dSqrt = bOBYQAOptimizer.stoppingTrustRegionRadius;
                                                    if (d47 > dSqrt) {
                                                        if (i40 == -1) {
                                                            break;
                                                            break;
                                                        }
                                                        d46 = dMin;
                                                        d54 = d16;
                                                        bOBYQAOptimizer = bOBYQAOptimizer;
                                                        i101 = i40;
                                                        i100 = i100;
                                                        i103 = i36;
                                                        arrayRealVector5 = arrayRealVector5;
                                                        dMax4 = d;
                                                        d47 = d47;
                                                    } else {
                                                        double d511 = d47 * HALF;
                                                        d57 = d47 / dSqrt;
                                                        if (d57 > SIXTEEN) {
                                                            if (d57 <= TWO_HUNDRED_FIFTY) {
                                                                dSqrt = bOBYQAOptimizer.stoppingTrustRegionRadius * FastMath.sqrt(d57);
                                                            } else {
                                                                dSqrt = d47 * ONE_OVER_TEN;
                                                            }
                                                        }
                                                        double dMax11 = FastMath.max(d511, dSqrt);
                                                        evaluations = bOBYQAOptimizer.getEvaluations();
                                                        d47 = dSqrt;
                                                        d46 = dMax11;
                                                        d54 = d16;
                                                        bOBYQAOptimizer = bOBYQAOptimizer;
                                                        i100 = i100;
                                                        i101 = 0;
                                                    }
                                                } else {
                                                    d47 = d47;
                                                    d46 = dMin;
                                                    d54 = d16;
                                                    bOBYQAOptimizer = bOBYQAOptimizer;
                                                    i101 = i40;
                                                    i100 = i100;
                                                }
                                                arrayRealVector5 = arrayRealVector5;
                                                i103 = 60;
                                                dMax4 = d;
                                            }
                                        }
                                    }
                                    d43 = 0.0d;
                                } else {
                                    bOBYQAOptimizer = bOBYQAOptimizer;
                                    i100 = i63;
                                    d56 = d26;
                                    d53 = d52;
                                    arrayRealVector5 = arrayRealVector5;
                                    d46 = d25;
                                    i103 = 60;
                                    dMax4 = d;
                                    i101 = i41;
                                    d48 = d23;
                                    d54 = d54;
                                    d43 = 0.0d;
                                    d50 = d27;
                                    d52 = d51;
                                    d51 = dAbs;
                                    d47 = d47;
                                }
                            }
                        }
                    } else {
                        i37 = 230;
                        d = dMax4;
                        i36 = 360;
                        d12 = d48;
                    }
                } else {
                    printState(210);
                    double d68 = dMax4;
                    double[] dArrAltmov = bOBYQAOptimizer.altmov(i100, d68);
                    double d69 = dArrAltmov[0];
                    double d70 = dArrAltmov[1];
                    int i136 = 0;
                    while (true) {
                        i36 = i115;
                        if (i136 >= dimension) {
                            break;
                        }
                        bOBYQAOptimizer.trialStepPoint.setEntry(i136, bOBYQAOptimizer.newPoint.getEntry(i136) - bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i136));
                        i136++;
                        i115 = i36;
                        i114 = i114;
                        d68 = d68;
                    }
                    d = d68;
                    d49 = d69;
                    d12 = d70;
                    i37 = 230;
                }
                i38 = i114;
                printState(i37);
                int i137 = 0;
                while (i137 < i95) {
                    double dE7 = d43;
                    double dE8 = dE7;
                    double d71 = dE8;
                    int i138 = 0;
                    while (true) {
                        d15 = d12;
                        if (i138 < dimension) {
                            int i139 = i138;
                            double dE9 = AbstractC1125a.e(bOBYQAOptimizer.trialStepPoint, i139, bOBYQAOptimizer.interpolationPoints.getEntry(i137, i138), d71);
                            dE8 = AbstractC1125a.e(bOBYQAOptimizer.trustRegionCenterOffset, i139, bOBYQAOptimizer.interpolationPoints.getEntry(i137, i138), dE8);
                            dE7 = AbstractC1125a.e(bOBYQAOptimizer.trialStepPoint, i139, bOBYQAOptimizer.bMatrix.getEntry(i137, i138), dE7);
                            i138 = i139 + 1;
                            d71 = dE9;
                            d12 = d15;
                        }
                    }
                    double d72 = d71;
                    arrayRealVector7.setEntry(i137, a.B(d72, HALF, dE8, d71));
                    bOBYQAOptimizer.lagrangeValuesAtNewPoint.setEntry(i137, dE7);
                    arrayRealVector6.setEntry(i137, d72);
                    i137++;
                    d12 = d15;
                    arrayRealVector5 = arrayRealVector5;
                }
                double d73 = d12;
                arrayRealVector2 = arrayRealVector5;
                double d74 = d43;
                int i140 = 0;
                while (i140 < i97) {
                    double dE10 = d43;
                    for (int i141 = 0; i141 < i95; i141++) {
                        dE10 = AbstractC1125a.e(arrayRealVector7, i141, bOBYQAOptimizer.zMatrix.getEntry(i141, i140), dE10);
                    }
                    d74 -= dE10 * dE10;
                    int i142 = 0;
                    while (i142 < i95) {
                        ArrayRealVector arrayRealVector19 = bOBYQAOptimizer.lagrangeValuesAtNewPoint;
                        int i143 = i140;
                        int i144 = i142;
                        arrayRealVector19.setEntry(i144, AbstractC1125a.c(bOBYQAOptimizer.zMatrix, i144, i143, dE10, arrayRealVector19.getEntry(i142)));
                        i142 = i144 + 1;
                        i140 = i143;
                    }
                    i140++;
                }
                double d75 = d43;
                double dE11 = d75;
                double d76 = dE11;
                int i145 = 0;
                while (i145 < dimension) {
                    double d77 = d74;
                    double d78 = AbstractC1125a.d(bOBYQAOptimizer.trialStepPoint, i145, d75);
                    double dE12 = d43;
                    int i146 = 0;
                    while (i146 < i95) {
                        double d79 = dE12;
                        int i147 = i145;
                        int i148 = i146;
                        dE12 = AbstractC1125a.c(bOBYQAOptimizer.bMatrix, i148, i147, arrayRealVector7.getEntry(i146), d79);
                        i146 = i148 + 1;
                        i145 = i147;
                    }
                    int i149 = i145;
                    double dE13 = AbstractC1125a.e(bOBYQAOptimizer.trialStepPoint, i149, dE12, d76);
                    int i150 = i95 + i149;
                    int i151 = 0;
                    while (i151 < dimension) {
                        int i152 = i151;
                        dE12 = AbstractC1125a.e(bOBYQAOptimizer.trialStepPoint, i152, bOBYQAOptimizer.bMatrix.getEntry(i150, i151), dE12);
                        i151 = i152 + 1;
                    }
                    bOBYQAOptimizer.lagrangeValuesAtNewPoint.setEntry(i150, dE12);
                    double dE14 = AbstractC1125a.e(bOBYQAOptimizer.trialStepPoint, i149, dE12, dE13);
                    dE11 = AbstractC1125a.e(bOBYQAOptimizer.trustRegionCenterOffset, i149, bOBYQAOptimizer.trialStepPoint.getEntry(i149), dE11);
                    d75 = d78;
                    d76 = dE14;
                    i145 = i149 + 1;
                    d74 = d77;
                }
                double d80 = dE11;
                double d81 = (((((d75 * HALF) + ((d45 + d80) + d80)) * d75) + (d80 * d80)) + d74) - d76;
                ArrayRealVector arrayRealVector20 = bOBYQAOptimizer.lagrangeValuesAtNewPoint;
                int i153 = bOBYQAOptimizer.trustRegionCenterInterpolationPointIndex;
                arrayRealVector20.setEntry(i153, arrayRealVector20.getEntry(i153) + 1.0d);
                if (i101 == 0) {
                    double entry24 = bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i100);
                    d55 = (d49 * d81) + (entry24 * entry24);
                    if (d55 >= d73 || d73 <= d43) {
                        d13 = d81;
                        d48 = d73;
                        d44 = d75;
                    } else {
                        for (int i154 = 0; i154 < dimension; i154++) {
                            bOBYQAOptimizer.newPoint.setEntry(i154, bOBYQAOptimizer.alternativeNewPoint.getEntry(i154));
                            bOBYQAOptimizer.trialStepPoint.setEntry(i154, bOBYQAOptimizer.newPoint.getEntry(i154) - bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i154));
                        }
                        d56 = d81;
                        d48 = d43;
                        i103 = i37;
                        dMax4 = d;
                        d44 = d75;
                    }
                    arrayRealVector5 = arrayRealVector2;
                } else {
                    double d82 = d46 * d46;
                    double dMax12 = d43;
                    double d83 = dMax12;
                    int i155 = 0;
                    i100 = 0;
                    while (true) {
                        int i156 = i100;
                        if (i155 >= i95) {
                            break;
                        }
                        if (i155 == bOBYQAOptimizer.trustRegionCenterInterpolationPointIndex) {
                            d14 = d75;
                        } else {
                            double d84 = d43;
                            int i157 = 0;
                            while (i157 < i97) {
                                double d85 = d75;
                                double entry25 = bOBYQAOptimizer.zMatrix.getEntry(i155, i157);
                                d84 = (entry25 * entry25) + d84;
                                i157++;
                                d75 = d85;
                            }
                            d14 = d75;
                            double entry26 = bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i155);
                            double d86 = (entry26 * entry26) + (d84 * d81);
                            dMax3 = d43;
                            int i158 = 0;
                            while (i158 < dimension) {
                                double d87 = d86;
                                double entry27 = bOBYQAOptimizer.interpolationPoints.getEntry(i155, i158) - bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i158);
                                dMax3 = (entry27 * entry27) + dMax3;
                                i158++;
                                d86 = d87;
                            }
                            double d88 = d86;
                            double d89 = dMax3 / d82;
                            double d90 = d83;
                            double dMax13 = FastMath.max(d58, d89 * d89);
                            d83 = dMax13 * d88;
                            if (d83 > d90) {
                                i156 = i155;
                                d55 = d88;
                            } else {
                                d83 = d90;
                            }
                            double entry28 = bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i155);
                            dMax12 = FastMath.max(dMax12, dMax13 * entry28 * entry28);
                        }
                        i100 = i156;
                        i155++;
                        d75 = d14;
                        d58 = 1.0d;
                    }
                    d13 = d81;
                    d48 = d73;
                    d44 = d75;
                }
                printState(i36);
                i48 = 0;
                while (i48 < dimension) {
                    double d610 = d13;
                    int i1111 = i100;
                    bOBYQAOptimizer.currentBest.setEntry(i48, FastMath.min(FastMath.max(dArr[i48], bOBYQAOptimizer.newPoint.getEntry(i48) + bOBYQAOptimizer.originShift.getEntry(i48)), dArr2[i48]));
                    if (bOBYQAOptimizer.newPoint.getEntry(i48) == bOBYQAOptimizer.lowerDifference.getEntry(i48)) {
                        bOBYQAOptimizer.currentBest.setEntry(i48, dArr[i48]);
                    }
                    if (bOBYQAOptimizer.newPoint.getEntry(i48) == bOBYQAOptimizer.upperDifference.getEntry(i48)) {
                        bOBYQAOptimizer.currentBest.setEntry(i48, dArr2[i48]);
                    }
                    i48++;
                    i100 = i1111;
                    d13 = d610;
                }
                d18 = d13;
                i49 = i100;
                dComputeObjectiveValue = bOBYQAOptimizer.computeObjectiveValue(bOBYQAOptimizer.currentBest.toArray());
                if (!bOBYQAOptimizer.isMinimize) {
                    dComputeObjectiveValue = -dComputeObjectiveValue;
                }
                d19 = dComputeObjectiveValue;
                if (i101 == -1) {
                    entry14 = d19;
                    i100 = i49;
                    i103 = i38;
                    d56 = d18;
                    dMax4 = d;
                    d50 = entry14;
                    arrayRealVector5 = arrayRealVector2;
                } else {
                    entry6 = bOBYQAOptimizer.fAtInterpolationPoints.getEntry(bOBYQAOptimizer.trustRegionCenterInterpolationPointIndex);
                    entry7 = d43;
                    i50 = 0;
                    i51 = 0;
                    while (i50 < dimension) {
                        i93 = i51;
                        entry7 = AbstractC1125a.e(bOBYQAOptimizer.gradientAtTrustRegionCenter, i50, bOBYQAOptimizer.trialStepPoint.getEntry(i50), entry7);
                        while (i94 <= i50) {
                            entry13 = bOBYQAOptimizer.trialStepPoint.getEntry(i50) * bOBYQAOptimizer.trialStepPoint.getEntry(i94);
                            if (i94 == i50) {
                                entry13 *= HALF;
                            }
                            entry7 = AbstractC1125a.e(bOBYQAOptimizer.modelSecondDerivativesValues, i93, entry13, entry7);
                            i93++;
                        }
                        i50++;
                        i51 = i93;
                    }
                    while (i52 < i95) {
                        double entry113 = arrayRealVector6.getEntry(i52);
                        entry7 = (bOBYQAOptimizer.modelSecondDerivativesParameters.getEntry(i52) * HALF * entry113 * entry113) + entry7;
                    }
                    d20 = d19 - entry6;
                    d21 = d20 - entry7;
                    dAbs = FastMath.abs(d21);
                    d22 = d54;
                    if (d22 > d47) {
                        evaluations = bOBYQAOptimizer.getEvaluations();
                    }
                    if (i101 > 0) {
                        d23 = d48;
                        d54 = d22;
                        i53 = i101;
                        i54 = i49;
                        d43 = d43;
                        d47 = d47;
                        d18 = d18;
                        d24 = d55;
                        d25 = d46;
                    } else {
                        if (entry7 < d43) {
                            throw new MathIllegalStateException(LocalizedFormats.TRUST_REGION_STEP_FAILED, Double.valueOf(entry7));
                        }
                        d57 = d20 / entry7;
                        d35 = d46 * HALF;
                        if (d57 <= ONE_OVER_TEN) {
                            dMax = FastMath.min(d35, d22);
                        } else {
                            if (d57 <= 0.7d) {
                                dMax = FastMath.max(d35, d22);
                            } else {
                                d54 = d22;
                                dMax = FastMath.max(d35, d54 * TWO);
                            }
                            if (dMax <= d47 * 1.5d) {
                                dMax = d47;
                            }
                            if (d19 < entry6) {
                                d36 = dMax * dMax;
                                d25 = dMax;
                                dMax2 = d43;
                                d37 = dMax2;
                                i87 = 0;
                                i88 = 0;
                                d38 = d55;
                                while (i87 < i95) {
                                    i90 = i88;
                                    d39 = d43;
                                    i91 = 0;
                                    while (i91 < i97) {
                                        double entry114 = bOBYQAOptimizer.zMatrix.getEntry(i87, i91);
                                        d39 = (entry114 * entry114) + d39;
                                        i91++;
                                        i101 = i101;
                                    }
                                    int i1112 = i101;
                                    double entry115 = bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i87);
                                    d40 = (entry115 * entry115) + (d39 * d18);
                                    dMax3 = d43;
                                    while (i92 < dimension) {
                                        double entry29 = bOBYQAOptimizer.interpolationPoints.getEntry(i87, i92) - bOBYQAOptimizer.newPoint.getEntry(i92);
                                        dMax3 = (entry29 * entry29) + dMax3;
                                    }
                                    double d611 = dMax3 / d36;
                                    double d612 = d48;
                                    double dMax14 = FastMath.max(1.0d, d611 * d611);
                                    d41 = dMax14 * d40;
                                    if (d41 > d37) {
                                        i90 = i87;
                                        d37 = d41;
                                        d38 = d40;
                                    }
                                    double entry210 = bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i87);
                                    dMax2 = FastMath.max(dMax2, entry210 * entry210 * dMax14);
                                    i87++;
                                    i88 = i90;
                                    i101 = i1112;
                                    d48 = d612;
                                }
                                i89 = i88;
                                int i1113 = i101;
                                d23 = d48;
                                if (d37 <= dMax2 * HALF) {
                                    i54 = i49;
                                    d24 = d55;
                                } else {
                                    i54 = i89;
                                    d24 = d38;
                                }
                                i53 = i1113;
                            } else {
                                d25 = dMax;
                                d23 = d48;
                                i53 = i101;
                                i54 = i49;
                                d43 = d43;
                                d47 = d47;
                                d18 = d18;
                                d24 = d55;
                                d54 = d54;
                            }
                        }
                        d54 = d22;
                        if (dMax <= d47 * 1.5d) {
                            dMax = d47;
                        }
                        if (d19 < entry6) {
                            d36 = dMax * dMax;
                            d25 = dMax;
                            dMax2 = d43;
                            d37 = dMax2;
                            i87 = 0;
                            i88 = 0;
                            d38 = d55;
                            while (i87 < i95) {
                                i90 = i88;
                                d39 = d43;
                                i91 = 0;
                                while (i91 < i97) {
                                    double entry116 = bOBYQAOptimizer.zMatrix.getEntry(i87, i91);
                                    d39 = (entry116 * entry116) + d39;
                                    i91++;
                                    i101 = i101;
                                }
                                int i1114 = i101;
                                double entry117 = bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i87);
                                d40 = (entry117 * entry117) + (d39 * d18);
                                dMax3 = d43;
                                while (i92 < dimension) {
                                    double entry211 = bOBYQAOptimizer.interpolationPoints.getEntry(i87, i92) - bOBYQAOptimizer.newPoint.getEntry(i92);
                                    dMax3 = (entry211 * entry211) + dMax3;
                                }
                                double d613 = dMax3 / d36;
                                double d614 = d48;
                                double dMax15 = FastMath.max(1.0d, d613 * d613);
                                d41 = dMax15 * d40;
                                if (d41 > d37) {
                                    i90 = i87;
                                    d37 = d41;
                                    d38 = d40;
                                }
                                double entry212 = bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i87);
                                dMax2 = FastMath.max(dMax2, entry212 * entry212 * dMax15);
                                i87++;
                                i88 = i90;
                                i101 = i1114;
                                d48 = d614;
                            }
                            i89 = i88;
                            int i1115 = i101;
                            d23 = d48;
                            if (d37 <= dMax2 * HALF) {
                                i54 = i49;
                                d24 = d55;
                            } else {
                                i54 = i89;
                                d24 = d38;
                            }
                            i53 = i1115;
                        } else {
                            d25 = dMax;
                            d23 = d48;
                            i53 = i101;
                            i54 = i49;
                            d43 = d43;
                            d47 = d47;
                            d18 = d18;
                            d24 = d55;
                            d54 = d54;
                        }
                    }
                    i43 = 90;
                    bOBYQAOptimizer.update(d18, d24, i54);
                    d26 = d18;
                    d55 = d24;
                    i55 = i54;
                    entry8 = bOBYQAOptimizer.modelSecondDerivativesParameters.getEntry(i55);
                    bOBYQAOptimizer.modelSecondDerivativesParameters.setEntry(i55, d43);
                    i57 = 0;
                    while (i56 < dimension) {
                        entry12 = bOBYQAOptimizer.interpolationPoints.getEntry(i55, i56) * entry8;
                        i86 = 0;
                        while (i86 <= i56) {
                            ArrayRealVector arrayRealVector110 = bOBYQAOptimizer.modelSecondDerivativesValues;
                            int i1210 = i55;
                            int i1211 = i86;
                            arrayRealVector110.setEntry(i57, AbstractC1125a.c(bOBYQAOptimizer.interpolationPoints, i1210, i1211, entry12, arrayRealVector110.getEntry(i57)));
                            i57++;
                            i86 = i1211 + 1;
                            i55 = i1210;
                            entry8 = entry8;
                        }
                    }
                    i58 = i55;
                    i59 = 0;
                    while (i59 < i97) {
                        entry11 = bOBYQAOptimizer.zMatrix.getEntry(i58, i59) * d21;
                        i85 = 0;
                        while (i85 < i95) {
                            ArrayRealVector arrayRealVector111 = bOBYQAOptimizer.modelSecondDerivativesParameters;
                            int i1212 = i59;
                            int i1213 = i85;
                            arrayRealVector111.setEntry(i1213, AbstractC1125a.c(bOBYQAOptimizer.zMatrix, i1213, i1212, entry11, arrayRealVector111.getEntry(i85)));
                            i85 = i1213 + 1;
                            i59 = i1212;
                        }
                        i59++;
                    }
                    bOBYQAOptimizer.fAtInterpolationPoints.setEntry(i58, d19);
                    while (i60 < dimension) {
                        bOBYQAOptimizer.interpolationPoints.setEntry(i58, i60, bOBYQAOptimizer.newPoint.getEntry(i60));
                        arrayRealVector2.setEntry(i60, bOBYQAOptimizer.bMatrix.getEntry(i58, i60));
                    }
                    arrayRealVector3 = arrayRealVector2;
                    i61 = 0;
                    while (i61 < i95) {
                        i82 = 0;
                        dC = 0.0d;
                        while (i82 < i97) {
                            int i1214 = i82;
                            dC = AbstractC1125a.c(bOBYQAOptimizer.zMatrix, i61, i1214, bOBYQAOptimizer.zMatrix.getEntry(i58, i82), dC);
                            i82 = i1214 + 1;
                        }
                        i83 = 0;
                        dE5 = 0.0d;
                        while (i83 < dimension) {
                            int i1215 = i83;
                            dE5 = AbstractC1125a.e(bOBYQAOptimizer.trustRegionCenterOffset, i1215, bOBYQAOptimizer.interpolationPoints.getEntry(i61, i83), dE5);
                            i83 = i1215 + 1;
                        }
                        d34 = dC * dE5;
                        i84 = 0;
                        while (i84 < dimension) {
                            int i1216 = i61;
                            int i1217 = i84;
                            arrayRealVector3.setEntry(i1217, AbstractC1125a.c(bOBYQAOptimizer.interpolationPoints, i1216, i1217, d34, arrayRealVector3.getEntry(i84)));
                            i84 = i1217 + 1;
                            i61 = i1216;
                        }
                        i61++;
                    }
                    i62 = 0;
                    while (i62 < dimension) {
                        ArrayRealVector arrayRealVector112 = bOBYQAOptimizer.gradientAtTrustRegionCenter;
                        ArrayRealVector arrayRealVector113 = arrayRealVector3;
                        arrayRealVector112.setEntry(i62, AbstractC1125a.e(arrayRealVector113, i62, d21, arrayRealVector112.getEntry(i62)));
                        i62++;
                        arrayRealVector3 = arrayRealVector113;
                        bOBYQAOptimizer = bOBYQAOptimizer;
                        d19 = d19;
                    }
                    d27 = d19;
                    bOBYQAOptimizer = bOBYQAOptimizer;
                    arrayRealVector4 = arrayRealVector3;
                    if (d27 < entry6) {
                        bOBYQAOptimizer.trustRegionCenterInterpolationPointIndex = i58;
                        i76 = 0;
                        i77 = 0;
                        d33 = 0.0d;
                        while (i76 < dimension) {
                            int i1218 = i58;
                            bOBYQAOptimizer.trustRegionCenterOffset.setEntry(i76, bOBYQAOptimizer.newPoint.getEntry(i76));
                            d33 = AbstractC1125a.d(bOBYQAOptimizer.trustRegionCenterOffset, i76, d33);
                            while (i81 <= i76) {
                                if (i81 < i76) {
                                    ArrayRealVector arrayRealVector114 = bOBYQAOptimizer.gradientAtTrustRegionCenter;
                                    arrayRealVector114.setEntry(i76, AbstractC1125a.e(bOBYQAOptimizer.trialStepPoint, i81, bOBYQAOptimizer.modelSecondDerivativesValues.getEntry(i77), arrayRealVector114.getEntry(i76)));
                                }
                                ArrayRealVector arrayRealVector115 = bOBYQAOptimizer.gradientAtTrustRegionCenter;
                                arrayRealVector115.setEntry(i81, AbstractC1125a.e(bOBYQAOptimizer.trialStepPoint, i76, bOBYQAOptimizer.modelSecondDerivativesValues.getEntry(i77), arrayRealVector115.getEntry(i81)));
                                i77++;
                            }
                            i76++;
                            i58 = i1218;
                        }
                        i63 = i58;
                        i78 = 0;
                        while (i78 < i95) {
                            i79 = 0;
                            dE4 = 0.0d;
                            while (i79 < dimension) {
                                int i1219 = i79;
                                dE4 = AbstractC1125a.e(bOBYQAOptimizer.trialStepPoint, i1219, bOBYQAOptimizer.interpolationPoints.getEntry(i78, i79), dE4);
                                i79 = i1219 + 1;
                            }
                            entry10 = bOBYQAOptimizer.modelSecondDerivativesParameters.getEntry(i78) * dE4;
                            i80 = 0;
                            while (i80 < dimension) {
                                ArrayRealVector arrayRealVector116 = bOBYQAOptimizer.gradientAtTrustRegionCenter;
                                int i1310 = i78;
                                int i1311 = i80;
                                arrayRealVector116.setEntry(i1311, AbstractC1125a.c(bOBYQAOptimizer.interpolationPoints, i1310, i1311, entry10, arrayRealVector116.getEntry(i80)));
                                i80 = i1311 + 1;
                                i78 = i1310;
                            }
                            i78++;
                        }
                        d45 = d33;
                    } else {
                        i63 = i58;
                    }
                    i64 = i53;
                    if (i64 > 0) {
                        while (i65 < i95) {
                            bOBYQAOptimizer.lagrangeValuesAtNewPoint.setEntry(i65, bOBYQAOptimizer.fAtInterpolationPoints.getEntry(i65) - bOBYQAOptimizer.fAtInterpolationPoints.getEntry(bOBYQAOptimizer.trustRegionCenterInterpolationPointIndex));
                            arrayRealVector7.setEntry(i65, 0.0d);
                        }
                        i66 = 0;
                        while (i66 < i97) {
                            i74 = 0;
                            dE3 = 0.0d;
                            while (i74 < i95) {
                                int i1312 = i74;
                                dE3 = AbstractC1125a.e(bOBYQAOptimizer.lagrangeValuesAtNewPoint, i1312, bOBYQAOptimizer.zMatrix.getEntry(i74, i66), dE3);
                                i74 = i1312 + 1;
                            }
                            i75 = 0;
                            while (i75 < i95) {
                                int i1313 = i66;
                                int i1314 = i75;
                                arrayRealVector7.setEntry(i1314, AbstractC1125a.c(bOBYQAOptimizer.zMatrix, i1314, i1313, dE3, arrayRealVector7.getEntry(i75)));
                                i75 = i1314 + 1;
                                i66 = i1313;
                            }
                            i66++;
                        }
                        while (i67 < i95) {
                            i73 = 0;
                            dE2 = 0.0d;
                            while (i73 < dimension) {
                                int i1315 = i73;
                                dE2 = AbstractC1125a.e(bOBYQAOptimizer.trustRegionCenterOffset, i1315, bOBYQAOptimizer.interpolationPoints.getEntry(i67, i73), dE2);
                                i73 = i1315 + 1;
                            }
                            arrayRealVector6.setEntry(i67, arrayRealVector7.getEntry(i67));
                            arrayRealVector7.setEntry(i67, arrayRealVector7.getEntry(i67) * dE2);
                        }
                        i68 = 0;
                        d28 = 0.0d;
                        d29 = 0.0d;
                        while (i68 < dimension) {
                            ArrayRealVector arrayRealVector117 = arrayRealVector4;
                            i72 = 0;
                            entry9 = 0.0d;
                            while (i72 < i95) {
                                entry9 = (arrayRealVector7.getEntry(i72) * bOBYQAOptimizer.interpolationPoints.getEntry(i72, i68)) + (bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i72) * bOBYQAOptimizer.bMatrix.getEntry(i72, i68)) + entry9;
                                i72++;
                                d29 = d29;
                            }
                            d30 = d29;
                            if (bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i68) == bOBYQAOptimizer.lowerDifference.getEntry(i68)) {
                                double dMin4 = FastMath.min(0.0d, bOBYQAOptimizer.gradientAtTrustRegionCenter.getEntry(i68));
                                double d615 = (dMin4 * dMin4) + d28;
                                double dMin5 = FastMath.min(0.0d, entry9);
                                d29 = (dMin5 * dMin5) + d30;
                                d28 = d615;
                            } else {
                                if (bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i68) == bOBYQAOptimizer.upperDifference.getEntry(i68)) {
                                    double dMax16 = FastMath.max(0.0d, bOBYQAOptimizer.gradientAtTrustRegionCenter.getEntry(i68));
                                    d31 = (dMax16 * dMax16) + d28;
                                    double dMax17 = FastMath.max(0.0d, entry9);
                                    d32 = dMax17 * dMax17;
                                } else {
                                    d31 = AbstractC1125a.d(bOBYQAOptimizer.gradientAtTrustRegionCenter, i68, d28);
                                    d32 = entry9 * entry9;
                                }
                                d29 = d32 + d30;
                                d28 = d31;
                            }
                            bOBYQAOptimizer.lagrangeValuesAtNewPoint.setEntry(i95 + i68, entry9);
                            i68++;
                            arrayRealVector4 = arrayRealVector117;
                            i64 = i64;
                        }
                        arrayRealVector5 = arrayRealVector4;
                        i41 = i64;
                        i69 = i102 + 1;
                        if (d28 < d29 * 10.0d) {
                            i70 = 0;
                        } else {
                            i70 = i69;
                        }
                        if (i70 >= 3) {
                            iMax = FastMath.max(i95, i98);
                            i71 = 0;
                            while (i71 < iMax) {
                                if (i71 < dimension) {
                                    bOBYQAOptimizer.gradientAtTrustRegionCenter.setEntry(i71, bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i95 + i71));
                                }
                                if (i71 < i95) {
                                    bOBYQAOptimizer.modelSecondDerivativesParameters.setEntry(i71, arrayRealVector6.getEntry(i71));
                                }
                                if (i71 < i98) {
                                    bOBYQAOptimizer.modelSecondDerivativesValues.setEntry(i71, 0.0d);
                                }
                                i71++;
                                i70 = 0;
                            }
                        }
                        i102 = i70;
                    } else {
                        arrayRealVector5 = arrayRealVector4;
                        i41 = i64;
                    }
                    if (i41 != 0) {
                        double d616 = TWO * d25;
                        d47 = d47;
                        double d617 = d47 * 10.0d;
                        dMax3 = FastMath.max(d616 * d616, d617 * d617);
                        d56 = d26;
                        d53 = d52;
                        dMin = d25;
                        d48 = d23;
                        i42 = 650;
                        d50 = d27;
                        d52 = d51;
                        d51 = dAbs;
                        printState(i42);
                        i45 = -1;
                        while (i44 < i95) {
                            i46 = 0;
                            d17 = 0.0d;
                            while (i46 < dimension) {
                                double entry118 = bOBYQAOptimizer.interpolationPoints.getEntry(i44, i46) - bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i46);
                                d17 = (entry118 * entry118) + d17;
                                i46++;
                                i45 = i45;
                            }
                            i47 = i45;
                            if (d17 > dMax3) {
                                i45 = i44;
                                dMax3 = d17;
                            } else {
                                i45 = i47;
                            }
                        }
                        i100 = i45;
                        if (i100 >= 0) {
                            dSqrt2 = FastMath.sqrt(dMax3);
                            if (i41 == -1) {
                                dMin = FastMath.min(dMin * ONE_OVER_TEN, dSqrt2 * HALF);
                                if (dMin <= d47 * 1.5d) {
                                    dMin = d47;
                                }
                            }
                            dMax4 = FastMath.max(FastMath.min(dSqrt2 * ONE_OVER_TEN, dMin), d47);
                            d44 = dMax4 * dMax4;
                            d46 = dMin;
                            i101 = 0;
                            i103 = i43;
                        } else {
                            i40 = i41;
                            if (i40 == -1) {
                                d46 = dMin;
                                i101 = i40;
                                dMax4 = d;
                                i103 = 680;
                            } else {
                                d43 = 0.0d;
                                if (d57 > 0.0d) {
                                    d47 = d47;
                                    d46 = dMin;
                                    bOBYQAOptimizer = bOBYQAOptimizer;
                                    i101 = i40;
                                    i100 = i100;
                                    arrayRealVector5 = arrayRealVector5;
                                    i103 = 60;
                                    dMax4 = d;
                                    d54 = d54;
                                } else {
                                    d16 = d54;
                                    if (FastMath.max(dMin, d16) <= d47) {
                                        i39 = 680;
                                        printState(i39);
                                        d47 = d47;
                                        dSqrt = bOBYQAOptimizer.stoppingTrustRegionRadius;
                                        if (d47 > dSqrt) {
                                            if (i40 == -1) {
                                                break;
                                                break;
                                            }
                                            d46 = dMin;
                                            d54 = d16;
                                            bOBYQAOptimizer = bOBYQAOptimizer;
                                            i101 = i40;
                                            i100 = i100;
                                            i103 = i36;
                                            arrayRealVector5 = arrayRealVector5;
                                            dMax4 = d;
                                            d47 = d47;
                                        } else {
                                            double d512 = d47 * HALF;
                                            d57 = d47 / dSqrt;
                                            if (d57 > SIXTEEN) {
                                                if (d57 <= TWO_HUNDRED_FIFTY) {
                                                    dSqrt = bOBYQAOptimizer.stoppingTrustRegionRadius * FastMath.sqrt(d57);
                                                } else {
                                                    dSqrt = d47 * ONE_OVER_TEN;
                                                }
                                            }
                                            double dMax18 = FastMath.max(d512, dSqrt);
                                            evaluations = bOBYQAOptimizer.getEvaluations();
                                            d47 = dSqrt;
                                            d46 = dMax18;
                                            d54 = d16;
                                            bOBYQAOptimizer = bOBYQAOptimizer;
                                            i100 = i100;
                                            i101 = 0;
                                        }
                                    } else {
                                        d47 = d47;
                                        d46 = dMin;
                                        d54 = d16;
                                        bOBYQAOptimizer = bOBYQAOptimizer;
                                        i101 = i40;
                                        i100 = i100;
                                    }
                                    arrayRealVector5 = arrayRealVector5;
                                    i103 = 60;
                                    dMax4 = d;
                                }
                            }
                        }
                        d43 = 0.0d;
                    }
                    bOBYQAOptimizer = bOBYQAOptimizer;
                    i100 = i63;
                    d56 = d26;
                    d53 = d52;
                    arrayRealVector5 = arrayRealVector5;
                    d46 = d25;
                    i103 = 60;
                    dMax4 = d;
                    i101 = i41;
                    d48 = d23;
                    d54 = d54;
                    d43 = 0.0d;
                    d50 = d27;
                    d52 = d51;
                    d51 = dAbs;
                    d47 = d47;
                }
            } else {
                d = dMax4;
                d8 = d54;
                i6 = 210;
                i10 = 230;
                d52 = d52;
                i7 = 90;
                d48 = d48;
                d7 = d44;
                d43 = d43;
                d47 = d47;
                i100 = i100;
                i98 = i98;
                arrayRealVector7 = arrayRealVector7;
                arrayRealVector5 = arrayRealVector5;
                i101 = i101;
                printState(i7);
                if (d7 <= 0.001d * d45) {
                    d9 = d45 * ONE_OVER_FOUR;
                    i15 = 0;
                    entry = d43;
                    while (i15 < i95) {
                        entry = bOBYQAOptimizer.modelSecondDerivativesParameters.getEntry(i15) + entry;
                        i32 = 0;
                        dE = (-0.5d) * d45;
                        while (i32 < dimension) {
                            int i159 = i32;
                            dE = AbstractC1125a.e(bOBYQAOptimizer.trustRegionCenterOffset, i159, bOBYQAOptimizer.interpolationPoints.getEntry(i15, i32), dE);
                            i32 = i159 + 1;
                        }
                        d10 = dE;
                        arrayRealVector6.setEntry(i15, d10);
                        d11 = d9 - (d10 * HALF);
                        i33 = 0;
                        while (i33 < dimension) {
                            arrayRealVector5.setEntry(i33, bOBYQAOptimizer.bMatrix.getEntry(i15, i33));
                            double d91 = d10;
                            bOBYQAOptimizer.lagrangeValuesAtNewPoint.setEntry(i33, AbstractC1125a.e(bOBYQAOptimizer.trustRegionCenterOffset, i33, d11, bOBYQAOptimizer.interpolationPoints.getEntry(i15, i33) * d10));
                            i34 = i95 + i33;
                            i35 = 0;
                            while (i35 <= i33) {
                                Array2DRowRealMatrix array2DRowRealMatrix = bOBYQAOptimizer.bMatrix;
                                int i160 = i35;
                                double dE15 = AbstractC1125a.e(bOBYQAOptimizer.lagrangeValuesAtNewPoint, i160, arrayRealVector5.getEntry(i33), array2DRowRealMatrix.getEntry(i34, i35));
                                ArrayRealVector arrayRealVector21 = arrayRealVector5;
                                double d92 = d53;
                                int i161 = i34;
                                array2DRowRealMatrix.setEntry(i161, i160, AbstractC1125a.e(arrayRealVector21, i160, bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i33), dE15));
                                i35 = i160 + 1;
                                arrayRealVector5 = arrayRealVector21;
                                bOBYQAOptimizer = bOBYQAOptimizer;
                                i34 = i161;
                                d53 = d92;
                                i33 = i33;
                            }
                            i33++;
                            arrayRealVector5 = arrayRealVector5;
                            bOBYQAOptimizer = bOBYQAOptimizer;
                            d10 = d91;
                        }
                        i15++;
                        arrayRealVector5 = arrayRealVector5;
                        bOBYQAOptimizer = bOBYQAOptimizer;
                        d53 = d53;
                    }
                    ArrayRealVector arrayRealVector22 = arrayRealVector5;
                    bOBYQAOptimizer = bOBYQAOptimizer;
                    arrayRealVector5 = arrayRealVector22;
                    d53 = d53;
                    i16 = 0;
                    while (i16 < i97) {
                        entry2 = d43;
                        entry3 = entry2;
                        for (i24 = 0; i24 < i95; i24++) {
                            entry2 = bOBYQAOptimizer.zMatrix.getEntry(i24, i16) + entry2;
                            bOBYQAOptimizer.lagrangeValuesAtNewPoint.setEntry(i24, arrayRealVector6.getEntry(i24) * bOBYQAOptimizer.zMatrix.getEntry(i24, i16));
                            entry3 = bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i24) + entry3;
                        }
                        i25 = 0;
                        while (i25 < dimension) {
                            entry5 = bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i25) * ((d9 * entry2) - (entry3 * HALF));
                            i29 = 0;
                            while (i29 < i95) {
                                int i162 = i29;
                                int i163 = i25;
                                entry5 = AbstractC1125a.c(bOBYQAOptimizer.interpolationPoints, i162, i163, bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i29), entry5);
                                i29 = i162 + 1;
                                i25 = i163;
                            }
                            i30 = i25;
                            arrayRealVector5.setEntry(i30, entry5);
                            i31 = 0;
                            while (i31 < i95) {
                                Array2DRowRealMatrix array2DRowRealMatrix2 = bOBYQAOptimizer.bMatrix;
                                array2DRowRealMatrix2.setEntry(i31, i30, AbstractC1125a.c(bOBYQAOptimizer.zMatrix, i31, i16, entry5, array2DRowRealMatrix2.getEntry(i31, i30)));
                                i31++;
                                i97 = i97;
                            }
                            i25 = i30 + 1;
                        }
                        int i164 = i16;
                        int i165 = i97;
                        for (i26 = 0; i26 < dimension; i26++) {
                            i27 = i26 + i95;
                            entry4 = arrayRealVector5.getEntry(i26);
                            for (i28 = 0; i28 <= i26; i28++) {
                                Array2DRowRealMatrix array2DRowRealMatrix3 = bOBYQAOptimizer.bMatrix;
                                array2DRowRealMatrix3.setEntry(i27, i28, AbstractC1125a.e(arrayRealVector5, i28, entry4, array2DRowRealMatrix3.getEntry(i27, i28)));
                            }
                        }
                        i16 = i164 + 1;
                        i97 = i165;
                    }
                    i14 = i97;
                    i17 = 0;
                    i18 = 0;
                    while (i17 < dimension) {
                        arrayRealVector5.setEntry(i17, bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i17) * entry * (-0.5d));
                        i20 = 0;
                        while (i20 < i95) {
                            int i166 = i17;
                            int i167 = i20;
                            arrayRealVector5.setEntry(i166, AbstractC1125a.c(bOBYQAOptimizer.interpolationPoints, i167, i166, bOBYQAOptimizer.modelSecondDerivativesParameters.getEntry(i20), arrayRealVector5.getEntry(i17)));
                            Array2DRowRealMatrix array2DRowRealMatrix4 = bOBYQAOptimizer.interpolationPoints;
                            array2DRowRealMatrix4.setEntry(i167, i166, array2DRowRealMatrix4.getEntry(i167, i166) - bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i166));
                            i20 = i167 + 1;
                            i17 = i166;
                        }
                        i21 = i18;
                        i22 = 0;
                        while (true) {
                            i23 = i17;
                            if (i22 <= i23) {
                                ArrayRealVector arrayRealVector23 = bOBYQAOptimizer.modelSecondDerivativesValues;
                                i17 = i23;
                                arrayRealVector23.setEntry(i21, AbstractC1125a.e(arrayRealVector5, i17, bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i22), AbstractC1125a.e(bOBYQAOptimizer.trustRegionCenterOffset, i23, arrayRealVector5.getEntry(i22), arrayRealVector23.getEntry(i21))));
                                Array2DRowRealMatrix array2DRowRealMatrix5 = bOBYQAOptimizer.bMatrix;
                                array2DRowRealMatrix5.setEntry(i95 + i22, i17, array2DRowRealMatrix5.getEntry(i95 + i17, i22));
                                i21++;
                                i22++;
                            }
                        }
                        i17 = i23 + 1;
                        i18 = i21;
                    }
                    for (i19 = 0; i19 < dimension; i19++) {
                        ArrayRealVector arrayRealVector24 = bOBYQAOptimizer.originShift;
                        arrayRealVector24.setEntry(i19, bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i19) + arrayRealVector24.getEntry(i19));
                        ArrayRealVector arrayRealVector25 = bOBYQAOptimizer.newPoint;
                        arrayRealVector25.setEntry(i19, arrayRealVector25.getEntry(i19) - bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i19));
                        ArrayRealVector arrayRealVector26 = bOBYQAOptimizer.lowerDifference;
                        arrayRealVector26.setEntry(i19, arrayRealVector26.getEntry(i19) - bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i19));
                        ArrayRealVector arrayRealVector27 = bOBYQAOptimizer.upperDifference;
                        arrayRealVector27.setEntry(i19, arrayRealVector27.getEntry(i19) - bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i19));
                        bOBYQAOptimizer.trustRegionCenterOffset.setEntry(i19, d43);
                    }
                    d43 = d43;
                    d45 = d43;
                } else {
                    ArrayRealVector arrayRealVector28 = arrayRealVector5;
                    bOBYQAOptimizer = bOBYQAOptimizer;
                    arrayRealVector5 = arrayRealVector28;
                    i14 = i97;
                    d43 = d43;
                }
                if (i101 == 0) {
                    d53 = d53;
                    d51 = d51;
                    i103 = i6;
                } else {
                    d53 = d53;
                    d51 = d51;
                    i103 = i10;
                }
                i97 = i14;
                d44 = d7;
                d46 = d46;
                dMax4 = d;
                d54 = d8;
                d47 = d47;
            }
            printState(i5);
            int i168 = i11;
            bOBYQAOptimizer = this;
            i98 = i98;
            d48 = d48;
            arrayRealVector5 = arrayRealVector;
            i101 = -1;
            arrayRealVector7 = arrayRealVector7;
            double[] dArrTrsbox = bOBYQAOptimizer.trsbox(d46, new ArrayRealVector(dimension), new ArrayRealVector(dimension), new ArrayRealVector(dimension), new ArrayRealVector(dimension), new ArrayRealVector(dimension));
            double d93 = dArrTrsbox[0];
            double d94 = dArrTrsbox[1];
            d43 = d43;
            double dMin6 = FastMath.min(d46, FastMath.sqrt(d93));
            if (dMin6 < d47 * HALF) {
                double d95 = d47 * 10.0d;
                dMax3 = d95 * d95;
                d44 = d93;
                if (bOBYQAOptimizer.getEvaluations() <= evaluations + 2) {
                    d46 = d46;
                    i103 = i9;
                } else {
                    double d96 = d51;
                    double d97 = d52;
                    double dMax19 = FastMath.max(d96, d97);
                    double d98 = d53;
                    double dMax20 = FastMath.max(dMax19, d98);
                    double d99 = d47 * ONE_OVER_EIGHT * d47;
                    if (d94 <= d43 || dMax20 <= d99 * d94) {
                        double d100 = dMax20 / d47;
                        int i169 = 0;
                        while (true) {
                            d6 = d96;
                            if (i169 >= dimension) {
                                break;
                            }
                            double entry30 = bOBYQAOptimizer.newPoint.getEntry(i169) == bOBYQAOptimizer.upperDifference.getEntry(i169) ? -arrayRealVector5.getEntry(i169) : bOBYQAOptimizer.newPoint.getEntry(i169) == bOBYQAOptimizer.lowerDifference.getEntry(i169) ? arrayRealVector5.getEntry(i169) : d100;
                            if (entry30 < d100) {
                                double entry31 = bOBYQAOptimizer.modelSecondDerivativesValues.getEntry(((i169 * i169) + i169) / 2);
                                for (int i170 = 0; i170 < i95; i170++) {
                                    double entry32 = bOBYQAOptimizer.interpolationPoints.getEntry(i170, i169);
                                    entry31 = a.C(entry32, entry32, bOBYQAOptimizer.modelSecondDerivativesParameters.getEntry(i170), entry31);
                                }
                                if (a.C(entry31, HALF, d47, entry30) < d100) {
                                    break;
                                }
                            }
                            i169++;
                            d96 = d6;
                        }
                        d52 = d97;
                        d51 = d6;
                        d53 = d98;
                        i103 = i8;
                        d46 = d46;
                    } else {
                        d53 = d98;
                        arrayRealVector5 = arrayRealVector5;
                        i100 = i100;
                        i98 = i98;
                        d52 = d97;
                        d43 = d43;
                        i103 = i9;
                        i101 = -1;
                        dMax3 = dMax3;
                        d44 = d44;
                        d47 = d47;
                        d51 = d96;
                        d54 = dMin6;
                        arrayRealVector7 = arrayRealVector7;
                        d48 = d48;
                        d46 = d46;
                    }
                    dMax4 = d;
                }
                d47 = d47;
                d54 = dMin6;
                arrayRealVector7 = arrayRealVector7;
                d48 = d48;
                dMax4 = d;
            } else {
                d52 = d52;
                d7 = d93;
                d46 = d46;
                d8 = dMin6;
                i101 = i168 + 1;
                printState(i7);
                if (d7 <= 0.001d * d45) {
                    d9 = d45 * ONE_OVER_FOUR;
                    i15 = 0;
                    entry = d43;
                    while (i15 < i95) {
                        entry = bOBYQAOptimizer.modelSecondDerivativesParameters.getEntry(i15) + entry;
                        i32 = 0;
                        dE = (-0.5d) * d45;
                        while (i32 < dimension) {
                            int i1510 = i32;
                            dE = AbstractC1125a.e(bOBYQAOptimizer.trustRegionCenterOffset, i1510, bOBYQAOptimizer.interpolationPoints.getEntry(i15, i32), dE);
                            i32 = i1510 + 1;
                        }
                        d10 = dE;
                        arrayRealVector6.setEntry(i15, d10);
                        d11 = d9 - (d10 * HALF);
                        i33 = 0;
                        while (i33 < dimension) {
                            arrayRealVector5.setEntry(i33, bOBYQAOptimizer.bMatrix.getEntry(i15, i33));
                            double d910 = d10;
                            bOBYQAOptimizer.lagrangeValuesAtNewPoint.setEntry(i33, AbstractC1125a.e(bOBYQAOptimizer.trustRegionCenterOffset, i33, d11, bOBYQAOptimizer.interpolationPoints.getEntry(i15, i33) * d10));
                            i34 = i95 + i33;
                            i35 = 0;
                            while (i35 <= i33) {
                                Array2DRowRealMatrix array2DRowRealMatrix6 = bOBYQAOptimizer.bMatrix;
                                int i1610 = i35;
                                double dE16 = AbstractC1125a.e(bOBYQAOptimizer.lagrangeValuesAtNewPoint, i1610, arrayRealVector5.getEntry(i33), array2DRowRealMatrix6.getEntry(i34, i35));
                                ArrayRealVector arrayRealVector29 = arrayRealVector5;
                                double d911 = d53;
                                int i1611 = i34;
                                array2DRowRealMatrix6.setEntry(i1611, i1610, AbstractC1125a.e(arrayRealVector29, i1610, bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i33), dE16));
                                i35 = i1610 + 1;
                                arrayRealVector5 = arrayRealVector29;
                                bOBYQAOptimizer = bOBYQAOptimizer;
                                i34 = i1611;
                                d53 = d911;
                                i33 = i33;
                            }
                            i33++;
                            arrayRealVector5 = arrayRealVector5;
                            bOBYQAOptimizer = bOBYQAOptimizer;
                            d10 = d910;
                        }
                        i15++;
                        arrayRealVector5 = arrayRealVector5;
                        bOBYQAOptimizer = bOBYQAOptimizer;
                        d53 = d53;
                    }
                    ArrayRealVector arrayRealVector210 = arrayRealVector5;
                    bOBYQAOptimizer = bOBYQAOptimizer;
                    arrayRealVector5 = arrayRealVector210;
                    d53 = d53;
                    i16 = 0;
                    while (i16 < i97) {
                        entry2 = d43;
                        entry3 = entry2;
                        while (i24 < i95) {
                            entry2 = bOBYQAOptimizer.zMatrix.getEntry(i24, i16) + entry2;
                            bOBYQAOptimizer.lagrangeValuesAtNewPoint.setEntry(i24, arrayRealVector6.getEntry(i24) * bOBYQAOptimizer.zMatrix.getEntry(i24, i16));
                            entry3 = bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i24) + entry3;
                        }
                        i25 = 0;
                        while (i25 < dimension) {
                            entry5 = bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i25) * ((d9 * entry2) - (entry3 * HALF));
                            i29 = 0;
                            while (i29 < i95) {
                                int i1612 = i29;
                                int i1613 = i25;
                                entry5 = AbstractC1125a.c(bOBYQAOptimizer.interpolationPoints, i1612, i1613, bOBYQAOptimizer.lagrangeValuesAtNewPoint.getEntry(i29), entry5);
                                i29 = i1612 + 1;
                                i25 = i1613;
                            }
                            i30 = i25;
                            arrayRealVector5.setEntry(i30, entry5);
                            i31 = 0;
                            while (i31 < i95) {
                                Array2DRowRealMatrix array2DRowRealMatrix7 = bOBYQAOptimizer.bMatrix;
                                array2DRowRealMatrix7.setEntry(i31, i30, AbstractC1125a.c(bOBYQAOptimizer.zMatrix, i31, i16, entry5, array2DRowRealMatrix7.getEntry(i31, i30)));
                                i31++;
                                i97 = i97;
                            }
                            i25 = i30 + 1;
                        }
                        int i1614 = i16;
                        int i1615 = i97;
                        while (i26 < dimension) {
                            i27 = i26 + i95;
                            entry4 = arrayRealVector5.getEntry(i26);
                            while (i28 <= i26) {
                                Array2DRowRealMatrix array2DRowRealMatrix8 = bOBYQAOptimizer.bMatrix;
                                array2DRowRealMatrix8.setEntry(i27, i28, AbstractC1125a.e(arrayRealVector5, i28, entry4, array2DRowRealMatrix8.getEntry(i27, i28)));
                            }
                        }
                        i16 = i1614 + 1;
                        i97 = i1615;
                    }
                    i14 = i97;
                    i17 = 0;
                    i18 = 0;
                    while (i17 < dimension) {
                        arrayRealVector5.setEntry(i17, bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i17) * entry * (-0.5d));
                        i20 = 0;
                        while (i20 < i95) {
                            int i1616 = i17;
                            int i1617 = i20;
                            arrayRealVector5.setEntry(i1616, AbstractC1125a.c(bOBYQAOptimizer.interpolationPoints, i1617, i1616, bOBYQAOptimizer.modelSecondDerivativesParameters.getEntry(i20), arrayRealVector5.getEntry(i17)));
                            Array2DRowRealMatrix array2DRowRealMatrix9 = bOBYQAOptimizer.interpolationPoints;
                            array2DRowRealMatrix9.setEntry(i1617, i1616, array2DRowRealMatrix9.getEntry(i1617, i1616) - bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i1616));
                            i20 = i1617 + 1;
                            i17 = i1616;
                        }
                        i21 = i18;
                        i22 = 0;
                        while (true) {
                            i23 = i17;
                            if (i22 <= i23) {
                                ArrayRealVector arrayRealVector211 = bOBYQAOptimizer.modelSecondDerivativesValues;
                                i17 = i23;
                                arrayRealVector211.setEntry(i21, AbstractC1125a.e(arrayRealVector5, i17, bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i22), AbstractC1125a.e(bOBYQAOptimizer.trustRegionCenterOffset, i23, arrayRealVector5.getEntry(i22), arrayRealVector211.getEntry(i21))));
                                Array2DRowRealMatrix array2DRowRealMatrix10 = bOBYQAOptimizer.bMatrix;
                                array2DRowRealMatrix10.setEntry(i95 + i22, i17, array2DRowRealMatrix10.getEntry(i95 + i17, i22));
                                i21++;
                                i22++;
                            }
                        }
                        i17 = i23 + 1;
                        i18 = i21;
                    }
                    while (i19 < dimension) {
                        ArrayRealVector arrayRealVector212 = bOBYQAOptimizer.originShift;
                        arrayRealVector212.setEntry(i19, bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i19) + arrayRealVector212.getEntry(i19));
                        ArrayRealVector arrayRealVector213 = bOBYQAOptimizer.newPoint;
                        arrayRealVector213.setEntry(i19, arrayRealVector213.getEntry(i19) - bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i19));
                        ArrayRealVector arrayRealVector214 = bOBYQAOptimizer.lowerDifference;
                        arrayRealVector214.setEntry(i19, arrayRealVector214.getEntry(i19) - bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i19));
                        ArrayRealVector arrayRealVector215 = bOBYQAOptimizer.upperDifference;
                        arrayRealVector215.setEntry(i19, arrayRealVector215.getEntry(i19) - bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i19));
                        bOBYQAOptimizer.trustRegionCenterOffset.setEntry(i19, d43);
                    }
                    d43 = d43;
                    d45 = d43;
                } else {
                    ArrayRealVector arrayRealVector216 = arrayRealVector5;
                    bOBYQAOptimizer = bOBYQAOptimizer;
                    arrayRealVector5 = arrayRealVector216;
                    i14 = i97;
                    d43 = d43;
                }
                if (i101 == 0) {
                    d53 = d53;
                    d51 = d51;
                    i103 = i6;
                } else {
                    d53 = d53;
                    d51 = d51;
                    i103 = i10;
                }
                i97 = i14;
                d44 = d7;
                d46 = d46;
                dMax4 = d;
                d54 = d8;
                d47 = d47;
            }
        }
        printState(i38);
        if (bOBYQAOptimizer.fAtInterpolationPoints.getEntry(bOBYQAOptimizer.trustRegionCenterInterpolationPointIndex) > entry14) {
            return d50;
        }
        for (int i171 = 0; i171 < dimension; i171++) {
            bOBYQAOptimizer.currentBest.setEntry(i171, FastMath.min(FastMath.max(dArr[i171], bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i171) + bOBYQAOptimizer.originShift.getEntry(i171)), dArr2[i171]));
            if (bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i171) == bOBYQAOptimizer.lowerDifference.getEntry(i171)) {
                bOBYQAOptimizer.currentBest.setEntry(i171, dArr[i171]);
            }
            if (bOBYQAOptimizer.trustRegionCenterOffset.getEntry(i171) == bOBYQAOptimizer.upperDifference.getEntry(i171)) {
                bOBYQAOptimizer.currentBest.setEntry(i171, dArr2[i171]);
            }
        }
        return bOBYQAOptimizer.fAtInterpolationPoints.getEntry(bOBYQAOptimizer.trustRegionCenterInterpolationPointIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String caller(int i5) {
        StackTraceElement stackTraceElement = a.z()[i5];
        return stackTraceElement.getMethodName() + " (at line " + stackTraceElement.getLineNumber() + ")";
    }

    private void prelim(double[] dArr, double[] dArr2) {
        double d;
        double d6;
        int i5;
        double dMax;
        double d7;
        double d8;
        char c;
        double d9;
        int i6;
        printMethod();
        int dimension = this.currentBest.getDimension();
        int i7 = this.numberOfInterpolationPoints;
        int rowDimension = this.bMatrix.getRowDimension();
        double d10 = this.initialTrustRegionRadius;
        double d11 = d10 * d10;
        double d12 = 1.0d;
        double d13 = 1.0d / d11;
        int i8 = dimension + 1;
        int i9 = 0;
        while (true) {
            d = 0.0d;
            if (i9 >= dimension) {
                break;
            }
            double d14 = d12;
            this.originShift.setEntry(i9, this.currentBest.getEntry(i9));
            for (int i10 = 0; i10 < i7; i10++) {
                this.interpolationPoints.setEntry(i10, i9, 0.0d);
            }
            for (int i11 = 0; i11 < rowDimension; i11++) {
                this.bMatrix.setEntry(i11, i9, 0.0d);
            }
            i9++;
            d12 = d14;
        }
        double d15 = d12;
        int i12 = (dimension * i8) / 2;
        for (int i13 = 0; i13 < i12; i13++) {
            this.modelSecondDerivativesValues.setEntry(i13, 0.0d);
        }
        for (int i14 = 0; i14 < i7; i14++) {
            this.modelSecondDerivativesParameters.setEntry(i14, 0.0d);
            int i15 = i7 - i8;
            for (int i16 = 0; i16 < i15; i16++) {
                this.zMatrix.setEntry(i14, i16, 0.0d);
            }
        }
        double d16 = Double.NaN;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int evaluations = getEvaluations();
            int i19 = evaluations - dimension;
            double d17 = d;
            int i20 = evaluations - 1;
            int i21 = i19 - 1;
            int i22 = dimension * 2;
            if (evaluations <= i22) {
                if (evaluations < 1 || evaluations > dimension) {
                    i6 = i17;
                    d6 = d11;
                    i5 = evaluations;
                    if (i5 > dimension) {
                        double entry = this.interpolationPoints.getEntry(i19, i21);
                        dMax = -this.initialTrustRegionRadius;
                        i22 = i22;
                        if (this.lowerDifference.getEntry(i21) == d17) {
                            dMax = FastMath.min(this.initialTrustRegionRadius * TWO, this.upperDifference.getEntry(i21));
                        }
                        if (this.upperDifference.getEntry(i21) == d17) {
                            dMax = FastMath.max(this.initialTrustRegionRadius * (-2.0d), this.lowerDifference.getEntry(i21));
                        }
                        this.interpolationPoints.setEntry(i5, i21, dMax);
                        i17 = i6;
                        d7 = entry;
                        d13 = d13;
                    } else {
                        dMax = d17;
                        d7 = dMax;
                    }
                } else {
                    double d18 = this.initialTrustRegionRadius;
                    i6 = i17;
                    if (this.upperDifference.getEntry(i20) == d17) {
                        d18 = -d18;
                    }
                    d6 = d11;
                    i5 = evaluations;
                    this.interpolationPoints.setEntry(i5, i20, d18);
                    d7 = d18;
                    dMax = d17;
                }
                i17 = i6;
            } else {
                d6 = d11;
                i22 = i22;
                i5 = evaluations;
                int i23 = (i5 - i8) / dimension;
                i17 = (i5 - (i23 * dimension)) - dimension;
                int i24 = i23 + i17;
                if (i24 > dimension) {
                    i18 = i24 - dimension;
                } else {
                    i18 = i17;
                    i17 = i24;
                }
                int i25 = i17 - 1;
                int i26 = i18 - 1;
                Array2DRowRealMatrix array2DRowRealMatrix = this.interpolationPoints;
                d13 = d13;
                array2DRowRealMatrix.setEntry(i5, i25, array2DRowRealMatrix.getEntry(i17, i25));
                Array2DRowRealMatrix array2DRowRealMatrix2 = this.interpolationPoints;
                array2DRowRealMatrix2.setEntry(i5, i26, array2DRowRealMatrix2.getEntry(i18, i26));
                dMax = d17;
                d7 = dMax;
            }
            int i27 = 0;
            while (i27 < dimension) {
                int i28 = dimension;
                double d19 = dMax;
                this.currentBest.setEntry(i27, FastMath.min(FastMath.max(dArr[i27], this.interpolationPoints.getEntry(i5, i27) + this.originShift.getEntry(i27)), dArr2[i27]));
                if (this.interpolationPoints.getEntry(i5, i27) == this.lowerDifference.getEntry(i27)) {
                    this.currentBest.setEntry(i27, dArr[i27]);
                }
                if (this.interpolationPoints.getEntry(i5, i27) == this.upperDifference.getEntry(i27)) {
                    this.currentBest.setEntry(i27, dArr2[i27]);
                }
                i27++;
                dimension = i28;
                dMax = d19;
            }
            int i29 = dimension;
            double d20 = dMax;
            double dComputeObjectiveValue = computeObjectiveValue(this.currentBest.toArray());
            if (!this.isMinimize) {
                dComputeObjectiveValue = -dComputeObjectiveValue;
            }
            int evaluations2 = getEvaluations();
            this.fAtInterpolationPoints.setEntry(i5, dComputeObjectiveValue);
            if (evaluations2 == 1) {
                this.trustRegionCenterInterpolationPointIndex = 0;
                d16 = dComputeObjectiveValue;
            } else if (dComputeObjectiveValue < this.fAtInterpolationPoints.getEntry(this.trustRegionCenterInterpolationPointIndex)) {
                this.trustRegionCenterInterpolationPointIndex = i5;
            }
            if (evaluations2 <= i22 + 1) {
                if (evaluations2 >= 2 && evaluations2 <= i8) {
                    this.gradientAtTrustRegionCenter.setEntry(i20, (dComputeObjectiveValue - d16) / d7);
                    if (i7 < evaluations2 + i29) {
                        double d21 = d15 / d7;
                        this.bMatrix.setEntry(0, i20, -d21);
                        this.bMatrix.setEntry(i5, i20, d21);
                        this.bMatrix.setEntry(i7 + i20, i20, d6 * (-0.5d));
                    }
                } else if (evaluations2 >= i29 + 2) {
                    double d22 = (dComputeObjectiveValue - d16) / d20;
                    double d23 = d20 - d7;
                    this.modelSecondDerivativesValues.setEntry((((i19 + 1) * i19) / 2) - 1, ((d22 - this.gradientAtTrustRegionCenter.getEntry(i21)) * TWO) / d23);
                    ArrayRealVector arrayRealVector = this.gradientAtTrustRegionCenter;
                    double d24 = d7;
                    arrayRealVector.setEntry(i21, com.google.android.gms.auth.api.accounttransfer.a.a(d22, d7, arrayRealVector.getEntry(i21) * d20, d23));
                    double d25 = d24 * d20;
                    if (d25 >= d17 || dComputeObjectiveValue >= this.fAtInterpolationPoints.getEntry(i19)) {
                        d9 = d20;
                    } else {
                        ArrayRealVector arrayRealVector2 = this.fAtInterpolationPoints;
                        arrayRealVector2.setEntry(i5, arrayRealVector2.getEntry(i19));
                        this.fAtInterpolationPoints.setEntry(i19, dComputeObjectiveValue);
                        if (this.trustRegionCenterInterpolationPointIndex == i5) {
                            this.trustRegionCenterInterpolationPointIndex = i19;
                        }
                        d9 = d20;
                        this.interpolationPoints.setEntry(i19, i21, d9);
                        this.interpolationPoints.setEntry(i5, i21, d24);
                    }
                    this.bMatrix.setEntry(0, i21, (-(d9 + d24)) / d25);
                    this.bMatrix.setEntry(i5, i21, (-0.5d) / this.interpolationPoints.getEntry(i19, i21));
                    Array2DRowRealMatrix array2DRowRealMatrix3 = this.bMatrix;
                    array2DRowRealMatrix3.setEntry(i19, i21, (-array2DRowRealMatrix3.getEntry(0, i21)) - this.bMatrix.getEntry(i5, i21));
                    this.zMatrix.setEntry(0, i21, FastMath.sqrt(TWO) / d25);
                    this.zMatrix.setEntry(i5, i21, FastMath.sqrt(HALF) / d6);
                    Array2DRowRealMatrix array2DRowRealMatrix4 = this.zMatrix;
                    array2DRowRealMatrix4.setEntry(i19, i21, (-array2DRowRealMatrix4.getEntry(0, i21)) - this.zMatrix.getEntry(i5, i21));
                }
                d8 = d13;
                c = 2;
            } else {
                d8 = d13;
                this.zMatrix.setEntry(0, i21, d8);
                this.zMatrix.setEntry(i5, i21, d8);
                double d26 = -d8;
                this.zMatrix.setEntry(i17, i21, d26);
                this.zMatrix.setEntry(i18, i21, d26);
                int i30 = i17 - 1;
                c = 2;
                this.modelSecondDerivativesValues.setEntry((((i17 * i30) / 2) + i18) - 1, (((d16 - this.fAtInterpolationPoints.getEntry(i17)) - this.fAtInterpolationPoints.getEntry(i18)) + dComputeObjectiveValue) / (this.interpolationPoints.getEntry(i5, i18 - 1) * this.interpolationPoints.getEntry(i5, i30)));
            }
            if (getEvaluations() >= i7) {
                return;
            }
            d13 = d8;
            d = d17;
            dimension = i29;
            d11 = d6;
        }
    }

    private void setup(double[] dArr, double[] dArr2) {
        printMethod();
        int length = getStartPoint().length;
        if (length < 2) {
            throw new NumberIsTooSmallException(Integer.valueOf(length), 2, true);
        }
        int i5 = length + 2;
        int i6 = length + 1;
        int[] iArr = {i5, (i5 * i6) / 2};
        int i7 = this.numberOfInterpolationPoints;
        if (i7 < iArr[0] || i7 > iArr[1]) {
            throw new OutOfRangeException(LocalizedFormats.NUMBER_OF_INTERPOLATION_POINTS, Integer.valueOf(this.numberOfInterpolationPoints), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
        }
        this.boundDifference = new double[length];
        double d = this.initialTrustRegionRadius * TWO;
        double dMin = Double.POSITIVE_INFINITY;
        for (int i8 = 0; i8 < length; i8++) {
            double[] dArr3 = this.boundDifference;
            double d6 = dArr2[i8] - dArr[i8];
            dArr3[i8] = d6;
            dMin = FastMath.min(dMin, d6);
        }
        if (dMin < d) {
            this.initialTrustRegionRadius = dMin / 3.0d;
        }
        this.bMatrix = new Array2DRowRealMatrix(this.numberOfInterpolationPoints + length, length);
        int i9 = this.numberOfInterpolationPoints;
        this.zMatrix = new Array2DRowRealMatrix(i9, (i9 - length) - 1);
        this.interpolationPoints = new Array2DRowRealMatrix(this.numberOfInterpolationPoints, length);
        this.originShift = new ArrayRealVector(length);
        this.fAtInterpolationPoints = new ArrayRealVector(this.numberOfInterpolationPoints);
        this.trustRegionCenterOffset = new ArrayRealVector(length);
        this.gradientAtTrustRegionCenter = new ArrayRealVector(length);
        this.lowerDifference = new ArrayRealVector(length);
        this.upperDifference = new ArrayRealVector(length);
        this.modelSecondDerivativesParameters = new ArrayRealVector(this.numberOfInterpolationPoints);
        this.newPoint = new ArrayRealVector(length);
        this.alternativeNewPoint = new ArrayRealVector(length);
        this.trialStepPoint = new ArrayRealVector(length);
        this.lagrangeValuesAtNewPoint = new ArrayRealVector(this.numberOfInterpolationPoints + length);
        this.modelSecondDerivativesValues = new ArrayRealVector((length * i6) / 2);
    }

    /* JADX WARN: Code duplicated, block: B:145:0x05fa  */
    /* JADX WARN: Code duplicated, block: B:151:0x062d  */
    /* JADX WARN: Code duplicated, block: B:232:0x090f  */
    /* JADX WARN: Code duplicated, block: B:234:0x0919  */
    /* JADX WARN: Code duplicated, block: B:235:0x094a  */
    /* JADX WARN: Code duplicated, block: B:292:0x08ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:297:0x0905 A[SYNTHETIC] */
    private double[] trsbox(double d, ArrayRealVector arrayRealVector, ArrayRealVector arrayRealVector2, ArrayRealVector arrayRealVector3, ArrayRealVector arrayRealVector4, ArrayRealVector arrayRealVector5) {
        double d6;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        double d7;
        int i11;
        int i12;
        double d8;
        double d9;
        int i13;
        int i14;
        int i15;
        int i16;
        double d10;
        int i17;
        double d11;
        double d12;
        double d13;
        int i18;
        int i19;
        int i20;
        double d14;
        double d15;
        double d16;
        double d17;
        ArrayRealVector arrayRealVector6;
        int i21;
        double d18;
        double d19;
        ArrayRealVector arrayRealVector7;
        double d20;
        double d21;
        double dMax;
        double dMin;
        double entry;
        double entry2;
        ArrayRealVector arrayRealVector8 = arrayRealVector;
        arrayRealVector2 = arrayRealVector2;
        arrayRealVector4 = arrayRealVector4;
        arrayRealVector5 = arrayRealVector5;
        printMethod();
        int dimension = this.currentBest.getDimension();
        int i22 = this.numberOfInterpolationPoints;
        int i23 = 0;
        int i24 = 0;
        while (true) {
            d6 = 1.0d;
            if (i23 >= dimension) {
                break;
            }
            arrayRealVector2.setEntry(i23, 0.0d);
            if (this.trustRegionCenterOffset.getEntry(i23) <= this.lowerDifference.getEntry(i23)) {
                if (this.gradientAtTrustRegionCenter.getEntry(i23) >= 0.0d) {
                    arrayRealVector2.setEntry(i23, MINUS_ONE);
                }
            } else if (this.trustRegionCenterOffset.getEntry(i23) >= this.upperDifference.getEntry(i23) && this.gradientAtTrustRegionCenter.getEntry(i23) <= 0.0d) {
                arrayRealVector2.setEntry(i23, 1.0d);
            }
            if (arrayRealVector2.getEntry(i23) != 0.0d) {
                i24++;
            }
            this.trialStepPoint.setEntry(i23, 0.0d);
            arrayRealVector8.setEntry(i23, this.gradientAtTrustRegionCenter.getEntry(i23));
            i23++;
        }
        double d22 = d * d;
        int i25 = 20;
        int i26 = 20;
        double d23 = -1.0d;
        double d24 = 0.0d;
        double d25 = 0.0d;
        double d26 = 0.0d;
        double d27 = 0.0d;
        double d28 = 0.0d;
        double dB = 0.0d;
        double d29 = 0.0d;
        double d30 = 0.0d;
        double d31 = 0.0d;
        double d32 = 0.0d;
        double d33 = 0.0d;
        double d34 = 0.0d;
        double d35 = 0.0d;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = -1;
        while (true) {
            if (i26 == i25) {
                i5 = i25;
                printState(i5);
                d32 = 0.0d;
            } else if (i26 != 30) {
                int i31 = 100;
                int i32 = 30;
                int i33 = 90;
                d29 = d29;
                if (i26 == 50) {
                    ArrayRealVector arrayRealVector9 = arrayRealVector3;
                    arrayRealVector8 = arrayRealVector8;
                    i6 = i24;
                    i22 = i22;
                    int i34 = i27;
                    double d36 = d23;
                    d34 = d34;
                    i7 = 20;
                    dimension = dimension;
                    i8 = i28;
                    arrayRealVector5 = arrayRealVector5;
                    i26 = 190;
                    int i35 = i30;
                    printState(50);
                    int i36 = 0;
                    double d37 = d22;
                    double dE = 0.0d;
                    double d38 = 0.0d;
                    while (i36 < dimension) {
                        if (arrayRealVector2.getEntry(i36) == 0.0d) {
                            double entry3 = this.trialStepPoint.getEntry(i36);
                            double dE2 = AbstractC1125a.e(this.trialStepPoint, i36, arrayRealVector9.getEntry(i36), d38);
                            dE = AbstractC1125a.e(arrayRealVector4, i36, arrayRealVector9.getEntry(i36), dE);
                            d37 -= entry3 * entry3;
                            d38 = dE2;
                        }
                        i36++;
                        i33 = i33;
                    }
                    double d39 = dE;
                    i9 = i33;
                    double d40 = 0.0d;
                    if (d37 <= 0.0d) {
                        i27 = i34;
                        arrayRealVector4 = arrayRealVector4;
                        arrayRealVector8 = arrayRealVector8;
                        i30 = i35;
                        i28 = i8;
                        arrayRealVector5 = arrayRealVector5;
                        dimension = dimension;
                        i26 = i9;
                        i22 = i22;
                        i24 = i6;
                        i25 = 20;
                        d29 = d29;
                        d6 = 1.0d;
                        d34 = d34;
                        d23 = d36;
                    } else {
                        double dSqrt = FastMath.sqrt((d38 * d38) + (d28 * d37));
                        double d41 = d38 < 0.0d ? (dSqrt - d38) / d28 : d37 / (dSqrt + d38);
                        double dMin2 = d39 > 0.0d ? FastMath.min(d41, d24 / d39) : d41;
                        int i37 = 0;
                        i30 = -1;
                        while (i37 < dimension) {
                            if (arrayRealVector9.getEntry(i37) != d40) {
                                double entry4 = this.trialStepPoint.getEntry(i37) + this.trustRegionCenterOffset.getEntry(i37);
                                if (arrayRealVector9.getEntry(i37) > d40) {
                                    entry = this.upperDifference.getEntry(i37) - entry4;
                                    entry2 = arrayRealVector9.getEntry(i37);
                                } else {
                                    entry = this.lowerDifference.getEntry(i37) - entry4;
                                    entry2 = arrayRealVector9.getEntry(i37);
                                }
                                double d42 = entry / entry2;
                                if (d42 < dMin2) {
                                    i30 = i37;
                                    dMin2 = d42;
                                }
                            }
                            i37++;
                            d40 = 0.0d;
                        }
                        if (dMin2 > d40) {
                            int i38 = i34 + 1;
                            double d43 = d39 / d28;
                            d19 = -1.0d;
                            if (i30 != -1 || d43 <= d40) {
                                dMin = d36;
                            } else {
                                dMin = FastMath.min(d36, d43);
                                if (dMin == MINUS_ONE) {
                                    dMin = d43;
                                }
                            }
                            double d44 = d41;
                            int i39 = 0;
                            double d45 = 0.0d;
                            while (i39 < dimension) {
                                double d46 = dMin;
                                double d47 = d45;
                                double d48 = d44;
                                arrayRealVector8.setEntry(i39, AbstractC1125a.e(arrayRealVector4, i39, dMin2, arrayRealVector8.getEntry(i39)));
                                if (arrayRealVector2.getEntry(i39) == 0.0d) {
                                    d47 = AbstractC1125a.d(arrayRealVector8, i39, d47);
                                }
                                ArrayRealVector arrayRealVector10 = this.trialStepPoint;
                                ArrayRealVector arrayRealVector11 = arrayRealVector9;
                                arrayRealVector10.setEntry(i39, AbstractC1125a.e(arrayRealVector11, i39, dMin2, arrayRealVector10.getEntry(i39)));
                                i39++;
                                arrayRealVector9 = arrayRealVector11;
                                d45 = d47;
                                d44 = d48;
                                dMin = d46;
                            }
                            arrayRealVector7 = arrayRealVector9;
                            d18 = d44;
                            d20 = 0.0d;
                            dMax = FastMath.max((d24 - ((dMin2 * HALF) * d39)) * dMin2, 0.0d);
                            d27 += dMax;
                            i27 = i38;
                            d35 = d24;
                            d24 = d45;
                            d21 = dMin;
                        } else {
                            d18 = d41;
                            d19 = -1.0d;
                            arrayRealVector7 = arrayRealVector9;
                            d20 = d40;
                            d21 = d36;
                            i27 = i34;
                            dMax = d20;
                        }
                        if (i30 >= 0) {
                            i24 = i6 + 1;
                            double d49 = d21;
                            arrayRealVector2.setEntry(i30, 1.0d);
                            double d50 = d19;
                            if (arrayRealVector7.getEntry(i30) < d20) {
                                arrayRealVector2.setEntry(i30, d50);
                            }
                            double entry5 = this.trialStepPoint.getEntry(i30);
                            d22 -= entry5 * entry5;
                            if (d22 <= d20) {
                                d23 = d49;
                            } else {
                                d34 = d34;
                                d23 = d49;
                                arrayRealVector4 = arrayRealVector4;
                                i27 = i27;
                                arrayRealVector8 = arrayRealVector8;
                                i30 = i30;
                                i28 = i8;
                                arrayRealVector5 = arrayRealVector5;
                                dimension = dimension;
                                i22 = i22;
                                i25 = 20;
                                i26 = 20;
                                d29 = d29;
                                d6 = 1.0d;
                            }
                        } else {
                            double d51 = d21;
                            i10 = i29;
                            if (dMin2 >= d18) {
                                i30 = i30;
                                printState(i9);
                                i18 = i27;
                                d13 = 0.0d;
                                printState(i31);
                                i19 = i6;
                                if (i19 >= dimension - 1) {
                                    arrayRealVector4 = arrayRealVector4;
                                    i24 = i19;
                                    i29 = i10;
                                    arrayRealVector8 = arrayRealVector8;
                                    i27 = i18;
                                    arrayRealVector5 = arrayRealVector5;
                                    dimension = dimension;
                                    i26 = i26;
                                    d34 = d34;
                                    i22 = i22;
                                    i25 = i7;
                                    d23 = d13;
                                    d6 = 1.0d;
                                    i28 = i8;
                                } else {
                                    i20 = 0;
                                    d14 = 0.0d;
                                    d15 = 0.0d;
                                    d16 = 0.0d;
                                    while (i20 < dimension) {
                                        if (arrayRealVector2.getEntry(i20) == 0.0d) {
                                            double d52 = AbstractC1125a.d(this.trialStepPoint, i20, d14);
                                            ArrayRealVector arrayRealVector12 = arrayRealVector8;
                                            int i40 = i20;
                                            double dE3 = AbstractC1125a.e(arrayRealVector12, i40, this.trialStepPoint.getEntry(i20), d15);
                                            arrayRealVector6 = arrayRealVector12;
                                            i21 = i40;
                                            d16 = AbstractC1125a.d(arrayRealVector6, i21, d16);
                                            arrayRealVector3.setEntry(i21, this.trialStepPoint.getEntry(i21));
                                            d17 = dE3;
                                            d14 = d52;
                                        } else {
                                            d17 = d15;
                                            arrayRealVector6 = arrayRealVector8;
                                            i21 = i20;
                                            arrayRealVector3.setEntry(i21, 0.0d);
                                        }
                                        i20 = i21 + 1;
                                        arrayRealVector8 = arrayRealVector6;
                                        d15 = d17;
                                        i19 = i19;
                                    }
                                    int i41 = i19;
                                    d26 = d15;
                                    d25 = d14;
                                    arrayRealVector8 = arrayRealVector8;
                                    d24 = d16;
                                    i29 = i10;
                                    i27 = i18;
                                    i28 = i27;
                                    arrayRealVector5 = arrayRealVector5;
                                    dimension = dimension;
                                    d34 = d34;
                                    i22 = i22;
                                    i24 = i41;
                                    i25 = i7;
                                    d29 = d29;
                                    d23 = d13;
                                    i26 = 210;
                                    d6 = 1.0d;
                                    arrayRealVector4 = arrayRealVector4;
                                }
                            } else if (i27 != i10 && dMax > 0.01d * d27) {
                                d32 = d24 / d35;
                                d34 = d34;
                                d23 = d51;
                                arrayRealVector4 = arrayRealVector4;
                                i27 = i27;
                                i29 = i10;
                                arrayRealVector8 = arrayRealVector8;
                                i30 = i30;
                                i28 = i8;
                                arrayRealVector5 = arrayRealVector5;
                                dimension = dimension;
                                i22 = i22;
                                i24 = i6;
                                i25 = 20;
                                d6 = 1.0d;
                                i26 = i32;
                            } else {
                                d23 = d51;
                                i29 = i10;
                                i24 = i6;
                            }
                        }
                        i25 = 20;
                        d6 = 1.0d;
                        i28 = i8;
                    }
                } else if (i26 == 90) {
                    arrayRealVector8 = arrayRealVector8;
                    i6 = i24;
                    i22 = i22;
                    i7 = 20;
                    dimension = dimension;
                    i8 = i28;
                    arrayRealVector5 = arrayRealVector5;
                    i26 = 190;
                    i27 = i27;
                    d34 = d34;
                    i9 = 90;
                    i10 = i29;
                    printState(i9);
                    i18 = i27;
                    d13 = 0.0d;
                    printState(i31);
                    i19 = i6;
                    if (i19 >= dimension - 1) {
                        arrayRealVector4 = arrayRealVector4;
                        i24 = i19;
                        i29 = i10;
                        arrayRealVector8 = arrayRealVector8;
                        i27 = i18;
                        arrayRealVector5 = arrayRealVector5;
                        dimension = dimension;
                        i26 = i26;
                        d34 = d34;
                        i22 = i22;
                        i25 = i7;
                        d23 = d13;
                        d6 = 1.0d;
                        i28 = i8;
                    } else {
                        i20 = 0;
                        d14 = 0.0d;
                        d15 = 0.0d;
                        d16 = 0.0d;
                        while (i20 < dimension) {
                            if (arrayRealVector2.getEntry(i20) == 0.0d) {
                                double d53 = AbstractC1125a.d(this.trialStepPoint, i20, d14);
                                ArrayRealVector arrayRealVector13 = arrayRealVector8;
                                int i42 = i20;
                                double dE4 = AbstractC1125a.e(arrayRealVector13, i42, this.trialStepPoint.getEntry(i20), d15);
                                arrayRealVector6 = arrayRealVector13;
                                i21 = i42;
                                d16 = AbstractC1125a.d(arrayRealVector6, i21, d16);
                                arrayRealVector3.setEntry(i21, this.trialStepPoint.getEntry(i21));
                                d17 = dE4;
                                d14 = d53;
                            } else {
                                d17 = d15;
                                arrayRealVector6 = arrayRealVector8;
                                i21 = i20;
                                arrayRealVector3.setEntry(i21, 0.0d);
                            }
                            i20 = i21 + 1;
                            arrayRealVector8 = arrayRealVector6;
                            d15 = d17;
                            i19 = i19;
                        }
                        int i43 = i19;
                        d26 = d15;
                        d25 = d14;
                        arrayRealVector8 = arrayRealVector8;
                        d24 = d16;
                        i29 = i10;
                        i27 = i18;
                        i28 = i27;
                        arrayRealVector5 = arrayRealVector5;
                        dimension = dimension;
                        d34 = d34;
                        i22 = i22;
                        i24 = i43;
                        i25 = i7;
                        d29 = d29;
                        d23 = d13;
                        i26 = 210;
                        d6 = 1.0d;
                        arrayRealVector4 = arrayRealVector4;
                    }
                } else if (i26 != 100) {
                    int i44 = 120;
                    if (i26 != 120) {
                        int i45 = 150;
                        if (i26 == 150) {
                            i27 = i27;
                            i28 = i28;
                            double d54 = 0.0d;
                            printState(150);
                            int i46 = 190;
                            int i47 = 100;
                            int i48 = 0;
                            double d55 = 0.0d;
                            double dE5 = 0.0d;
                            double dE6 = 0.0d;
                            while (i48 < dimension) {
                                if (arrayRealVector2.getEntry(i48) == d54) {
                                    double dE7 = AbstractC1125a.e(arrayRealVector4, i48, arrayRealVector3.getEntry(i48), d55);
                                    dE5 = AbstractC1125a.e(arrayRealVector4, i48, this.trialStepPoint.getEntry(i48), dE5);
                                    d55 = dE7;
                                    dE6 = AbstractC1125a.e(arrayRealVector5, i48, this.trialStepPoint.getEntry(i48), dE6);
                                }
                                i48++;
                                d54 = d54;
                                i47 = i47;
                                i46 = i46;
                                d23 = d23;
                                arrayRealVector4 = arrayRealVector4;
                            }
                            int i49 = i47;
                            i11 = i46;
                            d8 = d23;
                            double d56 = dE6;
                            double d57 = d54;
                            double d58 = dE5;
                            int i50 = (int) ((17.0d * d31) + 3.1d);
                            int i51 = i22;
                            int i52 = 0;
                            double d59 = dB;
                            double d60 = d30;
                            int i53 = -1;
                            double d61 = d57;
                            double d62 = d61;
                            while (i52 < i50) {
                                double d63 = d57;
                                d59 = (((double) i52) * d31) / ((double) i50);
                                double d64 = (d59 + d59) / ((d59 * d59) + 1.0d);
                                double d65 = d64 * (((d59 * d26) - d33) - ((d64 * HALF) * (((((d59 * d56) - d58) - d58) * d59) + d55)));
                                if (d65 > d61) {
                                    i53 = i52;
                                    d29 = d62;
                                    d61 = d65;
                                } else if (i52 == i53 + 1) {
                                    d60 = d65;
                                }
                                i52++;
                                d62 = d65;
                                d57 = d63;
                            }
                            d9 = d57;
                            double d66 = 1.0d;
                            if (i53 < 0) {
                                i26 = i11;
                                dB = d59;
                            } else {
                                dB = i53 < i50 ? a.B((d60 - d29) / (((d61 + d61) - d29) - d60), HALF, i53, d31) / ((double) i50) : d59;
                                double d67 = dB * dB;
                                double d68 = 1.0d - d67;
                                double d69 = d67 + 1.0d;
                                double d70 = d68 / d69;
                                double d71 = (dB + dB) / d69;
                                double d72 = (((dB * d26) - d33) - ((HALF * d71) * (((((dB * d56) - d58) - d58) * dB) + d55))) * d71;
                                if (d72 <= d9) {
                                    i26 = i11;
                                } else {
                                    int i54 = i24;
                                    int i55 = i28;
                                    int i56 = 0;
                                    double d73 = d9;
                                    double d74 = d73;
                                    while (i56 < dimension) {
                                        int i57 = dimension;
                                        int i58 = i50;
                                        d71 = d71;
                                        arrayRealVector8.setEntry(i56, AbstractC1125a.e(arrayRealVector4, i56, d71, AbstractC1125a.e(arrayRealVector5, i56, d70 - d66, arrayRealVector8.getEntry(i56))));
                                        if (arrayRealVector2.getEntry(i56) == d9) {
                                            ArrayRealVector arrayRealVector14 = this.trialStepPoint;
                                            arrayRealVector14.setEntry(i56, AbstractC1125a.e(arrayRealVector3, i56, d71, arrayRealVector14.getEntry(i56) * d70));
                                            arrayRealVector8 = arrayRealVector;
                                            i16 = i56;
                                            double dE8 = AbstractC1125a.e(arrayRealVector8, i16, this.trialStepPoint.getEntry(i56), d73);
                                            d74 = AbstractC1125a.d(arrayRealVector8, i16, d74);
                                            d10 = dE8;
                                        } else {
                                            i16 = i56;
                                            d10 = d73;
                                        }
                                        d9 = d9;
                                        ArrayRealVector arrayRealVector15 = arrayRealVector8;
                                        arrayRealVector5.setEntry(i16, AbstractC1125a.e(arrayRealVector4, i16, d71, arrayRealVector5.getEntry(i16) * d70));
                                        int i59 = i16 + 1;
                                        i27 = i27;
                                        d73 = d10;
                                        i55 = i55;
                                        i50 = i58;
                                        dimension = i57;
                                        i54 = i54;
                                        d66 = d66;
                                        i56 = i59;
                                        arrayRealVector8 = arrayRealVector15;
                                    }
                                    ArrayRealVector arrayRealVector16 = arrayRealVector8;
                                    int i60 = i54;
                                    int i61 = i55;
                                    int i62 = i27;
                                    int i63 = i50;
                                    i12 = dimension;
                                    double d75 = d74;
                                    d7 = d66;
                                    d27 += d72;
                                    int i64 = i30;
                                    if (i64 < 0 || i53 != i63) {
                                        double d76 = d34;
                                        if (d72 <= 0.01d * d27) {
                                            break;
                                        }
                                        i27 = i62;
                                        d34 = d76;
                                        d26 = d73;
                                        d24 = d75;
                                        arrayRealVector8 = arrayRealVector16;
                                        i30 = i64;
                                        i28 = i61;
                                        arrayRealVector5 = arrayRealVector5;
                                        d30 = d60;
                                        i22 = i51;
                                        dimension = i12;
                                        i24 = i60;
                                        i25 = 20;
                                        d29 = d29;
                                        i26 = 120;
                                        d6 = d7;
                                        d23 = d8;
                                        arrayRealVector4 = arrayRealVector4;
                                    } else {
                                        arrayRealVector2.setEntry(i64, d34);
                                        d26 = d73;
                                        d24 = d75;
                                        i30 = i64;
                                        i28 = i61;
                                        arrayRealVector5 = arrayRealVector5;
                                        i26 = i49;
                                        d30 = d60;
                                        i22 = i51;
                                        dimension = i12;
                                        i25 = 20;
                                        d29 = d29;
                                        d23 = d8;
                                        i27 = i62;
                                        arrayRealVector4 = arrayRealVector4;
                                        i24 = i60 + 1;
                                        arrayRealVector8 = arrayRealVector16;
                                        d6 = d7;
                                    }
                                }
                            }
                            d30 = d60;
                            i22 = i51;
                            d29 = d29;
                            d23 = d8;
                            d6 = 1.0d;
                            i25 = 20;
                        } else {
                            if (i26 == 190) {
                                d7 = d6;
                                i11 = 190;
                                i12 = dimension;
                                d8 = d23;
                                d9 = 0.0d;
                                break;
                            }
                            if (i26 != 210) {
                                throw new MathIllegalStateException(LocalizedFormats.SIMPLE_MESSAGE, "trsbox");
                            }
                            printState(210);
                            int i65 = 0;
                            int i66 = 0;
                            while (i65 < dimension) {
                                long j6 = 0;
                                arrayRealVector4.setEntry(i65, 0.0d);
                                int i67 = i45;
                                int i68 = 0;
                                while (i68 <= i65) {
                                    if (i68 < i65) {
                                        double entry6 = arrayRealVector4.getEntry(i65);
                                        double entry7 = this.modelSecondDerivativesValues.getEntry(i66);
                                        int i69 = i66;
                                        int i70 = i68;
                                        i15 = i69;
                                        i13 = 120;
                                        i14 = i70;
                                        arrayRealVector4.setEntry(i65, AbstractC1125a.e(arrayRealVector3, i70, entry7, entry6));
                                    } else {
                                        i13 = i44;
                                        i14 = i68;
                                        i15 = i66;
                                    }
                                    int i71 = i65;
                                    int i72 = i14;
                                    arrayRealVector4.setEntry(i72, AbstractC1125a.e(arrayRealVector3, i71, this.modelSecondDerivativesValues.getEntry(i15), arrayRealVector4.getEntry(i14)));
                                    i66 = i15 + 1;
                                    i68 = i72 + 1;
                                    i65 = i71;
                                    i44 = i13;
                                    j6 = 0;
                                }
                                i65++;
                                i66 = i66;
                                i44 = i44;
                                i45 = i67;
                            }
                            i32 = i45;
                            int i73 = i44;
                            RealVector realVectorEbeMultiply = this.interpolationPoints.operate(arrayRealVector3).ebeMultiply(this.modelSecondDerivativesParameters);
                            int i74 = 0;
                            while (i74 < i22) {
                                if (this.modelSecondDerivativesParameters.getEntry(i74) != 0.0d) {
                                    int i75 = 0;
                                    while (i75 < dimension) {
                                        int i76 = i74;
                                        int i77 = i75;
                                        arrayRealVector4.setEntry(i77, AbstractC1125a.c(this.interpolationPoints, i76, i77, realVectorEbeMultiply.getEntry(i74), arrayRealVector4.getEntry(i75)));
                                        i75 = i77 + 1;
                                        i74 = i76;
                                    }
                                }
                                i74++;
                            }
                            if (d23 != 0.0d) {
                                i26 = 50;
                            } else {
                                int i78 = i27;
                                int i79 = i28;
                                if (i78 > i79) {
                                    i27 = i78;
                                    i28 = i79;
                                    i25 = 20;
                                    d6 = 1.0d;
                                    i26 = i32;
                                } else {
                                    for (int i80 = 0; i80 < dimension; i80++) {
                                        arrayRealVector5.setEntry(i80, arrayRealVector4.getEntry(i80));
                                    }
                                    i27 = i78;
                                    i28 = i79;
                                    i26 = i73;
                                }
                            }
                            i25 = 20;
                            d6 = 1.0d;
                        }
                    } else {
                        int i81 = i24;
                        double d77 = d6;
                        int i82 = i22;
                        int i83 = i28;
                        double d78 = d23;
                        double d79 = 0.0d;
                        ArrayRealVector arrayRealVector17 = arrayRealVector8;
                        int i84 = dimension;
                        int i85 = i30;
                        ArrayRealVector arrayRealVector18 = arrayRealVector5;
                        double d80 = d34;
                        printState(120);
                        i27++;
                        double d81 = (d24 * d25) - (d26 * d26);
                        if (d81 <= 1.0E-4d * d27 * d27) {
                            d34 = d80;
                            arrayRealVector8 = arrayRealVector17;
                            i30 = i85;
                            arrayRealVector5 = arrayRealVector18;
                            dimension = i84;
                            i26 = 190;
                            i22 = i82;
                            i24 = i81;
                            i25 = 20;
                            d29 = d29;
                            d6 = d77;
                            d23 = d78;
                            arrayRealVector4 = arrayRealVector4;
                            i28 = i83;
                        } else {
                            double dSqrt2 = FastMath.sqrt(d81);
                            int i86 = 0;
                            while (i86 < i84) {
                                if (arrayRealVector2.getEntry(i86) == d79) {
                                    arrayRealVector3.setEntry(i86, ((this.trialStepPoint.getEntry(i86) * d26) - (arrayRealVector17.getEntry(i86) * d25)) / dSqrt2);
                                    d12 = d79;
                                } else {
                                    d12 = d79;
                                    arrayRealVector3.setEntry(i86, d12);
                                }
                                i86++;
                                d79 = d12;
                                d80 = d80;
                            }
                            double d82 = d80;
                            double d83 = d79;
                            double d84 = -dSqrt2;
                            int i87 = 0;
                            d34 = d82;
                            d31 = d77;
                            i30 = -1;
                            while (true) {
                                if (i87 >= i84) {
                                    i17 = i81;
                                    break;
                                }
                                if (arrayRealVector2.getEntry(i87) == d83) {
                                    double entry8 = (this.trialStepPoint.getEntry(i87) + this.trustRegionCenterOffset.getEntry(i87)) - this.lowerDifference.getEntry(i87);
                                    double entry9 = (this.upperDifference.getEntry(i87) - this.trustRegionCenterOffset.getEntry(i87)) - this.trialStepPoint.getEntry(i87);
                                    if (entry8 <= 0.0d) {
                                        i17 = i81 + 1;
                                        arrayRealVector2.setEntry(i87, MINUS_ONE);
                                    } else if (entry9 <= 0.0d) {
                                        i17 = i81 + 1;
                                        arrayRealVector2.setEntry(i87, d77);
                                    } else {
                                        double entry10 = this.trialStepPoint.getEntry(i87);
                                        double entry11 = arrayRealVector3.getEntry(i87);
                                        double d85 = (entry11 * entry11) + (entry10 * entry10);
                                        double entry12 = this.trustRegionCenterOffset.getEntry(i87) - this.lowerDifference.getEntry(i87);
                                        double d86 = d85 - (entry12 * entry12);
                                        if (d86 > 0.0d) {
                                            double dSqrt3 = FastMath.sqrt(d86) - arrayRealVector3.getEntry(i87);
                                            if (d31 * dSqrt3 > entry8) {
                                                d31 = entry8 / dSqrt3;
                                                i30 = i87;
                                                d11 = MINUS_ONE;
                                            } else {
                                                d11 = d34;
                                            }
                                        } else {
                                            d11 = d34;
                                        }
                                        double entry13 = this.upperDifference.getEntry(i87) - this.trustRegionCenterOffset.getEntry(i87);
                                        double d87 = d85 - (entry13 * entry13);
                                        if (d87 > 0.0d) {
                                            double entry14 = arrayRealVector3.getEntry(i87) + FastMath.sqrt(d87);
                                            if (d31 * entry14 > entry9) {
                                                i30 = i87;
                                                d31 = entry9 / entry14;
                                                d34 = 1.0d;
                                            } else {
                                                d34 = d11;
                                            }
                                        } else {
                                            d34 = d11;
                                        }
                                    }
                                    break;
                                }
                                i87++;
                                d83 = 0.0d;
                                d77 = 1.0d;
                            }
                            d33 = d84;
                            arrayRealVector8 = arrayRealVector17;
                            i28 = i83;
                            arrayRealVector5 = arrayRealVector18;
                            dimension = i84;
                            i22 = i82;
                            i25 = 20;
                            d29 = d29;
                            d23 = d78;
                            i26 = 210;
                            d6 = 1.0d;
                            i24 = i17;
                            arrayRealVector4 = arrayRealVector4;
                        }
                    }
                } else {
                    arrayRealVector8 = arrayRealVector8;
                    i6 = i24;
                    i22 = i22;
                    int i88 = i27;
                    d13 = d23;
                    i7 = 20;
                    i31 = 100;
                    dimension = dimension;
                    i8 = i28;
                    arrayRealVector5 = arrayRealVector5;
                    i26 = 190;
                    d34 = d34;
                    i10 = i29;
                    i18 = i88;
                    printState(i31);
                    i19 = i6;
                    if (i19 >= dimension - 1) {
                        arrayRealVector4 = arrayRealVector4;
                        i24 = i19;
                        i29 = i10;
                        arrayRealVector8 = arrayRealVector8;
                        i27 = i18;
                        arrayRealVector5 = arrayRealVector5;
                        dimension = dimension;
                        i26 = i26;
                        d34 = d34;
                        i22 = i22;
                        i25 = i7;
                        d23 = d13;
                        d6 = 1.0d;
                        i28 = i8;
                    } else {
                        i20 = 0;
                        d14 = 0.0d;
                        d15 = 0.0d;
                        d16 = 0.0d;
                        while (i20 < dimension) {
                            if (arrayRealVector2.getEntry(i20) == 0.0d) {
                                double d510 = AbstractC1125a.d(this.trialStepPoint, i20, d14);
                                ArrayRealVector arrayRealVector19 = arrayRealVector8;
                                int i410 = i20;
                                double dE9 = AbstractC1125a.e(arrayRealVector19, i410, this.trialStepPoint.getEntry(i20), d15);
                                arrayRealVector6 = arrayRealVector19;
                                i21 = i410;
                                d16 = AbstractC1125a.d(arrayRealVector6, i21, d16);
                                arrayRealVector3.setEntry(i21, this.trialStepPoint.getEntry(i21));
                                d17 = dE9;
                                d14 = d510;
                            } else {
                                d17 = d15;
                                arrayRealVector6 = arrayRealVector8;
                                i21 = i20;
                                arrayRealVector3.setEntry(i21, 0.0d);
                            }
                            i20 = i21 + 1;
                            arrayRealVector8 = arrayRealVector6;
                            d15 = d17;
                            i19 = i19;
                        }
                        int i411 = i19;
                        d26 = d15;
                        d25 = d14;
                        arrayRealVector8 = arrayRealVector8;
                        d24 = d16;
                        i29 = i10;
                        i27 = i18;
                        i28 = i27;
                        arrayRealVector5 = arrayRealVector5;
                        dimension = dimension;
                        d34 = d34;
                        i22 = i22;
                        i24 = i411;
                        i25 = i7;
                        d29 = d29;
                        d23 = d13;
                        i26 = 210;
                        d6 = 1.0d;
                        arrayRealVector4 = arrayRealVector4;
                    }
                }
            } else {
                i5 = i25;
            }
            printState(30);
            int i89 = 0;
            d28 = 0.0d;
            while (i89 < dimension) {
                if (arrayRealVector2.getEntry(i89) != 0.0d) {
                    arrayRealVector3.setEntry(i89, 0.0d);
                } else if (d32 == 0.0d) {
                    arrayRealVector3.setEntry(i89, -arrayRealVector8.getEntry(i89));
                } else {
                    arrayRealVector3.setEntry(i89, (arrayRealVector3.getEntry(i89) * d32) - arrayRealVector8.getEntry(i89));
                }
                d28 = AbstractC1125a.d(arrayRealVector3, i89, d28);
                i89++;
                arrayRealVector2 = arrayRealVector2;
            }
            if (d28 == 0.0d) {
                i29 = i29;
            } else {
                if (d32 == 0.0d) {
                    d24 = d28;
                    i29 = (i27 + dimension) - i24;
                } else {
                    i29 = i29;
                }
                if (d24 * d22 > 1.0E-4d * d27 * d27) {
                    i27 = i27;
                    arrayRealVector2 = arrayRealVector2;
                    d28 = d28;
                    arrayRealVector8 = arrayRealVector8;
                    i30 = i30;
                    i28 = i28;
                    arrayRealVector5 = arrayRealVector5;
                    dimension = dimension;
                    d34 = d34;
                    i22 = i22;
                    i24 = i24;
                    i25 = i5;
                    d29 = d29;
                    i26 = 210;
                    d6 = 1.0d;
                    arrayRealVector4 = arrayRealVector4;
                    d23 = d23;
                }
            }
            i30 = i30;
            arrayRealVector5 = arrayRealVector5;
            dimension = dimension;
            i26 = 190;
            d34 = d34;
            i22 = i22;
            i24 = i24;
            i25 = i5;
            d29 = d29;
            d6 = 1.0d;
            arrayRealVector4 = arrayRealVector4;
            d23 = d23;
            i28 = i28;
        }
        printState(i11);
        int i90 = i12;
        double d88 = d9;
        for (int i91 = 0; i91 < i90; i91++) {
            this.newPoint.setEntry(i91, FastMath.max(FastMath.min(this.trialStepPoint.getEntry(i91) + this.trustRegionCenterOffset.getEntry(i91), this.upperDifference.getEntry(i91)), this.lowerDifference.getEntry(i91)));
            if (arrayRealVector2.getEntry(i91) == MINUS_ONE) {
                this.newPoint.setEntry(i91, this.lowerDifference.getEntry(i91));
            }
            if (arrayRealVector2.getEntry(i91) == d7) {
                this.newPoint.setEntry(i91, this.upperDifference.getEntry(i91));
            }
            this.trialStepPoint.setEntry(i91, this.newPoint.getEntry(i91) - this.trustRegionCenterOffset.getEntry(i91));
            d88 = AbstractC1125a.d(this.trialStepPoint, i91, d88);
        }
        return new double[]{d88, d8};
    }

    private void update(double d, double d6, int i5) {
        printMethod();
        int dimension = this.currentBest.getDimension();
        int i6 = this.numberOfInterpolationPoints;
        int i7 = (i6 - dimension) - 1;
        ArrayRealVector arrayRealVector = new ArrayRealVector(i6 + dimension);
        int i8 = 0;
        double dMax = 0.0d;
        for (int i9 = 0; i9 < i6; i9++) {
            for (int i10 = 0; i10 < i7; i10++) {
                dMax = FastMath.max(dMax, FastMath.abs(this.zMatrix.getEntry(i9, i10)));
            }
        }
        double d7 = dMax * 1.0E-20d;
        int i11 = 1;
        while (i11 < i7) {
            if (FastMath.abs(this.zMatrix.getEntry(i5, i11)) > d7) {
                double entry = this.zMatrix.getEntry(i5, i8);
                double entry2 = this.zMatrix.getEntry(i5, i11);
                double dSqrt = FastMath.sqrt((entry2 * entry2) + (entry * entry));
                double entry3 = this.zMatrix.getEntry(i5, i8) / dSqrt;
                double entry4 = this.zMatrix.getEntry(i5, i11) / dSqrt;
                int i12 = i8;
                while (i12 < i6) {
                    double dC = AbstractC1125a.c(this.zMatrix, i12, i11, entry4, this.zMatrix.getEntry(i12, i8) * entry3);
                    Array2DRowRealMatrix array2DRowRealMatrix = this.zMatrix;
                    array2DRowRealMatrix.setEntry(i12, i11, (array2DRowRealMatrix.getEntry(i12, i11) * entry3) - (this.zMatrix.getEntry(i12, i8) * entry4));
                    this.zMatrix.setEntry(i12, 0, dC);
                    i12++;
                    i8 = 0;
                }
            }
            this.zMatrix.setEntry(i5, i11, 0.0d);
            i11++;
            i8 = 0;
        }
        for (int i13 = 0; i13 < i6; i13++) {
            arrayRealVector.setEntry(i13, this.zMatrix.getEntry(i13, 0) * this.zMatrix.getEntry(i5, 0));
        }
        double entry5 = arrayRealVector.getEntry(i5);
        double entry6 = this.lagrangeValuesAtNewPoint.getEntry(i5);
        ArrayRealVector arrayRealVector2 = this.lagrangeValuesAtNewPoint;
        arrayRealVector2.setEntry(i5, arrayRealVector2.getEntry(i5) - 1.0d);
        double dSqrt2 = FastMath.sqrt(d6);
        double d8 = entry6 / dSqrt2;
        int i14 = 0;
        double entry7 = this.zMatrix.getEntry(i5, 0) / dSqrt2;
        int i15 = 0;
        while (i15 < i6) {
            Array2DRowRealMatrix array2DRowRealMatrix2 = this.zMatrix;
            array2DRowRealMatrix2.setEntry(i15, 0, (array2DRowRealMatrix2.getEntry(i15, 0) * d8) - (this.lagrangeValuesAtNewPoint.getEntry(i15) * entry7));
            i15++;
            entry5 = entry5;
        }
        double d9 = entry5;
        int i16 = 0;
        while (i16 < dimension) {
            int i17 = i6 + i16;
            arrayRealVector.setEntry(i17, this.bMatrix.getEntry(i5, i16));
            double entry8 = ((this.lagrangeValuesAtNewPoint.getEntry(i17) * d9) - (arrayRealVector.getEntry(i17) * entry6)) / d6;
            double entry9 = ((arrayRealVector.getEntry(i17) * (-d)) - (this.lagrangeValuesAtNewPoint.getEntry(i17) * entry6)) / d6;
            int i18 = i14;
            while (i18 <= i17) {
                Array2DRowRealMatrix array2DRowRealMatrix3 = this.bMatrix;
                int i19 = i18;
                double d10 = entry9;
                array2DRowRealMatrix3.setEntry(i19, i16, AbstractC1125a.e(arrayRealVector, i19, d10, AbstractC1125a.e(this.lagrangeValuesAtNewPoint, i19, entry8, array2DRowRealMatrix3.getEntry(i18, i16))));
                if (i19 >= i6) {
                    Array2DRowRealMatrix array2DRowRealMatrix4 = this.bMatrix;
                    array2DRowRealMatrix4.setEntry(i17, i19 - i6, array2DRowRealMatrix4.getEntry(i19, i16));
                }
                i18 = i19 + 1;
                entry9 = d10;
            }
            i16++;
            i14 = 0;
        }
    }

    @Override // org.apache.commons.math3.optimization.direct.BaseAbstractMultivariateOptimizer
    public PointValuePair doOptimize() {
        double[] lowerBound = getLowerBound();
        double[] upperBound = getUpperBound();
        setup(lowerBound, upperBound);
        this.isMinimize = getGoalType() == GoalType.MINIMIZE;
        this.currentBest = new ArrayRealVector(getStartPoint());
        double dBobyqa = bobyqa(lowerBound, upperBound);
        double[] dataRef = this.currentBest.getDataRef();
        if (!this.isMinimize) {
            dBobyqa = -dBobyqa;
        }
        return new PointValuePair(dataRef, dBobyqa);
    }

    public BOBYQAOptimizer(int i5, double d, double d6) {
        super(null);
        this.numberOfInterpolationPoints = i5;
        this.initialTrustRegionRadius = d;
        this.stoppingTrustRegionRadius = d6;
    }

    private static void printMethod() {
    }

    private static void printState(int i5) {
    }
}
