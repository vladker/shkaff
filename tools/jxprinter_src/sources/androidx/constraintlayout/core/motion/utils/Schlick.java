package androidx.constraintlayout.core.motion.utils;

import androidx.collection.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    double mEps;
    double mS;
    double mT;

    public Schlick(String str) {
        this.mStr = str;
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        this.mS = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
        int i5 = iIndexOf2 + 1;
        this.mT = Double.parseDouble(str.substring(i5, str.indexOf(44, i5)).trim());
    }

    private double dfunc(double d) {
        double d6;
        double dA;
        double d7 = this.mT;
        if (d < d7) {
            double d8 = this.mS;
            d6 = d8 * d7 * d7;
            dA = (((d7 - d) * d8) + d) * a.a(d7, d, d8, d);
        } else {
            double d9 = this.mS;
            d6 = (d7 - 1.0d) * (d7 - 1.0d) * d9;
            dA = ((((d7 - d) * (-d9)) - d) + 1.0d) * ((((d7 - d) * (-d9)) - d) + 1.0d);
        }
        return d6 / dA;
    }

    private double func(double d) {
        double d6 = this.mT;
        if (d < d6) {
            return (d6 * d) / (((d6 - d) * this.mS) + d);
        }
        return ((d - 1.0d) * (1.0d - d6)) / ((1.0d - d) - ((d6 - d) * this.mS));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d) {
        return func(d);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d) {
        return dfunc(d);
    }
}
