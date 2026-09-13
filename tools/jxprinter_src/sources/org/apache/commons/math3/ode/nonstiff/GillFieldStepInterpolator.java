package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class GillFieldStepInterpolator<T extends RealFieldElement<T>> extends RungeKuttaFieldStepInterpolator<T> {
    private final T one_minus_inv_sqrt_2;
    private final T one_plus_inv_sqrt_2;

    public GillFieldStepInterpolator(Field<T> field, boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldEquationsMapper<T> fieldEquationsMapper) {
        super(field, z6, tArr, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative4, fieldEquationsMapper);
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) field.getZero().add(0.5d)).sqrt();
        this.one_minus_inv_sqrt_2 = (T) field.getOne().subtract(realFieldElement);
        this.one_plus_inv_sqrt_2 = (T) field.getOne().add(realFieldElement);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    public FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> fieldEquationsMapper, T t6, T t7, T t8, T t9) {
        T[] tArrCurrentStateLinearCombination;
        T[] tArrDerivativeLinearCombination;
        RealFieldElement realFieldElement = (RealFieldElement) t6.getField().getOne();
        RealFieldElement realFieldElement2 = (RealFieldElement) t7.multiply(2);
        RealFieldElement realFieldElement3 = (RealFieldElement) realFieldElement2.multiply(realFieldElement2);
        RealFieldElement realFieldElement4 = (RealFieldElement) ((RealFieldElement) t7.multiply(realFieldElement2.subtract(3.0d))).add(1.0d);
        RealFieldElement realFieldElement5 = (RealFieldElement) realFieldElement2.multiply(realFieldElement.subtract(t7));
        RealFieldElement realFieldElement6 = (RealFieldElement) realFieldElement5.multiply(this.one_minus_inv_sqrt_2);
        RealFieldElement realFieldElement7 = (RealFieldElement) realFieldElement5.multiply(this.one_plus_inv_sqrt_2);
        RealFieldElement realFieldElement8 = (RealFieldElement) t7.multiply(realFieldElement2.subtract(1.0d));
        if (getGlobalPreviousState() == null || t7.getReal() > 0.5d) {
            RealFieldElement realFieldElement9 = (RealFieldElement) t9.divide(-6.0d);
            RealFieldElement realFieldElement10 = (RealFieldElement) realFieldElement9.multiply(((RealFieldElement) realFieldElement2.add(2.0d)).subtract(realFieldElement3));
            tArrCurrentStateLinearCombination = currentStateLinearCombination((RealFieldElement) realFieldElement9.multiply(((RealFieldElement) realFieldElement3.subtract(t7.multiply(5))).add(1.0d)), (RealFieldElement) realFieldElement10.multiply(this.one_minus_inv_sqrt_2), (RealFieldElement) realFieldElement10.multiply(this.one_plus_inv_sqrt_2), (RealFieldElement) realFieldElement9.multiply(((RealFieldElement) realFieldElement3.add(t7)).add(1.0d)));
            tArrDerivativeLinearCombination = derivativeLinearCombination(realFieldElement4, realFieldElement6, realFieldElement7, realFieldElement8);
        } else {
            RealFieldElement realFieldElement11 = (RealFieldElement) t8.divide(6.0d);
            RealFieldElement realFieldElement12 = (RealFieldElement) realFieldElement11.multiply(((RealFieldElement) t7.multiply(6)).subtract(realFieldElement3));
            tArrCurrentStateLinearCombination = previousStateLinearCombination((RealFieldElement) realFieldElement11.multiply(((RealFieldElement) realFieldElement3.subtract(t7.multiply(9))).add(6.0d)), (RealFieldElement) realFieldElement12.multiply(this.one_minus_inv_sqrt_2), (RealFieldElement) realFieldElement12.multiply(this.one_plus_inv_sqrt_2), (RealFieldElement) realFieldElement11.multiply(realFieldElement3.subtract(t7.multiply(3))));
            tArrDerivativeLinearCombination = derivativeLinearCombination(realFieldElement4, realFieldElement6, realFieldElement7, realFieldElement8);
        }
        return new FieldODEStateAndDerivative<>(t6, tArrCurrentStateLinearCombination, tArrDerivativeLinearCombination);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    public GillFieldStepInterpolator<T> create(Field<T> field, boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldEquationsMapper<T> fieldEquationsMapper) {
        return new GillFieldStepInterpolator<>(field, z6, tArr, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative4, fieldEquationsMapper);
    }
}
