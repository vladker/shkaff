package org.apache.commons.math3.fitting.leastsquares;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optim.OptimizationProblem;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface LeastSquaresProblem extends OptimizationProblem<Evaluation> {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Evaluation {
        double getCost();

        RealMatrix getCovariances(double d);

        RealMatrix getJacobian();

        RealVector getPoint();

        double getRMS();

        RealVector getResiduals();

        RealVector getSigma(double d);
    }

    Evaluation evaluate(RealVector realVector);

    int getObservationSize();

    int getParameterSize();

    RealVector getStart();
}
