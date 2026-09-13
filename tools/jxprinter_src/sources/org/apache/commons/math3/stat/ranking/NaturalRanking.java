package org.apache.commons.math3.stat.ranking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class NaturalRanking implements RankingAlgorithm {
    public static final NaNStrategy DEFAULT_NAN_STRATEGY = NaNStrategy.FAILED;
    public static final TiesStrategy DEFAULT_TIES_STRATEGY = TiesStrategy.AVERAGE;
    private final NaNStrategy nanStrategy;
    private final RandomDataGenerator randomData;
    private final TiesStrategy tiesStrategy;

    /* JADX INFO: renamed from: org.apache.commons.math3.stat.ranking.NaturalRanking$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy;
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$stat$ranking$TiesStrategy;

        static {
            int[] iArr = new int[TiesStrategy.values().length];
            $SwitchMap$org$apache$commons$math3$stat$ranking$TiesStrategy = iArr;
            try {
                iArr[TiesStrategy.AVERAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$ranking$TiesStrategy[TiesStrategy.MAXIMUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$ranking$TiesStrategy[TiesStrategy.MINIMUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$ranking$TiesStrategy[TiesStrategy.RANDOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$ranking$TiesStrategy[TiesStrategy.SEQUENTIAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[NaNStrategy.values().length];
            $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy = iArr2;
            try {
                iArr2[NaNStrategy.MAXIMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.MINIMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.FIXED.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[NaNStrategy.FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class IntDoublePair implements Comparable<IntDoublePair> {
        private final int position;
        private final double value;

        public IntDoublePair(double d, int i5) {
            this.value = d;
            this.position = i5;
        }

        public int getPosition() {
            return this.position;
        }

        public double getValue() {
            return this.value;
        }

        @Override // java.lang.Comparable
        public int compareTo(IntDoublePair intDoublePair) {
            return Double.compare(this.value, intDoublePair.value);
        }
    }

    public NaturalRanking() {
        this.tiesStrategy = DEFAULT_TIES_STRATEGY;
        this.nanStrategy = DEFAULT_NAN_STRATEGY;
        this.randomData = null;
    }

    private boolean containsNaNs(IntDoublePair[] intDoublePairArr) {
        for (IntDoublePair intDoublePair : intDoublePairArr) {
            if (Double.isNaN(intDoublePair.getValue())) {
                return true;
            }
        }
        return false;
    }

    private void fill(double[] dArr, List<Integer> list, double d) {
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            dArr[it.next().intValue()] = d;
        }
    }

    private List<Integer> getNanPositions(IntDoublePair[] intDoublePairArr) {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < intDoublePairArr.length; i5++) {
            if (Double.isNaN(intDoublePairArr[i5].getValue())) {
                arrayList.add(Integer.valueOf(i5));
            }
        }
        return arrayList;
    }

    private void recodeNaNs(IntDoublePair[] intDoublePairArr, double d) {
        for (int i5 = 0; i5 < intDoublePairArr.length; i5++) {
            if (Double.isNaN(intDoublePairArr[i5].getValue())) {
                intDoublePairArr[i5] = new IntDoublePair(d, intDoublePairArr[i5].getPosition());
            }
        }
    }

    private IntDoublePair[] removeNaNs(IntDoublePair[] intDoublePairArr) {
        if (!containsNaNs(intDoublePairArr)) {
            return intDoublePairArr;
        }
        IntDoublePair[] intDoublePairArr2 = new IntDoublePair[intDoublePairArr.length];
        int i5 = 0;
        for (int i6 = 0; i6 < intDoublePairArr.length; i6++) {
            if (Double.isNaN(intDoublePairArr[i6].getValue())) {
                for (int i7 = i6 + 1; i7 < intDoublePairArr.length; i7++) {
                    intDoublePairArr[i7] = new IntDoublePair(intDoublePairArr[i7].getValue(), intDoublePairArr[i7].getPosition() - 1);
                }
            } else {
                intDoublePairArr2[i5] = new IntDoublePair(intDoublePairArr[i6].getValue(), intDoublePairArr[i6].getPosition());
                i5++;
            }
        }
        IntDoublePair[] intDoublePairArr3 = new IntDoublePair[i5];
        System.arraycopy(intDoublePairArr2, 0, intDoublePairArr3, 0, i5);
        return intDoublePairArr3;
    }

    private void resolveTie(double[] dArr, List<Integer> list) {
        int i5 = 0;
        double d = dArr[list.get(0).intValue()];
        int size = list.size();
        int i6 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$stat$ranking$TiesStrategy[this.tiesStrategy.ordinal()];
        if (i6 == 1) {
            fill(dArr, list, (((d * 2.0d) + ((double) size)) - 1.0d) / 2.0d);
            return;
        }
        if (i6 == 2) {
            fill(dArr, list, (d + ((double) size)) - 1.0d);
            return;
        }
        if (i6 == 3) {
            fill(dArr, list, d);
            return;
        }
        if (i6 == 4) {
            Iterator<Integer> it = list.iterator();
            long jRound = FastMath.round(d);
            while (it.hasNext()) {
                dArr[it.next().intValue()] = this.randomData.nextLong(jRound, (((long) size) + jRound) - 1);
            }
            return;
        }
        if (i6 != 5) {
            throw new MathInternalError();
        }
        Iterator<Integer> it2 = list.iterator();
        long jRound2 = FastMath.round(d);
        while (it2.hasNext()) {
            dArr[it2.next().intValue()] = ((long) i5) + jRound2;
            i5++;
        }
    }

    private void restoreNaNs(double[] dArr, List<Integer> list) {
        if (list.size() == 0) {
            return;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            dArr[it.next().intValue()] = Double.NaN;
        }
    }

    public NaNStrategy getNanStrategy() {
        return this.nanStrategy;
    }

    public TiesStrategy getTiesStrategy() {
        return this.tiesStrategy;
    }

    @Override // org.apache.commons.math3.stat.ranking.RankingAlgorithm
    public double[] rank(double[] dArr) {
        IntDoublePair[] intDoublePairArrRemoveNaNs = new IntDoublePair[dArr.length];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            intDoublePairArrRemoveNaNs[i5] = new IntDoublePair(dArr[i5], i5);
        }
        int i6 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$stat$ranking$NaNStrategy[this.nanStrategy.ordinal()];
        List<Integer> nanPositions = null;
        if (i6 == 1) {
            recodeNaNs(intDoublePairArrRemoveNaNs, Double.POSITIVE_INFINITY);
        } else if (i6 == 2) {
            recodeNaNs(intDoublePairArrRemoveNaNs, Double.NEGATIVE_INFINITY);
        } else if (i6 == 3) {
            intDoublePairArrRemoveNaNs = removeNaNs(intDoublePairArrRemoveNaNs);
        } else if (i6 == 4) {
            nanPositions = getNanPositions(intDoublePairArrRemoveNaNs);
        } else {
            if (i6 != 5) {
                throw new MathInternalError();
            }
            nanPositions = getNanPositions(intDoublePairArrRemoveNaNs);
            if (nanPositions.size() > 0) {
                throw new NotANumberException();
            }
        }
        Arrays.sort(intDoublePairArrRemoveNaNs);
        double[] dArr2 = new double[intDoublePairArrRemoveNaNs.length];
        dArr2[intDoublePairArrRemoveNaNs[0].getPosition()] = 1;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(intDoublePairArrRemoveNaNs[0].getPosition()));
        int i7 = 1;
        for (int i8 = 1; i8 < intDoublePairArrRemoveNaNs.length; i8++) {
            if (Double.compare(intDoublePairArrRemoveNaNs[i8].getValue(), intDoublePairArrRemoveNaNs[i8 - 1].getValue()) > 0) {
                i7 = i8 + 1;
                if (arrayList.size() > 1) {
                    resolveTie(dArr2, arrayList);
                }
                arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(intDoublePairArrRemoveNaNs[i8].getPosition()));
            } else {
                arrayList.add(Integer.valueOf(intDoublePairArrRemoveNaNs[i8].getPosition()));
            }
            dArr2[intDoublePairArrRemoveNaNs[i8].getPosition()] = i7;
        }
        if (arrayList.size() > 1) {
            resolveTie(dArr2, arrayList);
        }
        if (this.nanStrategy == NaNStrategy.FIXED) {
            restoreNaNs(dArr2, nanPositions);
        }
        return dArr2;
    }

    public NaturalRanking(TiesStrategy tiesStrategy) {
        this.tiesStrategy = tiesStrategy;
        this.nanStrategy = DEFAULT_NAN_STRATEGY;
        this.randomData = new RandomDataGenerator();
    }

    public NaturalRanking(NaNStrategy naNStrategy) {
        this.nanStrategy = naNStrategy;
        this.tiesStrategy = DEFAULT_TIES_STRATEGY;
        this.randomData = null;
    }

    public NaturalRanking(NaNStrategy naNStrategy, TiesStrategy tiesStrategy) {
        this.nanStrategy = naNStrategy;
        this.tiesStrategy = tiesStrategy;
        this.randomData = new RandomDataGenerator();
    }

    public NaturalRanking(RandomGenerator randomGenerator) {
        this.tiesStrategy = TiesStrategy.RANDOM;
        this.nanStrategy = DEFAULT_NAN_STRATEGY;
        this.randomData = new RandomDataGenerator(randomGenerator);
    }

    public NaturalRanking(NaNStrategy naNStrategy, RandomGenerator randomGenerator) {
        this.nanStrategy = naNStrategy;
        this.tiesStrategy = TiesStrategy.RANDOM;
        this.randomData = new RandomDataGenerator(randomGenerator);
    }
}
