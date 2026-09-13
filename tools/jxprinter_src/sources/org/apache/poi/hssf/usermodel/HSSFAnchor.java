package org.apache.poi.hssf.usermodel;

import org.apache.poi.ddf.EscherChildAnchorRecord;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ss.usermodel.ChildAnchor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class HSSFAnchor implements ChildAnchor {
    protected boolean _isHorizontallyFlipped;
    protected boolean _isVerticallyFlipped;

    public HSSFAnchor() {
        createEscherAnchor();
    }

    public static HSSFAnchor createAnchorFromEscher(EscherContainerRecord escherContainerRecord) {
        short s6 = EscherChildAnchorRecord.RECORD_ID;
        if (escherContainerRecord.getChildById(s6) != null) {
            return new HSSFChildAnchor((EscherChildAnchorRecord) escherContainerRecord.getChildById(s6));
        }
        short s7 = EscherClientAnchorRecord.RECORD_ID;
        if (escherContainerRecord.getChildById(s7) != null) {
            return new HSSFClientAnchor((EscherClientAnchorRecord) escherContainerRecord.getChildById(s7));
        }
        return null;
    }

    public abstract void createEscherAnchor();

    public abstract EscherRecord getEscherAnchor();

    public abstract boolean isHorizontallyFlipped();

    public abstract boolean isVerticallyFlipped();

    public HSSFAnchor(int i5, int i6, int i7, int i8) {
        createEscherAnchor();
        setDx1(i5);
        setDy1(i6);
        setDx2(i7);
        setDy2(i8);
    }
}
