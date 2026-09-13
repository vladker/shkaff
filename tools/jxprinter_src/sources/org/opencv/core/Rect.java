package org.opencv.core;

import A3.AbstractC0157z;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Rect {
    public int height;
    public int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f7686x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f7687y;

    public Rect(int i5, int i6, int i7, int i8) {
        this.f7686x = i5;
        this.f7687y = i6;
        this.width = i7;
        this.height = i8;
    }

    public double area() {
        return this.width * this.height;
    }

    public Point br() {
        return new Point(this.f7686x + this.width, this.f7687y + this.height);
    }

    public boolean contains(Point point) {
        int i5 = this.f7686x;
        double d = i5;
        double d6 = point.f7681x;
        if (d > d6 || d6 >= i5 + this.width) {
            return false;
        }
        int i6 = this.f7687y;
        double d7 = i6;
        double d8 = point.f7682y;
        return d7 <= d8 && d8 < ((double) (i6 + this.height));
    }

    public boolean empty() {
        return this.width <= 0 || this.height <= 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) obj;
        return this.f7686x == rect.f7686x && this.f7687y == rect.f7687y && this.width == rect.width && this.height == rect.height;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.height);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.width);
        int i5 = ((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.f7686x);
        int i6 = (i5 * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.f7687y);
        return (i6 * 31) + ((int) ((jDoubleToLongBits4 >>> 32) ^ jDoubleToLongBits4));
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            this.f7686x = dArr.length > 0 ? (int) dArr[0] : 0;
            this.f7687y = dArr.length > 1 ? (int) dArr[1] : 0;
            this.width = dArr.length > 2 ? (int) dArr[2] : 0;
            this.height = dArr.length > 3 ? (int) dArr[3] : 0;
            return;
        }
        this.f7686x = 0;
        this.f7687y = 0;
        this.width = 0;
        this.height = 0;
    }

    public Size size() {
        return new Size(this.width, this.height);
    }

    public Point tl() {
        return new Point(this.f7686x, this.f7687y);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(VectorFormat.DEFAULT_PREFIX);
        sb.append(this.f7686x);
        sb.append(", ");
        sb.append(this.f7687y);
        sb.append(", ");
        sb.append(this.width);
        sb.append("x");
        return AbstractC0157z.l(VectorFormat.DEFAULT_SUFFIX, this.height, sb);
    }

    public Rect clone() {
        return new Rect(this.f7686x, this.f7687y, this.width, this.height);
    }

    public Rect() {
        this(0, 0, 0, 0);
    }

    public Rect(Point point, Point point2) {
        double d = point.f7681x;
        double d6 = point2.f7681x;
        int i5 = (int) (d < d6 ? d : d6);
        this.f7686x = i5;
        double d7 = point.f7682y;
        double d8 = point2.f7682y;
        int i6 = (int) (d7 < d8 ? d7 : d8);
        this.f7687y = i6;
        this.width = ((int) (d <= d6 ? d6 : d)) - i5;
        this.height = ((int) (d7 <= d8 ? d8 : d7)) - i6;
    }

    public Rect(Point point, Size size) {
        this((int) point.f7681x, (int) point.f7682y, (int) size.width, (int) size.height);
    }

    public Rect(double[] dArr) {
        set(dArr);
    }
}
