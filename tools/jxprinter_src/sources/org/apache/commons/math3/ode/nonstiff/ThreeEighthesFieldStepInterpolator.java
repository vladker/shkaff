package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class ThreeEighthesFieldStepInterpolator<T extends RealFieldElement<T>> extends RungeKuttaFieldStepInterpolator<T> {
    public ThreeEighthesFieldStepInterpolator(Field<T> field, boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldEquationsMapper<T> fieldEquationsMapper) {
        super(field, z6, tArr, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative4, fieldEquationsMapper);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    public FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> fieldEquationsMapper, T t6, T t7, T t8, T t9) {
        T[] tArrCurrentStateLinearCombination;
        T[] tArrDerivativeLinearCombination;
        RealFieldElement realFieldElement = (RealFieldElement) t7.multiply(0.75d);
        RealFieldElement realFieldElement2 = (RealFieldElement) ((RealFieldElement) realFieldElement.multiply(((RealFieldElement) t7.multiply(4)).subtract(5.0d))).add(1.0d);
        RealFieldElement realFieldElement3 = (RealFieldElement) realFieldElement.multiply(((RealFieldElement) t7.multiply(-6)).add(5.0d));
        RealFieldElement realFieldElement4 = (RealFieldElement) realFieldElement.multiply(((RealFieldElement) t7.multiply(2)).subtract(1.0d));
        if (getGlobalPreviousState() == null || t7.getReal() > 0.5d) {
            RealFieldElement realFieldElement5 = (RealFieldElement) t9.divide(-8.0d);
            RealFieldElement realFieldElement6 = (RealFieldElement) ((RealFieldElement) t7.multiply(t7)).multiply(4);
            RealFieldElement realFieldElement7 = (RealFieldElement) t7.add(1.0d);
            tArrCurrentStateLinearCombination = currentStateLinearCombination((RealFieldElement) realFieldElement5.multiply(((RealFieldElement) ((RealFieldElement) realFieldElement6.multiply(2)).subtract(t7.multiply(7))).add(1.0d)), (RealFieldElement) ((RealFieldElement) realFieldElement5.multiply(realFieldElement7.subtract(realFieldElement6))).multiply(3), (RealFieldElement) ((RealFieldElement) realFieldElement5.multiply(realFieldElement7)).multiply(3), (RealFieldElement) realFieldElement5.multiply(realFieldElement7.add(realFieldElement6)));
            tArrDerivativeLinearCombination = derivativeLinearCombination(realFieldElement2, realFieldElement3, realFieldElement, realFieldElement4);
        } else {
            RealFieldElement realFieldElement8 = (RealFieldElement) t8.divide(8.0d);
            RealFieldElement realFieldElement9 = (RealFieldElement) ((RealFieldElement) t7.multiply(t7)).multiply(4);
            tArrCurrentStateLinearCombination = previousStateLinearCombination((RealFieldElement) realFieldElement8.multiply(((RealFieldElement) ((RealFieldElement) realFieldElement9.multiply(2)).subtract(t7.multiply(15))).add(8.0d)), (RealFieldElement) ((RealFieldElement) realFieldElement8.multiply(((RealFieldElement) t7.multiply(5)).subtract(realFieldElement9))).multiply(3), (RealFieldElement) ((RealFieldElement) realFieldElement8.multiply(t7)).multiply(3), (RealFieldElement) realFieldElement8.multiply(realFieldElement9.subtract(t7.multiply(3))));
            tArrDerivativeLinearCombination = derivativeLinearCombination(realFieldElement2, realFieldElement3, realFieldElement, realFieldElement4);
        }
        return new FieldODEStateAndDerivative<>(t6, tArrCurrentStateLinearCombination, tArrDerivativeLinearCombination);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    public ThreeEighthesFieldStepInterpolator<T> create(Field<T> field, boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldEquationsMapper<T> fieldEquationsMapper) {
        return new ThreeEighthesFieldStepInterpolator<>(field, z6, tArr, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative4, fieldEquationsMapper);
    }
}
