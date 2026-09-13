package org.apache.commons.math3.stat.descriptive.rank;

import java.io.Serializable;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.apache.commons.math3.util.KthSelector;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Median extends Percentile implements Serializable {
    private static final double FIXED_QUANTILE_50 = 50.0d;
    private static final long serialVersionUID = -3961477041290915687L;

    public Median() {
        super(FIXED_QUANTILE_50);
    }

    public Median(Median median) {
        super(median);
    }

    @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile
    public Median withEstimationType(Percentile.EstimationType estimationType) {
        return new Median(estimationType, getNaNStrategy(), getKthSelector());
    }

    @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile
    public Median withKthSelector(KthSelector kthSelector) {
        return new Median(getEstimationType(), getNaNStrategy(), kthSelector);
    }

    @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile
    public Median withNaNStrategy(NaNStrategy naNStrategy) {
        return new Median(getEstimationType(), naNStrategy, getKthSelector());
    }

    private Median(Percentile.EstimationType estimationType, NaNStrategy naNStrategy, KthSelector kthSelector) {
        super(FIXED_QUANTILE_50, estimationType, naNStrategy, kthSelector);
    }
}
