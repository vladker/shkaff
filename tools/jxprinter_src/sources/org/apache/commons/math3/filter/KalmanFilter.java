package org.apache.commons.math3.filter;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.CholeskyDecomposition;
import org.apache.commons.math3.linear.MatrixDimensionMismatchException;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.NonSquareMatrixException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class KalmanFilter {
    private RealMatrix controlMatrix;
    private RealMatrix errorCovariance;
    private RealMatrix measurementMatrix;
    private RealMatrix measurementMatrixT;
    private final MeasurementModel measurementModel;
    private final ProcessModel processModel;
    private RealVector stateEstimation;
    private RealMatrix transitionMatrix;
    private RealMatrix transitionMatrixT;

    public KalmanFilter(ProcessModel processModel, MeasurementModel measurementModel) {
        MathUtils.checkNotNull(processModel);
        MathUtils.checkNotNull(measurementModel);
        this.processModel = processModel;
        this.measurementModel = measurementModel;
        RealMatrix stateTransitionMatrix = processModel.getStateTransitionMatrix();
        this.transitionMatrix = stateTransitionMatrix;
        MathUtils.checkNotNull(stateTransitionMatrix);
        this.transitionMatrixT = this.transitionMatrix.transpose();
        if (processModel.getControlMatrix() == null) {
            this.controlMatrix = new Array2DRowRealMatrix();
        } else {
            this.controlMatrix = processModel.getControlMatrix();
        }
        RealMatrix measurementMatrix = measurementModel.getMeasurementMatrix();
        this.measurementMatrix = measurementMatrix;
        MathUtils.checkNotNull(measurementMatrix);
        this.measurementMatrixT = this.measurementMatrix.transpose();
        RealMatrix processNoise = processModel.getProcessNoise();
        MathUtils.checkNotNull(processNoise);
        RealMatrix measurementNoise = measurementModel.getMeasurementNoise();
        MathUtils.checkNotNull(measurementNoise);
        if (processModel.getInitialStateEstimate() == null) {
            this.stateEstimation = new ArrayRealVector(this.transitionMatrix.getColumnDimension());
        } else {
            this.stateEstimation = processModel.getInitialStateEstimate();
        }
        if (this.transitionMatrix.getColumnDimension() != this.stateEstimation.getDimension()) {
            throw new DimensionMismatchException(this.transitionMatrix.getColumnDimension(), this.stateEstimation.getDimension());
        }
        if (processModel.getInitialErrorCovariance() == null) {
            this.errorCovariance = processNoise.copy();
        } else {
            this.errorCovariance = processModel.getInitialErrorCovariance();
        }
        if (!this.transitionMatrix.isSquare()) {
            throw new NonSquareMatrixException(this.transitionMatrix.getRowDimension(), this.transitionMatrix.getColumnDimension());
        }
        RealMatrix realMatrix = this.controlMatrix;
        if (realMatrix != null && realMatrix.getRowDimension() > 0 && this.controlMatrix.getColumnDimension() > 0 && this.controlMatrix.getRowDimension() != this.transitionMatrix.getRowDimension()) {
            throw new MatrixDimensionMismatchException(this.controlMatrix.getRowDimension(), this.controlMatrix.getColumnDimension(), this.transitionMatrix.getRowDimension(), this.controlMatrix.getColumnDimension());
        }
        MatrixUtils.checkAdditionCompatible(this.transitionMatrix, processNoise);
        if (this.measurementMatrix.getColumnDimension() != this.transitionMatrix.getRowDimension()) {
            throw new MatrixDimensionMismatchException(this.measurementMatrix.getRowDimension(), this.measurementMatrix.getColumnDimension(), this.measurementMatrix.getRowDimension(), this.transitionMatrix.getRowDimension());
        }
        if (measurementNoise.getRowDimension() != this.measurementMatrix.getRowDimension()) {
            throw new MatrixDimensionMismatchException(measurementNoise.getRowDimension(), measurementNoise.getColumnDimension(), this.measurementMatrix.getRowDimension(), measurementNoise.getColumnDimension());
        }
    }

    public void correct(double[] dArr) {
        correct(new ArrayRealVector(dArr, false));
    }

    public double[][] getErrorCovariance() {
        return this.errorCovariance.getData();
    }

    public RealMatrix getErrorCovarianceMatrix() {
        return this.errorCovariance.copy();
    }

    public int getMeasurementDimension() {
        return this.measurementMatrix.getRowDimension();
    }

    public int getStateDimension() {
        return this.stateEstimation.getDimension();
    }

    public double[] getStateEstimation() {
        return this.stateEstimation.toArray();
    }

    public RealVector getStateEstimationVector() {
        return this.stateEstimation.copy();
    }

    public void predict() {
        predict((RealVector) null);
    }

    public void correct(RealVector realVector) {
        MathUtils.checkNotNull(realVector);
        if (realVector.getDimension() != this.measurementMatrix.getRowDimension()) {
            throw new DimensionMismatchException(realVector.getDimension(), this.measurementMatrix.getRowDimension());
        }
        RealMatrix realMatrixAdd = this.measurementMatrix.multiply(this.errorCovariance).multiply(this.measurementMatrixT).add(this.measurementModel.getMeasurementNoise());
        RealVector realVectorSubtract = realVector.subtract(this.measurementMatrix.operate(this.stateEstimation));
        RealMatrix realMatrixTranspose = new CholeskyDecomposition(realMatrixAdd).getSolver().solve(this.measurementMatrix.multiply(this.errorCovariance.transpose())).transpose();
        this.stateEstimation = this.stateEstimation.add(realMatrixTranspose.operate(realVectorSubtract));
        this.errorCovariance = MatrixUtils.createRealIdentityMatrix(realMatrixTranspose.getRowDimension()).subtract(realMatrixTranspose.multiply(this.measurementMatrix)).multiply(this.errorCovariance);
    }

    public void predict(double[] dArr) {
        predict(new ArrayRealVector(dArr, false));
    }

    public void predict(RealVector realVector) {
        if (realVector != null && realVector.getDimension() != this.controlMatrix.getColumnDimension()) {
            throw new DimensionMismatchException(realVector.getDimension(), this.controlMatrix.getColumnDimension());
        }
        RealVector realVectorOperate = this.transitionMatrix.operate(this.stateEstimation);
        this.stateEstimation = realVectorOperate;
        if (realVector != null) {
            this.stateEstimation = realVectorOperate.add(this.controlMatrix.operate(realVector));
        }
        this.errorCovariance = this.transitionMatrix.multiply(this.errorCovariance).multiply(this.transitionMatrixT).add(this.processModel.getProcessNoise());
    }
}
