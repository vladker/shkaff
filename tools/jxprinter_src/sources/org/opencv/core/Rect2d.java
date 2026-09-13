package org.opencv.core;

import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Rect2d {
    public double height;
    public double width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public double f7688x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public double f7689y;

    public Rect2d(double d, double d6, double d7, double d8) {
        this.f7688x = d;
        this.f7689y = d6;
        this.width = d7;
        this.height = d8;
    }

    public double area() {
        return this.width * this.height;
    }

    public Point br() {
        return new Point(this.f7688x + this.width, this.f7689y + this.height);
    }

    public boolean contains(Point point) {
        double d = this.f7688x;
        double d6 = point.f7681x;
        if (d > d6 || d6 >= d + this.width) {
            return false;
        }
        double d7 = this.f7689y;
        double d8 = point.f7682y;
        return d7 <= d8 && d8 < d7 + this.height;
    }

    public boolean empty() {
        return this.width <= 0.0d || this.height <= 0.0d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect2d)) {
            return false;
        }
        Rect2d rect2d = (Rect2d) obj;
        return this.f7688x == rect2d.f7688x && this.f7689y == rect2d.f7689y && this.width == rect2d.width && this.height == rect2d.height;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.height);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.width);
        int i5 = ((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.f7688x);
        int i6 = (i5 * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.f7689y);
        return (i6 * 31) + ((int) ((jDoubleToLongBits4 >>> 32) ^ jDoubleToLongBits4));
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            this.f7688x = dArr.length > 0 ? dArr[0] : 0.0d;
            this.f7689y = dArr.length > 1 ? dArr[1] : 0.0d;
            this.width = dArr.length > 2 ? dArr[2] : 0.0d;
            this.height = dArr.length > 3 ? dArr[3] : 0.0d;
            return;
        }
        this.f7688x = 0.0d;
        this.f7689y = 0.0d;
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public Size size() {
        return new Size(this.width, this.height);
    }

    public Point tl() {
        return new Point(this.f7688x, this.f7689y);
    }

    public String toString() {
        return VectorFormat.DEFAULT_PREFIX + this.f7688x + ", " + this.f7689y + ", " + this.width + "x" + this.height + VectorFormat.DEFAULT_SUFFIX;
    }

    public Rect2d clone() {
        return new Rect2d(this.f7688x, this.f7689y, this.width, this.height);
    }

    public Rect2d() {
        this(0.0d, 0.0d, 0.0d, 0.0d);
    }

    public Rect2d(Point point, Point point2) {
        double d = point.f7681x;
        double d6 = point2.f7681x;
        double d7 = d < d6 ? d : d6;
        this.f7688x = d7;
        double d8 = point.f7682y;
        double d9 = point2.f7682y;
        double d10 = d8 < d9 ? d8 : d9;
        this.f7689y = d10;
        this.width = (d <= d6 ? d6 : d) - d7;
        this.height = (d8 <= d9 ? d9 : d8) - d10;
    }

    public Rect2d(Point point, Size size) {
        this(point.f7681x, point.f7682y, size.width, size.height);
    }

    public Rect2d(double[] dArr) {
        set(dArr);
    }
}
