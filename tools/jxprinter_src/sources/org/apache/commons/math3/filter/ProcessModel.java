package org.apache.commons.math3.filter;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ProcessModel {
    RealMatrix getControlMatrix();

    RealMatrix getInitialErrorCovariance();

    RealVector getInitialStateEstimate();

    RealMatrix getProcessNoise();

    RealMatrix getStateTransitionMatrix();
}
