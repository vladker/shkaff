package org.apache.poi.ss.usermodel;

import java.io.Closeable;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.util.Removal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Workbook extends Closeable, Iterable<Sheet> {
    public static final int MAX_SENSITIVE_SHEET_NAME_LEN = 31;
    public static final int PICTURE_TYPE_DIB = 7;
    public static final int PICTURE_TYPE_EMF = 2;
    public static final int PICTURE_TYPE_JPEG = 5;
    public static final int PICTURE_TYPE_PICT = 4;
    public static final int PICTURE_TYPE_PNG = 6;
    public static final int PICTURE_TYPE_WMF = 3;

    int addOlePackage(byte[] bArr, String str, String str2, String str3);

    int addPicture(byte[] bArr, int i5);

    void addToolPack(UDFFinder uDFFinder);

    Sheet cloneSheet(int i5);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    CellStyle createCellStyle();

    DataFormat createDataFormat();

    EvaluationWorkbook createEvaluationWorkbook();

    Font createFont();

    Name createName();

    Sheet createSheet();

    Sheet createSheet(String str);

    Font findFont(boolean z6, short s6, short s7, String str, boolean z7, boolean z8, short s8, byte b);

    int getActiveSheetIndex();

    List<? extends Name> getAllNames();

    List<? extends PictureData> getAllPictures();

    CellReferenceType getCellReferenceType();

    CellStyle getCellStyleAt(int i5);

    CreationHelper getCreationHelper();

    int getFirstVisibleTab();

    Font getFontAt(int i5);

    boolean getForceFormulaRecalculation();

    Row.MissingCellPolicy getMissingCellPolicy();

    Name getName(String str);

    List<? extends Name> getNames(String str);

    int getNumCellStyles();

    int getNumberOfFonts();

    @Removal(version = "6.0.0")
    @Deprecated
    int getNumberOfFontsAsInt();

    int getNumberOfNames();

    int getNumberOfSheets();

    String getPrintArea(int i5);

    Sheet getSheet(String str);

    Sheet getSheetAt(int i5);

    int getSheetIndex(String str);

    int getSheetIndex(Sheet sheet);

    String getSheetName(int i5);

    SheetVisibility getSheetVisibility(int i5);

    SpreadsheetVersion getSpreadsheetVersion();

    boolean isHidden();

    boolean isSheetHidden(int i5);

    boolean isSheetVeryHidden(int i5);

    @Override // java.lang.Iterable
    default Iterator<Sheet> iterator() {
        return sheetIterator();
    }

    int linkExternalWorkbook(String str, Workbook workbook);

    void removeName(Name name);

    void removePrintArea(int i5);

    void removeSheetAt(int i5);

    void setActiveSheet(int i5);

    void setCellReferenceType(CellReferenceType cellReferenceType);

    void setFirstVisibleTab(int i5);

    void setForceFormulaRecalculation(boolean z6);

    void setHidden(boolean z6);

    void setMissingCellPolicy(Row.MissingCellPolicy missingCellPolicy);

    void setPrintArea(int i5, int i6, int i7, int i8, int i9);

    void setPrintArea(int i5, String str);

    void setSelectedTab(int i5);

    void setSheetHidden(int i5, boolean z6);

    void setSheetName(int i5, String str);

    void setSheetOrder(String str, int i5);

    void setSheetVisibility(int i5, SheetVisibility sheetVisibility);

    Iterator<Sheet> sheetIterator();

    @Override // java.lang.Iterable
    default Spliterator<Sheet> spliterator() {
        return Spliterators.spliterator(sheetIterator(), getNumberOfSheets(), 0);
    }

    void write(OutputStream outputStream);
}
