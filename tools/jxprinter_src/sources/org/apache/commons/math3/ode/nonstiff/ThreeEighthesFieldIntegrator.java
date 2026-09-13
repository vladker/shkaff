package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ThreeEighthesFieldIntegrator<T extends RealFieldElement<T>> extends RungeKuttaFieldIntegrator<T> {
    public ThreeEighthesFieldIntegrator(Field<T> field, T t6) {
        super(field, "3/8", t6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[][] getA() {
        T[][] tArr = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(getField(), 3, -1));
        int i5 = 0;
        while (i5 < tArr.length) {
            int i6 = i5 + 1;
            tArr[i5] = (RealFieldElement[]) MathArrays.buildArray(getField(), i6);
            i5 = i6;
        }
        tArr[0][0] = fraction(1, 3);
        tArr[1][0] = (RealFieldElement) tArr[0][0].negate();
        tArr[1][1] = getField().getOne();
        tArr[2][0] = getField().getOne();
        tArr[2][1] = (RealFieldElement) getField().getOne().negate();
        tArr[2][2] = getField().getOne();
        return tArr;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getB() {
        T[] tArr = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 4));
        tArr[0] = fraction(1, 8);
        T tFraction = fraction(3, 8);
        tArr[1] = tFraction;
        tArr[2] = tFraction;
        tArr[3] = tArr[0];
        return tArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getC() {
        T[] tArr = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 3));
        T tFraction = fraction(1, 3);
        tArr[0] = tFraction;
        tArr[1] = (RealFieldElement) tFraction.add(tFraction);
        tArr[2] = getField().getOne();
        return tArr;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldIntegrator
    public ThreeEighthesFieldStepInterpolator<T> createInterpolator(boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldEquationsMapper<T> fieldEquationsMapper) {
        return new ThreeEighthesFieldStepInterpolator<>(getField(), z6, tArr, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldEquationsMapper);
    }
}
