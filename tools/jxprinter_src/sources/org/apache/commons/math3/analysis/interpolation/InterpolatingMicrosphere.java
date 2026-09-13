package org.apache.commons.math3.analysis.interpolation;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.random.UnitSphereRandomVectorGenerator;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class InterpolatingMicrosphere {
    private final double background;
    private final double darkThreshold;
    private final int dimension;
    private final double maxDarkFraction;
    private final List<Facet> microsphere;
    private final List<FacetData> microsphereData;
    private final int size;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Facet {
        private final double[] normal;

        public Facet(double[] dArr) {
            this.normal = dArr;
        }

        public double[] getNormal() {
            return this.normal;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FacetData {
        private final double illumination;
        private final double sample;

        public FacetData(double d, double d6) {
            this.illumination = d;
            this.sample = d6;
        }

        public double illumination() {
            return this.illumination;
        }

        public double sample() {
            return this.sample;
        }
    }

    public InterpolatingMicrosphere(int i5, int i6, double d, double d6, double d7) {
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        if (i6 <= 0) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i6));
        }
        if (d < 0.0d || d > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d), 0, 1);
        }
        if (d6 < 0.0d) {
            throw new NotPositiveException(Double.valueOf(d6));
        }
        this.dimension = i5;
        this.size = i6;
        this.maxDarkFraction = d;
        this.darkThreshold = d6;
        this.background = d7;
        this.microsphere = new ArrayList(i6);
        this.microsphereData = new ArrayList(i6);
    }

    private void clear() {
        for (int i5 = 0; i5 < this.size; i5++) {
            this.microsphereData.set(i5, new FacetData(0.0d, 0.0d));
        }
    }

    private void illuminate(double[] dArr, double d, double d6) {
        for (int i5 = 0; i5 < this.size; i5++) {
            double dCosAngle = MathArrays.cosAngle(this.microsphere.get(i5).getNormal(), dArr);
            if (dCosAngle > 0.0d) {
                double d7 = dCosAngle * d6;
                if (d7 > this.darkThreshold && d7 > this.microsphereData.get(i5).illumination()) {
                    this.microsphereData.set(i5, new FacetData(d7, d));
                }
            }
        }
    }

    private double interpolate() {
        int i5 = 0;
        double dSample = 0.0d;
        double d = 0.0d;
        for (FacetData facetData : this.microsphereData) {
            double dIllumination = facetData.illumination();
            if (dIllumination != 0.0d) {
                dSample += facetData.sample() * dIllumination;
                d += dIllumination;
            } else {
                i5++;
            }
        }
        return ((double) i5) / ((double) this.size) <= this.maxDarkFraction ? dSample / d : this.background;
    }

    public void add(double[] dArr, boolean z6) {
        if (this.microsphere.size() >= this.size) {
            throw new MaxCountExceededException(Integer.valueOf(this.size));
        }
        if (dArr.length > this.dimension) {
            throw new DimensionMismatchException(dArr.length, this.dimension);
        }
        List<Facet> list = this.microsphere;
        if (z6) {
            dArr = (double[]) dArr.clone();
        }
        list.add(new Facet(dArr));
        this.microsphereData.add(new FacetData(0.0d, 0.0d));
    }

    public InterpolatingMicrosphere copy() {
        return new InterpolatingMicrosphere(this);
    }

    public int getDimension() {
        return this.dimension;
    }

    public int getSize() {
        return this.size;
    }

    public double value(double[] dArr, double[][] dArr2, double[] dArr3, double d, double d6) {
        if (d < 0.0d) {
            throw new NotPositiveException(Double.valueOf(d));
        }
        clear();
        int length = dArr2.length;
        for (int i5 = 0; i5 < length; i5++) {
            double[] dArrEbeSubtract = MathArrays.ebeSubtract(dArr2[i5], dArr);
            double dSafeNorm = MathArrays.safeNorm(dArrEbeSubtract);
            if (FastMath.abs(dSafeNorm) < d6) {
                return dArr3[i5];
            }
            illuminate(dArrEbeSubtract, dArr3[i5], FastMath.pow(dSafeNorm, -d));
        }
        return interpolate();
    }

    public InterpolatingMicrosphere(int i5, int i6, double d, double d6, double d7, UnitSphereRandomVectorGenerator unitSphereRandomVectorGenerator) {
        this(i5, i6, d, d6, d7);
        for (int i7 = 0; i7 < i6; i7++) {
            add(unitSphereRandomVectorGenerator.nextVector(), false);
        }
    }

    public InterpolatingMicrosphere(InterpolatingMicrosphere interpolatingMicrosphere) {
        this.dimension = interpolatingMicrosphere.dimension;
        int i5 = interpolatingMicrosphere.size;
        this.size = i5;
        this.maxDarkFraction = interpolatingMicrosphere.maxDarkFraction;
        this.darkThreshold = interpolatingMicrosphere.darkThreshold;
        this.background = interpolatingMicrosphere.background;
        this.microsphere = interpolatingMicrosphere.microsphere;
        this.microsphereData = new ArrayList(i5);
        for (FacetData facetData : interpolatingMicrosphere.microsphereData) {
            this.microsphereData.add(new FacetData(facetData.illumination(), facetData.sample()));
        }
    }
}
