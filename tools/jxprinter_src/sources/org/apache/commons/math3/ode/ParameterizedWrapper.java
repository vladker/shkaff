package org.apache.commons.math3.ode;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class ParameterizedWrapper implements ParameterizedODE {
    private final FirstOrderDifferentialEquations fode;

    public ParameterizedWrapper(FirstOrderDifferentialEquations firstOrderDifferentialEquations) {
        this.fode = firstOrderDifferentialEquations;
    }

    public void computeDerivatives(double d, double[] dArr, double[] dArr2) {
        this.fode.computeDerivatives(d, dArr, dArr2);
    }

    public int getDimension() {
        return this.fode.getDimension();
    }

    @Override // org.apache.commons.math3.ode.ParameterizedODE
    public double getParameter(String str) {
        if (isSupported(str)) {
            return Double.NaN;
        }
        throw new UnknownParameterException(str);
    }

    @Override // org.apache.commons.math3.ode.Parameterizable
    public Collection<String> getParametersNames() {
        return new ArrayList();
    }

    @Override // org.apache.commons.math3.ode.Parameterizable
    public boolean isSupported(String str) {
        return false;
    }

    @Override // org.apache.commons.math3.ode.ParameterizedODE
    public void setParameter(String str, double d) {
    }
}
