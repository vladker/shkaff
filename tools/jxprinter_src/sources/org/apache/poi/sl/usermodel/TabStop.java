package org.apache.poi.sl.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface TabStop {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum TabStopType {
        LEFT(0, 1),
        CENTER(1, 2),
        RIGHT(2, 3),
        DECIMAL(3, 4);

        public final int nativeId;
        public final int ooxmlId;

        TabStopType(int i5, int i6) {
            this.nativeId = i5;
            this.ooxmlId = i6;
        }

        public static TabStopType fromNativeId(int i5) {
            for (TabStopType tabStopType : values()) {
                if (tabStopType.nativeId == i5) {
                    return tabStopType;
                }
            }
            return null;
        }

        public static TabStopType fromOoxmlId(int i5) {
            for (TabStopType tabStopType : values()) {
                if (tabStopType.ooxmlId == i5) {
                    return tabStopType;
                }
            }
            return null;
        }
    }

    double getPositionInPoints();

    TabStopType getType();

    void setPositionInPoints(double d);

    void setType(TabStopType tabStopType);
}
