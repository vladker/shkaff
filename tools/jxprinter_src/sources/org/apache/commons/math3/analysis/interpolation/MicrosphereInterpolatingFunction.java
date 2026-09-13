package org.apache.commons.math3.analysis.interpolation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.random.UnitSphereRandomVectorGenerator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class MicrosphereInterpolatingFunction implements MultivariateFunction {
    private final double brightnessExponent;
    private final int dimension;
    private final List<MicrosphereSurfaceElement> microsphere;
    private final Map<RealVector, Double> samples;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class MicrosphereSurfaceElement {
        private double brightestIllumination;
        private Map.Entry<RealVector, Double> brightestSample;
        private final RealVector normal;

        public MicrosphereSurfaceElement(double[] dArr) {
            this.normal = new ArrayRealVector(dArr);
        }

        public double illumination() {
            return this.brightestIllumination;
        }

        public RealVector normal() {
            return this.normal;
        }

        public void reset() {
            this.brightestIllumination = 0.0d;
            this.brightestSample = null;
        }

        public Map.Entry<RealVector, Double> sample() {
            return this.brightestSample;
        }

        public void store(double d, Map.Entry<RealVector, Double> entry) {
            if (d > this.brightestIllumination) {
                this.brightestIllumination = d;
                this.brightestSample = entry;
            }
        }
    }

    public MicrosphereInterpolatingFunction(double[][] dArr, double[] dArr2, int i5, int i6, UnitSphereRandomVectorGenerator unitSphereRandomVectorGenerator) {
        if (dArr == null || dArr2 == null) {
            throw new NullArgumentException();
        }
        if (dArr.length == 0) {
            throw new NoDataException();
        }
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        double[] dArr3 = dArr[0];
        if (dArr3 == null) {
            throw new NullArgumentException();
        }
        this.dimension = dArr3.length;
        this.brightnessExponent = i5;
        this.samples = new HashMap(dArr2.length);
        for (int i7 = 0; i7 < dArr.length; i7++) {
            double[] dArr4 = dArr[i7];
            if (dArr4 == null) {
                throw new NullArgumentException();
            }
            if (dArr4.length != this.dimension) {
                throw new DimensionMismatchException(dArr4.length, this.dimension);
            }
            this.samples.put(new ArrayRealVector(dArr4), Double.valueOf(dArr2[i7]));
        }
        this.microsphere = new ArrayList(i6);
        for (int i8 = 0; i8 < i6; i8++) {
            this.microsphere.add(new MicrosphereSurfaceElement(unitSphereRandomVectorGenerator.nextVector()));
        }
    }

    private double cosAngle(RealVector realVector, RealVector realVector2) {
        return realVector.dotProduct(realVector2) / (realVector2.getNorm() * realVector.getNorm());
    }

    @Override // org.apache.commons.math3.analysis.MultivariateFunction
    public double value(double[] dArr) {
        ArrayRealVector arrayRealVector = new ArrayRealVector(dArr);
        Iterator<MicrosphereSurfaceElement> it = this.microsphere.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
        for (Map.Entry<RealVector, Double> entry : this.samples.entrySet()) {
            RealVector realVectorSubtract = entry.getKey().subtract(arrayRealVector);
            double norm = realVectorSubtract.getNorm();
            if (FastMath.abs(norm) < FastMath.ulp(1.0d)) {
                return entry.getValue().doubleValue();
            }
            for (MicrosphereSurfaceElement microsphereSurfaceElement : this.microsphere) {
                microsphereSurfaceElement.store(cosAngle(realVectorSubtract, microsphereSurfaceElement.normal()) * FastMath.pow(norm, -this.brightnessExponent), entry);
            }
        }
        double dDoubleValue = 0.0d;
        double d = 0.0d;
        for (MicrosphereSurfaceElement microsphereSurfaceElement2 : this.microsphere) {
            double dIllumination = microsphereSurfaceElement2.illumination();
            Map.Entry<RealVector, Double> entrySample = microsphereSurfaceElement2.sample();
            if (entrySample != null) {
                d += dIllumination;
                dDoubleValue = (entrySample.getValue().doubleValue() * dIllumination) + dDoubleValue;
            }
        }
        return dDoubleValue / d;
    }
}
