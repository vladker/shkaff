package org.apache.commons.math3.ode.sampling;

import androidx.collection.a;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NordsieckStepInterpolator extends AbstractStepInterpolator {
    private static final long serialVersionUID = -7179861704951334960L;
    private Array2DRowRealMatrix nordsieck;
    private double referenceTime;
    private double[] scaled;
    private double scalingH;
    protected double[] stateVariation;

    public NordsieckStepInterpolator() {
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void computeInterpolatedStateAndDerivatives(double d, double d6) {
        int i5;
        double d7 = this.interpolatedTime - this.referenceTime;
        double d8 = d7 / this.scalingH;
        Arrays.fill(this.stateVariation, 0.0d);
        Arrays.fill(this.interpolatedDerivatives, 0.0d);
        double[][] dataRef = this.nordsieck.getDataRef();
        int length = dataRef.length - 1;
        while (true) {
            i5 = 0;
            if (length < 0) {
                break;
            }
            int i6 = length + 2;
            double[] dArr = dataRef[length];
            double dPow = FastMath.pow(d8, i6);
            while (i5 < dArr.length) {
                double d9 = dArr[i5] * dPow;
                double[] dArr2 = this.stateVariation;
                dArr2[i5] = dArr2[i5] + d9;
                double[] dArr3 = this.interpolatedDerivatives;
                dArr3[i5] = (((double) i6) * d9) + dArr3[i5];
                i5++;
                dataRef = dataRef;
                length = length;
            }
            length--;
        }
        while (true) {
            double[] dArr4 = this.currentState;
            if (i5 >= dArr4.length) {
                return;
            }
            double[] dArr5 = this.stateVariation;
            double d10 = dArr5[i5];
            double[] dArr6 = this.scaled;
            double d11 = (dArr6[i5] * d8) + d10;
            dArr5[i5] = d11;
            this.interpolatedState[i5] = dArr4[i5] + d11;
            double[] dArr7 = this.interpolatedDerivatives;
            dArr7[i5] = a.D(dArr6[i5], d8, dArr7[i5], d7);
            i5++;
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public StepInterpolator doCopy() {
        return new NordsieckStepInterpolator(this);
    }

    public double[] getInterpolatedStateVariation() {
        getInterpolatedState();
        return this.stateVariation;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        double baseExternal = readBaseExternal(objectInput);
        this.scalingH = objectInput.readDouble();
        this.referenceTime = objectInput.readDouble();
        double[] dArr = this.currentState;
        int length = dArr == null ? -1 : dArr.length;
        boolean z6 = objectInput.readBoolean();
        if (z6) {
            this.scaled = new double[length];
            for (int i5 = 0; i5 < length; i5++) {
                this.scaled[i5] = objectInput.readDouble();
            }
        } else {
            this.scaled = null;
        }
        boolean z7 = objectInput.readBoolean();
        if (z7) {
            this.nordsieck = (Array2DRowRealMatrix) objectInput.readObject();
        } else {
            this.nordsieck = null;
        }
        if (z6 && z7) {
            this.stateVariation = new double[length];
            setInterpolatedTime(baseExternal);
        } else {
            this.stateVariation = null;
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void reinitialize(double[] dArr, boolean z6, EquationsMapper equationsMapper, EquationsMapper[] equationsMapperArr) {
        super.reinitialize(dArr, z6, equationsMapper, equationsMapperArr);
        this.stateVariation = new double[dArr.length];
    }

    public void rescale(double d) {
        double d6 = d / this.scalingH;
        int i5 = 0;
        while (true) {
            double[] dArr = this.scaled;
            if (i5 >= dArr.length) {
                break;
            }
            dArr[i5] = dArr[i5] * d6;
            i5++;
        }
        double d7 = d6;
        for (double[] dArr2 : this.nordsieck.getDataRef()) {
            d7 *= d6;
            for (int i6 = 0; i6 < dArr2.length; i6++) {
                dArr2[i6] = dArr2[i6] * d7;
            }
        }
        this.scalingH = d;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        writeBaseExternal(objectOutput);
        objectOutput.writeDouble(this.scalingH);
        objectOutput.writeDouble(this.referenceTime);
        double[] dArr = this.currentState;
        int length = dArr == null ? -1 : dArr.length;
        if (this.scaled == null) {
            objectOutput.writeBoolean(false);
        } else {
            objectOutput.writeBoolean(true);
            for (int i5 = 0; i5 < length; i5++) {
                objectOutput.writeDouble(this.scaled[i5]);
            }
        }
        if (this.nordsieck == null) {
            objectOutput.writeBoolean(false);
        } else {
            objectOutput.writeBoolean(true);
            objectOutput.writeObject(this.nordsieck);
        }
    }

    public NordsieckStepInterpolator(NordsieckStepInterpolator nordsieckStepInterpolator) {
        super(nordsieckStepInterpolator);
        this.scalingH = nordsieckStepInterpolator.scalingH;
        this.referenceTime = nordsieckStepInterpolator.referenceTime;
        double[] dArr = nordsieckStepInterpolator.scaled;
        if (dArr != null) {
            this.scaled = (double[]) dArr.clone();
        }
        if (nordsieckStepInterpolator.nordsieck != null) {
            this.nordsieck = new Array2DRowRealMatrix(nordsieckStepInterpolator.nordsieck.getDataRef(), true);
        }
        double[] dArr2 = nordsieckStepInterpolator.stateVariation;
        if (dArr2 != null) {
            this.stateVariation = (double[]) dArr2.clone();
        }
    }

    public void reinitialize(double d, double d6, double[] dArr, Array2DRowRealMatrix array2DRowRealMatrix) {
        this.referenceTime = d;
        this.scalingH = d6;
        this.scaled = dArr;
        this.nordsieck = array2DRowRealMatrix;
        setInterpolatedTime(getInterpolatedTime());
    }
}
