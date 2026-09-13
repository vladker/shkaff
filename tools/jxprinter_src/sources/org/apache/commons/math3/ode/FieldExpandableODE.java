package org.apache.commons.math3.ode;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FieldExpandableODE<T extends RealFieldElement<T>> {
    private List<FieldSecondaryEquations<T>> components = new ArrayList();
    private FieldEquationsMapper<T> mapper;
    private final FirstOrderFieldDifferentialEquations<T> primary;

    public FieldExpandableODE(FirstOrderFieldDifferentialEquations<T> firstOrderFieldDifferentialEquations) {
        this.primary = firstOrderFieldDifferentialEquations;
        this.mapper = new FieldEquationsMapper<>(null, firstOrderFieldDifferentialEquations.getDimension());
    }

    public int addSecondaryEquations(FieldSecondaryEquations<T> fieldSecondaryEquations) {
        this.components.add(fieldSecondaryEquations);
        this.mapper = new FieldEquationsMapper<>(this.mapper, fieldSecondaryEquations.getDimension());
        return this.components.size();
    }

    public T[] computeDerivatives(T t6, T[] tArr) {
        T[] tArr2 = (T[]) ((RealFieldElement[]) MathArrays.buildArray(t6.getField(), this.mapper.getTotalDimension()));
        int i5 = 0;
        RealFieldElement[] realFieldElementArrExtractEquationData = this.mapper.extractEquationData(0, tArr);
        RealFieldElement[] realFieldElementArrComputeDerivatives = this.primary.computeDerivatives(t6, realFieldElementArrExtractEquationData);
        this.mapper.insertEquationData(0, realFieldElementArrComputeDerivatives, tArr2);
        while (true) {
            int i6 = i5 + 1;
            if (i6 >= this.mapper.getNumberOfEquations()) {
                return tArr2;
            }
            this.mapper.insertEquationData(i6, this.components.get(i5).computeDerivatives(t6, realFieldElementArrExtractEquationData, realFieldElementArrComputeDerivatives, this.mapper.extractEquationData(i6, tArr)), tArr2);
            i5 = i6;
        }
    }

    public FieldEquationsMapper<T> getMapper() {
        return this.mapper;
    }

    public void init(T t6, T[] tArr, T t7) {
        int i5 = 0;
        RealFieldElement[] realFieldElementArrExtractEquationData = this.mapper.extractEquationData(0, tArr);
        this.primary.init(t6, realFieldElementArrExtractEquationData, t7);
        while (true) {
            int i6 = i5 + 1;
            if (i6 >= this.mapper.getNumberOfEquations()) {
                return;
            }
            this.components.get(i5).init(t6, realFieldElementArrExtractEquationData, this.mapper.extractEquationData(i6, tArr), t7);
            i5 = i6;
        }
    }
}
