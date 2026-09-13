package org.apache.commons.math3.filter;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultProcessModel implements ProcessModel {
    private RealMatrix controlMatrix;
    private RealMatrix initialErrorCovMatrix;
    private RealVector initialStateEstimateVector;
    private RealMatrix processNoiseCovMatrix;
    private RealMatrix stateTransitionMatrix;

    public DefaultProcessModel(double[][] dArr, double[][] dArr2, double[][] dArr3, double[] dArr4, double[][] dArr5) {
        this(new Array2DRowRealMatrix(dArr), new Array2DRowRealMatrix(dArr2), new Array2DRowRealMatrix(dArr3), new ArrayRealVector(dArr4), new Array2DRowRealMatrix(dArr5));
    }

    @Override // org.apache.commons.math3.filter.ProcessModel
    public RealMatrix getControlMatrix() {
        return this.controlMatrix;
    }

    @Override // org.apache.commons.math3.filter.ProcessModel
    public RealMatrix getInitialErrorCovariance() {
        return this.initialErrorCovMatrix;
    }

    @Override // org.apache.commons.math3.filter.ProcessModel
    public RealVector getInitialStateEstimate() {
        return this.initialStateEstimateVector;
    }

    @Override // org.apache.commons.math3.filter.ProcessModel
    public RealMatrix getProcessNoise() {
        return this.processNoiseCovMatrix;
    }

    @Override // org.apache.commons.math3.filter.ProcessModel
    public RealMatrix getStateTransitionMatrix() {
        return this.stateTransitionMatrix;
    }

    public DefaultProcessModel(double[][] dArr, double[][] dArr2, double[][] dArr3) {
        this(new Array2DRowRealMatrix(dArr), new Array2DRowRealMatrix(dArr2), new Array2DRowRealMatrix(dArr3), (RealVector) null, (RealMatrix) null);
    }

    public DefaultProcessModel(RealMatrix realMatrix, RealMatrix realMatrix2, RealMatrix realMatrix3, RealVector realVector, RealMatrix realMatrix4) {
        this.stateTransitionMatrix = realMatrix;
        this.controlMatrix = realMatrix2;
        this.processNoiseCovMatrix = realMatrix3;
        this.initialStateEstimateVector = realVector;
        this.initialErrorCovMatrix = realMatrix4;
    }
}
