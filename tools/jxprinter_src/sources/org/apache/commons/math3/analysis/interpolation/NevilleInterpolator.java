package org.apache.commons.math3.analysis.interpolation;

import java.io.Serializable;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NevilleInterpolator implements UnivariateInterpolator, Serializable {
    static final long serialVersionUID = 3003707660147873733L;

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public PolynomialFunctionLagrangeForm interpolate(double[] dArr, double[] dArr2) {
        return new PolynomialFunctionLagrangeForm(dArr, dArr2);
    }
}
