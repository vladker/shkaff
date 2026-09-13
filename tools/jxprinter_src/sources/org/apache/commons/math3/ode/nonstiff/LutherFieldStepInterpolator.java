package org.apache.commons.math3.ode.nonstiff;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class LutherFieldStepInterpolator<T extends RealFieldElement<T>> extends RungeKuttaFieldStepInterpolator<T> {
    private final T c5a;
    private final T c5b;
    private final T c5c;
    private final T c5d;
    private final T c6a;
    private final T c6b;
    private final T c6c;
    private final T c6d;
    private final T d5a;
    private final T d5b;
    private final T d5c;
    private final T d6a;
    private final T d6b;
    private final T d6c;

    public LutherFieldStepInterpolator(Field<T> field, boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldEquationsMapper<T> fieldEquationsMapper) {
        super(field, z6, tArr, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative4, fieldEquationsMapper);
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) field.getZero().add(21.0d)).sqrt();
        this.c5a = (T) ((RealFieldElement) realFieldElement.multiply(-49)).add(-49.0d);
        this.c5b = (T) ((RealFieldElement) realFieldElement.multiply(287)).add(392.0d);
        this.c5c = (T) ((RealFieldElement) realFieldElement.multiply(-357)).add(-637.0d);
        this.c5d = (T) ((RealFieldElement) realFieldElement.multiply(343)).add(833.0d);
        this.c6a = (T) ((RealFieldElement) realFieldElement.multiply(49)).add(-49.0d);
        this.c6b = (T) ((RealFieldElement) realFieldElement.multiply(-287)).add(392.0d);
        this.c6c = (T) ((RealFieldElement) realFieldElement.multiply(357)).add(-637.0d);
        this.c6d = (T) ((RealFieldElement) realFieldElement.multiply(-343)).add(833.0d);
        this.d5a = (T) ((RealFieldElement) realFieldElement.multiply(49)).add(49.0d);
        this.d5b = (T) ((RealFieldElement) realFieldElement.multiply(-847)).add(-1372.0d);
        this.d5c = (T) ((RealFieldElement) realFieldElement.multiply(1029)).add(2254.0d);
        this.d6a = (T) ((RealFieldElement) realFieldElement.multiply(-49)).add(49.0d);
        this.d6b = (T) ((RealFieldElement) realFieldElement.multiply(847)).add(-1372.0d);
        this.d6c = (T) ((RealFieldElement) realFieldElement.multiply(-1029)).add(2254.0d);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    public FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> fieldEquationsMapper, T t6, T t7, T t8, T t9) {
        T[] tArrCurrentStateLinearCombination;
        T[] tArrDerivativeLinearCombination;
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(21)).add(-47.0d))).add(36.0d))).add(-10.8d))).add(1.0d);
        RealFieldElement realFieldElement2 = (RealFieldElement) t6.getField().getZero();
        RealFieldElement realFieldElement3 = (RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(112)).add(-202.66666666666666d))).add(106.66666666666667d))).add(-13.866666666666667d));
        RealFieldElement realFieldElement4 = (RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(-113.4d)).add(194.4d))).add(-97.2d))).add(12.96d));
        RealFieldElement realFieldElement5 = (RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(this.c5a.divide(5.0d))).add(this.c5b.divide(15.0d)))).add(this.c5c.divide(30.0d)))).add(this.c5d.divide(150.0d)));
        RealFieldElement realFieldElement6 = (RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(this.c6a.divide(5.0d))).add(this.c6b.divide(15.0d)))).add(this.c6c.divide(30.0d)))).add(this.c6d.divide(150.0d)));
        RealFieldElement realFieldElement7 = (RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(3.0d)).add(-3.0d))).add(0.6d));
        if (getGlobalPreviousState() == null || t7.getReal() > 0.5d) {
            tArrCurrentStateLinearCombination = currentStateLinearCombination((RealFieldElement) t9.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(-4.2d)).add(7.55d))).add(-4.45d))).add(0.95d))).add(-0.05d)), (RealFieldElement) t6.getField().getZero(), (RealFieldElement) t9.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(-22.4d)).add(28.266666666666666d))).add(-7.288888888888889d))).add(-0.35555555555555557d))).add(-0.35555555555555557d)), (RealFieldElement) t9.multiply(t7.multiply(t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(22.68d)).add(-25.92d))).add(6.48d)))), (RealFieldElement) t9.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(this.d5a.divide(25.0d))).add(this.d5b.divide(300.0d)))).add(this.d5c.divide(900.0d)))).add(-0.2722222222222222d))).add(-0.2722222222222222d)), (RealFieldElement) t9.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(this.d6a.divide(25.0d))).add(this.d6b.divide(300.0d)))).add(this.d6c.divide(900.0d)))).add(-0.2722222222222222d))).add(-0.2722222222222222d)), (RealFieldElement) t9.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(-0.75d)).add(0.25d))).add(-0.05d))).add(-0.05d)));
            tArrDerivativeLinearCombination = derivativeLinearCombination(realFieldElement, realFieldElement2, realFieldElement3, realFieldElement4, realFieldElement5, realFieldElement6, realFieldElement7);
        } else {
            tArrCurrentStateLinearCombination = previousStateLinearCombination((RealFieldElement) t8.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(4.2d)).add(-11.75d))).add(12.0d))).add(-5.4d))).add(1.0d)), (RealFieldElement) t6.getField().getZero(), (RealFieldElement) t8.multiply(t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(22.4d)).add(-50.666666666666664d))).add(35.55555555555556d))).add(-6.933333333333334d))), (RealFieldElement) t8.multiply(t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(-22.68d)).add(48.6d))).add(-32.4d))).add(6.48d))), (RealFieldElement) t8.multiply(t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(this.c5a.divide(25.0d))).add(this.c5b.divide(60.0d)))).add(this.c5c.divide(90.0d)))).add(this.c5d.divide(300.0d)))), (RealFieldElement) t8.multiply(t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(this.c6a.divide(25.0d))).add(this.c6b.divide(60.0d)))).add(this.c6c.divide(90.0d)))).add(this.c6d.divide(300.0d)))), (RealFieldElement) t8.multiply(t7.multiply(((RealFieldElement) t7.multiply(((RealFieldElement) t7.multiply(0.75d)).add(-1.0d))).add(0.3d))));
            tArrDerivativeLinearCombination = derivativeLinearCombination(realFieldElement, realFieldElement2, realFieldElement3, realFieldElement4, realFieldElement5, realFieldElement6, realFieldElement7);
        }
        return new FieldODEStateAndDerivative<>(t6, tArrCurrentStateLinearCombination, tArrDerivativeLinearCombination);
    }

    @Override // org.apache.commons.math3.ode.nonstiff.RungeKuttaFieldStepInterpolator
    public LutherFieldStepInterpolator<T> create(Field<T> field, boolean z6, T[][] tArr, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldEquationsMapper<T> fieldEquationsMapper) {
        return new LutherFieldStepInterpolator<>(field, z6, tArr, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative4, fieldEquationsMapper);
    }
}
