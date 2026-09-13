package org.apache.commons.math3.ode.sampling;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.ode.FieldODEStateAndDerivative;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class FieldStepNormalizer<T extends RealFieldElement<T>> implements FieldStepHandler<T> {
    private final StepNormalizerBounds bounds;
    private FieldODEStateAndDerivative<T> first;
    private boolean forward;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f6866h;
    private final FieldFixedStepHandler<T> handler;
    private FieldODEStateAndDerivative<T> last;
    private final StepNormalizerMode mode;

    public FieldStepNormalizer(double d, FieldFixedStepHandler<T> fieldFixedStepHandler) {
        this(d, fieldFixedStepHandler, StepNormalizerMode.INCREMENT, StepNormalizerBounds.FIRST);
    }

    private void doNormalizedStep(boolean z6) {
        if (this.bounds.firstIncluded() || this.first.getTime().getReal() != this.last.getTime().getReal()) {
            this.handler.handleStep(this.last, z6);
        }
    }

    private boolean isNextInStep(T t6, FieldStepInterpolator<T> fieldStepInterpolator) {
        boolean z6 = this.forward;
        double real = t6.getReal();
        double real2 = fieldStepInterpolator.getCurrentState().getTime().getReal();
        if (z6) {
            return real <= real2;
        }
        return real >= real2;
    }

    @Override // org.apache.commons.math3.ode.sampling.FieldStepHandler
    public void handleStep(FieldStepInterpolator<T> fieldStepInterpolator, boolean z6) {
        RealFieldElement time;
        double dFloor;
        boolean z7;
        if (this.last == null) {
            FieldODEStateAndDerivative<T> previousState = fieldStepInterpolator.getPreviousState();
            this.first = previousState;
            this.last = previousState;
            boolean zIsForward = fieldStepInterpolator.isForward();
            this.forward = zIsForward;
            if (!zIsForward) {
                this.f6866h = -this.f6866h;
            }
        }
        if (this.mode == StepNormalizerMode.INCREMENT) {
            time = this.last.getTime();
            dFloor = this.f6866h;
        } else {
            time = (RealFieldElement) this.last.getTime().getField().getZero();
            dFloor = (FastMath.floor(this.last.getTime().getReal() / this.f6866h) + 1.0d) * this.f6866h;
        }
        RealFieldElement realFieldElement = (RealFieldElement) time.add(dFloor);
        if (this.mode == StepNormalizerMode.MULTIPLES && Precision.equals(realFieldElement.getReal(), this.last.getTime().getReal(), 1)) {
            realFieldElement = (RealFieldElement) realFieldElement.add(this.f6866h);
        }
        boolean zIsNextInStep = isNextInStep(realFieldElement, fieldStepInterpolator);
        while (true) {
            z7 = false;
            if (!zIsNextInStep) {
                break;
            }
            doNormalizedStep(false);
            this.last = fieldStepInterpolator.getInterpolatedState(realFieldElement);
            realFieldElement = (RealFieldElement) realFieldElement.add(this.f6866h);
            zIsNextInStep = isNextInStep(realFieldElement, fieldStepInterpolator);
        }
        if (z6) {
            if (this.bounds.lastIncluded() && this.last.getTime().getReal() != fieldStepInterpolator.getCurrentState().getTime().getReal()) {
                z7 = true;
            }
            doNormalizedStep(!z7);
            if (z7) {
                this.last = fieldStepInterpolator.getCurrentState();
                doNormalizedStep(true);
            }
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.FieldStepHandler
    public void init(FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, T t6) {
        this.first = null;
        this.last = null;
        this.forward = true;
        this.handler.init(fieldODEStateAndDerivative, t6);
    }

    public FieldStepNormalizer(double d, FieldFixedStepHandler<T> fieldFixedStepHandler, StepNormalizerMode stepNormalizerMode) {
        this(d, fieldFixedStepHandler, stepNormalizerMode, StepNormalizerBounds.FIRST);
    }

    public FieldStepNormalizer(double d, FieldFixedStepHandler<T> fieldFixedStepHandler, StepNormalizerBounds stepNormalizerBounds) {
        this(d, fieldFixedStepHandler, StepNormalizerMode.INCREMENT, stepNormalizerBounds);
    }

    public FieldStepNormalizer(double d, FieldFixedStepHandler<T> fieldFixedStepHandler, StepNormalizerMode stepNormalizerMode, StepNormalizerBounds stepNormalizerBounds) {
        this.f6866h = FastMath.abs(d);
        this.handler = fieldFixedStepHandler;
        this.mode = stepNormalizerMode;
        this.bounds = stepNormalizerBounds;
        this.first = null;
        this.last = null;
        this.forward = true;
    }
}
