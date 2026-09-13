package org.apache.commons.math3.optimization;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class InitialGuess implements OptimizationData {
    private final double[] init;

    public InitialGuess(double[] dArr) {
        this.init = (double[]) dArr.clone();
    }

    public double[] getInitialGuess() {
        return (double[]) this.init.clone();
    }
}
