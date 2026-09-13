package org.apache.poi.ss.util;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class AreaReference {
    private static final char CELL_DELIMITER = ':';
    private static final SpreadsheetVersion DEFAULT_SPREADSHEET_VERSION = SpreadsheetVersion.EXCEL97;
    private static final char SHEET_NAME_DELIMITER = '!';
    private static final char SPECIAL_NAME_DELIMITER = '\'';
    private final CellReference _firstCell;
    private final boolean _isSingleCell;
    private final CellReference _lastCell;
    private final SpreadsheetVersion _version;

    public AreaReference(String str, SpreadsheetVersion spreadsheetVersion) {
        this._version = spreadsheetVersion == null ? DEFAULT_SPREADSHEET_VERSION : spreadsheetVersion;
        if (!isContiguous(str)) {
            throw new IllegalArgumentException("References passed to the AreaReference must be contiguous, use generateContiguous(ref) if you have non-contiguous references");
        }
        String[] strArrSeparateAreaRefs = separateAreaRefs(str);
        String str2 = strArrSeparateAreaRefs[0];
        if (strArrSeparateAreaRefs.length == 1) {
            CellReference cellReference = new CellReference(str2);
            this._firstCell = cellReference;
            this._lastCell = cellReference;
            this._isSingleCell = true;
            return;
        }
        if (strArrSeparateAreaRefs.length != 2) {
            throw new IllegalArgumentException(AbstractC0157z.o("Bad area ref '", str, "'"));
        }
        String str3 = strArrSeparateAreaRefs[1];
        if (!isPlainColumn(str2)) {
            this._firstCell = new CellReference(str2);
            this._lastCell = new CellReference(str3);
            this._isSingleCell = str2.equals(str3);
        } else {
            if (!isPlainColumn(str3)) {
                throw new RuntimeException(AbstractC0157z.o("Bad area ref '", str, "'"));
            }
            boolean zIsPartAbsolute = CellReference.isPartAbsolute(str2);
            boolean zIsPartAbsolute2 = CellReference.isPartAbsolute(str3);
            int iConvertColStringToIndex = CellReference.convertColStringToIndex(str2);
            int iConvertColStringToIndex2 = CellReference.convertColStringToIndex(str3);
            this._firstCell = new CellReference(0, iConvertColStringToIndex, true, zIsPartAbsolute);
            this._lastCell = new CellReference(65535, iConvertColStringToIndex2, true, zIsPartAbsolute2);
            this._isSingleCell = false;
        }
    }

    public static AreaReference[] generateContiguous(SpreadsheetVersion spreadsheetVersion, String str) {
        if (spreadsheetVersion == null) {
            spreadsheetVersion = DEFAULT_SPREADSHEET_VERSION;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : splitAreaReferences(str)) {
            arrayList.add(new AreaReference(str2, spreadsheetVersion));
        }
        return (AreaReference[]) arrayList.toArray(new AreaReference[0]);
    }

    public static AreaReference getWholeColumn(SpreadsheetVersion spreadsheetVersion, String str, String str2) {
        if (spreadsheetVersion == null) {
            spreadsheetVersion = DEFAULT_SPREADSHEET_VERSION;
        }
        return new AreaReference(str + "$1:" + str2 + "$" + spreadsheetVersion.getMaxRows(), spreadsheetVersion);
    }

    public static AreaReference getWholeRow(SpreadsheetVersion spreadsheetVersion, String str, String str2) {
        if (spreadsheetVersion == null) {
            spreadsheetVersion = DEFAULT_SPREADSHEET_VERSION;
        }
        StringBuilder sbY = AbstractC0157z.y("$A", str, ":$");
        sbY.append(spreadsheetVersion.getLastColumnName());
        sbY.append(str2);
        return new AreaReference(sbY.toString(), spreadsheetVersion);
    }

    public static boolean isContiguous(String str) {
        return splitAreaReferences(str).length == 1;
    }

    private static boolean isPlainColumn(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char cCharAt = str.charAt(length);
            if (!(cCharAt == '$' && length == 0) && (cCharAt < 'A' || cCharAt > 'Z')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isWholeColumnReference(SpreadsheetVersion spreadsheetVersion, CellReference cellReference, CellReference cellReference2) {
        if (spreadsheetVersion == null) {
            spreadsheetVersion = DEFAULT_SPREADSHEET_VERSION;
        }
        return cellReference.getRow() == 0 && cellReference.isRowAbsolute() && cellReference2.getRow() == spreadsheetVersion.getLastRowIndex() && cellReference2.isRowAbsolute();
    }

    private static String[] separateAreaRefs(String str) {
        int length = str.length();
        int i5 = -1;
        int i6 = 0;
        boolean z6 = false;
        while (i6 < length) {
            char cCharAt = str.charAt(i6);
            if (cCharAt != '\'') {
                if (cCharAt == ':' && !z6) {
                    if (i5 >= 0) {
                        throw new IllegalArgumentException(AbstractC0157z.o("More than one cell delimiter ':' appears in area reference '", str, "'"));
                    }
                    i5 = i6;
                }
            } else if (!z6) {
                z6 = true;
            } else {
                if (i6 >= length - 1) {
                    throw new IllegalArgumentException(AbstractC0157z.o("Area reference '", str, "' ends with special name delimiter '''"));
                }
                int i7 = i6 + 1;
                if (str.charAt(i7) == '\'') {
                    i6 = i7;
                } else {
                    z6 = false;
                }
            }
            i6++;
        }
        if (i5 < 0) {
            return new String[]{str};
        }
        String strSubstring = str.substring(0, i5);
        String strSubstring2 = str.substring(i5 + 1);
        if (strSubstring2.indexOf(33) >= 0) {
            throw new RuntimeException(AbstractC0157z.o("Unexpected ! in second cell reference of '", str, "'"));
        }
        int iLastIndexOf = strSubstring.lastIndexOf(33);
        return iLastIndexOf < 0 ? new String[]{strSubstring, strSubstring2} : new String[]{strSubstring, androidx.collection.a.n(strSubstring.substring(0, iLastIndexOf + 1), strSubstring2)};
    }

    private static String[] splitAreaReferences(String str) {
        String string;
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        loop0: while (true) {
            string = "";
            while (stringTokenizer.hasMoreTokens()) {
                if (string.length() > 0) {
                    string = string.concat(",");
                }
                StringBuilder sbR = androidx.collection.a.r(string);
                sbR.append(stringTokenizer.nextToken());
                string = sbR.toString();
                int iCountMatches = StringUtil.countMatches(string, '\'');
                if (iCountMatches == 0 || iCountMatches == 2) {
                    arrayList.add(string);
                }
            }
            break loop0;
        }
        if (string.length() > 0) {
            arrayList.add(string);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String formatAsString() {
        if (isWholeColumnReference()) {
            return CellReference.convertNumToColString(this._firstCell.getCol()) + ParameterizedMessage.ERROR_MSG_SEPARATOR + CellReference.convertNumToColString(this._lastCell.getCol());
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append(this._firstCell.formatAsString());
        if (!this._isSingleCell) {
            sb.append(':');
            if (this._lastCell.getSheetName() == null) {
                sb.append(this._lastCell.formatAsString());
            } else {
                this._lastCell.appendCellReference(sb);
            }
        }
        return sb.toString();
    }

    public CellReference[] getAllReferencedCells() {
        if (this._isSingleCell) {
            return new CellReference[]{this._firstCell};
        }
        int iMin = Math.min(this._firstCell.getRow(), this._lastCell.getRow());
        int iMax = Math.max(this._firstCell.getRow(), this._lastCell.getRow());
        int iMin2 = Math.min((int) this._firstCell.getCol(), (int) this._lastCell.getCol());
        int iMax2 = Math.max((int) this._firstCell.getCol(), (int) this._lastCell.getCol());
        String sheetName = this._firstCell.getSheetName();
        ArrayList arrayList = new ArrayList();
        for (int i5 = iMin; i5 <= iMax; i5++) {
            for (int i6 = iMin2; i6 <= iMax2; i6++) {
                arrayList.add(new CellReference(sheetName, i5, i6, this._firstCell.isRowAbsolute(), this._firstCell.isColAbsolute()));
            }
        }
        return (CellReference[]) arrayList.toArray(new CellReference[0]);
    }

    public CellReference getFirstCell() {
        return this._firstCell;
    }

    public CellReference getLastCell() {
        return this._lastCell;
    }

    public boolean isSingleCell() {
        return this._isSingleCell;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName());
        sb.append(" [");
        try {
            sb.append(formatAsString());
        } catch (Exception e) {
            sb.append(e);
        }
        sb.append(']');
        return sb.toString();
    }

    public boolean isWholeColumnReference() {
        return isWholeColumnReference(this._version, this._firstCell, this._lastCell);
    }

    public AreaReference(CellReference cellReference, CellReference cellReference2, SpreadsheetVersion spreadsheetVersion) {
        int row;
        boolean zIsRowAbsolute;
        int row2;
        boolean zIsRowAbsolute2;
        String sheetName;
        short col;
        String sheetName2;
        short col2;
        boolean z6;
        boolean zIsColAbsolute;
        this._version = spreadsheetVersion != null ? spreadsheetVersion : DEFAULT_SPREADSHEET_VERSION;
        boolean z7 = cellReference.getRow() > cellReference2.getRow();
        boolean z8 = cellReference.getCol() > cellReference2.getCol();
        if (!z7 && !z8) {
            this._firstCell = cellReference;
            this._lastCell = cellReference2;
        } else {
            if (z7) {
                row = cellReference2.getRow();
                zIsRowAbsolute = cellReference2.isRowAbsolute();
                row2 = cellReference.getRow();
                zIsRowAbsolute2 = cellReference.isRowAbsolute();
            } else {
                row = cellReference.getRow();
                zIsRowAbsolute = cellReference.isRowAbsolute();
                row2 = cellReference2.getRow();
                zIsRowAbsolute2 = cellReference2.isRowAbsolute();
            }
            int i5 = row;
            boolean z9 = zIsRowAbsolute;
            if (z8) {
                sheetName = cellReference2.getSheetName();
                col = cellReference2.getCol();
                boolean zIsColAbsolute2 = cellReference2.isColAbsolute();
                sheetName2 = cellReference.getSheetName();
                col2 = cellReference.getCol();
                zIsColAbsolute = cellReference.isColAbsolute();
                z6 = zIsColAbsolute2;
            } else {
                sheetName = cellReference.getSheetName();
                col = cellReference.getCol();
                boolean zIsColAbsolute3 = cellReference.isColAbsolute();
                sheetName2 = cellReference2.getSheetName();
                col2 = cellReference2.getCol();
                z6 = zIsColAbsolute3;
                zIsColAbsolute = cellReference2.isColAbsolute();
            }
            String str = sheetName;
            boolean z10 = zIsRowAbsolute2;
            short s6 = col2;
            this._firstCell = new CellReference(str, i5, col, z9, z6);
            this._lastCell = new CellReference(sheetName2, row2, s6, z10, zIsColAbsolute);
        }
        this._isSingleCell = false;
    }
}
