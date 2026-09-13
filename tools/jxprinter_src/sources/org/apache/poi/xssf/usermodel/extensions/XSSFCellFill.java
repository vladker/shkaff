package org.apache.poi.xssf.usermodel.extensions;

import java.util.Objects;
import org.apache.poi.util.Internal;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPatternFill;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STPatternType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSSFCellFill {
    private CTFill _fill;
    private IndexedColorMap _indexedColorMap;

    public XSSFCellFill(CTFill cTFill, IndexedColorMap indexedColorMap) {
        this._fill = cTFill;
        this._indexedColorMap = indexedColorMap;
    }

    private CTPatternFill ensureCTPatternFill() {
        CTPatternFill patternFill = this._fill.getPatternFill();
        return patternFill == null ? this._fill.addNewPatternFill() : patternFill;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof XSSFCellFill)) {
            return false;
        }
        XSSFCellFill xSSFCellFill = (XSSFCellFill) obj;
        return Objects.equals(getFillBackgroundColor(), xSSFCellFill.getFillBackgroundColor()) && Objects.equals(getFillForegroundColor(), xSSFCellFill.getFillForegroundColor()) && Objects.equals(getPatternType(), xSSFCellFill.getPatternType());
    }

    @Internal
    public CTFill getCTFill() {
        return this._fill;
    }

    public XSSFColor getFillBackgroundColor() {
        CTPatternFill patternFill = this._fill.getPatternFill();
        if (patternFill == null) {
            return null;
        }
        return XSSFColor.from(patternFill.getBgColor(), this._indexedColorMap);
    }

    public XSSFColor getFillForegroundColor() {
        CTPatternFill patternFill = this._fill.getPatternFill();
        if (patternFill == null) {
            return null;
        }
        return XSSFColor.from(patternFill.getFgColor(), this._indexedColorMap);
    }

    public STPatternType.Enum getPatternType() {
        CTPatternFill patternFill = this._fill.getPatternFill();
        if (patternFill == null) {
            return null;
        }
        return patternFill.getPatternType();
    }

    public int hashCode() {
        return this._fill.toString().hashCode();
    }

    public void setFillBackgroundColor(int i5) {
        CTPatternFill cTPatternFillEnsureCTPatternFill = ensureCTPatternFill();
        (cTPatternFillEnsureCTPatternFill.isSetBgColor() ? cTPatternFillEnsureCTPatternFill.getBgColor() : cTPatternFillEnsureCTPatternFill.addNewBgColor()).setIndexed(i5);
    }

    public void setFillForegroundColor(int i5) {
        CTPatternFill cTPatternFillEnsureCTPatternFill = ensureCTPatternFill();
        (cTPatternFillEnsureCTPatternFill.isSetFgColor() ? cTPatternFillEnsureCTPatternFill.getFgColor() : cTPatternFillEnsureCTPatternFill.addNewFgColor()).setIndexed(i5);
    }

    public void setPatternType(STPatternType.Enum r6) {
        ensureCTPatternFill().setPatternType(r6);
    }

    public XSSFCellFill() {
        this._fill = CTFill.Factory.newInstance();
    }

    public void setFillBackgroundColor(XSSFColor xSSFColor) {
        CTPatternFill cTPatternFillEnsureCTPatternFill = ensureCTPatternFill();
        if (xSSFColor == null) {
            cTPatternFillEnsureCTPatternFill.unsetBgColor();
        } else {
            cTPatternFillEnsureCTPatternFill.setBgColor(xSSFColor.getCTColor());
        }
    }

    public void setFillForegroundColor(XSSFColor xSSFColor) {
        CTPatternFill cTPatternFillEnsureCTPatternFill = ensureCTPatternFill();
        if (xSSFColor == null) {
            cTPatternFillEnsureCTPatternFill.unsetFgColor();
        } else {
            cTPatternFillEnsureCTPatternFill.setFgColor(xSSFColor.getCTColor());
        }
    }
}
