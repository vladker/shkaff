package org.apache.commons.math3.ode;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FieldODEState<T extends RealFieldElement<T>> {
    private final T[][] secondaryState;
    private final T[] state;
    private final T time;

    public FieldODEState(T t6, T[] tArr) {
        this(t6, tArr, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[][] copy(Field<T> field, T[][] tArr) {
        if (tArr == null) {
            return null;
        }
        T[][] tArr2 = (T[][]) ((RealFieldElement[][]) MathArrays.buildArray(field, tArr.length, -1));
        for (int i5 = 0; i5 < tArr.length; i5++) {
            tArr2[i5] = (RealFieldElement[]) tArr[i5].clone();
        }
        return tArr2;
    }

    public int getNumberOfSecondaryStates() {
        T[][] tArr = this.secondaryState;
        if (tArr == null) {
            return 0;
        }
        return tArr.length;
    }

    public T[] getSecondaryState(int i5) {
        return (T[]) ((RealFieldElement[]) (i5 == 0 ? this.state.clone() : this.secondaryState[i5 - 1].clone()));
    }

    public int getSecondaryStateDimension(int i5) {
        return i5 == 0 ? this.state.length : this.secondaryState[i5 - 1].length;
    }

    public T[] getState() {
        return (T[]) ((RealFieldElement[]) this.state.clone());
    }

    public int getStateDimension() {
        return this.state.length;
    }

    public T getTime() {
        return this.time;
    }

    public FieldODEState(T t6, T[] tArr, T[][] tArr2) {
        this.time = t6;
        this.state = (T[]) ((RealFieldElement[]) tArr.clone());
        this.secondaryState = (T[][]) copy(t6.getField(), tArr2);
    }
}
