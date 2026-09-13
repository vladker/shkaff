package org.apache.commons.math3.stat.descriptive.moment;

import java.io.Serializable;
import org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SemiVariance extends AbstractUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = -2653430366886024994L;
    private boolean biasCorrected;
    private Direction varianceDirection;
    public static final Direction UPSIDE_VARIANCE = Direction.UPSIDE;
    public static final Direction DOWNSIDE_VARIANCE = Direction.DOWNSIDE;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Direction {
        UPSIDE(true),
        DOWNSIDE(false);

        private boolean direction;

        Direction(boolean z6) {
            this.direction = z6;
        }

        public boolean getDirection() {
            return this.direction;
        }
    }

    public SemiVariance() {
        this.biasCorrected = true;
        this.varianceDirection = Direction.DOWNSIDE;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] dArr, int i5, int i6) {
        return evaluate(dArr, new Mean().evaluate(dArr, i5, i6), this.varianceDirection, this.biasCorrected, 0, dArr.length);
    }

    public Direction getVarianceDirection() {
        return this.varianceDirection;
    }

    public boolean isBiasCorrected() {
        return this.biasCorrected;
    }

    public void setBiasCorrected(boolean z6) {
        this.biasCorrected = z6;
    }

    public void setVarianceDirection(Direction direction) {
        this.varianceDirection = direction;
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public SemiVariance copy() {
        SemiVariance semiVariance = new SemiVariance();
        copy(this, semiVariance);
        return semiVariance;
    }

    public double evaluate(double[] dArr, Direction direction) {
        return evaluate(dArr, new Mean().evaluate(dArr), direction, this.biasCorrected, 0, dArr.length);
    }

    public SemiVariance(boolean z6) {
        this.biasCorrected = true;
        this.varianceDirection = Direction.DOWNSIDE;
        this.biasCorrected = z6;
    }

    public static void copy(SemiVariance semiVariance, SemiVariance semiVariance2) {
        MathUtils.checkNotNull(semiVariance);
        MathUtils.checkNotNull(semiVariance2);
        semiVariance2.setData(semiVariance.getDataRef());
        semiVariance2.biasCorrected = semiVariance.biasCorrected;
        semiVariance2.varianceDirection = semiVariance.varianceDirection;
    }

    public double evaluate(double[] dArr, double d) {
        return evaluate(dArr, d, this.varianceDirection, this.biasCorrected, 0, dArr.length);
    }

    public double evaluate(double[] dArr, double d, Direction direction) {
        return evaluate(dArr, d, direction, this.biasCorrected, 0, dArr.length);
    }

    public double evaluate(double[] dArr, double d, Direction direction, boolean z6, int i5, int i6) {
        test(dArr, i5, i6);
        if (dArr.length == 0) {
            return Double.NaN;
        }
        double d6 = 0.0d;
        if (dArr.length == 1) {
            return 0.0d;
        }
        boolean direction2 = direction.getDirection();
        while (i5 < i6) {
            double d7 = dArr[i5];
            if ((d7 > d) == direction2) {
                double d8 = d7 - d;
                d6 = (d8 * d8) + d6;
            }
            i5++;
        }
        return d6 / (z6 ? ((double) i6) - 1.0d : i6);
    }

    public SemiVariance(Direction direction) {
        this.biasCorrected = true;
        Direction direction2 = Direction.UPSIDE;
        this.varianceDirection = direction;
    }

    public SemiVariance(boolean z6, Direction direction) {
        this.biasCorrected = true;
        Direction direction2 = Direction.UPSIDE;
        this.biasCorrected = z6;
        this.varianceDirection = direction;
    }

    public SemiVariance(SemiVariance semiVariance) {
        this.biasCorrected = true;
        this.varianceDirection = Direction.DOWNSIDE;
        copy(semiVariance, this);
    }
}
