package org.apache.poi.ss.usermodel;

import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ClientAnchor {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum AnchorType {
        MOVE_AND_RESIZE(0),
        DONT_MOVE_DO_RESIZE(1),
        MOVE_DONT_RESIZE(2),
        DONT_MOVE_AND_RESIZE(3);

        public final short value;

        AnchorType(int i5) {
            this.value = (short) i5;
        }

        @Internal
        public static AnchorType byId(int i5) {
            return values()[i5];
        }
    }

    AnchorType getAnchorType();

    short getCol1();

    short getCol2();

    int getDx1();

    int getDx2();

    int getDy1();

    int getDy2();

    int getRow1();

    int getRow2();

    void setAnchorType(AnchorType anchorType);

    void setCol1(int i5);

    void setCol2(int i5);

    void setDx1(int i5);

    void setDx2(int i5);

    void setDy1(int i5);

    void setDy2(int i5);

    void setRow1(int i5);

    void setRow2(int i5);
}
