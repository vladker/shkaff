package org.apache.commons.math3.ode;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class ParameterJacobianWrapper implements ParameterJacobianProvider {
    private final FirstOrderDifferentialEquations fode;
    private final Map<String, Double> hParam = new HashMap();
    private final ParameterizedODE pode;

    public ParameterJacobianWrapper(FirstOrderDifferentialEquations firstOrderDifferentialEquations, ParameterizedODE parameterizedODE, ParameterConfiguration[] parameterConfigurationArr) {
        this.fode = firstOrderDifferentialEquations;
        this.pode = parameterizedODE;
        for (ParameterConfiguration parameterConfiguration : parameterConfigurationArr) {
            String parameterName = parameterConfiguration.getParameterName();
            if (parameterizedODE.isSupported(parameterName)) {
                this.hParam.put(parameterName, Double.valueOf(parameterConfiguration.getHP()));
            }
        }
    }

    @Override // org.apache.commons.math3.ode.ParameterJacobianProvider
    public void computeParameterJacobian(double d, double[] dArr, double[] dArr2, String str, double[] dArr3) {
        int dimension = this.fode.getDimension();
        if (!this.pode.isSupported(str)) {
            Arrays.fill(dArr3, 0, dimension, 0.0d);
            return;
        }
        double[] dArr4 = new double[dimension];
        double parameter = this.pode.getParameter(str);
        double dDoubleValue = this.hParam.get(str).doubleValue();
        this.pode.setParameter(str, parameter + dDoubleValue);
        this.fode.computeDerivatives(d, dArr, dArr4);
        for (int i5 = 0; i5 < dimension; i5++) {
            dArr3[i5] = (dArr4[i5] - dArr2[i5]) / dDoubleValue;
        }
        this.pode.setParameter(str, parameter);
    }

    @Override // org.apache.commons.math3.ode.Parameterizable
    public Collection<String> getParametersNames() {
        return this.pode.getParametersNames();
    }

    @Override // org.apache.commons.math3.ode.Parameterizable
    public boolean isSupported(String str) {
        return this.pode.isSupported(str);
    }
}
