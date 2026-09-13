package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LutherFieldIntegrator<T extends RealFieldElement<T>> extends RungeKuttaFieldIntegrator<T> {
    public LutherFieldIntegrator(Field<T> field, T t6) {
        super(field, "Luther", t6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[][] getA() {
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) getField().getZero().add(21.0d)).sqrt();
        T[][] tArr = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(getField(), 6, -1));
        int i5 = 0;
        while (i5 < tArr.length) {
            int i6 = i5 + 1;
            tArr[i5] = (RealFieldElement[]) MathArrays.buildArray(getField(), i6);
            i5 = i6;
        }
        tArr[0][0] = getField().getOne();
        tArr[1][0] = fraction(3, 8);
        tArr[1][1] = fraction(1, 8);
        tArr[2][0] = fraction(8, 27);
        tArr[2][1] = fraction(2, 27);
        Object[] objArr = tArr[2];
        objArr[2] = objArr[0];
        tArr[3][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(9)).add(-21.0d)).divide(392.0d);
        tArr[3][1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(8)).add(-56.0d)).divide(392.0d);
        tArr[3][2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(-48)).add(336.0d)).divide(392.0d);
        tArr[3][3] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(3)).add(-63.0d)).divide(392.0d);
        tArr[4][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(-255)).add(-1155.0d)).divide(1960.0d);
        tArr[4][1] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(-40)).add(-280.0d)).divide(1960.0d);
        tArr[4][2] = (RealFieldElement) ((RealFieldElement) realFieldElement.multiply(-320)).divide(1960.0d);
        tArr[4][3] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(363)).add(63.0d)).divide(1960.0d);
        tArr[4][4] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(392)).add(2352.0d)).divide(1960.0d);
        tArr[5][0] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(105)).add(330.0d)).divide(180.0d);
        tArr[5][1] = fraction(2, 3);
        tArr[5][2] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(280)).add(-200.0d)).divide(180.0d);
        tArr[5][3] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(-189)).add(126.0d)).divide(180.0d);
        tArr[5][4] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(-126)).add(-686.0d)).divide(180.0d);
        tArr[5][5] = (RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement.multiply(-70)).add(490.0d)).divide(180.0d);
        return tArr;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getB() {
        T[] tArr = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 7));
        tArr[0] = fraction(1, 20);
        tArr[1] = getField().getZero();
        tArr[2] = fraction(16, 45);
        tArr[3] = getField().getZero();
        T tFraction = fraction(49, 180);
        tArr[4] = tFraction;
        tArr[5] = tFraction;
        tArr[6] = tArr[0];
        return tArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.ode.nonstiff.FieldButcherArrayProvider
    public T[] getC() {
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) getField().getZero().add(21.0d)).sqrt();
        T[] tArr = (T[]) ((RealFieldElement[]) MathArrays.buildArray(getField(), 6));
        tArr[0] = getField().getOne();
        tArr[1] = fraction(1, 2);
        tArr[2] = fraction(2, 3);
        tArr[3] = (RealFieldElement) ((RealFieldElement) realFieldElement.subtract(7.0d)).divide(-14.0d);
        tArr[4] = (RealFieldElement) ((RealFieldElement) realFieldElement.add(7.0d)).divide(14.0d);
        tArr[5] = getField().getOne();
        return tArr;
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldIntegrator
    public LutherFieldStepInterpolator<T> createInterpolator(boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldEquationsMapper<T> fieldEquationsMapper) {
        return new LutherFieldStepInterpolator<>(getField(), z6, tArr, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldEquationsMapper);
    }
}
