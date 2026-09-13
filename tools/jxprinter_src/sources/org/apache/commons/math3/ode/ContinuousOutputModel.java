package org.apache.commons.math3.ode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ContinuousOutputModel implements StepHandler, Serializable {
    private static final long serialVersionUID = -1417964919405031606L;
    private List<StepInterpolator> steps = new ArrayList();
    private double initialTime = Double.NaN;
    private double finalTime = Double.NaN;
    private boolean forward = true;
    private int index = 0;

    private int locatePoint(double d, StepInterpolator stepInterpolator) {
        if (this.forward) {
            if (d < stepInterpolator.getPreviousTime()) {
                return -1;
            }
            return d > stepInterpolator.getCurrentTime() ? 1 : 0;
        }
        if (d > stepInterpolator.getPreviousTime()) {
            return -1;
        }
        return d < stepInterpolator.getCurrentTime() ? 1 : 0;
    }

    public void append(ContinuousOutputModel continuousOutputModel) {
        if (continuousOutputModel.steps.size() == 0) {
            return;
        }
        if (this.steps.size() == 0) {
            this.initialTime = continuousOutputModel.initialTime;
            this.forward = continuousOutputModel.forward;
        } else {
            if (getInterpolatedState().length != continuousOutputModel.getInterpolatedState().length) {
                throw new DimensionMismatchException(continuousOutputModel.getInterpolatedState().length, getInterpolatedState().length);
            }
            if (this.forward ^ continuousOutputModel.forward) {
                throw new MathIllegalArgumentException(LocalizedFormats.PROPAGATION_DIRECTION_MISMATCH, new Object[0]);
            }
            StepInterpolator stepInterpolator = this.steps.get(this.index);
            double currentTime = stepInterpolator.getCurrentTime();
            double previousTime = currentTime - stepInterpolator.getPreviousTime();
            double initialTime = continuousOutputModel.getInitialTime() - currentTime;
            if (FastMath.abs(initialTime) > FastMath.abs(previousTime) * 0.001d) {
                throw new MathIllegalArgumentException(LocalizedFormats.HOLE_BETWEEN_MODELS_TIME_RANGES, Double.valueOf(FastMath.abs(initialTime)));
            }
        }
        Iterator<StepInterpolator> it = continuousOutputModel.steps.iterator();
        while (it.hasNext()) {
            this.steps.add(it.next().copy());
        }
        int size = this.steps.size() - 1;
        this.index = size;
        this.finalTime = this.steps.get(size).getCurrentTime();
    }

    public double getFinalTime() {
        return this.finalTime;
    }

    public double getInitialTime() {
        return this.initialTime;
    }

    public double[] getInterpolatedDerivatives() {
        return this.steps.get(this.index).getInterpolatedDerivatives();
    }

    public double[] getInterpolatedSecondaryDerivatives(int i5) {
        return this.steps.get(this.index).getInterpolatedSecondaryDerivatives(i5);
    }

    public double[] getInterpolatedSecondaryState(int i5) {
        return this.steps.get(this.index).getInterpolatedSecondaryState(i5);
    }

    public double[] getInterpolatedState() {
        return this.steps.get(this.index).getInterpolatedState();
    }

    public double getInterpolatedTime() {
        return this.steps.get(this.index).getInterpolatedTime();
    }

    @Override // org.apache.commons.math3.ode.sampling.StepHandler
    public void handleStep(StepInterpolator stepInterpolator, boolean z6) {
        if (this.steps.size() == 0) {
            this.initialTime = stepInterpolator.getPreviousTime();
            this.forward = stepInterpolator.isForward();
        }
        this.steps.add(stepInterpolator.copy());
        if (z6) {
            this.finalTime = stepInterpolator.getCurrentTime();
            this.index = this.steps.size() - 1;
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.StepHandler
    public void init(double d, double[] dArr, double d6) {
        this.initialTime = Double.NaN;
        this.finalTime = Double.NaN;
        this.forward = true;
        this.index = 0;
        this.steps.clear();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00dc  */
    public void setInterpolatedTime(double d) {
        int i5 = 0;
        StepInterpolator stepInterpolator = this.steps.get(0);
        double d6 = 0.5d;
        double currentTime = (stepInterpolator.getCurrentTime() + stepInterpolator.getPreviousTime()) * 0.5d;
        int size = this.steps.size() - 1;
        StepInterpolator stepInterpolator2 = this.steps.get(size);
        double currentTime2 = (stepInterpolator2.getCurrentTime() + stepInterpolator2.getPreviousTime()) * 0.5d;
        if (locatePoint(d, stepInterpolator) <= 0) {
            this.index = 0;
            stepInterpolator.setInterpolatedTime(d);
            return;
        }
        if (locatePoint(d, stepInterpolator2) >= 0) {
            this.index = size;
            stepInterpolator2.setInterpolatedTime(d);
            return;
        }
        while (size - i5 > 5) {
            StepInterpolator stepInterpolator3 = this.steps.get(this.index);
            int iLocatePoint = locatePoint(d, stepInterpolator3);
            if (iLocatePoint < 0) {
                size = this.index;
                currentTime2 = (stepInterpolator3.getCurrentTime() + stepInterpolator3.getPreviousTime()) * d6;
            } else if (iLocatePoint <= 0) {
                stepInterpolator3.setInterpolatedTime(d);
                return;
            } else {
                i5 = this.index;
                currentTime = (stepInterpolator3.getCurrentTime() + stepInterpolator3.getPreviousTime()) * d6;
            }
            int i6 = (i5 + size) / 2;
            StepInterpolator stepInterpolator4 = this.steps.get(i6);
            double currentTime3 = (stepInterpolator4.getCurrentTime() + stepInterpolator4.getPreviousTime()) * d6;
            double d7 = currentTime3 - currentTime;
            if (FastMath.abs(d7) >= 1.0E-6d) {
                double d8 = currentTime2 - currentTime3;
                if (FastMath.abs(d8) < 1.0E-6d) {
                    this.index = i6;
                } else {
                    double d9 = currentTime2 - currentTime;
                    double d10 = d - currentTime2;
                    double d11 = d - currentTime3;
                    double d12 = d - currentTime;
                    this.index = (int) FastMath.rint(((((d10 * d11) * d8) * ((double) i5)) + ((((d11 * d12) * d7) * ((double) size)) - (((d12 * d10) * d9) * ((double) i6)))) / ((d8 * d7) * d9));
                }
            } else {
                this.index = i6;
            }
            int iMax = FastMath.max(i5 + 1, ((i5 * 9) + size) / 10);
            int iMin = FastMath.min(size - 1, ((size * 9) + i5) / 10);
            int i7 = this.index;
            if (i7 < iMax) {
                this.index = iMax;
            } else if (i7 > iMin) {
                this.index = iMin;
            }
            d6 = 0.5d;
        }
        this.index = i5;
        while (true) {
            int i8 = this.index;
            if (i8 > size || locatePoint(d, this.steps.get(i8)) <= 0) {
                break;
            } else {
                this.index++;
            }
        }
        this.steps.get(this.index).setInterpolatedTime(d);
    }
}
