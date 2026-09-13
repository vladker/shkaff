package org.apache.commons.math3.ode.sampling;

import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class StepNormalizer implements StepHandler {
    private final StepNormalizerBounds bounds;
    private double firstTime;
    private boolean forward;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f6867h;
    private final FixedStepHandler handler;
    private double[] lastDerivatives;
    private double[] lastState;
    private double lastTime;
    private final StepNormalizerMode mode;

    public StepNormalizer(double d, FixedStepHandler fixedStepHandler) {
        this(d, fixedStepHandler, StepNormalizerMode.INCREMENT, StepNormalizerBounds.FIRST);
    }

    private void doNormalizedStep(boolean z6) {
        if (this.bounds.firstIncluded() || this.firstTime != this.lastTime) {
            this.handler.handleStep(this.lastTime, this.lastState, this.lastDerivatives, z6);
        }
    }

    private boolean isNextInStep(double d, StepInterpolator stepInterpolator) {
        boolean z6 = this.forward;
        double currentTime = stepInterpolator.getCurrentTime();
        if (z6) {
            return d <= currentTime;
        }
        return d >= currentTime;
    }

    private void storeStep(StepInterpolator stepInterpolator, double d) {
        this.lastTime = d;
        stepInterpolator.setInterpolatedTime(d);
        double[] interpolatedState = stepInterpolator.getInterpolatedState();
        double[] dArr = this.lastState;
        System.arraycopy(interpolatedState, 0, dArr, 0, dArr.length);
        double[] interpolatedDerivatives = stepInterpolator.getInterpolatedDerivatives();
        double[] dArr2 = this.lastDerivatives;
        System.arraycopy(interpolatedDerivatives, 0, dArr2, 0, dArr2.length);
    }

    @Override // org.apache.commons.math3.ode.sampling.StepHandler
    public void handleStep(StepInterpolator stepInterpolator, boolean z6) {
        boolean z7 = false;
        if (this.lastState == null) {
            this.firstTime = stepInterpolator.getPreviousTime();
            double previousTime = stepInterpolator.getPreviousTime();
            this.lastTime = previousTime;
            stepInterpolator.setInterpolatedTime(previousTime);
            this.lastState = (double[]) stepInterpolator.getInterpolatedState().clone();
            this.lastDerivatives = (double[]) stepInterpolator.getInterpolatedDerivatives().clone();
            boolean z8 = stepInterpolator.getCurrentTime() >= this.lastTime;
            this.forward = z8;
            if (!z8) {
                this.f6867h = -this.f6867h;
            }
        }
        double dFloor = this.mode == StepNormalizerMode.INCREMENT ? this.lastTime + this.f6867h : (FastMath.floor(this.lastTime / this.f6867h) + 1.0d) * this.f6867h;
        if (this.mode == StepNormalizerMode.MULTIPLES && Precision.equals(dFloor, this.lastTime, 1)) {
            dFloor += this.f6867h;
        }
        boolean zIsNextInStep = isNextInStep(dFloor, stepInterpolator);
        while (zIsNextInStep) {
            doNormalizedStep(false);
            storeStep(stepInterpolator, dFloor);
            dFloor += this.f6867h;
            zIsNextInStep = isNextInStep(dFloor, stepInterpolator);
        }
        if (z6) {
            if (this.bounds.lastIncluded() && this.lastTime != stepInterpolator.getCurrentTime()) {
                z7 = true;
            }
            doNormalizedStep(!z7);
            if (z7) {
                storeStep(stepInterpolator, stepInterpolator.getCurrentTime());
                doNormalizedStep(true);
            }
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.StepHandler
    public void init(double d, double[] dArr, double d6) {
        this.firstTime = Double.NaN;
        this.lastTime = Double.NaN;
        this.lastState = null;
        this.lastDerivatives = null;
        this.forward = true;
        this.handler.init(d, dArr, d6);
    }

    public StepNormalizer(double d, FixedStepHandler fixedStepHandler, StepNormalizerMode stepNormalizerMode) {
        this(d, fixedStepHandler, stepNormalizerMode, StepNormalizerBounds.FIRST);
    }

    public StepNormalizer(double d, FixedStepHandler fixedStepHandler, StepNormalizerBounds stepNormalizerBounds) {
        this(d, fixedStepHandler, StepNormalizerMode.INCREMENT, stepNormalizerBounds);
    }

    public StepNormalizer(double d, FixedStepHandler fixedStepHandler, StepNormalizerMode stepNormalizerMode, StepNormalizerBounds stepNormalizerBounds) {
        this.f6867h = FastMath.abs(d);
        this.handler = fixedStepHandler;
        this.mode = stepNormalizerMode;
        this.bounds = stepNormalizerBounds;
        this.firstTime = Double.NaN;
        this.lastTime = Double.NaN;
        this.lastState = null;
        this.lastDerivatives = null;
        this.forward = true;
    }
}
