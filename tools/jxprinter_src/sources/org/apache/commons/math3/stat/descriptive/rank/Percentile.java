package org.apache.commons.math3.stat.descriptive.rank;

import java.io.Serializable;
import java.util.Arrays;
import java.util.BitSet;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.KthSelector;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.MedianOf3PivotingStrategy;
import org.apache.commons.math3.util.PivotingStrategyInterface;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Percentile extends AbstractUnivariateStatistic implements Serializable {
    private static final int MAX_CACHED_LEVELS = 10;
    private static final int PIVOTS_HEAP_LENGTH = 512;
    private static final long serialVersionUID = -8091216485095130416L;
    private int[] cachedPivots;
    private final EstimationType estimationType;
    private final KthSelector kthSelector;
    private final NaNStrategy nanStrategy;
    private double quantile;

    /* JADX INFO: renamed from: org.apache.commons.math3.stat.descriptive.rank.Percentile$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy;

        static {
            int[] iArr = new int[NaNStrategy.values().length];
            $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy = iArr;
            try {
                iArr[NaNStrategy.MAXIMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.MINIMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum EstimationType {
        LEGACY("Legacy Apache Commons Math") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.1
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i5) {
                if (Double.compare(d, 0.0d) == 0) {
                    return 0.0d;
                }
                return Double.compare(d, 1.0d) == 0 ? i5 : d * ((double) (i5 + 1));
            }
        },
        R_1("R-1") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.2
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double estimate(double[] dArr, int[] iArr, double d, int i5, KthSelector kthSelector) {
                return super.estimate(dArr, iArr, FastMath.ceil(d - 0.5d), i5, kthSelector);
            }

            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i5) {
                if (Double.compare(d, 0.0d) == 0) {
                    return 0.0d;
                }
                return (((double) i5) * d) + 0.5d;
            }
        },
        R_2("R-2") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.3
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double estimate(double[] dArr, int[] iArr, double d, int i5, KthSelector kthSelector) {
                return (super.estimate(dArr, iArr, FastMath.ceil(d - 0.5d), i5, kthSelector) + super.estimate(dArr, iArr, FastMath.floor(d + 0.5d), i5, kthSelector)) / 2.0d;
            }

            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i5) {
                if (Double.compare(d, 1.0d) == 0) {
                    return i5;
                }
                if (Double.compare(d, 0.0d) == 0) {
                    return 0.0d;
                }
                return (((double) i5) * d) + 0.5d;
            }
        },
        R_3("R-3") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.4
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i5) {
                double d6 = i5;
                if (Double.compare(d, 0.5d / d6) <= 0) {
                    return 0.0d;
                }
                return FastMath.rint(d6 * d);
            }
        },
        R_4("R-4") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.5
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i5) {
                double d6 = i5;
                if (Double.compare(d, 1.0d / d6) < 0) {
                    return 0.0d;
                }
                return Double.compare(d, 1.0d) == 0 ? d6 : d6 * d;
            }
        },
        R_5("R-5") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.6
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i5) {
                double d6 = i5;
                double d7 = (d6 - 0.5d) / d6;
                if (Double.compare(d, 0.5d / d6) < 0) {
                    return 0.0d;
                }
                return Double.compare(d, d7) >= 0 ? d6 : (d6 * d) + 0.5d;
            }
        },
        R_6("R-6") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.7
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i5) {
                double d6 = i5 + 1;
                double d7 = i5;
                double d8 = (1.0d * d7) / d6;
                if (Double.compare(d, 1.0d / d6) < 0) {
                    return 0.0d;
                }
                return Double.compare(d, d8) >= 0 ? d7 : d6 * d;
            }
        },
        R_7("R-7") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.8
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i5) {
                if (Double.compare(d, 0.0d) == 0) {
                    return 0.0d;
                }
                return Double.compare(d, 1.0d) == 0 ? i5 : (((double) (i5 - 1)) * d) + 1.0d;
            }
        },
        R_8("R-8") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.9
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i5) {
                double d6 = i5;
                double d7 = d6 + 0.3333333333333333d;
                double d8 = (d6 - 0.3333333333333333d) / d7;
                if (Double.compare(d, 0.6666666666666666d / d7) < 0) {
                    return 0.0d;
                }
                return Double.compare(d, d8) >= 0 ? d6 : (d7 * d) + 0.3333333333333333d;
            }
        },
        R_9("R-9") { // from class: org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType.10
            @Override // org.apache.commons.math3.stat.descriptive.rank.Percentile.EstimationType
            public double index(double d, int i5) {
                double d6 = i5;
                double d7 = 0.25d + d6;
                double d8 = (d6 - 0.375d) / d7;
                if (Double.compare(d, 0.625d / d7) < 0) {
                    return 0.0d;
                }
                return Double.compare(d, d8) >= 0 ? d6 : (d7 * d) + 0.375d;
            }
        };

        private final String name;

        /* synthetic */ EstimationType(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        public double estimate(double[] dArr, int[] iArr, double d, int i5, KthSelector kthSelector) {
            double dFloor = FastMath.floor(d);
            int i6 = (int) dFloor;
            double d6 = d - dFloor;
            if (d < 1.0d) {
                return kthSelector.select(dArr, iArr, 0);
            }
            if (d >= i5) {
                return kthSelector.select(dArr, iArr, i5 - 1);
            }
            double dSelect = kthSelector.select(dArr, iArr, i6 - 1);
            return ((kthSelector.select(dArr, iArr, i6) - dSelect) * d6) + dSelect;
        }

        public double evaluate(double[] dArr, int[] iArr, double d, KthSelector kthSelector) {
            MathUtils.checkNotNull(dArr);
            if (d > 100.0d || d <= 0.0d) {
                throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUNDS_QUANTILE_VALUE, Double.valueOf(d), 0, 100);
            }
            return estimate(dArr, iArr, index(d / 100.0d, dArr.length), dArr.length, kthSelector);
        }

        public String getName() {
            return this.name;
        }

        public abstract double index(double d, int i5);

        EstimationType(String str) {
            this.name = str;
        }

        public double evaluate(double[] dArr, double d, KthSelector kthSelector) {
            return evaluate(dArr, null, d, kthSelector);
        }
    }

    public Percentile() {
        this(50.0d);
    }

    private static double[] copyOf(double[] dArr, int i5, int i6) {
        MathArrays.verifyValues(dArr, i5, i6);
        return MathArrays.copyOfRange(dArr, i5, i6 + i5);
    }

    private int[] getPivots(double[] dArr) {
        if (dArr == getDataRef()) {
            return this.cachedPivots;
        }
        int[] iArr = new int[512];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private static double[] removeAndSlice(double[] dArr, int i5, int i6, double d) {
        int i7;
        MathArrays.verifyValues(dArr, i5, i6);
        BitSet bitSet = new BitSet(i6);
        int i8 = i5;
        while (true) {
            i7 = i5 + i6;
            if (i8 >= i7) {
                break;
            }
            if (Precision.equalsIncludingNaN(d, dArr[i8])) {
                bitSet.set(i8 - i5);
            }
            i8++;
        }
        if (bitSet.isEmpty()) {
            return copyOf(dArr, i5, i6);
        }
        int iNextClearBit = 0;
        if (bitSet.cardinality() == i6) {
            return new double[0];
        }
        double[] dArr2 = new double[i6 - bitSet.cardinality()];
        int i9 = i5;
        int i10 = 0;
        while (true) {
            int iNextSetBit = bitSet.nextSetBit(iNextClearBit);
            if (iNextSetBit == -1) {
                break;
            }
            int i11 = iNextSetBit - iNextClearBit;
            System.arraycopy(dArr, i9, dArr2, i10, i11);
            i10 += i11;
            iNextClearBit = bitSet.nextClearBit(iNextSetBit);
            i9 = i5 + iNextClearBit;
        }
        if (i9 < i7) {
            System.arraycopy(dArr, i9, dArr2, i10, i7 - i9);
        }
        return dArr2;
    }

    private static double[] replaceAndSlice(double[] dArr, int i5, int i6, double d, double d6) {
        double[] dArrCopyOf = copyOf(dArr, i5, i6);
        for (int i7 = 0; i7 < i6; i7++) {
            dArrCopyOf[i7] = Precision.equalsIncludingNaN(d, dArrCopyOf[i7]) ? d6 : dArrCopyOf[i7];
        }
        return dArrCopyOf;
    }

    public double evaluate(double d) {
        return evaluate(getDataRef(), d);
    }

    public EstimationType getEstimationType() {
        return this.estimationType;
    }

    public KthSelector getKthSelector() {
        return this.kthSelector;
    }

    public NaNStrategy getNaNStrategy() {
        return this.nanStrategy;
    }

    public PivotingStrategyInterface getPivotingStrategy() {
        return this.kthSelector.getPivotingStrategy();
    }

    public double getQuantile() {
        return this.quantile;
    }

    public double[] getWorkArray(double[] dArr, int i5, int i6) {
        if (dArr == getDataRef()) {
            return getDataRef();
        }
        int i7 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[this.nanStrategy.ordinal()];
        if (i7 == 1) {
            return replaceAndSlice(dArr, i5, i6, Double.NaN, Double.POSITIVE_INFINITY);
        }
        if (i7 == 2) {
            return replaceAndSlice(dArr, i5, i6, Double.NaN, Double.NEGATIVE_INFINITY);
        }
        if (i7 == 3) {
            return removeAndSlice(dArr, i5, i6, Double.NaN);
        }
        if (i7 != 4) {
            return copyOf(dArr, i5, i6);
        }
        double[] dArrCopyOf = copyOf(dArr, i5, i6);
        MathArrays.checkNotNaN(dArrCopyOf);
        return dArrCopyOf;
    }

    @Deprecated
    public int medianOf3(double[] dArr, int i5, int i6) {
        return new MedianOf3PivotingStrategy().pivotIndex(dArr, i5, i6);
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic
    public void setData(double[] dArr) {
        if (dArr == null) {
            this.cachedPivots = null;
        } else {
            int[] iArr = new int[512];
            this.cachedPivots = iArr;
            Arrays.fill(iArr, -1);
        }
        super.setData(dArr);
    }

    public void setQuantile(double d) {
        if (d <= 0.0d || d > 100.0d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUNDS_QUANTILE_VALUE, Double.valueOf(d), 0, 100);
        }
        this.quantile = d;
    }

    public Percentile withEstimationType(EstimationType estimationType) {
        return new Percentile(this.quantile, estimationType, this.nanStrategy, this.kthSelector);
    }

    public Percentile withKthSelector(KthSelector kthSelector) {
        return new Percentile(this.quantile, this.estimationType, this.nanStrategy, kthSelector);
    }

    public Percentile withNaNStrategy(NaNStrategy naNStrategy) {
        return new Percentile(this.quantile, this.estimationType, naNStrategy, this.kthSelector);
    }

    public Percentile(double d) {
        this(d, EstimationType.LEGACY, NaNStrategy.REMOVED, new KthSelector(new MedianOf3PivotingStrategy()));
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public Percentile copy() {
        return new Percentile(this);
    }

    public double evaluate(double[] dArr, double d) {
        test(dArr, 0, 0);
        return evaluate(dArr, 0, dArr.length, d);
    }

    public Percentile(Percentile percentile) {
        MathUtils.checkNotNull(percentile);
        this.estimationType = percentile.getEstimationType();
        this.nanStrategy = percentile.getNaNStrategy();
        this.kthSelector = percentile.getKthSelector();
        setData(percentile.getDataRef());
        int[] iArr = percentile.cachedPivots;
        if (iArr != null) {
            System.arraycopy(iArr, 0, this.cachedPivots, 0, iArr.length);
        }
        setQuantile(percentile.quantile);
    }

    @Deprecated
    public static void copy(Percentile percentile, Percentile percentile2) {
        throw new MathUnsupportedOperationException();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] dArr, int i5, int i6) {
        return evaluate(dArr, i5, i6, this.quantile);
    }

    public double evaluate(double[] dArr, int i5, int i6, double d) {
        test(dArr, i5, i6);
        if (d > 100.0d || d <= 0.0d) {
            throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUNDS_QUANTILE_VALUE, Double.valueOf(d), 0, 100);
        }
        if (i6 == 0) {
            return Double.NaN;
        }
        if (i6 == 1) {
            return dArr[i5];
        }
        double[] workArray = getWorkArray(dArr, i5, i6);
        int[] pivots = getPivots(dArr);
        if (workArray.length == 0) {
            return Double.NaN;
        }
        return this.estimationType.evaluate(workArray, pivots, d, this.kthSelector);
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic
    public void setData(double[] dArr, int i5, int i6) {
        if (dArr == null) {
            this.cachedPivots = null;
        } else {
            int[] iArr = new int[512];
            this.cachedPivots = iArr;
            Arrays.fill(iArr, -1);
        }
        super.setData(dArr, i5, i6);
    }

    public Percentile(double d, EstimationType estimationType, NaNStrategy naNStrategy, KthSelector kthSelector) {
        setQuantile(d);
        this.cachedPivots = null;
        MathUtils.checkNotNull(estimationType);
        MathUtils.checkNotNull(naNStrategy);
        MathUtils.checkNotNull(kthSelector);
        this.estimationType = estimationType;
        this.nanStrategy = naNStrategy;
        this.kthSelector = kthSelector;
    }
}
