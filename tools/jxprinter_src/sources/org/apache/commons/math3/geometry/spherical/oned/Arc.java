package org.apache.commons.math3.geometry.spherical.oned;

import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Arc {
    private final double lower;
    private final double middle;
    private final double tolerance;
    private final double upper;

    public Arc(double d, double d6, double d7) {
        this.tolerance = d7;
        if (!Precision.equals(d, d6, 0)) {
            double d8 = d6 - d;
            if (d8 < 6.283185307179586d) {
                if (d > d6) {
                    throw new NumberIsTooLargeException(LocalizedFormats.ENDPOINTS_NOT_AN_INTERVAL, Double.valueOf(d), Double.valueOf(d6), true);
                }
                double dNormalizeAngle = MathUtils.normalizeAngle(d, 3.141592653589793d);
                this.lower = dNormalizeAngle;
                double d9 = d8 + dNormalizeAngle;
                this.upper = d9;
                this.middle = (dNormalizeAngle + d9) * 0.5d;
                return;
            }
        }
        this.lower = 0.0d;
        this.upper = 6.283185307179586d;
        this.middle = 3.141592653589793d;
    }

    public Region.Location checkPoint(double d) {
        double dNormalizeAngle = MathUtils.normalizeAngle(d, this.middle);
        double d6 = this.lower;
        double d7 = this.tolerance;
        if (dNormalizeAngle >= d6 - d7) {
            double d8 = this.upper;
            if (dNormalizeAngle <= d8 + d7) {
                if (dNormalizeAngle <= d6 + d7 || dNormalizeAngle >= d8 - d7) {
                    return getSize() >= 6.283185307179586d - this.tolerance ? Region.Location.INSIDE : Region.Location.BOUNDARY;
                }
                return Region.Location.INSIDE;
            }
        }
        return Region.Location.OUTSIDE;
    }

    public double getBarycenter() {
        return this.middle;
    }

    public double getInf() {
        return this.lower;
    }

    public double getSize() {
        return this.upper - this.lower;
    }

    public double getSup() {
        return this.upper;
    }

    public double getTolerance() {
        return this.tolerance;
    }
}
