package org.opencv.core;

import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Point3 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public double f7683x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public double f7684y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public double f7685z;

    public Point3(double d, double d6, double d7) {
        this.f7683x = d;
        this.f7684y = d6;
        this.f7685z = d7;
    }

    public Point3 cross(Point3 point3) {
        double d = this.f7684y;
        double d6 = point3.f7685z;
        double d7 = this.f7685z;
        double d8 = point3.f7684y;
        double d9 = (d * d6) - (d7 * d8);
        double d10 = point3.f7683x;
        double d11 = this.f7683x;
        return new Point3(d9, (d7 * d10) - (d6 * d11), (d11 * d8) - (d * d10));
    }

    public double dot(Point3 point3) {
        return (this.f7685z * point3.f7685z) + (this.f7684y * point3.f7684y) + (this.f7683x * point3.f7683x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point3)) {
            return false;
        }
        Point3 point3 = (Point3) obj;
        return this.f7683x == point3.f7683x && this.f7684y == point3.f7684y && this.f7685z == point3.f7685z;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f7683x);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f7684y);
        int i5 = ((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.f7685z);
        return (i5 * 31) + ((int) ((jDoubleToLongBits3 >>> 32) ^ jDoubleToLongBits3));
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            this.f7683x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.f7684y = dArr.length > 1 ? dArr[1] : 0.0d;
            this.f7685z = dArr.length > 2 ? dArr[2] : 0.0d;
        } else {
            this.f7683x = 0.0d;
            this.f7684y = 0.0d;
            this.f7685z = 0.0d;
        }
    }

    public String toString() {
        return VectorFormat.DEFAULT_PREFIX + this.f7683x + ", " + this.f7684y + ", " + this.f7685z + VectorFormat.DEFAULT_SUFFIX;
    }

    public Point3 clone() {
        return new Point3(this.f7683x, this.f7684y, this.f7685z);
    }

    public Point3() {
        this(0.0d, 0.0d, 0.0d);
    }

    public Point3(Point point) {
        this.f7683x = point.f7681x;
        this.f7684y = point.f7682y;
        this.f7685z = 0.0d;
    }

    public Point3(double[] dArr) {
        this();
        set(dArr);
    }
}
