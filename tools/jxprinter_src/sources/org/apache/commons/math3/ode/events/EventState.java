package org.apache.commons.math3.ode.events;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.solvers.AllowedSolution;
import org.apache.commons.math3.analysis.solvers.BracketedUnivariateSolver;
import org.apache.commons.math3.analysis.solvers.PegasusSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolver;
import org.apache.commons.math3.analysis.solvers.UnivariateSolverUtils;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EventState {
    private final double convergence;
    private boolean forward;
    private final EventHandler handler;
    private final double maxCheckInterval;
    private final int maxIterationCount;
    private final UnivariateSolver solver;
    private ExpandableStatefulODE expandable = null;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private double f6830t0 = Double.NaN;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private double f6829g0 = Double.NaN;
    private boolean g0Positive = true;
    private boolean pendingEvent = false;
    private double pendingEventTime = Double.NaN;
    private double previousEventTime = Double.NaN;
    private boolean increasing = true;
    private EventHandler.Action nextAction = EventHandler.Action.CONTINUE;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LocalMaxCountExceededException extends RuntimeException {
        private static final long serialVersionUID = 20120901;
        private final MaxCountExceededException wrapped;

        public LocalMaxCountExceededException(MaxCountExceededException maxCountExceededException) {
            this.wrapped = maxCountExceededException;
        }

        public MaxCountExceededException getException() {
            return this.wrapped;
        }
    }

    public EventState(EventHandler eventHandler, double d, double d6, int i5, UnivariateSolver univariateSolver) {
        this.handler = eventHandler;
        this.maxCheckInterval = d;
        this.convergence = FastMath.abs(d6);
        this.maxIterationCount = i5;
        this.solver = univariateSolver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double[] getCompleteState(StepInterpolator stepInterpolator) {
        double[] dArr = new double[this.expandable.getTotalDimension()];
        this.expandable.getPrimaryMapper().insertEquationData(stepInterpolator.getInterpolatedState(), dArr);
        EquationsMapper[] secondaryMappers = this.expandable.getSecondaryMappers();
        int length = secondaryMappers.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            secondaryMappers[i5].insertEquationData(stepInterpolator.getInterpolatedSecondaryState(i6), dArr);
            i5++;
            i6++;
        }
        return dArr;
    }

    public boolean evaluateStep(StepInterpolator stepInterpolator) {
        boolean z6;
        double dSolve;
        int i5;
        double dForceSide;
        double d;
        double dSolve2;
        double d6;
        int i6;
        final StepInterpolator stepInterpolator2 = stepInterpolator;
        try {
            this.forward = stepInterpolator2.isForward();
            double currentTime = stepInterpolator2.getCurrentTime();
            double d7 = currentTime - this.f6830t0;
            boolean z7 = false;
            if (FastMath.abs(d7) < this.convergence) {
                return false;
            }
            int iMax = FastMath.max(1, (int) FastMath.ceil(FastMath.abs(d7) / this.maxCheckInterval));
            double d8 = d7 / ((double) iMax);
            UnivariateFunction univariateFunction = new UnivariateFunction() { // from class: org.apache.commons.math3.ode.events.EventState.1
                @Override // org.apache.commons.math3.analysis.UnivariateFunction
                public double value(double d9) {
                    try {
                        stepInterpolator2.setInterpolatedTime(d9);
                        return EventState.this.handler.g(d9, EventState.this.getCompleteState(stepInterpolator2));
                    } catch (MaxCountExceededException e) {
                        throw new LocalMaxCountExceededException(e);
                    }
                }
            };
            double d9 = this.f6830t0;
            double d10 = this.f6829g0;
            double d11 = d9;
            int i7 = 0;
            while (i7 < iMax) {
                if (i7 != iMax - 1) {
                    currentTime = (((double) (i7 + 1)) * d8) + this.f6830t0;
                }
                stepInterpolator2.setInterpolatedTime(currentTime);
                double dG = this.handler.g(currentTime, getCompleteState(stepInterpolator));
                if (this.g0Positive ^ (dG >= 0.0d)) {
                    this.increasing = dG >= d10;
                    int i8 = i7;
                    UnivariateSolver univariateSolver = this.solver;
                    if (univariateSolver instanceof BracketedUnivariateSolver) {
                        BracketedUnivariateSolver bracketedUnivariateSolver = (BracketedUnivariateSolver) univariateSolver;
                        if (this.forward) {
                            double d12 = currentTime;
                            i6 = i8;
                            double d13 = d11;
                            dSolve2 = bracketedUnivariateSolver.solve(this.maxIterationCount, univariateFunction, d13, d12, AllowedSolution.RIGHT_SIDE);
                            d11 = d13;
                            d = d12;
                        } else {
                            d = currentTime;
                            i6 = i8;
                            dSolve2 = bracketedUnivariateSolver.solve(this.maxIterationCount, univariateFunction, d, d11, AllowedSolution.LEFT_SIDE);
                        }
                        i5 = i6;
                    } else {
                        double d14 = currentTime;
                        if (this.forward) {
                            double d15 = d11;
                            dSolve = univariateSolver.solve(this.maxIterationCount, univariateFunction, d15, d14);
                            d11 = d15;
                            d14 = d14;
                        } else {
                            dSolve = univariateSolver.solve(this.maxIterationCount, univariateFunction, d14, d11);
                        }
                        int evaluations = this.maxIterationCount - this.solver.getEvaluations();
                        double d16 = d14;
                        double d17 = dSolve;
                        UnivariateFunction univariateFunction2 = univariateFunction;
                        i5 = i8;
                        PegasusSolver pegasusSolver = new PegasusSolver(this.solver.getRelativeAccuracy(), this.solver.getAbsoluteAccuracy());
                        if (this.forward) {
                            dForceSide = UnivariateSolverUtils.forceSide(evaluations, univariateFunction2, pegasusSolver, d17, d11, d16, AllowedSolution.RIGHT_SIDE);
                            univariateFunction = univariateFunction2;
                            d = d16;
                        } else {
                            double d18 = d11;
                            dForceSide = UnivariateSolverUtils.forceSide(evaluations, univariateFunction2, pegasusSolver, d17, d16, d18, AllowedSolution.LEFT_SIDE);
                            univariateFunction = univariateFunction2;
                            d = d16;
                            d11 = d18;
                        }
                        dSolve2 = dForceSide;
                    }
                    if (Double.isNaN(this.previousEventTime) || FastMath.abs(dSolve2 - d11) > this.convergence || FastMath.abs(dSolve2 - this.previousEventTime) > this.convergence) {
                        if (!Double.isNaN(this.previousEventTime) && FastMath.abs(this.previousEventTime - dSolve2) <= this.convergence) {
                            d6 = d;
                            i7 = i5;
                        }
                        this.pendingEventTime = dSolve2;
                        this.pendingEvent = true;
                        return true;
                    }
                    do {
                        d11 = this.forward ? d11 + this.convergence : d11 - this.convergence;
                        dG = univariateFunction.value(d11);
                        if (!(this.g0Positive ^ (dG >= 0.0d))) {
                            break;
                        }
                    } while (this.forward ^ (d11 >= d));
                    if (!(this.forward ^ (d11 >= d))) {
                        this.pendingEventTime = dSolve2;
                        this.pendingEvent = true;
                        return true;
                    }
                    i7 = i5 - 1;
                    d6 = d11;
                    d11 = d6;
                    d10 = dG;
                    z6 = true;
                } else {
                    d8 = d8;
                    d11 = currentTime;
                    z6 = true;
                    d10 = dG;
                }
                i7++;
                stepInterpolator2 = stepInterpolator;
                currentTime = currentTime;
                d8 = d8;
                z7 = false;
            }
            boolean z8 = z7;
            this.pendingEvent = z8;
            this.pendingEventTime = Double.NaN;
            return z8;
        } catch (LocalMaxCountExceededException e) {
            throw e.getException();
        }
    }

    public double getConvergence() {
        return this.convergence;
    }

    public EventHandler getEventHandler() {
        return this.handler;
    }

    public double getEventTime() {
        if (this.pendingEvent) {
            return this.pendingEventTime;
        }
        return this.forward ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
    }

    public double getMaxCheckInterval() {
        return this.maxCheckInterval;
    }

    public int getMaxIterationCount() {
        return this.maxIterationCount;
    }

    public void reinitializeBegin(StepInterpolator stepInterpolator) {
        double previousTime = stepInterpolator.getPreviousTime();
        this.f6830t0 = previousTime;
        stepInterpolator.setInterpolatedTime(previousTime);
        double dG = this.handler.g(this.f6830t0, getCompleteState(stepInterpolator));
        this.f6829g0 = dG;
        if (dG == 0.0d) {
            double dMax = (FastMath.max(this.solver.getAbsoluteAccuracy(), FastMath.abs(this.solver.getRelativeAccuracy() * this.f6830t0)) * 0.5d) + this.f6830t0;
            stepInterpolator.setInterpolatedTime(dMax);
            this.f6829g0 = this.handler.g(dMax, getCompleteState(stepInterpolator));
        }
        this.g0Positive = this.f6829g0 >= 0.0d;
    }

    public boolean reset(double d, double[] dArr) {
        if (!this.pendingEvent || FastMath.abs(this.pendingEventTime - d) > this.convergence) {
            return false;
        }
        EventHandler.Action action = this.nextAction;
        EventHandler.Action action2 = EventHandler.Action.RESET_STATE;
        if (action == action2) {
            this.handler.resetState(d, dArr);
        }
        this.pendingEvent = false;
        this.pendingEventTime = Double.NaN;
        EventHandler.Action action3 = this.nextAction;
        return action3 == action2 || action3 == EventHandler.Action.RESET_DERIVATIVES;
    }

    public void setExpandable(ExpandableStatefulODE expandableStatefulODE) {
        this.expandable = expandableStatefulODE;
    }

    public void stepAccepted(double d, double[] dArr) {
        this.f6830t0 = d;
        this.f6829g0 = this.handler.g(d, dArr);
        if (!this.pendingEvent || FastMath.abs(this.pendingEventTime - d) > this.convergence) {
            this.g0Positive = this.f6829g0 >= 0.0d;
            this.nextAction = EventHandler.Action.CONTINUE;
        } else {
            this.previousEventTime = d;
            boolean z6 = this.increasing;
            this.g0Positive = z6;
            this.nextAction = this.handler.eventOccurred(d, dArr, !(z6 ^ this.forward));
        }
    }

    public boolean stop() {
        return this.nextAction == EventHandler.Action.STOP;
    }
}
