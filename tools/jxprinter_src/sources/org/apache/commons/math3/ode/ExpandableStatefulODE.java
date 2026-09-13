package org.apache.commons.math3.ode;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ExpandableStatefulODE {
    private List<SecondaryComponent> components;
    private final FirstOrderDifferentialEquations primary;
    private final EquationsMapper primaryMapper;
    private final double[] primaryState;
    private final double[] primaryStateDot;
    private double time;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class SecondaryComponent {
        private final SecondaryEquations equation;
        private final EquationsMapper mapper;
        private final double[] state;
        private final double[] stateDot;

        public SecondaryComponent(SecondaryEquations secondaryEquations, int i5) {
            int dimension = secondaryEquations.getDimension();
            this.equation = secondaryEquations;
            this.mapper = new EquationsMapper(i5, dimension);
            this.state = new double[dimension];
            this.stateDot = new double[dimension];
        }
    }

    public ExpandableStatefulODE(FirstOrderDifferentialEquations firstOrderDifferentialEquations) {
        int dimension = firstOrderDifferentialEquations.getDimension();
        this.primary = firstOrderDifferentialEquations;
        this.primaryMapper = new EquationsMapper(0, dimension);
        this.time = Double.NaN;
        this.primaryState = new double[dimension];
        this.primaryStateDot = new double[dimension];
        this.components = new ArrayList();
    }

    public int addSecondaryEquations(SecondaryEquations secondaryEquations) {
        int dimension;
        if (this.components.isEmpty()) {
            this.components = new ArrayList();
            dimension = this.primary.getDimension();
        } else {
            SecondaryComponent secondaryComponent = (SecondaryComponent) AbstractC0157z.f(1, this.components);
            dimension = secondaryComponent.mapper.getDimension() + secondaryComponent.mapper.getFirstIndex();
        }
        this.components.add(new SecondaryComponent(secondaryEquations, dimension));
        return this.components.size() - 1;
    }

    public void computeDerivatives(double d, double[] dArr, double[] dArr2) {
        this.primaryMapper.extractEquationData(dArr, this.primaryState);
        this.primary.computeDerivatives(d, this.primaryState, this.primaryStateDot);
        for (SecondaryComponent secondaryComponent : this.components) {
            secondaryComponent.mapper.extractEquationData(dArr, secondaryComponent.state);
            double d6 = d;
            secondaryComponent.equation.computeDerivatives(d6, this.primaryState, this.primaryStateDot, secondaryComponent.state, secondaryComponent.stateDot);
            secondaryComponent.mapper.insertEquationData(secondaryComponent.stateDot, dArr2);
            d = d6;
        }
        this.primaryMapper.insertEquationData(this.primaryStateDot, dArr2);
    }

    public double[] getCompleteState() {
        double[] dArr = new double[getTotalDimension()];
        this.primaryMapper.insertEquationData(this.primaryState, dArr);
        for (SecondaryComponent secondaryComponent : this.components) {
            secondaryComponent.mapper.insertEquationData(secondaryComponent.state, dArr);
        }
        return dArr;
    }

    public FirstOrderDifferentialEquations getPrimary() {
        return this.primary;
    }

    public EquationsMapper getPrimaryMapper() {
        return this.primaryMapper;
    }

    public double[] getPrimaryState() {
        return (double[]) this.primaryState.clone();
    }

    public double[] getPrimaryStateDot() {
        return (double[]) this.primaryStateDot.clone();
    }

    public EquationsMapper[] getSecondaryMappers() {
        int size = this.components.size();
        EquationsMapper[] equationsMapperArr = new EquationsMapper[size];
        for (int i5 = 0; i5 < size; i5++) {
            equationsMapperArr[i5] = this.components.get(i5).mapper;
        }
        return equationsMapperArr;
    }

    public double[] getSecondaryState(int i5) {
        return (double[]) this.components.get(i5).state.clone();
    }

    public double[] getSecondaryStateDot(int i5) {
        return (double[]) this.components.get(i5).stateDot.clone();
    }

    public double getTime() {
        return this.time;
    }

    public int getTotalDimension() {
        if (this.components.isEmpty()) {
            return this.primaryMapper.getDimension();
        }
        EquationsMapper equationsMapper = ((SecondaryComponent) AbstractC0157z.f(1, this.components)).mapper;
        return equationsMapper.getDimension() + equationsMapper.getFirstIndex();
    }

    public void setCompleteState(double[] dArr) {
        if (dArr.length != getTotalDimension()) {
            throw new DimensionMismatchException(dArr.length, getTotalDimension());
        }
        this.primaryMapper.extractEquationData(dArr, this.primaryState);
        for (SecondaryComponent secondaryComponent : this.components) {
            secondaryComponent.mapper.extractEquationData(dArr, secondaryComponent.state);
        }
    }

    public void setPrimaryState(double[] dArr) {
        int length = dArr.length;
        double[] dArr2 = this.primaryState;
        if (length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, this.primaryState.length);
        }
        System.arraycopy(dArr, 0, dArr2, 0, dArr.length);
    }

    public void setSecondaryState(int i5, double[] dArr) {
        double[] dArr2 = this.components.get(i5).state;
        if (dArr.length != dArr2.length) {
            throw new DimensionMismatchException(dArr.length, dArr2.length);
        }
        System.arraycopy(dArr, 0, dArr2, 0, dArr.length);
    }

    public void setTime(double d) {
        this.time = d;
    }
}
