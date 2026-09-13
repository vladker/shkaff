package org.apache.commons.math3.analysis.interpolation;

import java.io.Serializable;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionNewtonForm;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DividedDifferenceInterpolator implements UnivariateInterpolator, Serializable {
    private static final long serialVersionUID = 107049519551235069L;

    public static double[] computeDividedDifference(double[] dArr, double[] dArr2) {
        PolynomialFunctionLagrangeForm.verifyInterpolationArray(dArr, dArr2, true);
        double[] dArr3 = (double[]) dArr2.clone();
        int length = dArr.length;
        double[] dArr4 = new double[length];
        dArr4[0] = dArr3[0];
        for (int i5 = 1; i5 < length; i5++) {
            int i6 = 0;
            while (i6 < length - i5) {
                int i7 = i6 + 1;
                dArr3[i6] = (dArr3[i7] - dArr3[i6]) / (dArr[i6 + i5] - dArr[i6]);
                i6 = i7;
            }
            dArr4[i5] = dArr3[0];
        }
        return dArr4;
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public PolynomialFunctionNewtonForm interpolate(double[] dArr, double[] dArr2) {
        PolynomialFunctionLagrangeForm.verifyInterpolationArray(dArr, dArr2, true);
        int length = dArr.length - 1;
        double[] dArr3 = new double[length];
        System.arraycopy(dArr, 0, dArr3, 0, length);
        return new PolynomialFunctionNewtonForm(computeDividedDifference(dArr, dArr2), dArr3);
    }
}
