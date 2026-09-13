package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface UnivariateStatistic extends MathArrays.Function {
    UnivariateStatistic copy();

    @Override // org.apache.commons.math3.util.MathArrays.Function
    double evaluate(double[] dArr);

    @Override // org.apache.commons.math3.util.MathArrays.Function
    double evaluate(double[] dArr, int i5, int i6);
}
