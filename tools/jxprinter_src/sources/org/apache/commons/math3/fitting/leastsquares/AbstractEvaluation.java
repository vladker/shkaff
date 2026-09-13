package org.apache.commons.math3.fitting.leastsquares;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractEvaluation implements LeastSquaresProblem.Evaluation {
    private final int observationSize;

    public AbstractEvaluation(int i5) {
        this.observationSize = i5;
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public double getCost() {
        RealVector arrayRealVector = new ArrayRealVector(getResiduals());
        return FastMath.sqrt(arrayRealVector.dotProduct(arrayRealVector));
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public RealMatrix getCovariances(double d) {
        RealMatrix jacobian = getJacobian();
        return new QRDecomposition(jacobian.transpose().multiply(jacobian), d).getSolver().getInverse();
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public double getRMS() {
        double cost = getCost();
        return FastMath.sqrt((cost * cost) / ((double) this.observationSize));
    }

    @Override // org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation
    public RealVector getSigma(double d) {
        RealMatrix covariances = getCovariances(d);
        int columnDimension = covariances.getColumnDimension();
        ArrayRealVector arrayRealVector = new ArrayRealVector(columnDimension);
        for (int i5 = 0; i5 < columnDimension; i5++) {
            arrayRealVector.setEntry(i5, FastMath.sqrt(covariances.getEntry(i5, i5)));
        }
        return arrayRealVector;
    }
}
