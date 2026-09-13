package org.apache.commons.math3.ode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.sampling.FieldStepHandler;
import org.apache.commons.math3.ode.sampling.FieldStepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ContinuousOutputFieldModel<T extends RealFieldElement<T>> implements FieldStepHandler<T> {
    private List<FieldStepInterpolator<T>> steps = new ArrayList();
    private T initialTime = null;
    private T finalTime = null;
    private boolean forward = true;
    private int index = 0;

    private void checkDimensionsEquality(int i5, int i6) {
        if (i5 != i6) {
            throw new DimensionMismatchException(i6, i5);
        }
    }

    private int locatePoint(T t6, FieldStepInterpolator<T> fieldStepInterpolator) {
        if (this.forward) {
            if (((RealFieldElement) t6.subtract(fieldStepInterpolator.getPreviousState().getTime())).getReal() < 0.0d) {
                return -1;
            }
            return ((RealFieldElement) t6.subtract(fieldStepInterpolator.getCurrentState().getTime())).getReal() > 0.0d ? 1 : 0;
        }
        if (((RealFieldElement) t6.subtract(fieldStepInterpolator.getPreviousState().getTime())).getReal() > 0.0d) {
            return -1;
        }
        return ((RealFieldElement) t6.subtract(fieldStepInterpolator.getCurrentState().getTime())).getReal() < 0.0d ? 1 : 0;
    }

    public void append(ContinuousOutputFieldModel<T> continuousOutputFieldModel) {
        if (continuousOutputFieldModel.steps.size() == 0) {
            return;
        }
        if (this.steps.size() == 0) {
            this.initialTime = continuousOutputFieldModel.initialTime;
            this.forward = continuousOutputFieldModel.forward;
        } else {
            FieldODEStateAndDerivative<T> previousState = this.steps.get(0).getPreviousState();
            FieldODEStateAndDerivative<T> previousState2 = continuousOutputFieldModel.steps.get(0).getPreviousState();
            checkDimensionsEquality(previousState.getStateDimension(), previousState2.getStateDimension());
            checkDimensionsEquality(previousState.getNumberOfSecondaryStates(), previousState2.getNumberOfSecondaryStates());
            for (int i5 = 0; i5 < previousState.getNumberOfSecondaryStates(); i5++) {
                checkDimensionsEquality(previousState.getSecondaryStateDimension(i5), previousState2.getSecondaryStateDimension(i5));
            }
            if (this.forward ^ continuousOutputFieldModel.forward) {
                throw new MathIllegalArgumentException(LocalizedFormats.PROPAGATION_DIRECTION_MISMATCH, new Object[0]);
            }
            FieldStepInterpolator<T> fieldStepInterpolator = this.steps.get(this.index);
            T time = fieldStepInterpolator.getCurrentState().getTime();
            RealFieldElement realFieldElement = (RealFieldElement) time.subtract(fieldStepInterpolator.getPreviousState().getTime());
            RealFieldElement realFieldElement2 = (RealFieldElement) continuousOutputFieldModel.getInitialTime().subtract(time);
            if (((RealFieldElement) ((RealFieldElement) realFieldElement2.abs()).subtract(((RealFieldElement) realFieldElement.abs()).multiply(0.001d))).getReal() > 0.0d) {
                throw new MathIllegalArgumentException(LocalizedFormats.HOLE_BETWEEN_MODELS_TIME_RANGES, Double.valueOf(((RealFieldElement) realFieldElement2.abs()).getReal()));
            }
        }
        Iterator<FieldStepInterpolator<T>> it = continuousOutputFieldModel.steps.iterator();
        while (it.hasNext()) {
            this.steps.add(it.next());
        }
        int size = this.steps.size() - 1;
        this.index = size;
        this.finalTime = this.steps.get(size).getCurrentState().getTime();
    }

    public T getFinalTime() {
        return this.finalTime;
    }

    public T getInitialTime() {
        return this.initialTime;
    }

    public FieldODEStateAndDerivative<T> getInterpolatedState(T t6) {
        int i5 = 0;
        FieldStepInterpolator<T> fieldStepInterpolator = this.steps.get(0);
        RealFieldElement realFieldElement = (RealFieldElement) ((RealFieldElement) fieldStepInterpolator.getPreviousState().getTime().add(fieldStepInterpolator.getCurrentState().getTime())).multiply(0.5d);
        int size = this.steps.size() - 1;
        FieldStepInterpolator<T> fieldStepInterpolator2 = this.steps.get(size);
        RealFieldElement realFieldElement2 = (RealFieldElement) ((RealFieldElement) fieldStepInterpolator2.getPreviousState().getTime().add(fieldStepInterpolator2.getCurrentState().getTime())).multiply(0.5d);
        if (locatePoint(t6, fieldStepInterpolator) <= 0) {
            this.index = 0;
            return fieldStepInterpolator.getInterpolatedState(t6);
        }
        if (locatePoint(t6, fieldStepInterpolator2) >= 0) {
            this.index = size;
            return fieldStepInterpolator2.getInterpolatedState(t6);
        }
        while (size - i5 > 5) {
            FieldStepInterpolator<T> fieldStepInterpolator3 = this.steps.get(this.index);
            int iLocatePoint = locatePoint(t6, fieldStepInterpolator3);
            if (iLocatePoint < 0) {
                size = this.index;
                realFieldElement2 = (RealFieldElement) ((RealFieldElement) fieldStepInterpolator3.getPreviousState().getTime().add(fieldStepInterpolator3.getCurrentState().getTime())).multiply(0.5d);
            } else {
                if (iLocatePoint <= 0) {
                    return fieldStepInterpolator3.getInterpolatedState(t6);
                }
                i5 = this.index;
                realFieldElement = (RealFieldElement) ((RealFieldElement) fieldStepInterpolator3.getPreviousState().getTime().add(fieldStepInterpolator3.getCurrentState().getTime())).multiply(0.5d);
            }
            int i6 = (i5 + size) / 2;
            FieldStepInterpolator<T> fieldStepInterpolator4 = this.steps.get(i6);
            RealFieldElement realFieldElement3 = (RealFieldElement) ((RealFieldElement) fieldStepInterpolator4.getPreviousState().getTime().add(fieldStepInterpolator4.getCurrentState().getTime())).multiply(0.5d);
            if (((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement3.subtract(realFieldElement)).abs()).subtract(1.0E-6d)).getReal() < 0.0d || ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement2.subtract(realFieldElement3)).abs()).subtract(1.0E-6d)).getReal() < 0.0d) {
                this.index = i6;
            } else {
                RealFieldElement realFieldElement4 = (RealFieldElement) realFieldElement2.subtract(realFieldElement3);
                RealFieldElement realFieldElement5 = (RealFieldElement) realFieldElement3.subtract(realFieldElement);
                RealFieldElement realFieldElement6 = (RealFieldElement) realFieldElement2.subtract(realFieldElement);
                RealFieldElement realFieldElement7 = (RealFieldElement) t6.subtract(realFieldElement2);
                RealFieldElement realFieldElement8 = (RealFieldElement) t6.subtract(realFieldElement3);
                RealFieldElement realFieldElement9 = (RealFieldElement) t6.subtract(realFieldElement);
                this.index = (int) FastMath.rint(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) realFieldElement8.multiply(realFieldElement9)).multiply(realFieldElement5)).multiply(size)).subtract(((RealFieldElement) ((RealFieldElement) realFieldElement7.multiply(realFieldElement9)).multiply(realFieldElement6)).multiply(i6))).add(((RealFieldElement) ((RealFieldElement) realFieldElement7.multiply(realFieldElement8)).multiply(realFieldElement4)).multiply(i5))).divide(((RealFieldElement) realFieldElement4.multiply(realFieldElement5)).multiply(realFieldElement6))).getReal());
            }
            int iMax = FastMath.max(i5 + 1, ((i5 * 9) + size) / 10);
            int iMin = FastMath.min(size - 1, ((size * 9) + i5) / 10);
            int i7 = this.index;
            if (i7 < iMax) {
                this.index = iMax;
            } else if (i7 > iMin) {
                this.index = iMin;
            }
        }
        this.index = i5;
        while (true) {
            int i8 = this.index;
            if (i8 > size || locatePoint(t6, this.steps.get(i8)) <= 0) {
                break;
            }
            this.index++;
        }
        return this.steps.get(this.index).getInterpolatedState(t6);
    }

    @Override // org.apache.commons.math3.ode.sampling.FieldStepHandler
    public void handleStep(FieldStepInterpolator<T> fieldStepInterpolator, boolean z6) {
        if (this.steps.size() == 0) {
            this.initialTime = fieldStepInterpolator.getPreviousState().getTime();
            this.forward = fieldStepInterpolator.isForward();
        }
        this.steps.add(fieldStepInterpolator);
        if (z6) {
            this.finalTime = fieldStepInterpolator.getCurrentState().getTime();
            this.index = this.steps.size() - 1;
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.FieldStepHandler
    public void init(FieldODEStateAndDerivative<T> fieldODEStateAndDerivative, T t6) {
        this.initialTime = fieldODEStateAndDerivative.getTime();
        this.finalTime = t6;
        this.forward = true;
        this.index = 0;
        this.steps.clear();
    }
}
