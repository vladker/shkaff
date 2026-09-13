package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Blend {
    private Blend() {
    }

    public static int cam16Ucs(int i5, int i6, double d) {
        Cam16 cam16FromInt = Cam16.fromInt(i5);
        Cam16 cam16FromInt2 = Cam16.fromInt(i6);
        double jstar = cam16FromInt.getJstar();
        double astar = cam16FromInt.getAstar();
        double bstar = cam16FromInt.getBstar();
        return Cam16.fromUcs(androidx.collection.a.a(cam16FromInt2.getJstar(), jstar, d, jstar), androidx.collection.a.a(cam16FromInt2.getAstar(), astar, d, astar), androidx.collection.a.a(cam16FromInt2.getBstar(), bstar, d, bstar)).toInt();
    }

    public static int harmonize(int i5, int i6) {
        Hct hctFromInt = Hct.fromInt(i5);
        Hct hctFromInt2 = Hct.fromInt(i6);
        double dMin = Math.min(MathUtils.differenceDegrees(hctFromInt.getHue(), hctFromInt2.getHue()) * 0.5d, 15.0d);
        return Hct.from(MathUtils.sanitizeDegreesDouble((MathUtils.rotationDirection(hctFromInt.getHue(), hctFromInt2.getHue()) * dMin) + hctFromInt.getHue()), hctFromInt.getChroma(), hctFromInt.getTone()).toInt();
    }

    public static int hctHue(int i5, int i6, double d) {
        return Hct.from(Cam16.fromInt(cam16Ucs(i5, i6, d)).getHue(), Cam16.fromInt(i5).getChroma(), ColorUtils.lstarFromArgb(i5)).toInt();
    }
}
