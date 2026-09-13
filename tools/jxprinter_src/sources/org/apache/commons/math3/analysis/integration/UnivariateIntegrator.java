package org.apache.commons.math3.analysis.integration;

import org.apache.commons.math3.analysis.UnivariateFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface UnivariateIntegrator {
    double getAbsoluteAccuracy();

    int getEvaluations();

    int getIterations();

    int getMaximalIterationCount();

    int getMinimalIterationCount();

    double getRelativeAccuracy();

    double integrate(int i5, UnivariateFunction univariateFunction, double d, double d6);
}
