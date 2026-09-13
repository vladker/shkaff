package org.apache.poi.ss.formula.functions;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class FinanceLib {
    private FinanceLib() {
    }

    public static double fv(double d, double d6, double d7, double d8, boolean z6) {
        if (d == 0.0d) {
            return androidx.collection.a.B(d6, d7, d8, -1.0d);
        }
        double d9 = d + 1.0d;
        return ((((1.0d - Math.pow(d9, d6)) * (z6 ? d9 : 1.0d)) * d7) / d) - (Math.pow(d9, d6) * d8);
    }

    public static double nper(double d, double d6, double d7, double d8, boolean z6) {
        if (d == 0.0d) {
            return ((d8 + d7) * (-1.0d)) / d6;
        }
        double d9 = d + 1.0d;
        double d10 = ((z6 ? d9 : 1.0d) * d6) / d;
        double d11 = d10 - d8;
        return ((d11 < 0.0d ? Math.log(d8 - d10) : Math.log(d11)) - (d11 < 0.0d ? Math.log((-d7) - d10) : Math.log(d7 + d10))) / Math.log(d9);
    }

    public static double npv(double d, double[] dArr) {
        double d6 = d + 1.0d;
        double d7 = 0.0d;
        double d8 = d6;
        for (double d9 : dArr) {
            d7 += d9 / d8;
            d8 *= d6;
        }
        return d7;
    }

    public static double pmt(double d, double d6, double d7, double d8, boolean z6) {
        if (d == 0.0d) {
            return ((d8 + d7) * (-1.0d)) / d6;
        }
        double d9 = d + 1.0d;
        return (((Math.pow(d9, d6) * d7) + d8) * d) / ((1.0d - Math.pow(d9, d6)) * (z6 ? d9 : 1.0d));
    }

    public static double pv(double d, double d6, double d7, double d8, boolean z6) {
        if (d == 0.0d) {
            return androidx.collection.a.B(d6, d7, d8, -1.0d);
        }
        double d9 = d + 1.0d;
        return (((((1.0d - Math.pow(d9, d6)) / d) * (z6 ? d9 : 1.0d)) * d7) - d8) / Math.pow(d9, d6);
    }
}
