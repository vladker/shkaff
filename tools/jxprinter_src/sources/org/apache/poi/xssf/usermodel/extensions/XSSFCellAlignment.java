package org.apache.poi.xssf.usermodel.extensions;

import java.math.BigInteger;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.ReadingOrder;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellAlignment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STHorizontalAlignment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STVerticalAlignment;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSSFCellAlignment {
    private final CTCellAlignment cellAlignement;

    public XSSFCellAlignment(CTCellAlignment cTCellAlignment) {
        this.cellAlignement = cTCellAlignment;
    }

    @Internal
    public CTCellAlignment getCTCellAlignment() {
        return this.cellAlignement;
    }

    public HorizontalAlignment getHorizontal() {
        STHorizontalAlignment.Enum horizontal = this.cellAlignement.getHorizontal();
        if (horizontal == null) {
            horizontal = STHorizontalAlignment.GENERAL;
        }
        return HorizontalAlignment.values()[horizontal.intValue() - 1];
    }

    public long getIndent() {
        return this.cellAlignement.getIndent();
    }

    public ReadingOrder getReadingOrder() {
        CTCellAlignment cTCellAlignment = this.cellAlignement;
        return (cTCellAlignment == null || !cTCellAlignment.isSetReadingOrder()) ? ReadingOrder.CONTEXT : ReadingOrder.forLong(this.cellAlignement.getReadingOrder());
    }

    public boolean getShrinkToFit() {
        return this.cellAlignement.getShrinkToFit();
    }

    public long getTextRotation() {
        if (this.cellAlignement.isSetTextRotation()) {
            return this.cellAlignement.getTextRotation().longValue();
        }
        return 0L;
    }

    public VerticalAlignment getVertical() {
        STVerticalAlignment.Enum vertical = this.cellAlignement.getVertical();
        if (vertical == null) {
            vertical = STVerticalAlignment.BOTTOM;
        }
        return VerticalAlignment.values()[vertical.intValue() - 1];
    }

    public boolean getWrapText() {
        return this.cellAlignement.getWrapText();
    }

    public void setHorizontal(HorizontalAlignment horizontalAlignment) {
        this.cellAlignement.setHorizontal(STHorizontalAlignment.Enum.forInt(horizontalAlignment.ordinal() + 1));
    }

    public void setIndent(long j6) {
        this.cellAlignement.setIndent(j6);
    }

    public void setReadingOrder(ReadingOrder readingOrder) {
        this.cellAlignement.setReadingOrder(readingOrder.getCode());
    }

    public void setShrinkToFit(boolean z6) {
        this.cellAlignement.setShrinkToFit(z6);
    }

    public void setTextRotation(long j6) {
        if (j6 < 0 && j6 >= -90) {
            j6 = (j6 * (-1)) + 90;
        }
        this.cellAlignement.setTextRotation(BigInteger.valueOf(j6));
    }

    public void setVertical(VerticalAlignment verticalAlignment) {
        this.cellAlignement.setVertical(STVerticalAlignment.Enum.forInt(verticalAlignment.ordinal() + 1));
    }

    public void setWrapText(boolean z6) {
        this.cellAlignement.setWrapText(z6);
    }
}
