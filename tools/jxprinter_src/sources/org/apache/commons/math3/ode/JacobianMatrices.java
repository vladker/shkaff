package org.apache.commons.math3.ode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class JacobianMatrices {
    private boolean dirtyParameter;
    private ExpandableStatefulODE efode;
    private int index;
    private List<ParameterJacobianProvider> jacobianProviders;
    private MainStateJacobianProvider jode;
    private double[] matricesData;
    private int paramDim;
    private ParameterizedODE pode;
    private ParameterConfiguration[] selectedParameters;
    private int stateDim;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class JacobiansSecondaryEquations implements SecondaryEquations {
        private JacobiansSecondaryEquations() {
        }

        @Override // org.apache.commons.math3.ode.SecondaryEquations
        public void computeDerivatives(double d, double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4) {
            double[] dArr5;
            int i5;
            int i6 = 0;
            if (JacobianMatrices.this.dirtyParameter && JacobianMatrices.this.paramDim != 0) {
                JacobianMatrices.this.jacobianProviders.add(new ParameterJacobianWrapper(JacobianMatrices.this.jode, JacobianMatrices.this.pode, JacobianMatrices.this.selectedParameters));
                JacobianMatrices.this.dirtyParameter = false;
            }
            int i7 = 1;
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, JacobianMatrices.this.stateDim, JacobianMatrices.this.stateDim);
            JacobianMatrices.this.jode.computeMainStateJacobian(d, dArr, dArr2, dArr6);
            for (int i8 = 0; i8 < JacobianMatrices.this.stateDim; i8++) {
                double[] dArr7 = dArr6[i8];
                for (int i9 = 0; i9 < JacobianMatrices.this.stateDim; i9++) {
                    int i10 = i9;
                    double d6 = 0.0d;
                    for (int i11 = 0; i11 < JacobianMatrices.this.stateDim; i11++) {
                        d6 += dArr7[i11] * dArr3[i10];
                        i10 += JacobianMatrices.this.stateDim;
                    }
                    dArr4[(JacobianMatrices.this.stateDim * i8) + i9] = d6;
                }
            }
            if (JacobianMatrices.this.paramDim != 0) {
                double[] dArr8 = new double[JacobianMatrices.this.stateDim];
                int i12 = JacobianMatrices.this.stateDim * JacobianMatrices.this.stateDim;
                ParameterConfiguration[] parameterConfigurationArr = JacobianMatrices.this.selectedParameters;
                int length = parameterConfigurationArr.length;
                int i13 = 0;
                while (i13 < length) {
                    ParameterConfiguration parameterConfiguration = parameterConfigurationArr[i13];
                    int i14 = i6;
                    int i15 = i14;
                    while (i14 == 0 && i15 < JacobianMatrices.this.jacobianProviders.size()) {
                        ParameterJacobianProvider parameterJacobianProvider = (ParameterJacobianProvider) JacobianMatrices.this.jacobianProviders.get(i15);
                        if (parameterJacobianProvider.isSupported(parameterConfiguration.getParameterName())) {
                            dArr5 = dArr8;
                            parameterJacobianProvider.computeParameterJacobian(d, dArr, dArr2, parameterConfiguration.getParameterName(), dArr5);
                            int i16 = 0;
                            while (i16 < JacobianMatrices.this.stateDim) {
                                double[] dArr9 = dArr6[i16];
                                double d7 = dArr5[i16];
                                int i17 = i12;
                                int i18 = i7;
                                for (int i19 = 0; i19 < JacobianMatrices.this.stateDim; i19++) {
                                    d7 += dArr9[i19] * dArr3[i17];
                                    i17++;
                                }
                                dArr4[i12 + i16] = d7;
                                i16++;
                                i7 = i18;
                            }
                            i5 = i7;
                            i14 = i5;
                        } else {
                            dArr5 = dArr8;
                            i5 = i7;
                        }
                        i15++;
                        i7 = i5;
                        dArr8 = dArr5;
                    }
                    double[] dArr10 = dArr8;
                    int i20 = i7;
                    if (i14 == 0) {
                        Arrays.fill(dArr4, i12, JacobianMatrices.this.stateDim + i12, 0.0d);
                    }
                    i12 += JacobianMatrices.this.stateDim;
                    i13++;
                    i7 = i20;
                    dArr8 = dArr10;
                    i6 = 0;
                }
            }
        }

        @Override // org.apache.commons.math3.ode.SecondaryEquations
        public int getDimension() {
            return (JacobianMatrices.this.paramDim + JacobianMatrices.this.stateDim) * JacobianMatrices.this.stateDim;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class MainStateJacobianWrapper implements MainStateJacobianProvider {
        private final double[] hY;
        private final FirstOrderDifferentialEquations ode;

        public MainStateJacobianWrapper(FirstOrderDifferentialEquations firstOrderDifferentialEquations, double[] dArr) {
            this.ode = firstOrderDifferentialEquations;
            this.hY = (double[]) dArr.clone();
            if (dArr.length != firstOrderDifferentialEquations.getDimension()) {
                throw new DimensionMismatchException(firstOrderDifferentialEquations.getDimension(), dArr.length);
            }
        }

        @Override // org.apache.commons.math3.ode.FirstOrderDifferentialEquations
        public void computeDerivatives(double d, double[] dArr, double[] dArr2) {
            this.ode.computeDerivatives(d, dArr, dArr2);
        }

        @Override // org.apache.commons.math3.ode.MainStateJacobianProvider
        public void computeMainStateJacobian(double d, double[] dArr, double[] dArr2, double[][] dArr3) {
            int dimension = this.ode.getDimension();
            double[] dArr4 = new double[dimension];
            for (int i5 = 0; i5 < dimension; i5++) {
                double d6 = dArr[i5];
                dArr[i5] = this.hY[i5] + d6;
                this.ode.computeDerivatives(d, dArr, dArr4);
                for (int i6 = 0; i6 < dimension; i6++) {
                    dArr3[i6][i5] = (dArr4[i6] - dArr2[i6]) / this.hY[i5];
                }
                dArr[i5] = d6;
            }
        }

        @Override // org.apache.commons.math3.ode.FirstOrderDifferentialEquations
        public int getDimension() {
            return this.ode.getDimension();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class MismatchedEquations extends MathIllegalArgumentException {
        private static final long serialVersionUID = 20120902;

        public MismatchedEquations() {
            super(LocalizedFormats.UNMATCHED_ODE_IN_EXPANDED_SET, new Object[0]);
        }
    }

    public JacobianMatrices(FirstOrderDifferentialEquations firstOrderDifferentialEquations, double[] dArr, String... strArr) {
        this(new MainStateJacobianWrapper(firstOrderDifferentialEquations, dArr), strArr);
    }

    private void checkDimension(int i5, Object obj) {
        int length = obj == null ? 0 : Array.getLength(obj);
        if (length != i5) {
            throw new DimensionMismatchException(length, i5);
        }
    }

    public void addParameterJacobianProvider(ParameterJacobianProvider parameterJacobianProvider) {
        this.jacobianProviders.add(parameterJacobianProvider);
    }

    public void getCurrentMainSetJacobian(double[][] dArr) {
        double[] secondaryState = this.efode.getSecondaryState(this.index);
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = this.stateDim;
            if (i5 >= i7) {
                return;
            }
            System.arraycopy(secondaryState, i6, dArr[i5], 0, i7);
            i6 += this.stateDim;
            i5++;
        }
    }

    public void getCurrentParameterJacobian(String str, double[] dArr) {
        double[] secondaryState = this.efode.getSecondaryState(this.index);
        int i5 = this.stateDim;
        int i6 = i5 * i5;
        for (ParameterConfiguration parameterConfiguration : this.selectedParameters) {
            if (parameterConfiguration.getParameterName().equals(str)) {
                System.arraycopy(secondaryState, i6, dArr, 0, this.stateDim);
                return;
            }
            i6 += this.stateDim;
        }
    }

    public void registerVariationalEquations(ExpandableStatefulODE expandableStatefulODE) {
        FirstOrderDifferentialEquations firstOrderDifferentialEquations = this.jode;
        if (firstOrderDifferentialEquations instanceof MainStateJacobianWrapper) {
            firstOrderDifferentialEquations = ((MainStateJacobianWrapper) firstOrderDifferentialEquations).ode;
        }
        if (expandableStatefulODE.getPrimary() != firstOrderDifferentialEquations) {
            throw new MismatchedEquations();
        }
        this.efode = expandableStatefulODE;
        int iAddSecondaryEquations = expandableStatefulODE.addSecondaryEquations(new JacobiansSecondaryEquations());
        this.index = iAddSecondaryEquations;
        this.efode.setSecondaryState(iAddSecondaryEquations, this.matricesData);
    }

    public void setInitialMainStateJacobian(double[][] dArr) {
        checkDimension(this.stateDim, dArr);
        checkDimension(this.stateDim, dArr[0]);
        int i5 = 0;
        for (double[] dArr2 : dArr) {
            System.arraycopy(dArr2, 0, this.matricesData, i5, this.stateDim);
            i5 += this.stateDim;
        }
        ExpandableStatefulODE expandableStatefulODE = this.efode;
        if (expandableStatefulODE != null) {
            expandableStatefulODE.setSecondaryState(this.index, this.matricesData);
        }
    }

    public void setInitialParameterJacobian(String str, double[] dArr) {
        checkDimension(this.stateDim, dArr);
        int i5 = this.stateDim;
        int i6 = i5 * i5;
        for (ParameterConfiguration parameterConfiguration : this.selectedParameters) {
            if (str.equals(parameterConfiguration.getParameterName())) {
                System.arraycopy(dArr, 0, this.matricesData, i6, this.stateDim);
                ExpandableStatefulODE expandableStatefulODE = this.efode;
                if (expandableStatefulODE != null) {
                    expandableStatefulODE.setSecondaryState(this.index, this.matricesData);
                    return;
                }
                return;
            }
            i6 += this.stateDim;
        }
        throw new UnknownParameterException(str);
    }

    public void setParameterStep(String str, double d) {
        for (ParameterConfiguration parameterConfiguration : this.selectedParameters) {
            if (str.equals(parameterConfiguration.getParameterName())) {
                parameterConfiguration.setHP(d);
                this.dirtyParameter = true;
                return;
            }
        }
        throw new UnknownParameterException(str);
    }

    public void setParameterizedODE(ParameterizedODE parameterizedODE) {
        this.pode = parameterizedODE;
        this.dirtyParameter = true;
    }

    public JacobianMatrices(MainStateJacobianProvider mainStateJacobianProvider, String... strArr) {
        this.efode = null;
        this.index = -1;
        this.jode = mainStateJacobianProvider;
        this.pode = null;
        this.stateDim = mainStateJacobianProvider.getDimension();
        int i5 = 0;
        if (strArr == null) {
            this.selectedParameters = null;
            this.paramDim = 0;
        } else {
            this.selectedParameters = new ParameterConfiguration[strArr.length];
            for (int i6 = 0; i6 < strArr.length; i6++) {
                this.selectedParameters[i6] = new ParameterConfiguration(strArr[i6], Double.NaN);
            }
            this.paramDim = strArr.length;
        }
        this.dirtyParameter = false;
        this.jacobianProviders = new ArrayList();
        int i7 = this.stateDim;
        this.matricesData = new double[(this.paramDim + i7) * i7];
        while (true) {
            int i8 = this.stateDim;
            if (i5 >= i8) {
                return;
            }
            this.matricesData[(i8 + 1) * i5] = 1.0d;
            i5++;
        }
    }
}
