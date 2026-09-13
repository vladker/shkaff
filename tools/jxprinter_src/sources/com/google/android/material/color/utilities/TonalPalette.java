package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TonalPalette {
    Map<Integer, Integer> cache = new HashMap();
    double chroma;
    double hue;
    Hct keyColor;

    private TonalPalette(double d, double d6, Hct hct) {
        this.hue = d;
        this.chroma = d6;
        this.keyColor = hct;
    }

    private static Hct createKeyColor(double d, double d6) {
        Hct hctFrom = Hct.from(d, d6, 50.0d);
        double dAbs = Math.abs(hctFrom.getChroma() - d6);
        for (double d7 = 1.0d; d7 < 50.0d && Math.round(d6) != Math.round(hctFrom.getChroma()); d7 += 1.0d) {
            Hct hctFrom2 = Hct.from(d, d6, 50.0d + d7);
            double dAbs2 = Math.abs(hctFrom2.getChroma() - d6);
            if (dAbs2 < dAbs) {
                dAbs = dAbs2;
                hctFrom = hctFrom2;
            }
            Hct hctFrom3 = Hct.from(d, d6, 50.0d - d7);
            double dAbs3 = Math.abs(hctFrom3.getChroma() - d6);
            if (dAbs3 < dAbs) {
                dAbs = dAbs3;
                hctFrom = hctFrom3;
            }
        }
        return hctFrom;
    }

    public static TonalPalette fromHct(Hct hct) {
        return new TonalPalette(hct.getHue(), hct.getChroma(), hct);
    }

    public static TonalPalette fromHueAndChroma(double d, double d6) {
        return new TonalPalette(d, d6, createKeyColor(d, d6));
    }

    public static TonalPalette fromInt(int i5) {
        return fromHct(Hct.fromInt(i5));
    }

    public double getChroma() {
        return this.chroma;
    }

    public Hct getHct(double d) {
        return Hct.from(this.hue, this.chroma, d);
    }

    public double getHue() {
        return this.hue;
    }

    public Hct getKeyColor() {
        return this.keyColor;
    }

    public int tone(int i5) {
        Integer numValueOf = this.cache.get(Integer.valueOf(i5));
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(Hct.from(this.hue, this.chroma, i5).toInt());
            this.cache.put(Integer.valueOf(i5), numValueOf);
        }
        return numValueOf.intValue();
    }
}
