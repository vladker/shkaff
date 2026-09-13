package org.apache.poi.sl.usermodel;

import org.apache.poi.common.Duplicatable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Insets2D implements Duplicatable {
    public double bottom;
    public double left;
    public double right;
    public double top;

    public Insets2D(double d, double d6, double d7, double d8) {
        this.top = d;
        this.left = d6;
        this.bottom = d7;
        this.right = d8;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Insets2D) {
            Insets2D insets2D = (Insets2D) obj;
            if (this.top == insets2D.top && this.left == insets2D.left && this.bottom == insets2D.bottom && this.right == insets2D.right) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        double d = this.left;
        double d6 = this.bottom + d;
        double d7 = this.right;
        double d8 = this.top;
        double d9 = d7 + d8;
        double d10 = (((d6 + 1.0d) * d6) / 2.0d) + d;
        double d11 = (((d9 + 1.0d) * d9) / 2.0d) + d8;
        double d12 = d10 + d11;
        return (int) ((((1.0d + d12) * d12) / 2.0d) + d11);
    }

    public void set(double d, double d6, double d7, double d8) {
        this.top = d;
        this.left = d6;
        this.bottom = d7;
        this.right = d8;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.collection.a.w(Insets2D.class, sb, "[top=");
        sb.append(this.top);
        sb.append(",left=");
        sb.append(this.left);
        sb.append(",bottom=");
        sb.append(this.bottom);
        sb.append(",right=");
        sb.append(this.right);
        sb.append("]");
        return sb.toString();
    }

    @Override // org.apache.poi.common.Duplicatable
    public Insets2D copy() {
        return new Insets2D(this.top, this.left, this.bottom, this.right);
    }
}
