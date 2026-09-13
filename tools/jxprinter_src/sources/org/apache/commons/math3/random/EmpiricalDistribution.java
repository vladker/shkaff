package org.apache.commons.math3.random;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.AbstractRealDistribution;
import org.apache.commons.math3.distribution.ConstantRealDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EmpiricalDistribution extends AbstractRealDistribution {
    public static final int DEFAULT_BIN_COUNT = 1000;
    private static final String FILE_CHARSET = "US-ASCII";
    private static final long serialVersionUID = 5729073523949762654L;
    private final int binCount;
    private final List<SummaryStatistics> binStats;
    private double delta;
    private boolean loaded;
    private double max;
    private double min;
    protected final RandomDataGenerator randomData;
    private SummaryStatistics sampleStats;
    private double[] upperBounds;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class ArrayDataAdapter extends DataAdapter {
        private double[] inputArray;

        public ArrayDataAdapter(double[] dArr) {
            super();
            MathUtils.checkNotNull(dArr);
            this.inputArray = dArr;
        }

        @Override // org.apache.commons.math3.random.EmpiricalDistribution.DataAdapter
        public void computeBinStats() {
            for (int i5 = 0; i5 < this.inputArray.length; i5++) {
                ((SummaryStatistics) EmpiricalDistribution.this.binStats.get(EmpiricalDistribution.this.findBin(this.inputArray[i5]))).addValue(this.inputArray[i5]);
            }
        }

        @Override // org.apache.commons.math3.random.EmpiricalDistribution.DataAdapter
        public void computeStats() {
            EmpiricalDistribution.this.sampleStats = new SummaryStatistics();
            for (int i5 = 0; i5 < this.inputArray.length; i5++) {
                EmpiricalDistribution.this.sampleStats.addValue(this.inputArray[i5]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public abstract class DataAdapter {
        private DataAdapter() {
        }

        public abstract void computeBinStats();

        public abstract void computeStats();
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class StreamDataAdapter extends DataAdapter {
        private BufferedReader inputStream;

        public StreamDataAdapter(BufferedReader bufferedReader) {
            super();
            this.inputStream = bufferedReader;
        }

        @Override // org.apache.commons.math3.random.EmpiricalDistribution.DataAdapter
        public void computeBinStats() throws IOException {
            while (true) {
                String line = this.inputStream.readLine();
                if (line == null) {
                    this.inputStream.close();
                    this.inputStream = null;
                    return;
                } else {
                    double d = Double.parseDouble(line);
                    ((SummaryStatistics) EmpiricalDistribution.this.binStats.get(EmpiricalDistribution.this.findBin(d))).addValue(d);
                }
            }
        }

        @Override // org.apache.commons.math3.random.EmpiricalDistribution.DataAdapter
        public void computeStats() throws IOException {
            EmpiricalDistribution.this.sampleStats = new SummaryStatistics();
            while (true) {
                String line = this.inputStream.readLine();
                if (line == null) {
                    this.inputStream.close();
                    this.inputStream = null;
                    return;
                } else {
                    EmpiricalDistribution.this.sampleStats.addValue(Double.parseDouble(line));
                }
            }
        }
    }

    public EmpiricalDistribution() {
        this(1000);
    }

    private double cumBinP(int i5) {
        return this.upperBounds[i5];
    }

    private void fillBinStats(DataAdapter dataAdapter) {
        this.min = this.sampleStats.getMin();
        double max = this.sampleStats.getMax();
        this.max = max;
        this.delta = (max - this.min) / ((double) this.binCount);
        if (!this.binStats.isEmpty()) {
            this.binStats.clear();
        }
        for (int i5 = 0; i5 < this.binCount; i5++) {
            this.binStats.add(i5, new SummaryStatistics());
        }
        dataAdapter.computeBinStats();
        double[] dArr = new double[this.binCount];
        this.upperBounds = dArr;
        dArr[0] = this.binStats.get(0).getN() / this.sampleStats.getN();
        int i6 = 1;
        while (true) {
            int i7 = this.binCount;
            if (i6 >= i7 - 1) {
                this.upperBounds[i7 - 1] = 1.0d;
                return;
            }
            double[] dArr2 = this.upperBounds;
            dArr2[i6] = (this.binStats.get(i6).getN() / this.sampleStats.getN()) + dArr2[i6 - 1];
            i6++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findBin(double d) {
        return FastMath.min(FastMath.max(((int) FastMath.ceil((d - this.min) / this.delta)) - 1, 0), this.binCount - 1);
    }

    private RealDistribution k(double d) {
        return getKernel(this.binStats.get(findBin(d)));
    }

    private double kB(int i5) {
        double d;
        double d6;
        double[] upperBounds = getUpperBounds();
        RealDistribution kernel = getKernel(this.binStats.get(i5));
        if (i5 == 0) {
            d = this.min;
            d6 = upperBounds[0];
        } else {
            d = upperBounds[i5 - 1];
            d6 = upperBounds[i5];
        }
        return kernel.cumulativeProbability(d, d6);
    }

    private double pB(int i5) {
        if (i5 == 0) {
            return this.upperBounds[0];
        }
        double[] dArr = this.upperBounds;
        return dArr[i5] - dArr[i5 - 1];
    }

    private double pBminus(int i5) {
        if (i5 == 0) {
            return 0.0d;
        }
        return this.upperBounds[i5 - 1];
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double cumulativeProbability(double d) {
        if (d < this.min) {
            return 0.0d;
        }
        if (d >= this.max) {
            return 1.0d;
        }
        int iFindBin = findBin(d);
        double dPBminus = pBminus(iFindBin);
        double dPB = pB(iFindBin);
        RealDistribution realDistributionK = k(d);
        if (realDistributionK instanceof ConstantRealDistribution) {
            return d < realDistributionK.getNumericalMean() ? dPBminus : dPBminus + dPB;
        }
        return (((realDistributionK.cumulativeProbability(d) - realDistributionK.cumulativeProbability(iFindBin == 0 ? this.min : getUpperBounds()[iFindBin - 1])) / kB(iFindBin)) * dPB) + dPBminus;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double density(double d) {
        if (d < this.min || d > this.max) {
            return 0.0d;
        }
        int iFindBin = findBin(d);
        return (getKernel(this.binStats.get(iFindBin)).density(d) * pB(iFindBin)) / kB(iFindBin);
    }

    public int getBinCount() {
        return this.binCount;
    }

    public List<SummaryStatistics> getBinStats() {
        return this.binStats;
    }

    public double[] getGeneratorUpperBounds() {
        double[] dArr = this.upperBounds;
        int length = dArr.length;
        double[] dArr2 = new double[length];
        System.arraycopy(dArr, 0, dArr2, 0, length);
        return dArr2;
    }

    public RealDistribution getKernel(SummaryStatistics summaryStatistics) {
        return (summaryStatistics.getN() == 1 || summaryStatistics.getVariance() == 0.0d) ? new ConstantRealDistribution(summaryStatistics.getMean()) : new NormalDistribution(this.randomData.getRandomGenerator(), summaryStatistics.getMean(), summaryStatistics.getStandardDeviation(), 1.0E-9d);
    }

    public double getNextValue() {
        if (this.loaded) {
            return sample();
        }
        throw new MathIllegalStateException(LocalizedFormats.DISTRIBUTION_NOT_LOADED, new Object[0]);
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalMean() {
        return this.sampleStats.getMean();
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getNumericalVariance() {
        return this.sampleStats.getVariance();
    }

    public StatisticalSummary getSampleStats() {
        return this.sampleStats;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportLowerBound() {
        return this.min;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public double getSupportUpperBound() {
        return this.max;
    }

    public double[] getUpperBounds() {
        double[] dArr = new double[this.binCount];
        int i5 = 0;
        while (true) {
            int i6 = this.binCount;
            if (i5 >= i6 - 1) {
                dArr[i6 - 1] = this.max;
                return dArr;
            }
            int i7 = i5 + 1;
            dArr[i5] = (this.delta * ((double) i7)) + this.min;
            i5 = i7;
        }
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double inverseCumulativeProbability(double d) {
        int i5 = 0;
        if (d < 0.0d || d > 1.0d) {
            throw new OutOfRangeException(Double.valueOf(d), 0, 1);
        }
        if (d == 0.0d) {
            return getSupportLowerBound();
        }
        if (d == 1.0d) {
            return getSupportUpperBound();
        }
        while (cumBinP(i5) < d) {
            i5++;
        }
        RealDistribution kernel = getKernel(this.binStats.get(i5));
        double dKB = kB(i5);
        double d6 = i5 == 0 ? this.min : getUpperBounds()[i5 - 1];
        double dCumulativeProbability = kernel.cumulativeProbability(d6);
        double dPB = pB(i5);
        double dPBminus = d - pBminus(i5);
        return dPBminus <= 0.0d ? d6 : kernel.inverseCumulativeProbability(((dPBminus * dKB) / dPB) + dCumulativeProbability);
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportConnected() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportLowerBoundInclusive() {
        return true;
    }

    @Override // org.apache.commons.math3.distribution.RealDistribution
    public boolean isSupportUpperBoundInclusive() {
        return true;
    }

    public void load(double[] dArr) {
        try {
            new ArrayDataAdapter(dArr).computeStats();
            fillBinStats(new ArrayDataAdapter(dArr));
            this.loaded = true;
        } catch (IOException unused) {
            throw new MathInternalError();
        }
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public double probability(double d) {
        return 0.0d;
    }

    public void reSeed(long j6) {
        this.randomData.reSeed(j6);
    }

    @Override // org.apache.commons.math3.distribution.AbstractRealDistribution, org.apache.commons.math3.distribution.RealDistribution
    public void reseedRandomGenerator(long j6) {
        this.randomData.reSeed(j6);
    }

    public EmpiricalDistribution(int i5) {
        this(i5, new RandomDataGenerator());
    }

    public EmpiricalDistribution(int i5, RandomGenerator randomGenerator) {
        this(i5, new RandomDataGenerator(randomGenerator));
    }

    public EmpiricalDistribution(RandomGenerator randomGenerator) {
        this(1000, randomGenerator);
    }

    @Deprecated
    public EmpiricalDistribution(int i5, RandomDataImpl randomDataImpl) {
        this(i5, randomDataImpl.getDelegate());
    }

    @Deprecated
    public EmpiricalDistribution(RandomDataImpl randomDataImpl) {
        this(1000, randomDataImpl);
    }

    public void load(URL url) throws Throwable {
        MathUtils.checkNotNull(url);
        Charset charsetForName = Charset.forName("US-ASCII");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), charsetForName));
        try {
            new StreamDataAdapter(bufferedReader).computeStats();
            if (this.sampleStats.getN() != 0) {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(url.openStream(), charsetForName));
                try {
                    fillBinStats(new StreamDataAdapter(bufferedReader2));
                    this.loaded = true;
                    try {
                        bufferedReader2.close();
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                    throw th;
                }
            }
            throw new ZeroException(LocalizedFormats.URL_CONTAINS_NO_DATA, url);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private EmpiricalDistribution(int i5, RandomDataGenerator randomDataGenerator) {
        super(randomDataGenerator.getRandomGenerator());
        this.sampleStats = null;
        this.max = Double.NEGATIVE_INFINITY;
        this.min = Double.POSITIVE_INFINITY;
        this.delta = 0.0d;
        this.loaded = false;
        this.upperBounds = null;
        if (i5 > 0) {
            this.binCount = i5;
            this.randomData = randomDataGenerator;
            this.binStats = new ArrayList();
            return;
        }
        throw new NotStrictlyPositiveException(Integer.valueOf(i5));
    }

    public void load(File file) throws Throwable {
        MathUtils.checkNotNull(file);
        Charset charsetForName = Charset.forName("US-ASCII");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charsetForName));
        try {
            new StreamDataAdapter(bufferedReader).computeStats();
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), charsetForName));
            try {
                fillBinStats(new StreamDataAdapter(bufferedReader2));
                this.loaded = true;
                try {
                    bufferedReader2.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
