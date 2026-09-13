package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class ClassicalRungeKuttaFieldStepInterpolator<T extends RealFieldElement<T>> extends RungeKuttaFieldStepInterpolator<T> {
    public ClassicalRungeKuttaFieldStepInterpolator(Field<T> field, boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldEquationsMapper<T> fieldEquationsMapper) {
        super(field, z6, tArr, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative4, fieldEquationsMapper);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    public FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> fieldEquationsMapper, T t6, T t7, T t8, T t9) {
        T[] tArrCurrentStateLinearCombination;
        T[] tArrDerivativeLinearCombination;
        RealFieldElement realFieldElement = (RealFieldElement) t6.getField().getOne();
        RealFieldElement realFieldElement2 = (RealFieldElement) realFieldElement.subtract(t7);
        RealFieldElement realFieldElement3 = (RealFieldElement) realFieldElement.subtract(t7.multiply(2));
        RealFieldElement realFieldElement4 = (RealFieldElement) realFieldElement2.multiply(realFieldElement3);
        RealFieldElement realFieldElement5 = (RealFieldElement) ((RealFieldElement) t7.multiply(realFieldElement2)).multiply(2);
        RealFieldElement realFieldElement6 = (RealFieldElement) ((RealFieldElement) t7.multiply(realFieldElement3)).negate();
        if (getGlobalPreviousState() == null || t7.getReal() > 0.5d) {
            RealFieldElement realFieldElement7 = (RealFieldElement) t7.multiply(4);
            RealFieldElement realFieldElement8 = (RealFieldElement) t9.divide(6.0d);
            RealFieldElement realFieldElement9 = (RealFieldElement) realFieldElement8.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) realFieldElement7.negate()).add(5.0d))).subtract(1.0d));
            RealFieldElement realFieldElement10 = (RealFieldElement) realFieldElement8.multiply(((RealFieldElement) t7.multiply(realFieldElement7.subtract(2.0d))).subtract(2.0d));
            tArrCurrentStateLinearCombination = currentStateLinearCombination(realFieldElement9, realFieldElement10, realFieldElement10, (RealFieldElement) realFieldElement8.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) realFieldElement7.negate()).subtract(1.0d))).subtract(1.0d)));
            tArrDerivativeLinearCombination = derivativeLinearCombination(realFieldElement4, realFieldElement5, realFieldElement5, realFieldElement6);
        } else {
            RealFieldElement realFieldElement11 = (RealFieldElement) ((RealFieldElement) t7.multiply(t7)).multiply(4);
            RealFieldElement realFieldElement12 = (RealFieldElement) t8.divide(6.0d);
            RealFieldElement realFieldElement13 = (RealFieldElement) realFieldElement12.multiply(((RealFieldElement) realFieldElement11.subtract(t7.multiply(9))).add(6.0d));
            RealFieldElement realFieldElement14 = (RealFieldElement) realFieldElement12.multiply(((RealFieldElement) t7.multiply(6)).subtract(realFieldElement11));
            tArrCurrentStateLinearCombination = previousStateLinearCombination(realFieldElement13, realFieldElement14, realFieldElement14, (RealFieldElement) realFieldElement12.multiply(realFieldElement11.subtract(t7.multiply(3))));
            tArrDerivativeLinearCombination = derivativeLinearCombination(realFieldElement4, realFieldElement5, realFieldElement5, realFieldElement6);
        }
        return new FieldODEStateAndDerivative<>(t6, tArrCurrentStateLinearCombination, tArrDerivativeLinearCombination);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    public ClassicalRungeKuttaFieldStepInterpolator<T> create(Field<T> field, boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldEquationsMapper<T> fieldEquationsMapper) {
        return new ClassicalRungeKuttaFieldStepInterpolator<>(field, z6, tArr, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative4, fieldEquationsMapper);
    }
}
