package org.apache.commons.math3.ode.events;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.analysis.RealFieldUnivariateFunction;
import org.apache.commons.math3.analysis.solvers.AllowedSolution;
import org.apache.commons.math3.analysis.solvers.BracketedRealFieldUnivariateSolver;
import org.apache.commons.math3.ode.FieldODEState;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.ode.sampling.FieldStepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FieldEventState<T extends RealFieldElement<T>> {
    private final T convergence;
    private boolean forward;
    private final FieldEventHandler<T> handler;
    private final double maxCheckInterval;
    private final int maxIterationCount;
    private final BracketedRealFieldUnivariateSolver<T> solver;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private T f6832t0 = null;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private T f6831g0 = null;
    private boolean g0Positive = true;
    private boolean pendingEvent = false;
    private T pendingEventTime = null;
    private T previousEventTime = null;
    private boolean increasing = true;
    private Action nextAction = Action.CONTINUE;

    public FieldEventState(FieldEventHandler<T> fieldEventHandler, double d, T t6, int i5, BracketedRealFieldUnivariateSolver<T> bracketedRealFieldUnivariateSolver) {
        this.handler = fieldEventHandler;
        this.maxCheckInterval = d;
        this.convergence = (T) t6.abs();
        this.maxIterationCount = i5;
        this.solver = bracketedRealFieldUnivariateSolver;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x016e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean evaluateStep(final FieldStepInterpolator<T> fieldStepInterpolator) {
        RealFieldElement realFieldElement;
        T t6;
        T t7;
        RealFieldElement realFieldElement2;
        RealFieldElement realFieldElementValue;
        this.forward = fieldStepInterpolator.isForward();
        T time = fieldStepInterpolator.getCurrentState().getTime();
        RealFieldElement realFieldElement3 = (RealFieldElement) time.subtract(this.f6832t0);
        if (((RealFieldElement) ((RealFieldElement) realFieldElement3.abs()).subtract(this.convergence)).getReal() < 0.0d) {
            return false;
        }
        int iMax = FastMath.max(1, (int) FastMath.ceil(FastMath.abs(realFieldElement3.getReal()) / this.maxCheckInterval));
        RealFieldElement realFieldElement4 = (RealFieldElement) realFieldElement3.divide(iMax);
        RealFieldUnivariateFunction<T> realFieldUnivariateFunction = new RealFieldUnivariateFunction<T>() { // from class: org.apache.commons.math3.ode.events.FieldEventState.1
            @Override // org.apache.commons.math3.analysis.RealFieldUnivariateFunction
            public T value(T t8) {
                return (T) FieldEventState.this.handler.g(fieldStepInterpolator.getInterpolatedState(t8));
            }
        };
        T t8 = this.f6832t0;
        RealFieldElement realFieldElement5 = this.f6831g0;
        int i5 = 0;
        RealFieldElement realFieldElement6 = t8;
        while (i5 < iMax) {
            RealFieldElement realFieldElement7 = i5 == iMax + (-1) ? time : (RealFieldElement) this.f6832t0.add(realFieldElement4.multiply(i5 + 1));
            RealFieldElement realFieldElementG = this.handler.g(fieldStepInterpolator.getInterpolatedState(realFieldElement7));
            if (this.g0Positive ^ (realFieldElementG.getReal() >= 0.0d)) {
                this.increasing = ((RealFieldElement) realFieldElementG.subtract(realFieldElement5)).getReal() >= 0.0d;
                if (this.forward) {
                    realFieldElement = realFieldElementG;
                    t6 = (T) this.solver.solve(this.maxIterationCount, realFieldUnivariateFunction, realFieldElement6, realFieldElement7, AllowedSolution.RIGHT_SIDE);
                } else {
                    realFieldElement = realFieldElementG;
                    RealFieldElement realFieldElement8 = realFieldElement7;
                    RealFieldElement realFieldElement9 = realFieldElement6;
                    t6 = (T) this.solver.solve(this.maxIterationCount, realFieldUnivariateFunction, realFieldElement8, realFieldElement9, AllowedSolution.LEFT_SIDE);
                    realFieldElement7 = realFieldElement8;
                    realFieldElement6 = realFieldElement9;
                }
                if (this.previousEventTime == null || ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t6.subtract(realFieldElement6)).abs()).subtract(this.convergence)).getReal() > 0.0d) {
                    t7 = this.previousEventTime;
                    if (t7 != null || ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t7.subtract(t6)).abs()).subtract(this.convergence)).getReal() > 0.0d) {
                        this.pendingEventTime = t6;
                        this.pendingEvent = true;
                        return true;
                    }
                    realFieldElement2 = realFieldElement;
                } else {
                    if (((RealFieldElement) ((RealFieldElement) ((RealFieldElement) t6.subtract(this.previousEventTime)).abs()).subtract(this.convergence)).getReal() > 0.0d) {
                        t7 = this.previousEventTime;
                        if (t7 != null) {
                        }
                        this.pendingEventTime = t6;
                        this.pendingEvent = true;
                        return true;
                    }
                    do {
                        realFieldElement6 = (RealFieldElement) (this.forward ? realFieldElement6.add(this.convergence) : realFieldElement6.subtract(this.convergence));
                        realFieldElementValue = realFieldUnivariateFunction.value(realFieldElement6);
                        if (!(this.g0Positive ^ (realFieldElementValue.getReal() >= 0.0d))) {
                            break;
                        }
                    } while (this.forward ^ (((RealFieldElement) realFieldElement6.subtract(realFieldElement7)).getReal() >= 0.0d));
                    if (!((((RealFieldElement) realFieldElement6.subtract(realFieldElement7)).getReal() >= 0.0d) ^ this.forward)) {
                        this.pendingEventTime = t6;
                        this.pendingEvent = true;
                        return true;
                    }
                    i5--;
                    realFieldElement2 = realFieldElementValue;
                    realFieldElement7 = realFieldElement6;
                }
                realFieldElement5 = realFieldElement2;
            } else {
                realFieldElement5 = realFieldElementG;
            }
            realFieldElement6 = realFieldElement7;
            i5++;
        }
        this.pendingEvent = false;
        this.pendingEventTime = null;
        return false;
    }

    public T getConvergence() {
        return this.convergence;
    }

    public FieldEventHandler<T> getEventHandler() {
        return this.handler;
    }

    public T getEventTime() {
        if (this.pendingEvent) {
            return this.pendingEventTime;
        }
        return (T) ((RealFieldElement) this.f6832t0.getField().getZero()).add(this.forward ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY);
    }

    public double getMaxCheckInterval() {
        return this.maxCheckInterval;
    }

    public int getMaxIterationCount() {
        return this.maxIterationCount;
    }

    public void reinitializeBegin(FieldStepInterpolator<T> fieldStepInterpolator) {
        FieldODEStateAndDerivative<T> previousState = fieldStepInterpolator.getPreviousState();
        this.f6832t0 = previousState.getTime();
        T t6 = (T) this.handler.g(previousState);
        this.f6831g0 = t6;
        if (t6.getReal() == 0.0d) {
            this.f6831g0 = (T) this.handler.g(fieldStepInterpolator.getInterpolatedState((RealFieldElement) this.f6832t0.add(FastMath.max(this.solver.getAbsoluteAccuracy().getReal(), FastMath.abs(((RealFieldElement) this.solver.getRelativeAccuracy().multiply(this.f6832t0)).getReal())) * 0.5d)));
        }
        this.g0Positive = this.f6831g0.getReal() >= 0.0d;
    }

    public FieldODEState<T> reset(FieldODEStateAndDerivative<T> fieldODEStateAndDerivative) {
        if (!this.pendingEvent || ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.pendingEventTime.subtract(fieldODEStateAndDerivative.getTime())).abs()).subtract(this.convergence)).getReal() > 0.0d) {
            return null;
        }
        Action action = this.nextAction;
        if (action == Action.RESET_STATE) {
            fieldODEStateAndDerivative = this.handler.resetState(fieldODEStateAndDerivative);
        } else if (action != Action.RESET_DERIVATIVES) {
            fieldODEStateAndDerivative = null;
        }
        this.pendingEvent = false;
        this.pendingEventTime = null;
        return fieldODEStateAndDerivative;
    }

    public void stepAccepted(FieldODEStateAndDerivative<T> fieldODEStateAndDerivative) {
        this.f6832t0 = fieldODEStateAndDerivative.getTime();
        this.f6831g0 = (T) this.handler.g(fieldODEStateAndDerivative);
        if (!this.pendingEvent || ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) this.pendingEventTime.subtract(fieldODEStateAndDerivative.getTime())).abs()).subtract(this.convergence)).getReal() > 0.0d) {
            this.g0Positive = this.f6831g0.getReal() >= 0.0d;
            this.nextAction = Action.CONTINUE;
        } else {
            this.previousEventTime = fieldODEStateAndDerivative.getTime();
            boolean z6 = this.increasing;
            this.g0Positive = z6;
            this.nextAction = this.handler.eventOccurred(fieldODEStateAndDerivative, !(z6 ^ this.forward));
        }
    }

    public boolean stop() {
        return this.nextAction == Action.STOP;
    }
}
