package org.apache.commons.math3.linear;

import androidx.collection.a;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.IterationManager;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SymmLQ extends PreconditionedIterativeLinearSolver {
    private static final String OPERATOR = "operator";
    private static final String THRESHOLD = "threshold";
    private static final String VECTOR = "vector";
    private static final String VECTOR1 = "vector1";
    private static final String VECTOR2 = "vector2";
    private final boolean check;
    private final double delta;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class State {
        static final double CBRT_MACH_PREC;
        static final double MACH_PREC;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RealLinearOperator f6816a;
        private final RealVector b;
        private boolean bIsNull;
        private double beta;
        private double beta1;
        private double bstep;
        private double cgnorm;
        private final boolean check;
        private double dbar;
        private final double delta;
        private double gammaZeta;
        private double gbar;
        private double gmax;
        private double gmin;
        private final boolean goodb;
        private boolean hasConverged;
        private double lqnorm;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final RealLinearOperator f6817m;
        private final RealVector mb;
        private double minusEpsZeta;
        private double oldb;

        /* JADX INFO: renamed from: r1, reason: collision with root package name */
        private RealVector f6818r1;

        /* JADX INFO: renamed from: r2, reason: collision with root package name */
        private RealVector f6819r2;
        private double rnorm;
        private final double shift;
        private double snprod;
        private double tnorm;
        private RealVector wbar;
        private final RealVector xL;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private RealVector f6820y;
        private double ynorm2;

        static {
            double dUlp = FastMath.ulp(1.0d);
            MACH_PREC = dUlp;
            CBRT_MACH_PREC = FastMath.cbrt(dUlp);
        }

        public State(RealLinearOperator realLinearOperator, RealLinearOperator realLinearOperator2, RealVector realVector, boolean z6, double d, double d6, boolean z7) {
            this.f6816a = realLinearOperator;
            this.f6817m = realLinearOperator2;
            this.b = realVector;
            this.xL = new ArrayRealVector(realVector.getDimension());
            this.goodb = z6;
            this.shift = d;
            this.mb = realLinearOperator2 != null ? realLinearOperator2.operate(realVector) : realVector;
            this.hasConverged = false;
            this.check = z7;
            this.delta = d6;
        }

        private static void checkSymmetry(RealLinearOperator realLinearOperator, RealVector realVector, RealVector realVector2, RealVector realVector3) {
            double dDotProduct = realVector2.dotProduct(realVector2);
            double dDotProduct2 = realVector.dotProduct(realVector3);
            double d = (MACH_PREC + dDotProduct) * CBRT_MACH_PREC;
            if (FastMath.abs(dDotProduct - dDotProduct2) <= d) {
                return;
            }
            NonSelfAdjointOperatorException nonSelfAdjointOperatorException = new NonSelfAdjointOperatorException();
            ExceptionContext context = nonSelfAdjointOperatorException.getContext();
            context.setValue("operator", realLinearOperator);
            context.setValue(SymmLQ.VECTOR1, realVector);
            context.setValue(SymmLQ.VECTOR2, realVector2);
            context.setValue(SymmLQ.THRESHOLD, Double.valueOf(d));
            throw nonSelfAdjointOperatorException;
        }

        private static void daxpbypz(double d, RealVector realVector, double d6, RealVector realVector2, RealVector realVector3) {
            int dimension = realVector3.getDimension();
            for (int i5 = 0; i5 < dimension; i5++) {
                realVector3.setEntry(i5, realVector3.getEntry(i5) + (realVector2.getEntry(i5) * d6) + (realVector.getEntry(i5) * d));
            }
        }

        private static void daxpy(double d, RealVector realVector, RealVector realVector2) {
            int dimension = realVector.getDimension();
            for (int i5 = 0; i5 < dimension; i5++) {
                realVector2.setEntry(i5, realVector2.getEntry(i5) + (realVector.getEntry(i5) * d));
            }
        }

        private static void throwNPDLOException(RealLinearOperator realLinearOperator, RealVector realVector) {
            NonPositiveDefiniteOperatorException nonPositiveDefiniteOperatorException = new NonPositiveDefiniteOperatorException();
            ExceptionContext context = nonPositiveDefiniteOperatorException.getContext();
            context.setValue("operator", realLinearOperator);
            context.setValue("vector", realVector);
            throw nonPositiveDefiniteOperatorException;
        }

        private void updateNorms() {
            double dSqrt = FastMath.sqrt(this.tnorm);
            double dSqrt2 = FastMath.sqrt(this.ynorm2);
            double d = MACH_PREC;
            double d6 = dSqrt * d;
            double d7 = dSqrt * dSqrt2;
            double d8 = d7 * d;
            double d9 = d7 * this.delta;
            double d10 = this.gbar;
            if (d10 != 0.0d) {
                d6 = d10;
            }
            double d11 = this.gammaZeta;
            double d12 = this.minusEpsZeta;
            this.lqnorm = FastMath.sqrt((d12 * d12) + (d11 * d11));
            double dAbs = ((this.snprod * this.beta1) * this.beta) / FastMath.abs(d6);
            this.cgnorm = dAbs;
            double dMin = this.lqnorm <= dAbs ? this.gmax / this.gmin : this.gmax / FastMath.min(this.gmin, FastMath.abs(d6));
            if (d * dMin >= 0.1d) {
                throw new IllConditionedOperatorException(dMin);
            }
            if (this.beta1 <= d8) {
                throw new SingularOperatorException();
            }
            this.rnorm = FastMath.min(this.cgnorm, this.lqnorm);
            double d13 = this.cgnorm;
            this.hasConverged = d13 <= d8 || d13 <= d9;
        }

        public boolean bEqualsNullVector() {
            return this.bIsNull;
        }

        public boolean betaEqualsZero() {
            return this.beta < MACH_PREC;
        }

        public double getNormOfResidual() {
            return this.rnorm;
        }

        public boolean hasConverged() {
            return this.hasConverged;
        }

        public void init() {
            this.xL.set(0.0d);
            RealVector realVectorCopy = this.b.copy();
            this.f6818r1 = realVectorCopy;
            RealLinearOperator realLinearOperator = this.f6817m;
            RealVector realVectorCopy2 = realLinearOperator == null ? this.b.copy() : realLinearOperator.operate(realVectorCopy);
            this.f6820y = realVectorCopy2;
            RealLinearOperator realLinearOperator2 = this.f6817m;
            if (realLinearOperator2 != null && this.check) {
                checkSymmetry(realLinearOperator2, this.f6818r1, realVectorCopy2, realLinearOperator2.operate(realVectorCopy2));
            }
            double dDotProduct = this.f6818r1.dotProduct(this.f6820y);
            this.beta1 = dDotProduct;
            if (dDotProduct < 0.0d) {
                throwNPDLOException(this.f6817m, this.f6820y);
            }
            double d = this.beta1;
            if (d == 0.0d) {
                this.bIsNull = true;
                return;
            }
            this.bIsNull = false;
            double dSqrt = FastMath.sqrt(d);
            this.beta1 = dSqrt;
            RealVector realVectorMapMultiply = this.f6820y.mapMultiply(1.0d / dSqrt);
            RealVector realVectorOperate = this.f6816a.operate(realVectorMapMultiply);
            this.f6820y = realVectorOperate;
            if (this.check) {
                RealLinearOperator realLinearOperator3 = this.f6816a;
                checkSymmetry(realLinearOperator3, realVectorMapMultiply, realVectorOperate, realLinearOperator3.operate(realVectorOperate));
            }
            daxpy(-this.shift, realVectorMapMultiply, this.f6820y);
            double dDotProduct2 = realVectorMapMultiply.dotProduct(this.f6820y);
            daxpy((-dDotProduct2) / this.beta1, this.f6818r1, this.f6820y);
            daxpy((-realVectorMapMultiply.dotProduct(this.f6820y)) / realVectorMapMultiply.dotProduct(realVectorMapMultiply), realVectorMapMultiply, this.f6820y);
            RealVector realVectorCopy3 = this.f6820y.copy();
            this.f6819r2 = realVectorCopy3;
            RealLinearOperator realLinearOperator4 = this.f6817m;
            if (realLinearOperator4 != null) {
                this.f6820y = realLinearOperator4.operate(realVectorCopy3);
            }
            this.oldb = this.beta1;
            double dDotProduct3 = this.f6819r2.dotProduct(this.f6820y);
            this.beta = dDotProduct3;
            if (dDotProduct3 < 0.0d) {
                throwNPDLOException(this.f6817m, this.f6820y);
            }
            double dSqrt2 = FastMath.sqrt(this.beta);
            this.beta = dSqrt2;
            double d6 = this.beta1;
            this.cgnorm = d6;
            this.gbar = dDotProduct2;
            this.dbar = dSqrt2;
            this.gammaZeta = d6;
            this.minusEpsZeta = 0.0d;
            this.bstep = 0.0d;
            this.snprod = 1.0d;
            this.tnorm = (dSqrt2 * dSqrt2) + (dDotProduct2 * dDotProduct2);
            this.ynorm2 = 0.0d;
            double dAbs = FastMath.abs(dDotProduct2) + MACH_PREC;
            this.gmax = dAbs;
            this.gmin = dAbs;
            if (this.goodb) {
                ArrayRealVector arrayRealVector = new ArrayRealVector(this.f6816a.getRowDimension());
                this.wbar = arrayRealVector;
                arrayRealVector.set(0.0d);
            } else {
                this.wbar = realVectorMapMultiply;
            }
            updateNorms();
        }

        public void refineSolution(RealVector realVector) {
            int dimension = this.xL.getDimension();
            int i5 = 0;
            if (this.lqnorm < this.cgnorm) {
                if (!this.goodb) {
                    realVector.setSubVector(0, this.xL);
                    return;
                }
                double d = this.bstep / this.beta1;
                while (i5 < dimension) {
                    realVector.setEntry(i5, (this.mb.getEntry(i5) * d) + this.xL.getEntry(i5));
                    i5++;
                }
                return;
            }
            double dSqrt = FastMath.sqrt(this.tnorm);
            double d6 = this.gbar;
            if (d6 == 0.0d) {
                d6 = MACH_PREC * dSqrt;
            }
            double d7 = this.gammaZeta / d6;
            double d8 = ((this.snprod * d7) + this.bstep) / this.beta1;
            if (!this.goodb) {
                while (i5 < dimension) {
                    realVector.setEntry(i5, (this.wbar.getEntry(i5) * d7) + this.xL.getEntry(i5));
                    i5++;
                }
                return;
            }
            while (i5 < dimension) {
                double entry = this.xL.getEntry(i5);
                double entry2 = this.wbar.getEntry(i5);
                realVector.setEntry(i5, (this.mb.getEntry(i5) * d8) + (entry2 * d7) + entry);
                i5++;
            }
        }

        public void update() {
            RealVector realVectorMapMultiply = this.f6820y.mapMultiply(1.0d / this.beta);
            RealVector realVectorOperate = this.f6816a.operate(realVectorMapMultiply);
            this.f6820y = realVectorOperate;
            daxpbypz(-this.shift, realVectorMapMultiply, (-this.beta) / this.oldb, this.f6818r1, realVectorOperate);
            double dDotProduct = realVectorMapMultiply.dotProduct(this.f6820y);
            daxpy((-dDotProduct) / this.beta, this.f6819r2, this.f6820y);
            this.f6818r1 = this.f6819r2;
            RealVector realVector = this.f6820y;
            this.f6819r2 = realVector;
            RealLinearOperator realLinearOperator = this.f6817m;
            if (realLinearOperator != null) {
                this.f6820y = realLinearOperator.operate(realVector);
            }
            this.oldb = this.beta;
            double dDotProduct2 = this.f6819r2.dotProduct(this.f6820y);
            this.beta = dDotProduct2;
            if (dDotProduct2 < 0.0d) {
                throwNPDLOException(this.f6817m, this.f6820y);
            }
            double dSqrt = FastMath.sqrt(this.beta);
            this.beta = dSqrt;
            double d = this.tnorm;
            double d6 = this.oldb;
            this.tnorm = a.A(dSqrt, dSqrt, (d6 * d6) + (dDotProduct * dDotProduct), d);
            double d7 = this.gbar;
            double dSqrt2 = FastMath.sqrt((d6 * d6) + (d7 * d7));
            double d8 = this.gbar / dSqrt2;
            double d9 = this.oldb / dSqrt2;
            double d10 = this.dbar;
            double d11 = (d9 * dDotProduct) + (d8 * d10);
            this.gbar = (d10 * d9) - (dDotProduct * d8);
            double d12 = this.beta;
            double d13 = d9 * d12;
            this.dbar = (-d8) * d12;
            double d14 = this.gammaZeta / dSqrt2;
            double d15 = d14 * d8;
            double d16 = d14 * d9;
            int i5 = 0;
            for (int dimension = this.xL.getDimension(); i5 < dimension; dimension = dimension) {
                double entry = this.xL.getEntry(i5);
                double entry2 = realVectorMapMultiply.getEntry(i5);
                double entry3 = this.wbar.getEntry(i5);
                this.xL.setEntry(i5, (entry2 * d16) + (entry3 * d15) + entry);
                this.wbar.setEntry(i5, (entry3 * d9) - (entry2 * d8));
                i5++;
                realVectorMapMultiply = realVectorMapMultiply;
            }
            double d17 = this.bstep;
            double d18 = this.snprod;
            this.bstep = a.C(d18, d8, d14, d17);
            this.snprod = d18 * d9;
            this.gmax = FastMath.max(this.gmax, dSqrt2);
            this.gmin = FastMath.min(this.gmin, dSqrt2);
            this.ynorm2 = (d14 * d14) + this.ynorm2;
            this.gammaZeta = this.minusEpsZeta - (d11 * d14);
            this.minusEpsZeta = (-d13) * d14;
            updateNorms();
        }
    }

    public SymmLQ(int i5, double d, boolean z6) {
        super(i5);
        this.delta = d;
        this.check = z6;
    }

    public final boolean getCheck() {
        return this.check;
    }

    @Override // org.apache.commons.math3.linear.PreconditionedIterativeLinearSolver
    public RealVector solve(RealLinearOperator realLinearOperator, RealLinearOperator realLinearOperator2, RealVector realVector) {
        MathUtils.checkNotNull(realLinearOperator);
        return solveInPlace(realLinearOperator, realLinearOperator2, realVector, new ArrayRealVector(realLinearOperator.getColumnDimension()), false, 0.0d);
    }

    @Override // org.apache.commons.math3.linear.PreconditionedIterativeLinearSolver
    public RealVector solveInPlace(RealLinearOperator realLinearOperator, RealLinearOperator realLinearOperator2, RealVector realVector, RealVector realVector2) {
        return solveInPlace(realLinearOperator, realLinearOperator2, realVector, realVector2, false, 0.0d);
    }

    public RealVector solveInPlace(RealLinearOperator realLinearOperator, RealLinearOperator realLinearOperator2, RealVector realVector, RealVector realVector2, boolean z6, double d) {
        PreconditionedIterativeLinearSolver.checkParameters(realLinearOperator, realLinearOperator2, realVector, realVector2);
        IterationManager iterationManager = getIterationManager();
        iterationManager.resetIterationCount();
        iterationManager.incrementIterationCount();
        State state = new State(realLinearOperator, realLinearOperator2, realVector, z6, d, this.delta, this.check);
        state.init();
        state.refineSolution(realVector2);
        DefaultIterativeLinearSolverEvent defaultIterativeLinearSolverEvent = new DefaultIterativeLinearSolverEvent(this, iterationManager.getIterations(), realVector2, realVector, state.getNormOfResidual());
        if (state.bEqualsNullVector()) {
            iterationManager.fireTerminationEvent(defaultIterativeLinearSolverEvent);
            return realVector2;
        }
        boolean z7 = state.betaEqualsZero() || state.hasConverged();
        iterationManager.fireInitializationEvent(defaultIterativeLinearSolverEvent);
        if (!z7) {
            do {
                iterationManager.incrementIterationCount();
                iterationManager.fireIterationStartedEvent(new DefaultIterativeLinearSolverEvent(this, iterationManager.getIterations(), realVector2, realVector, state.getNormOfResidual()));
                state.update();
                state.refineSolution(realVector2);
                iterationManager.fireIterationPerformedEvent(new DefaultIterativeLinearSolverEvent(this, iterationManager.getIterations(), realVector2, realVector, state.getNormOfResidual()));
            } while (!state.hasConverged());
        }
        iterationManager.fireTerminationEvent(new DefaultIterativeLinearSolverEvent(this, iterationManager.getIterations(), realVector2, realVector, state.getNormOfResidual()));
        return realVector2;
    }

    public SymmLQ(IterationManager iterationManager, double d, boolean z6) {
        super(iterationManager);
        this.delta = d;
        this.check = z6;
    }

    public RealVector solve(RealLinearOperator realLinearOperator, RealLinearOperator realLinearOperator2, RealVector realVector, boolean z6, double d) {
        MathUtils.checkNotNull(realLinearOperator);
        return solveInPlace(realLinearOperator, realLinearOperator2, realVector, new ArrayRealVector(realLinearOperator.getColumnDimension()), z6, d);
    }

    @Override // org.apache.commons.math3.linear.PreconditionedIterativeLinearSolver
    public RealVector solve(RealLinearOperator realLinearOperator, RealLinearOperator realLinearOperator2, RealVector realVector, RealVector realVector2) {
        MathUtils.checkNotNull(realVector2);
        return solveInPlace(realLinearOperator, realLinearOperator2, realVector, realVector2.copy(), false, 0.0d);
    }

    @Override // org.apache.commons.math3.linear.PreconditionedIterativeLinearSolver, org.apache.commons.math3.linear.IterativeLinearSolver
    public RealVector solve(RealLinearOperator realLinearOperator, RealVector realVector) {
        MathUtils.checkNotNull(realLinearOperator);
        ArrayRealVector arrayRealVector = new ArrayRealVector(realLinearOperator.getColumnDimension());
        arrayRealVector.set(0.0d);
        return solveInPlace(realLinearOperator, null, realVector, arrayRealVector, false, 0.0d);
    }

    public RealVector solve(RealLinearOperator realLinearOperator, RealVector realVector, boolean z6, double d) {
        MathUtils.checkNotNull(realLinearOperator);
        return solveInPlace(realLinearOperator, null, realVector, new ArrayRealVector(realLinearOperator.getColumnDimension()), z6, d);
    }

    @Override // org.apache.commons.math3.linear.PreconditionedIterativeLinearSolver, org.apache.commons.math3.linear.IterativeLinearSolver
    public RealVector solve(RealLinearOperator realLinearOperator, RealVector realVector, RealVector realVector2) {
        MathUtils.checkNotNull(realVector2);
        return solveInPlace(realLinearOperator, null, realVector, realVector2.copy(), false, 0.0d);
    }

    @Override // org.apache.commons.math3.linear.PreconditionedIterativeLinearSolver, org.apache.commons.math3.linear.IterativeLinearSolver
    public RealVector solveInPlace(RealLinearOperator realLinearOperator, RealVector realVector, RealVector realVector2) {
        return solveInPlace(realLinearOperator, null, realVector, realVector2, false, 0.0d);
    }
}
