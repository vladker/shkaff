package org.apache.poi.ss.formula.functions;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Finance {
    public static double fv(double d, int i5, double d6, double d7, int i6) {
        double d8 = d + 1.0d;
        double d9 = i5;
        return -((((Math.pow(d8, d9) - 1.0d) * androidx.collection.a.B(d, i6, 1.0d, d6)) / d) + (Math.pow(d8, d9) * d7));
    }

    public static double ipmt(double d, int i5, int i6, double d6, double d7, int i7) {
        double dFv = fv(d, i5 - 1, pmt(d, i6, d6, d7, i7), d6, i7) * d;
        return i7 == 1 ? dFv / (d + 1.0d) : dFv;
    }

    public static double pmt(double d, int i5, double d6, double d7, int i6) {
        double d8 = d + 1.0d;
        double d9 = i5;
        return (((Math.pow(d8, d9) * d6) + d7) * (-d)) / ((Math.pow(d8, d9) - 1.0d) * ((d * ((double) i6)) + 1.0d));
    }

    public static double ppmt(double d, int i5, int i6, double d6, double d7, int i7) {
        return pmt(d, i6, d6, d7, i7) - ipmt(d, i5, i6, d6, d7, i7);
    }

    public static double fv(double d, int i5, double d6, double d7) {
        return fv(d, i5, d6, d7, 0);
    }

    public static double ipmt(double d, int i5, int i6, double d6, double d7) {
        return ipmt(d, i5, i6, d6, d7, 0);
    }

    public static double pmt(double d, int i5, double d6, double d7) {
        return pmt(d, i5, d6, d7, 0);
    }

    public static double ppmt(double d, int i5, int i6, double d6, double d7) {
        return pmt(d, i6, d6, d7) - ipmt(d, i5, i6, d6, d7);
    }

    public static double ipmt(double d, int i5, int i6, double d6) {
        return ipmt(d, i5, i6, d6, 0.0d);
    }

    public static double pmt(double d, int i5, double d6) {
        return pmt(d, i5, d6, 0.0d);
    }

    public static double ppmt(double d, int i5, int i6, double d6) {
        return pmt(d, i6, d6) - ipmt(d, i5, i6, d6);
    }
}
