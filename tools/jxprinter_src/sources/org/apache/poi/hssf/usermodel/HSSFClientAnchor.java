package org.apache.poi.hssf.usermodel;

import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.util.IEEEDouble;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class HSSFClientAnchor extends HSSFAnchor implements ClientAnchor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int MAX_COL;
    public static final int MAX_ROW;
    private EscherClientAnchorRecord _escherClientAnchor;

    static {
        SpreadsheetVersion spreadsheetVersion = SpreadsheetVersion.EXCEL97;
        MAX_COL = spreadsheetVersion.getLastColumnIndex();
        MAX_ROW = spreadsheetVersion.getLastRowIndex();
    }

    public HSSFClientAnchor(EscherClientAnchorRecord escherClientAnchorRecord) {
        this._escherClientAnchor = escherClientAnchorRecord;
    }

    private void checkRange(int i5, int i6, int i7, String str) {
        if (i5 < i6 || i5 > i7) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" must be between ");
            sb.append(i6);
            sb.append(" and ");
            sb.append(i7);
            throw new IllegalArgumentException(androidx.exifinterface.media.a.q(sb, ", but was: ", i5));
        }
    }

    private float getRowHeightInPoints(HSSFSheet hSSFSheet, int i5) {
        HSSFRow row = hSSFSheet.getRow(i5);
        return row == null ? hSSFSheet.getDefaultRowHeightInPoints() : row.getHeightInPoints();
    }

    private static int unsignedValue(short s6) {
        return s6 < 0 ? s6 + 65536 : s6;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public void createEscherAnchor() {
        this._escherClientAnchor = new EscherClientAnchorRecord();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != HSSFClientAnchor.class) {
            return false;
        }
        HSSFClientAnchor hSSFClientAnchor = (HSSFClientAnchor) obj;
        return hSSFClientAnchor.getCol1() == getCol1() && hSSFClientAnchor.getCol2() == getCol2() && hSSFClientAnchor.getDx1() == getDx1() && hSSFClientAnchor.getDx2() == getDx2() && hSSFClientAnchor.getDy1() == getDy1() && hSSFClientAnchor.getDy2() == getDy2() && hSSFClientAnchor.getRow1() == getRow1() && hSSFClientAnchor.getRow2() == getRow2() && hSSFClientAnchor.getAnchorType() == getAnchorType();
    }

    public float getAnchorHeightInPoints(HSSFSheet hSSFSheet) {
        int dy1 = getDy1();
        int dy2 = getDy2();
        int iMin = Math.min(getRow1(), getRow2());
        int iMax = Math.max(getRow1(), getRow2());
        if (iMin == iMax) {
            return ((dy2 - dy1) / 256.0f) * getRowHeightInPoints(hSSFSheet, iMax);
        }
        float rowHeightInPoints = ((256.0f - dy1) / 256.0f) * getRowHeightInPoints(hSSFSheet, iMin);
        float rowHeightInPoints2 = 0.0f;
        while (true) {
            rowHeightInPoints += rowHeightInPoints2;
            iMin++;
            if (iMin >= iMax) {
                return ((dy2 / 256.0f) * getRowHeightInPoints(hSSFSheet, iMax)) + rowHeightInPoints;
            }
            rowHeightInPoints2 = getRowHeightInPoints(hSSFSheet, iMin);
        }
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public ClientAnchor.AnchorType getAnchorType() {
        return ClientAnchor.AnchorType.byId(this._escherClientAnchor.getFlag());
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public short getCol1() {
        return this._escherClientAnchor.getCol1();
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public short getCol2() {
        return this._escherClientAnchor.getCol2();
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDx1() {
        return this._escherClientAnchor.getDx1();
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDx2() {
        return this._escherClientAnchor.getDx2();
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDy1() {
        return this._escherClientAnchor.getDy1();
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public int getDy2() {
        return this._escherClientAnchor.getDy2();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public EscherRecord getEscherAnchor() {
        return this._escherClientAnchor;
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public int getRow1() {
        return unsignedValue(this._escherClientAnchor.getRow1());
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public int getRow2() {
        return unsignedValue(this._escherClientAnchor.getRow2());
    }

    public int hashCode() {
        return 42;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public boolean isHorizontallyFlipped() {
        return this._isHorizontallyFlipped;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFAnchor
    public boolean isVerticallyFlipped() {
        return this._isVerticallyFlipped;
    }

    public void setAnchor(short s6, int i5, int i6, int i7, short s7, int i8, int i9, int i10) {
        checkRange(getDx1(), 0, IEEEDouble.EXPONENT_BIAS, "dx1");
        checkRange(getDx2(), 0, IEEEDouble.EXPONENT_BIAS, "dx2");
        checkRange(getDy1(), 0, 255, "dy1");
        checkRange(getDy2(), 0, 255, "dy2");
        short col1 = getCol1();
        int i11 = MAX_COL;
        checkRange(col1, 0, i11, "col1");
        checkRange(getCol2(), 0, i11, "col2");
        int row1 = getRow1();
        int i12 = MAX_ROW;
        checkRange(row1, 0, i12, "row1");
        checkRange(getRow2(), 0, i12, "row2");
        setCol1(s6);
        setRow1(i5);
        setDx1(i6);
        setDy1(i7);
        setCol2(s7);
        setRow2(i8);
        setDx2(i9);
        setDy2(i10);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setAnchorType(ClientAnchor.AnchorType anchorType) {
        this._escherClientAnchor.setFlag(anchorType.value);
    }

    public void setCol1(short s6) {
        checkRange(s6, 0, MAX_COL, "col1");
        this._escherClientAnchor.setCol1(s6);
    }

    public void setCol2(short s6) {
        checkRange(s6, 0, MAX_COL, "col2");
        this._escherClientAnchor.setCol2(s6);
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDx1(int i5) {
        this._escherClientAnchor.setDx1((short) i5);
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDx2(int i5) {
        this._escherClientAnchor.setDx2((short) i5);
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDy1(int i5) {
        this._escherClientAnchor.setDy1((short) i5);
    }

    @Override // org.apache.poi.ss.usermodel.ChildAnchor
    public void setDy2(int i5) {
        this._escherClientAnchor.setDy2((short) i5);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setRow1(int i5) {
        checkRange(i5, 0, MAX_ROW, "row1");
        this._escherClientAnchor.setRow1((short) i5);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setRow2(int i5) {
        checkRange(i5, 0, MAX_ROW, "row2");
        this._escherClientAnchor.setRow2((short) i5);
    }

    public HSSFClientAnchor() {
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setCol1(int i5) {
        setCol1((short) i5);
    }

    @Override // org.apache.poi.ss.usermodel.ClientAnchor
    public void setCol2(int i5) {
        setCol2((short) i5);
    }

    public HSSFClientAnchor(int i5, int i6, int i7, int i8, short s6, int i9, short s7, int i10) {
        super(i5, i6, i7, i8);
        checkRange(i5, 0, IEEEDouble.EXPONENT_BIAS, "dx1");
        checkRange(i7, 0, IEEEDouble.EXPONENT_BIAS, "dx2");
        checkRange(i6, 0, 255, "dy1");
        checkRange(i8, 0, 255, "dy2");
        int i11 = MAX_COL;
        checkRange(s6, 0, i11, "col1");
        checkRange(s7, 0, i11, "col2");
        int i12 = MAX_ROW;
        checkRange(i9, 0, i12, "row1");
        checkRange(i10, 0, i12, "row2");
        setCol1((short) Math.min((int) s6, (int) s7));
        setCol2((short) Math.max((int) s6, (int) s7));
        setRow1(Math.min(i9, i10));
        setRow2(Math.max(i9, i10));
        if (s6 > s7) {
            this._isHorizontallyFlipped = true;
        }
        if (i9 > i10) {
            this._isVerticallyFlipped = true;
        }
    }
}
