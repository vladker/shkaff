package org.apache.commons.math3.complex;

import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class RootsOfUnity implements Serializable {
    private static final long serialVersionUID = 20120201;
    private int omegaCount = 0;
    private double[] omegaReal = null;
    private double[] omegaImaginaryCounterClockwise = null;
    private double[] omegaImaginaryClockwise = null;
    private boolean isCounterClockWise = true;

    public synchronized void computeRoots(int i5) {
        try {
            if (i5 == 0) {
                throw new ZeroException(LocalizedFormats.CANNOT_COMPUTE_0TH_ROOT_OF_UNITY, new Object[0]);
            }
            this.isCounterClockWise = i5 > 0;
            int iAbs = FastMath.abs(i5);
            if (iAbs == this.omegaCount) {
                return;
            }
            double d = 6.283185307179586d / ((double) iAbs);
            double dCos = FastMath.cos(d);
            double dSin = FastMath.sin(d);
            double[] dArr = new double[iAbs];
            this.omegaReal = dArr;
            double[] dArr2 = new double[iAbs];
            this.omegaImaginaryCounterClockwise = dArr2;
            double[] dArr3 = new double[iAbs];
            this.omegaImaginaryClockwise = dArr3;
            dArr[0] = 1.0d;
            dArr2[0] = 0.0d;
            dArr3[0] = 0.0d;
            for (int i6 = 1; i6 < iAbs; i6++) {
                double[] dArr4 = this.omegaReal;
                int i7 = i6 - 1;
                double d6 = dArr4[i7] * dCos;
                double[] dArr5 = this.omegaImaginaryCounterClockwise;
                dArr4[i6] = d6 - (dArr5[i7] * dSin);
                double d7 = (dArr5[i7] * dCos) + (dArr4[i7] * dSin);
                dArr5[i6] = d7;
                this.omegaImaginaryClockwise[i6] = -d7;
            }
            this.omegaCount = iAbs;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized double getImaginary(int i5) {
        try {
            int i6 = this.omegaCount;
            if (i6 == 0) {
                throw new MathIllegalStateException(LocalizedFormats.ROOTS_OF_UNITY_NOT_COMPUTED_YET, new Object[0]);
            }
            if (i5 < 0 || i5 >= i6) {
                throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_ROOT_OF_UNITY_INDEX, Integer.valueOf(i5), 0, Integer.valueOf(this.omegaCount - 1));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.isCounterClockWise ? this.omegaImaginaryCounterClockwise[i5] : this.omegaImaginaryClockwise[i5];
    }

    public synchronized int getNumberOfRoots() {
        return this.omegaCount;
    }

    public synchronized double getReal(int i5) {
        int i6 = this.omegaCount;
        if (i6 == 0) {
            throw new MathIllegalStateException(LocalizedFormats.ROOTS_OF_UNITY_NOT_COMPUTED_YET, new Object[0]);
        }
        if (i5 < 0 || i5 >= i6) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_ROOT_OF_UNITY_INDEX, Integer.valueOf(i5), 0, Integer.valueOf(this.omegaCount - 1));
        }
        return this.omegaReal[i5];
    }

    public synchronized boolean isCounterClockWise() {
        if (this.omegaCount == 0) {
            throw new MathIllegalStateException(LocalizedFormats.ROOTS_OF_UNITY_NOT_COMPUTED_YET, new Object[0]);
        }
        return this.isCounterClockWise;
    }
}
