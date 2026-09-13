package org.apache.poi.xddf.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Angles {
    public static final int OOXML_DEGREE = 60000;

    public static final double attributeToDegrees(int i5) {
        return ((double) i5) / 60000.0d;
    }

    public static final int degreesToAttribute(double d) {
        return Math.toIntExact(Math.round(d * 60000.0d));
    }
}
