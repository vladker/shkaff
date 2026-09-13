package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.random.UnitSphereRandomVectorGenerator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class MicrosphereInterpolator implements MultivariateInterpolator {
    public static final int DEFAULT_BRIGHTNESS_EXPONENT = 2;
    public static final int DEFAULT_MICROSPHERE_ELEMENTS = 2000;
    private final int brightnessExponent;
    private final int microsphereElements;

    public MicrosphereInterpolator() {
        this(2000, 2);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.MultivariateInterpolator
    public MultivariateFunction interpolate(double[][] dArr, double[] dArr2) {
        return new MicrosphereInterpolatingFunction(dArr, dArr2, this.brightnessExponent, this.microsphereElements, new UnitSphereRandomVectorGenerator(dArr[0].length));
    }

    public MicrosphereInterpolator(int i5, int i6) {
        if (i6 < 0) {
            throw new NotPositiveException(Integer.valueOf(i6));
        }
        if (i5 <= 0) {
            throw new NotStrictlyPositiveException(Integer.valueOf(i5));
        }
        this.microsphereElements = i5;
        this.brightnessExponent = i6;
    }
}
