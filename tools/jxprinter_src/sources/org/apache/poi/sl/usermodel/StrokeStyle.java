package org.apache.poi.sl.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface StrokeStyle {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum LineCap {
        ROUND(0, 1),
        SQUARE(1, 2),
        FLAT(2, 3);

        public final int nativeId;
        public final int ooxmlId;

        LineCap(int i5, int i6) {
            this.nativeId = i5;
            this.ooxmlId = i6;
        }

        public static LineCap fromNativeId(int i5) {
            for (LineCap lineCap : values()) {
                if (lineCap.nativeId == i5) {
                    return lineCap;
                }
            }
            return null;
        }

        public static LineCap fromOoxmlId(int i5) {
            for (LineCap lineCap : values()) {
                if (lineCap.ooxmlId == i5) {
                    return lineCap;
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum LineCompound {
        SINGLE(0, 1),
        DOUBLE(1, 2),
        THICK_THIN(2, 3),
        THIN_THICK(3, 4),
        TRIPLE(4, 5);

        public final int nativeId;
        public final int ooxmlId;

        LineCompound(int i5, int i6) {
            this.nativeId = i5;
            this.ooxmlId = i6;
        }

        public static LineCompound fromNativeId(int i5) {
            for (LineCompound lineCompound : values()) {
                if (lineCompound.nativeId == i5) {
                    return lineCompound;
                }
            }
            return null;
        }

        public static LineCompound fromOoxmlId(int i5) {
            for (LineCompound lineCompound : values()) {
                if (lineCompound.ooxmlId == i5) {
                    return lineCompound;
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum LineDash {
        SOLID(1, 1, null),
        DOT(6, 2, 1, 1),
        DASH(7, 3, 3, 4),
        DASH_DOT(9, 5, 4, 3, 1, 3),
        LG_DASH(8, 4, 8, 3),
        LG_DASH_DOT(10, 6, 8, 3, 1, 3),
        LG_DASH_DOT_DOT(11, 7, 8, 3, 1, 3, 1, 3),
        SYS_DASH(2, 8, 2, 2),
        SYS_DOT(3, 9, 1, 1),
        SYS_DASH_DOT(4, 10, 2, 2, 1, 1),
        SYS_DASH_DOT_DOT(5, 11, 2, 2, 1, 1, 1, 1);

        public final int nativeId;
        public final int ooxmlId;
        public final int[] pattern;

        LineDash(int i5, int i6, int... iArr) {
            this.nativeId = i5;
            this.ooxmlId = i6;
            this.pattern = (iArr == null || iArr.length == 0) ? null : iArr;
        }

        public static LineDash fromNativeId(int i5) {
            for (LineDash lineDash : values()) {
                if (lineDash.nativeId == i5) {
                    return lineDash;
                }
            }
            return null;
        }

        public static LineDash fromOoxmlId(int i5) {
            for (LineDash lineDash : values()) {
                if (lineDash.ooxmlId == i5) {
                    return lineDash;
                }
            }
            return null;
        }
    }

    LineCap getLineCap();

    LineCompound getLineCompound();

    LineDash getLineDash();

    double getLineWidth();

    PaintStyle getPaint();
}
