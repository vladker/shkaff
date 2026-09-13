package org.apache.commons.math3.ode.sampling;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.EquationsMapper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractStepInterpolator implements StepInterpolator {
    protected double[] currentState;
    private boolean dirtyState;
    private boolean finalized;
    private boolean forward;
    private double globalCurrentTime;
    private double globalPreviousTime;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected double f6865h;
    protected double[] interpolatedDerivatives;
    protected double[] interpolatedPrimaryDerivatives;
    protected double[] interpolatedPrimaryState;
    protected double[][] interpolatedSecondaryDerivatives;
    protected double[][] interpolatedSecondaryState;
    protected double[] interpolatedState;
    protected double interpolatedTime;
    private EquationsMapper primaryMapper;
    private EquationsMapper[] secondaryMappers;
    private double softCurrentTime;
    private double softPreviousTime;

    public AbstractStepInterpolator() {
        this.globalPreviousTime = Double.NaN;
        this.globalCurrentTime = Double.NaN;
        this.softPreviousTime = Double.NaN;
        this.softCurrentTime = Double.NaN;
        this.f6865h = Double.NaN;
        this.interpolatedTime = Double.NaN;
        this.currentState = null;
        this.finalized = false;
        this.forward = true;
        this.dirtyState = true;
        this.primaryMapper = null;
        this.secondaryMappers = null;
        allocateInterpolatedArrays(-1);
    }

    private void allocateInterpolatedArrays(int i5) {
        if (i5 < 0) {
            this.interpolatedState = null;
            this.interpolatedDerivatives = null;
            this.interpolatedPrimaryState = null;
            this.interpolatedPrimaryDerivatives = null;
            this.interpolatedSecondaryState = null;
            this.interpolatedSecondaryDerivatives = null;
            return;
        }
        this.interpolatedState = new double[i5];
        this.interpolatedDerivatives = new double[i5];
        this.interpolatedPrimaryState = new double[this.primaryMapper.getDimension()];
        this.interpolatedPrimaryDerivatives = new double[this.primaryMapper.getDimension()];
        EquationsMapper[] equationsMapperArr = this.secondaryMappers;
        if (equationsMapperArr == null) {
            this.interpolatedSecondaryState = null;
            this.interpolatedSecondaryDerivatives = null;
            return;
        }
        this.interpolatedSecondaryState = new double[equationsMapperArr.length][];
        this.interpolatedSecondaryDerivatives = new double[equationsMapperArr.length][];
        int i6 = 0;
        while (true) {
            EquationsMapper[] equationsMapperArr2 = this.secondaryMappers;
            if (i6 >= equationsMapperArr2.length) {
                return;
            }
            this.interpolatedSecondaryState[i6] = new double[equationsMapperArr2[i6].getDimension()];
            this.interpolatedSecondaryDerivatives[i6] = new double[this.secondaryMappers[i6].getDimension()];
            i6++;
        }
    }

    private void evaluateCompleteInterpolatedState() {
        if (this.dirtyState) {
            double d = this.globalCurrentTime - this.interpolatedTime;
            double d6 = this.f6865h;
            computeInterpolatedStateAndDerivatives(d6 != 0.0d ? (d6 - d) / d6 : 0.0d, d);
            this.dirtyState = false;
        }
    }

    public abstract void computeInterpolatedStateAndDerivatives(double d, double d6);

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public StepInterpolator copy() {
        finalizeStep();
        return doCopy();
    }

    public abstract StepInterpolator doCopy();

    public final void finalizeStep() {
        if (this.finalized) {
            return;
        }
        doFinalize();
        this.finalized = true;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double getCurrentTime() {
        return this.softCurrentTime;
    }

    public double getGlobalCurrentTime() {
        return this.globalCurrentTime;
    }

    public double getGlobalPreviousTime() {
        return this.globalPreviousTime;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double[] getInterpolatedDerivatives() {
        evaluateCompleteInterpolatedState();
        this.primaryMapper.extractEquationData(this.interpolatedDerivatives, this.interpolatedPrimaryDerivatives);
        return this.interpolatedPrimaryDerivatives;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double[] getInterpolatedSecondaryDerivatives(int i5) {
        evaluateCompleteInterpolatedState();
        this.secondaryMappers[i5].extractEquationData(this.interpolatedDerivatives, this.interpolatedSecondaryDerivatives[i5]);
        return this.interpolatedSecondaryDerivatives[i5];
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double[] getInterpolatedSecondaryState(int i5) {
        evaluateCompleteInterpolatedState();
        this.secondaryMappers[i5].extractEquationData(this.interpolatedState, this.interpolatedSecondaryState[i5]);
        return this.interpolatedSecondaryState[i5];
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double[] getInterpolatedState() {
        evaluateCompleteInterpolatedState();
        this.primaryMapper.extractEquationData(this.interpolatedState, this.interpolatedPrimaryState);
        return this.interpolatedPrimaryState;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double getInterpolatedTime() {
        return this.interpolatedTime;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double getPreviousTime() {
        return this.softPreviousTime;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public boolean isForward() {
        return this.forward;
    }

    public double readBaseExternal(ObjectInput objectInput) throws IOException {
        int i5 = objectInput.readInt();
        this.globalPreviousTime = objectInput.readDouble();
        this.globalCurrentTime = objectInput.readDouble();
        this.softPreviousTime = objectInput.readDouble();
        this.softCurrentTime = objectInput.readDouble();
        this.f6865h = objectInput.readDouble();
        this.forward = objectInput.readBoolean();
        this.primaryMapper = (EquationsMapper) objectInput.readObject();
        this.secondaryMappers = new EquationsMapper[objectInput.read()];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            EquationsMapper[] equationsMapperArr = this.secondaryMappers;
            if (i7 >= equationsMapperArr.length) {
                break;
            }
            equationsMapperArr[i7] = (EquationsMapper) objectInput.readObject();
            i7++;
        }
        this.dirtyState = true;
        if (i5 >= 0) {
            this.currentState = new double[i5];
            while (true) {
                double[] dArr = this.currentState;
                if (i6 >= dArr.length) {
                    break;
                }
                dArr[i6] = objectInput.readDouble();
                i6++;
            }
        } else {
            this.currentState = null;
        }
        this.interpolatedTime = Double.NaN;
        allocateInterpolatedArrays(i5);
        this.finalized = true;
        return objectInput.readDouble();
    }

    @Override // java.io.Externalizable
    public abstract void readExternal(ObjectInput objectInput);

    public void reinitialize(double[] dArr, boolean z6, EquationsMapper equationsMapper, EquationsMapper[] equationsMapperArr) {
        this.globalPreviousTime = Double.NaN;
        this.globalCurrentTime = Double.NaN;
        this.softPreviousTime = Double.NaN;
        this.softCurrentTime = Double.NaN;
        this.f6865h = Double.NaN;
        this.interpolatedTime = Double.NaN;
        this.currentState = dArr;
        this.finalized = false;
        this.forward = z6;
        this.dirtyState = true;
        this.primaryMapper = equationsMapper;
        this.secondaryMappers = (EquationsMapper[]) equationsMapperArr.clone();
        allocateInterpolatedArrays(dArr.length);
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public void setInterpolatedTime(double d) {
        this.interpolatedTime = d;
        this.dirtyState = true;
    }

    public void setSoftCurrentTime(double d) {
        this.softCurrentTime = d;
    }

    public void setSoftPreviousTime(double d) {
        this.softPreviousTime = d;
    }

    public void shift() {
        double d = this.globalCurrentTime;
        this.globalPreviousTime = d;
        this.softPreviousTime = d;
        this.softCurrentTime = d;
    }

    public void storeTime(double d) {
        this.globalCurrentTime = d;
        this.softCurrentTime = d;
        this.f6865h = d - this.globalPreviousTime;
        setInterpolatedTime(d);
        this.finalized = false;
    }

    public void writeBaseExternal(ObjectOutput objectOutput) throws IOException {
        double[] dArr = this.currentState;
        if (dArr == null) {
            objectOutput.writeInt(-1);
        } else {
            objectOutput.writeInt(dArr.length);
        }
        objectOutput.writeDouble(this.globalPreviousTime);
        objectOutput.writeDouble(this.globalCurrentTime);
        objectOutput.writeDouble(this.softPreviousTime);
        objectOutput.writeDouble(this.softCurrentTime);
        objectOutput.writeDouble(this.f6865h);
        objectOutput.writeBoolean(this.forward);
        objectOutput.writeObject(this.primaryMapper);
        objectOutput.write(this.secondaryMappers.length);
        int i5 = 0;
        for (EquationsMapper equationsMapper : this.secondaryMappers) {
            objectOutput.writeObject(equationsMapper);
        }
        if (this.currentState != null) {
            while (true) {
                double[] dArr2 = this.currentState;
                if (i5 >= dArr2.length) {
                    break;
                }
                objectOutput.writeDouble(dArr2[i5]);
                i5++;
            }
        }
        objectOutput.writeDouble(this.interpolatedTime);
        try {
            finalizeStep();
        } catch (MaxCountExceededException e) {
            IOException iOException = new IOException(e.getLocalizedMessage());
            iOException.initCause(e);
            throw iOException;
        }
    }

    @Override // java.io.Externalizable
    public abstract void writeExternal(ObjectOutput objectOutput);

    public AbstractStepInterpolator(double[] dArr, boolean z6, EquationsMapper equationsMapper, EquationsMapper[] equationsMapperArr) {
        this.globalPreviousTime = Double.NaN;
        this.globalCurrentTime = Double.NaN;
        this.softPreviousTime = Double.NaN;
        this.softCurrentTime = Double.NaN;
        this.f6865h = Double.NaN;
        this.interpolatedTime = Double.NaN;
        this.currentState = dArr;
        this.finalized = false;
        this.forward = z6;
        this.dirtyState = true;
        this.primaryMapper = equationsMapper;
        this.secondaryMappers = equationsMapperArr == null ? null : (EquationsMapper[]) equationsMapperArr.clone();
        allocateInterpolatedArrays(dArr.length);
    }

    public void doFinalize() {
    }

    public AbstractStepInterpolator(AbstractStepInterpolator abstractStepInterpolator) {
        this.globalPreviousTime = abstractStepInterpolator.globalPreviousTime;
        this.globalCurrentTime = abstractStepInterpolator.globalCurrentTime;
        this.softPreviousTime = abstractStepInterpolator.softPreviousTime;
        this.softCurrentTime = abstractStepInterpolator.softCurrentTime;
        this.f6865h = abstractStepInterpolator.f6865h;
        this.interpolatedTime = abstractStepInterpolator.interpolatedTime;
        double[] dArr = abstractStepInterpolator.currentState;
        if (dArr == null) {
            this.currentState = null;
            this.primaryMapper = null;
            this.secondaryMappers = null;
            allocateInterpolatedArrays(-1);
        } else {
            this.currentState = (double[]) dArr.clone();
            this.interpolatedState = (double[]) abstractStepInterpolator.interpolatedState.clone();
            this.interpolatedDerivatives = (double[]) abstractStepInterpolator.interpolatedDerivatives.clone();
            this.interpolatedPrimaryState = (double[]) abstractStepInterpolator.interpolatedPrimaryState.clone();
            this.interpolatedPrimaryDerivatives = (double[]) abstractStepInterpolator.interpolatedPrimaryDerivatives.clone();
            this.interpolatedSecondaryState = new double[abstractStepInterpolator.interpolatedSecondaryState.length][];
            this.interpolatedSecondaryDerivatives = new double[abstractStepInterpolator.interpolatedSecondaryDerivatives.length][];
            int i5 = 0;
            while (true) {
                double[][] dArr2 = this.interpolatedSecondaryState;
                if (i5 >= dArr2.length) {
                    break;
                }
                dArr2[i5] = (double[]) abstractStepInterpolator.interpolatedSecondaryState[i5].clone();
                this.interpolatedSecondaryDerivatives[i5] = (double[]) abstractStepInterpolator.interpolatedSecondaryDerivatives[i5].clone();
                i5++;
            }
        }
        this.finalized = abstractStepInterpolator.finalized;
        this.forward = abstractStepInterpolator.forward;
        this.dirtyState = abstractStepInterpolator.dirtyState;
        this.primaryMapper = abstractStepInterpolator.primaryMapper;
        EquationsMapper[] equationsMapperArr = abstractStepInterpolator.secondaryMappers;
        this.secondaryMappers = equationsMapperArr != null ? (EquationsMapper[]) equationsMapperArr.clone() : null;
    }
}
