package org.apache.commons.math3.ode;

import org.apache.commons.math3.RealFieldElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FieldODEStateAndDerivative<T extends RealFieldElement<T>> extends FieldODEState<T> {
    private final T[] derivative;
    private final T[][] secondaryDerivative;

    public FieldODEStateAndDerivative(T t6, T[] tArr, T[] tArr2) {
        this(t6, tArr, tArr2, null, null);
    }

    public T[] getDerivative() {
        return (T[]) ((RealFieldElement[]) this.derivative.clone());
    }

    public T[] getSecondaryDerivative(int i5) {
        return (T[]) ((RealFieldElement[]) (i5 == 0 ? this.derivative.clone() : this.secondaryDerivative[i5 - 1].clone()));
    }

    public FieldODEStateAndDerivative(T t6, T[] tArr, T[] tArr2, T[][] tArr3, T[][] tArr4) {
        super(t6, tArr, tArr3);
        this.derivative = (T[]) ((RealFieldElement[]) tArr2.clone());
        this.secondaryDerivative = copy(t6.getField(), tArr4);
    }
}
