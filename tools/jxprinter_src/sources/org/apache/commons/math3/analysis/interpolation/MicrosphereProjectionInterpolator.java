package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.random.UnitSphereRandomVectorGenerator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MicrosphereProjectionInterpolator implements MultivariateInterpolator {
    private final double exponent;
    private final InterpolatingMicrosphere microsphere;
    private final double noInterpolationTolerance;
    private final boolean sharedSphere;

    public MicrosphereProjectionInterpolator(int i5, int i6, double d, double d6, double d7, double d8, boolean z6, double d9) {
        this(new InterpolatingMicrosphere(i5, i6, d, d6, d7, new UnitSphereRandomVectorGenerator(i5)), d8, z6, d9);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.MultivariateInterpolator
    public MultivariateFunction interpolate(final double[][] dArr, final double[] dArr2) {
        if (dArr == null || dArr2 == null) {
            throw new NullArgumentException();
        }
        if (dArr.length == 0) {
            throw new NoDataException();
        }
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        if (dArr[0] == null) {
            throw new NullArgumentException();
        }
        int dimension = this.microsphere.getDimension();
        if (dimension != dArr[0].length) {
            throw new DimensionMismatchException(dArr[0].length, dimension);
        }
        final InterpolatingMicrosphere interpolatingMicrosphereCopy = this.sharedSphere ? this.microsphere : this.microsphere.copy();
        return new MultivariateFunction() { // from class: org.apache.commons.math3.analysis.interpolation.MicrosphereProjectionInterpolator.1
            @Override // org.apache.commons.math3.analysis.MultivariateFunction
            public double value(double[] dArr3) {
                return interpolatingMicrosphereCopy.value(dArr3, dArr, dArr2, MicrosphereProjectionInterpolator.this.exponent, MicrosphereProjectionInterpolator.this.noInterpolationTolerance);
            }
        };
    }

    public MicrosphereProjectionInterpolator(InterpolatingMicrosphere interpolatingMicrosphere, double d, boolean z6, double d6) {
        if (d < 0.0d) {
            throw new NotPositiveException(Double.valueOf(d));
        }
        this.microsphere = interpolatingMicrosphere;
        this.exponent = d;
        this.sharedSphere = z6;
        this.noInterpolationTolerance = d6;
    }
}
