package org.apache.commons.math3.geometry.euclidean.oned;

import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.partitioning.Region;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Interval {
    private final double lower;
    private final double upper;

    public Interval(double d, double d6) {
        if (d6 < d) {
            throw new NumberIsTooSmallException(LocalizedFormats.ENDPOINTS_NOT_AN_INTERVAL, Double.valueOf(d6), Double.valueOf(d), true);
        }
        this.lower = d;
        this.upper = d6;
    }

    public Region.Location checkPoint(double d, double d6) {
        double d7 = this.lower;
        if (d >= d7 - d6) {
            double d8 = this.upper;
            if (d <= d8 + d6) {
                return (d <= d7 + d6 || d >= d8 - d6) ? Region.Location.BOUNDARY : Region.Location.INSIDE;
            }
        }
        return Region.Location.OUTSIDE;
    }

    public double getBarycenter() {
        return (this.lower + this.upper) * 0.5d;
    }

    public double getInf() {
        return this.lower;
    }

    @Deprecated
    public double getLength() {
        return getSize();
    }

    @Deprecated
    public double getLower() {
        return getInf();
    }

    @Deprecated
    public double getMidPoint() {
        return getBarycenter();
    }

    public double getSize() {
        return this.upper - this.lower;
    }

    public double getSup() {
        return this.upper;
    }

    @Deprecated
    public double getUpper() {
        return getSup();
    }
}
