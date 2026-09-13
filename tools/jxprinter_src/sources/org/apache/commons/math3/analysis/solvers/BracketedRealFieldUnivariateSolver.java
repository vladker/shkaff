package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.analysis.RealFieldUnivariateFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface BracketedRealFieldUnivariateSolver<T extends RealFieldElement<T>> {
    T getAbsoluteAccuracy();

    int getEvaluations();

    T getFunctionValueAccuracy();

    int getMaxEvaluations();

    T getRelativeAccuracy();

    T solve(int i5, RealFieldUnivariateFunction<T> realFieldUnivariateFunction, T t6, T t7, T t8, AllowedSolution allowedSolution);

    T solve(int i5, RealFieldUnivariateFunction<T> realFieldUnivariateFunction, T t6, T t7, AllowedSolution allowedSolution);
}
