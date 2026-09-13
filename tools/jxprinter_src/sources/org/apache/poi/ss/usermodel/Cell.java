package org.apache.poi.ss.usermodel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Cell {
    CellAddress getAddress();

    CellRangeAddress getArrayFormulaRange();

    boolean getBooleanCellValue();

    CellType getCachedFormulaResultType();

    Comment getCellComment();

    String getCellFormula();

    CellStyle getCellStyle();

    CellType getCellType();

    int getColumnIndex();

    Date getDateCellValue();

    byte getErrorCellValue();

    Hyperlink getHyperlink();

    LocalDateTime getLocalDateTimeCellValue();

    double getNumericCellValue();

    RichTextString getRichStringCellValue();

    Row getRow();

    int getRowIndex();

    Sheet getSheet();

    String getStringCellValue();

    boolean isPartOfArrayFormulaGroup();

    void removeCellComment();

    void removeFormula();

    void removeHyperlink();

    void setAsActiveCell();

    void setBlank();

    void setCellComment(Comment comment);

    void setCellErrorValue(byte b);

    void setCellFormula(String str);

    void setCellStyle(CellStyle cellStyle);

    @Removal(version = "5.0")
    @Deprecated
    void setCellType(CellType cellType);

    void setCellValue(double d);

    void setCellValue(String str);

    default void setCellValue(LocalDate localDate) {
        setCellValue(localDate == null ? null : localDate.atStartOfDay());
    }

    void setCellValue(LocalDateTime localDateTime);

    void setCellValue(Calendar calendar);

    void setCellValue(Date date);

    void setCellValue(RichTextString richTextString);

    void setCellValue(boolean z6);

    void setHyperlink(Hyperlink hyperlink);
}
