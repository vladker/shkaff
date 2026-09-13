package org.apache.commons.math3.ode.nonstiff;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
abstract class RungeKuttaStepInterpolator extends AbstractStepInterpolator {
    protected AbstractIntegrator integrator;
    protected double[] previousState;
    protected double[][] yDotK;

    public RungeKuttaStepInterpolator() {
        this.previousState = null;
        this.yDotK = null;
        this.integrator = null;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        double baseExternal = readBaseExternal(objectInput);
        double[] dArr = this.currentState;
        int length = dArr == null ? -1 : dArr.length;
        if (length < 0) {
            this.previousState = null;
        } else {
            this.previousState = new double[length];
            for (int i5 = 0; i5 < length; i5++) {
                this.previousState[i5] = objectInput.readDouble();
            }
        }
        int i6 = objectInput.readInt();
        this.yDotK = i6 < 0 ? null : new double[i6][];
        for (int i7 = 0; i7 < i6; i7++) {
            this.yDotK[i7] = length < 0 ? null : new double[length];
            for (int i8 = 0; i8 < length; i8++) {
                this.yDotK[i7][i8] = objectInput.readDouble();
            }
        }
        this.integrator = null;
        if (this.currentState != null) {
            setInterpolatedTime(baseExternal);
        } else {
            this.interpolatedTime = baseExternal;
        }
    }

    public void reinitialize(AbstractIntegrator abstractIntegrator, double[] dArr, double[][] dArr2, boolean z6, EquationsMapper equationsMapper, EquationsMapper[] equationsMapperArr) {
        reinitialize(dArr, z6, equationsMapper, equationsMapperArr);
        this.previousState = null;
        this.yDotK = dArr2;
        this.integrator = abstractIntegrator;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void shift() {
        this.previousState = (double[]) this.currentState.clone();
        super.shift();
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        writeBaseExternal(objectOutput);
        double[] dArr = this.currentState;
        int length = dArr == null ? -1 : dArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            objectOutput.writeDouble(this.previousState[i5]);
        }
        double[][] dArr2 = this.yDotK;
        int length2 = dArr2 != null ? dArr2.length : -1;
        objectOutput.writeInt(length2);
        for (int i6 = 0; i6 < length2; i6++) {
            for (int i7 = 0; i7 < length; i7++) {
                objectOutput.writeDouble(this.yDotK[i6][i7]);
            }
        }
    }

    public RungeKuttaStepInterpolator(RungeKuttaStepInterpolator rungeKuttaStepInterpolator) {
        super(rungeKuttaStepInterpolator);
        if (rungeKuttaStepInterpolator.currentState != null) {
            this.previousState = (double[]) rungeKuttaStepInterpolator.previousState.clone();
            this.yDotK = new double[rungeKuttaStepInterpolator.yDotK.length][];
            int i5 = 0;
            while (true) {
                double[][] dArr = rungeKuttaStepInterpolator.yDotK;
                if (i5 >= dArr.length) {
                    break;
                }
                this.yDotK[i5] = (double[]) dArr[i5].clone();
                i5++;
            }
        } else {
            this.previousState = null;
            this.yDotK = null;
        }
        this.integrator = null;
    }
}
