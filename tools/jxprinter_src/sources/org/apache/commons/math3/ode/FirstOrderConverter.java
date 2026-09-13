package org.apache.commons.math3.ode;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FirstOrderConverter implements FirstOrderDifferentialEquations {
    private final int dimension;
    private final SecondOrderDifferentialEquations equations;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final double[] f6824z;
    private final double[] zDDot;
    private final double[] zDot;

    public FirstOrderConverter(SecondOrderDifferentialEquations secondOrderDifferentialEquations) {
        this.equations = secondOrderDifferentialEquations;
        int dimension = secondOrderDifferentialEquations.getDimension();
        this.dimension = dimension;
        this.f6824z = new double[dimension];
        this.zDot = new double[dimension];
        this.zDDot = new double[dimension];
    }

    @Override // org.apache.commons.math3.ode.FirstOrderDifferentialEquations
    public void computeDerivatives(double d, double[] dArr, double[] dArr2) {
        System.arraycopy(dArr, 0, this.f6824z, 0, this.dimension);
        int i5 = this.dimension;
        System.arraycopy(dArr, i5, this.zDot, 0, i5);
        this.equations.computeSecondDerivatives(d, this.f6824z, this.zDot, this.zDDot);
        System.arraycopy(this.zDot, 0, dArr2, 0, this.dimension);
        double[] dArr3 = this.zDDot;
        int i6 = this.dimension;
        System.arraycopy(dArr3, 0, dArr2, i6, i6);
    }

    @Override // org.apache.commons.math3.ode.FirstOrderDifferentialEquations
    public int getDimension() {
        return this.dimension * 2;
    }
}
