package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.MathUnsupportedOperationException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultIterativeLinearSolverEvent extends IterativeLinearSolverEvent {
    private static final long serialVersionUID = 20120129;
    private final RealVector b;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final RealVector f6806r;
    private final double rnorm;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final RealVector f6807x;

    public DefaultIterativeLinearSolverEvent(Object obj, int i5, RealVector realVector, RealVector realVector2, RealVector realVector3, double d) {
        super(obj, i5);
        this.f6807x = realVector;
        this.b = realVector2;
        this.f6806r = realVector3;
        this.rnorm = d;
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolverEvent
    public double getNormOfResidual() {
        return this.rnorm;
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolverEvent
    public RealVector getResidual() {
        RealVector realVector = this.f6806r;
        if (realVector != null) {
            return realVector;
        }
        throw new MathUnsupportedOperationException();
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolverEvent
    public RealVector getRightHandSideVector() {
        return this.b;
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolverEvent
    public RealVector getSolution() {
        return this.f6807x;
    }

    @Override // org.apache.commons.math3.linear.IterativeLinearSolverEvent
    public boolean providesResidual() {
        return this.f6806r != null;
    }

    public DefaultIterativeLinearSolverEvent(Object obj, int i5, RealVector realVector, RealVector realVector2, double d) {
        super(obj, i5);
        this.f6807x = realVector;
        this.b = realVector2;
        this.f6806r = null;
        this.rnorm = d;
    }
}
