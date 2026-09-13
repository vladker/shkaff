package org.apache.commons.math3.ode.nonstiff;

import java.util.Arrays;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.ode.FieldEquationsMapper;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class AdamsFieldStepInterpolator<T extends RealFieldElement<T>> extends AbstractFieldStepInterpolator<T> {
    private final Array2DRowFieldMatrix<T> nordsieck;
    private final FieldODEStateAndDerivative<T> reference;
    private final T[] scaled;
    private T scalingH;

    public AdamsFieldStepInterpolator(T t6, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, T[] tArr, Array2DRowFieldMatrix<T> array2DRowFieldMatrix, boolean z6, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldEquationsMapper<T> fieldEquationsMapper) {
        this(t6, fieldODEStateAndDerivative, tArr, array2DRowFieldMatrix, z6, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldEquationsMapper);
    }

    public static <S extends RealFieldElement<S>> FieldODEStateAndDerivative<S> taylor(FieldODEStateAndDerivative<S> fieldODEStateAndDerivative, S s6, S s7, S[] sArr, Array2DRowFieldMatrix<S> array2DRowFieldMatrix) {
        int i5;
        RealFieldElement realFieldElement = (RealFieldElement) s6.subtract(fieldODEStateAndDerivative.getTime());
        RealFieldElement realFieldElement2 = (RealFieldElement) realFieldElement.divide(s7);
        RealFieldElement[] realFieldElementArr = (RealFieldElement[]) MathArrays.buildArray(s6.getField(), sArr.length);
        Arrays.fill(realFieldElementArr, s6.getField().getZero());
        RealFieldElement[] realFieldElementArr2 = (RealFieldElement[]) MathArrays.buildArray(s6.getField(), sArr.length);
        Arrays.fill(realFieldElementArr2, s6.getField().getZero());
        RealFieldElement[][] realFieldElementArr3 = (RealFieldElement[][]) array2DRowFieldMatrix.getDataRef();
        int length = realFieldElementArr3.length;
        while (true) {
            length--;
            i5 = 0;
            if (length < 0) {
                break;
            }
            int i6 = length + 2;
            RealFieldElement[] realFieldElementArr4 = realFieldElementArr3[length];
            RealFieldElement realFieldElement3 = (RealFieldElement) realFieldElement2.pow(i6);
            while (i5 < realFieldElementArr4.length) {
                RealFieldElement realFieldElement4 = (RealFieldElement) realFieldElementArr4[i5].multiply(realFieldElement3);
                realFieldElementArr[i5] = (RealFieldElement) realFieldElementArr[i5].add(realFieldElement4);
                realFieldElementArr2[i5] = (RealFieldElement) realFieldElementArr2[i5].add(realFieldElement4.multiply(i6));
                i5++;
            }
        }
        S[] state = fieldODEStateAndDerivative.getState();
        while (i5 < realFieldElementArr.length) {
            RealFieldElement realFieldElement5 = (RealFieldElement) realFieldElementArr[i5].add(sArr[i5].multiply(realFieldElement2));
            realFieldElementArr[i5] = realFieldElement5;
            state[i5] = (RealFieldElement) state[i5].add(realFieldElement5);
            realFieldElementArr2[i5] = (RealFieldElement) ((RealFieldElement) realFieldElementArr2[i5].add(sArr[i5].multiply(realFieldElement2))).divide(realFieldElement);
            i5++;
        }
        return new FieldODEStateAndDerivative<>(s6, state, realFieldElementArr2);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    public FieldODEStateAndDerivative<T> computeInterpolatedStateAndDerivatives(FieldEquationsMapper<T> fieldEquationsMapper, T t6, T t7, T t8, T t9) {
        return taylor(this.reference, t6, this.scalingH, this.scaled, this.nordsieck);
    }

    private AdamsFieldStepInterpolator(T t6, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, T[] tArr, Array2DRowFieldMatrix<T> array2DRowFieldMatrix, boolean z6, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative5, FieldEquationsMapper<T> fieldEquationsMapper) {
        super(z6, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative4, fieldODEStateAndDerivative5, fieldEquationsMapper);
        this.scalingH = t6;
        this.reference = fieldODEStateAndDerivative;
        this.scaled = (T[]) ((RealFieldElement[]) tArr.clone());
        this.nordsieck = new Array2DRowFieldMatrix<>(array2DRowFieldMatrix.getData(), false);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractFieldStepInterpolator
    public AdamsFieldStepInterpolator<T> create(boolean z6, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative2, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative3, FieldODEStateAndDerivative<T> fieldODEStateAndDerivative4, FieldEquationsMapper<T> fieldEquationsMapper) {
        return new AdamsFieldStepInterpolator<>(this.scalingH, this.reference, this.scaled, this.nordsieck, z6, fieldODEStateAndDerivative, fieldODEStateAndDerivative2, fieldODEStateAndDerivative3, fieldODEStateAndDerivative4, fieldEquationsMapper);
    }
}
