package org.opencv.core;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class RotatedRect {
    public double angle;
    public Point center;
    public Size size;

    public RotatedRect() {
        this.center = new Point();
        this.size = new Size();
        this.angle = 0.0d;
    }

    public Rect boundingRect() {
        Point[] pointArr = new Point[4];
        points(pointArr);
        Rect rect = new Rect((int) Math.floor(Math.min(Math.min(Math.min(pointArr[0].f7681x, pointArr[1].f7681x), pointArr[2].f7681x), pointArr[3].f7681x)), (int) Math.floor(Math.min(Math.min(Math.min(pointArr[0].f7682y, pointArr[1].f7682y), pointArr[2].f7682y), pointArr[3].f7682y)), (int) Math.ceil(Math.max(Math.max(Math.max(pointArr[0].f7681x, pointArr[1].f7681x), pointArr[2].f7681x), pointArr[3].f7681x)), (int) Math.ceil(Math.max(Math.max(Math.max(pointArr[0].f7682y, pointArr[1].f7682y), pointArr[2].f7682y), pointArr[3].f7682y)));
        rect.width -= rect.f7686x - 1;
        rect.height -= rect.f7687y - 1;
        return rect;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RotatedRect)) {
            return false;
        }
        RotatedRect rotatedRect = (RotatedRect) obj;
        return this.center.equals(rotatedRect.center) && this.size.equals(rotatedRect.size) && this.angle == rotatedRect.angle;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.center.f7681x);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.center.f7682y);
        int i5 = ((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.size.width);
        int i6 = (i5 * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.size.height);
        int i7 = (i6 * 31) + ((int) (jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32)));
        long jDoubleToLongBits5 = Double.doubleToLongBits(this.angle);
        return (i7 * 31) + ((int) ((jDoubleToLongBits5 >>> 32) ^ jDoubleToLongBits5));
    }

    public void points(Point[] pointArr) {
        double d = (this.angle * 3.141592653589793d) / 180.0d;
        double dCos = Math.cos(d) * 0.5d;
        double dSin = Math.sin(d) * 0.5d;
        Point point = this.center;
        double d6 = point.f7681x;
        Size size = this.size;
        double d7 = size.height;
        double d8 = size.width;
        pointArr[0] = new Point((d6 - (dSin * d7)) - (dCos * d8), ((d7 * dCos) + point.f7682y) - (d8 * dSin));
        Point point2 = this.center;
        double d9 = point2.f7681x;
        Size size2 = this.size;
        double d10 = size2.height;
        double d11 = (dSin * d10) + d9;
        double d12 = size2.width;
        pointArr[1] = new Point(d11 - (dCos * d12), (point2.f7682y - (dCos * d10)) - (dSin * d12));
        Point point3 = this.center;
        double d13 = point3.f7681x * 2.0d;
        Point point4 = pointArr[0];
        pointArr[2] = new Point(d13 - point4.f7681x, (point3.f7682y * 2.0d) - point4.f7682y);
        Point point5 = this.center;
        double d14 = point5.f7681x * 2.0d;
        Point point6 = pointArr[1];
        pointArr[3] = new Point(d14 - point6.f7681x, (point5.f7682y * 2.0d) - point6.f7682y);
    }

    public void set(double[] dArr) {
        if (dArr != null) {
            Point point = this.center;
            point.f7681x = dArr.length > 0 ? dArr[0] : 0.0d;
            point.f7682y = dArr.length > 1 ? dArr[1] : 0.0d;
            Size size = this.size;
            size.width = dArr.length > 2 ? dArr[2] : 0.0d;
            size.height = dArr.length > 3 ? dArr[3] : 0.0d;
            this.angle = dArr.length > 4 ? dArr[4] : 0.0d;
            return;
        }
        Point point2 = this.center;
        point2.f7681x = 0.0d;
        point2.f7682y = 0.0d;
        Size size2 = this.size;
        size2.width = 0.0d;
        size2.height = 0.0d;
        this.angle = 0.0d;
    }

    public String toString() {
        return "{ " + this.center + " " + this.size + " * " + this.angle + " }";
    }

    public RotatedRect clone() {
        return new RotatedRect(this.center, this.size, this.angle);
    }

    public RotatedRect(Point point, Size size, double d) {
        this.center = point.clone();
        this.size = size.clone();
        this.angle = d;
    }

    public RotatedRect(double[] dArr) {
        this();
        set(dArr);
    }
}
