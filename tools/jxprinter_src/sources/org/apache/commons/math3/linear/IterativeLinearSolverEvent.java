package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.util.IterationEvent;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class IterativeLinearSolverEvent extends IterationEvent {
    private static final long serialVersionUID = 20120129;

    public IterativeLinearSolverEvent(Object obj, int i5) {
        super(obj, i5);
    }

    public abstract double getNormOfResidual();

    public RealVector getResidual() {
        throw new MathUnsupportedOperationException();
    }

    public abstract RealVector getRightHandSideVector();

    public abstract RealVector getSolution();

    public boolean providesResidual() {
        return false;
    }
}
