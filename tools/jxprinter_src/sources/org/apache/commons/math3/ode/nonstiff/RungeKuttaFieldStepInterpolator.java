package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
abstract class RungeKuttaFieldStepInterpolator<T extends RealFieldElement<T>> extends AbstractFieldStepInterpolator<T> {
    private final Field<T> field;
    private final T[][] yDotK;

    public RungeKuttaFieldStepInterpolator(Field<T> field, boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldEquationsMapper<T> fieldEquationsMapper) {
        super(z6, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative4, fieldEquationsMapper);
        this.field = field;
        this.yDotK = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(field, tArr.length, -1));
        for (int i5 = 0; i5 < tArr.length; i5++) {
            ((T[][]) this.yDotK)[i5] = (RealFieldElement[]) tArr[i5].clone();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private T[] combine(T[] tArr, T... tArr2) {
        for (int i5 = 0; i5 < tArr.length; i5++) {
            for (int i6 = 0; i6 < tArr2.length; i6++) {
                tArr[i5] = (RealFieldElement) tArr[i5].add(tArr2[i6].multiply(this.yDotK[i6][i5]));
            }
        }
        return tArr;
    }

    public abstract RungeKuttaFieldStepInterpolator<T> create(Field<T> field, boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldEquationsMapper<T> fieldEquationsMapper);

    public T[] currentStateLinearCombination(T... tArr) {
        return (T[]) combine(getCurrentState().getState(), tArr);
    }

    public T[] derivativeLinearCombination(T... tArr) {
        return (T[]) combine((RealFieldElement[]) MathArrays.buildArray(this.field, this.yDotK[0].length), tArr);
    }

    public final T[] previousStateLinearCombination(T... tArr) {
        return (T[]) combine(getPreviousState().getState(), tArr);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    public RungeKuttaFieldStepInterpolator<T> create(boolean z6, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldEquationsMapper<T> fieldEquationsMapper) {
        return create(this.field, z6, this.yDotK, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative4, fieldEquationsMapper);
    }
}
