package org.apache.poi.util;

import java.awt.geom.Dimension2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Dimension2DDouble extends Dimension2D {
    double height;
    double width;

    public Dimension2DDouble() {
        this.width = 0.0d;
        this.height = 0.0d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Dimension2DDouble) {
            Dimension2DDouble dimension2DDouble = (Dimension2DDouble) obj;
            if (this.width == dimension2DDouble.width && this.height == dimension2DDouble.height) {
                return true;
            }
        }
        return false;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    public int hashCode() {
        double d = this.width;
        double d6 = this.height + d;
        return (int) Math.ceil((((1.0d + d6) * d6) / 2.0d) + d);
    }

    public void setSize(double d, double d6) {
        this.width = d;
        this.height = d6;
    }

    public String toString() {
        return "Dimension2DDouble[" + this.width + ", " + this.height + "]";
    }

    public Dimension2DDouble(double d, double d6) {
        this.width = d;
        this.height = d6;
    }
}
