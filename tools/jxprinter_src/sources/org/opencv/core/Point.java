package org.opencv.core;

import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Point {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public double f7681x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public double f7682y;

    public Point(double d, double d6) {
        this.f7681x = d;
        this.f7682y = d6;
    }

    public double dot(Point point) {
        return (this.f7682y * point.f7682y) + (this.f7681x * point.f7681x);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return this.f7681x == point.f7681x && this.f7682y == point.f7682y;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f7681x);
        int i5 = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f7682y);
        return (i5 * 31) + ((int) ((jDoubleToLongBits2 >>> 32) ^ jDoubleToLongBits2));
    }

    public boolean inside(Rect rect) {
        return rect.contains(this);
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            this.f7681x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.f7682y = dArr.length > 1 ? dArr[1] : 0.0d;
        } else {
            this.f7681x = 0.0d;
            this.f7682y = 0.0d;
        }
    }

    public String toString() {
        return VectorFormat.DEFAULT_PREFIX + this.f7681x + ", " + this.f7682y + VectorFormat.DEFAULT_SUFFIX;
    }

    public Point clone() {
        return new Point(this.f7681x, this.f7682y);
    }

    public Point() {
        this(0.0d, 0.0d);
    }

    public Point(double[] dArr) {
        this();
        set(dArr);
    }
}
