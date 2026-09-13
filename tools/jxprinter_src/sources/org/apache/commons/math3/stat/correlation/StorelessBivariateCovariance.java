package org.apache.commons.math3.stat.correlation;

import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class StorelessBivariateCovariance {
    private boolean biasCorrected;
    private double covarianceNumerator;
    private double meanX;
    private double meanY;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private double f6912n;

    public StorelessBivariateCovariance() {
        this(true);
    }

    public void append(StorelessBivariateCovariance storelessBivariateCovariance) {
        double d = this.f6912n;
        double d6 = storelessBivariateCovariance.f6912n + d;
        this.f6912n = d6;
        double d7 = storelessBivariateCovariance.meanX;
        double d8 = this.meanX;
        double d9 = d7 - d8;
        double d10 = storelessBivariateCovariance.meanY;
        double d11 = this.meanY;
        double d12 = d10 - d11;
        double d13 = storelessBivariateCovariance.f6912n;
        this.meanX = ((d9 * d13) / d6) + d8;
        this.meanY = ((d12 * d13) / d6) + d11;
        this.covarianceNumerator = (((d * d13) / d6) * d9 * d12) + storelessBivariateCovariance.covarianceNumerator + this.covarianceNumerator;
    }

    public double getN() {
        return this.f6912n;
    }

    public double getResult() {
        double d;
        double d6 = this.f6912n;
        if (d6 < 2.0d) {
            throw new NumberIsTooSmallException(LocalizedFormats.INSUFFICIENT_DIMENSION, Double.valueOf(this.f6912n), 2, true);
        }
        if (this.biasCorrected) {
            d = this.covarianceNumerator;
            d6 -= 1.0d;
        } else {
            d = this.covarianceNumerator;
        }
        return d / d6;
    }

    public void increment(double d, double d6) {
        double d7 = this.f6912n + 1.0d;
        this.f6912n = d7;
        double d8 = this.meanX;
        double d9 = d - d8;
        double d10 = this.meanY;
        double d11 = d6 - d10;
        this.meanX = (d9 / d7) + d8;
        this.meanY = (d11 / d7) + d10;
        this.covarianceNumerator = (((d7 - 1.0d) / d7) * d9 * d11) + this.covarianceNumerator;
    }

    public StorelessBivariateCovariance(boolean z6) {
        this.meanY = 0.0d;
        this.meanX = 0.0d;
        this.f6912n = 0.0d;
        this.covarianceNumerator = 0.0d;
        this.biasCorrected = z6;
    }
}
