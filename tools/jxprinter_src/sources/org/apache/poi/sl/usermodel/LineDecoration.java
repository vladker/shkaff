package org.apache.poi.sl.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface LineDecoration {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum DecorationShape {
        NONE(0, 1),
        TRIANGLE(1, 2),
        STEALTH(2, 3),
        DIAMOND(3, 4),
        OVAL(4, 5),
        ARROW(5, 6);

        public final int nativeId;
        public final int ooxmlId;

        DecorationShape(int i5, int i6) {
            this.nativeId = i5;
            this.ooxmlId = i6;
        }

        public static DecorationShape fromNativeId(int i5) {
            for (DecorationShape decorationShape : values()) {
                if (decorationShape.nativeId == i5) {
                    return decorationShape;
                }
            }
            return null;
        }

        public static DecorationShape fromOoxmlId(int i5) {
            for (DecorationShape decorationShape : values()) {
                if (decorationShape.ooxmlId == i5) {
                    return decorationShape;
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum DecorationSize {
        SMALL(0, 1),
        MEDIUM(1, 2),
        LARGE(2, 3);

        public final int nativeId;
        public final int ooxmlId;

        DecorationSize(int i5, int i6) {
            this.nativeId = i5;
            this.ooxmlId = i6;
        }

        public static DecorationSize fromNativeId(int i5) {
            for (DecorationSize decorationSize : values()) {
                if (decorationSize.nativeId == i5) {
                    return decorationSize;
                }
            }
            return null;
        }

        public static DecorationSize fromOoxmlId(int i5) {
            for (DecorationSize decorationSize : values()) {
                if (decorationSize.ooxmlId == i5) {
                    return decorationSize;
                }
            }
            return null;
        }
    }

    DecorationSize getHeadLength();

    DecorationShape getHeadShape();

    DecorationSize getHeadWidth();

    DecorationSize getTailLength();

    DecorationShape getTailShape();

    DecorationSize getTailWidth();
}
