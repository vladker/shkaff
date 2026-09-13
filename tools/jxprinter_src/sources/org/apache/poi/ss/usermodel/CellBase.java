package org.apache.poi.ss.usermodel;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CellBase implements Cell {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private void checkLength(String str) {
        if (str.length() <= getSpreadsheetVersion().getMaxTextLength()) {
            return;
        }
        Locale locale = Locale.ROOT;
        throw new IllegalArgumentException(androidx.collection.a.i(getSpreadsheetVersion().getMaxTextLength(), "The maximum length of cell contents (text) is ", " characters"));
    }

    private void tryToDeleteArrayFormulaIfSet() {
        if (isPartOfArrayFormulaGroup()) {
            tryToDeleteArrayFormula(null);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public CellAddress getAddress() {
        return new CellAddress(this);
    }

    public abstract SpreadsheetVersion getSpreadsheetVersion();

    public final CellType getValueType() {
        CellType cellType = getCellType();
        return cellType != CellType.FORMULA ? cellType : getCachedFormulaResultType();
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public final void removeFormula() {
        if (getCellType() == CellType.BLANK) {
            return;
        }
        if (isPartOfArrayFormulaGroup()) {
            tryToDeleteArrayFormula(null);
        } else {
            removeFormulaImpl();
        }
    }

    public abstract void removeFormulaImpl();

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setBlank() {
        setCellType(CellType.BLANK);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public final void setCellFormula(String str) {
        tryToDeleteArrayFormulaIfSet();
        if (str == null) {
            removeFormula();
        } else {
            setCellFormulaImpl(str);
        }
    }

    public abstract void setCellFormulaImpl(String str);

    @Override // org.apache.poi.ss.usermodel.Cell
    public final void setCellType(CellType cellType) {
        if (cellType == null || cellType == CellType._NONE) {
            throw new IllegalArgumentException("cellType shall not be null nor _NONE");
        }
        CellType cellType2 = CellType.FORMULA;
        if (cellType == cellType2) {
            if (getCellType() != cellType2) {
                throw new IllegalArgumentException("Calling Cell.setCellType(CellType.FORMULA) is illegal. Use setCellFormula(String) directly.");
            }
        } else {
            tryToDeleteArrayFormulaIfSet();
            setCellTypeImpl(cellType);
        }
    }

    public abstract void setCellTypeImpl(CellType cellType);

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(double d) {
        if (Double.isInfinite(d)) {
            setCellErrorValue(FormulaError.DIV0.getCode());
        } else if (Double.isNaN(d)) {
            setCellErrorValue(FormulaError.NUM.getCode());
        } else {
            setCellValueImpl(d);
        }
    }

    public abstract void setCellValueImpl(double d);

    public abstract void setCellValueImpl(String str);

    public abstract void setCellValueImpl(LocalDateTime localDateTime);

    public abstract void setCellValueImpl(Calendar calendar);

    public abstract void setCellValueImpl(Date date);

    public abstract void setCellValueImpl(RichTextString richTextString);

    public final void tryToDeleteArrayFormula(String str) {
        if (getArrayFormulaRange().getNumberOfCells() <= 1) {
            getRow().getSheet().removeArrayFormula(this);
            return;
        }
        if (str == null) {
            str = "Cell " + new CellReference(this).formatAsString() + " is part of a multi-cell array formula. You cannot change part of an array.";
        }
        throw new IllegalStateException(str);
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(Date date) {
        if (date == null) {
            setBlank();
        } else {
            setCellValueImpl(date);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            setBlank();
        } else {
            setCellValueImpl(localDateTime);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(Calendar calendar) {
        if (calendar == null) {
            setBlank();
        } else {
            setCellValueImpl(calendar);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(String str) {
        if (str == null) {
            setBlank();
        } else {
            checkLength(str);
            setCellValueImpl(str);
        }
    }

    @Override // org.apache.poi.ss.usermodel.Cell
    public void setCellValue(RichTextString richTextString) {
        if (richTextString != null && richTextString.getString() != null) {
            checkLength(richTextString.getString());
            setCellValueImpl(richTextString);
        } else {
            setBlank();
        }
    }
}
