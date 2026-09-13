package org.apache.commons.math3.distribution;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MixtureMultivariateNormalDistribution extends MixtureMultivariateRealDistribution<MultivariateNormalDistribution> {
    public MixtureMultivariateNormalDistribution(double[] dArr, double[][] dArr2, double[][][] dArr3) {
        super(createComponents(dArr, dArr2, dArr3));
    }

    private static List<Pair<Double, MultivariateNormalDistribution>> createComponents(double[] dArr, double[][] dArr2, double[][][] dArr3) {
        ArrayList arrayList = new ArrayList(dArr.length);
        for (int i5 = 0; i5 < dArr.length; i5++) {
            arrayList.add(new Pair(Double.valueOf(dArr[i5]), new MultivariateNormalDistribution(dArr2[i5], dArr3[i5])));
        }
        return arrayList;
    }

    public MixtureMultivariateNormalDistribution(List<Pair<Double, MultivariateNormalDistribution>> list) {
        super(list);
    }

    public MixtureMultivariateNormalDistribution(RandomGenerator randomGenerator, List<Pair<Double, MultivariateNormalDistribution>> list) {
        super(randomGenerator, list);
    }
}
